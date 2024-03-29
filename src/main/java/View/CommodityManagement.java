/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package View;

import Controllers.GoodsController;
import Ultility.JsonDataFile;
import Models.*;
import Ultility.CustomPair;
import Ultility.IDGenerator;
import java.io.File;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.nio.file.Path;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author FPTSHOP
 */
public class CommodityManagement {

    private static final String HOME = System.getProperty("user.dir");
    private static final String SEPARATOR = File.separator;
    private static final String DATA_FOLDER = HOME + SEPARATOR + "data" + SEPARATOR;
    private static final String STORE_DATA_FOLDER = DATA_FOLDER + "storeData" + SEPARATOR;
    private static final String STORE_ID_BUCKET_PATH = DATA_FOLDER + "storeIDBucket.json";
    private static final String LIST_STORE_PATH = DATA_FOLDER + "storeList.json";

    final static JsonDataFile myData = new JsonDataFile();
    static Store store = new Store();
    final static GoodsController goodsCtr = new GoodsController();
    final static IDGenerator storeIDGenerator = new IDGenerator();
    final static List<StoreShortedCut> storeList = new ArrayList<>();

    public static void main(String[] args) {
        insertDataDirectly();
        saveData();
    }

    private static void loadData() {
        myData.load(Path.of(LIST_STORE_PATH), List.class, storeList);
    }

    private static void saveData() {
        myData.save(Path.of(STORE_ID_BUCKET_PATH), storeIDGenerator);
        myData.save(Path.of(LIST_STORE_PATH), storeList);
        myData.save(Path.of(STORE_DATA_FOLDER+store.getID()+".json"), store);
    }

