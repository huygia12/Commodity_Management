/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.sourcecode;

import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 *
 * @author s1rja
 */
public class UsefulFunctions {

    Scanner sc = new Scanner(System.in);
    String outputDatePatternForUF = "dd/MM/yyyy";
    int NAME_MAX_SIZE;
    int PROVIDER_MAX_SIZE;
    int LIST_PRICE_MAX_SIZE;
    int TOTAL_QUANTITY_MAX_SIZE;
    int IMPORT_PRICE_MAX_SIZE;
    int QUANTITY_MAX_SIZE;

    public Goods searchGoods(List<Goods> goodsList) {
        // search(Goods) : null neu nhap BACK/ 1 Goods neu tim kiem thanh cong
        if (goodsList.isEmpty()) {
            System.out.println("No product found in the repository.");
            return null;
        }
        String input = new String();
        boolean completed = false;
        Goods result = null;
        do {
            try {
                System.out.print("Input productID to search(Type name for suggestion) or Back to go back: ");
                input = sc.nextLine();
                int searchingKey = Integer.parseInt(input);
                for (Goods goods1 : goodsList) {
                    if (goods1.getGoodsID().equals(input)) {
                        result = goods1;
                    }
                }
                if (result == null) {
                    System.out.println("Your input ID doesnt exist.");
                    continue;
                }
                completed = true;
            } catch (NumberFormatException nfe) {
                if (input.equalsIgnoreCase("back")) {
                    break;
                }
                List<Goods> bucket = new ArrayList<>();
                for (Goods goods2 : goodsList) {
                    String nameToLowerCase = goods2.getGoodsName().toLowerCase();
                    String inputToLowerCase = input.toLowerCase();
                    if (nameToLowerCase.contains(inputToLowerCase)) {
                        bucket.add(goods2);
                    }
                }
                if (bucket.isEmpty()) {
                    System.out.println("No product match with your input!");
                } else {
                    System.out.print("\nSearching : \"" + input + "\"");
                    showGoodsList(bucket);
                }
            }
        } while (!completed);
        return result;
    }

    public void alignTheColumn(List<Goods> goodsList) {
        // duyet tu dau den cuoi mang de lay MAX_SIZE cua giatri input tung attributes
        Goods goodsAt0 = goodsList.get(0);
        NAME_MAX_SIZE = "Name".length();
        PROVIDER_MAX_SIZE = "Provider".length();
        LIST_PRICE_MAX_SIZE = "List Price".length();
        TOTAL_QUANTITY_MAX_SIZE = "Total Quantity".length();
        IMPORT_PRICE_MAX_SIZE = "Import Price".length();
        QUANTITY_MAX_SIZE = "Quantity".length();
        for (Goods goods : goodsList) {
            if (goods.getGoodsName().length() > NAME_MAX_SIZE) {
                NAME_MAX_SIZE = goods.getGoodsName().length();
            }
            if (goods.getProvider().length() > PROVIDER_MAX_SIZE) {
                PROVIDER_MAX_SIZE = goods.getProvider().length();
            }
            if (Long.toString(goods.getListPrice()).length() > LIST_PRICE_MAX_SIZE) {
                LIST_PRICE_MAX_SIZE = Long.toString(goods.getListPrice()).length();
            }
            if (Integer.toString(goods.getTotalQuantity()).length() > TOTAL_QUANTITY_MAX_SIZE) {
                TOTAL_QUANTITY_MAX_SIZE = Integer.toString(goods.getTotalQuantity()).length();
            }
            for (Shipment shipment : goods.getShipments()) {
                if (Long.toString(shipment.getImportPrice()).length() > IMPORT_PRICE_MAX_SIZE) {
                    IMPORT_PRICE_MAX_SIZE = Long.toString(shipment.getImportPrice()).length();
                }
                if (Integer.toString(shipment.getQuantity()).length() > QUANTITY_MAX_SIZE) {
                    QUANTITY_MAX_SIZE = Integer.toString(shipment.getQuantity()).length();
                }
            }
        }
    }

