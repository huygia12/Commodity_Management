/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controllers;

import Models.CustomerCardList;
import Models.Order;
import Models.Goods;
import Models.GoodsList;
import Models.IDGenerator;
import Models.Shift;
import Models.Shipment;
import Models.Store;
import View.Cautions;
import View.OrderView;
import View.ShipmentView;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
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
    @SerializedName("ctions")
    @Expose
    final Cautions ctions = new Cautions();
    @SerializedName("CURRENT_DATE")
    @Expose
    final LocalDate CURRENT_DATE = LocalDate.now();
    @SerializedName("draftGoodsList")
    @Expose
    private final GoodsList<Goods> draftGoodsList = new GoodsList(new ArrayList<>());
    @SerializedName("repoGoodsList")
    @Expose
    private GoodsList<Goods> repoGoodsList = new GoodsList(new ArrayList<>());
    @SerializedName("view")
    @Expose
    private final OrderView view = new OrderView();
    @SerializedName("order")
    @Expose
    private Order order;

    public OrderController() {
    }
    
    public OrderController(Order order) {
        this.order = order;
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
    
    public void makeNewOrder(GoodsList repoGoodsList, CustomerCardList customerCardList, 
            Store myStore, Shift shift, IDGenerator idGenerator, Scanner sc) {
        this.setOrder(new Order(idGenerator.generateID(Order.class.getName(), 6),
                                myStore.getVAT()));
        this.repoGoodsList = repoGoodsList;
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
                        this.order.addToOrder(draftGoodsList, shipView, view, sc);
                        break;
                    case 2:
                        this.order.editOrder(repoGoodsList, draftGoodsList, shipView, view, sc);
                        break;
                    case 3:
                        if (this.order.payOrder(view,customerCardList, myStore, sc)) {
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
            shift.getOrderHisPerShift().add(this.order);
            updateQuanAfterPay();
        }
    }
}
