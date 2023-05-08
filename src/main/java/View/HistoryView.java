/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package View;

import Models.CustomPair;
import Models.Goods;
import Models.GoodsList;
import Models.History;
import Models.ImportedGoods;
import Models.Order;
import Models.Shift;
import java.time.DateTimeException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Scanner;
import java.util.Set;

/**
 *
 * @author FPTSHOP
 */
public class HistoryView {

    final Cautions ctions = new Cautions();
    final Scanner sc = new Scanner(System.in);
    final String inputDateFormat = "dd/MM/yyyy";
    private int orderIDMaxSize;
    private int orderDateTimeMaxSize;
    private int totalMaxSize;

    private int goodsNameMaxSize;
    private int goodsIDMaxSize;
    private int goodsQuanMaxSize;

    private int paymentOptionsMaxSize;
    private int customerCardMaxSize;

    private int importGoodsIDMaxSize;
    private int importDateMaxSize;
    private int importGoodsNameMaxSize;
    private int quantityMaxSize;

    private int manufactureMaxSize;
    private int hsdMaxSize;
    private int nsxMaxSize;
    private int importPriceMaxSize;

    private int shiftIDMaxSize;
    private int shiftOpenDateTimeMaxSize;
    private int shiftEndDateTimeMaxSize;
    private int netRevenueMaxSize;

    public void menuOfHistoryManagement() {
        System.out.println("\n***************************************");
        System.out.println("* 1. Statistic of Orders from - to     *");
        System.out.println("* 2. Statistic of Imports from - to    *");
        System.out.println("* 3. Statistic of Shifts from - to     *");
        System.out.println("* 4. Search an Order in History       *");
        System.out.println("* 5. Search an ImportGoods in History *");
        System.out.println("* 6. Search a Shift in History        *");
        System.out.println("* 7. Back                             *");
        System.out.println("***************************************");
        System.out.print("Option => ");
    }

    public void showOrderHistory(History history) {
        if (history.getShiftHistory().isEmpty()) {
            System.out.println("No order found!");
            return;
        }
        computeSizeOfEachOrderHistoryColumn(history);
        int totalColSize = orderIDMaxSize + orderDateTimeMaxSize + totalMaxSize + 3 + 6;
        final int extraLengthOfBorder = 11;
        int borderLength = totalColSize + extraLengthOfBorder;
        System.out.println("|" + "-".repeat(borderLength) + "|");
        System.out.printf("| %-" + String.format(orderIDMaxSize + "s")
                + " | %-" + String.format(orderDateTimeMaxSize + "s")
                + " | %-" + String.format(shiftIDMaxSize + "s")
                + " | %-" + String.format(totalMaxSize + "s"),
                "Order ID",
                "Innitiated Date&Time",
                "Shift ID",
                "Total");
        System.out.println("|" + "-".repeat(borderLength) + "|");
        for (Shift shift : history.getShiftHistory()) {
            for (Order order : shift.getOrderHisPerShift()) {
                System.out.printf("| %-" + String.format(orderIDMaxSize + "s")
                        + " | %-" + String.format(orderDateTimeMaxSize + "s")
                        + " | %-" + String.format(shiftIDMaxSize + "s")
                        + " | %-" + String.format(totalMaxSize + "s"),
                        order.getID(),
                        order.getOrderDateTime(),
                        shift.getID(),
                        order.getTotal());
                System.out.println("|" + "-".repeat(borderLength) + "|");
            }
        }
    }

    private void computeSizeOfEachOrderHistoryColumn(History history) {
        orderIDMaxSize = "Order ID".length();
        orderDateTimeMaxSize = "Innitiated Date&Time".length();
        totalMaxSize = "Total".length();
        for (Shift shift : history.getShiftHistory()) {
            for (Order order : shift.getOrderHisPerShift()) {
                if (order.getID().length() > orderIDMaxSize) {
                    orderIDMaxSize = order.getID().length();
                }
                if (order.getOrderDateTime().length() > orderDateTimeMaxSize) {
                    orderDateTimeMaxSize = order.getOrderDateTime().length();
                }
                if ((order.getTotal() + "").length() > totalMaxSize) {
                    totalMaxSize = (order.getTotal() + "").length();
                }
            }
            if (shift.getID().length() > shiftIDMaxSize) {
                shiftIDMaxSize = shift.getID().length();
            }
        }
    }

