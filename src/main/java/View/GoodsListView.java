/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package View;

import Controllers.GoodsController;
import Models.Goods;
import Models.GoodsList;
import Models.Shipment;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

/**
 *
 * @author FPTSHOP
 */
public class GoodsListView {
    private final String OUTPUT_DATE_PATTERN = "dd/MM/yyyy";
    private int nameMaxSize;
    private int providerMaxSize;
    private int listPriceMaxSize;
    private int totalQuantityMaxSize;
    private int importPriceMaxSize;
    private int quantityMaxSize;
    
    public<T extends Goods> void showGoodsList(GoodsList<T> myGoodsList) {
        if (myGoodsList.getGoodsList().isEmpty()) {
            System.out.println("Nothing found in this List!");
            return;
        }
        System.out.println();
        this.computeSizeEachColumn(myGoodsList);
        int totalColumnsSize = nameMaxSize
                + providerMaxSize
                + listPriceMaxSize
                + totalQuantityMaxSize
                + importPriceMaxSize
                + quantityMaxSize;
        final int extralengthOfBorder = 78;
        int borderLength = extralengthOfBorder + totalColumnsSize;
        System.out.println("|" + "-".repeat(borderLength) + "|");
        System.out.printf("| %-8s | %-" + String.format(nameMaxSize + "s")
                + " | %-" + String.format(providerMaxSize + "s")
                + " | %-" + String.format(listPriceMaxSize + "s")
                + " | %-" + String.format(totalQuantityMaxSize + "s")
                + " | %-11s | %-15s | %-15s | %-" + String.format(importPriceMaxSize + "s")
                + " | %-" + String.format(quantityMaxSize + "s")
                + " |\n",
                "Goods ID", "Name",
                "Provider",
                "List Price",
                "Total Quantity",
                "Shipment ID", "Production Date", "Expiration Date", "Import Price",
                "Quantity");
        System.out.println("|" + "-".repeat(totalColumnsSize + 78) + "|");
        for (Goods goods : myGoodsList.getGoodsList()) {
            System.out.printf("| %-8s | %-" + String.format(nameMaxSize + "s")
                    + " | %-" + String.format(providerMaxSize + "s")
                    + " | %-" + String.format(listPriceMaxSize + ".1f")
                    + " | %-" + String.format(totalQuantityMaxSize + ".1f") + " |",
                    goods.getID(),
                    goods.getGoodsName(),
                    goods.getManufacture(),
                    goods.getListPrice(),
                    new GoodsController().getTotalQuanByShipments(goods));
            if (!goods.getShipments().isEmpty()) {
                // Neu list shipment cua goods da ton tai it nhat 1 shipment, thuc hien in ra shipment do
                Shipment shipment = goods.getShipments().get(0);
                String productionDateString = formatDate(shipment.getNsx(), OUTPUT_DATE_PATTERN);
                String expirationDateString = formatDate(shipment.getHsd(), OUTPUT_DATE_PATTERN);
                System.out.printf(" %-11s | %-15s | %-15s | %-"
                        + String.format(importPriceMaxSize + ".1f")
                        + " | %-" + String.format(quantityMaxSize + ".1f")
                        + " |\n",
                        shipment.getID(), productionDateString, expirationDateString,
                        shipment.getImportPrice(),
                        shipment.getQuantity());
                // Neu co >1 shipment, thuc hien ra cac shipment con lai
                for (int i = 1; i < goods.getShipments().size(); i++) {
                    shipment = goods.getShipments().get(i);
                    productionDateString = formatDate(shipment.getNsx(), OUTPUT_DATE_PATTERN);
                    expirationDateString = formatDate(shipment.getHsd(), OUTPUT_DATE_PATTERN);
                    int spaceInGoodsColumns = nameMaxSize + providerMaxSize + listPriceMaxSize + totalQuantityMaxSize + 20;
                    System.out.printf("| %-" + String.format(spaceInGoodsColumns + "s")
                            + " | %-11s | %-15s | %-15s"
                            + " | %-" + String.format(importPriceMaxSize + ".1f")
                            + " | %-" + String.format(quantityMaxSize + ".1f") + " |\n",
                            "",
                            shipment.getID(), productionDateString, expirationDateString,
                            shipment.getImportPrice(),
                            shipment.getQuantity());
                }
            } else {
                // Neu chua co shipment nao ton tai, thuc hien in ra khoang trang trong cac cot thuoc tinh
                System.out.printf(" %-11s | %-15s | %-15s | %-" + String.format(importPriceMaxSize + "s")
                        + " | %-" + String.format(quantityMaxSize + "s") + " |\n",
                        "", "", "", "", "");
            }
            System.out.println("|" + "-".repeat(borderLength) + "|");
        }
    }
    
    
    private String formatDate(LocalDate date, String formatPattern) {
        return date.format(DateTimeFormatter.ofPattern(formatPattern));
    }

    private<T extends Goods> void computeSizeEachColumn(GoodsList<T> myGoodsList) {
        GoodsController goodsCtr = new GoodsController();
        // duyet tu dau den cuoi mang de tim MAX_SIZE cua giatri input tung thuoc tinh
        nameMaxSize = "Name".length();
        providerMaxSize = "Provider".length();
        listPriceMaxSize = "List Price".length();
        totalQuantityMaxSize = "Total Quantity".length();
        importPriceMaxSize = "Import Price".length();
        quantityMaxSize = "Quantity".length();
        for (T goods : myGoodsList.getGoodsList()) {
            if (goods.getGoodsName().length() > nameMaxSize) {
                nameMaxSize = goods.getGoodsName().length();
            }
            if (goods.getManufacture().length() > providerMaxSize) {
                providerMaxSize = goods.getManufacture().length();
            }
            if (String.format(".1f", goods.getListPrice()).length() > listPriceMaxSize) {
                listPriceMaxSize = String.format(".1f", goods.getListPrice()).length();
            }
            if (String.format(".1f", goodsCtr.getTotalQuanByShipments(goods)).length() > totalQuantityMaxSize) {
                totalQuantityMaxSize = String.format(".1f", goodsCtr.getTotalQuanByShipments(goods)).length();
            }
            for (Shipment shipment : goods.getShipments()) {
                if (String.format(".1f", shipment.getImportPrice()).length() > importPriceMaxSize) {
                    importPriceMaxSize = String.format(".1f", shipment.getImportPrice()).length();
                }
                if (String.format(".1f", shipment.getQuantity()).length() > quantityMaxSize) {
                    quantityMaxSize = String.format(".1f", shipment.getQuantity()).length();
                }
            }
        }
    }
}
