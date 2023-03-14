/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package JavaProject;

import java.util.Date;
import java.text.ParseException;

/**
 *
 * @author s1rja
 */
class Shipment {
    private int quantity;
    private int importPrice;
    private String shipmentID = null;
    private Date nsx = null;
    private Date hsd = null;

    public Shipment() {
    }

    public Shipment(int quantity, int importPrice, Date nsx, Date hsd) throws ParseException {
        this.quantity = quantity;
        this.importPrice = importPrice;
        this.nsx = nsx;
        this.hsd = hsd;
    }

    public Date getNsx() {
        return nsx;
    }

    public void setNsx(Date nsx) {
        this.nsx = nsx;
    }

    public Date getHsd() {
        return hsd;
    }

    public void setHsd(Date hsd) {
        this.hsd = hsd;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public int getImportPrice() {
        return importPrice;
    }

    public void setImportPrice(int importPrice) {
        this.importPrice = importPrice;
    }

    public String getShipmentID() {
        return shipmentID;
    }

    public void setShipmentID(String shipmentID) {
        this.shipmentID = shipmentID;
    }
    
}
