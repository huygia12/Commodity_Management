/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Ultility;

import Models.Goods;
import Models.GoodsList;
import Controllers.GoodsController;
import Controllers.ShipmentController;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.stream.Collectors;

/**
 *
 * @author FPTSHOP
 */
public class FilterGoodsList {

    private GoodsList<Goods> goodsList;
    private final GoodsController goodsCtr = new GoodsController();
    private final ShipmentController shipmentCtr = new ShipmentController();

    public FilterGoodsList() {
    }

    public FilterGoodsList(GoodsList<Goods> goodsList) {
        this.goodsList = goodsList;
    }

    public GoodsList<Goods> getGoodsList() {
        return goodsList;
    }

    public void setGoodsList(GoodsList<Goods> goodsList) {
        this.goodsList = goodsList;
    }

    
    public GoodsList<Goods> withSameUnit(String unit) {
        GoodsList<Goods> filterGoodsList = new GoodsList();
        filterGoodsList.setGoodsList(this.goodsList
                .getGoodsList()
                .stream().filter(x -> x.getUnit().equals(unit))
                .map(x -> goodsCtr.cloneGoods(x))
                .collect(Collectors.toList()));
        return filterGoodsList;
    }

    public GoodsList<Goods> withinProductionDateRange(LocalDate fromDate, LocalDate toDate) {
        GoodsList<Goods> filterGoodsList = new GoodsList();
        for (Goods goods : this.goodsList.getGoodsList()) {
            goods.getShipments()
                    .stream()
                    .filter(shipment -> (shipment.getNsx().isAfter(fromDate)
                    && shipment.getNsx().isBefore(toDate))
                    || shipment.getNsx().isEqual(fromDate)
                    || shipment.getHsd().isEqual(toDate))
                    .map(x -> shipmentCtr.cloneShipment(x))
                    .collect(Collectors.toList());
            filterGoodsList
                    .getGoodsList()
                    .add(goodsCtr.cloneGoods(goods));
        }
        return filterGoodsList;
    }

    public GoodsList<Goods> withinExpirDateRange(LocalDate fromDate, LocalDate toDate) {
        GoodsList<Goods> filterGoodsList = new GoodsList();
        for (Goods goods : this.goodsList.getGoodsList()) {
            goods.getShipments()
                    .stream()
                    .filter(shipment -> (shipment.getHsd().isAfter(fromDate)
                    && shipment.getHsd().isBefore(toDate))
                    || shipment.getHsd().isEqual(fromDate)
                    || shipment.getHsd().isEqual(toDate))
                    .map(x -> shipmentCtr.cloneShipment(x))
                    .collect(Collectors.toList());
            filterGoodsList
                    .getGoodsList()
                    .add(goodsCtr.cloneGoods(goods));
        }
        return filterGoodsList;
    }
    
    public GoodsList<Goods> withinPriceRange(BigDecimal fromPrice, BigDecimal toPrice) {
        GoodsList<Goods> filterGoodsList = new GoodsList();
        filterGoodsList.setGoodsList(this.goodsList
                .getGoodsList()
                .stream().filter(x -> (x.getListPrice().compareTo(fromPrice)>=0 
                        && x.getListPrice().compareTo(toPrice)<=0))
                .map(x -> goodsCtr.cloneGoods(x))
                .collect(Collectors.toList()));
        return filterGoodsList;
    }
}
