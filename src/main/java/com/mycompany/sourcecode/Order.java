package com.mycompany.sourcecode;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class Order {

    private String orderID;
    private int customerMoney;
    private int discount;
    private List<Goods> draftOrder = new ArrayList<>();
    Scanner sc = new Scanner(System.in);
    List<Goods> myGoodsList = new ArrayList<>();
    UsefulFunctions uf = new UsefulFunctions();
    String invoiceDate = LocalDateTime.now().format(DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss"));

    public Order() {
    }

    public Order(List<Goods> myGoodsList) {
        this.myGoodsList = myGoodsList;
    }

    public void setDiscount(int discount) {
        this.discount = discount;
    }

    public int getDiscount() {
        return this.discount;
    }

    public String getOrderID() {
        return this.orderID;
    }

    public int getCustomerMoney() {
        return customerMoney;
    }

    public void setCustomerMoney(int customerMoney) {
        this.customerMoney = customerMoney;
    }

    private int totalPayment() {
        int totalPayment = 0;
        for (int i = 0; i < draftOrder.size(); i++) {
            Goods goods = draftOrder.get(i);
            totalPayment += goods.getListPrice() * goods.getTotalQuantity();
        }
        return totalPayment;
    }

    private int totalAfterDiscount(int totalPayment) {
        int totalAfterDiscount = totalPayment - (totalPayment * discount / 100);
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

    private Goods checkExistingOrderGoods(Goods searchGoods) {
        for (Goods goods : draftOrder) {

            if (goods.getGoodsID().equals(searchGoods.getGoodsID())) {
                return goods;
            }
        }
        return null;
    }

    private boolean checkExistingOrderShipment(Goods searchGoods, Shipment searchShipment) {
        Goods existingGoodsInOrder = checkExistingOrderGoods(searchGoods);
        if (existingGoodsInOrder != null) {
            for (Shipment shipment : existingGoodsInOrder.getShipments()) {
                if (shipment.getShipmentID().equals(searchShipment.getShipmentID())) {
                    return true;
                }
            }
        }
        return false;
    }

    //Function 1
    private void addToOrder() {
        Goods orderGoods = new Goods();
        Shipment orderShipment = new Shipment();

        Goods searchGoods = uf.searchGoods(myGoodsList);
        String input;
        if (searchGoods == null) {
            return;
        }
        Shipment searchShipment = uf.searchShipments(searchGoods);
        if (searchShipment == null) {
            return;
        }
        boolean checkExistingOrderShipment = checkExistingOrderShipment(searchGoods, searchShipment);
        if (checkExistingOrderShipment) {
            System.out.println("This product shipment has been already exist");
            return;
        }
        while (true) {
            System.out.print("Input product quantity or type BACK to get back: ");
            input = sc.nextLine();
            if (input.equalsIgnoreCase("back")) {
                break;
            } else {
                try {
                    int quantity = Integer.parseInt(input);
                    if (quantity < 0) {
                        System.out.println(
                                "Product quantity must be a positive number !");
                        continue;
                    } else if (quantity > searchShipment.getQuantity()) {
                        System.out.println(
                                "Warning: Does not have enough required quantity !");
                        continue;
                    } else if (quantity == 0) {
                        break;
                    }
                    Goods existingGoodsInOrder = checkExistingOrderGoods(searchGoods);
                    orderShipment.setImportPrice(searchShipment.getImportPrice());
                    orderShipment.setNsx(searchShipment.getNsx());
                    orderShipment.setHsd(searchShipment.getHsd());
                    orderShipment.setShipmentID(searchShipment.getShipmentID());
                    orderShipment.setQuantity(quantity);
                    if (existingGoodsInOrder == null) {
                        orderGoods.setGoodsID(searchGoods.getGoodsID());
                        orderGoods.setGoodsName(searchGoods.getGoodsName());
                        orderGoods.setListPrice(searchGoods.getListPrice());
                        orderGoods.setProvider(searchGoods.getProvider());
                        draftOrder.add(orderGoods);
                        orderGoods.getShipments().add(orderShipment);
                    } else {
                        existingGoodsInOrder.getShipments().add(orderShipment);
                    }
                    showDraftOrder(draftOrder);
                    break;
                } catch (NumberFormatException ne) {
                    if ("".equals(input)) {
                        System.out.println("Input is required!");
                    } else {
                        System.out.println("Wrong input!");
                    }
                }
            }
        }
    }
    
    //Function 2
    private void editOrder() {
        int choice;
        if (draftOrder.isEmpty()) {
            System.out.println("You haven't add any product !");
            return;
        } else {
            uf.showGoodsList(draftOrder);
        }
        Goods searchOrderGoods = uf.searchGoods(draftOrder);
        if (searchOrderGoods == null) {
            return;
        }
        Shipment searchOrderShipment = uf.searchShipments(searchOrderGoods);
        if (searchOrderShipment == null) {
            return;
        }

        Shipment temp = new Shipment(searchOrderShipment.getQuantity(), searchOrderShipment.getImportPrice(),
                searchOrderShipment.getNsx(), searchOrderShipment.getHsd());

        int tempQuantity = 0;
        for (Goods goods : myGoodsList) {
            if (goods.getGoodsID().equals(searchOrderGoods.getGoodsID())) {
                for (Shipment Shipment1 : goods.getShipments()) {
                    if (Shipment1.getShipmentID().equals(searchOrderShipment.getShipmentID())) {
                        tempQuantity = Shipment1.getQuantity();
                    }
                }
            }
        }
        do {
            try {
                editOrderMenu();
                choice = sc.nextInt();
                sc.nextLine();
                switch (choice) {
                    case 1:
                        IncreaseQuantity(temp, tempQuantity);
                        break;
                    case 2:
                        DecreaseQuantity(searchOrderGoods, temp);
                        break;
                    case 3:
                        deleteFromOrder(searchOrderGoods, searchOrderShipment);
                        showDraftOrder(draftOrder);
                        return;
                    case 4:
                        searchOrderShipment.setQuantity(temp.getQuantity());
                        System.out.println("Editted succeed !");
                        showDraftOrder(draftOrder);
                        return;
                    default:
                        System.out.println("Wrong input! Please type form 1->4!");
                        break;
                }
            } catch (InputMismatchException ime) {
                System.out.println("Wrong input!");
                choice = -1;
            }
        } while (choice != 4);
    }
    
    //Function 2.1
    private void IncreaseQuantity(Shipment tmp, int shipmentQuantity) {
        if (tmp.getQuantity() == shipmentQuantity) {
            System.out.println("Can not increase quantity");
            return;
        }
        String input;
        int value = 1;
        while (true) {
            System.out.print("Enter the quantity you want to increase or type BACK to get back: ");
            input = sc.nextLine();
            if (input.equalsIgnoreCase("back")) {
                return;
            } else {
                try {
                    value = Integer.parseInt(input);
                    if (value <= 0) {
                        System.out.println(
                                "Product quantity must be a positive number !");
                        continue;
                    } else if ((tmp.getQuantity() + value) > shipmentQuantity) {
                        System.out.println(
                                "Warning: Does not have enough required quantity !");
                        continue;
                    }
                    int quantity = tmp.getQuantity();
                    tmp.setQuantity(quantity + value);
                    return;
                } catch (NumberFormatException nfe) {
                    if ("".equals(input)) {
                        System.out.println("Input is required!");
                    } else {
                        System.out.println("Wrong input!");
                    }
                }
            }
        }
    }
    
    //Function 2.2
    private void DecreaseQuantity(Goods goods, Shipment tmp) {
        if (tmp.getQuantity() == 0) {
            System.out.println("Can not decrease quantity");
            return;
        }
        String input;
        int value = 1;
        while (true) {
            System.out.print("Enter the quantity you want to decrease or type BACK to get back: ");
            input = sc.nextLine();
            if (input.equalsIgnoreCase("back")) {
                return;
            } else {
                try {
                    value = Integer.parseInt(input);
                    if (value <= 0) {
                        System.out.println(
                                "Product quantity must be a positive number !");
                        continue;
                    } else if (value >= tmp.getQuantity()) {
                        System.out.println(
                                "Your changes make quantity equal 0");
                        tmp.setQuantity(0);
                        return;
                    }
                    int quantity = tmp.getQuantity();
                    tmp.setQuantity(quantity - value);
                    return;
                } catch (NumberFormatException nfe) {
                    if ("".equals(input)) {
                        System.out.println("Input is required!");
                    } else {
                        System.out.println("Wrong input!");
                    }
                }
            }
        }
    }
      
    //Function 2.3
    private void deleteFromOrder(Goods goods, Shipment shipment) {
        goods.getShipments().remove(shipment);
        System.out.println("Deleted succeed !");
    }
    
    //Function 3
    private void payOrder() {
        if (draftOrder.isEmpty()) {
            System.out.println("Your order list is empty!");
            return;
        }
        Scanner scanner = new Scanner(System.in);
        while (true) {
            try {
                System.out.print("Please enter the discount percentage (must be a positive number), or type BACK to go back: ");
                String input = scanner.nextLine();
                if (input.equalsIgnoreCase("BACK")) {
                    return;
                }
                discount = Math.min(100, Integer.parseInt(input));
                if (discount < 0) {
                    System.out.println("Discount percentage must be a positive number. Please try again.");
                    continue;
                }
                break;
            } catch (NumberFormatException e) {
                System.out.println("Invalid input. Discount percentage must be a positive number. Please try again.");
            }
        }
        int totalPayment = totalPayment();
        int totalAfterDiscount = totalAfterDiscount(totalPayment);
        boolean inputMoney = true;
        boolean backToDiscount = false; // Thêm biến để theo dõi việc quay lại nhập giảm giá
        while (inputMoney) {
            try {
                if (!backToDiscount) {
                    System.out.println("Please enter the amount of money you give, or type BACK to go back, or type EXIT to exit payment process: ");
                } else {
                    System.out.println("Please enter the discount percentage (must be a positive number), or type BACK to go back: ");
                }
                String input = scanner.nextLine();
                if (input.equalsIgnoreCase("BACK")) {
                    if (backToDiscount) {
                        backToDiscount = false; // Nếu thấy muốn quay lại nhập giảm giá thì sẽ quay lại chỗ xử lý giảm giá
                    } else {
                        backToDiscount = true; // Nếu không thì sẽ quay lại chỗ xử lý giảm giá
                        continue;
                    }
                } else if (input.equalsIgnoreCase("EXIT")) {
                    inputMoney = false;
                } else {
                    if (!backToDiscount) {
                        customerMoney = Integer.parseInt(input);
                        if (customerMoney < 0) {
                            System.out.println("Payment amount must be a positive number. Please try again.");
                            continue;
                        }
                        if (customerMoney < totalAfterDiscount) {
                            System.out.println("Insufficient payment. Please pay more.");
                            continue;
                        }
                        int change = customerMoney - totalAfterDiscount;
                        showBill(totalPayment, totalAfterDiscount, change);
                        draftOrder.clear();
                        inputMoney = false;
                    } else {
                        backToDiscount = false; // Khi nhập giảm giá xong thì sẽ không còn quay lại trong trường hợp này.
                        discount = Math.min(100, Integer.parseInt(input));
                        if (discount < 0) {
                            System.out.println("Discount percentage must be a positive number. Please try again.");
                            continue;
                        }
                        System.out.println("Discount applied successfully!");
                    }
                    // Hiển thị hóa đơn và trừ số lượng hàng
                    int change = customerMoney - totalAfterDiscount;
                    showBill(totalPayment, totalAfterDiscount, change);
                    inputMoney = false; // Đặt biến để thoát vòng lặp và quay lại Menu
                    draftOrder.clear();
                    break;
                }
            } catch (NumberFormatException e) {
                System.out.println("Invalid input. Please try again.");
            }
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
        System.out.println("Date: " + invoiceDate);
        System.out.println("");
        System.out.format("%-25s %-10s %-15s %-15s\n", "Name", "Quantity", "Price", "Total");
        System.out.format("%-25s %-10s %-15s %-15s\n", "-------------------------", "----------", "---------------", "---------------");
        for (int i = 0; i < draftOrder.size(); i++) {
            Goods goods = draftOrder.get(i);
            long totalQuantity = goods.getTotalQuantity();
            long price = goods.getListPrice();
            long totalPrice = totalQuantity * price;
            System.out.format("%-25s %-10d %-15d %-15d\n", goods.getGoodsName(), totalQuantity, price, totalPrice);
        }
        System.out.println("Total payment: " + totalPayment);
        System.out.println("Discount: " + discount + "%");
        System.out.println("Total after discount: " + totalAfterDiscount);
        System.out.println("Customer payment: " + customerMoney);
        System.out.println("Change: " + change);
        System.out.println("----------------------------------------");
    }
    
    public void makeNewOrder() {

        int choice;
        do {
            try {
                orderMenu();
                choice = sc.nextInt();
                switch (choice) {
                    case 1:
                        uf.showGoodsList(myGoodsList);
                        addToOrder();
                        break;
                    case 2:
                        editOrder();
                        break;
                    case 3:
                        payOrder();
                        break;
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
    }
}
