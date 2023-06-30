/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controllers;

import Ultility.IDGenerator;
import Models.*;
import View.OrderView;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.stream.*;

/**
 *
 * @author FPTSHOP
 */
public class OrderController extends GoodsListController {

    private final OrderView view = new OrderView();
    final LocalDate CURRENT_DATE = LocalDate.now();
    private final GoodsList<Goods> draftGoodsList = new GoodsList(new ArrayList<>());
    private final ShipmentController shipmentCtr = new ShipmentController();
    private final CustomerCardController cardCtr = new CustomerCardController();

    public OrderController() {
    }

    public OrderView getOrderView() {
        return this.view;
    }

    public BigDecimal getSubTotal(Order order) {
        // tong tien khi chua qua discount va VAT
        BigDecimal result = BigDecimal.ZERO;
        for (Goods goods : order.getList()) {
            result = result.add(goods.getListPrice()
                    .multiply(goodsCtr.getTotalQuanByShipments(goods)));
        }
        return result;
    }

    public BigDecimal getTaxAmount(Order order) {
        // tong tien phi VAT cho ca hoa don
        return getSubTotal(order).multiply(new BigDecimal(order.getTax() * 1.0 / 100));
    }

    public BigDecimal getTotal(Order order, Store store) {
        // Khoan tien can thanh toan khi da tru di discount va cong them VAT
        BigDecimal total = (getSubTotal(order)
                .add(getTaxAmount(order)))
                .multiply(new BigDecimal(1.0 - order.getDiscount() * 1.0 / 100))
                .add(order.getShippingFee());
        if(order.getCustomerCard()!=null){
            Double customerDisOffer = (100f - cardCtr
                    .getCustomerDiscountOffer(order.getCustomerCard(), store))/100;
            total = total.subtract(getPointDiscountAmount(order, store));
            total = total.multiply(new BigDecimal(customerDisOffer));
        }
        return total;
    }

    public BigDecimal getDiscountAmount(Order order) {
        // tong tien giam gia 
        return (getSubTotal(order).add(getTaxAmount(order)))
                .multiply(new BigDecimal(order.getDiscount() * 1.0 / 100));
    }

    public BigDecimal getChange(Order order, Store store) {
        return order.getCusMoney().subtract(getTotal(order, store));
    }

    public BigDecimal getPointDiscountAmount(Order order, Store store) {
        return (order.getCustomerCard() == null) ? BigDecimal.ZERO : cardCtr
                .convertPointToMoney(order.getCustomerCard(), 
                        order.getPointDiscount(), store);
    }

    public GoodsList<Goods> makeDraftGoodsList(GoodsList<Goods> repoGoodsList) {
        // tao mot ban cpy cua repositoryGoodsList la draftGoodsList
        draftGoodsList.setGoodsList(repoGoodsList.getList()
                .stream()
                .map(x -> goodsCtr.cloneGoods(x))
                .collect(Collectors.toList()));
        // draftGoodsList chi duoc phep chua nhung Shipment con hsd
        for (Goods draftGoods : draftGoodsList.getList()) {
            draftGoods.setShipments(draftGoods.getShipments()
                    .stream()
                    .filter(x -> x.getHsd().isAfter(this.CURRENT_DATE))
                    .collect(Collectors.toList()));
        }
        // draftGoodsList chi duoc phep chua Goods van con shipment
        draftGoodsList.setGoodsList(draftGoodsList.getList()
                .stream()
                .filter(x -> !x.getShipments().isEmpty())
                .collect(Collectors.toList()));
        return draftGoodsList;
    }

    private void updateQuanAfterPay(GoodsList<Goods> repoGoodsList, Order order) {
        // cap nhat lai so luong neu pay thanh cong
        for (Goods orderGoods : order.getList()) {
            Goods repoGoods = containGoods(repoGoodsList, orderGoods.getID());
            for (Shipment orderShipment : orderGoods.getShipments()) {
                Shipment repoShipment = goodsCtr.containShipment(repoGoods.getShipments(), orderShipment.getID());
                BigDecimal quanBefore = repoShipment.getQuantity();
                repoShipment.setQuantity(quanBefore.subtract(orderShipment.getQuantity()));
            }
        }
    }

    public Order makeNewOrder(Shift shift, IDGenerator idGenerator) {
        Order order = new Order(idGenerator.generateID(Order.class.getName(), 6));
        order.setCashier(shift.getCashier());
        order.setTax(shift.getTax());
        order.setPaymentOptions(PaymentOptions.CASH_PAYMENT);
        return order;
    }

