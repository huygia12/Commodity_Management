/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controllers;

import Models.CustomerCard;
import Models.CustomerCardList;
import Models.CustomerRank;
import Models.Order;
import Models.Store;
import Ultility.IDGenerator;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.stream.*;

/**
 *
 * @author FPTSHOP
 */
public class CustomerCardController {
    
    public CustomerCardController() {
    }

    public CustomerCard cloneCustomerCard(CustomerCard customerCard) {
        CustomerCard cloneCard = new CustomerCard();
        cloneCard.setCustomer(new CustomerController().cloneCustomer(customerCard.getCustomer()));
        cloneCard.setID(customerCard.getID());
        cloneCard.setPoint(customerCard.getPoint());
        cloneCard.setIDOfBoughtOrders(customerCard.getIDOfBoughtOrders()
                .stream()
                .map(x -> x)
                .collect(Collectors.toList()));
        return cloneCard;
    }

    public void gainPoint(CustomerCard custmomerCard, BigDecimal totalPayment, Store store) {
        custmomerCard.setPoint(custmomerCard
                .getPoint()
                .add(totalPayment.toBigInteger()
                        .divide(store.getAmountForOnePoint().toBigInteger())));
    }

    public BigDecimal convertPointToMoney(CustomerCard custmomerCard, BigInteger inputPoint, Store store) {
        if (inputPoint.compareTo(BigInteger.ZERO) <= 0) {
            return BigDecimal.ZERO;
        }
        if (inputPoint.compareTo(custmomerCard
                .getPoint()) >= 0) {
            inputPoint = custmomerCard.getPoint();
        }
        return new BigDecimal(inputPoint
                .divide(store.getPointsForOneVND())
                .multiply(new BigInteger("1000")));
    }

    public void usePoint(CustomerCard customerCard, BigInteger usedPoint){
        customerCard.setPoint(customerCard.getPoint().subtract(usedPoint));
    }
    
    public void updateRank(CustomerCard customerCard, Store store){
        HistoryController hisCtr = new HistoryController();
        OrderController orderCtr = new OrderController();
        BigDecimal total = BigDecimal.ZERO;
        for (String orderID : customerCard.getIDOfBoughtOrders()) {
            Order order = hisCtr.containOrder(orderID,store.getHistory());
            total = total.add(orderCtr.getTotal(order, store));
        }
        
        if(total.compareTo(store.getBronzeDiscountOffer().getK())>=0){
            customerCard.setRank(CustomerRank.BRONZE);
        }
        if(total.compareTo(store.getSilverDiscountOffer().getK())>=0){
            customerCard.setRank(CustomerRank.SILVER);
        }
        if(total.compareTo(store.getGoldDiscountOffer().getK())>=0){
            customerCard.setRank(CustomerRank.GOLD);
        }
        if(total.compareTo(store.getDiamondDiscountOffer().getK())>=0){
            customerCard.setRank(CustomerRank.DIAMOND);
        }
    }
    
    public Double getCustomerDiscountOffer(CustomerCard customerCard, Store store){
        Double discountOffer = 0d;
        if(customerCard.getRank().equals(CustomerRank.BRONZE)){
            discountOffer = store.getBronzeDiscountOffer().getV();
        }
        if(customerCard.getRank().equals(CustomerRank.SILVER)){
            discountOffer = store.getSilverDiscountOffer().getV();
        }
        if(customerCard.getRank().equals(CustomerRank.GOLD)){
            discountOffer = store.getGoldDiscountOffer().getV();
        }
        if(customerCard.getRank().equals(CustomerRank.DIAMOND)){
            discountOffer = store.getDiamondDiscountOffer().getV();
        }
        return discountOffer;
    } 
}
