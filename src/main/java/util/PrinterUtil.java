package util;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.StaticalProduct;
import model.entities.Invoice;
import model.entities.InvoiceProduct;
import model.entities.Shift;
import model.entities.Store;
import model.enums.PaymentOption;

public class PrinterUtil {

    private final static String HOME = System.getProperty("user.dir");
    private final static String SEPARATOR = File.separator;
    private final static String BILL_FILE_PRINT = HOME + SEPARATOR + "output" + SEPARATOR + "bill.txt";
    private final static String SHIFT_FILE_PRINT = HOME + SEPARATOR + "output" + SEPARATOR + "shiftOverView.txt";

    public static void exportBillToTxtFile(Invoice invoice, Store store) {
        try (PrintWriter pw = new PrintWriter(Files.newBufferedWriter(Path.of(BILL_FILE_PRINT),
                StandardOpenOption.CREATE,
                StandardOpenOption.WRITE,
                StandardOpenOption.TRUNCATE_EXISTING))) {
            pw.println("");
            pw.println("-------------- YOUR BILL ---------------");
            pw.println("----------------------------------------");
            pw.println("Store: " + store.getStoreName());
            pw.println("Email: " + store.getEmail());
            pw.println("Date: " + FormatOutput.convertLocalDateTimeToString(invoice.getCreatedAt()));
            pw.println("");
            pw.format("%-25s %-10s %-15s %-15s\n", "Name", "Quantity", "Price", "Total");
            pw.format("%-25s %-10s %-15s %-15s\n", "-------------------------", "----------", "---------------", "---------------");
            for (InvoiceProduct p : invoice.getInvoiceProducts()) {
                pw.format("%-25s %-10d %-15d %-15s\n", p.getProductName(), p.getQuantity(), p.getPrice(), InvoiceUtil.getTotalAmountPerProduct(p));
            }
            pw.printf("SubTotal: %s\n", InvoiceUtil.getSubTotal(invoice));
            pw.printf("Discount Amount(Discount=%s): %s\n", invoice.getDiscount() + "%", InvoiceUtil.getDiscountAmount(invoice));
            pw.println("Payment Option: " + invoice.getPaymentMethod());
            pw.printf("Total: %s\n", InvoiceUtil.getTotal(invoice));
            if (invoice.getPaymentMethod().equals(PaymentOption.CASH)) {
                pw.printf("Customer payment: %d\n", invoice.getCustomerMoney());
                pw.printf("Change: %s\n", InvoiceUtil.getChange(invoice));
            }
            pw.println("----------------------------------------");
        } catch (IOException ex) {
            Logger.getLogger(PrinterUtil.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public static void exportShiftToTxtFile(Store store, Shift shift) {
        Path outputPath = Path.of(SHIFT_FILE_PRINT);
        List<Invoice> invoices = shift.getInvoices();
        Map<Long, StaticalProduct> staticalProducts = InvoiceUtil.getStaticalProducts(invoices);
        try (PrintWriter pw = new PrintWriter(Files.newBufferedWriter(outputPath,
                StandardOpenOption.CREATE,
                StandardOpenOption.WRITE,
                StandardOpenOption.TRUNCATE_EXISTING))) {
            pw.printf("%49s\n", "BÁO CÁO CA : " + shift.getShiftId());
            pw.println(String.format("%40s" + " | " + "%-40s", "Cửa hàng", store.getStoreName()));
            pw.println("-".repeat(83));
            pw.println(String.format("%40s" + " | " + "%-40s", "Giờ mở ca", FormatOutput.convertLocalDateTimeToString(shift.getOpenAt())));
            pw.println(String.format("%40s" + " | " + "%-40s", "Giờ đóng ca", FormatOutput.convertLocalDateTimeToString(shift.getEndAt())));
            pw.println(String.format("%40s" + " | " + "%-40s", "Thu ngân", shift.getCashierName()));
            pw.println(String.format("%40s" + " | " + "%-40d", "Số dư đầu ca", shift.getOpeningBalance()));
            pw.println(String.format("%40s" + " | " + "%-40s", "Doanh thu(gross)", ShiftUtil.getGrossRevenue(shift)));
            pw.println(String.format("%40s" + " | " + "%-40s", "Tổng chiết khấu trực tiếp", ShiftUtil.getTotalDiscountMoney(shift)));
            pw.println(String.format("%40s" + " | " + "%-40d", "Phí phát sinh", shift.getSurcharge()));
            pw.println(String.format("%40s" + " | " + "%-40s", "Lợi nhuận ròng(net)", ShiftUtil.getNetRevenue(shift)));
            pw.println(String.format("%40s" + " | " + "%-40s", "Tổng số hóa đơn", invoices.size()));
            pw.println(String.format("%40s" + " | " + "%-40s", "Trung bình/hóa đơn", ShiftUtil.getAveragePerOrder(shift)));
            pw.println(String.format("%-70s", "<+> CÁC PHƯƠNG THỨC THANH TOÁN:"));
            pw.println(String.format("%40s" + " | " + "%-40s", "Tiền mặt", ShiftUtil.getTotalPaymentByCash(shift)));
            pw.println(String.format("%40s" + " | " + "%-40s", "Chuyển khoản", ShiftUtil.getTotalPaymentByWireTransfer(shift)));
            pw.println(String.format("%-70s", "<+> MẶT HÀNG TIÊU THỤ:"));
            pw.println(String.format("%20s" + " | " + "%-20s" + " | " + "%-20s" + " | " + "%-20s", "Goods Name", "Quantity", "Revenue", "Ratio"));
            for (Map.Entry<Long, StaticalProduct> entry : staticalProducts.entrySet()) {
                StaticalProduct staticalProduct = entry.getValue();
                pw.println(String.format("%20s" + " | " + "%-20d" + " | " + "%-20s" + " | " + "%-20s",
                    staticalProduct.getProductName(), staticalProduct.getQuantity(), staticalProduct.getRevenue(), staticalProduct.getRatio() + "%"));
            }
        } catch (IOException ex) {
            Logger.getLogger(PrinterUtil.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
