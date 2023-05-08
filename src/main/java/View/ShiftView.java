/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change shift license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit shift template
 */
package View;

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

    public void shiftNotOpenCaution() {
        System.out.println("Shift not open yet!");
    }

    public void shiftNotEndCaution() {
        System.out.println("Current shift not over yet!!");
    }

    public void menuOfShiftManagement() {
        System.out.print("""
                           \n****************************************
                           * 1. Open shift                        *
                           * 2. Set Shipping fee                  *
                           * 3. Change employees of shift shift   *
                           * 4. Change shift openningbalance      *
                           * 5. Show order history                *
                           * 6. Show import goods history         *
                           * 7. Current shift over view           *
                           * 8. End shift                         *
                           * 9. Back                              *
                           ****************************************
                           Options => """);
    }

    public void menuOfModifyEmployeeListOfThisShift(){
        System.out.print("""
                           \n***********************************************
                           * 1. Add employee                             *
                           * 2. Remove employee                          *
                           * 3. Reset and retype employees of shift Shift *
                           * 4. Back                                     *
                           ***********************************************
                           Options => """);
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
                    if (!ctions.checkIfBigDecimalNegative(openBalance)) {
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
                    if (!ctions.checkIfBigDecimalNegative(openBalance)) {
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
        do {
            e = employeeList.searchEmployee();
            if (e != null) {
                shift.getEmployeeOfThisShift().getList().add(e);
            }
        } while (e == null);
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
    
    public int typeInCashier(Shift shift) {
        while (true) {
            Employee e = shift.getEmployeeOfThisShift().searchEmployee();
            if (e == null) {
                return -1;
            } else {
                return 1;
            }
        }
    }
    
    public void printFileOfThisShiftOverView(Store myStore, Shift shift) {
        Path outputPath = Path.of(FILE_PRINT);
        try ( PrintWriter pw = new PrintWriter(Files.newBufferedWriter(outputPath,
                StandardOpenOption.CREATE,
                StandardOpenOption.WRITE,
                StandardOpenOption.TRUNCATE_EXISTING))) {
            pw.printf("%5s\n", "END-SHIFT-REPORT");
            pw.println(String.format("%20s" + " | " + "%-20s", "STORE NAME", myStore.getName()));
            pw.println("-".repeat(40));
            pw.println(String.format("%20s" + " | " + "%-20s", "Open time", shift.getOpenTime()));
            pw.println(String.format("%20s" + " | " + "%-20s", "Close time", shift.getEndTime()));
            pw.println(String.format("%20s" + " | " + "%-20s", "Cashier", shift.getCashier().getFirstName() + " " + shift.getCashier().getLastName()));
            pw.println(String.format("%20s" + " | " + "%-20.0f", "Openning balance", shift.getOpeningBalance()));
            pw.println(String.format("%20s" + " | " + "%-20.0f", "Gross revenue", shift.getGrossRevenue()));
            pw.println(String.format("%20s" + " | " + "%-20.0f", "Total direct discount", shift.getTotalDiscountMoney()));
            pw.println(String.format("%20s" + " | " + "%-20.0f", "Total point discount", shift.getTotalPointDiscount()));
            pw.println(String.format("%20s" + " | " + "%-20.0f", "VAT" + shift.getVAT() + "%", shift.getTotalVAT()));
            pw.println(String.format("%20s" + " | " + "%-20.0f", "Shipping fee", shift.getTransportFee()));
            pw.println(String.format("%20s" + " | " + "%-20.0f", "Net revenue", shift.getNetRevenue()));
            pw.println(String.format("%20s" + " | " + "%-20s", "Number of orders", shift.getNumberOfOrder()));
            pw.println(String.format("%20s" + " | " + "%-20.0f", "Average per Order", shift.getAveragePerOrder()));
            pw.println(String.format("%5s", "OPTIONS PAYMENT:"));
            pw.println(String.format("%20s" + " | " + "%-20.0f", "+Cash", shift.getTotalPaymentByCash()));
            pw.println(String.format("%20s" + " | " + "%-20.0f", "+Wire transfer", shift.getTotalPaymentByWireTransfer()));
            pw.println(String.format("%20s" + " | " + "%-20.0f", "+Current CashBox money", shift.getTotalPaymentByCash().add(shift.getOpeningBalance())));
            pw.println(String.format("%5s", "CONSUMPTIONS:"));
            pw.println(String.format("%-10s" + " | " + "%-10s"+ " | " + "%-10s"+ " | " + "%-10s", "Goods Name", "Quantity", "Revenue", "Ratio"));
            List<StaticalItems> staticalItemsList = new ArrayList<>(shift.getStaticalList().values());
            staticalItemsList.stream().forEach(x->pw.println(String.format("%-10s" + " | " + "%-10.0f"+ " | " + "%-10.0f"+ " | " + "%-10.0f%s", 
                    x.getName(), x.getQuantity(), x.getRevenue(), x.getRatio(), "%")));
        } catch (IOException ex) {
            Logger.getLogger(Shift.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}