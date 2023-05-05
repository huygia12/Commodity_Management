/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package View;

import Models.Employee;
import Models.EmployeeList;
import Models.Shift;
import java.math.BigDecimal;
import java.util.Scanner;

/**
 *
 * @author FPTSHOP
 */
public class ShiftView {

    final Scanner sc = new Scanner(System.in);
    final Cautions ctions = new Cautions();

    public void shiftNotOpenCaution() {
        System.out.println("Shift not open yet!");
    }

    public void shiftNotEndCaution() {
        System.out.println("Current shift not over yet!!");
    }

    public void menuOfEditShift() {
        System.out.print("""
                           \n****************************************
                           * 1. Open shift                        *
                           * 2. Set Shipping fee                  *
                           * 3. Change employees of this shift    *
                           * 4. Change this shift openningbalance *
                           * 5. End shift                         *
                           ****************************************
                           Options => """);
    }

    public void menuOfModifyEmployeeListOfThisShift(){
        System.out.print("""
                           \n***********************************************
                           * 1. Add employee                             *
                           * 2. Remove employee                          *
                           * 3. Reset and retype employees of this Shift *
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
}