    public int addToOrder(GoodsList<Goods> draftGoodsList, Order order, String strQuantity, String goodsID, String shipmentID) {
        int choice = 0;
        Goods addedGoods = containGoods(draftGoodsList, goodsID);
        Shipment addedShipment = goodsCtr.containShipment(addedGoods.getShipments(), shipmentID);

        BigDecimal quantity = new BigDecimal(strQuantity);
        Shipment cloneShipment = shipmentCtr.cloneShipment(addedShipment);
        cloneShipment.setQuantity(quantity);
        Goods existedGoods = containGoods(order, goodsID);
        // nếu order chưa tồn tại sản phẩm này : 0
        if (existedGoods == null) {
            Goods cloneGoods = goodsCtr.cloneGoods(addedGoods);
            cloneGoods.getShipments().clear();
            cloneGoods.getShipments().add(cloneShipment);
            order.getList().add(cloneGoods);
        } else {
            Shipment existedShipment = goodsCtr
                    .containShipment(existedGoods.getShipments(), shipmentID);
            // nếu shipment đã tồn tại thì cộng số lượng vào số lượng đã có : 1
            if (existedShipment != null) {
                existedShipment
                        .setQuantity(existedShipment.getQuantity()
                                .add(cloneShipment.getQuantity()));
                choice = 1;
            } else {
                // Nếu shipment chưa tồn tại thì thêm cả shipment vào order : 2
                existedGoods.getShipments().add(cloneShipment);
                choice = 2;
            }
        }
        // sau khi them goods vao order, giam so luong goods do torng draftGoodsList
        BigDecimal quantityBefore = addedShipment.getQuantity();
        addedShipment.setQuantity(quantityBefore.subtract(quantity));
        return choice;
    }

    public void deleteFromOrder(GoodsList<Goods> repoGoodsList, GoodsList<Goods> draftGoodsList, Order order, String shipmentID, String goodsID) {
        Goods selectedGoods = containGoods(order, goodsID);
        Shipment deletedShipment = goodsCtr.containShipment(selectedGoods.getShipments(), shipmentID);
        selectedGoods.getShipments().remove(deletedShipment);
        if (selectedGoods.getShipments().isEmpty()) {
            order.getList().remove(selectedGoods);
        }
        // trả lại số lượng cho draftGoodsList sau khi xóa 
        BigDecimal originQuan = goodsCtr
                .containShipment(containGoods(repoGoodsList, goodsID).getShipments(),
                        shipmentID)
                .getQuantity();
        goodsCtr.containShipment(containGoods(draftGoodsList, goodsID).getShipments(),
                shipmentID)
                .setQuantity(originQuan);
    }

    public void resetOrder(GoodsList<Goods> draftGoodsList, Order order) {
        for (Goods goods : order.getList()) {
            for (Shipment shipment : goods.getShipments()) {
                Shipment shipmentInDraftGoodsList = goodsCtr
                        .containShipment(containGoods(draftGoodsList, goods.getID()).getShipments(),
                        shipment.getID());
                BigDecimal originQuan = shipment.getQuantity().add(shipmentInDraftGoodsList.getQuantity());
                shipmentInDraftGoodsList.setQuantity(originQuan);
            }
        }
        order.getList().clear();
    }

    public void editOrder(GoodsList<Goods> draftGoodsList, Order order,
            Shipment remainShipment, Goods editedGoods, Shipment editedShipment,
            BigDecimal quantityBefore, BigDecimal quantityAfter, BigDecimal quantityRemain) {
        if (quantityAfter.compareTo(quantityBefore) > 0) {// nếu số lượng mới nhiều hơn số lượng cũ
            remainShipment.setQuantity(quantityRemain
                    .subtract(quantityAfter.subtract(quantityBefore)));
        } else {// nếu số lượng mới ít hơn số lượng cũ
            remainShipment.setQuantity(quantityRemain
                    .add(quantityBefore.subtract(quantityAfter)));
        }
        if (quantityAfter.compareTo(BigDecimal.ZERO) != 0) {// nếu số lượng mới != 0 thì thay đổi
            editedShipment.setQuantity(quantityAfter);
        } else {// nếu số lượng mới == 0 thì xóa khỏi order
            editedGoods.getShipments().remove(editedShipment);
            if (editedGoods.getShipments().isEmpty()) {
                order.getList().remove(editedGoods);
            }
        }
    }

    public void payOrder(Order order,Shift shift, Store store) {
        CustomerCard card = order.getCustomerCard();
        if (card != null) {
            cardCtr.gainPoint(card, getTotal(order, store), store);
            cardCtr.usePoint(card, order.getPointDiscount());
            cardCtr.updateRank(card, store);
            card.setUsedPoint(order.getPointDiscount().add(card.getUsedPoint()));
            card.getIDOfBoughtOrders().add(order.getID());
        }
        order.setOrderDateTime();
        shift.getOrderHisPerShift().add(order);
        updateQuanAfterPay(store.getRepository(), order);
    }
}