    public void showDetailInOrderHistory(GoodsList goodsList) {
        if (goodsList.getGoodsList().isEmpty()) {
            System.out.println("No goods found!");
            return;
        }
        computeSizeOfEachDetailInOrderHistoryColumn(goodsList);
        int totalColSize = goodsIDMaxSize + goodsNameMaxSize + goodsQuanMaxSize + 3 + 6;
        final int extraLengthOfBorder = 11;
        int borderLength = totalColSize + extraLengthOfBorder;
        System.out.println("|" + "-".repeat(borderLength) + "|");
        System.out.printf("| %-" + String.format(goodsIDMaxSize + "s")
                + " | %-" + String.format(goodsNameMaxSize + "s")
                + " | %-" + String.format(goodsQuanMaxSize + "s"),
                "Goods ID",
                "Goods Name",
                "Quantity");
        System.out.println("|" + "-".repeat(borderLength) + "|");
        for (Goods goods : goodsList.getGoodsList()) {
            System.out.printf("| %-" + String.format(goodsIDMaxSize + "s")
                    + " | %-" + String.format(goodsNameMaxSize + "s")
                    + " | %-" + String.format(goodsQuanMaxSize + "s"),
                    goods.getID(),
                    goods.getGoodsName(),
                    goods.getTotalQuantity());
            System.out.println("|" + "-".repeat(borderLength) + "|");
        }
    }

    private void computeSizeOfEachDetailInOrderHistoryColumn(GoodsList goodsList) {
        goodsIDMaxSize = "Order ID".length();
        goodsNameMaxSize = "Goods Name".length();
        goodsQuanMaxSize = "Quantity".length();
        for (Goods goods : goodsList.getGoodsList()) {
            if (goods.getID().length() > goodsIDMaxSize) {
                goodsIDMaxSize = goods.getID().length();
            }
            if (goods.getGoodsName().length() > goodsNameMaxSize) {
                goodsNameMaxSize = goods.getGoodsName().length();
            }
            if ((goods.getTotalQuanByShipments() + "").length() > goodsQuanMaxSize) {
                goodsQuanMaxSize = (goods.getTotalQuanByShipments() + "").length();
            }
        }
    }

    public void showImportGoodsHistory(History history) {
        if (history.getShiftHistory().isEmpty()) {
            System.out.println("No Imported Goods found!");
            return;
        }
        computeSizeOfEachImportGoodsHistoryColumn(history);
        int totalColSize = importGoodsIDMaxSize + importDateMaxSize
                + quantityMaxSize + importGoodsNameMaxSize + 3 + 6;
        final int extraLengthOfBorder = 11;
        int borderLength = totalColSize + extraLengthOfBorder;
        System.out.println("|" + "-".repeat(borderLength) + "|");
        System.out.printf("| %-" + String.format(importGoodsIDMaxSize + "s")
                + " | %-" + String.format(importDateMaxSize + "s")
                + " | %-" + String.format(importGoodsNameMaxSize + "s")
                + " | %-" + String.format(quantityMaxSize + "s"),
                "Goods ID",
                "Imported Date&Time",
                "Goods Name",
                "Quantity");
        System.out.println("|" + "-".repeat(borderLength) + "|");
        for (Shift shift : history.getShiftHistory()) {
            for (ImportedGoods importGoods : shift.getImportGoodsHis()) {
                System.out.printf("| %-" + String.format(importGoodsIDMaxSize + "s")
                        + " | %-" + String.format(importGoodsNameMaxSize + "s")
                        + " | %-" + String.format(importDateMaxSize + "s")
                        + " | %-" + String.format(quantityMaxSize + "s"),
                        importGoods.getID(),
                        importGoods.getGoodsName(),
                        importGoods.getImportDateTime(),
                        importGoods.getTotalQuanByShipments());
                System.out.println("|" + "-".repeat(borderLength) + "|");
            }
        }
    }

    private void computeSizeOfEachImportGoodsHistoryColumn(History history) {
        importGoodsIDMaxSize = "Goods ID".length();
        importDateMaxSize = "Imported Date&Time".length();
        quantityMaxSize = "Quantity".length();
        importGoodsNameMaxSize = "Goods Name".length();
        for (Shift shift : history.getShiftHistory()) {
            for (ImportedGoods importGoods : shift.getImportGoodsHis()) {
                if (importGoods.getID().length() > importGoodsIDMaxSize) {
                    importGoodsIDMaxSize = importGoods.getID().length();
                }
                if (importGoods.getImportDateTime().length() > importDateMaxSize) {
                    importDateMaxSize = importGoods.getImportDateTime().length();
                }
                if ((importGoods.getTotalQuanByShipments() + "").length() > quantityMaxSize) {
                    quantityMaxSize = (importGoods.getTotalQuanByShipments() + "").length();
                }
                if (importGoods.getGoodsName().length() > importGoodsNameMaxSize) {
                    importGoodsNameMaxSize = importGoods.getGoodsName().length();
                }
            }
        }
    }

