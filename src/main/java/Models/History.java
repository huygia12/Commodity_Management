/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Models;

import java.util.List;
import java.util.Scanner;

/**
 *
 * @author FPTSHOP
 */
public class History {

    final Scanner sc = new Scanner(System.in);
    private List<Order> orderHistory;
    private List<ImportedGoods> importGoodsHistory;
    private List<Shift> shiftHistory;

    private int orderIDMaxSize;
    private int orderDateTimeMaxSize;
    private int paymentOptionsMaxSize;
    private int totalMaxSize;

    private int importGoodsIDMaxSize;
    private int importDateMaxSize;
    private int importGoodsNameMaxSize;
    private int manufactureMaxSize;
    private int quantityMaxSize;
    private int hsdMaxSize;
    private int nsxMaxSize;
    private int importPriceMaxSize;

    public History(List<Order> orderHistory, List<ImportedGoods> importGoodsHistory, List<Shift> shiftHistory) {
        this.orderHistory = orderHistory;
        this.importGoodsHistory = importGoodsHistory;
        this.shiftHistory = shiftHistory;
    }

    public History(List<Shift> shiftHistory) {
        this.shiftHistory = shiftHistory;
    }

    public History() {
    }

    public List<Order> getOrderHistory() {
        return orderHistory;
    }

    public void setOrderHistory(List<Order> orderHistory) {
        this.orderHistory = orderHistory;
    }

    public List<ImportedGoods> getImportGoodsHistory() {
        return importGoodsHistory;
    }

    public void setImportGoodsHistory(List<ImportedGoods> importGoodsHistory) {
        this.importGoodsHistory = importGoodsHistory;
    }

    public List<Shift> getShiftHistory() {
        return shiftHistory;
    }

    public void setShiftHistory(List<Shift> shiftHistory) {
        this.shiftHistory = shiftHistory;
    }

    public void showOrderHistory(List<Order> orderHistory) {
        if (orderHistory.isEmpty()) {
            System.out.println("Nothing found in this order history!");
            return;
        }
        computeSizeOfEachOrderHistoryColumn(orderHistory);
        int totalColSize = orderIDMaxSize + orderDateTimeMaxSize + paymentOptionsMaxSize
                + totalMaxSize + 3 + 6;
        final int extraLengthOfBorder = 11;
        int borderLength = totalColSize + extraLengthOfBorder;
        System.out.println("|" + "-".repeat(borderLength) + "|");
        System.out.printf("| %-" + String.format(orderIDMaxSize + "s")
                + " | %-" + String.format(orderDateTimeMaxSize + "s")
                + " | %-" + String.format(paymentOptionsMaxSize + "s")
                + " | %-" + String.format(totalMaxSize + "s"),
                "Order ID",
                "Date&Time",
                "PaymentOption",
                "Total");
        System.out.println("|" + "-".repeat(borderLength) + "|");
        for (Order order : orderHistory) {
            System.out.printf("| %-" + String.format(orderIDMaxSize + "s")
                    + " | %-" + String.format(orderDateTimeMaxSize + "s")
                    + " | %-" + String.format(paymentOptionsMaxSize + "s")
                    + " | %-" + String.format(totalMaxSize + "s"),
                    order.getID(),
                    order.getOrderDateTime(),
                    order.getPaymentOptions(),
                    order.getTotal());
            System.out.println("|" + "-".repeat(borderLength) + "|");
        }
    }

    private void computeSizeOfEachOrderHistoryColumn(List<Order> orderHistory) {
        orderIDMaxSize = "Order ID".length();
        orderDateTimeMaxSize = "Created Date&Time".length();
        paymentOptionsMaxSize = "PaymentOptions".length();
        totalMaxSize = "Total".length();
        for (Order order : orderHistory) {
            if (order.getID().length() > orderIDMaxSize) {
                orderIDMaxSize = order.getID().length();
            }
            if (order.getOrderDateTime().length() > orderDateTimeMaxSize) {
                orderDateTimeMaxSize = order.getOrderDateTime().length();
            }
            if ((order.getPaymentOptions() + "").length() > paymentOptionsMaxSize) {
                paymentOptionsMaxSize = (order.getPaymentOptions() + "").length();
            }
            if ((order.getTotal() + "").length() > totalMaxSize) {
                totalMaxSize = (order.getTotal() + "").length();
            }
        }
    }

