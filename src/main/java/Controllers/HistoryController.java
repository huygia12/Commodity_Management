/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controllers;

import Ultility.CustomPair;
import Models.Goods;
import Models.GoodsList;
import Models.History;
import Models.Order;
import Models.Shift;
import Models.Shipment;
import Models.SoldGoods;
import Models.StaticalGoods;
import Models.Store;
import Ultility.Cautions;
import View.HistoryView;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;
import java.util.Set;

/**
 *
 * @author FPTSHOP
 */
public class HistoryController {

    private final HistoryView view = new HistoryView();
    final Scanner sc = new Scanner(System.in);
    final Cautions ctions = new Cautions();
    final GoodsListController goodsListCtr = new GoodsListController();
    final OrderController orderCtr = new OrderController();

    public HistoryController() {
    }

    public HistoryView getHistoryView() {
        return this.view;
    }

    public void historyManagement(History history) {
        if (history.getShiftHistory().isEmpty()) {
            System.out.println("Nothing found in history!");
            return;
        }
        int choice;
        do {
            try {
                this.view.menuOfHistoryManagement();
                choice = sc.nextInt();
                sc.nextLine();
                switch (choice) {
                    case 1:
                        statisticOfOrder(history);
                        break;
                    case 2:
                        break;
                    case 3:
                        statisticOfShiftGoods(history);
                        break;
                    case 4:
                        searchOrderInDetail(history);
                        break;
                    case 5:
                        break;
                    case 6:
                        break;
                    case 7:
                        System.out.println("Back...");
                        break;
                    default:
                        System.out.println("Wrong input, Please type from 1->7!");
                        break;
                }
            } catch (InputMismatchException ime) {
                ctions.wrInput();
                choice = -1;
                sc.next();
            }
        } while (choice != 7);
    }

    //function 1
    public GoodsList<SoldGoods> makeHisoryOrderGoodsList(List<Shift> shiftList) {
        GoodsList<SoldGoods> soldGoodsList = new GoodsList();
        Set<String> IDBucket = new HashSet<>();
        SoldGoods soldGoods = new SoldGoods();
        for (Shift shift : shiftList) {
            for (Order order : shift.getOrderHisPerShift()) {
                for (Goods goods : order.getList()) {
                    if (IDBucket.contains(goods.getID())) {
                        soldGoods = goodsListCtr.containGoods(soldGoodsList, goods.getID());
                        // set gia da ban cho khach hang 
                        soldGoods.setSoldPrice(order.getTax(), order.getDiscount());
                        // tang tong tien cua san pham da ban
                        soldGoods.setTotalAmountSold(soldGoods.getTotalAmountSold()
                                .add(soldGoods.getSoldPrice().multiply(goods.getTotalQuantity())));
                        // tang so luong da ban cua san pham
                        soldGoods.setTotalQuantity(soldGoods.getTotalQuantity()
                                .add(goods.getTotalQuantity()));
                    } else {
                        soldGoods = new SoldGoods(goods);
                        // set so luong da ban cua san pham
                        soldGoods.setTotalQuantity(goods.getTotalQuantity());
                        // set gia da ban cho khach hang 
                        soldGoods.setSoldPrice(order.getTax(), order.getDiscount());
                        // set tong tien cua san pham da ban
                        soldGoods.setTotalAmountSold(soldGoods.getSoldPrice()
                                .multiply(soldGoods.getTotalQuantity()));
                        // them vao danh sach cac san pham da ban
                        soldGoodsList.getList().add(soldGoods);
                        // them id cua soldGoods da ton tai vao trong idbucket
                        IDBucket.add(goods.getID());
                    }
                }
            }
        }
        return soldGoodsList;
    }

    private List<Shift> ordersBetweenFromToDate(CustomPair<LocalDate, LocalDate> fromToDate, History history) {
        List<Shift> shiftList = new ArrayList<>();
        for (Shift shift : history.getShiftHistory()) {
            Shift tempShift = new Shift();
            for (Order order : shift.getOrderHisPerShift()) {
                LocalDate orderDateTime = order.getOrderDateTime().toLocalDate();
                // Neu order nam trong khoang cua fromToDate thi them vao tmp
                if ((orderDateTime.isAfter(fromToDate.getK())
                        && orderDateTime.isBefore(fromToDate.getV()))
                        || orderDateTime.isEqual(fromToDate.getK())
                        || orderDateTime.isEqual(fromToDate.getV())) {
                    tempShift.getOrderHisPerShift().add(order);
                }
            }
            if (!tempShift.getOrderHisPerShift().isEmpty()) {
                tempShift.setID(shift.getID());
                shiftList.add(tempShift);
            }
        }
        return shiftList;
    }

