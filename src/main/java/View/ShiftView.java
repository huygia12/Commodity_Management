/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package View;

import Models.Employee;
import Models.EmployeeList;
import Models.Shift;
import java.math.BigDecimal;
import java.time.DateTimeException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

/**
 *
 * @author FPTSHOP
 */
public class ShiftView {

    final Scanner sc = new Scanner(System.in);
    Cautions ctions = new Cautions();

    public ShiftView() {
    }

    public void shiftNotOpenCaution() {
        System.out.println("Shift not open yet!");
    }

    public void shiftNotEndCaution() {
        System.out.println("Current shift not over yet!!");
    }

    public void menuOfEditShift() {
        System.out.print("""
                           *************************************
                           * 1. Open shift                     *
                           * 2. Set Shipping fee               *
                           * 3. Change employees of this shift *
                           * 4. Change this shift open balance *
                           * 5. End shift                      *
                           *************************************
                           Options => 
                           """);
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
            System.out.print("Type in Shipping Fee or type EXIT/BACK to exit/back: ");
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
                    shift.setTransportFee(openBalance);
                    return 1;
                } catch (NumberFormatException nfe) {
                    ctions.wrInput();
                }
            }
        }
    }
    
    public int typeInEmployeeList(Shift shift, EmployeeList originEmployeeList) {
        Employee e;
        do {
            e = originEmployeeList.searchEmployee();
            if (e != null) {
                shift.getEmployeeList().getList().add(e);
            }
        } while (e == null);
        while (true) {
            System.out.print("Type EXIT/BACK/Done to exit/back/done of adding employees: ");
            String inputStr = sc.nextLine();
            if ("exit".equalsIgnoreCase(inputStr)) {
                return 0;
            } else if ("back".equalsIgnoreCase(inputStr)) {
                return -1;
            } else if ("done".equalsIgnoreCase(inputStr)) {
                return 1;
            }
        }
    }
    
    public int typeInCashier(Shift shift) {
        while (true) {
            Employee e = shift.getEmployeeList().searchEmployee();
            if (e == null) {
                return -1;
            } else {
                return 1;
            }
        }
    }
}