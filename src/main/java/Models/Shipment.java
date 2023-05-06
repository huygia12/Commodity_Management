/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Models;

import java.math.BigDecimal;
import java.time.LocalDate;

/**
 *
 * @author s1rja
 */
public class Shipment {

    private BigDecimal quantity = BigDecimal.ZERO;
    private BigDecimal importPrice = BigDecimal.ZERO;
    private String id = null;
    private LocalDate nsx = null;
    private LocalDate hsd = null;

    public Shipment() {
    }

    public Shipment(BigDecimal quantity, BigDecimal importPrice, LocalDate nsx, LocalDate hsd) {
        this.quantity = quantity;
        this.importPrice = importPrice;
        this.nsx = nsx;
        this.hsd = hsd;
    }

    public Shipment(BigDecimal quantity, BigDecimal importPrice, LocalDate nsx, LocalDate hsd, String id) {
        this.quantity = quantity;
        this.importPrice = importPrice;
        this.nsx = nsx;
        this.hsd = hsd;
        this.id = id.trim();
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

    public BigDecimal getQuantity() {
        return quantity;
    }

    public void setQuantity(BigDecimal quantity) {
        this.quantity = quantity;
    }

    public BigDecimal getImportPrice() {
        return importPrice;
    }

    public void setImportPrice(BigDecimal importPrice) {
        this.importPrice = importPrice;
    }

    public String getID() {
        return id;
    }

    public void setID(String shipmentID) {
        this.id = shipmentID;
    }

    public Shipment cloneShipment() {
        Shipment cloneShipment = new Shipment();
        cloneShipment.setID(this.getID());
        cloneShipment.setImportPrice(this.getImportPrice());
        cloneShipment.setQuantity(this.getQuantity());
        cloneShipment.setHsd(this.getHsd());
        cloneShipment.setNsx(this.getNsx());
        return cloneShipment;
    }

    public void gainQuantity(BigDecimal quantity) {
        BigDecimal sumQuantity = this.getQuantity().add(quantity);
        this.setQuantity(sumQuantity);
    }
}
