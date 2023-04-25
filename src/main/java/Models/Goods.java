/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Models;

import View.Cautions;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 *
 * @author s1rja
 */
public class Goods {

    final Cautions ctions = new Cautions();
    final Scanner sc = new Scanner(System.in);
    private String goodsName;
    private String id;
    private String manufacture;
    private BigInteger listPrice = BigInteger.ZERO;
    private BigInteger totalQuantity = BigInteger.ZERO;
    private List<Shipment> shipments = new ArrayList<>();

    public Goods() {
    }

    public Goods(String goodsName, String manufac, BigInteger listPrice) {
        this.goodsName = goodsName.trim();
        this.manufacture = manufac.trim();
        this.listPrice = listPrice;
    }

    public Goods(String goodsName, String manufac, BigInteger listPrice, String goodsID) {
        this.goodsName = goodsName;
        this.manufacture = manufac;
        this.listPrice = listPrice;
        this.id = goodsID;
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

    public BigInteger getListPrice() {
        if(this.listPrice == null){
            this.listPrice = BigInteger.ZERO;
        }
        return listPrice;
    }

    public void setListPrice(BigInteger listPrice) {
        this.listPrice = listPrice;
    }

    public BigInteger getTotalQuantity() {
        this.totalQuantity = BigInteger.ZERO;
        for (int i = 0; i < shipments.size(); i++) {
            this.totalQuantity = this.totalQuantity.add(shipments.get(i).getQuantity());
        }
        if(this.totalQuantity == null){
            this.totalQuantity = BigInteger.ZERO;
        }
        return this.totalQuantity;
    }

    public Goods cloneGoods() {
        // tra ve 1 goods duoc cpy cac thuoc tinh cua goods goi ham cloneGoods() nay
        Goods cloneGoods = new Goods();
        cloneGoods.setID(this.getID());
        cloneGoods.setGoodsName(this.getGoodsName());
        cloneGoods.setListPrice(this.getListPrice());
        cloneGoods.setManufacture(this.getManufacture());
        for (Shipment shipment : this.getShipments()) {
            cloneGoods.getShipments().add(shipment.cloneShipment());
        }
        return cloneGoods;
    }

    public boolean twoGoodsIsDup(Goods anotherGoods) {
        // tra ve true neu goods voi anotherGoods co cung name va manufacture, nguoc lai, tra ve true
        return this.getGoodsName().equalsIgnoreCase(anotherGoods.getGoodsName())
                && this.getManufacture().equalsIgnoreCase(anotherGoods.getManufacture());
    }

    public int indexOfDupShip(Shipment chekingShipment) {
        // tra ve -1 neu khong tim thay shipment trong shipmentList co cung hsd, nsx, importPrice voi checkingShipment
        // != -1 neu tim thay va chinh la index cua shipment do trong shipmentList
        for (Shipment tmpShipment : this.getShipments()) {
            if (tmpShipment.getImportPrice() == chekingShipment.getImportPrice()
                    && tmpShipment.getHsd().isEqual(chekingShipment.getHsd())
                    && tmpShipment.getNsx().isEqual(chekingShipment.getNsx())) {
                return this.getShipments().indexOf(tmpShipment);
            }
        }
        return -1;
    }

    public Shipment containShipment(String shipmentID) {
        // tra ve mot shipment voi tham so dau vao la id cua shipment do
        for (Shipment tmpShipment : this.getShipments()) {
            if (tmpShipment.getID().equals(shipmentID)) {
                return tmpShipment;
            }
        }
        return null;
    }

    public Shipment searchShipment() {
        // tim kiem shipment trong goods goi den method seachShipment() nay
        GoodsList bucket = new GoodsList(new ArrayList<>());
        if (ctions.checkIfListEmpty(this.getShipments())) {
            return null;
        }
        bucket.getGoodsList().add(this);
        do {
            bucket.showGoodsList();
            System.out.print("Input shipment ID or type BACK to go back: ");
            String inputStr = sc.nextLine();
            if ("back".equalsIgnoreCase(inputStr)) {
                System.out.println("Back...");
                return null;
            } else if (ctions.checkIfNoInput(inputStr)) {
            } else {
                for (Shipment shipment : this.getShipments()) {
                    if (inputStr.equals(shipment.getID())) {
                        return shipment;
                    }
                }
                System.out.println("No shipment found!");
            }
        } while (true);
    }

}
