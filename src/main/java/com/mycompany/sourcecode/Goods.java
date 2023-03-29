/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.sourcecode;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author s1rja
 */
public class Goods {
    private String goodsName;
    private String goodsID = null;
    private String provider;
    private long listPrice;
    private int totalQuantity = 0;
    private List<Shipment> shipments = new ArrayList<>();

    public Goods() {
    }
    
    public Goods(int totalQuantity) {
        this.totalQuantity = totalQuantity;
    }

    public Goods(String goodsName, String provider, long listPrice) {
        this.goodsName = goodsName;
        this.provider = provider;
        this.listPrice = listPrice;
    }

    public List<Shipment> getShipments() {
        return this.shipments;
    }

    public void setShipment(Shipment shipment) {
        for (Shipment shipment1 : shipments) {
            if (shipment1 == null) {
                shipment1 = shipment;
            }
        }
    }

    public String getGoodsName() {
        return goodsName;
    }

    public void setGoodsName(String goodsName) {
        this.goodsName = goodsName.trim();
    }

    public String getGoodsID() {
        return goodsID;
    }

    public void setGoodsID(String goodsID) {
        this.goodsID = goodsID;
    }

    public String getProvider() {
        return provider;
    }

    public void setProvider(String provider) {
        this.provider = provider.trim();
    }

    public long getListPrice() {
        return listPrice;
    }

    public void setListPrice(long listPrice) {
        this.listPrice = listPrice;
    }

    public int getTotalQuantity() {
        this.totalQuantity = 0;
        for (int i = 0; i < shipments.size(); i++) {
            this.totalQuantity += shipments.get(i).getQuantity();
        }
        return this.totalQuantity;
    }
}
