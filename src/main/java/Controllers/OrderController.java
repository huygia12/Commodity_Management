/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controllers;

import Models.CustomerCardList;
import Models.Order;
import Models.Goods;
import Models.GoodsList;
import Ultility.IDGenerator;
import Models.PaymentOptions;
import Models.Shift;
import Models.Shipment;
import Models.Store;
import Ultility.Cautions;
import View.OrderView;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;
import java.util.stream.*;

/**
 *
 * @author FPTSHOP
 */
public class OrderController extends GoodsListController{

    private final OrderView view = new OrderView();
    final Cautions ctions = new Cautions();
    final LocalDate CURRENT_DATE = LocalDate.now();
    private final GoodsList<Goods> draftGoodsList = new GoodsList(new ArrayList<>());
    private final ShipmentController shipmentCtr = new ShipmentController();
    private final CustomerCardController cardCtr = new CustomerCardController();
    private final Scanner sc = new Scanner(System.in);
    
    public OrderController() {
    }

    public OrderView getOrderView() {
        return this.view;
    }

    public BigDecimal getSubTotal(Order order) {
        // tong tien khi chua qua discount va VAT
        BigDecimal result = BigDecimal.ZERO;
        for (Goods goods : order.getGoodsList()) {
            result = result.add(goods.getListPrice()
                    .multiply(goodsCtr.getTotalQuanByShipments(goods)));
        }
        return result;
    }

    public BigDecimal getTaxFee(Order order) {
        // tong tien phi VAT cho ca hoa don
        return getSubTotal(order).multiply(new BigDecimal(order.getVAT() * 1.0 / 100));
    }

    public BigDecimal getTotal(Order order) {
        // Khoan tien can thanh toan khi da tru di discount va cong them VAT
        return (getSubTotal(order)
                .add(getTaxFee(order)))
                .multiply(new BigDecimal(1.0 - order.getDiscount() * 1.0 / 100))
                .subtract(order.getPointDiscount());
    }

    public BigDecimal getDiscountMoney(Order order) {
        // tong tien giam gia 
        return (getSubTotal(order).add(getTaxFee(order)))
                .multiply(new BigDecimal(order.getDiscount() * 1.0 / 100));
    }

    public BigDecimal getChange(Order order) {
        return order.getCusMoney().subtract(getTotal(order));
    }

    
    public Order makeNewOrder(GoodsList<Goods> repoGoodsList, CustomerCardList customerCardList,
            Store myStore, Shift shift, IDGenerator idGenerator) {
        
        Order order = new Order(idGenerator.generateID(Order.class.getName(), 6),
                myStore.getVAT());
        // tao mot ban cpy cua repositoryGoodsList la draftGoodsList
        makeDraftGoodsList(repoGoodsList);
        int choice;
        boolean completed = false;
        do {
            try {
                this.view.orderMenu();
                choice = sc.nextInt();
                sc.nextLine();
                switch (choice) {
                    case 1:
                        addToOrder(order);
                        break;
                    case 2:
                        editOrder(repoGoodsList, order);
                        break;
                    case 3:
                        if (payOrder(customerCardList, myStore, order)) {
                            completed = true;
                        }
                        break;
                    case 4:
                        break;
                    default:
                        System.out.println("Wrong input! Please type form 1->4!");
                        break;
                }
            } catch (InputMismatchException ime) {
                ctions.wrInput();
                choice = -1;
                sc.next();
            }
        } while (choice != 4 && !completed);
        if (completed) {
            shift.getOrderHisPerShift().add(order);
            updateQuanAfterPay(repoGoodsList, order);
        }
        return order;
    }
    
    public GoodsList<Goods> makeDraftGoodsList(GoodsList<Goods> repoGoodsList) {
        // tao mot ban cpy cua repositoryGoodsList la draftGoodsList
        draftGoodsList.setGoodsList(repoGoodsList.getGoodsList()
                .stream()
                .map(x -> goodsCtr.cloneGoods(x))
                .collect(Collectors.toList()));
        // draftGoodsList chi duoc phep chua nhung Shipment con hsd
        for (Goods draftGoods : draftGoodsList.getGoodsList()) {
            draftGoods.setShipments(draftGoods.getShipments()
                    .stream()
                    .filter(x -> x.getHsd().isAfter(this.CURRENT_DATE))
                    .collect(Collectors.toList()));
        }
        // draftGoodsList chi duoc phep chua Goods van con shipment
        draftGoodsList.setGoodsList(draftGoodsList.getGoodsList()
                .stream()
                .filter(x -> !x.getShipments().isEmpty())
                .collect(Collectors.toList()));
        return draftGoodsList;
    }

