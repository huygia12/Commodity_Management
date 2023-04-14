/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.sourcecode;

import java.awt.AWTException;
import java.awt.Robot;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author s1rja
 */
public class UsefulFunctions {

    Scanner sc = new Scanner(System.in);
    final String OUTPUT_DATE_PATTERN = "dd/MM/yyyy";
    final LocalDate CURRENT_DATE = LocalDate.now();
    int nameMaxSize;
    int providerMaxSize;
    int listPriceMaxSize;
    int totalQuantityMaxSize;
    int importPriceMaxSize;
    int quantityMaxSize;

    public void clearScreen() {
        try {
            Robot pressbot = new Robot();
            pressbot.keyPress(17); // Holds CTRL key.
            pressbot.keyPress(76); // Holds L key.
            pressbot.keyRelease(17); // Releases CTRL key.
            pressbot.keyRelease(76); // Releases L key.
            sc.nextLine();
            pressbot.keyPress(13); // Holds Enter key.
            pressbot.keyRelease(13);
        } catch (AWTException ex) {
            Logger.getLogger(Logger.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void typeAnyKeyToContinue() {
        System.out.println("\nType any key to continue...");
        sc.nextLine();
    }

    public Goods findGoodsWithID(String id, List<Goods> goodsList) {
        for (Goods tmpGoods : goodsList) {
            if (tmpGoods.getGoodsID().equals(id)) {
                return tmpGoods;
            }
        }
        return null;
    }

    public boolean checkIfShipmentExisted(String id, List<Shipment> shipmentList) {
        for (Shipment shipment : shipmentList) {
            if (shipment.getShipmentID().equals(id)) {
                return true;
            }
        }
        return false;
    }

    public <E> boolean checkIfListEmpty(List<E> goodsList) {
        if (goodsList.isEmpty()) {
            System.out.println("Cannot process in an empty List!");
            return true;
        }
        return false;
    }

    public boolean checkIfNumPositive(int num) {
        if (num <= 0) {
            System.out.println("Must be a positive number!");
            return false;
        }
        return true;
    }

    public int checkIfDuplicateGoodsExisted(List<Goods> goodsList, Goods checkingGoods) {
        // return index of the first dupicate goods in list, otherwise -1 will be returned
        for (Goods goods : goodsList) {
            if (goods.checkIfTwoGoodsIsDuplicate(checkingGoods)) {
                System.out.println("Same goods detected!");
                System.out.println("Aborting...");
                return goodsList.indexOf(goods);
            }
        }
        return -1;
    }

    public boolean noInputCase(String str) {
        if ("".equalsIgnoreCase(str)) {
            System.out.println("Input is required!");
            return true;
        }
        return false;
    }

    public boolean backCase(String str) {
        return "back".equalsIgnoreCase(str);
    }

    public boolean exitCase(String str) {
        return "exit".equalsIgnoreCase(str);
    }

    public void computeSizeOfEachColumn(List<Goods> goodsList) {
        // duyet tu dau den cuoi mang de lay MAX_SIZE cua giatri input tung attributes
        nameMaxSize = "Name".length();
        providerMaxSize = "Provider".length();
        listPriceMaxSize = "List Price".length();
        totalQuantityMaxSize = "Total Quantity".length();
        importPriceMaxSize = "Import Price".length();
        quantityMaxSize = "Quantity".length();
        for (Goods goods : goodsList) {
            if (goods.getGoodsName().length() > nameMaxSize) {
                nameMaxSize = goods.getGoodsName().length();
            }
            if (goods.getProvider().length() > providerMaxSize) {
                providerMaxSize = goods.getProvider().length();
            }
            if (Long.toString(goods.getListPrice()).length() > listPriceMaxSize) {
                listPriceMaxSize = Long.toString(goods.getListPrice()).length();
            }
            if (Integer.toString(goods.getTotalQuantity()).length() > totalQuantityMaxSize) {
                totalQuantityMaxSize = Integer.toString(goods.getTotalQuantity()).length();
            }
            for (Shipment shipment : goods.getShipments()) {
                if (Long.toString(shipment.getImportPrice()).length() > importPriceMaxSize) {
                    importPriceMaxSize = Long.toString(shipment.getImportPrice()).length();
                }
                if (Integer.toString(shipment.getQuantity()).length() > quantityMaxSize) {
                    quantityMaxSize = Integer.toString(shipment.getQuantity()).length();
                }
            }
        }
    }

    public String dateFormat(LocalDate date, String formatPattern) {
        return date.format(DateTimeFormatter.ofPattern(formatPattern));
    }

    public void showGoodsList(List<Goods> goodsList) {
        if (checkIfListEmpty(goodsList)) {
            return;
        }
        System.out.println();
        computeSizeOfEachColumn(goodsList);
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
        for (Goods goods : goodsList) {
            System.out.printf("| %-8s | %-" + String.format(nameMaxSize + "s")
                    + " | %-" + String.format(providerMaxSize + "s")
                    + " | %-" + String.format(listPriceMaxSize + "s")
                    + " | %-" + String.format(totalQuantityMaxSize + "s") + " |",
                    goods.getGoodsID(),
                    goods.getGoodsName(),
                    goods.getProvider(),
                    goods.getListPrice(),
                    goods.getTotalQuantity());
            if (!goods.getShipments().isEmpty()) {
                // If shipments already existed, fill them in the conlumns
                Shipment shipment = goods.getShipments().get(0);
                String productionDateString = dateFormat(shipment.getNsx(), OUTPUT_DATE_PATTERN);
                String expirationDateString = dateFormat(shipment.getHsd(), OUTPUT_DATE_PATTERN);
                System.out.printf(" %-11s | %-15s | %-15s | %-"
                        + String.format(importPriceMaxSize + "s")
                        + " | %-" + String.format(quantityMaxSize + "s")
                        + " |\n",
                        shipment.getShipmentID(), productionDateString, expirationDateString,
                        shipment.getImportPrice(),
                        shipment.getQuantity());
                // If existed more than 1 shipment, use for-loop to print all the others
                for (int i = 1; i < goods.getShipments().size(); i++) {
                    shipment = goods.getShipments().get(i);
                    productionDateString = dateFormat(shipment.getNsx(), OUTPUT_DATE_PATTERN);
                    expirationDateString = dateFormat(shipment.getHsd(), OUTPUT_DATE_PATTERN);
                    int spaceInGoodsColumns = nameMaxSize + providerMaxSize + listPriceMaxSize + totalQuantityMaxSize + 20;
                    System.out.printf("| %-" + String.format(spaceInGoodsColumns + "s")
                            + " | %-11s | %-15s | %-15s"
                            + " | %-" + String.format(importPriceMaxSize + "s")
                            + " | %-" + String.format(quantityMaxSize + "s") + " |\n",
                            "",
                            shipment.getShipmentID(), productionDateString, expirationDateString,
                            shipment.getImportPrice(),
                            shipment.getQuantity());
                }
            } else {
                // If haven't imported any goods yet, not fill in anything in the column
                System.out.printf(" %-11s | %-15s | %-15s | %-" + String.format(importPriceMaxSize + "s")
                        + " | %-" + String.format(quantityMaxSize + "s") + " |\n",
                        "", "", "", "", "");
            }
            System.out.println("|" + "-".repeat(borderLength) + "|");
        }
    }

    public Goods searchGoods(List<Goods> goodsList) {
        // return null if list is empty or choose 'back', otherwise A goods will be returned
        if (checkIfListEmpty(goodsList)) {
            return null;
        }
        String inputStr = new String();
        boolean completed = false;
        Goods searchingGoods = null;
        do {
            try {
                System.out.print("Input productID to search(Type name for suggestion) or Back to go back: ");
                inputStr = sc.nextLine();
                if (backCase(inputStr)) {
                    break;
                }
                int searchingKey = Integer.parseInt(inputStr);
                searchingGoods = findGoodsWithID(inputStr, goodsList);
                if (searchingGoods == null) {
                    System.out.println("Your input ID doesnt exist.");
                    continue;
                }
                completed = true;
            } catch (NumberFormatException nfe) {
                // name suggestions for users
                List<Goods> bucket = new ArrayList<>();
                for (Goods tmpGoods : goodsList) {
                    String nameToLowerCase = tmpGoods.getGoodsName().toLowerCase();
                    String inputToLowerCase = inputStr.toLowerCase();
                    if (nameToLowerCase.contains(inputToLowerCase)) {
                        bucket.add(tmpGoods);
                    }
                }
                if (bucket.isEmpty()) {
                    System.out.println("No product match with your input!");
                } else {
                    System.out.print("\nSearching : \"" + inputStr + "\"");
                    showGoodsList(bucket);
                }
            }
        } while (!completed);
        return searchingGoods;
    }

    public Shipment searchShipments(Goods goods) {
        List<Goods> bucket = new ArrayList<>();
        if (checkIfListEmpty(goods.getShipments())) {
            return null;
        }
        bucket.add(goods);
        do {
            showGoodsList(bucket);
            System.out.print("Input shipment ID or type BACK to go back: ");
            String inputStr = sc.nextLine();
            if (backCase(inputStr)) {
                System.out.println("Back...");
                return null;
            } else {
                for (Shipment shipment : goods.getShipments()) {
                    if (inputStr.equals(shipment.getShipmentID())) {
                        return shipment;
                    }
                }
                System.out.println("No shipment found!");
            }
        } while (true);
    }
}
