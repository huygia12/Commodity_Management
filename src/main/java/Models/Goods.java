/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import com.opencsv.bean.CsvBindByPosition;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author s1rja
 */
public class Goods {
    @CsvBindByPosition(position = 0)
    @SerializedName("id")
    @Expose
    private String id;
    @CsvBindByPosition(position = 1)
    @SerializedName("goodsName")
    @Expose
    private String goodsName;
    @CsvBindByPosition(position = 2)
    @SerializedName("manufacture")
    @Expose
    private String manufacture;
    @CsvBindByPosition(position = 3)
    @SerializedName("totalQuantity")
    @Expose
    private BigDecimal totalQuantity = BigDecimal.ZERO;
    @SerializedName("shipments")
    @Expose
    private List<Shipment> shipments = new ArrayList<>();
    @SerializedName("unit")
    @Expose
    private String unit;
    @SerializedName("listPrice")
    @Expose
    private BigDecimal listPrice = BigDecimal.ZERO;
    
    public Goods() {
    }

    public Goods(String goodsName, String manufac, BigDecimal listPrice, String goodsID, String unit) {
        this.goodsName = goodsName.trim();
        this.manufacture = manufac.trim();
        this.listPrice = listPrice;
        this.id = goodsID.trim();
        this.unit = unit.trim();
    }

    public List<Shipment> getShipments() {
        return this.shipments;
    }

    public void setShipments(List<Shipment> shipments) {
        this.shipments = shipments;
    }

    public String getGoodsName() {
        return goodsName;
    }

    public void setGoodsName(String goodsName) {
        this.goodsName = goodsName.trim();
    }

    public String getID() {
        return id;
    }

    public void setID(String goodsID) {
        this.id = goodsID;
    }

    public String getManufacture() {
        return manufacture;
    }

    public void setManufacture(String provider) {
        this.manufacture = provider.trim();
    }

    public BigDecimal getListPrice() {
        return listPrice;
    }
    
    public void setListPrice(BigDecimal listPrice) {
        this.listPrice = listPrice;
    }
    
    public BigDecimal getTotalQuantity(){
        calculateTotalQuantity();
        return this.totalQuantity;
    }
    
    public void setTotalQuantity(BigDecimal totalQuantity){
        this.totalQuantity = totalQuantity;
    }

    public String getUnit() {
        return unit;
    }

    public void setUnit(String unit) {
        this.unit = unit.trim();
    }
    
    private void calculateTotalQuantity() {
        BigDecimal totalQuantityToCalculate = BigDecimal.ZERO;
        for (Shipment shipment : shipments) {
            totalQuantityToCalculate = totalQuantityToCalculate.add(shipment.getQuantity());
        }
        totalQuantity = totalQuantityToCalculate;
    }
}