    private void updateQuanAfterPay(GoodsList<Goods> repoGoodsList, Order order) {
        // cap nhat lai so luong neu pay thanh cong
        for (Goods orderGoods : order.getGoodsList()) {
            Goods repoGoods = containGoods(repoGoodsList, orderGoods.getID());
            for (Shipment orderShipment : orderGoods.getShipments()) {
                Shipment repoShipment = goodsCtr.containShipment(repoGoods, orderShipment.getID());
                BigDecimal quanBefore = repoShipment.getQuantity();
                repoShipment.setQuantity(quanBefore.subtract(orderShipment.getQuantity()));
            }
        }
    }
    
    //Function 1
    private void addToOrder(Order order) {
        Shipment orderShipment = new Shipment();
        Goods searchGoods = searchGoods(draftGoodsList);
        // Tim kiem goods va shipment muon them vao order
        if (searchGoods == null) {
            return;
        }
        Shipment searchShipment = goodsCtr.searchShipment(searchGoods);
        if (searchShipment == null) {
            return;
        }
        if (searchShipment.getQuantity().compareTo(BigDecimal.ZERO) == 0) {
            System.out.println("Doesn't have enough quantity!");
            return;
        }
        // Type in the quantity of searchGoods want to buy
        while (true) {
            int nextProcess = shipmentCtr.getView().typeInQuan(orderShipment);
            if (nextProcess == -1 || nextProcess == 0) {
                return;
            } else if (orderShipment.getQuantity().compareTo(searchShipment.getQuantity()) > 0) {
                System.out.println("Doesn't have enough quantity!");
                orderShipment.setQuantity(BigDecimal.ZERO);
            } else if (ctions.checkIfNumberNegative(orderShipment.getQuantity())) {
                orderShipment.setQuantity(BigDecimal.ZERO);
            } else {
                break;
            }
        }
        BigDecimal inputQuantity = orderShipment.getQuantity();
        // Kiem tra neu order da chua goods nay hay chua
        Goods existedOrderGoods = containGoods(order,searchGoods.getID());
        orderShipment = shipmentCtr.cloneShipment(searchShipment);
        orderShipment.setQuantity(inputQuantity);
        if (existedOrderGoods == null) {
            // Neu khong chua thi them moi vao Order hien tai
            Goods orderGoods = goodsCtr.cloneGoods(searchGoods);
            orderGoods.getShipments().clear();
            orderGoods.getShipments().add(orderShipment);
            order.getGoodsList().add(orderGoods);
        } else {
            Shipment existedOrderShipment = goodsCtr
                    .containShipment(existedOrderGoods, orderShipment.getID());
            if (existedOrderShipment != null) {
                // Neu shipment nay da ton tai trong hoa don, chi them so luong cua shipment
                existedOrderShipment
                        .setQuantity(existedOrderShipment.getQuantity()
                                .add(orderShipment.getQuantity()));
            } else {
                // Neu chua ton tai shipment nay, them shipment vao trong  
                existedOrderGoods.getShipments().add(orderShipment);
            }
        }
        // sau khi them goods vao order, giam so luong goods do torng draftGoodsList
        BigDecimal quantityBefore = searchShipment.getQuantity();
        searchShipment.setQuantity(quantityBefore.subtract(inputQuantity));
        this.view.showDraftOrder(order, this);
    }

