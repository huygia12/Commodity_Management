/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controllers;

import gui.ShiftView;
import Models.*;
import View.ShiftView;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.List;

/**
 *
 * @author FPTSHOP
 */
public class ShiftController {

    private final ShiftView shiftView = new ShiftView();
    final OrderController orderCtr = new OrderController();

    public ShiftController() {
    }

    public ShiftView getView() {
        return this.shiftView;
    }


    public BigDecimal getTotalDiscountMoney(Shift shift) {
        BigDecimal result = BigDecimal.ZERO;
        for (Order order : shift.getOrderHisPerShift()) {
            result = result.add(orderCtr.getDiscountAmount(order));
        }
        return result;
    }

    public BigDecimal getTotalPaymentByCash(Shift shift, Store store) {
        BigDecimal result = BigDecimal.ZERO;
        for (Order order : shift.getOrderHisPerShift()) {
            if (order.getPaymentOptions().equals(PaymentOptions.CASH_PAYMENT)) {
                result = result.add(orderCtr.getTotal(order, store));
            }
        }
        return result;
    }

    public BigDecimal getTotalPaymentByWireTransfer(Shift shift, Store store) {
        BigDecimal result = BigDecimal.ZERO;
        for (Order order : shift.getOrderHisPerShift()) {
            if (order.getPaymentOptions().equals(PaymentOptions.OTHER_PAYMENT)) {
                result = result.add(orderCtr.getTotal(order, store));
            }
        }
        return result;
    }

    public BigDecimal getTotalVAT(Shift shift) {
        BigDecimal result = BigDecimal.ZERO;
        for (Order order : shift.getOrderHisPerShift()) {
            result = result.add(orderCtr.getTaxAmount(order));
        }
        return result;
    }

    public long getNumberOfOrder(Shift shift) {
        return shift.getOrderHisPerShift().size();
    }

    public BigDecimal getAveragePerOrder(Shift shift, Store store) {
        if (getNumberOfOrder(shift) == 0) {
            return BigDecimal.ZERO;
        }
        return getNetRevenue(shift, store).divide(new BigDecimal(getNumberOfOrder(shift)+""), 2 , RoundingMode.HALF_UP);
    }

    public BigDecimal getTotalQuanOfThisShift(Shift shift) {
        BigDecimal result = BigDecimal.ZERO;
        for (Order order : shift.getOrderHisPerShift()) {
            for (Goods goods : order.getList()) {
                result = result.add(goods.getTotalQuantity());
            }
        }
        return result;
    }

    public Order containOrder(List<Order> orderList, String orderID) {
        for (Order order : orderList) {
            if (order.getID().equals(orderID)) {
                return order;
            }
        }
        return null;
    }

    public void openShift(Store store, Shift shift, 
            int tax, BigDecimal openBalance, 
            Employee cashier, EmployeeList employeeList,
            String note) {
        shift.setState(ShiftState.OPENED);
        shift.setID(store.getiDGenerator().generateID(Shift.class.getName(), 6));
        shift.setOpenTime();
        shift.setTax(tax);
        shift.setOpeningBalance(openBalance);
        shift.setCashier(cashier);
        shift.setEmployeeOfThisShift(employeeList);
        shift.setNote(note);
        store.getHistory().getShiftHistory().add(shift);
    }
    
    public void endShift(Shift shift, String note, BigDecimal surcharge) {
        shift.setEndTime();
        shift.setNote(note);
        shift.setSurcharge(surcharge);
        shift.setState(ShiftState.CLOSED);
    }
}
