package Ultility;

import Models.Goods;
import Models.GoodsList;
import Controllers.GoodsController;
import Controllers.ShipmentController;
import Models.Shipment;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.*;

public class FilterGoodsList {

    private GoodsList<Goods> goodsList;
    private final GoodsController goodsCtr = new GoodsController();
    private final ShipmentController shipmentCtr = new ShipmentController();

    public FilterGoodsList() {
    }

    public FilterGoodsList(GoodsList<Goods> goodsList) {
        this.goodsList = goodsList;
    }

    public GoodsList<Goods> getList() {
        return goodsList;
    }

    public void setGoodsList(GoodsList<Goods> goodsList) {
        this.goodsList = goodsList;
    }

    public GoodsList<Goods> withSameUnit(String unit) {
        GoodsList<Goods> filterGoodsList = new GoodsList();
        filterGoodsList.setGoodsList(this.goodsList
                .getList()
                .stream().filter(x -> x.getUnit().equals(unit))
                .map(x -> goodsCtr.cloneGoods(x))
                .collect(Collectors.toList()));
        return filterGoodsList;
    }

    public GoodsList<Goods> withinProductionDateRange(LocalDate fromDate, LocalDate toDate) {
        GoodsList<Goods> filterGoodsList = new GoodsList();
        for (Goods goods : this.goodsList.getList()) {
            // Lọc shipment không nằm trong khoảng nsx
            List<Shipment> shipmentList = new ArrayList<>();
            for (Shipment shipment : goods.getShipments()) {
                if ((shipment.getNsx() != null)
                        && ((shipment.getNsx().isAfter(fromDate)
                        && shipment.getNsx().isBefore(toDate))
                        || (shipment.getNsx().isEqual(fromDate))
                        || (shipment.getNsx().isEqual(toDate)))) {

                    shipmentList.add(shipmentCtr.cloneShipment(shipment));
                }
            }
            if (!shipmentList.isEmpty()) {
                // nếu shipmentList khác rỗng, tạo clone của goods rồi thêm vào filterGoodsList
                Goods filterGoods = goodsCtr.cloneGoods(goods);
                filterGoods.setShipments(shipmentList);
                filterGoodsList
                        .getList()
                        .add(filterGoods);
            }
        }
        return filterGoodsList;
    }

    public GoodsList<Goods> withinExpirDateRange(LocalDate fromDate, LocalDate toDate) {
        GoodsList<Goods> filterGoodsList = new GoodsList();
        for (Goods goods : this.goodsList.getList()) {
            List<Shipment> shipmentList = new ArrayList<>();
            for (Shipment shipment : goods.getShipments()) {
                if ((shipment.getHsd() != null)
                        && ((shipment.getHsd().isAfter(fromDate)
                        && shipment.getHsd().isBefore(toDate))
                        || (shipment.getHsd().isEqual(fromDate))
                        || (shipment.getHsd().isEqual(toDate)))) {

                    shipmentList.add(shipmentCtr.cloneShipment(shipment));
                }
            }
            if (!shipmentList.isEmpty()) {
                Goods filterGoods = goodsCtr.cloneGoods(goods);
                filterGoods.setShipments(shipmentList);
                filterGoodsList
                        .getList()
                        .add(filterGoods);
            }
        }
        return filterGoodsList;
    }

    public GoodsList<Goods> withinPriceRange(BigDecimal fromPrice, BigDecimal toPrice) {
        GoodsList<Goods> filterGoodsList = new GoodsList();
        filterGoodsList.setGoodsList(this.goodsList
                .getList()
                .stream().filter(x -> (x.getListPrice().compareTo(fromPrice) >= 0
                && x.getListPrice().compareTo(toPrice) <= 0))
                .map(x -> goodsCtr.cloneGoods(x))
                .collect(Collectors.toList()));
        return filterGoodsList;
    }
}