    //Funtion 2
    private void editOrder(GoodsList repoGoodsList, Order order) {
        String choice;
        // Tao mot draftOrder cua curOrder de thao tac, sau khi edit xong moi thay doi vao curOrder
        Order draftOrder = new Order();
        draftOrder.setGoodsList(order.getGoodsList().stream()
                .map(x -> goodsCtr.cloneGoods(x))
                .collect(Collectors.toList()));
        // tim kiem goods va shipment muon chinh sua
        Goods searchOrderGoods = searchGoods(order);
        if (searchOrderGoods == null) {
            return;
        }
        Shipment searchOrderShipment = goodsCtr.searchShipment(searchOrderGoods);
        if (searchOrderShipment == null) {
            return;
        }
        // lay ra shipment muon chinh sua
        Shipment editShipment = goodsCtr.containShipment(containGoods(draftOrder, searchOrderGoods.getID()), 
                searchOrderShipment.getID());
        // lay so luong con lai o trong kho cua san pham da duoc tim kiem
        BigDecimal remainQuan = goodsCtr.containShipment(containGoods(draftGoodsList, searchOrderGoods.getID()), 
                searchOrderShipment.getID())
                .getQuantity();
        do {
            this.view.editOrderMenu();
            choice = sc.nextLine();
            switch (choice) {
                case "1":
                    remainQuan = remainQuan.subtract(IncrQuanInOrder(editShipment, remainQuan));
                    this.view.showDraftOrder(draftOrder, this);
                    break;
                case "2":
                    remainQuan = remainQuan.add(DecrQuanInOrder(editShipment));
                    this.view.showDraftOrder(draftOrder, this);
                    break;
                case "3":
                    deleteFromOrder(repoGoodsList, searchOrderGoods, searchOrderShipment, order);
                    this.view.showDraftOrder(draftOrder, this);
                    return;
                case "4":
                    if (editShipment.getQuantity().compareTo(BigDecimal.ZERO) == 0) {
                        System.out.println(
                                "Your changes make quantity become 0 and will be automatically removed from order!");
                        deleteFromOrder(repoGoodsList,  searchOrderGoods, searchOrderShipment, order);
                    } else {
                        // set quantity in curOrder after finish edit
                        searchOrderShipment.setQuantity(editShipment.getQuantity());
                        // reset quantity in the draftGoodsList after finish edit
                        goodsCtr.containShipment(containGoods(draftGoodsList, searchOrderGoods.getID()), 
                                searchOrderShipment.getID())
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

    private BigDecimal IncrQuanInOrder(Shipment cloneShipment, BigDecimal remainQuan) {
        // tra ve so luong duoc tang len neu thuc hien thanh cong, BigInteger.Zero neu remainQuan == 0 hoac user nhap back/exit
        if (remainQuan.equals(BigDecimal.ZERO)) {
            System.out.println("Can not increase quantity!");
            return BigDecimal.ZERO;
        }
        BigDecimal quanBefore = cloneShipment.getQuantity();
        while (true) {
            int nextProcess = shipmentCtr.getView().typeInQuan(cloneShipment);
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

    private BigDecimal DecrQuanInOrder(Shipment cloneShipment) {
        // tra ve so luong duoc giam neu thuc hien thanh cong, BigInteger.Zero neu remainQuan == 0 hoac user nhap back/exit
        if (cloneShipment.getQuantity().compareTo(BigDecimal.ZERO) == 0) {
            System.out.println("Can not decrease Quantity!");
            return BigDecimal.ZERO;
        }
        BigDecimal quanBefore = cloneShipment.getQuantity();
        int nextProcess = shipmentCtr.getView().typeInQuan(cloneShipment);
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

    private void deleteFromOrder(GoodsList repoGoodsList, Goods orderGoods, 
            Shipment orderShipment, Order order) {
        orderGoods.getShipments().remove(orderShipment);
        if (orderGoods.getShipments().isEmpty()) {
            order.getGoodsList().remove(orderGoods);
        }
        System.out.println("Deleted succeed !");
        // tra lai so luong ban dau neu delete
        BigDecimal originQuan = goodsCtr
                .containShipment(containGoods(repoGoodsList, orderGoods.getID()), 
                        orderShipment.getID())
                .getQuantity();
        goodsCtr.containShipment( containGoods(draftGoodsList, orderGoods.getID()), 
                orderShipment.getID())
                .setQuantity(originQuan);
    }

    //Funtion 3
    private boolean payOrder( CustomerCardList customerCardList, Store myStore, Order order) {
        // tra ve true neu pay thanh cong, false neu list khong co gi hoac user nhap exit
        if (ctions.checkIfListEmpty(order.getGoodsList())) {
            return false;
        }
        int n = 1;
        int nextProcess;
        while (n != -1) {
            OUTER:
            OUTER_1:
            switch (n) {
                case 1:
                    // nhap discount
                    nextProcess = this.view.typeInDcountPctage(order);
                    if (nextProcess == 0 || nextProcess == -1) {
                        return false;
                    }
                case 2:
                    // nhap phuong thuc thanh toan
                    nextProcess = this.view.typeOfPayment(order);
                    switch (nextProcess) {
                        case 0:
                            return false;
                        case -1:
                            n = 2;
                            break OUTER;
                        default:
                            // neu chon payment option la Wire_Transfer_Payment thi bo qua case 3 
                            if (order.getPaymentOptions().equals(PaymentOptions.Wire_Transfer_Payment)) {
                                n = 4;
                                break OUTER;
                            }
                            break;
                    }
                case 3:
                    // nhap so tien khach hang tra
                    nextProcess = this.view.typeInCusMoney(order, this);
                    if (nextProcess == 0) {
                        return false;
                    } else if (nextProcess == -1) {
                        break;
                    }
                case 4:
                    nextProcess = this.view.typeInCustomerID(customerCardList, order);
                    switch (nextProcess) {
                        case 0:
                            return false;
                        case -1:
                            n = 3;
                            break OUTER_1;
                        default:
                            if (order.getCustomerCard() == null) {
                                n = -1;
                                break OUTER_1;
                            }
                            break;
                    }
                case 5:
                    nextProcess = this.view.typeInPoint(order);
                    if (nextProcess == 0) {
                        return false;
                    } else if (nextProcess == -1) {
                        n = 4;
                        break;
                    }
                    n = -1;
            }
        }
        if (order.getCustomerCard() != null) {
            cardCtr.gainPoint(order.getCustomerCard(), getTotal(order));
        }
        this.view.showBill(order, myStore, this);
        if (this.view.makeDecisionToPrintOrder()) {
            this.view.printBillToFile(order, myStore, this);
        }
        return true;
    }
}
