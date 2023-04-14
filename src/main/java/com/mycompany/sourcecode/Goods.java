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
        this.goodsName = goodsName.trim();
        this.provider = provider.trim();
        this.listPrice = listPrice;
    }

    public List<Shipment> getShipments() {
        return this.shipments;
    }

    public void setShipment(List<Shipment> shipments) {
        this.shipments = shipments;
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

    
    public Goods cloneGoods() {
        Goods cloneGoods = new Goods();
        cloneGoods.setGoodsID(this.getGoodsID());
        cloneGoods.setGoodsName(this.getGoodsName());
        cloneGoods.setListPrice(this.getListPrice());
        cloneGoods.setProvider(this.getProvider());
        for (Shipment shipment : this.getShipments()) {
            cloneGoods.shipments.add(shipment.cloneShipment());
        }
        return cloneGoods;
    }

    public int checkIfDuplicateShipmentExisted(Shipment shipment) {
        // return -1 if shipments in goods not contain duplicate shipment(duplicate in importPrice, hsd and nsx)
        // != -1 if shipments in goods contain shipment and is the index of shipment in
        // goods'sshipments
        for (Shipment tmpShipment : this.getShipments()) {
            if (tmpShipment.getImportPrice() == shipment.getImportPrice()
                    && tmpShipment.getHsd().isEqual(shipment.getHsd())
                    && tmpShipment.getNsx().isEqual(shipment.getNsx())) {
                return this.getShipments().indexOf(tmpShipment);
            }
        }
        return -1;
    }

    public boolean checkIfTwoGoodsIsDuplicate(Goods anotherGoods) {
        // return true if Goods is duplicate in goodsName and goodsProvider with 'anotherGoods', otherwise it returns false
        return this.getGoodsName().equalsIgnoreCase(anotherGoods.getGoodsName())
                && this.getProvider().equalsIgnoreCase(anotherGoods.getProvider());
    }
    
    public Shipment findShipmentWithID(String id){
        // return shipment with the given id
        for (Shipment tmpShipment : this.shipments) {
            if(tmpShipment.getShipmentID().equals(id)){
                return tmpShipment;
            }
        }
        return null;
    }
}
