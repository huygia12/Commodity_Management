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
    private String id;
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/MM/yyyy")
    private LocalDate nsx;
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/MM/yyyy")
    private LocalDate hsd;
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/MM/yyyy")
    private LocalDate importedDate;
    
    public Shipment() {
    }

    public Shipment(BigDecimal quantity, BigDecimal importPrice, LocalDate nsx, LocalDate hsd, String id, LocalDate importedDate) {
        this.quantity = quantity;
        this.importPrice = importPrice;
        this.nsx = nsx;
        this.hsd = hsd;
        this.id = id.trim();
        this.importedDate = importedDate;
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

    public LocalDate getImportedDate() {
        return importedDate;
    }

    public void setImportedDate(LocalDate importedDate) {
        this.importedDate = importedDate;
    }
    
    public String calculateStatus() {
        if (this.hsd == null || this.nsx == null) {
            return "Không có hạn sử dụng";
        } else if (!this.hsd.isAfter(LocalDate.now())) {
            return "Hết hạn";
        } else {
            return "Còn hạn";
        }
    }
}
