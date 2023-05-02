/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Models;

import View.ShiftView;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Stack;

/**
 *
 * @author FPTSHOP
 */
public class Shift {
    private Stack<Order> orderHisPerShift;
    private Stack<ImportedGoods> importGoodsHis;
    private String date;
    private String startTime = null;
    private String endTime = null;
    private String ID;
    private BigDecimal openingBalance;
    private BigDecimal transportFee;
    private int VAT;
    private List<Employee> employee;
    
    
    public Shift(){}
    
    public Shift(Stack<ImportedGoods> shipmentHistory, Stack<Order> orderHistory) {
        this.orderHisPerShift = orderHistory;
        this.importGoodsHis = shipmentHistory;
        this.date = LocalDateTime.now()
                .format(DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss"));
    }

    public String getDate(){
        return this.date;
    }

    public Stack<Order> getOrderHisPerShift() {
        return orderHisPerShift;
    }

    public Stack<ImportedGoods> getImportGoodsHis() {
        return importGoodsHis;
    }

    public String getStartTime() {
        return startTime;
    }

    public void setStartTime(String startTime) {
        this.startTime = startTime;
    }

    public String getEndTime() {
        return endTime;
    }

    public void setEndTime(String endTime) {
        this.endTime = endTime;
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
        return transportFee;
    }

    public void setTransportFee(BigDecimal transportFee) {
        this.transportFee = transportFee;
    }

    public int getVAT() {
        return VAT;
    }

    public void setVAT(int VAT) {
        this.VAT = VAT;
    }

    public List<Employee> getEmployee() {
        return employee;
    }

    public void setEmployee(List<Employee> employee) {
        this.employee = employee;
    }

    
    public boolean orderOnSameDay (Order newOrder){
        LocalDateTime date1 = LocalDateTime.parse(this.orderHisPerShift.peek().getInVoiceDateTime(), 
                DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss"));
        LocalDateTime date2 = LocalDateTime.parse(newOrder.getInVoiceDateTime(), 
                DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss"));
        return date1.getDayOfMonth() == date2.getDayOfMonth() 
                && date1.getMonth() == date2.getMonth() 
                && date1.getYear() == date2.getYear();
    }
    
    public boolean importGoodsOnSameDay(ImportedGoods newImportGoods){
        LocalDateTime date1 = LocalDateTime.parse(this.importGoodsHis.peek().getImportDateTime(), 
                DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss"));
        LocalDateTime date2 = LocalDateTime.parse(newImportGoods.getImportDateTime(), 
                DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss"));
        return date1.getDayOfMonth() == date2.getDayOfMonth() 
                && date1.getMonth() == date2.getMonth() 
                && date1.getYear() == date2.getYear();
    }
    
    
    public void openShift(ShiftView shiftView){
        if(this.endTime == null){
            shiftView.shiftNotEndCaution();
            return;
        }
        int n = 1;
        switch(n){
            case 1:
            case 2:
                
        }
    }
}
