/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controllers;

import Models.*;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author FPTSHOP
 */
public class HistoryController {

    final GoodsListController goodsListCtr = new GoodsListController();
    final OrderController orderCtr = new OrderController();

    public HistoryController() {
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
