package Models;

import View.Cautions;
import View.OrderView;
import View.ShipmentView;
import java.math.BigDecimal;
import java.util.List;
import java.util.stream.*;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Order extends GoodsList {

    final String INVOICE_DATE;
    final Cautions ctions = new Cautions();
    private String ID;
    private BigDecimal cusMoney = BigDecimal.ZERO;
    private int discount;
    private String paymentOptions;

    public Order(List<Goods> currentOrder, String ID) {
        super(currentOrder);
        this.ID = ID;
        this.INVOICE_DATE = LocalDateTime
                .now()
                .format(DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss"));
    }

    private Order(List<Goods> currentOrder) {
        super(currentOrder);
        this.INVOICE_DATE = LocalDateTime
                .now()
                .format(DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss"));
    }

    public void setDiscount(int discount) {
        this.discount = discount;
    }

    public int getDiscount() {
        return this.discount;
    }

    public void setID(String ID) {
        this.ID = ID;
    }

    public String getID() {
        return this.ID;
    }

    public String getInVoiceDateTime(){
        return this.INVOICE_DATE;
    }

    public String getPaymentOptions() {
        return this.paymentOptions;
    }

    public void setPaymentOptions(int option) {
        if( option == 1){
            this.paymentOptions = "Cash Payment";
        }else{
            this.paymentOptions = "Wire Transfer Paymnet";
        }
    }
    
    public BigDecimal getCusMoney() {
        if (this.cusMoney == null) {
            this.cusMoney = BigDecimal.ZERO;
        }
        return this.cusMoney;
    }

    public void setCusMoney(BigDecimal customerMoney) {
        this.cusMoney = customerMoney;
    }

    public BigDecimal getTotalPayment() {
        BigDecimal result = BigDecimal.ZERO;
        for (Goods goods : this.getGoodsList()) {
            result = result.add(goods.getListPrice().multiply(goods.getTotalQuantity()));
        }
        return result;
    }

    public BigDecimal getTotalAfterDis() {
        BigDecimal result = BigDecimal.valueOf(1.0 - (discount * 1.0) / 100).multiply(this.getTotalPayment());
        if (result == null) {
            result = BigDecimal.ZERO;
        }
        return result;
    }

    public BigDecimal getDiscountMoney(){
        
    }
    
    //Function 1
    public void addToOrder(GoodsList draftGoodsList, ShipmentView shipView, OrderView orderView) {
        Shipment orderShipment = new Shipment();
        Goods searchGoods = draftGoodsList.searchGoods();
        // Tim kiem goods va shipment muon them vao order
        if (searchGoods == null) {
            return;
        }
        Shipment searchShipment = searchGoods.searchShipment();
        if (searchShipment == null) {
            return;
        }
        if (searchShipment.getQuantity().compareTo(BigDecimal.ZERO) == 0) {
            System.out.println("Doesn't have enough quantity!");
            return;
        }
        // Type in the quantity of searchGoods want to buy
        while (true) {
            int nextProcess = shipView.typeInQuan(orderShipment);
            if (nextProcess == -1 || nextProcess == 0) {
                return;
            } else if (orderShipment.getQuantity().compareTo(searchShipment.getQuantity()) > 0) {
                orderShipment.setQuantity(BigDecimal.ZERO);
            } else if (!ctions.checkIfBigIntPositive(orderShipment.getQuantity())) {
                orderShipment.setQuantity(BigDecimal.ZERO);
            } else {
                break;
            }
        }
        BigDecimal inputQuantity = orderShipment.getQuantity();
        // Check if order already had this goods or not
        Goods existedOrderGoods = this.containGoods(searchGoods.getID());
        orderShipment = searchShipment.cloneShipment();
        orderShipment.setQuantity(inputQuantity);
        if (existedOrderGoods == null) {
            // if not, add new Goods and it'sShipment to currentOrder
            Goods orderGoods = searchGoods.cloneGoods();
            orderGoods.getShipments().clear();
            orderGoods.getShipments().add(orderShipment);
            this.getGoodsList().add(orderGoods);
        } else {
            Shipment existedOrderShipment = existedOrderGoods
                    .containShipment(orderShipment.getID());
            if (existedOrderShipment != null) {
                // Neu shipment nay da ton tai trong hoa don, chi them so luong cua shipment
                existedOrderShipment
                        .setQuantity(existedOrderShipment.getQuantity()
                                .add(orderShipment.getQuantity()));
            } else {
                // if not, add new Shipment to order 
                existedOrderGoods.getShipments().add(orderShipment);
            }
        }
        // sau khi them goods vao order, giam so luong goods do torng draftGoodsList
        BigDecimal quantityBefore = searchShipment.getQuantity();
        searchShipment.setQuantity(quantityBefore.subtract(inputQuantity));
        orderView.showDraftOrder(this);
    }

    //Funtion 2
    public void editOrder(GoodsList repoGoodsList, GoodsList draftGoodsList, ShipmentView shipView, OrderView orderView) {
        String choice;
        // Tao mot draftOrder cua curOrder de thao tac, sau khi edit xong moi thay doi vao curOrder
        Order draftOrder = new Order(this.getGoodsList().stream()
                .map(x -> x.cloneGoods())
                .collect(Collectors.toList()));
        // Search for goods and shipment want to edit
        Goods searchOrderGoods = this.searchGoods();
        if (searchOrderGoods == null) {
            return;
        }
        Shipment searchOrderShipment = searchOrderGoods.searchShipment();
        if (searchOrderShipment == null) {
            return;
        }
        Shipment editShipment = draftOrder.containGoods(searchOrderGoods.getID())
                .containShipment(searchOrderShipment.getID());
        // take the rest quantity of searchShipment in repository goodsList
        BigDecimal remainQuan = draftGoodsList.containGoods(searchOrderGoods.getID())
                .containShipment(searchOrderShipment.getID())
                .getQuantity();
        do {
            orderView.editOrderMenu();
            choice = sc.nextLine();
            switch (choice) {
                case "1":
                    remainQuan = remainQuan.subtract(IncrQuanInOrder(editShipment, shipView, remainQuan));
                    orderView.showDraftOrder(draftOrder);
                    break;
                case "2":
                    remainQuan = remainQuan.add(DecrQuanInOrder(editShipment, shipView));
                    orderView.showDraftOrder(draftOrder);
                    break;
                case "3":
                    deleteFromOrder(repoGoodsList, draftGoodsList, searchOrderGoods, searchOrderShipment);
                    orderView.showDraftOrder(this);
                    return;
                case "4":
                    if (editShipment.getQuantity().compareTo(BigDecimal.ZERO) == 0) {
                        System.out.println(
                                "Your changes make quantity become 0 and will be automatically removed from order!");
                        deleteFromOrder(repoGoodsList, draftGoodsList, searchOrderGoods, searchOrderShipment);
                    } else {
                        // set quantity in curOrder after finish edit
                        searchOrderShipment.setQuantity(editShipment.getQuantity());
                        // reset quantity in the draftGoodsList after finish edit
                        draftGoodsList.containGoods(searchOrderGoods.getID())
                                .containShipment(searchOrderShipment.getID())
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

    private BigDecimal IncrQuanInOrder(Shipment cloneShipment, ShipmentView shipView, BigDecimal remainQuan) {
        // tra ve so luong duoc tang len neu thuc hien thanh cong, BigInteger.Zero neu remainQuan == 0 hoac user nhap back/exit
        if (remainQuan.equals(BigDecimal.ZERO)) {
            System.out.println("Can not increase quantity!");
            return BigDecimal.ZERO;
        }
        BigDecimal quanBefore = cloneShipment.getQuantity();
        while (true) {
            int nextProcess = shipView.typeInQuan(cloneShipment);
            BigDecimal quanIncrease = cloneShipment.getQuantity();
            if (nextProcess == -1 || nextProcess == 0) {
                return BigDecimal.ZERO;
            } else if (quanIncrease.compareTo(remainQuan) > 0) {
                System.out.println("Doesn't have enough quantity!");
                cloneShipment.setQuantity(BigDecimal.ZERO);
            } else {
                cloneShipment.setQuantity(quanBefore.add(quanIncrease));
                return quanIncrease;
            }
        }
    }

    private BigDecimal DecrQuanInOrder(Shipment cloneShipment, ShipmentView shipView) {
        // tra ve so luong duoc giam neu thuc hien thanh cong, BigInteger.Zero neu remainQuan == 0 hoac user nhap back/exit
        if (cloneShipment.getQuantity().compareTo(BigDecimal.ZERO) == 0) {
            System.out.println("Can not decrease Quantity!");
            return BigDecimal.ZERO;
        }
        BigDecimal quanBefore = cloneShipment.getQuantity();
        int nextProcess = shipView.typeInQuan(cloneShipment);
        BigDecimal quanDecrease = cloneShipment.getQuantity();
        if (nextProcess == -1 || nextProcess == 0) {
            return BigDecimal.ZERO;
        } else if (quanDecrease.compareTo(quanBefore) >= 0) {
            cloneShipment.setQuantity(BigDecimal.ZERO);
            return quanBefore;
        } else {
            cloneShipment.setQuantity(quanBefore.subtract(quanDecrease));
            return quanDecrease;
        }
    }

    private void deleteFromOrder(GoodsList repoGoodsList, GoodsList draftGoodsList, Goods orderGoods, Shipment orderShipment) {
        orderGoods.getShipments().remove(orderShipment);
        if (orderGoods.getShipments().isEmpty()) {
            this.getGoodsList().remove(orderGoods);
        }
        System.out.println("Deleted succeed !");
        // return the origin quantity after delete shipment
        BigDecimal originQuan = repoGoodsList.containGoods(orderGoods.getID())
                .containShipment(orderShipment.getID())
                .getQuantity();
        draftGoodsList.containGoods(orderGoods.getID())
                .containShipment(orderShipment.getID())
                .setQuantity(originQuan);
    }

    //Funtion 3
    public boolean payOrder(OrderView orderView) {
        // tra ve true neu pay thanh cong, false neu list khong co gi hoac user nhap exit
        if (ctions.checkIfListEmpty(this.getGoodsList())) {
            return false;
        }
        int n = 1;
        int nextProcess;
        while (n != 3) {
            if (n == 1) {
                nextProcess = orderView.typeInDcountPctage(this);
                if (nextProcess == 0 || nextProcess == -1) {
                    return false;
                }
                n++;
            }
            if (n == 2) {
                nextProcess = orderView.typeInCusMoney(this);
                if (nextProcess == 0) {
                    return false;
                } else if (nextProcess == -1) {
                    n = 1;
                    continue;
                }
                n++;
            }if(n == 3){
                
            }
            // make a payment and show bill
            orderView.showBill(this);
            n = 3;
        }
        return true;
    }

}