    public void showGoodsList(List<Goods> goodsList) {
        if (goodsList.isEmpty()) {
            System.out.println("No product found in the repository.");
            return;
        }
        System.out.println();
        alignTheColumn(goodsList);
        System.out.printf("| %-8s | %-" + String.format(NAME_MAX_SIZE + "s") + " | %-" + String.format(PROVIDER_MAX_SIZE + "s")
                + " | %-" + String.format(LIST_PRICE_MAX_SIZE + "s") + " | %-" + String.format(TOTAL_QUANTITY_MAX_SIZE + "s")
                + " | %11s | %-15s | %-15s | %-" + String.format(IMPORT_PRICE_MAX_SIZE + "s") + " | %-" + String.format(QUANTITY_MAX_SIZE + "s") + " |\n",
                "Goods ID", "Name", "Provider", "List Price", "Total Quantity", "Shipment ID",
                "Production Date", "Expiration Date", "Import Price", "Quantity");
        System.out.println("|" + "-".repeat(NAME_MAX_SIZE + PROVIDER_MAX_SIZE + LIST_PRICE_MAX_SIZE
                + TOTAL_QUANTITY_MAX_SIZE + IMPORT_PRICE_MAX_SIZE + QUANTITY_MAX_SIZE + 78) + "|");
        for (Goods goods : goodsList) {
            System.out.printf("| %-8s | %-" + String.format(NAME_MAX_SIZE + "s") + " | %-" + String.format(PROVIDER_MAX_SIZE + "s")
                    + " | %-" + String.format(LIST_PRICE_MAX_SIZE + "s") + " | %-" + String.format(TOTAL_QUANTITY_MAX_SIZE + "s") + " |",
                    goods.getGoodsID(),
                    goods.getGoodsName(),
                    goods.getProvider(),
                    goods.getListPrice(),
                    goods.getTotalQuantity());
            if (!goods.getShipments().isEmpty()) {
                Shipment shipment = goods.getShipments().get(0);
                String productionDateString = shipment.getNsx().format(DateTimeFormatter.ofPattern(outputDatePatternForUF));
                String expirationDateString = shipment.getHsd().format(DateTimeFormatter.ofPattern(outputDatePatternForUF));
                System.out.printf( " %-11s | %-15s | %-15s | %-" + String.format(IMPORT_PRICE_MAX_SIZE + "s")
                        + " | %-" + String.format(QUANTITY_MAX_SIZE + "s") + " |\n",
                        shipment.getShipmentID(),
                        productionDateString,
                        expirationDateString,
                        shipment.getImportPrice(),
                        shipment.getQuantity());
                for (int i = 1; i < goods.getShipments().size(); i++) {
                    shipment = goods.getShipments().get(i);
                    productionDateString = shipment.getNsx().format(DateTimeFormatter.ofPattern(outputDatePatternForUF));
                    expirationDateString = shipment.getHsd().format(DateTimeFormatter.ofPattern(outputDatePatternForUF));
                    System.out.printf("| %-" + String.format(NAME_MAX_SIZE + PROVIDER_MAX_SIZE + LIST_PRICE_MAX_SIZE + TOTAL_QUANTITY_MAX_SIZE + 20 + "s")
                            + " | %-11s | %-15s | %-15s | %-" + String.format(IMPORT_PRICE_MAX_SIZE + "s") + " | %-" + String.format(QUANTITY_MAX_SIZE + "s") + " |\n",
                            "",
                            shipment.getShipmentID(),
                            productionDateString,
                            expirationDateString,
                            shipment.getImportPrice(),
                            shipment.getQuantity());
                }
            } else {
                System.out.printf(" %-11s | %-15s | %-15s | %-" + String.format(IMPORT_PRICE_MAX_SIZE + "s")
                        + " | %-" + String.format(QUANTITY_MAX_SIZE + "s") + " |\n", "", "", "", "", "", "");
            }
            System.out.println("|" + "-".repeat(NAME_MAX_SIZE + PROVIDER_MAX_SIZE + LIST_PRICE_MAX_SIZE
                    + TOTAL_QUANTITY_MAX_SIZE + IMPORT_PRICE_MAX_SIZE + QUANTITY_MAX_SIZE + 78) + "|");
        }
    }

    public int shipmentCompare(Shipment shipment, Goods goods) {
        // return -1 if shipments in goods not contain shipment
        // != 0 if shipments in goods contain shipment and is the index of shipment in
        // goods'sshipments
        int i = 0;
        int length = goods.getShipments().size();
        for (i = 0; i < length; i++) {
            Shipment temp = goods.getShipments().get(i);
            if (temp.getImportPrice() == shipment.getImportPrice()
                    && temp.getHsd().isEqual(shipment.getHsd())
                    && temp.getNsx().isEqual(shipment.getNsx())) {
                break;
            }
        }
        if (i == length) {
            return -1;
        }
        return i;
    }

    public int goodsCompare(Goods goods, List<Goods> goodsList) {
        int i = 0;
        if (goodsList == null) {
            return 0;
        } else {
            for (Goods goodNeedCompare : goodsList) {
                if (goodNeedCompare.getGoodsName().equalsIgnoreCase(goods.getGoodsName())
                        && goodNeedCompare.getProvider().equalsIgnoreCase(goods.getProvider())) {
                    i = 1;
                } else {
                    i = 0;
                }
            }
            return i;
        }
    }

    public Shipment searchShipments(Goods goods) {
        // tra ve 0 neu khong ton tai shipment nao trong goods
        // -1 neu chon 'BACK', >1 neu tim duoc shipment
        List<Goods> bucket = new ArrayList<>();
        if (goods.getShipments().isEmpty()) {
            System.out.println("No shipment exist within the goods");
            System.out.println("Aborting...");
            return null;
        }
        bucket.add(goods);
        do {
            showGoodsList(bucket);
            System.out.print("Input shipment ID or type BACK to go back: ");
            String input = sc.nextLine();
            if (input.equalsIgnoreCase("back")) {
                System.out.println("Back...");
                return null;
            } else {
                for (Shipment shipment : goods.getShipments()) {
                    if (input.equals(shipment.getShipmentID())) {
                        return shipment;
                    }
                }
                System.out.println("No shipment found!");
            }
        } while (true);
    }

}
