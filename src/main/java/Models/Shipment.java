/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Models;

import java.math.BigInteger;
import java.time.LocalDate;

/**
 *
 * @author s1rja
 */
public class Shipment {

    private BigInteger quantity = BigInteger.ZERO;
    private BigInteger importPrice = BigInteger.ZERO;
    private String id = null;
    private LocalDate nsx = null;
    private LocalDate hsd = null;

    public Shipment() {
    }

    public Shipment(BigInteger quantity, BigInteger importPrice, LocalDate nsx, LocalDate hsd) {
        this.quantity = quantity;
        this.importPrice = importPrice;
        this.nsx = nsx;
        this.hsd = hsd;
    }

    public Shipment(BigInteger quantity, BigInteger importPrice, LocalDate nsx, LocalDate hsd, String id) {
        this.quantity = quantity;
        this.importPrice = importPrice;
        this.nsx = nsx;
        this.hsd = hsd;
        this.id = id;
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

    public BigInteger getQuantity() {
        return quantity;
    }

    public void setQuantity(BigInteger quantity) {
        this.quantity = quantity;
    }

    public BigInteger getImportPrice() {
        return importPrice;
    }

    public void setImportPrice(BigInteger importPrice) {
        this.importPrice = importPrice;
    }

    public String getID() {
        return id;
    }

    public void setID(String shipmentID) {
        this.id = shipmentID;
    }
    
    
    public Shipment cloneShipment (){
        Shipment cloneShipment = new Shipment();
        cloneShipment.setID(this.getID());
        cloneShipment.setImportPrice(this.getImportPrice());
        cloneShipment.setQuantity(this.getQuantity());
        cloneShipment.setHsd(this.getHsd());
        cloneShipment.setNsx(this.getNsx());
        return cloneShipment;
    }

}
