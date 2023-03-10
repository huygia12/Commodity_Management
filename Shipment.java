/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package JavaProject;

import java.util.Date;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;

/**
 *
 * @author s1rja
 */
class Shipment {
    private int quantity;
    private int importPrice;
    private String shipmentID = null;
    private Date nsx;
    private Date hsd;

    public Shipment() {
    }

    public Shipment(int quantity, int importPrice, String nsx, String hsd) throws ParseException {
        DateFormat df = new SimpleDateFormat("dd/MM/yyyy");
        this.quantity = quantity;
        this.importPrice = importPrice;
        this.nsx = df.parse(nsx);
        this.hsd = df.parse(hsd);
    }

    public Date getNsx() {
        return nsx;
    }

    public void setNsx(String nsx) throws ParseException {
        DateFormat df = new SimpleDateFormat("dd/MM/yyyy");
        this.nsx = df.parse(nsx);
    }

    public Date getHsd() {
        return hsd;
    }

    public void setHsd(String hsd) throws ParseException {
        DateFormat df = new SimpleDateFormat("dd/MM/yyyy");
        this.hsd = df.parse(hsd);
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