    public void showImportGoodsHistory(List<ImportedGoods> importGoodsHistory) {
        if (importGoodsHistory.isEmpty()) {
            System.out.println("Nothing found in this import goods history!");
            return;
        }
        computeSizeOfEachImportGoodsHistoryColumn(importGoodsHistory);
        int totalColSize = importGoodsIDMaxSize + importDateMaxSize + manufactureMaxSize
                + quantityMaxSize + hsdMaxSize + nsxMaxSize
                + importPriceMaxSize+ importGoodsNameMaxSize + 3 + 6;
        final int extraLengthOfBorder = 11;
        int borderLength = totalColSize + extraLengthOfBorder;
        System.out.println("|" + "-".repeat(borderLength) + "|");
        System.out.printf("| %-" + String.format(importGoodsIDMaxSize + "s")
                + " | %-" + String.format(importGoodsNameMaxSize + "s")
                + " | %-" + String.format(importDateMaxSize + "s")
                + " | %-" + String.format(quantityMaxSize + "s"),
                "Goods ID",
                "Goods Name",
                "Import Date&Time",
                "Quantity");
        System.out.println("|" + "-".repeat(borderLength) + "|");
        for (ImportedGoods importGoods : importGoodsHistory) {
            System.out.printf("| %-" + String.format(importGoodsIDMaxSize + "s")
                    + " | %-" + String.format(importGoodsNameMaxSize + "s")
                    + " | %-" + String.format(importDateMaxSize + "s")
                    + " | %-" + String.format(quantityMaxSize + "s"),
                    importGoods.getID(),
                    importGoods.getGoodsName(),
                    importGoods.getImportDateTime(),
                    importGoods.getTotalQuantity());
            System.out.println("|" + "-".repeat(borderLength) + "|");
        }
    }

    private void computeSizeOfEachImportGoodsHistoryColumn(List<ImportedGoods> importGoodsHistory) {
        importGoodsIDMaxSize = "Goods ID".length();
        importDateMaxSize = "Imported Date&Time".length();
        manufactureMaxSize = "Manufacture".length();
        quantityMaxSize = "Quantity".length();
        hsdMaxSize = "Expiration Date".length();
        nsxMaxSize = "Production Date".length();
        importPriceMaxSize = "Import Price".length();
        importGoodsNameMaxSize = "Goods Name".length();
        for (ImportedGoods tmp : importGoodsHistory) {
            if (tmp.getID().length() > importGoodsIDMaxSize) {
                importGoodsIDMaxSize = tmp.getID().length();
            }
            if (tmp.getImportDateTime().length() > importDateMaxSize) {
                importDateMaxSize = tmp.getImportDateTime().length();
            }
            if (tmp.getManufacture().length() > manufactureMaxSize) {
                manufactureMaxSize = tmp.getManufacture().length();
            }
            if ((tmp.getTotalQuantity()+ "").length() > quantityMaxSize) {
                quantityMaxSize = (tmp.getTotalQuantity() + "").length();
            }
            if ((tmp.getShipments().get(0).getHsd() + "").length() > hsdMaxSize) {
                hsdMaxSize = (tmp.getShipments().get(0).getHsd() + "").length();
            }
            if ((tmp.getShipments().get(0).getNsx() + "").length() > nsxMaxSize) {
                nsxMaxSize = (tmp.getShipments().get(0).getNsx()  + "").length();
            }
            if ((tmp.getShipments().get(0).getImportPrice() + "").length() > importPriceMaxSize) {
                importPriceMaxSize = (tmp.getShipments().get(0).getImportPrice() + "").length();
            }
            if (tmp.getGoodsName().length() > importGoodsNameMaxSize) {
                importGoodsNameMaxSize = tmp.getGoodsName().length();
            }
        }
    }

}
