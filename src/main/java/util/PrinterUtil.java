package util;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.math.BigDecimal;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.entities.Invoice;
import model.entities.Shift;
import model.entities.Store;


public class PrinterUtil {
    private final static String HOME = System.getProperty("user.dir");
    private final static String SEPARATOR = File.separator;
    private final static String BILL_FILE_PRINT = HOME + SEPARATOR + "output" + SEPARATOR + "bill.txt";
    private final static String SHIFT_FILE_PRINT = HOME + SEPARATOR + "output" + SEPARATOR + "shiftOverView.txt";
    
    public static void exportBillToTxtFile(Invoice invoice, Store store) {
        try ( PrintWriter pw = new PrintWriter(Files.newBufferedWriter(Path.of(BILL_FILE_PRINT),
                StandardOpenOption.CREATE,
                StandardOpenOption.WRITE,
                StandardOpenOption.TRUNCATE_EXISTING))) {
            String customerID = "";
            pw.println("");
            pw.println("-------------- YOUR BILL ---------------");
            pw.println("----------------------------------------");
            pw.println("Store: " + store.getStoreName());
            pw.println("Email: " + store.getEmail());
            pw.println("Date: " + FormatOutput.convertLocalDateTimeToString(invoice.getCreatedAt()));
            pw.println("");
            pw.format("%-25s %-10s %-15s %-15s\n", "Name", "Quantity", "Price", "Total");
            pw.format("%-25s %-10s %-15s %-15s\n", "-------------------------", "----------", "---------------", "---------------");
            for (int i = 0; i < invoice.getList().size(); i++) {
                Goods goods = invoice.getList().get(i);
                BigDecimal totalQuantity = goodsCtr.getTotalQuanByShipments(goods);
                BigDecimal price = goods.getListPrice();
                BigDecimal totalPrice = totalQuantity.multiply(price);
                pw.format("%-25s %-10.1f %-15.1f %-15.1f\n", goods.getGoodsName(), totalQuantity, price, totalPrice);
            }
            pw.printf("SubTotal: %.1f\n", orderCtr.getSubTotal(invoice));
            pw.printf("Discount Amount(Discount=%s): %.1f\n", invoice.getDiscount() + "%", orderCtr.getDiscountAmount(invoice));
            pw.printf("Tax(VAT=%s): %.1f\n", invoice.getTax() + "%", orderCtr.getTaxAmount(invoice));
            pw.println("Payment Option: " + invoice.getPaymentOptions());
            pw.println("Member Card ID: " + customerID);
            pw.printf("Total: %.1f\n", orderCtr.getTotal(invoice, store));
            if (invoice.getPaymentOptions().equals(PaymentOptions.CASH_PAYMENT)) {
                pw.printf("Customer payment: %.1f\n", invoice.getCusMoney());
                pw.printf("Change: %.1f\n", orderCtr.getChange(invoice, store));
            }
            pw.println("----------------------------------------");
        } catch (IOException ex) {
            Logger.getLogger(this.getClass().getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public static void exportShiftToTxtFile(Store store, Shift shift) {
        Path outputPath = Path.of(SHIFT_FILE_PRINT);
        try ( PrintWriter pw = new PrintWriter(Files.newBufferedWriter(outputPath,
                StandardOpenOption.CREATE,
                StandardOpenOption.WRITE,
                StandardOpenOption.TRUNCATE_EXISTING))) {
            pw.printf("%49s\n", "BÁO CÁO CA : " + shift.getID());
            pw.println(String.format("%40s" + " | " + "%-40s", "Cửa hàng", store.getName()));
            pw.println("-".repeat(83));
            pw.println(String.format("%40s" + " | " + "%-40s", "Giờ mở ca", shift.getOpenTime()));
            pw.println(String.format("%40s" + " | " + "%-40s", "Giờ đóng ca", shift.getEndTime()));
            pw.println(String.format("%40s" + " | " + "%-40s", "Thu ngân", shift.getCashier().getFirstName() + " " + shift.getCashier().getLastName()));
            pw.println(String.format("%40s" + " | " + "%-40.1f", "Số dư đầu ca", shift.getOpeningBalance()));
            pw.println(String.format("%40s" + " | " + "%-40.1f", "Doanh thu(gross)", shiftCtr.getGrossRevenue(shift)));
            pw.println(String.format("%40s" + " | " + "%-40.1f", "Tổng chiết khấu trực tiếp", shiftCtr.getTotalDiscountMoney(shift)));
            pw.println(String.format("%40s" + " | " + "%-40.1f", "Tổng tiền thuế(VAT)" + shift.getTax() + "%", shiftCtr.getTotalVAT(shift)));
            pw.println(String.format("%40s" + " | " + "%-40.1f", "Phí phát sinh", shift.getSurcharge()));
            pw.println(String.format("%40s" + " | " + "%-40.1f", "Lợi nhuận ròng(net)", shiftCtr.getNetRevenue(shift, store)));
            pw.println(String.format("%40s" + " | " + "%-40s", "Tổng số hóa đơn", shiftCtr.getNumberOfOrder(shift)));
            pw.println(String.format("%40s" + " | " + "%-40.1f", "Trung bình/hóa đơn", shiftCtr.getAveragePerOrder(shift, store)));
            pw.println(String.format("%-70s", "<+> CÁC PHƯƠNG THỨC THANH TOÁN:"));
            pw.println(String.format("%40s" + " | " + "%-40.1f", "Tiền mặt", shiftCtr.getTotalPaymentByCash(shift, store)));
            pw.println(String.format("%40s" + " | " + "%-40.1f", "Chuyển khoản&Ngân hàng", shiftCtr.getTotalPaymentByWireTransfer(shift, store)));
            pw.println(String.format("%-70s", "<+> MẶT HÀNG TIÊU THỤ:"));
            pw.println(String.format("%20s" + " | " + "%-20s" + " | " + "%-20s" + " | " + "%-20s", "Goods Name", "Quantity", "Revenue", "Ratio"));
            GoodsList<StaticalGoods> staticalGoodsList = new HistoryController()
                    .makeStaticalGoodsList(shift.getOrderHisPerShift(), shiftCtr.getGrossRevenue(shift));
            staticalGoodsList.getList().stream().forEach(goods -> pw.println(String.format("%20s" + " | " + "%-20.1f" + " | " + "%-20.1f" + " | " + "%-20s",
                    goods.getGoodsName(), goods.getTotalQuantity(), goods.getRevenue(), String.format("%.1f", goods.getRatio()) + "%")));
            pw.println(String.format("%-70s", "<+> GHI CHÚ CA: ") + shift.getNote());
        } catch (IOException ex) {
            Logger.getLogger(Shift.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
