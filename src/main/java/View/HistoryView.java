/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package View;

import Models.CustomPair;
import Models.GoodsList;
import Models.History;
import Models.ImportedGoods;
import Models.Order;
import Models.PaymentOptions;
import Models.Shift;
import Models.Shipment;
import Models.SoldGoods;
import Models.StaticalItems;
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
    final String DATE_FORMAT = "dd/MM/yyyy";
    private int orderIDMaxSize;
    private int orderDateTimeMaxSize;
    private int totalMaxSize;
    private int goodsNameMaxSize;
    private int goodsIDMaxSize;
    private int goodsTotalQuanMaxSize;
    private int totalAmountSoldMaxSize;
    private int providerMaxSize;
    private int listPriceMaxSize;
    private int importGoodsIDMaxSize;
    private int importDateMaxSize;
    private int importGoodsNameMaxSize;
    private int importGoodsQuanMaxSize;
    private int importGoodsTotalAmountMaxSize;
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
                System.out.printf("| %-" + String.format(orderIDMaxSize + "s")
                        + " | %-" + String.format(orderDateTimeMaxSize + "s")
                        + " | %-" + String.format(shiftIDMaxSize + "s")
                        + " | %-" + String.format(totalMaxSize + ".1f")+" |",
                        order.getID(),
                        order.getOrderDateTime(),
                        shift.getID(),
                        order.getTotal());
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
                if (order.getOrderDateTime().length() > orderDateTimeMaxSize) {
                    orderDateTimeMaxSize = order.getOrderDateTime().length();
                }
                if (String.format("%.1f", order.getTotal()).length() > totalMaxSize) {
                    totalMaxSize = String.format("%.1f", order.getTotal()).length();
                }
            }
            if (shift.getID().length() > shiftIDMaxSize) {
                shiftIDMaxSize = shift.getID().length();
            }
        }
    }

    public void showOrderHistory(GoodsList<SoldGoods> goodsList) {
        if (goodsList.getGoodsList().isEmpty()) {
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
        for (SoldGoods goods : goodsList.getGoodsList()) {
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
        for (SoldGoods goods : goodsList.getGoodsList()) {
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
        for (SoldGoods goods : goodsList.getGoodsList()) {
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
    public void showImportGoodsHistory(History history) {
        if (history.getShiftHistory().isEmpty()) {
            System.out.println("No Imported Goods found!");
            return;
        }
        computeSizeOfEachColumnInImportGoodsHistory(history);
        int totalColSize = importGoodsIDMaxSize + importDateMaxSize
                + importGoodsQuanMaxSize + importGoodsNameMaxSize + 3 + 6;
        final int extraLengthOfBorder = 11;
        int borderLength = totalColSize + extraLengthOfBorder;
        System.out.println("|" + "-".repeat(borderLength) + "|");
        System.out.printf("| %-" + String.format(importGoodsIDMaxSize + "s")
                + " | %-" + String.format(importDateMaxSize + "s")
                + " | %-" + String.format(importGoodsNameMaxSize + "s")
                + " | %-" + String.format(importGoodsQuanMaxSize + "s")+" |",
                "Goods ID",
                "Imported Date&Time",
                "Goods Name",
                "Quantity");
        System.out.println("");
        System.out.println("|" + "-".repeat(borderLength) + "|");
        for (Shift shift : history.getShiftHistory()) {
            for (ImportedGoods importGoods : shift.getImportGoodsHis().getGoodsList()) {
                System.out.printf("| %-" + String.format(importGoodsIDMaxSize + "s")
                        + " | %-" + String.format(importDateMaxSize + "s")
                        + " | %-" + String.format(importGoodsNameMaxSize + "s")
                        + " | %-" + String.format(importGoodsQuanMaxSize + ".1f")+" |",
                        importGoods.getID(),
                        importGoods.getImportDateTime(),
                        importGoods.getGoodsName(),
                        importGoods.getTotalQuanByShipments());
                System.out.println("");
                System.out.println("|" + "-".repeat(borderLength) + "|");
            }
        }
    }

    private void computeSizeOfEachColumnInImportGoodsHistory(History history) {
        importGoodsIDMaxSize = "Goods ID".length();
        importDateMaxSize = "Imported Date&Time".length();
        importGoodsQuanMaxSize = "Quantity".length();
        importGoodsNameMaxSize = "Goods Name".length();
        for (Shift shift : history.getShiftHistory()) {
            for (ImportedGoods importGoods : shift.getImportGoodsHis().getGoodsList()) {
                if (importGoods.getID().length() > importGoodsIDMaxSize) {
                    importGoodsIDMaxSize = importGoods.getID().length();
                }
                if (importGoods.getImportDateTime().length() > importDateMaxSize) {
                    importDateMaxSize = importGoods.getImportDateTime().length();
                }
                if (String.format("%.1f", importGoods.getTotalQuanByShipments()).length() > importGoodsQuanMaxSize) {
                    importGoodsQuanMaxSize = String.format("%.1f", importGoods.getTotalQuanByShipments()).length();
                }
                if (importGoods.getGoodsName().length() > importGoodsNameMaxSize) {
                    importGoodsNameMaxSize = importGoods.getGoodsName().length();
                }
            }
        }
    }

    public void showImportGoodsHistory(GoodsList<ImportedGoods> goodsList) {
        if (goodsList.getGoodsList().isEmpty()) {
            System.out.println("No goods found!");
            return;
        }
        computeSizeOfEachColumnInImportGoodsHistory(goodsList);
        int totalColSize = importGoodsIDMaxSize + importGoodsQuanMaxSize
                + importGoodsNameMaxSize + importGoodsTotalAmountMaxSize + 3 + 6;
        final int extraLengthOfBorder = 11;
        int borderLength = totalColSize + extraLengthOfBorder;
        System.out.println("|" + "-".repeat(borderLength) + "|");
        System.out.printf("| %-" + String.format(importGoodsIDMaxSize + "s")
                + " | %-" + String.format(importGoodsNameMaxSize + "s")
                + " | %-" + String.format(importGoodsQuanMaxSize + "s")
                + " | %-" + String.format(importGoodsTotalAmountMaxSize + "s")+" |",
                "Goods ID",
                "Goods Name",
                "Imported Quantity",
                "Total Import Amount");
        System.out.println("");
        System.out.println("|" + "-".repeat(borderLength) + "|");
        for (ImportedGoods goods : goodsList.getGoodsList()) {
            System.out.printf("| %-" + String.format(importGoodsIDMaxSize + "s")
                    + " | %-" + String.format(importGoodsNameMaxSize + "s")
                    + " | %-" + String.format(importGoodsQuanMaxSize + ".1f")
                    + " | %-" + String.format(importGoodsTotalAmountMaxSize + ".1f")+" |",
                    goods.getID(),
                    goods.getGoodsName(),
                    goods.getTotalQuantity(),
                    goods.getTotalAmountImport());
            System.out.println("");
            System.out.println("|" + "-".repeat(borderLength) + "|");
        }
        BigDecimal total = BigDecimal.ZERO;
        for (ImportedGoods importGoods : goodsList.getGoodsList()) {
            total = total.add(importGoods.getTotalAmountImport());
        }
        System.out.println(String.format("%" + (totalColSize - importGoodsTotalAmountMaxSize) + "s"
                + "%" + importGoodsTotalAmountMaxSize + ".1f", "Total : ", total));
    }

    private void computeSizeOfEachColumnInImportGoodsHistory(GoodsList<ImportedGoods> goodsList) {
        importGoodsIDMaxSize = "Order ID".length();
        importGoodsNameMaxSize = "Goods Name".length();
        importGoodsQuanMaxSize = "Imported Quantity".length();
        importGoodsTotalAmountMaxSize = "Total Import Amount".length();
        for (ImportedGoods goods : goodsList.getGoodsList()) {
            if (goods.getID().length() > importGoodsIDMaxSize) {
                importGoodsIDMaxSize = goods.getID().length();
            }
            if (goods.getGoodsName().length() > importGoodsNameMaxSize) {
                importGoodsNameMaxSize = goods.getGoodsName().length();
            }
            if (String.format(".1f", goods.getTotalQuantity()).length() > importGoodsQuanMaxSize) {
                importGoodsQuanMaxSize = String.format(".1f", goods.getTotalQuantity()).length();
            }
            if (String.format(".1f", goods.getTotalAmountImport()).length() > importGoodsTotalAmountMaxSize) {
                importGoodsTotalAmountMaxSize = String.format(".1f", goods.getTotalAmountImport()).length();
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
        for (Shift shift : history.getShiftHistory()) {
            System.out.printf("| %-" + String.format(shiftIDMaxSize + "s")
                    + " | %-" + String.format(shiftOpenDateTimeMaxSize + "s")
                    + " | %-" + String.format(shiftEndDateTimeMaxSize + "s")
                    + " | %-" + String.format(netRevenueMaxSize + ".1f")+" |",
                    shift.getID(),
                    shift.getOpenTime(),
                    shift.getEndTime(),
                    shift.getNetRevenue());
            System.out.println("");
            System.out.println("|" + "-".repeat(borderLength) + "|");
        }
        BigDecimal total = BigDecimal.ZERO;
        for (Shift shift : history.getShiftHistory()) {
            total = total.add(shift.getNetRevenue());
        }
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
            if (shift.getOpenTime().length() > importDateMaxSize) {
                importDateMaxSize = shift.getOpenTime().length();
            }
            if ((shift.getEndTime() + "").length() > importGoodsQuanMaxSize) {
                importGoodsQuanMaxSize = (shift.getEndTime() + "").length();
            }
            if (String.format("%.1f", shift.getNetRevenue()).length() > netRevenueMaxSize) {
                netRevenueMaxSize = String.format("%.1f", shift.getNetRevenue()).length();
            }
        }
    }

    //
    public void showAnOrderInDetail(Order order) {
        System.out.printf("%10s%8s\n", "ORDER ID: ", order.getID());
        System.out.printf("%s: %s\n", "Init Date&Time", order.getOrderDateTime());
        System.out.printf("%s: %s\n", "VAT", order.getVAT() + "%");
        System.out.printf("%s: %s\n", "Discount", order.getDiscount() + "%");
        System.out.printf("%s: %s\n", "Customer Card ID", order.getCustomerCard().getID());
        System.out.printf("%s: %.1f\n", "Point Discount", order.getPointDiscount());
        System.out.printf("%s: %s\n", "Payment Option", order.getPaymentOptions());
        if (order.getPaymentOptions().equals(PaymentOptions.Cash_Payment)) {
            System.out.printf("%s: %.1f\n", "Customer money", order.getCusMoney());
            System.out.printf("%s: %.1f\n", "Change", order.getChange());
        }
        System.out.printf("%s: %.1f\n", "SubTotal", order.getSubTotal());
        System.out.printf("%s: %.1f\n", "Total", order.getTotal());
    }

    public void showAnShiftInDetail(Shift shift) {
        String openTime = shift.getOpenTime();
        String endTime = shift.getEndTime();
        if (openTime == null) {
            openTime = "";
        }
        if (endTime == null) {
            endTime = "";
        }
        System.out.println("");
        System.out.printf("%10s%8s\n", "SHIFT ID: ", shift.getID());
        System.out.printf("%s: %-20s\n", "Open Date&Time", shift.getOpenTime());
        System.out.printf("%s: %-20s\n", "End Date&Time", shift.getEndTime());
        System.out.printf("%s: %-20s\n", "Cashier", shift.getCashier().getFirstName()+" "+shift.getCashier().getLastName());
        System.out.printf("%s: %-20.1f\n", "Opening Balance", shift.getOpeningBalance());
        System.out.printf("%s: %-20.1f\n", "Gross revenue", shift.getGrossRevenue());
        System.out.printf("%s: %-20.1f\n", "Total direct discount", shift.getTotalDiscountMoney());
        System.out.printf("%s: %-20.1f\n", "Total point discount", shift.getTotalPointDiscount());
        System.out.printf("%s: %-20s\n", "VAT", shift.getVAT() + "%");
        System.out.printf("%s: %-20.1f\n", "Shipping Fee", shift.getTransportFee());
        System.out.printf("%s: %-20.1f\n", "Net Revenue", shift.getNetRevenue());
        System.out.printf("%s: %-20s\n", "Number of Order", shift.getNumberOfOrder());
        System.out.printf("%s: %-20.1f\n", "Average per Order", shift.getAveragePerOrder());
        System.out.println("OPTIONS PAYMENT:");
        System.out.printf("%s: %-20.1f\n", "+Cash", shift.getTotalPaymentByCash());
        System.out.printf("%s: %-20.1f\n", "+Wire transfer", shift.getTotalPaymentByWireTransfer());
        System.out.printf("%s: %-20.1f\n", "+Current CashBox money", shift.getTotalPaymentByCash()
                .add(shift.getOpeningBalance()));
        System.out.println(String.format("%5s", "CONSUMPTIONS:"));
        System.out.println(String.format("%-20s" + " | " + "%-20s" + " | " + "%-20s" + " | " + "%-20s",
                "Goods Name", "Quantity", "Revenue", "Ratio"));
        List<StaticalItems> staticalItemsList = new ArrayList<>(shift.getStaticalList().values());
        staticalItemsList.stream().forEach(x -> System.out.println(String.format("%-20s" + " | " + "%-20.1f" + " | " + "%-20.1f" + " | " + "%-20s",
                x.getName(), x.getQuantity(), x.getRevenue(), String.format("%.1f", x.getRatio())+"%")));
        shift.getEmployeeOfThisShift().showList();
    }

    public void showAnImpotedGoodsInDetail(ImportedGoods importGoods) {
        System.out.println();
        this.computeSizeColumnsOfAnImportGoods(importGoods);
        int totalColumnsSize = goodsNameMaxSize
                + providerMaxSize
                + listPriceMaxSize
                + goodsTotalQuanMaxSize
                + importPriceMaxSize
                + importGoodsQuanMaxSize;
        final int extralengthOfBorder = 85;
        int borderLength = extralengthOfBorder + totalColumnsSize;
        System.out.println("|" + "-".repeat(borderLength) + "|");
        System.out.printf("| %-8s | %-" + String.format(goodsNameMaxSize + "s")
                + " | %-" + String.format(providerMaxSize + "s")
                + " | %-" + String.format(listPriceMaxSize + "s")
                + " | %-" + String.format(goodsTotalQuanMaxSize + "s")
                + " | %-11s | %-15s | %-15s | %-" + String.format(importPriceMaxSize + "s")
                + " | %-" + String.format(importGoodsQuanMaxSize + "s")
                + " | %-19s |\n",
                "Goods ID", "Name",
                "Provider",
                "List Price",
                "Total Quantity",
                "Shipment ID", "Production Date", "Expiration Date", "Import Price",
                "Quantity",
                "Import Date&Time");
        System.out.println("|" + "-".repeat(totalColumnsSize + 78) + "|");
        System.out.printf("| %-8s | %-" + String.format(goodsNameMaxSize + "s")
                + " | %-" + String.format(providerMaxSize + "s")
                + " | %-" + String.format(listPriceMaxSize + ".1f")
                + " | %-" + String.format(goodsTotalQuanMaxSize + ".1f") + " |",
                importGoods.getID(),
                importGoods.getGoodsName(),
                importGoods.getManufacture(),
                importGoods.getListPrice(),
                importGoods.getTotalQuanByShipments());
        if (!importGoods.getShipments().isEmpty()) {
            // Neu list shipment cua goods da ton tai it nhat 1 shipment, thuc hien in ra shipment do
            Shipment shipment = importGoods.getShipments().get(0);
            String productionDateString = shipment.getNsx().format(DateTimeFormatter.ofPattern(DATE_FORMAT));
            String expirationDateString = shipment.getHsd().format(DateTimeFormatter.ofPattern(DATE_FORMAT));
            System.out.printf(" %-11s | %-15s | %-15s | %-"
                    + String.format(importPriceMaxSize + ".1f")
                    + " | %-" + String.format(importGoodsQuanMaxSize + ".1f")
                    + " | %-19s |\n",
                    shipment.getID(), productionDateString, expirationDateString,
                    shipment.getImportPrice(),
                    shipment.getQuantity(),
                    importGoods.getImportDateTime());
        } else {
            // Neu chua co shipment nao ton tai, thuc hien in ra khoang trang trong cac cot thuoc tinh
            System.out.printf(" %-11s | %-15s | %-15s | %-" + String.format(importPriceMaxSize + "s")
                    + " | %-" + String.format(importGoodsQuanMaxSize + "s") + " | %-19s |\n",
                    "", "", "", "", "", "");
        }
        System.out.println("|" + "-".repeat(borderLength) + "|");
    }

    private void computeSizeColumnsOfAnImportGoods(ImportedGoods importGoods) {
        // duyet tu dau den cuoi mang de tim MAX_SIZE cua giatri input tung thuoc tinh
        goodsNameMaxSize = "Name".length();
        providerMaxSize = "Provider".length();
        listPriceMaxSize = "List Price".length();
        goodsTotalQuanMaxSize = "Total Quantity".length();
        importPriceMaxSize = "Import Price".length();
        importGoodsQuanMaxSize = "Quantity".length();
        if (importGoods.getGoodsName().length() > goodsNameMaxSize) {
            goodsNameMaxSize = importGoods.getGoodsName().length();
        }
        if (importGoods.getManufacture().length() > providerMaxSize) {
            providerMaxSize = importGoods.getManufacture().length();
        }
        if (String.format(".1f", importGoods.getListPrice()).length() > listPriceMaxSize) {
            listPriceMaxSize = String.format(".1f", importGoods.getListPrice()).length();
        }
        if (String.format(".1f", importGoods.getTotalQuanByShipments()).length() > goodsTotalQuanMaxSize) {
            goodsTotalQuanMaxSize = String.format(".1f", importGoods.getTotalQuanByShipments()).length();
        }
        if (String.format(".1f", importGoods.getShipments().get(0).getImportPrice()).length() > importPriceMaxSize) {
            importPriceMaxSize = String.format(".1f", importGoods.getShipments().get(0).getImportPrice()).length();
        }
        if (String.format(".1f", importGoods.getShipments().get(0).getQuantity()).length() > importGoodsQuanMaxSize) {
            importGoodsQuanMaxSize = String.format(".1f", importGoods.getShipments().get(0).getQuantity()).length();
        }
    }

    //
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
