/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controllers;

import Models.Order;
import Models.Goods;
import Models.GoodsList;
import Models.Shipment;
import View.Cautions;
import View.OrderView;
import View.ShipmentView;
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
public class OrderController {
    
    final Scanner sc = new Scanner(System.in);
    final Cautions ctions = new Cautions();
    final LocalDate CURRENT_DATE = LocalDate.now();
    private final GoodsList draftGoodsList = new GoodsList(new ArrayList<>());
    private GoodsList repoGoodsList = new GoodsList(new ArrayList<>());
    private final OrderView view = new OrderView();
    private Order order;

    public OrderController(Order order, GoodsList repoGoodsList) {
        this.order = order;
        this.repoGoodsList = repoGoodsList;
    }

    public Order getOrder() {
        return order;
    }

    public void setOrder(Order order) {
        this.order = order;
    }
    
    public OrderView getOrderView(){
        return this.view;
    }
    
    private void makeDraftGoodsList(){
        draftGoodsList.setGoodsList(repoGoodsList.getGoodsList()
                .stream()
                .map(x -> x.cloneGoods())
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
    }
    
    private void updateQuanAfterPay(){
        // cap nhat lai so luong neu pay thanh cong
        for (Goods orderGoods : this.order.getGoodsList()) {
            Goods repoGoods = this.repoGoodsList.containGoods(orderGoods.getID());
            for (Shipment orderShipment : orderGoods.getShipments()) {
                Shipment repoShipment = repoGoods.containShipment(orderShipment.getID());
                BigDecimal quanBefore = repoShipment.getQuantity();
                repoShipment.setQuantity(quanBefore.subtract(orderShipment.getQuantity()));
            }
        }
    }
    
    public boolean makeNewOrder() {
        // tao mot ban cpy cua repositoryGoodsList la draftGoodsList
        makeDraftGoodsList();
        ShipmentView shipView = new ShipmentView();
        int choice;
        boolean completed = false;
        do {
            try {
                this.view.orderMenu();
                choice = sc.nextInt();
                sc.nextLine();
                switch (choice) {
                    case 1:
                        this.order.addToOrder(draftGoodsList, shipView, view);
                        break;
                    case 2:
                        this.order.editOrder(repoGoodsList, draftGoodsList, shipView, view);
                        break;
                    case 3:
                        if (this.order.payOrder(view)) {
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
        if(completed){
            updateQuanAfterPay();
        }
        return completed;
    }
}
