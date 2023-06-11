/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package View;

import Controllers.GoodsController;
import Controllers.OrderController;
import Models.*;
import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.math.BigDecimal;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;
import java.time.format.DateTimeFormatter;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author FPTSHOP
 */
public class OrderView {
    private final String HOME = System.getProperty("user.dir");
    private final String SEPARATOR = File.separator;
    private final String FILE_PRINT = HOME + SEPARATOR + "output" + SEPARATOR + "bill.txt";
    private final String DATE_TIME_FORMAT = "dd/MM/yyyy hh:mm:ss";

    public void printBillToFile(Order order, Store store) {
        GoodsController goodsCtr = new GoodsController();
        OrderController orderCtr = new OrderController();
        try ( PrintWriter pw = new PrintWriter(Files.newBufferedWriter(Path.of(FILE_PRINT),
                StandardOpenOption.CREATE,
                StandardOpenOption.WRITE,
                StandardOpenOption.TRUNCATE_EXISTING))) {
            String customerID = "";
            if (order.getCustomerCard() != null) {
                customerID = order.getCustomerCard().getID();
            }
            pw.println("");
            pw.println("-------------- YOUR BILL ---------------");
            pw.println("----------------------------------------");
            pw.println("Store Name: " + store.getName());
            pw.println("Email: " + store.getEmail());
            pw.println("Address: " + store.getAddress());
            pw.println("Phone Number: " + store.getPhoneNumber());
            pw.println("Date: " + order.getOrderDateTime().format(DateTimeFormatter.ofPattern(DATE_TIME_FORMAT)));
            pw.println("");
            pw.format("%-25s %-10s %-15s %-15s\n", "Name", "Quantity", "Price", "Total");
            pw.format("%-25s %-10s %-15s %-15s\n", "-------------------------", "----------", "---------------", "---------------");
            for (int i = 0; i < order.getList().size(); i++) {
                Goods goods = order.getList().get(i);
                BigDecimal totalQuantity = goodsCtr.getTotalQuanByShipments(goods);
                BigDecimal price = goods.getListPrice();
                BigDecimal totalPrice = totalQuantity.multiply(price);
                pw.format("%-25s %-10.1f %-15.1f %-15.1f\n", goods.getGoodsName(), totalQuantity, price, totalPrice);
            }
            pw.printf("SubTotal: %.1f\n", orderCtr.getSubTotal(order));
            pw.printf("Discount Amount(Discount=%s): %.1f\n", order.getDiscount() + "%", orderCtr.getDiscountAmount(order));
            pw.printf("Tax(VAT=%s): %.1f\n", store.getVAT() + "%", orderCtr.getTaxAmount(order));
            pw.println("Payment Option: " + order.getPaymentOptions());
            pw.println("Member Card ID: " + customerID);
            pw.printf("Point Discount: \n", orderCtr.getPointDiscountAmount(order, store));
            pw.printf("Total: %.1f\n", orderCtr.getTotal(order, store));
            if (order.getPaymentOptions().equals(PaymentOptions.CASH_PAYMENT)) {
                pw.printf("Customer payment: %.1f\n", order.getCusMoney());
                pw.printf("Change: %.1f\n", orderCtr.getChange(order, store));
            }
            pw.println("----------------------------------------");
        } catch (IOException ex) {
            Logger.getLogger(OrderView.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
