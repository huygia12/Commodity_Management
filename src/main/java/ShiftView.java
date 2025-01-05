

import Controllers.HistoryController;
import Controllers.ShiftController;
import Models.*;
import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ShiftView {

    private final String HOME = System.getProperty("user.dir");
    private final String SEPARATOR = File.separator;
    private final String FILE_PRINT = HOME + SEPARATOR + "output" + SEPARATOR + "shiftOverView.txt";

    public void printFileOfThisShiftOverView(Store store, Shift shift, ShiftController shiftCtr) {
        Path outputPath = Path.of(FILE_PRINT);
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