    private void statisticOfOrder(History history) {
        this.view.showOrderHistory(history);
        CustomPair<LocalDate, LocalDate> fromToDate = this.view.typeInFromToDate();
        // Nhat tat ca order nam trong khoang fromToDate de cho vao shiftList
        List<Shift> shiftList = ordersBetweenFromToDate(fromToDate, history);
        // Hien thi cac thong tin co ban cua cac order do: orderID, shiftID, orderDateTime, orderTotal
        // Hien thi thong ke so luong va so tien cua tung mat hang duoc ban
        this.view.showOrderHistory(makeHisoryOrderGoodsList(shiftList));
    }

    //function 3
    private List<Shift> shiftBetweenFromToDate(CustomPair<LocalDate, LocalDate> fromToDate, History history) {
        List<Shift> shiftList = new ArrayList<>();
        for (Shift shift : history.getShiftHistory()) {
            LocalDate importDateTime = shift.getOpenTime().toLocalDate();
            // Neu order nam trong khoang cua fromToDate thi them vao tmp
            if ((importDateTime.isAfter(fromToDate.getK())
                    && importDateTime.isBefore(fromToDate.getV()))
                    || importDateTime.isEqual(fromToDate.getK())
                    || importDateTime.isEqual(fromToDate.getV())) {
                shiftList.add(shift);
            }
        }
        return shiftList;
    }

    private void statisticOfShiftGoods(History history) {
        CustomPair<LocalDate, LocalDate> fromToDate = this.view.typeInFromToDate();
        List<Shift> shiftList = shiftBetweenFromToDate(fromToDate, history);
    }

    //function 4
    private void searchOrderInDetail(History history) {
        Order searchingOrder = searchOrder(history);
        if (searchingOrder != null) {
            this.view.showAnOrderInDetail(searchingOrder);
            GoodsList<Goods> orderGoodsList = new GoodsList(searchingOrder.getList());
            goodsListCtr.getView().showGoodsList(orderGoodsList);
        }
    }

    public Order containOrder(String ID, History history) {
        for (Shift shift : history.getShiftHistory()) {
            for (Order order : shift.getOrderHisPerShift()) {
                if (order.getID().equals(ID)) {
                    return order;
                }
            }
        }
        return null;
    }

    public Shift containShift(String ID, History history) {
        for (Shift shift : history.getShiftHistory()) {
            if (shift.getID().equals(ID)) {
                return shift;
            }
        }
        return null;
    }

    public Goods containImportGoods(String shipmentID, History history) {
        for (Goods importedGoods : history.getImportGoodsList()) {
            Shipment firstShipment = importedGoods.getShipments().get(0);
            if (firstShipment.getID().equals(shipmentID)) {
                return importedGoods;
            }
        }
        return null;
    }

    public Order searchOrder(History history) {
        // tra ve null neu nguoi dung nhap 'back', nguoc lai, tra ve 1 order duoc tim kiem
        if (history.getShiftHistory().isEmpty()) {
            System.out.println("Cannot search in an empty List!");
            return null;
        }
        String inputStr;
        boolean completed = false;
        Order searchingOrder = null;
        do {
            try {
                System.out.print("Input orderID to search or BACK to go back: ");
                inputStr = sc.nextLine();
                if ("back".equalsIgnoreCase(inputStr)) {
                    return null;
                }
                int searchingKey = Integer.parseInt(inputStr);
                searchingOrder = containOrder(inputStr, history);
                if (searchingOrder == null) {
                    System.out.println("Your input ID doesnt exist.");
                    continue;
                }
                completed = true;
            } catch (NumberFormatException nfe) {
                ctions.wrInput();
            }
        } while (!completed);
        return searchingOrder;
    }

