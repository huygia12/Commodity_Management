/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author s1rja
 */
public class Goods {
    
    @SerializedName("goodsName")
    @Expose
    private String goodsName;
    @SerializedName("id")
    @Expose
    private String id;
    @SerializedName("manufacture")
    @Expose
    private String manufacture;
    @SerializedName("listPrice")
    @Expose
    private BigDecimal listPrice = BigDecimal.ZERO;
    @SerializedName("totalQuantity")
    @Expose
    private BigDecimal totalQuantity = BigDecimal.ZERO;
    @SerializedName("shipments")
    @Expose
    private List<Shipment> shipments = new ArrayList<>();

    public Goods() {
    }

    public Goods(String goodsName, String manufac, BigDecimal listPrice) {
        this.goodsName = goodsName.trim();
        this.manufacture = manufac.trim();
        this.listPrice = listPrice;
    }

    public Goods(String goodsName, String manufac, BigDecimal listPrice, String goodsID) {
        this.goodsName = goodsName.trim();
        this.manufacture = manufac.trim();
        this.listPrice = listPrice;
        this.id = goodsID.trim();
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
        return this.totalQuantity;
    }
    
    public void setTotalQuantity(BigDecimal totalQuantity){
        this.totalQuantity = totalQuantity;
    }
}
