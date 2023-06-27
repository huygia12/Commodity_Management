/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package View;

import Controllers.EmployeeListController;
import Controllers.OrderController;
import Controllers.ShiftController;
import Ultility.Cautions;
import Ultility.CustomPair;
import Models.GoodsList;
import Models.History;
import Models.Order;
import Models.Shift;
import Models.SoldGoods;
import java.math.BigDecimal;
import java.time.DateTimeException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 *
 * @author FPTSHOP
 */
public class HistoryView {
    final Cautions ctions = new Cautions();
    final Scanner sc = new Scanner(System.in);
    final OrderController orderCtr = new OrderController();
    final EmployeeListController employeeListCtr = new EmployeeListController();
    final ShiftController shiftCtr = new ShiftController();
    final String DATE_FORMAT = "dd/MM/yyyy";
    final String DATE_TIME_FORMAT = "dd/MM/yyyy HH:mm:ss";
    private int orderIDMaxSize;
    private int orderDateTimeMaxSize;
    private int totalMaxSize;
    private int goodsNameMaxSize;
    private int goodsIDMaxSize;
    private int goodsTotalQuanMaxSize;
    private int totalAmountSoldMaxSize;
    private int importGoodsIDMaxSize;
    private int importDateMaxSize;
    private int importGoodsQuanMaxSize;
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

    //
    public void showOrderHistory(History history) {
        if (history.getShiftHistory().isEmpty()) {
            System.out.println("No order found!");
            return;
        }
        computeSizeOfEachColumnInOrderHistory(history);
        int totalColSize = orderIDMaxSize + orderDateTimeMaxSize + totalMaxSize + shiftIDMaxSize;
        final int extraLengthOfBorder = 11;
        int borderLength = totalColSize + extraLengthOfBorder;
        System.out.println("|" + "-".repeat(borderLength) + "|");
        System.out.printf("| %-" + String.format(orderIDMaxSize + "s")
                + " | %-" + String.format(orderDateTimeMaxSize + "s")
                + " | %-" + String.format(shiftIDMaxSize + "s")
                + " | %-" + String.format(totalMaxSize + "s")+ " |",
                "Order ID",
                "Innitiated Date&Time",
                "Shift ID",
                "Total");
        System.out.println("");
        System.out.println("|" + "-".repeat(borderLength) + "|");
        for (Shift shift : history.getShiftHistory()) {
            for (Order order : shift.getOrderHisPerShift()) {
//                System.out.printf("| %-" + String.format(orderIDMaxSize + "s")
//                        + " | %-" + String.format(orderDateTimeMaxSize + "s")
//                        + " | %-" + String.format(shiftIDMaxSize + "s")
//                        + " | %-" + String.format(totalMaxSize + ".1f")+" |",
//                        order.getID(),
//                        order.getOrderDateTime(),
//                        shift.getID(),
//                        orderCtr.getTotal(order));
                System.out.println("");
                System.out.println("|" + "-".repeat(borderLength) + "|");
            }
        }
    }

    private void computeSizeOfEachColumnInOrderHistory(History history) {
        orderIDMaxSize = "Order ID".length();
        orderDateTimeMaxSize = "Innitiated Date&Time".length();
        totalMaxSize = "Total".length();
        shiftIDMaxSize = "Shift ID".length();
        for (Shift shift : history.getShiftHistory()) {
            for (Order order : shift.getOrderHisPerShift()) {
                if (order.getID().length() > orderIDMaxSize) {
                    orderIDMaxSize = order.getID().length();
                }
                int orderDateTimeSize = order.getOrderDateTime()
                        .format(DateTimeFormatter.ofPattern(DATE_TIME_FORMAT))
                        .length();
                if (orderDateTimeSize > orderDateTimeMaxSize) {
                    orderDateTimeMaxSize = orderDateTimeSize;
                }
//                if (String.format("%.1f", orderCtr.getTotal(order)).length() > totalMaxSize) {
//                    totalMaxSize = String.format("%.1f", orderCtr.getTotal(order)).length();
//                }
            }
            if (shift.getID().length() > shiftIDMaxSize) {
                shiftIDMaxSize = shift.getID().length();
            }
        }
    }

    public void showOrderHistory(GoodsList<SoldGoods> goodsList) {
        if (goodsList.getList().isEmpty()) {
            System.out.println("No goods found!");
            return;
        }
        computeSizeOfEachColumnInOrderHistory(goodsList);
        int totalColSize = goodsIDMaxSize + goodsNameMaxSize
                + goodsTotalQuanMaxSize + totalAmountSoldMaxSize;
        final int extraLengthOfBorder = 11;
        int borderLength = totalColSize + extraLengthOfBorder;
        System.out.println("|" + "-".repeat(borderLength) + "|");
        System.out.printf("| %-" + String.format(goodsIDMaxSize + "s")
                + " | %-" + String.format(goodsNameMaxSize + "s")
                + " | %-" + String.format(goodsTotalQuanMaxSize + "s")
                + " | %-" + String.format(totalAmountSoldMaxSize + "s")+" |",
                "Goods ID",
                "Goods Name",
                "Quantity",
                "Sold Total(Taxed and Discounted)");
        System.out.println("");
        System.out.println("|" + "-".repeat(borderLength) + "|");
        for (SoldGoods goods : goodsList.getList()) {
            System.out.printf("| %-" + String.format(goodsIDMaxSize + "s")
                    + " | %-" + String.format(goodsNameMaxSize + "s")
                    + " | %-" + String.format(goodsTotalQuanMaxSize + ".1f")
                    + " | %-" + String.format(totalAmountSoldMaxSize + ".1f")+" |",
                    goods.getID(),
                    goods.getGoodsName(),
                    goods.getTotalQuantity(),
                    goods.getTotalAmountSold());
            System.out.println("");
            System.out.println("|" + "-".repeat(borderLength) + "|");
        }
        BigDecimal total = BigDecimal.ZERO;
        for (SoldGoods goods : goodsList.getList()) {
            total = total.add(goods.getTotalAmountSold());
        }
        System.out.println(String.format("%" + (totalColSize - totalAmountSoldMaxSize) + "s"
                + "%" + totalAmountSoldMaxSize + ".1f", "Total : ", total));
    }