    public Shift searchShift(History history) {
        // tra ve null neu nguoi dung nhap 'back', nguoc lai, tra ve 1 Shift duoc tim kiem
        if (history.getShiftHistory().isEmpty()) {
            System.out.println("Cannot search in an empty List!");
            return null;
        }
        String inputStr;
        boolean completed = false;
        Shift searchingShift = null;
        do {
            try {
                System.out.print("Input shiftID to search or BACK to go back: ");
                inputStr = sc.nextLine();
                if ("back".equalsIgnoreCase(inputStr)) {
                    return null;
                }
                int searchingKey = Integer.parseInt(inputStr);
                searchingShift = containShift(inputStr, history);
                if (searchingShift == null) {
                    System.out.println("Your input ID doesnt exist.");
                    continue;
                }
                completed = true;
            } catch (NumberFormatException nfe) {
                ctions.wrInput();
            }
        } while (!completed);
        return searchingShift;
    }

    public List<Order> toOrderList(History history) {
        List<Order> listOfOrder = new ArrayList<>();
        for (Shift shift : history.getShiftHistory()) {
            for (Order order : shift.getOrderHisPerShift()) {
                listOfOrder.add(order);
            }
        }
        return listOfOrder;
    }

    public BigDecimal getTotalNetRevenue(List<Order> orderHistory, Store store) {
        BigDecimal result = BigDecimal.ZERO;
        for (Order order : orderHistory) {
            result = result.add(orderCtr.getTotal(order, store));
        }
        return result;
    }

    public BigDecimal getTotalGrossRevenue(List<Order> orderHistory) {
        BigDecimal result = BigDecimal.ZERO;
        for (Order order : orderHistory) {
            result = result.add(orderCtr.getSubTotal(order));
        }
        return result;
    }

    public GoodsList<StaticalGoods> makeStaticalGoodsList(List<Order> orderList, BigDecimal totalRevenue) {
        ShipmentController shipmentCtr = new ShipmentController();
        GoodsController goodsCtr = new GoodsController();
        GoodsList<StaticalGoods> staticalGoodsList = new GoodsList<>();
        // duyẹt một vòng để lọc ra danh sách không bị trùng của các goods
        for (Order order : orderList) {
            for (Goods goods : order.getList()) {
                StaticalGoods staticalGoods = goodsListCtr.containGoods(staticalGoodsList, goods.getID());
                if (staticalGoods != null) { //  nếu đã tồn tại thì check den shipment
                    for (Shipment shipment : goods.getShipments()) {
                        Shipment staticalShipment = goodsCtr
                                .containShipment(staticalGoods.getShipments(), shipment.getID());
                        if (staticalShipment != null) {// neu da ton tai thi cong so luong
                            staticalShipment.setQuantity(staticalShipment.getQuantity()
                                    .add(shipment.getQuantity()));
                        } else { // neu chua ton tai thi them moi shipment
                            Shipment cloneShipment = shipmentCtr.cloneShipment(shipment);
                            staticalGoods.getShipments().add(cloneShipment);
                        }
                    }
                } else { // nếu chưa tồn tại goods này thì thêm vào danh sách thống kê
                    StaticalGoods newStaticalGoods = new StaticalGoods(goods);
                    for (Shipment shipment : goods.getShipments()) {
                        Shipment cloneShipment = shipmentCtr.cloneShipment(shipment);
                        newStaticalGoods.getShipments().add(cloneShipment);
                    }
                    staticalGoodsList.getList().add(newStaticalGoods);
                }
            }
        }
        // duyệt 1 vòng để set revenue và ratio cho từng shipment trong các goods
        for (StaticalGoods staticalGoods : staticalGoodsList.getList()) {
            staticalGoods.setRevenue(staticalGoods.getTotalQuantity()
                    .multiply(staticalGoods.getListPrice()));
            staticalGoods.setRatio(staticalGoods.getRevenue()
                    .divide(totalRevenue, 2, RoundingMode.HALF_UP));
        }
        return staticalGoodsList;
    }

    public BigDecimal getTotalAmountOfImportGoods(List<Goods> importGoodsList) {
        BigDecimal result = BigDecimal.ZERO;
        for (Goods goods : importGoodsList) {
            Shipment shipment = goods.getShipments().get(0);
            result = result.add(shipment.getImportPrice().multiply(shipment.getQuantity()));
        }
        return result;
    }
}
