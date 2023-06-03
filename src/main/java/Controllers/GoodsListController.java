/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controllers;

import Models.Goods;
import Models.GoodsList;
import Models.Shipment;
import View.GoodsListView;
import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author FPTSHOP
 */
public class GoodsListController {

    private final GoodsListView view = new GoodsListView();
    private final Scanner sc = new Scanner(System.in);
    final GoodsController goodsCtr = new GoodsController();

    public GoodsListController() {
    }

    public GoodsListView getView() {
        return view;
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

    public <T extends Goods> T searchGoods(GoodsList<T> goodsList) {
        // tra ve null neu nguoi dung nhap 'back', nguoc lai, tra ve 1 goods duoc tim kiem
        if (goodsList.getList().isEmpty()) {
            System.out.println("Cannot search in an empty List!");
            return null;
        }
        String inputStr = new String();
        boolean completed = false;
        T searchingGoods = null;
        do {
            try {
                System.out.print("Input productID to search(Type name for suggestion or press 'Enter' to see the whole List) or BACK to go back: ");
                inputStr = sc.nextLine();
                if ("back".equalsIgnoreCase(inputStr)) {
                    return null;
                }
                int searchingKey = Integer.parseInt(inputStr);
                searchingGoods = containGoods(goodsList, inputStr);
                if (searchingGoods == null) {
                    System.out.println("Your input ID doesnt exist.");
                    continue;
                }
                completed = true;
            } catch (NumberFormatException nfe) {
                // name suggestions for users
                GoodsList bucket = new GoodsList(new ArrayList<>());
                String inputToLowerCase = inputStr.toLowerCase();
                for (Goods tmpGoods : goodsList.getList()) {
                    String nameToLowerCase = tmpGoods.getGoodsName().toLowerCase();
                    if (nameToLowerCase.contains(inputToLowerCase)) {
                        bucket.getList().add(tmpGoods);
                    }
                }
                if (bucket.getList().isEmpty()) {
                    System.out.println("No product match with your input!");
                } else {
                    System.out.print("\nSearching : \"" + inputStr + "\"");
                    this.view.showGoodsList(bucket);
                }
            }
        } while (!completed);
        return searchingGoods;
    }

    public <T extends Goods> Object searchGoodsForGUI(String searchedGoodsID, GoodsList<T> goodsList) {
        // trả về null nếu không tìm thấy bất kỳ kết quả nào phù hợp
        try {
            int key = Integer.parseInt(searchedGoodsID);

            // nếu searchingKey là 1 chuỗi toàn số
            containGoods(goodsList, searchedGoodsID);
            return containGoods(goodsList, searchedGoodsID);
        } catch (NumberFormatException nfe) {
            // nếu searchingKey là 1 chuỗi gồm ít nhất 1 ký tự là chữ
            GoodsList<T> bucket = new GoodsList(new ArrayList<>());
            String inputToLowerCase = searchedGoodsID.toLowerCase();
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
}
