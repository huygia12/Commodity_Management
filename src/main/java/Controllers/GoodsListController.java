/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controllers;

import Models.Goods;
import Models.GoodsList;
import Models.Shipment;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 *
 * @author FPTSHOP
 */
public class GoodsListController {
    final GoodsController goodsCtr = new GoodsController();

    public GoodsListController() {
    }

    public <T extends Goods> int indexOfDupGoods(GoodsList<T> goodsList, T checkingGoods) {
        // tra ve index cua goods dau tien trong goodsList co manufac va name giong voi checkingGoods
        for (T goods : goodsList.getList()) {
            if (goodsCtr.twoGoodsIsDup(goods, checkingGoods)) {
                return goodsList.getList().indexOf(goods);
            }
        }
        return -1;
    }

    public <T extends Goods> T containGoods(GoodsList<T> goodsList, String id) {
        for (T tmpGoods : goodsList.getList()) {
            if (tmpGoods.getID().equals(id)) {
                return tmpGoods;
            }
        }
        return null;
    }

    public <T extends Goods> Object searchGoods(String searchingKey, GoodsList<T> goodsList) {
        // trả về null nếu không tìm thấy bất kỳ kết quả nào phù hợp
        try {
            int key = Integer.parseInt(searchingKey);

            // nếu searchingKey là 1 chuỗi toàn số
            containGoods(goodsList, searchingKey);
            return containGoods(goodsList, searchingKey);
        } catch (NumberFormatException nfe) {
            // nếu searchingKey là 1 chuỗi gồm ít nhất 1 ký tự là chữ
            GoodsList<T> bucket = new GoodsList(new ArrayList<>());
            String inputToLowerCase = searchingKey.toLowerCase();
            for (T tmpGoods : goodsList.getList()) {
                String nameToLowerCase = tmpGoods.getGoodsName().toLowerCase();
                if (nameToLowerCase.contains(inputToLowerCase)) {
                    bucket.getList().add(tmpGoods);
                }
            }
            if (bucket.getList().isEmpty()) {
                return null;
            } else {
                return bucket;
            }
        }
    }

    public <T extends Goods> T containGoodsForGUI(GoodsList<T> goodsList, String shipmentID) {
        for (T tmpGoods : goodsList.getList()) {
            for (Shipment shipment : tmpGoods.getShipments()) {
                if (shipment.getID().equals(shipmentID)) {
                    return tmpGoods;
                }
            }
        }
        return null;
    }
    
    public <T extends Goods> boolean compare(GoodsList<T> goodsList, GoodsList<T> anotherGoodsList){
        int size = goodsList.getList().size();
        if(size != anotherGoodsList.getList().size()){
            return false;
        }
        for (int i = 0; i < size; i++) {
            Goods g1 = goodsList.getList().get(i);
            Goods g2 = anotherGoodsList.getList().get(i);
            if(!goodsCtr.compare(g1, g2)){
                return false;
            }
        }
        return true;
    }
    
    public <T extends Goods> List<String> getManufactureList(List<T> goodsList){
        List<String> manufactureList = new ArrayList<>();
        for (T goods : goodsList) {
            if(!manufactureList.contains(goods.getManufacture())){
                manufactureList.add(goods.getManufacture());
            }
        }
        return manufactureList;
    }
}
