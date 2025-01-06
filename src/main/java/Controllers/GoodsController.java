/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controllers;

import Models.Goods;
import Models.GoodsList;
import Models.Shipment;
import util.Cautions;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 *
 * @author FPTSHOP
 */
public class GoodsController {

    final Cautions ctions = new Cautions();
    private final Scanner sc = new Scanner(System.in);
    public GoodsController() {
    }

    public BigDecimal getVATMoneyPerGoods(Goods goods, int vat) {
        return goods.getListPrice().multiply(new BigDecimal(vat * 1.0 / 100));
    }

    public BigDecimal getTotalQuanByShipments(Goods goods) {
        BigDecimal totalQuan = BigDecimal.ZERO;
        for (Shipment shipment : goods.getShipments()) {
            totalQuan = totalQuan.add(shipment.getQuantity());
        }
        return totalQuan;
    }

    public Goods cloneGoods(Goods goods) {
        // tra ve 1 goods duoc cpy cac thuoc tinh cua goods goi ham cloneGoods() nay
        Goods cloneGoods = new Goods();
        cloneGoods.setID(goods.getID());
        cloneGoods.setGoodsName(goods.getGoodsName());
        cloneGoods.setListPrice(goods.getListPrice());
        cloneGoods.setManufacture(goods.getManufacture());
        cloneGoods.setUnit(goods.getUnit());
        for (Shipment shipment : goods.getShipments()) {
            cloneGoods.getShipments().add(new ShipmentController().cloneShipment(shipment));
        }
        return cloneGoods;
    }

    public <T extends Goods> boolean twoGoodsIsDup(T goods, T anotherGoods) {
        // tra ve true neu goods voi anotherGoods co cung name va manufacture, nguoc lai, tra ve true
        return goods.getGoodsName().equalsIgnoreCase(anotherGoods.getGoodsName())
                && goods.getManufacture().equalsIgnoreCase(anotherGoods.getManufacture());
    }

    public int indexOfDupShip(Goods goods, Shipment chekingShipment) {
        // tra ve -1 neu khong tim thay shipment trong shipmentList co cung hsd, nsx, importPrice voi checkingShipment
        // != -1 neu tim thay va chinh la index cua shipment do trong shipmentList
        for (Shipment tmpShipment : goods.getShipments()) {
            if (tmpShipment.getImportPrice() == chekingShipment.getImportPrice()
                    && tmpShipment.getHsd().isEqual(chekingShipment.getHsd())
                    && tmpShipment.getNsx().isEqual(chekingShipment.getNsx())) {
                return goods.getShipments().indexOf(tmpShipment);
            }
        }
        return -1;
    }

    public<T extends Shipment> T containShipment(List<T> shipmentList, String shipmentID) {
        // tra ve mot shipment voi tham so dau vao la id cua shipment do
        for (T tmpShipment : shipmentList) {
            if (tmpShipment.getID().equals(shipmentID)) {
                return tmpShipment;
            }
        }
        return null;
    }
    
    public boolean compare(Goods goods, Goods anotherGoods) {
        ShipmentController shipmentCtr = new ShipmentController();
        boolean check = true;
        if (!goods.getGoodsName().equals(anotherGoods.getGoodsName())) {
            check = false;
        } else if (!goods.getID().equals(anotherGoods.getID())) {
            check = false;
        } else if (!goods.getManufacture().equals(anotherGoods.getManufacture())) {
            check = false;
        } else if (!goods.getUnit().equals(anotherGoods.getUnit())) {
            check = false;
        } else if (goods.getListPrice().compareTo(anotherGoods.getListPrice()) != 0) {
            check = false;
        } else {
            int size = goods.getShipments().size();
            if (size != anotherGoods.getShipments().size()) {
                check = false;
            } else {
                for (int i = 0; i < size; i++) {
                    if(!shipmentCtr.compare(goods.getShipments().get(i), 
                            anotherGoods.getShipments().get(i))){
                        check = false;
                        break;
                    }
                }
            }
        }
        return check;
    }
}
