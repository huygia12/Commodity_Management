package util;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;
import java.util.List;
import java.util.Map;
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

            int col1Width = 25; 
            int col2Width = 10;
            int col3Width = 18;
            int col4Width = 18; 

            // Đoạn đầu hóa đơn
            pw.println("=".repeat(col1Width + col2Width + col3Width + col4Width + 7)); 
            pw.println("              HÓA ĐƠN BÁN HÀNG");
            pw.println("               Mã hóa đơn: " + invoice.getInvoiceId());
            pw.println("=".repeat(col1Width + col2Width + col3Width + col4Width + 7));
            pw.println("Cửa hàng            : " + store.getStoreName());
            pw.println("Email               : " + store.getEmail());
            pw.println("Thời gian tạo       : " + FormatOutput.convertLocalDateTimeToString(invoice.getCreatedAt()));
            pw.println("-".repeat(col1Width + col2Width + col3Width + col4Width + 7));  // Đoạn ngăn cách

            // Danh sách sản phẩm
            pw.printf("%-" + col1Width + "s | %-" + col2Width + "s | %-" + col3Width + "s | %-" + col4Width + "s\n",
                    "Tên sản phẩm", "Số lượng", "Đơn giá", "Tổng tiền");
            pw.println("-".repeat(col1Width + col2Width + col3Width + col4Width + 7)); 

            for (InvoiceProduct p : invoice.getInvoiceProducts()) {
                // Kết hợp giá trị VND vào giá tiền
                String priceStr = String.format("%,d VND", p.getPrice());
                String totalStr = String.format("%s VND", InvoiceUtil.getTotalAmountPerProduct(p));

                // In thông tin sản phẩm
                pw.printf("%-" + col1Width + "s | %-" + col2Width + "d | %-" + col3Width + "s | %-" + col4Width + "s\n",
                        p.getProductName(), p.getQuantity(), priceStr, totalStr);
                pw.println("-".repeat(col1Width + col2Width + col3Width + col4Width + 7));
            }

            // Tính tổng tiền và các chi tiết khác
            pw.printf("%-" + col1Width + "s: %s VND\n", "Tổng tiền hàng", InvoiceUtil.getSubTotal(invoice));
            pw.printf("%-" + col1Width + "s: %s\n", "Chiết khấu (%)", invoice.getDiscount() + "%");
            pw.printf("%-" + col1Width + "s: %s VND\n", "Số tiền chiết khấu", InvoiceUtil.getDiscountAmount(invoice));
            pw.println("-".repeat(col1Width + col2Width + col3Width + col4Width + 7));
            pw.printf("%-" + col1Width + "s: %s\n", "Phương thức thanh toán", invoice.getPaymentMethod());
            pw.printf("%-" + col1Width + "s: %s VND\n", "Tổng cộng", InvoiceUtil.getTotal(invoice));

            // Đoạn kết thúc hóa đơn
            pw.println("=".repeat(col1Width + col2Width + col3Width + col4Width + 7)); 
            pw.println("CẢM ƠN QUÝ KHÁCH!");
            pw.println("HẸN GẶP LẠI!");
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

            // Header
            pw.println("=".repeat(80));
            pw.printf("%40s\n", "BÁO CÁO KẾT THÚC CA");
            pw.printf("%40s\n", "Mã ca: " + shift.getShiftId());
            pw.println("=".repeat(80));
            pw.println();

            // Thông tin cơ bản
            pw.println("Thông tin cửa hàng:");
            pw.printf("  %-20s : %s\n", "Tên cửa hàng", store.getStoreName());
            pw.printf("  %-20s : %s\n", "Giờ mở ca", FormatOutput.convertLocalDateTimeToString(shift.getOpenAt()));
            pw.printf("  %-20s : %s\n", "Giờ đóng ca", FormatOutput.convertLocalDateTimeToString(shift.getEndAt()));
            pw.printf("  %-20s : %s\n", "Thu ngân", shift.getCashierName());
            pw.printf("  %-20s : %d\n", "Số dư đầu ca", shift.getOpeningBalance());
            pw.println("-".repeat(80));
            pw.println();

            // Doanh thu
            pw.println("Tổng hợp doanh thu:");
            pw.printf("  %-30s : %s\n", "Doanh thu (Gross)", ShiftUtil.getGrossRevenue(shift));
            pw.printf("  %-30s : %s\n", "Tổng chiết khấu trực tiếp", ShiftUtil.getTotalDiscountMoney(shift));
            pw.printf("  %-30s : %d\n", "Phí phát sinh", shift.getSurcharge());
            pw.printf("  %-30s : %s\n", "Lợi nhuận ròng (Net)", ShiftUtil.getNetRevenue(shift));
            pw.println("-".repeat(80));
            pw.println();

            // Hóa đơn
            pw.println("Tổng hợp hóa đơn:");
            pw.printf("  %-30s : %d\n", "Tổng số hóa đơn", invoices.size());
            pw.printf("  %-30s : %s\n", "Trung bình mỗi hóa đơn", ShiftUtil.getAveragePerOrder(shift));
            pw.println("-".repeat(80));
            pw.println();

            // Phương thức thanh toán
            pw.println("Phân tích phương thức thanh toán:");
            pw.printf("  %-30s : %s\n", "Tiền mặt", ShiftUtil.getTotalPaymentByCash(shift));
            pw.printf("  %-30s : %s\n", "Chuyển khoản", ShiftUtil.getTotalPaymentByWireTransfer(shift));
            pw.println("-".repeat(80));
            pw.println();

            // Mặt hàng tiêu thụ
            pw.println("Mặt hàng tiêu thụ:");
            pw.printf("%-25s | %-10s | %-15s | %-10s\n", "Tên mặt hàng", "Số lượng", "Doanh thu", "Tỉ lệ (%)");
            pw.println("-".repeat(80));
            for (Map.Entry<Long, StaticalProduct> entry : staticalProducts.entrySet()) {
                StaticalProduct staticalProduct = entry.getValue();
                pw.printf("%-25s | %-10d | %-15s | %-10s\n",
                        staticalProduct.getProductName(),
                        staticalProduct.getQuantity(),
                        staticalProduct.getRevenue(),
                        staticalProduct.getRatio() + "%");
            }
            pw.println("=".repeat(80));
        } catch (IOException ex) {
            Logger.getLogger(PrinterUtil.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
