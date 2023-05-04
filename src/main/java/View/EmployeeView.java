/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package View;

import Models.Employee;
import Models.EmployeeList;
import java.math.BigDecimal;

/**
 *
 * @author FPTSHOP
 */
public class EmployeeView extends HumanView<Employee> {

    public int typeInSalaryPerDay(Employee e) {
        while (true) {
            System.out.print("Type in Salary per day or type EXIT/BACK to exit/back: ");
            String inputStr = sc.nextLine();
            if ("exit".equalsIgnoreCase(inputStr)) {
                return 0;
            } else if ("back".equalsIgnoreCase(inputStr)) {
                return -1;
            } else if (ctions.checkIfNoInput(inputStr)) {
            } else {
                try {
                    BigDecimal salaryPerDay = new BigDecimal(inputStr);
                    if (!ctions.checkIfBigDecimalNegative(salaryPerDay)) {
                        continue;
                    }
                    e.setSalaryPerDay(salaryPerDay);
                    return 1;
                } catch (NumberFormatException nfe) {
                    ctions.wrInput();
                }
            }
        }
    }

    public int typeInCCCD(Employee e, EmployeeList employeeList) {
        while (true) {
            System.out.print("Type in CCCD or type EXIT/BACK to exit/back: ");
            String inputStr = sc.nextLine();
            if ("exit".equalsIgnoreCase(inputStr)) {
                return 0;
            } else if ("back".equalsIgnoreCase(inputStr)) {
                return -1;
            } else if (ctions.checkIfNoInput(inputStr)
                    || !ctions.checkIfANumberSequence(inputStr)) {
            } else if (employeeList.containEmployee(inputStr) != null) {
                System.out.println("This employee already existed.");
            } else {
                e.setCCCD(inputStr);
                return 1;
            }
        }
    }
}
