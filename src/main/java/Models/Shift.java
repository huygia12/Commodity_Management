/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Models;

import View.ShiftView;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Stack;

/**
 *
 * @author FPTSHOP
 */
public class Shift {

    private Stack<Order> orderHisPerShift;
    private Stack<ImportedGoods> importGoodsHis;
    private String startDateTime = null;
    private String endDateTime = null;
    private String ID;
    private BigDecimal openingBalance;
    private BigDecimal shippingFee;
    private EmployeeList employeeList;
    private Employee cashier;

    public Shift() {
    }

    public Shift(Stack<Order> orderHisPerShift, Stack<ImportedGoods> importGoodsHis, BigDecimal openingBalance, EmployeeList employeeList, Employee cashier) {
        this.orderHisPerShift = orderHisPerShift;
        this.importGoodsHis = importGoodsHis;
        this.openingBalance = openingBalance;
        this.employeeList = employeeList;
        this.cashier = cashier;
        this.startDateTime = LocalDateTime.now()
                .format(DateTimeFormatter.ofPattern("HH:mm:ss dd/MM/yyyy"));
    }

    public Stack<Order> getOrderHisPerShift() {
        return orderHisPerShift;
    }

    public Stack<ImportedGoods> getImportGoodsHis() {
        return importGoodsHis;
    }

    public String getStartTime() {
        return startDateTime;
    }

    public void setStartTime() {
        this.startDateTime = LocalDateTime.now()
                .format(DateTimeFormatter.ofPattern("HH:mm:ss"));
    }

    public String getEndTime() {
        return endDateTime;
    }

    public void setEndTime(String endTime) {
        this.endDateTime = LocalDateTime.now()
                .format(DateTimeFormatter.ofPattern("HH:mm:ss"));
    }

    public String getID() {
        return ID;
    }

    public void setID(String ID) {
        this.ID = ID;
    }

    public BigDecimal getOpeningBalance() {
        return openingBalance;
    }

    public void setOpeningBalance(BigDecimal openingBalance) {
        this.openingBalance = openingBalance;
    }

    public BigDecimal getTransportFee() {
        return shippingFee;
    }

    public void setTransportFee(BigDecimal transportFee) {
        this.shippingFee = transportFee;
    }

    public EmployeeList getEmployeeList() {
        return employeeList;
    }

    public void setEmployeeList(EmployeeList employeeList) {
        this.employeeList = employeeList;
    }

    public Employee getCashier() {
        return cashier;
    }

    public void setCashier(Employee cashier) {
        this.cashier = cashier;
    }

    public boolean orderOnSameDay(Order newOrder) {
        LocalDateTime date1 = LocalDateTime.parse(this.orderHisPerShift.peek().getInVoiceDateTime(),
                DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss"));
        LocalDateTime date2 = LocalDateTime.parse(newOrder.getInVoiceDateTime(),
                DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss"));
        return date1.getDayOfMonth() == date2.getDayOfMonth()
                && date1.getMonth() == date2.getMonth()
                && date1.getYear() == date2.getYear();
    }

    public boolean importGoodsOnSameDay(ImportedGoods newImportGoods) {
        LocalDateTime date1 = LocalDateTime.parse(this.importGoodsHis.peek().getImportDateTime(),
                DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss"));
        LocalDateTime date2 = LocalDateTime.parse(newImportGoods.getImportDateTime(),
                DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss"));
        return date1.getDayOfMonth() == date2.getDayOfMonth()
                && date1.getMonth() == date2.getMonth()
                && date1.getYear() == date2.getYear();
    }

    
    public void openShift(ShiftView shiftView, EmployeeList originEmployeeList) {
        if (this.endDateTime == null) {
            shiftView.shiftNotEndCaution();
            return;
        }
        int n = 1;
        int nextProcess;
        while (n != 3) {
            switch (n) {
                case 1:
                    nextProcess = shiftView.typeInOpeningBalance(this);
                    if (nextProcess == 0 || nextProcess == -1) {
                        return;
                    }
                    break;
                case 2:
                    nextProcess = shiftView.typeInEmployeeList(this, originEmployeeList);
                    if (nextProcess == 0) {
                        return;
                    } else if (nextProcess == -1) {
                        break;
                    }
                    break;
                case 3:
                    nextProcess = shiftView.typeInCashier(this);
                    break;
            }
        }
    }
    
    
}
