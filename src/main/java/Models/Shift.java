/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Models;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Stack;

/**
 *
 * @author FPTSHOP
 */
public class Shift {
    private Stack<Order> orderHistoryPerDay = new Stack<>();
    private Stack<ImportedGoods> importGoodsHistory = new Stack<>();
    private String date;
    private String startTime;
    private String endTime;
    private String ID;
    private BigDecimal openingBalance;
    private BigDecimal transportFee;
    private int VAT;
    
    
    public Shift(){}
    
    public Shift(Stack<ImportedGoods> shipmentHistory, Stack<Order> orderHistory) {
        this.orderHistoryPerDay = orderHistory;
        this.importGoodsHistory = shipmentHistory;
        this.date = LocalDateTime.now()
                .format(DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss"));
    }

    public Stack<Order> getOrderHistory() {
        return orderHistoryPerDay;
    }

    public void setOrderHistory(Stack<Order> orderHistory) {
        this.orderHistoryPerDay = orderHistory;
    }

    public Stack<ImportedGoods> getShipmentHistory() {
        return importGoodsHistory;
    }

    public void setShipmentHistory(Stack<ImportedGoods> shipmentHistory) {
        this.importGoodsHistory = shipmentHistory;
    }
    
    public String getDate(){
        return this.date;
    }
    
    
    public boolean orderInSameDay (Order newOrder){
        LocalDateTime date1 = LocalDateTime.parse(this.orderHistoryPerDay.peek().getInVoiceDateTime(), 
                DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss"));
        LocalDateTime date2 = LocalDateTime.parse(newOrder.getInVoiceDateTime(), 
                DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss"));
        return date1.getDayOfMonth() == date2.getDayOfMonth() 
                && date1.getMonth() == date2.getMonth() 
                && date1.getYear() == date2.getYear();
    }
    
    public boolean importGoodsSameDay(ImportedGoods newImportGoods){
        LocalDateTime date1 = LocalDateTime.parse(this.importGoodsHistory.peek().getImportDateTime(), 
                DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss"));
        LocalDateTime date2 = LocalDateTime.parse(newImportGoods.getImportDateTime(), 
                DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss"));
        return date1.getDayOfMonth() == date2.getDayOfMonth() 
                && date1.getMonth() == date2.getMonth() 
                && date1.getYear() == date2.getYear();
    }
}
