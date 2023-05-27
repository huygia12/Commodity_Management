/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change shift license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit shift template
 */
package View;

import Controllers.EmployeeListController;
import Controllers.ShiftController;
import Ultility.Cautions;
import Models.Employee;
import Models.EmployeeList;
import Models.Shift;
import Models.StaticalItems;
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

    public int typeInShippingFee(Shift shift) {
        while (true) {
            System.out.print("Type in Shipping Fee or type BACK to back: ");
            String inputStr = sc.nextLine();
            if ("back".equalsIgnoreCase(inputStr)) {
                return -1;
            } else if (ctions.checkIfNoInput(inputStr)) {
            } else {
                try {
                    BigDecimal openBalance = new BigDecimal(inputStr);
                    if (ctions.checkIfNumberNegative(openBalance)) {
                        continue;
                    }
                    shift.setTransportFee(openBalance);
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

    public void printFileOfThisShiftOverView(Store myStore, Shift shift, ShiftController shiftCtr) {
        Path outputPath = Path.of(FILE_PRINT);
        try ( PrintWriter pw = new PrintWriter(Files.newBufferedWriter(outputPath,
                StandardOpenOption.CREATE,
                StandardOpenOption.WRITE,
                StandardOpenOption.TRUNCATE_EXISTING))) {
            pw.printf("%11s\n", "END-SHIFT-REPORT");
            pw.println(String.format("%21s" + " | " + "%-20s", "STORE NAME", myStore.getName()));
            pw.println("-".repeat(40));
            pw.println(String.format("%21s" + " | " + "%-20s", "Open time", shift.getOpenTime()));
            pw.println(String.format("%21s" + " | " + "%-20s", "Close time", shift.getEndTime()));
            pw.println(String.format("%21s" + " | " + "%-20s", "Cashier", shift.getCashier().getFirstName() + " " + shift.getCashier().getLastName()));
            pw.println(String.format("%21s" + " | " + "%-20.1f", "Openning balance", shift.getOpeningBalance()));
            pw.println(String.format("%21s" + " | " + "%-20.1f", "Gross revenue", shiftCtr.getGrossRevenue(shift)));
            pw.println(String.format("%21s" + " | " + "%-20.1f", "Total direct discount", shiftCtr.getTotalDiscountMoney(shift)));
            pw.println(String.format("%21s" + " | " + "%-20.1f", "Total point discount", shiftCtr.getTotalPointDiscount(shift)));
            pw.println(String.format("%21s" + " | " + "%-20.1f", "VAT" + shift.getTax() + "%", shiftCtr.getTotalVAT(shift)));
            pw.println(String.format("%21s" + " | " + "%-20.1f", "Shipping fee", shift.getTransportFee()));
            pw.println(String.format("%21s" + " | " + "%-20.1f", "Net revenue", shiftCtr.getNetRevenue(shift)));
            pw.println(String.format("%21s" + " | " + "%-20s", "Number of orders", shiftCtr.getNumberOfOrder(shift)));
            pw.println(String.format("%21s" + " | " + "%-20.1f", "Average per Order", shiftCtr.getAveragePerOrder(shift)));
            pw.println(String.format("%21s", "OPTIONS PAYMENT:"));
            pw.println(String.format("%21s" + " | " + "%-20.1f", "+Cash", shiftCtr.getTotalPaymentByCash(shift)));
            pw.println(String.format("%21s" + " | " + "%-20.1f", "+Wire transfer", shiftCtr.getTotalPaymentByWireTransfer(shift)));
            pw.println(String.format("%21s" + " | " + "%-20.1f", "+Current CashBox money", shiftCtr.getTotalPaymentByCash(shift).add(shift.getOpeningBalance())));
            pw.println(String.format("%21s", "CONSUMPTIONS:"));
            pw.println(String.format("%-21s" + " | " + "%-20s" + " | " + "%-20s" + " | " + "%-20s", "Goods Name", "Quantity", "Revenue", "Ratio"));
            List<StaticalItems> staticalItemsList = new ArrayList<>(shiftCtr.getStaticalList(shift).values());
            staticalItemsList.stream().forEach(x -> pw.println(String.format("%-21s" + " | " + "%-20.1f" + " | " + "%-20.1f" + " | " + "%-20s",
                    x.getName(), x.getQuantity(), x.getRevenue(), String.format("%.1f", x.getRatio()) + "%")));
        } catch (IOException ex) {
            Logger.getLogger(Shift.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
