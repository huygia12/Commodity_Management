/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controllers;

import Ultility.CustomPair;
import Models.Goods;
import Models.GoodsList;
import Models.History;
import Models.ImportedGoods;
import Models.Order;
import Models.Shift;
import Models.SoldGoods;
import Models.Store;
import Ultility.Cautions;
import View.HistoryView;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
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
    
    public HistoryController() {
    }

    public HistoryView getHistoryView() {
        return this.view;
    }
    
    
    public void historyManagement(History history, Store store) {
        if(history.getShiftHistory().isEmpty()){
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
                        statisticOfOrder(history, store);
                        break;
                    case 2:
                        statisticOfImportGoods(history);
                        break;
                    case 3:
                        statisticOfShiftGoods(history, store);
                        break;
                    case 4:
                        searchOrderInDetail(history, store);
                        break;
                    case 5:
                        searchImportGoodsInDetail(history);
                        break;
                    case 6:
                        searchShiftInDetail(history, store);
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

    private void statisticOfOrder(History history, Store store) {
        this.view.showOrderHistory(history, store);
        CustomPair<LocalDate, LocalDate> fromToDate = this.view.typeInFromToDate();
        // Nhat tat ca order nam trong khoang fromToDate de cho vao shiftList
        List<Shift> shiftList = ordersBetweenFromToDate(fromToDate, history);
        // Hien thi cac thong tin co ban cua cac order do: orderID, shiftID, orderDateTime, orderTotal
        this.view.showOrderHistory(new History(shiftList), store);
        // Hien thi thong ke so luong va so tien cua tung mat hang duoc ban
        this.view.showOrderHistory(makeHisoryOrderGoodsList(shiftList));
    }

    //function 2
    public GoodsList<ImportedGoods> makeHistoryImportGoodsList(List<Shift> shiftList) {
        ImportedGoodsController importGoodsCtr = new ImportedGoodsController();
        GoodsList<ImportedGoods> importGoodsList = new GoodsList();
        Set<String> IDBucket = new HashSet<>();
        ImportedGoods tmpImportGoods = new ImportedGoods();
        for (Shift shift : shiftList) {
            for (ImportedGoods importGoods : shift.getImportGoodsHis().getList()) {
                if (IDBucket.contains(importGoods.getID())) {
                    tmpImportGoods = goodsListCtr.containGoods(importGoodsList, importGoods.getID());
                    // tang so luong vao tong so luong
                    tmpImportGoods.setTotalQuantity(tmpImportGoods.getTotalQuantity()
                            .add(importGoodsCtr.getTotalQuanByShipments(importGoods)));
                    // tang tong tien nhap hang cua san pham do
                    tmpImportGoods.setTotalAmountImport(importGoods.getShipments().get(0).getImportPrice()
                            .multiply(importGoodsCtr.getTotalQuanByShipments(importGoods))
                            .add(tmpImportGoods.getTotalAmountImport()));
                } else {
                    tmpImportGoods = importGoodsCtr.cloneImportGoods(importGoods);
                    // set so luong cua san pham nhap
                    tmpImportGoods.setTotalQuantity(importGoodsCtr.getTotalQuanByShipments(tmpImportGoods));
                    // set tong tien cua san pham da nhap
                    tmpImportGoods.setTotalAmountImport(
                            importGoods.getShipments().get(0).getImportPrice()
                                    .multiply(importGoodsCtr.getTotalQuanByShipments(importGoods)));
                    // them vao danh sach cac san pham da nhap
                    importGoodsList.getList().add(tmpImportGoods);
                    // them id cua importGoods da ton tai vao trong idbucket
                    IDBucket.add(importGoods.getID());
                }
            }
        }
        return importGoodsList;
    }

    private List<Shift> importGoodsBetweenFromToDate(CustomPair<LocalDate, LocalDate> fromToDate, History history) {
        List<Shift> shiftList = new ArrayList<>();
        for (Shift shift : history.getShiftHistory()) {
            Shift tempShift = new Shift();
            for (ImportedGoods importGoods : shift.getImportGoodsHis().getList()) {
                LocalDate importDateTime = LocalDate
                        .parse(importGoods.getImportDateTime(),
                                DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss"));
                // Neu importGoods nam trong khoang cua fromToDate thi them vao tempShift
                if ((importDateTime.isAfter(fromToDate.getK())
                        && importDateTime.isBefore(fromToDate.getV()))
                        || importDateTime.isEqual(fromToDate.getK())
                        || importDateTime.isEqual(fromToDate.getV())) {
                    tempShift.getImportGoodsHis().getList().add(importGoods);
                }
            }
            if (!tempShift.getImportGoodsHis().getList().isEmpty()) {
                tempShift.setID(shift.getID());
                shiftList.add(tempShift);
            }
        }
        return shiftList;
    }

    private void statisticOfImportGoods(History history) {
        this.view.showImportGoodsHistory(history);
        CustomPair<LocalDate, LocalDate> fromToDate = this.view.typeInFromToDate();
        List<Shift> shiftList = importGoodsBetweenFromToDate(fromToDate, history);
        this.view.showImportGoodsHistory(new History(shiftList));
        this.view.showImportGoodsHistory(makeHistoryImportGoodsList(shiftList));
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

    private void statisticOfShiftGoods(History history, Store store) {
        CustomPair<LocalDate, LocalDate> fromToDate = this.view.typeInFromToDate();
        List<Shift> shiftList = shiftBetweenFromToDate(fromToDate, history);
        this.view.showShiftHistory(new History(shiftList), store);
    }

    //function 4
    private void searchOrderInDetail(History history, Store store){
        Order searchingOrder = searchOrder(history);
        if(searchingOrder != null){
            this.view.showAnOrderInDetail(searchingOrder, store);
            GoodsList<Goods> orderGoodsList = new GoodsList(searchingOrder.getList());
            goodsListCtr.getView().showGoodsList(orderGoodsList);
        }
    }
    
    private void searchImportGoodsInDetail(History history){
        ImportedGoods searchingImportGoods = searchImportGoods(history);
        if(searchingImportGoods != null){
            this.view.showAnImpotedGoodsInDetail(searchingImportGoods);
        }
    }
    
    private void searchShiftInDetail(History history, Store store){
        Shift searchingShift = searchShift(history);
        if(searchingShift != null){
            this.view.showAnShiftInDetail(searchingShift, store);
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

    public ImportedGoods containImportedGoods(String ID, History history) {
        for (Shift shift : history.getShiftHistory()) {
            for (ImportedGoods importGoods : shift.getImportGoodsHis().getList()) {
                if (importGoods.getID().equals(ID)) {
                    return importGoods;
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
    
    public ImportedGoods searchImportGoods(History history) {
        // tra ve null neu nguoi dung nhap 'back', nguoc lai, tra ve 1 importGoods duoc tim kiem
        if (history.getShiftHistory().isEmpty()) {
            System.out.println("Cannot search in an empty List!");
            return null;
        }
        String inputStr;
        boolean completed = false;
        ImportedGoods searchingImportGoods = null;
        do {
            try {
                System.out.print("Input goodsID to search or BACK to go back: ");
                inputStr = sc.nextLine();
                if ("back".equalsIgnoreCase(inputStr)) {
                    return null;
                }
                int searchingKey = Integer.parseInt(inputStr);
                searchingImportGoods = containImportedGoods(inputStr, history);
                if (searchingImportGoods == null) {
                    System.out.println("Your input ID doesnt exist.");
                    continue;
                }
                completed = true;
            } catch (NumberFormatException nfe) {
                ctions.wrInput();
            }
        } while (!completed);
        return searchingImportGoods;
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
    
}
