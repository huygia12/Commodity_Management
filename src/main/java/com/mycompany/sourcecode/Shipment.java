/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.sourcecode;

import java.time.LocalDate;

/**
 *
 * @author s1rja
 */
class Shipment {

    private int quantity;
    private long importPrice;
    private String shipmentID = null;
    private LocalDate nsx = null;
    private LocalDate hsd = null;

    public Shipment() {
    }

    public Shipment(int quantity, long importPrice, LocalDate nsx, LocalDate hsd) {
        this.quantity = quantity;
        this.importPrice = importPrice;
        this.nsx = nsx;
        this.hsd = hsd;
    }

    public LocalDate getNsx() {
        return nsx;
    }

    public void setNsx(LocalDate nsx) {
        this.nsx = nsx;
    }

    public LocalDate getHsd() {
        return hsd;
    }

    public void setHsd(LocalDate hsd) {
        this.hsd = hsd;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public long getImportPrice() {
        return importPrice;
    }

    public void setImportPrice(long importPrice) {
        this.importPrice = importPrice;
    }

    public String getShipmentID() {
        return shipmentID;
    }

    public void setShipmentID(String shipmentID) {
        this.shipmentID = shipmentID;
    }

    public void reduceQuantity(int quantity) {
        this.quantity -= quantity;
    }

}
