/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change shift license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit shift template
 */
package View;

import Controllers.EmployeeListController;
import Controllers.HistoryController;
import Controllers.ShiftController;
import Ultility.Cautions;
import Models.Employee;
import Models.EmployeeList;
import Models.GoodsList;
import Models.Shift;
import Models.StaticalGoods;
import Models.Store;
import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.math.BigDecimal;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author FPTSHOP
 */
public class ShiftView {

    private final String HOME = System.getProperty("user.dir");
    private final String SEPARATOR = File.separator;
    private final String FILE_PRINT = HOME + SEPARATOR + "output" + SEPARATOR + "shiftOverView.txt";
    final Scanner sc = new Scanner(System.in);
    final Cautions ctions = new Cautions();
    final EmployeeListController employeeListCtr = new EmployeeListController();

    public void shiftNotOpenCaution() {
        System.out.println("Shift not open yet!");
    }

    public void shiftNotEndCaution() {
        System.out.println("Current shift not over yet!!");
    }

    public boolean removeEmployeeCaution(Shift currentShift) {
        while (true) {
            System.out.println("This eliminates will also remove cashier of this shift, keep your change?");
            System.out.println("(If yes, you must choose another cashier of this shift)");
            System.out.print("(Y/N): ");
            String inputStr = sc.nextLine();
            if (inputStr.equalsIgnoreCase("Y")) {
                return true;
            } else if (inputStr.equalsIgnoreCase("N")) {
                return false;
            }
            ctions.wrInput();
        }
    }

    public void menuOfShiftManagement() {
        System.out.print("""
                           \n************SHIFT_MANAGEMENT************
                           * 1. Open shift                        *
                           * 2. Set Shipping fee                  *
                           * 3. Modify employees of this shift    *
                           * 4. Change shift openning balance     *
                           * 5. Show order history                *
                           * 6. Show import goods history         *
                           * 7. Current shift over view           *
                           * 8. End shift                         *
                           * 9. Back                              *
                           ****************************************
                           Options => """);
    }

    public void menuOfModifyEmployeeListOfThisShift() {
        System.out.print("""
                           \n*********MODIFY_EMPLOYEES_OF_THIS_SHIFT*********
                           * 1. Add employee                              *
                           * 2. Remove employee                           *
                           * 3. Reset and retype employees of shift Shift *
                           * 4. Back                                      *
                           ************************************************
                           Options => """);
    }

    public boolean checkIfThisShiftContainThisEmployee(Shift shift, String CCCD) {
        if (employeeListCtr.containEmployee(shift.getEmployeeOfThisShift(), CCCD) != null) {
            System.out.println("This employee already existed in this Shift!");
            return true;
        }
        return false;
    }

    public int typeInOpeningBalance(Shift shift) {
        while (true) {
            System.out.print("Type in openning balance or type EXIT/BACK to exit/back: ");
            String inputStr = sc.nextLine();
            if ("exit".equalsIgnoreCase(inputStr)) {
                return 0;
            } else if ("back".equalsIgnoreCase(inputStr)) {
                return -1;
            } else if (ctions.checkIfNoInput(inputStr)) {
            } else {
                try {
                    BigDecimal openBalance = new BigDecimal(inputStr);
                    if (ctions.checkIfNumberNegative(openBalance)) {
                        continue;
                    }
                    shift.setOpeningBalance(openBalance);
                    return 1;
                } catch (NumberFormatException nfe) {
                    ctions.wrInput();
                }
            }
        }
    }

    public int typeInSurcharge(Shift shift) {
        while (true) {
            System.out.print("Type in surcharge or type BACK to back: ");
            String inputStr = sc.nextLine();
            if ("back".equalsIgnoreCase(inputStr)) {
                return -1;
            } else if (ctions.checkIfNoInput(inputStr)) {
            } else {
                try {
                    BigDecimal surcharge = new BigDecimal(inputStr);
                    if (ctions.checkIfNumberNegative(surcharge)) {
                        continue;
                    }
                    shift.setSurcharge(surcharge);
                    return 1;
                } catch (NumberFormatException nfe) {
                    ctions.wrInput();
                }
            }
        }
    }

    public int typeInEmployeesOfThisShift(Shift shift, EmployeeList employeeList) {
        Employee e;
        System.out.println("Choose employees of this shift by typing in their phonenumber:");
        do {
            e = employeeListCtr.searchEmployee(employeeList);
            if (e != null) {
                // neu shift da ton tai employee nay roi thi bo qua
                if (checkIfThisShiftContainThisEmployee(shift, e.getCCCD())) {
                    continue;
                }
                shift.getEmployeeOfThisShift().getList().add(e);
            }
        } while (e != null);
        while (true) {
            System.out.print("Type EXIT/BACK/Done to exit/back/done of adding employees: ");
            String inputStr = sc.nextLine();
            if ("exit".equalsIgnoreCase(inputStr)) {
                shift.getEmployeeOfThisShift().getList().clear();
                return 0;
            } else if ("back".equalsIgnoreCase(inputStr)) {
                shift.getEmployeeOfThisShift().getList().clear();
                return -1;
            } else if ("done".equalsIgnoreCase(inputStr)) {
                return 1;
            }
            ctions.wrInput();
        }
    }

    public int typeInCashier(Shift shift, EmployeeList employeeList) {
        while (true) {
            System.out.println("Choose Cashier of this shift by typing in her/his phonenumber or type BACK to go back:");
            Employee e = employeeListCtr.searchEmployee(employeeList);
            if (e == null) {
                return -1;
            } else {
                shift.setCashier(e);
                // neu chua ton tai employee trong shift thi them vao shift, neu da ton tai thi bo qua
                if (employeeListCtr.containEmployee(shift.getEmployeeOfThisShift(), e.getCCCD()) == null) {
                    shift.getEmployeeOfThisShift().getList().add(e);
                }
                return 1;
            }
        }
    }

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
            pw.println(String.format("%40s" + " | " + "%-40.1f", "Tổng chiết khấu điểm", shiftCtr.getTotalPointDiscount(shift, store)));
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
