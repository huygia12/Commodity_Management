package Controllers;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Order {
    private final List<Goods> curOrder = new ArrayList<>();
    private String orderID;
    private int cusMoney;
    private int discount;
    private List<Goods> myGoodsList = new ArrayList<>();
    private List<Goods> draftGoodsList = new ArrayList<>();
    Scanner sc = new Scanner(System.in);
    UsefulFunctions uf = new UsefulFunctions();
    String invoiceDate = LocalDateTime.now().format(DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss"));

    public Order() {
    }

    public Order(List<Goods> myGoodsList, String orderID) {
        this.myGoodsList = myGoodsList;
        this.orderID = orderID;
    }

    public void setDiscount(int discount) {
        this.discount = discount;
    }

    public int getDiscount() {
        return this.discount;
    }

    public void setOrderID(String orderID) {
        this.orderID = orderID;
    }

    public String getOrderID() {
        return this.orderID;
    }

    public int getCustomerMoney() {
        return cusMoney;
    }

    public void setCustomerMoney(int customerMoney) {
        this.cusMoney = customerMoney;
    }

    private int totalPayment() {
        int totalPayment = 0;
        for (int i = 0; i < curOrder.size(); i++) {
            Goods goods = curOrder.get(i);
            totalPayment += goods.getListPrice() * goods.getTotalQuantity();
        }
        return totalPayment;
    }

    private int totalAfterDiscount() {
        int totalPayment = this.totalPayment();
        int totalAfterDiscount = totalPayment - (totalPayment * this.discount / 100);
        return totalAfterDiscount;
    }

    public void orderMenu() {
        System.out.println("");
        System.out.println("--------------------------");
        System.out.println("|    MAKE A NEW ORDER    |");
        System.out.println("--------------------------");
        System.out.println("| 1. Add to order        |");
        System.out.println("| 2. Edit Current Order  |");
        System.out.println("| 3. Pay                 |");
        System.out.println("| 4. Back                |");
        System.out.println("--------------------------");
        System.out.print("Option=> ");
    }

    private void editOrderMenu() {
        System.out.println("");
        System.out.println("------------------------------");
        System.out.println("|      CHOOSE FUNCTION       |");
        System.out.println("------------------------------");
        System.out.println("| 1. Incerase Quantity       |");
        System.out.println("| 2. Decrease Quantity       |");
        System.out.println("| 3. Delete from order       |");
        System.out.println("| 4. Back                    |");
        System.out.println("------------------------------");
        System.out.print("Option=> ");
    }

    //Function 1
    private void addToOrder() {
        Shipment orderShipment = new Shipment();
        Goods searchGoods = uf.searchGoods(draftGoodsList);
        // Search for goods and shipment want to buy
        if (searchGoods == null) {
            return;
        }
        Shipment searchShipment = uf.searchShipments(searchGoods);
        if (searchShipment == null) {
            return;
        }
        if (searchShipment.getQuantity() == 0) {
            uf.checkIfNotEnouQuan(1, 0);
            return;
        }
        // Type in the quantity of searchGoods want to buy
        while (true) {
            int nextProcess = uf.typeInQuan(orderShipment);
            if (nextProcess == -1 || nextProcess == 0) {
                return;
            } else if (uf.checkIfNotEnouQuan(orderShipment.getQuantity(),
                    searchShipment.getQuantity())) {
                orderShipment.setQuantity(0);
            } else if (uf.checkIfNumIsZero(orderShipment.getQuantity())) {
                orderShipment.setQuantity(0);
            } else {
                break;
            }
        }
        int inputQuantity = orderShipment.getQuantity();
        // Check if order already had this goods or not
        Goods existedOrderGoods = uf.containGoods(searchGoods.getGoodsID(), curOrder);
        orderShipment = searchShipment.cloneShipment();
        orderShipment.setQuantity(inputQuantity);
        if (existedOrderGoods == null) {
            // if not, add new Goods and it'sShipment to currentOrder
            Goods orderGoods = searchGoods.cloneGoods();
            orderGoods.getShipments().clear();
            orderGoods.getShipments().add(orderShipment);
            curOrder.add(orderGoods);
        } else {
            Shipment existedOrderShipment = existedOrderGoods
                    .containShipment(orderShipment.getShipmentID());
            if (existedOrderShipment != null) {
                // if Shipment already exist, gain shipment's quantity
                existedOrderShipment
                        .setQuantity(existedOrderShipment.getQuantity()
                                + orderShipment.getQuantity());
            } else {
                // if not, add new Shipment to order 
                existedOrderGoods.getShipments().add(orderShipment);
            }
        }
        // after add a goods to order, decrease quantity of that goods in draftGoodsList
        int quantityBefore = searchShipment.getQuantity();
        searchShipment.setQuantity(quantityBefore - inputQuantity);
        showDraftOrder(curOrder);
    }

    //Function 2
    private void editOrder() {
        String choice;
        // Make a draftOrder of the curOrder to work in, after finish the edit, change the curOrder
        List<Goods> draftOrder = curOrder.stream()
                .map(x -> x.cloneGoods())
                .collect(Collectors.toList());
        // Search for goods and shipment want to edit
        Goods searchOrderGoods = uf.searchGoods(curOrder);
        if (searchOrderGoods == null) {
            return;
        }
        Shipment searchOrderShipment = uf.searchShipments(searchOrderGoods);
        if (searchOrderShipment == null) {
            return;
        }
        Shipment editShipment = uf.containGoods(searchOrderGoods.getGoodsID(), draftOrder)
                .containShipment(searchOrderShipment.getShipmentID());
        // take the rest quantity of searchShipment in repository goodsList
        int remainQuan = uf.containGoods(searchOrderGoods.getGoodsID(), draftGoodsList)
                .containShipment(searchOrderShipment.getShipmentID())
                .getQuantity();
        do {
            editOrderMenu();
            choice = sc.nextLine();
            switch (choice) {
                case "1":
                    remainQuan -= IncreaseQuantity(editShipment, remainQuan);
                    showDraftOrder(draftOrder);
                    break;
                case "2":
                    remainQuan += DecreaseQuantity(editShipment);
                    showDraftOrder(draftOrder);
                    break;
                case "3":
                    deleteFromOrder(searchOrderGoods, searchOrderShipment);
                    showDraftOrder(curOrder);
                    return;
                case "4":
                    if (editShipment.getQuantity() == 0) {
                        System.out.println(
                                "Your changes make quantity become 0 and will be automatically removed from order!");
                        deleteFromOrder(searchOrderGoods, searchOrderShipment);
                    } else {
                        // set quantity in curOrder after finish edit
                        searchOrderShipment.setQuantity(editShipment.getQuantity());
                        // reset quantity in the draftGoodsList after finish edit
                        uf.containGoods(searchOrderGoods.getGoodsID(), draftGoodsList)
                                .containShipment(searchOrderShipment.getShipmentID())
                                .setQuantity(remainQuan);
                        System.out.println("Edit succeed !");
                    }
                    return;
                default:
                    System.out.println("Wrong input! Please type form 1->4!");
                    break;
            }
        } while (!choice.equals("4"));
    }

    //Function 2.1
    private int IncreaseQuantity(Shipment cloneShipment, int remainQuan) {
        if (remainQuan == 0) {
            System.out.println("Can not increase quantity!");
            return -1;
        }
        int quanBefore = cloneShipment.getQuantity();
        while (true) {
            int nextProcess = uf.typeInQuan(cloneShipment);
            int quanIncrease = cloneShipment.getQuantity();
            if (nextProcess == -1 || nextProcess == 0) {
                return -1;
            } else if (uf.checkIfNotEnouQuan(quanIncrease, remainQuan)) {
                cloneShipment.setQuantity(0);
            } else {
                cloneShipment.setQuantity(quanBefore + quanIncrease);
                return quanIncrease;
            }
        }
    }

    //Function 2.2
    private int DecreaseQuantity(Shipment cloneShipment) {
        if (cloneShipment.getQuantity() == 0) {
            System.out.println("Can not decrease Quantity!");
            return -1;
        }
        int quanBefore = cloneShipment.getQuantity();
        int nextProcess = uf.typeInQuan(cloneShipment);
        int quanDecrease = cloneShipment.getQuantity();
        if (nextProcess == -1 || nextProcess == 0) {
            return -1;
        } else if (quanDecrease >= quanBefore) {
            cloneShipment.setQuantity(0);
            return quanBefore;
        } else {
            cloneShipment.setQuantity(quanBefore - quanDecrease);
            return quanDecrease;
        }
    }

    //Function 2.3
    private void deleteFromOrder(Goods orderGoods, Shipment orderShipment) {
        orderGoods.getShipments().remove(orderShipment);
        if (orderGoods.getShipments().isEmpty()) {
            this.curOrder.remove(orderGoods);
        }
        System.out.println("Deleted succeed !");
        // return the origin quantity after delete shipment
        int originQuan = uf.containGoods(orderGoods.getGoodsID(), this.myGoodsList)
                .containShipment(orderShipment.getShipmentID())
                .getQuantity();
        uf.containGoods(orderGoods.getGoodsID(), this.draftGoodsList)
                .containShipment(orderShipment.getShipmentID())
                .setQuantity(originQuan);
    }

    private int typeInDcountPctage() {
        while (true) {
            System.out.print("Please enter the discount percentage (must be a positive number), or type BACK to go back: ");
            String input = sc.nextLine();
            if (uf.backCase(input)) {
                return -1;
            } else if (uf.exitCase(input)) {
                return 0;
            } else if (uf.checkIfNoInput(input)) {
            } else {
                try {
                    this.discount = Math.min(100, Integer.parseInt(input));
                    if (uf.checkIfNumPositive(this.discount)) {
                        return 1;
                    } else {
                        this.discount = 0;
                    }
                } catch (NumberFormatException nfe) {
                    System.out.println("Invalid input! Please try again.");
                }
            }
        }
    }

    private int typeInGivenMoney() {
        while (true) {
            System.out.print("Please enter the amount of money customer give, or type EXIT/BACK to exit/back from payment : ");
            String input = sc.nextLine();
            if (uf.backCase(input)) {
                return -1;
            } else if (uf.exitCase(input)) {
                return 0;
            } else if (uf.checkIfNoInput(input)) {
            } else {
                try {
                    this.cusMoney = Integer.parseInt(input);
                    if (!uf.checkIfNumPositive(this.cusMoney)) {
                        this.cusMoney = 0;
                    } else if (this.cusMoney < this.totalAfterDiscount()) {
                        this.cusMoney = 0;
                        System.out.println("Insufficient payment! Please pay more.");
                    } else {
                        return 1;
                    }
                } catch (NumberFormatException nfe) {
                    uf.wrInput();
                }
            }
        }
    }

    //Function 3
    private void payOrder() {
        if (uf.checkIfListEmpty(this.curOrder)) {
            return;
        }
        int n = 1;
        int nextProcess;
        while (n != 3) {
            if (n == 1) {
                nextProcess = typeInDcountPctage();
                if (nextProcess == 0 || nextProcess == -1) {
                    return;
                }
                n++;
            }
            if (n == 2) {
                nextProcess = typeInGivenMoney();
                if (nextProcess == 0) {
                    return;
                } else if (nextProcess == -1) {
                    n = 1;
                    continue;
                }
            }
            // make a payment and show bill
            int totalPayment = this.totalPayment();
            int totalAfterDis = this.totalAfterDiscount();
            int change = this.cusMoney - totalAfterDis;
            showBill(totalPayment, totalAfterDis, change);
            // update myGoodsList after payment completed
            n = 3;
        }
    }

    private void showDraftOrder(List<Goods> draftOrder) {
        System.out.println("");
        System.out.println("-------------------------- YOUR ORDER ------------------------------");
        System.out.println("--------------------------------------------------------------------");
        System.out.format("%-25s %-10s %-15s %-15s\n", "Name", "Quantity", "Price", "Total");
        System.out.format("%-25s %-10s %-15s %-15s\n", "-------------------------", "----------", "---------------", "---------------");
        for (int i = 0; i < draftOrder.size(); i++) {
            Goods goods = draftOrder.get(i);
            long totalQuantity = goods.getTotalQuantity();
            long price = goods.getListPrice();
            long totalPrice = totalQuantity * price;
            System.out.format("%-25s %-10d %-15d %-15d\n", goods.getGoodsName(), totalQuantity, price, totalPrice);
        }
        int totalPayment = totalPayment();
        System.out.println(" ");
        System.out.println("Total payment: " + totalPayment);
        System.out.println("--------------------------------------------------------------------");
    }

    private void showBill(int totalPayment, int totalAfterDiscount, int change) {
        System.out.println("");
        System.out.println("-------------- YOUR BILL ---------------");
        System.out.println("----------------------");
        System.out.println("Date: " + this.invoiceDate);
        System.out.println("");
        System.out.format("%-25s %-10s %-15s %-15s\n", "Name", "Quantity", "Price", "Total");
        System.out.format("%-25s %-10s %-15s %-15s\n", "-------------------------", "----------", "---------------", "---------------");
        for (int i = 0; i < this.curOrder.size(); i++) {
            Goods goods = this.curOrder.get(i);
            long totalQuantity = goods.getTotalQuantity();
            long price = goods.getListPrice();
            long totalPrice = totalQuantity * price;
            System.out.format("%-25s %-10d %-15d %-15d\n", goods.getGoodsName(), totalQuantity, price, totalPrice);
        }
        System.out.println("Total payment: " + totalPayment);
        System.out.println("Discount: " + this.discount + "%");
        System.out.println("Total after discount: " + totalAfterDiscount);
        System.out.println("Customer payment: " + this.cusMoney);
        System.out.println("Change: " + change);
        System.out.println("----------------------------------------");
    }

    public List<Goods> makeNewOrder() {
        // make a copy of myGoodsList and take all the valid expiration date of Goods
        draftGoodsList = myGoodsList.stream()
                .map(x -> x.cloneGoods())
                .collect(Collectors.toList());
        for (Goods draftGoods : draftGoodsList) {
            draftGoods.setShipment(draftGoods.getShipments()
                    .stream()
                    .filter(x->x.getHsd().isAfter(uf.CURRENT_DATE))
                    .collect(Collectors.toList()));
        }
        
        int choice;
        do {
            try {
                orderMenu();
                choice = sc.nextInt();
                sc.nextLine();
                switch (choice) {
                    case 1:
                        addToOrder();
                        break;
                    case 2:
                        editOrder();
                        break;
                    case 3:
                        payOrder();
                        return curOrder;
                    case 4:
                        break;
                    default:
                        System.out.println("Wrong input! Please type form 1->4!");
                        break;
                }
            } catch (InputMismatchException ime) {
                System.out.println("Wrong input!");
                choice = -1;
                sc.next();
            }
        } while (choice != 4);
        return null;
    }
}
