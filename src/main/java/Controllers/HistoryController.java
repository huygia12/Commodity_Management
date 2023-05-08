/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controllers;

import Models.CustomPair;
import Models.Goods;
import Models.GoodsList;
import Models.History;
import Models.Order;
import Models.Shift;
import View.Cautions;
import View.HistoryView;
import java.time.LocalDate;
import java.time.LocalDateTime;
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

    private GoodsList makeDetailOrderHistoryGoodsList(List<Shift> shiftList){
        GoodsList goodsList = new GoodsList();
        Set<String> IDBucket = new HashSet<>();
        Goods tmpGoods = null;
        for (Shift shift : shiftList) {
            for (Order order : shift.getOrderHisPerShift()) {
                for (Goods goods : order.getGoodsList()) {
                    if(IDBucket.contains(goods.getID())){
                        tmpGoods = goodsList.containGoods(goods.getID());
                        tmpGoods.setTotalQuantity(tmpGoods.getTotalQuantity()
                                .add(goods.getTotalQuantity()));
                    }else{
                        tmpGoods = goods.cloneGoods();
                        goodsList.getGoodsList().add(tmpGoods);
                        IDBucket.add(goods.getID());
                    }
                }
            }
        }
        return goodsList;
    }
    
    private List<Shift> makeListOfShiftBetweenFromToDate(CustomPair<LocalDate, LocalDate> fromToDate){
        List<Shift> shiftList = new ArrayList<>();
        for (Shift shift : this.history.getShiftHistory()) {
            Shift tempShift = new Shift();
            for (Order order : shift.getOrderHisPerShift()) {
                LocalDate orderDateTime = LocalDate
                        .parse(order.getOrderDateTime(),
                                DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss"));
                // Neu order nam trong khoang cua fromToDate thi them vao tmp
                if (orderDateTime.isAfter(fromToDate.getK())
                        && orderDateTime.isBefore(fromToDate.getV())) {
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
    
    public void statisticOfOrder() {
        CustomPair<LocalDate, LocalDate> fromToDate = this.view.typeInFromToDate();
        List<Shift> shiftList = makeListOfShiftBetweenFromToDate(fromToDate);
        this.view.showOrderHistory(new History(shiftList));
        this.view.showDetailInOrderHistory(makeDetailOrderHistoryGoodsList(shiftList));
    }

    public void historyManagement() {
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

                        break;
                    case 3:

                        break;
                    case 4:

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
}
