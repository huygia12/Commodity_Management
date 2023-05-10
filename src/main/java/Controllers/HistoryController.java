/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controllers;

import Models.CustomPair;
import Models.Goods;
import Models.GoodsList;
import Models.History;
import Models.ImportedGoods;
import Models.Order;
import Models.Shift;
import Models.SoldGoods;
import View.Cautions;
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

    final Cautions ctions = new Cautions();
    final Scanner sc = new Scanner(System.in);
    private final HistoryView view = new HistoryView();
    private History history;

    public HistoryController(History history) {
        this.history = history;
    }

    public History getHistory() {
        return history;
    }

    public void setHistory(History history) {
        this.history = history;
    }

    public HistoryView getHistoryView() {
        return this.view;
    }

    //function 1
    public GoodsList<SoldGoods> makeHisoryOrderGoodsList(List<Shift> shiftList) {
        GoodsList<SoldGoods> soldGoodsList = new GoodsList();
        Set<String> IDBucket = new HashSet<>();
        SoldGoods soldGoods = new SoldGoods();
        for (Shift shift : shiftList) {
            for (Order order : shift.getOrderHisPerShift()) {
                for (Goods goods : order.getGoodsList()) {
                    if (IDBucket.contains(goods.getID())) {
                        soldGoods = soldGoodsList.containGoods(goods.getID());
                        // set gia da ban cho khach hang 
                        soldGoods.setSoldPrice(order.getVAT(), order.getDiscount());
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
                        soldGoods.setSoldPrice(order.getVAT(), order.getDiscount());
                        // set tong tien cua san pham da ban
                        soldGoods.setTotalAmountSold(soldGoods.getSoldPrice()
                                .multiply(soldGoods.getTotalQuantity()));
                        // them vao danh sach cac san pham da ban
                        soldGoodsList.getGoodsList().add(soldGoods);
                        // them id cua soldGoods da ton tai vao trong idbucket
                        IDBucket.add(goods.getID());
                    }
                }
            }
        }
        return soldGoodsList;
    }

    private List<Shift> ordersBetweenFromToDate(CustomPair<LocalDate, LocalDate> fromToDate) {
        List<Shift> shiftList = new ArrayList<>();
        for (Shift shift : this.history.getShiftHistory()) {
            Shift tempShift = new Shift();
            for (Order order : shift.getOrderHisPerShift()) {
                LocalDate orderDateTime = LocalDate
                        .parse(order.getOrderDateTime(),
                                DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss"));
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

    private void statisticOfOrder() {
        this.view.showOrderHistory(this.history);
        CustomPair<LocalDate, LocalDate> fromToDate = this.view.typeInFromToDate();
        // Nhat tat ca order nam trong khoang fromToDate de cho vao shiftList
        List<Shift> shiftList = ordersBetweenFromToDate(fromToDate);
        // Hien thi cac thong tin co ban cua cac order do: orderID, shiftID, orderDateTime, orderTotal
        this.view.showOrderHistory(new History(shiftList));
        // Hien thi thong ke so luong va so tien cua tung mat hang duoc ban
        this.view.showOrderHistory(makeHisoryOrderGoodsList(shiftList));
    }

    //function 2
    public GoodsList<ImportedGoods> makeHistoryImportGoodsList(List<Shift> shiftList) {
        GoodsList<ImportedGoods> importGoodsList = new GoodsList();
        Set<String> IDBucket = new HashSet<>();
        ImportedGoods tmpImportGoods = new ImportedGoods();
        for (Shift shift : shiftList) {
            for (ImportedGoods importGoods : shift.getImportGoodsHis().getGoodsList()) {
                if (IDBucket.contains(importGoods.getID())) {
                    tmpImportGoods = importGoodsList.containGoods(importGoods.getID());
                    // tang so luong vao tong so luong
                    tmpImportGoods.setTotalQuantity(tmpImportGoods.getTotalQuantity()
                            .add(importGoods.getTotalQuanByShipments()));
                    // tang tong tien nhap hang cua san pham do
                    tmpImportGoods.setTotalAmountImport(importGoods.getShipments().get(0).getImportPrice()
                            .multiply(importGoods.getTotalQuanByShipments())
                            .add(tmpImportGoods.getTotalAmountImport()));
                } else {
                    tmpImportGoods = importGoods.cloneImportGoods();
                    // set so luong cua san pham nhap
                    tmpImportGoods.setTotalQuantity(tmpImportGoods.getTotalQuanByShipments());
                    // set tong tien cua san pham da nhap
                    tmpImportGoods.setTotalAmountImport(
                            importGoods.getShipments().get(0).getImportPrice()
                                    .multiply(importGoods.getTotalQuanByShipments()));
                    // them vao danh sach cac san pham da nhap
                    importGoodsList.getGoodsList().add(tmpImportGoods);
                    // them id cua importGoods da ton tai vao trong idbucket
                    IDBucket.add(importGoods.getID());
                }
            }
        }
        return importGoodsList;
    }

    private List<Shift> importGoodsBetweenFromToDate(CustomPair<LocalDate, LocalDate> fromToDate) {
        List<Shift> shiftList = new ArrayList<>();
        for (Shift shift : this.history.getShiftHistory()) {
            Shift tempShift = new Shift();
            for (ImportedGoods importGoods : shift.getImportGoodsHis().getGoodsList()) {
                LocalDate importDateTime = LocalDate
                        .parse(importGoods.getImportDateTime(),
                                DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss"));
                // Neu importGoods nam trong khoang cua fromToDate thi them vao tempShift
                if ((importDateTime.isAfter(fromToDate.getK())
                        && importDateTime.isBefore(fromToDate.getV()))
                        || importDateTime.isEqual(fromToDate.getK())
                        || importDateTime.isEqual(fromToDate.getV())) {
                    tempShift.getImportGoodsHis().getGoodsList().add(importGoods);
                }
            }
            if (!tempShift.getImportGoodsHis().getGoodsList().isEmpty()) {
                tempShift.setID(shift.getID());
                shiftList.add(tempShift);
            }
        }
        return shiftList;
    }

    private void statisticOfImportGoods() {
        this.view.showImportGoodsHistory(this.history);
        CustomPair<LocalDate, LocalDate> fromToDate = this.view.typeInFromToDate();
        List<Shift> shiftList = importGoodsBetweenFromToDate(fromToDate);
        this.view.showImportGoodsHistory(new History(shiftList));
        this.view.showImportGoodsHistory(makeHistoryImportGoodsList(shiftList));
    }

    //function 3
    private List<Shift> shiftBetweenFromToDate(CustomPair<LocalDate, LocalDate> fromToDate) {
        List<Shift> shiftList = new ArrayList<>();
        for (Shift shift : this.history.getShiftHistory()) {
            LocalDate importDateTime = LocalDate
                    .parse(shift.getOpenTime(),
                            DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss"));
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

    private void statisticOfShiftGoods() {
        CustomPair<LocalDate, LocalDate> fromToDate = this.view.typeInFromToDate();
        List<Shift> shiftList = shiftBetweenFromToDate(fromToDate);
        this.view.showShiftHistory(new History(shiftList));
    }

    //function 4
    private void searchOrderInDetail(){
        Order searchingOrder = this.history.searchOrder();
        if(searchingOrder != null){
            this.view.showAnOrderInDetail(searchingOrder);
            GoodsList<Goods> orderGoodsList = new GoodsList(searchingOrder.getGoodsList());
            orderGoodsList.showGoodsList();
        }
    }
    
    private void searchImportGoodsInDetail(){
        ImportedGoods searchingImportGoods = this.history.searchImportGoods();
        if(searchingImportGoods != null){
            this.view.showAnImpotedGoodsInDetail(searchingImportGoods);
        }
    }
    
    private void searchShiftInDetail(){
        Shift searchingShift = this.history.searchShift();
        if(searchingShift != null){
            this.view.showAnShiftInDetail(searchingShift);
        }
    }
    
    public void historyManagement() {
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
                        statisticOfOrder();
                        break;
                    case 2:
                        statisticOfImportGoods();
                        break;
                    case 3:
                        statisticOfShiftGoods();
                        break;
                    case 4:
                        searchOrderInDetail();
                        break;
                    case 5:
                        searchImportGoodsInDetail();
                        break;
                    case 6:
                        searchShiftInDetail();
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
}