    private void computeSizeOfEachColumnInOrderHistory(GoodsList<SoldGoods> goodsList) {
        goodsIDMaxSize = "Order ID".length();
        goodsNameMaxSize = "Goods Name".length();
        goodsTotalQuanMaxSize = "Quantity".length();
        totalAmountSoldMaxSize = "Sold Total(Taxed and Discounted)".length();
        for (SoldGoods goods : goodsList.getList()) {
            if (goods.getID().length() > goodsIDMaxSize) {
                goodsIDMaxSize = goods.getID().length();
            }
            if (goods.getGoodsName().length() > goodsNameMaxSize) {
                goodsNameMaxSize = goods.getGoodsName().length();
            }
            if (String.format("%.1f", goods.getTotalQuantity()).length() > goodsTotalQuanMaxSize) {
                goodsTotalQuanMaxSize = String.format("%.1f", goods.getTotalQuantity()).length();
            }
            if (String.format("%.1f", goods.getTotalAmountSold()).length() > totalAmountSoldMaxSize) {
                totalAmountSoldMaxSize = String.format("%.1f", goods.getTotalAmountSold()).length();
            }
        }
    }

    //
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
                + " | %-" + String.format(netRevenueMaxSize + "s")+" |",
                "Shift ID",
                "Open Date&Time",
                "End Date&Time",
                "Net Revenue");
        System.out.println("");
        System.out.println("|" + "-".repeat(borderLength) + "|");
//        for (Shift shift : history.getShiftHistory()) {
//            System.out.printf("| %-" + String.format(shiftIDMaxSize + "s")
//                    + " | %-" + String.format(shiftOpenDateTimeMaxSize + "s")
//                    + " | %-" + String.format(shiftEndDateTimeMaxSize + "s")
//                    + " | %-" + String.format(netRevenueMaxSize + ".1f")+" |",
//                    shift.getID(),
//                    shift.getOpenTime(),
//                    shift.getEndTime(),
//                    shiftCtr.getNetRevenue(shift));
//            System.out.println("");
//            System.out.println("|" + "-".repeat(borderLength) + "|");
//        }
        BigDecimal total = BigDecimal.ZERO;
//        for (Shift shift : history.getShiftHistory()) {
//            total = total.add(shiftCtr.getNetRevenue(shift));
//        }
        System.out.println(String.format("%" + (totalColSize - netRevenueMaxSize) + "s"
                + "%" + netRevenueMaxSize + ".1f", "Total Net Revenue: ", total));
    }

    private void computeSizeOfEachShiftHistoryColumn(History history) {
        shiftIDMaxSize = "Shift ID".length();
        shiftOpenDateTimeMaxSize = "Open Date&Time".length();
        shiftEndDateTimeMaxSize = "End Date&Time".length();
        netRevenueMaxSize = "Net Revenue".length();
        for (Shift shift : history.getShiftHistory()) {
            if (shift.getID().length() > importGoodsIDMaxSize) {
                importGoodsIDMaxSize = shift.getID().length();
            }
            if (shift.getOpenTime().toString().length() > importDateMaxSize) {
                importDateMaxSize = shift.getOpenTime().toString().length();
            }
            if ((shift.getEndTime() + "").length() > importGoodsQuanMaxSize) {
                importGoodsQuanMaxSize = (shift.getEndTime() + "").length();
            }
//            if (String.format("%.1f", shiftCtr.getNetRevenue(shift)).length() > netRevenueMaxSize) {
//                netRevenueMaxSize = String.format("%.1f", shiftCtr.getNetRevenue(shift)).length();
//            }
        }
    }

    //
    public void showAnOrderInDetail(Order order) {
        System.out.printf("%10s%8s\n", "ORDER ID: ", order.getID());
        System.out.printf("%s: %s\n", "Init Date&Time", order.getOrderDateTime());
        System.out.printf("%s: %s\n", "VAT", order.getTax() + "%");
        System.out.printf("%s: %s\n", "Discount", order.getDiscount() + "%");
        System.out.printf("%s: %s\n", "Customer Card ID", order.getCustomerCard().getID());
        System.out.printf("%s: %.1f\n", "Point Discount", order.getPointDiscount());
        System.out.printf("%s: %s\n", "Payment Option", order.getPaymentOptions());
//        if (order.getPaymentOptions().equals(PaymentOptions.CASH_PAYMENT)) {
//            System.out.printf("%s: %.1f\n", "Customer money", order.getCusMoney());
//            System.out.printf("%s: %.1f\n", "Change", orderCtr.getChange(order));
//        }
//        System.out.printf("%s: %.1f\n", "SubTotal", orderCtr.getSubTotal(order));
//        System.out.printf("%s: %.1f\n", "Total", orderCtr.getTotal(order));
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
                            DateTimeFormatter.ofPattern(DATE_FORMAT));
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
                            DateTimeFormatter.ofPattern(DATE_FORMAT));
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