    public void showShiftHistory(History history) {
        if (history.getShiftHistory().isEmpty()) {
            System.out.println("No shift found!");
            return;
        }
        computeSizeOfEachShiftHistoryColumn(history);
        int totalColSize = shiftEndDateTimeMaxSize + netRevenueMaxSize
                + shiftOpenDateTimeMaxSize + shiftIDMaxSize + 3 + 6;
        final int extraLengthOfBorder = 11;
        int borderLength = totalColSize + extraLengthOfBorder;
        System.out.println("|" + "-".repeat(borderLength) + "|");
        System.out.printf("| %-" + String.format(shiftIDMaxSize + "s")
                + " | %-" + String.format(shiftOpenDateTimeMaxSize + "s")
                + " | %-" + String.format(shiftEndDateTimeMaxSize + "s")
                + " | %-" + String.format(netRevenueMaxSize + "s"),
                "Shift ID",
                "Open Date&Time",
                "End Date&Time",
                "Net Revenue");
        System.out.println("|" + "-".repeat(borderLength) + "|");
        for (Shift shift : history.getShiftHistory()) {
            System.out.printf("| %-" + String.format(shiftIDMaxSize + "s")
                    + " | %-" + String.format(shiftOpenDateTimeMaxSize + "s")
                    + " | %-" + String.format(shiftEndDateTimeMaxSize + "s")
                    + " | %-" + String.format(netRevenueMaxSize + "s"),
                    shift.getID(),
                    shift.getOpenTime(),
                    shift.getEndTime(),
                    shift.getNetRevenue());
            System.out.println("|" + "-".repeat(borderLength) + "|");
        }
    }

    private void computeSizeOfEachShiftHistoryColumn(History history) {
        shiftIDMaxSize = "Shift ID".length();
        shiftOpenDateTimeMaxSize = "Open Date&Time".length();
        shiftEndDateTimeMaxSize = "End Date&Time".length();
        importGoodsNameMaxSize = "Net Revenue".length();
        for (Shift shift : history.getShiftHistory()) {
            if (shift.getID().length() > importGoodsIDMaxSize) {
                importGoodsIDMaxSize = shift.getID().length();
            }
            if (shift.getOpenTime().length() > importDateMaxSize) {
                importDateMaxSize = shift.getOpenTime().length();
            }
            if ((shift.getEndTime() + "").length() > quantityMaxSize) {
                quantityMaxSize = (shift.getEndTime() + "").length();
            }
            if ((shift.getNetRevenue() + "").length() > importGoodsNameMaxSize) {
                importGoodsNameMaxSize = (shift.getNetRevenue() + "").length();
            }
        }
    }

    public CustomPair typeInFromToDate() {
        String inputStr;
        LocalDate fromDate = null, toDate = null;
        int n = 1;
        System.out.println("Please type in Date from... to... (Ex: dd/MM/yyyy)");
        while (n != 3) {
            if (n == 1) {
                System.out.print("From: ");
                inputStr = sc.nextLine();
                try {
                    fromDate = LocalDate.parse(inputStr,
                            DateTimeFormatter.ofPattern(inputDateFormat));
                    n = 2;
                } catch (DateTimeException dte) {
                    ctions.wrInput();
                }
            } else {
                System.out.print("To(or Back to back): ");
                inputStr = sc.nextLine();
                if (inputStr.equalsIgnoreCase("back")) {
                    n = 1;
                    continue;
                }
                try {
                    toDate = LocalDate.parse(inputStr,
                            DateTimeFormatter.ofPattern(inputDateFormat));
                    if (toDate.isBefore(fromDate)) {
                        System.out.println("Must be after fromDate.");
                        continue;
                    }
                    n = 3;
                } catch (DateTimeException dte) {
                    ctions.wrInput();
                }
            }
        }
        return new CustomPair<>(fromDate, toDate);
    }
}