    private static void insertDataDirectly() {
        store.setID(storeIDGenerator.generateID(Store.class.getName(), 6));
        IDGenerator idGenerator = store.getiDGenerator();
        Units units = store.getUnits();
        store.getUnits().getBucket().add("Hộp");
        store.getUnits().getBucket().add("Cái");
        store.getUnits().getBucket().add("Que");
        store.getUnits().getBucket().add("Lon");
        store.getUnits().getBucket().add("Quyển");
        store.getUnits().getBucket().add("Gói");
        store.getUnits().getBucket().add("Chai");
        store.getUnits().getBucket().add("Túi");
        store.getRepository().getList().add(new Goods("Custard Cake", "TuyenIndustry", new BigDecimal("30000"), idGenerator.generateID(Goods.class.getName(), 6), units.getBucket().get(0)));
        store.getRepository().getList().add(new Goods("Cup Cake", "TuyenIndustry", new BigDecimal("8000"), idGenerator.generateID(Goods.class.getName(), 6), units.getBucket().get(1)));
        store.getRepository().getList().add(new Goods("Donut", "TuyenIndustry", new BigDecimal("12000"), idGenerator.generateID(Goods.class.getName(), 6), units.getBucket().get(1)));
        store.getRepository().getList().add(new Goods("Flan", "Kem cacao", new BigDecimal("5000"), idGenerator.generateID(Goods.class.getName(), 6), units.getBucket().get(0)));
        store.getRepository().getList().add(new Goods("Strawberry ice-cream", "Kem cacao", new BigDecimal("9000"), idGenerator.generateID(Goods.class.getName(), 6), units.getBucket().get(2)));
        store.getRepository().getList().add(new Goods("Paddle pop", "Kem cacao", new BigDecimal("5000"), idGenerator.generateID(Goods.class.getName(), 6), units.getBucket().get(2)));
        store.getRepository().getList().add(new Goods("Lemon Soda", "Kem cacao", new BigDecimal("8000"), idGenerator.generateID(Goods.class.getName(), 6), units.getBucket().get(3)));
        store.getRepository().getList().add(new Goods("Ruler", "HuyStationery", new BigDecimal("3000"), idGenerator.generateID(Goods.class.getName(), 6), units.getBucket().get(1)));
        store.getRepository().getList().add(new Goods("Pencil", "HuyStationery", new BigDecimal("2000"), idGenerator.generateID(Goods.class.getName(), 6), units.getBucket().get(1)));
        store.getRepository().getList().add(new Goods("Rubber", "HuyStationery", new BigDecimal("2000"), idGenerator.generateID(Goods.class.getName(), 6), units.getBucket().get(1)));
        store.getRepository().getList().add(new Goods("Note", "HuyStationery", new BigDecimal("7000"), idGenerator.generateID(Goods.class.getName(), 6), units.getBucket().get(4)));
        store.getRepository().getList().add(new Goods("Sugar", "CookWithTung", new BigDecimal("22000"), idGenerator.generateID(Goods.class.getName(), 6), units.getBucket().get(5)));
        store.getRepository().getList().add(new Goods("Cooking oil", "CookWithTung", new BigDecimal("48000"), idGenerator.generateID(Goods.class.getName(), 6), units.getBucket().get(6)));
        store.getRepository().getList().add(new Goods("Spring-roll", "CookWithTung", new BigDecimal("50000"), idGenerator.generateID(Goods.class.getName(), 6), units.getBucket().get(5)));
        store.getRepository().getList().add(new Goods("Salt", "CookWithTung", new BigDecimal("5000"), idGenerator.generateID(Goods.class.getName(), 6), units.getBucket().get(7)));
        store.getRepository().getList().add(new Goods("Instant Noodle", "CookWithTung", new BigDecimal("14000"), idGenerator.generateID(Goods.class.getName(), 6), units.getBucket().get(7)));
        store.getRepository().getList().get(0).getShipments().add(new Shipment(new BigDecimal("20"), new BigDecimal("20000"), LocalDate.of(2023, 3, 13), LocalDate.of(2023, 11, 14), idGenerator.generateID(Shipment.class.getName(), 8), LocalDate.of(2023, 3, 20)));
        store.getRepository().getList().get(0).getShipments().add(new Shipment(new BigDecimal("40"), new BigDecimal("19000"), LocalDate.of(2023, 3, 15), LocalDate.of(2023, 11, 16), idGenerator.generateID(Shipment.class.getName(), 8), LocalDate.of(2023, 3, 25)));
        store.getRepository().getList().get(0).getShipments().add(new Shipment(new BigDecimal("30000"), new BigDecimal("18000"), LocalDate.of(2023, 3, 17), LocalDate.of(2023, 11, 18), idGenerator.generateID(Shipment.class.getName(), 8), LocalDate.of(2023, 11, 14)));
        store.getRepository().getList().get(1).getShipments().add(new Shipment(new BigDecimal("50"), new BigDecimal("3000"), LocalDate.of(2023, 3, 13), LocalDate.of(2023, 11, 14), idGenerator.generateID(Shipment.class.getName(), 8), LocalDate.of(2023, 3, 20)));
        store.getRepository().getList().get(1).getShipments().add(new Shipment(new BigDecimal("20"), new BigDecimal("4000"), LocalDate.of(2023, 3, 15), LocalDate.of(2023, 11, 16), idGenerator.generateID(Shipment.class.getName(), 8), LocalDate.of(2023, 3, 25)));
        store.getRepository().getList().get(1).getShipments().add(new Shipment(new BigDecimal("10"), new BigDecimal("5000"), LocalDate.of(2023, 3, 17), LocalDate.of(2023, 11, 18), idGenerator.generateID(Shipment.class.getName(), 8), LocalDate.of(2023, 4, 14)));
        store.getRepository().getList().get(2).getShipments().add(new Shipment(new BigDecimal("35"), new BigDecimal("5000"), LocalDate.of(2023, 3, 13), LocalDate.of(2023, 11, 14), idGenerator.generateID(Shipment.class.getName(), 8), LocalDate.of(2023, 3, 20)));
        store.getRepository().getList().get(2).getShipments().add(new Shipment(new BigDecimal("22"), new BigDecimal("6000"), LocalDate.of(2023, 3, 15), LocalDate.of(2023, 11, 16), idGenerator.generateID(Shipment.class.getName(), 8), LocalDate.of(2023, 3, 25)));
        store.getRepository().getList().get(2).getShipments().add(new Shipment(new BigDecimal("29"), new BigDecimal("7000"), LocalDate.of(2023, 3, 17), LocalDate.of(2023, 11, 18), idGenerator.generateID(Shipment.class.getName(), 8), LocalDate.of(2023, 4, 14)));
        store.getRepository().getList().get(3).getShipments().add(new Shipment(new BigDecimal("50"), new BigDecimal("2500"), LocalDate.of(2023, 3, 13), LocalDate.of(2023, 11, 14), idGenerator.generateID(Shipment.class.getName(), 8), LocalDate.of(2023, 3, 20)));
        store.getRepository().getList().get(3).getShipments().add(new Shipment(new BigDecimal("51"), new BigDecimal("2400"), LocalDate.of(2023, 3, 15), LocalDate.of(2023, 11, 16), idGenerator.generateID(Shipment.class.getName(), 8), LocalDate.of(2023, 3, 25)));
        store.getRepository().getList().get(3).getShipments().add(new Shipment(new BigDecimal("33"), new BigDecimal("2100"), LocalDate.of(2023, 3, 17), LocalDate.of(2023, 11, 18), idGenerator.generateID(Shipment.class.getName(), 8), LocalDate.of(2023, 4, 14)));
        store.getRepository().getList().get(4).getShipments().add(new Shipment(new BigDecimal("56"), new BigDecimal("4500"), LocalDate.of(2023, 3, 13), LocalDate.of(2023, 11, 14), idGenerator.generateID(Shipment.class.getName(), 8), LocalDate.of(2023, 3, 20)));
        store.getRepository().getList().get(4).getShipments().add(new Shipment(new BigDecimal("44"), new BigDecimal("4700"), LocalDate.of(2023, 3, 15), LocalDate.of(2023, 11, 16), idGenerator.generateID(Shipment.class.getName(), 8), LocalDate.of(2023, 3, 25)));
        store.getRepository().getList().get(4).getShipments().add(new Shipment(new BigDecimal("33"), new BigDecimal("3800"), LocalDate.of(2023, 3, 17), LocalDate.of(2023, 11, 18), idGenerator.generateID(Shipment.class.getName(), 8), LocalDate.of(2023, 4, 14)));
        store.getRepository().getList().get(5).getShipments().add(new Shipment(new BigDecimal("22"), new BigDecimal("2500"), LocalDate.of(2023, 3, 13), LocalDate.of(2023, 11, 14), idGenerator.generateID(Shipment.class.getName(), 8), LocalDate.of(2023, 3, 20)));
        store.getRepository().getList().get(5).getShipments().add(new Shipment(new BigDecimal("46"), new BigDecimal("2700"), LocalDate.of(2023, 3, 15), LocalDate.of(2023, 11, 16), idGenerator.generateID(Shipment.class.getName(), 8), LocalDate.of(2023, 3, 25)));
        store.getRepository().getList().get(5).getShipments().add(new Shipment(new BigDecimal("68"), new BigDecimal("2200"), LocalDate.of(2023, 3, 17), LocalDate.of(2023, 11, 18), idGenerator.generateID(Shipment.class.getName(), 8), LocalDate.of(2023, 4, 14)));
        store.getRepository().getList().get(6).getShipments().add(new Shipment(new BigDecimal("42"), new BigDecimal("4000"), LocalDate.of(2023, 3, 13), LocalDate.of(2023, 11, 14), idGenerator.generateID(Shipment.class.getName(), 8), LocalDate.of(2023, 3, 20)));
        store.getRepository().getList().get(6).getShipments().add(new Shipment(new BigDecimal("65"), new BigDecimal("4300"), LocalDate.of(2023, 3, 15), LocalDate.of(2023, 11, 16), idGenerator.generateID(Shipment.class.getName(), 8), LocalDate.of(2023, 3, 25)));
        store.getRepository().getList().get(6).getShipments().add(new Shipment(new BigDecimal("26"), new BigDecimal("5000"), LocalDate.of(2023, 3, 17), LocalDate.of(2023, 11, 18), idGenerator.generateID(Shipment.class.getName(), 8), LocalDate.of(2023, 4, 14)));
        store.getRepository().getList().get(7).getShipments().add(new Shipment(new BigDecimal("33"), new BigDecimal("1000"), LocalDate.of(2023, 3, 13), LocalDate.of(2025, 10, 14), idGenerator.generateID(Shipment.class.getName(), 8), LocalDate.of(2023, 3, 20)));
        store.getRepository().getList().get(7).getShipments().add(new Shipment(new BigDecimal("77"), new BigDecimal("1200"), LocalDate.of(2023, 3, 15), LocalDate.of(2025, 10, 16), idGenerator.generateID(Shipment.class.getName(), 8), LocalDate.of(2023, 3, 25)));
        store.getRepository().getList().get(7).getShipments().add(new Shipment(new BigDecimal("88"), new BigDecimal("1000"), LocalDate.of(2023, 3, 17), LocalDate.of(2025, 10, 18), idGenerator.generateID(Shipment.class.getName(), 8), LocalDate.of(2023, 4, 14)));
        store.getRepository().getList().get(8).getShipments().add(new Shipment(new BigDecimal("13"), new BigDecimal("800"), LocalDate.of(2023, 3, 13), LocalDate.of(2025, 10, 14), idGenerator.generateID(Shipment.class.getName(), 8), LocalDate.of(2023, 3, 20)));
        store.getRepository().getList().get(8).getShipments().add(new Shipment(new BigDecimal("16"), new BigDecimal("750"), LocalDate.of(2023, 3, 15), LocalDate.of(2025, 10, 16), idGenerator.generateID(Shipment.class.getName(), 8), LocalDate.of(2023, 3, 25)));
        store.getRepository().getList().get(8).getShipments().add(new Shipment(new BigDecimal("44"), new BigDecimal("700"), LocalDate.of(2023, 3, 17), LocalDate.of(2025, 10, 18), idGenerator.generateID(Shipment.class.getName(), 8), LocalDate.of(2023, 4, 14)));
        store.getRepository().getList().get(9).getShipments().add(new Shipment(new BigDecimal("15"), new BigDecimal("700"), LocalDate.of(2023, 3, 13), LocalDate.of(2025, 10, 14), idGenerator.generateID(Shipment.class.getName(), 8), LocalDate.of(2023, 3, 20)));
        store.getRepository().getList().get(9).getShipments().add(new Shipment(new BigDecimal("17"), new BigDecimal("750"), LocalDate.of(2023, 3, 15), LocalDate.of(2025, 10, 16), idGenerator.generateID(Shipment.class.getName(), 8), LocalDate.of(2023, 3, 25)));
        store.getRepository().getList().get(9).getShipments().add(new Shipment(new BigDecimal("44"), new BigDecimal("750"), LocalDate.of(2023, 3, 17), LocalDate.of(2025, 10, 18), idGenerator.generateID(Shipment.class.getName(), 8), LocalDate.of(2023, 4, 14)));
        store.getRepository().getList().get(10).getShipments().add(new Shipment(new BigDecimal("42"), new BigDecimal("3000"), LocalDate.of(2023, 3, 13), LocalDate.of(2025, 10, 14), idGenerator.generateID(Shipment.class.getName(), 8), LocalDate.of(2023, 3, 20)));
        store.getRepository().getList().get(10).getShipments().add(new Shipment(new BigDecimal("19"), new BigDecimal("3000"), LocalDate.of(2023, 3, 15), LocalDate.of(2025, 10, 16), idGenerator.generateID(Shipment.class.getName(), 8), LocalDate.of(2023, 3, 25)));
        store.getRepository().getList().get(10).getShipments().add(new Shipment(new BigDecimal("18"), new BigDecimal("4000"), LocalDate.of(2023, 3, 17), LocalDate.of(2025, 10, 18), idGenerator.generateID(Shipment.class.getName(), 8), LocalDate.of(2023, 4, 14)));
        store.getRepository().getList().get(11).getShipments().add(new Shipment(new BigDecimal("15"), new BigDecimal("11000"), LocalDate.of(2023, 3, 13), LocalDate.of(2024, 3, 14), idGenerator.generateID(Shipment.class.getName(), 8), LocalDate.of(2023, 3, 20)));
        store.getRepository().getList().get(11).getShipments().add(new Shipment(new BigDecimal("22"), new BigDecimal("11000"), LocalDate.of(2023, 3, 15), LocalDate.of(2024, 3, 16), idGenerator.generateID(Shipment.class.getName(), 8), LocalDate.of(2023, 3, 25)));
        store.getRepository().getList().get(11).getShipments().add(new Shipment(new BigDecimal("23"), new BigDecimal("12000"), LocalDate.of(2023, 3, 17), LocalDate.of(2024, 3, 18), idGenerator.generateID(Shipment.class.getName(), 8), LocalDate.of(2023, 4, 14)));
        store.getRepository().getList().get(12).getShipments().add(new Shipment(new BigDecimal("32"), new BigDecimal("24000"), LocalDate.of(2023, 3, 13), LocalDate.of(2024, 3, 14), idGenerator.generateID(Shipment.class.getName(), 8), LocalDate.of(2023, 3, 20)));
        store.getRepository().getList().get(12).getShipments().add(new Shipment(new BigDecimal("31"), new BigDecimal("24000"), LocalDate.of(2023, 3, 15), LocalDate.of(2024, 3, 16), idGenerator.generateID(Shipment.class.getName(), 8), LocalDate.of(2023, 3, 25)));
        store.getRepository().getList().get(12).getShipments().add(new Shipment(new BigDecimal("33"), new BigDecimal("25000"), LocalDate.of(2023, 3, 17), LocalDate.of(2024, 3, 18), idGenerator.generateID(Shipment.class.getName(), 8), LocalDate.of(2023, 4, 14)));
        store.getRepository().getList().get(13).getShipments().add(new Shipment(new BigDecimal("35"), new BigDecimal("25000"), LocalDate.of(2023, 3, 13), LocalDate.of(2023, 11, 14), idGenerator.generateID(Shipment.class.getName(), 8), LocalDate.of(2023, 3, 20)));
        store.getRepository().getList().get(13).getShipments().add(new Shipment(new BigDecimal("37"), new BigDecimal("25000"), LocalDate.of(2023, 3, 15), LocalDate.of(2023, 11, 16), idGenerator.generateID(Shipment.class.getName(), 8), LocalDate.of(2023, 3, 25)));
        store.getRepository().getList().get(13).getShipments().add(new Shipment(new BigDecimal("28"), new BigDecimal("25000"), LocalDate.of(2023, 3, 17), LocalDate.of(2023, 11, 18), idGenerator.generateID(Shipment.class.getName(), 8), LocalDate.of(2023, 4, 14)));
        store.getRepository().getList().get(14).getShipments().add(new Shipment(new BigDecimal("43"), new BigDecimal("2000"), LocalDate.of(2023, 3, 13), LocalDate.of(2023, 12, 14), idGenerator.generateID(Shipment.class.getName(), 8), LocalDate.of(2023, 3, 20)));
        store.getRepository().getList().get(14).getShipments().add(new Shipment(new BigDecimal("22"), new BigDecimal("2000"), LocalDate.of(2023, 3, 15), LocalDate.of(2023, 12, 16), idGenerator.generateID(Shipment.class.getName(), 8), LocalDate.of(2023, 3, 25)));
        store.getRepository().getList().get(14).getShipments().add(new Shipment(new BigDecimal("25"), new BigDecimal("2000"), LocalDate.of(2023, 3, 17), LocalDate.of(2023, 12, 18), idGenerator.generateID(Shipment.class.getName(), 8), LocalDate.of(2023, 4, 14)));
        store.getRepository().getList().get(15).getShipments().add(new Shipment(new BigDecimal("23"), new BigDecimal("6500"), LocalDate.of(2023, 3, 13), LocalDate.of(2023, 10, 14), idGenerator.generateID(Shipment.class.getName(), 8), LocalDate.of(2023, 3, 20)));
        store.getRepository().getList().get(15).getShipments().add(new Shipment(new BigDecimal("27"), new BigDecimal("6500"), LocalDate.of(2023, 3, 15), LocalDate.of(2023, 10, 16), idGenerator.generateID(Shipment.class.getName(), 8), LocalDate.of(2023, 3, 25)));
        store.getRepository().getList().get(15).getShipments().add(new Shipment(new BigDecimal("11"), new BigDecimal("6500"), LocalDate.of(2023, 3, 17), LocalDate.of(2023, 10, 18), idGenerator.generateID(Shipment.class.getName(), 8), LocalDate.of(2023, 4, 14)));
        Goods goods1 = goodsCtr.cloneGoods(store.getRepository().getList().get(0));
        Shipment shipment1 = goods1.getShipments().get(0);
        goods1.getShipments().clear();
        goods1.getShipments().add(shipment1);
        store.getHistory().getImportGoodsList().add(goods1);
        Goods goods2 = goodsCtr.cloneGoods(store.getRepository().getList().get(1));
        Shipment shipment2 = goods2.getShipments().get(0);
        goods2.getShipments().clear();
        goods2.getShipments().add(shipment2);
        store.getHistory().getImportGoodsList().add(goods2);
        Goods goods3 = goodsCtr.cloneGoods(store.getRepository().getList().get(2));
        Shipment shipment3 = goods3.getShipments().get(0);
        goods3.getShipments().clear();
        goods3.getShipments().add(shipment3);
        store.getHistory().getImportGoodsList().add(goods3);
        Goods goods4 = goodsCtr.cloneGoods(store.getRepository().getList().get(3));
        Shipment shipment4 = goods4.getShipments().get(0);
        goods4.getShipments().clear();
        goods4.getShipments().add(shipment4);
        store.getHistory().getImportGoodsList().add(goods4);
        Goods goods5 = goodsCtr.cloneGoods(store.getRepository().getList().get(4));
        Shipment shipment5 = goods5.getShipments().get(0);
        goods5.getShipments().clear();
        goods5.getShipments().add(shipment5);
        store.getHistory().getImportGoodsList().add(goods5);
        Goods goods6 = goodsCtr.cloneGoods(store.getRepository().getList().get(5));
        Shipment shipment6 = goods6.getShipments().get(0);
        goods6.getShipments().clear();
        goods6.getShipments().add(shipment6);
        store.getHistory().getImportGoodsList().add(goods6);
        Goods goods7 = goodsCtr.cloneGoods(store.getRepository().getList().get(6));
        Shipment shipment7 = goods7.getShipments().get(0);
        goods7.getShipments().clear();
        goods7.getShipments().add(shipment7);
        store.getHistory().getImportGoodsList().add(goods7);
        Goods goods8 = goodsCtr.cloneGoods(store.getRepository().getList().get(7));
        Shipment shipment8 = goods8.getShipments().get(0);
        goods8.getShipments().clear();
        goods8.getShipments().add(shipment8);
        store.getHistory().getImportGoodsList().add(goods8);
        Goods goods9 = goodsCtr.cloneGoods(store.getRepository().getList().get(8));
        Shipment shipment9 = goods9.getShipments().get(0);
        goods9.getShipments().clear();
        goods9.getShipments().add(shipment9);
        store.getHistory().getImportGoodsList().add(goods9);
        Goods goods10 = goodsCtr.cloneGoods(store.getRepository().getList().get(9));
        Shipment shipment10 = goods10.getShipments().get(0);
        goods10.getShipments().clear();
        goods10.getShipments().add(shipment10);
        store.getHistory().getImportGoodsList().add(goods10);
        Goods goods11 = goodsCtr.cloneGoods(store.getRepository().getList().get(10));
        Shipment shipment11 = goods11.getShipments().get(0);
        goods11.getShipments().clear();
        goods11.getShipments().add(shipment11);
        store.getHistory().getImportGoodsList().add(goods11);
        Goods goods12 = goodsCtr.cloneGoods(store.getRepository().getList().get(11));
        Shipment shipment12 = goods12.getShipments().get(0);
        goods12.getShipments().clear();
        goods12.getShipments().add(shipment12);
        store.getHistory().getImportGoodsList().add(goods12);
        Goods goods13 = goodsCtr.cloneGoods(store.getRepository().getList().get(12));
        Shipment shipment13 = goods13.getShipments().get(0);
        goods13.getShipments().clear();
        goods13.getShipments().add(shipment13);
        store.getHistory().getImportGoodsList().add(goods13);
        Goods goods14 = goodsCtr.cloneGoods(store.getRepository().getList().get(13));
        Shipment shipment14 = goods14.getShipments().get(0);
        goods14.getShipments().clear();
        goods14.getShipments().add(shipment14);
        store.getHistory().getImportGoodsList().add(goods14);
        Goods goods15 = goodsCtr.cloneGoods(store.getRepository().getList().get(14));
        Shipment shipment15 = goods15.getShipments().get(0);
        goods15.getShipments().clear();
        goods15.getShipments().add(shipment15);
        store.getHistory().getImportGoodsList().add(goods15);
        Goods goods16 = goodsCtr.cloneGoods(store.getRepository().getList().get(15));
        Shipment shipment16 = goods16.getShipments().get(0);
        goods16.getShipments().clear();
        goods16.getShipments().add(shipment16);
        store.getHistory().getImportGoodsList().add(goods16);
        Goods good1 = goodsCtr.cloneGoods(store.getRepository().getList().get(0));
        Shipment shipmen1 = good1.getShipments().get(1);
        good1.getShipments().clear();
        good1.getShipments().add(shipmen1);
        store.getHistory().getImportGoodsList().add(good1);
        Goods good2 = goodsCtr.cloneGoods(store.getRepository().getList().get(1));
        Shipment shipmen2 = good2.getShipments().get(1);
        good2.getShipments().clear();
        good2.getShipments().add(shipmen2);
        store.getHistory().getImportGoodsList().add(good2);
        Goods good3 = goodsCtr.cloneGoods(store.getRepository().getList().get(2));
        Shipment shipmen3 = good3.getShipments().get(1);
        good3.getShipments().clear();
        good3.getShipments().add(shipmen3);
        store.getHistory().getImportGoodsList().add(good3);
        Goods good4 = goodsCtr.cloneGoods(store.getRepository().getList().get(3));
        Shipment shipmen4 = good4.getShipments().get(1);
        good4.getShipments().clear();
        good4.getShipments().add(shipmen4);
        store.getHistory().getImportGoodsList().add(good4);
        Goods good5 = goodsCtr.cloneGoods(store.getRepository().getList().get(4));
        Shipment shipmen5 = good5.getShipments().get(1);
        good5.getShipments().clear();
        good5.getShipments().add(shipmen5);
        store.getHistory().getImportGoodsList().add(good5);
        Goods good6 = goodsCtr.cloneGoods(store.getRepository().getList().get(5));
        Shipment shipmen6 = good6.getShipments().get(1);
        good6.getShipments().clear();
        good6.getShipments().add(shipmen6);
        store.getHistory().getImportGoodsList().add(good6);
        Goods good7 = goodsCtr.cloneGoods(store.getRepository().getList().get(6));
        Shipment shipmen7 = good7.getShipments().get(1);
        good7.getShipments().clear();
        good7.getShipments().add(shipmen7);
        store.getHistory().getImportGoodsList().add(good7);
        Goods good8 = goodsCtr.cloneGoods(store.getRepository().getList().get(7));
        Shipment shipmen8 = good8.getShipments().get(1);
        good8.getShipments().clear();
        good8.getShipments().add(shipmen8);
        store.getHistory().getImportGoodsList().add(good8);
        Goods good9 = goodsCtr.cloneGoods(store.getRepository().getList().get(8));
        Shipment shipmen9= good9.getShipments().get(1);
        good9.getShipments().clear();
        good9.getShipments().add(shipmen9);
        store.getHistory().getImportGoodsList().add(good9);
        Goods good10 = goodsCtr.cloneGoods(store.getRepository().getList().get(9));
        Shipment shipmen10 = good10.getShipments().get(1);
        good10.getShipments().clear();
        good10.getShipments().add(shipmen10);
        store.getHistory().getImportGoodsList().add(good10);
        Goods good11 = goodsCtr.cloneGoods(store.getRepository().getList().get(10));
        Shipment shipmen11 = good11.getShipments().get(1);
        good11.getShipments().clear();
        good11.getShipments().add(shipmen11);
        store.getHistory().getImportGoodsList().add(good11);
        Goods good12 = goodsCtr.cloneGoods(store.getRepository().getList().get(11));
        Shipment shipmen12 = good12.getShipments().get(1);
        good12.getShipments().clear();
        good12.getShipments().add(shipmen12);
        store.getHistory().getImportGoodsList().add(good12);
        Goods good13 = goodsCtr.cloneGoods(store.getRepository().getList().get(12));
        Shipment shipmen13 = good13.getShipments().get(1);
        good13.getShipments().clear();
        good13.getShipments().add(shipmen13);
        store.getHistory().getImportGoodsList().add(good13);
        Goods good14 = goodsCtr.cloneGoods(store.getRepository().getList().get(13));
        Shipment shipmen14 = good14.getShipments().get(1);
        good14.getShipments().clear();
        good14.getShipments().add(shipmen14);
        store.getHistory().getImportGoodsList().add(good14);
        Goods good15 = goodsCtr.cloneGoods(store.getRepository().getList().get(14));
        Shipment shipmen15 = good15.getShipments().get(1);
        good15.getShipments().clear();
        good15.getShipments().add(shipmen15);
        store.getHistory().getImportGoodsList().add(good15);
        Goods good16 = goodsCtr.cloneGoods(store.getRepository().getList().get(15));
        Shipment shipmen16 = good16.getShipments().get(1);
        good16.getShipments().clear();
        good16.getShipments().add(shipmen16);
        store.getHistory().getImportGoodsList().add(good16);
        Goods god1 = goodsCtr.cloneGoods(store.getRepository().getList().get(0));
        Shipment ship1 = god1.getShipments().get(2);
        god1.getShipments().clear();
        god1.getShipments().add(ship1);
        store.getHistory().getImportGoodsList().add(god1);
        Goods god2 = goodsCtr.cloneGoods(store.getRepository().getList().get(1));
        Shipment ship2 = god2.getShipments().get(2);
        god2.getShipments().clear();
        god2.getShipments().add(ship2);
        store.getHistory().getImportGoodsList().add(god2);
        Goods god3 = goodsCtr.cloneGoods(store.getRepository().getList().get(2));
        Shipment ship3 = god3.getShipments().get(2);
        god3.getShipments().clear();
        god3.getShipments().add(ship3);
        store.getHistory().getImportGoodsList().add(god3);
        Goods god4 = goodsCtr.cloneGoods(store.getRepository().getList().get(3));
        Shipment ship4 = god4.getShipments().get(2);
        god4.getShipments().clear();
        god4.getShipments().add(ship4);
        store.getHistory().getImportGoodsList().add(god4);
        Goods god5 = goodsCtr.cloneGoods(store.getRepository().getList().get(4));
        Shipment ship5 = god5.getShipments().get(2);
        god5.getShipments().clear();
        god5.getShipments().add(ship5);
        store.getHistory().getImportGoodsList().add(god5);
        Goods god6 = goodsCtr.cloneGoods(store.getRepository().getList().get(5));
        Shipment ship6 = god6.getShipments().get(2);
        god6.getShipments().clear();
        god6.getShipments().add(ship6);
        store.getHistory().getImportGoodsList().add(god6);
        Goods god7 = goodsCtr.cloneGoods(store.getRepository().getList().get(6));
        Shipment ship7 = god7.getShipments().get(2);
        god7.getShipments().clear();
        god7.getShipments().add(ship7);
        store.getHistory().getImportGoodsList().add(god7);
        Goods god8 = goodsCtr.cloneGoods(store.getRepository().getList().get(7));
        Shipment ship8 = god8.getShipments().get(2);
        god8.getShipments().clear();
        god8.getShipments().add(ship8);
        store.getHistory().getImportGoodsList().add(god8);
        Goods god9 = goodsCtr.cloneGoods(store.getRepository().getList().get(8));
        Shipment ship9= god9.getShipments().get(2);
        god9.getShipments().clear();
        god9.getShipments().add(ship9);
        store.getHistory().getImportGoodsList().add(god9);
        Goods god10 = goodsCtr.cloneGoods(store.getRepository().getList().get(9));
        Shipment ship10 = god10.getShipments().get(2);
        god10.getShipments().clear();
        god10.getShipments().add(ship10);
        store.getHistory().getImportGoodsList().add(god10);
        Goods god11 = goodsCtr.cloneGoods(store.getRepository().getList().get(10));
        Shipment ship11 = god11.getShipments().get(2);
        god11.getShipments().clear();
        god11.getShipments().add(ship11);
        store.getHistory().getImportGoodsList().add(god11);
        Goods god12 = goodsCtr.cloneGoods(store.getRepository().getList().get(11));
        Shipment ship12 = god12.getShipments().get(2);
        god12.getShipments().clear();
        god12.getShipments().add(ship12);
        store.getHistory().getImportGoodsList().add(god12);
        Goods god13 = goodsCtr.cloneGoods(store.getRepository().getList().get(12));
        Shipment ship13 = god13.getShipments().get(2);
        god13.getShipments().clear();
        god13.getShipments().add(ship13);
        store.getHistory().getImportGoodsList().add(god13);
        Goods god14 = goodsCtr.cloneGoods(store.getRepository().getList().get(13));
        Shipment ship14 = god14.getShipments().get(2);
        god14.getShipments().clear();
        god14.getShipments().add(ship14);
        store.getHistory().getImportGoodsList().add(god14);
        Goods god15 = goodsCtr.cloneGoods(store.getRepository().getList().get(14));
        Shipment ship15 = god15.getShipments().get(2);
        god15.getShipments().clear();
        god15.getShipments().add(ship15);
        store.getHistory().getImportGoodsList().add(god15);
        Goods god16 = goodsCtr.cloneGoods(store.getRepository().getList().get(15));
        Shipment ship16 = god16.getShipments().get(2);
        god16.getShipments().clear();
        god16.getShipments().add(ship16);
        store.getHistory().getImportGoodsList().add(god16);

        store.getEmployeeList().getList().add(new Employee(new BigDecimal("22000"), "2223666611", "Nguyen Gia", "Huy", "0705737293", "so10-Ngo2-YenPhuc-PhucLa-HaDong", 19, Gender.MALE));
        store.getEmployeeList().getList().add(new Employee(new BigDecimal("23000"), "3553646623", "Vu Hung", "Tung", "0905737293", "AeonMall HaDong", 16, Gender.MALE));
        store.getEmployeeList().getList().add(new Employee(new BigDecimal("22000"), "7337593977", "Dao Van", "Tuyen", "0805737293", "220-TrieuKhuc-TanTrieu-ThanhTri", 20, Gender.MALE));
        store.getEmployeeList().getList().add(new Employee(new BigDecimal("25000"), "3957577777", "Nguyen Thao", "Chi", "0505737293", "141-ChienThang-TanTrieu", 20, Gender.FEMALE));
        store.getEmployeeList().getList().add(new Employee(new BigDecimal("20000"), "2727495500", "Tran Luu", "Dung", "0903737293", "Vinhome Riverside", 19, Gender.OTHER));
        store.getCustomerCardList().getList().add(new CustomerCard(idGenerator.generateID(CustomerCard.class.getName(), 6), new Customer("Nguyen Duc", "Anh", "0975268264", "34 Nguyen Du", 20, Gender.MALE)));
        store.getCustomerCardList().getList().add(new CustomerCard(idGenerator.generateID(CustomerCard.class.getName(), 6), new Customer("Le Van", "Quyet", "0906333164", "26 Do Duc Duc", 20, Gender.OTHER)));
        store.getCustomerCardList().getList().add(new CustomerCard(idGenerator.generateID(CustomerCard.class.getName(), 6), new Customer("Do Quynh", "Anh", "0971345298", "16 Cau Giay", 22, Gender.FEMALE)));
        store.getCustomerCardList().getList().add(new CustomerCard(idGenerator.generateID(CustomerCard.class.getName(), 6), new Customer("Le Duc", "Cuong", "0916254167", "41 Minh Khai", 17, Gender.MALE)));
        store.setName("Chang hi");
        store.setAddress("112-Nguyen Van Loc");
        store.setEmail("wangwang123@gmail.com");
        store.setPassWord("12345678");
        store.setPhoneNumber("0705737292");
        store.setPointsForOneVND(new BigInteger("10"));
        store.setAmountForOnePoint(new BigDecimal("10000"));
        store.getSettings().getPriceAmountList().add("< 100000");
        store.getSettings().getPriceAmountList().add("100000 - 300000");
        store.getSettings().getPriceAmountList().add("300000 - 500000");
        store.getSettings().getPriceAmountList().add("< 500000");
        store.setBronzeDiscountOffer(new CustomPair<>(new BigDecimal("0"), 0d));
        store.setSilverDiscountOffer(new CustomPair<>(new BigDecimal("8000000"), 2d));
        store.setGoldDiscountOffer(new CustomPair<>(new BigDecimal("12000000"), 3d));
        store.setDiamondDiscountOffer(new CustomPair<>(new BigDecimal("30000000"), 4d));
        
        storeList.add(new StoreShortedCut(store.getID(), store.getEmail(), store.getPassWord()));
//        GoodsList<Goods> orderGoodsList1 = new GoodsList();
//        orderGoodsList1.getList().add(repo.getList().get(0));
//        orderGoodsList1.getList().add(repo.getList().get(2));
//        orderGoodsList1.getList().add(repo.getList().get(3));
//        orderGoodsList1.getList().add(repo.getList().get(4));
//        shift.getOrderHisPerShift().add(new Order(LocalDateTime.parse("03/01/2023 05:05:05", DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss")), "HD000001", PaymentOptions.CASH_PAYMENT, cardList.getList().get(1), employeeList.getList().get(0), orderGoodsList1.getList()));
//        GoodsList<Goods> orderGoodsList3 = new GoodsList();
//        orderGoodsList1.getList().add(repo.getList().get(4));
//        orderGoodsList1.getList().add(repo.getList().get(1));
//        orderGoodsList1.getList().add(repo.getList().get(7));
//        orderGoodsList1.getList().add(repo.getList().get(5));
//        shift.getOrderHisPerShift().add(new Order(LocalDateTime.parse("03/01/2023 06:25:05", DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss")), "HD000002", PaymentOptions.OTHER_PAYMENT, cardList.getList().get(2), employeeList.getList().get(0), orderGoodsList3.getList()));
//        GoodsList<Goods> orderGoodsList2 = new GoodsList();
//        orderGoodsList1.getList().add(repo.getList().get(0));
//        orderGoodsList1.getList().add(repo.getList().get(2));
//        shift.getOrderHisPerShift().add(new Order(LocalDateTime.parse("03/01/2023 07:33:05", DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss")), "HD000003", PaymentOptions.CASH_PAYMENT, cardList.getList().get(3), employeeList.getList().get(0), orderGoodsList2.getList()));
//        shift.getImportGoodsHis().getList().add(new ImportedGoods(repo.getList().get(0)));
//        shift.getImportGoodsHis().getList().add(new ImportedGoods(repo.getList().get(1)));
//        shift.getImportGoodsHis().getList().add(new ImportedGoods(repo.getList().get(2)));
//        shift.getImportGoodsHis().getList().add(new ImportedGoods(repo.getList().get(3)));
//        shift.getImportGoodsHis().getList().add(new ImportedGoods(repo.getList().get(4)));
//        shift.getImportGoodsHis().getList().add(new ImportedGoods(repo.getList().get(8)));
//        shift.getImportGoodsHis().getList().add(new ImportedGoods(repo.getList().get(12)));
//        
    }
}
