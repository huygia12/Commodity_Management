/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Models;

import java.util.ArrayList;
import java.util.List;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

/**
 *
 * @author FPTSHOP
 */
public class GoodsList {
    final Scanner sc = new Scanner(System.in);
    private final String OUTPUT_DATE_PATTERN = "dd/MM/yyyy";
    private int nameMaxSize;
    private int providerMaxSize;
    private int listPriceMaxSize;
    private int totalQuantityMaxSize;
    private int importPriceMaxSize;
    private int quantityMaxSize;
    private List<Goods> myGoodsList = new ArrayList<>();

    public GoodsList() {}

    public GoodsList(List<Goods> goodsList) {
        this.myGoodsList = goodsList;
    }

    
    public List<Goods> getGoodsList() {
        return myGoodsList;
    }

    public void setGoodsList(List<Goods> goodsList) {
        this.myGoodsList = goodsList;
    }

    
    public int indexOfDupGoods(Goods checkingGoods) {
        // tra ve index cua goods dau tien trong goodsList co manufac va name giong voi checkingGoods
        for (Goods goods : this.myGoodsList) {
            if (goods.twoGoodsIsDup(checkingGoods)) {
                return this.myGoodsList.indexOf(goods);
            }
        }
        return -1;
    }

    public void showGoodsList() {
        if (this.getGoodsList().isEmpty()) {
            System.out.println("Nothing found in this List!");
            return;
        }
        System.out.println();
        this.computeSizeEachColumn();
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
                + " | %11s | %-15s | %-15s | %-" + String.format(importPriceMaxSize + "s")
                + " | %-" + String.format(quantityMaxSize + "s")
                + " |\n",
                "Goods ID", "Name",
                "Provider",
                "List Price",
                "Total Quantity",
                "Shipment ID", "Production Date", "Expiration Date", "Import Price",
                "Quantity");
        System.out.println("|" + "-".repeat(totalColumnsSize + 78) + "|");
        for (Goods goods : this.myGoodsList) {
            System.out.printf("| %-8s | %-" + String.format(nameMaxSize + "s")
                    + " | %-" + String.format(providerMaxSize + "s")
                    + " | %-" + String.format(listPriceMaxSize + "s")
                    + " | %-" + String.format(totalQuantityMaxSize + "s") + " |",
                    goods.getID(),
                    goods.getGoodsName(),
                    goods.getManufacture(),
                    goods.getListPrice(),
                    goods.getTotalQuanByShipments());
            if (!goods.getShipments().isEmpty()) {
                // Neu list shipment cua goods da ton tai it nhat 1 shipment, thuc hien in ra shipment do
                Shipment shipment = goods.getShipments().get(0);
                String productionDateString = formatDate(shipment.getNsx(), OUTPUT_DATE_PATTERN);
                String expirationDateString = formatDate(shipment.getHsd(), OUTPUT_DATE_PATTERN);
                System.out.printf(" %-11s | %-15s | %-15s | %-"
                        + String.format(importPriceMaxSize + "s")
                        + " | %-" + String.format(quantityMaxSize + "s")
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
                            + " | %-" + String.format(importPriceMaxSize + "s")
                            + " | %-" + String.format(quantityMaxSize + "s") + " |\n",
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

    private void computeSizeEachColumn() {
        // duyet tu dau den cuoi mang de tim MAX_SIZE cua giatri input tung thuoc tinh
        nameMaxSize = "Name".length();
        providerMaxSize = "Provider".length();
        listPriceMaxSize = "List Price".length();
        totalQuantityMaxSize = "Total Quantity".length();
        importPriceMaxSize = "Import Price".length();
        quantityMaxSize = "Quantity".length();
        for (Goods goods : this.myGoodsList) {
            if (goods.getGoodsName().length() > nameMaxSize) {
                nameMaxSize = goods.getGoodsName().length();
            }
            if (goods.getManufacture().length() > providerMaxSize) {
                providerMaxSize = goods.getManufacture().length();
            }
            if (goods.getListPrice().toString().length() > listPriceMaxSize) {
                listPriceMaxSize = goods.getListPrice().toString().length();
            }
            if (goods.getTotalQuanByShipments().toString().length() > totalQuantityMaxSize) {
                totalQuantityMaxSize = goods.getTotalQuanByShipments().toString().length();
            }
            for (Shipment shipment : goods.getShipments()) {
                if (shipment.getImportPrice().toString().length() > importPriceMaxSize) {
                    importPriceMaxSize = shipment.getImportPrice().toString().length();
                }
                if (shipment.getQuantity().toString().length() > quantityMaxSize) {
                    quantityMaxSize = shipment.getQuantity().toString().length();
                }
            }
        }
    }

    public String formatDate(LocalDate date, String formatPattern) {
        return date.format(DateTimeFormatter.ofPattern(formatPattern));
    }

    public Goods containGoods(String id) {
        for (Goods tmpGoods : this.myGoodsList) {
            if (tmpGoods.getID().equals(id)) {
                return tmpGoods;
            }
        }
        return null;
    }

    public Goods searchGoods() {
        // tra ve null neu nguoi dung nhap 'back', nguoc lai, tra ve 1 goods duoc tim kiem
        if (this.getGoodsList().isEmpty()) {
            System.out.println("Cannot search in an empty List!");
            return null;
        }
        String inputStr = new String();
        boolean completed = false;
        Goods searchingGoods = null;
        do {
            try {
                System.out.print("Input productID to search(Type name for suggestion or press 'Enter' to see the whole List) or BACK to go back: ");
                inputStr = sc.nextLine();
                if ("back".equalsIgnoreCase(inputStr)) {
                    return null;
                }
                int searchingKey = Integer.parseInt(inputStr);
                searchingGoods = containGoods(inputStr);
                if (searchingGoods == null) {
                    System.out.println("Your input ID doesnt exist.");
                    continue;
                }
                completed = true;
            } catch (NumberFormatException nfe) {
                // name suggestions for users
                GoodsList bucket = new GoodsList(new ArrayList<>());
                String inputToLowerCase = inputStr.toLowerCase();
                for (Goods tmpGoods : this.myGoodsList) {
                    String nameToLowerCase = tmpGoods.getGoodsName().toLowerCase();
                    if (nameToLowerCase.contains(inputToLowerCase)) {
                        bucket.getGoodsList().add(tmpGoods);
                    }
                }
                if (bucket.getGoodsList().isEmpty()) {
                    System.out.println("No product match with your input!");
                } else {
                    System.out.print("\nSearching : \"" + inputStr + "\"");
                    bucket.showGoodsList();
                }
            }
        } while (!completed);
        return searchingGoods;
    }
}
