/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Models;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import java.math.BigDecimal;
import java.time.LocalDate;

/**
 *
 * @author s1rja
 */
public class Shipment {

    @SerializedName("quantity")
    @Expose
    private BigDecimal quantity = BigDecimal.ZERO;
    @SerializedName("importPrice")
    @Expose
    private BigDecimal importPrice = BigDecimal.ZERO;
    @SerializedName("id")
    @Expose
    private String id = null;
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "d/M/y")
    private LocalDate nsx = null;
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "d/M/y")
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
}
