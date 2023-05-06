/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Models;

import java.math.BigDecimal;

/**
 *
 * @author FPTSHOP
 */
public class StaticalItems {
    private String name;
    private BigDecimal quantity;
    private BigDecimal revenue;
    private double ratio;
    
    public StaticalItems(String name, BigDecimal quantity, BigDecimal revenue, double ratio) {
        this.name = name;
        this.quantity = quantity;
        this.revenue = revenue;
        this.ratio = ratio;
    }

    public StaticalItems() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public BigDecimal getQuantity() {
        return quantity;
    }

    public void setQuantity(BigDecimal quantity) {
        this.quantity = quantity;
    }

    public BigDecimal getRevenue() {
        return revenue;
    }

    public void setRevenue(BigDecimal revenue) {
        this.revenue = revenue;
    }

    public double getRatio() {
        return ratio;
    }

    public void setRatio(double ratio) {
        this.ratio = ratio;
    }
  
    
}
