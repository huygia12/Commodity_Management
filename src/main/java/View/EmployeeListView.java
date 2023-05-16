/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package View;

import Models.Employee;
import Models.EmployeeList;

/**
 *
 * @author FPTSHOP
 */
public class EmployeeListView {

    private int salaryMaxSize;
    private int CCCDmaxSize;
    private int firstNameMaxSize;
    private int lastNameMaxSize;
    private int phoneNumberMaxSize;
    private int addressMaxSize;

    public void menuOfEmployeeManagement() {
        System.out.print("""
                           \n**********EMPLOYEE_MANAGEMENT**********
                           * 1. Add new Employee                 *
                           * 2. Change Employee Information      *
                           * 3. Remove an employee               *
                           * 4. Search for detail of an employee *
                           * 5. Show all employee & infor        *
                           * 6. Back                             *
                           ***************************************
                           Options =>  """);
    }

    public void menuOfEditEmployeeInfor() {
        System.out.print("""
                           \n*******CHANGE_EMPLOYEE_INFOR*********
                           * 1. Change employee first Name     *
                           * 2. Change employee last Name      *
                           * 3. Change employee identification *
                           * 4. Change employee phone number   *
                           * 5. Change employee age            *
                           * 6. Change employee gender         *
                           * 7. Change employee salary         *
                           * 8. Change employee address        *
                           * 9. Back                           *
                           *************************************
                           Options => """);
    }

    public void showList(EmployeeList employeeList) {
        if (employeeList.getList().isEmpty()) {
            System.out.println("Nothing found in this List!");
            return;
        }
        computeSizeOfEachCol(employeeList);
        int totalColSize = salaryMaxSize + CCCDmaxSize + firstNameMaxSize
                + lastNameMaxSize + phoneNumberMaxSize + addressMaxSize + 3 + 6;
        final int extraLengthOfBorder = 23;
        int borderLength = totalColSize + extraLengthOfBorder;
        System.out.println("");
        System.out.println("|" + "-".repeat(borderLength) + "|");
        System.out.printf("| %-" + String.format(CCCDmaxSize + "s")
                + " | %-" + String.format(firstNameMaxSize + "s")
                + " | %-" + String.format(lastNameMaxSize + "s")
                + " | %-" + String.format(phoneNumberMaxSize + "s")
                + " | %-" + String.format(3 + "s")
                + " | %-" + String.format(6 + "s")
                + " | %-" + String.format(addressMaxSize + "s")
                + " | %-" + String.format(salaryMaxSize + "s") + " |\n",
                "CCCD",
                "First Name",
                "Last Name",
                "Phone Number",
                "Age",
                "Gender",
                "Address",
                "Salary Per Day");
        System.out.println("|" + "-".repeat(borderLength) + "|");
        for (Employee e : employeeList.getList()) {
            System.out.printf("| %-" + String.format(CCCDmaxSize + "s")
                    + " | %-" + String.format(firstNameMaxSize + "s")
                    + " | %-" + String.format(lastNameMaxSize + "s")
                    + " | %-" + String.format(phoneNumberMaxSize + "s")
                    + " | %-" + String.format(3 + "s")
                    + " | %-" + String.format(6 + "s")
                    + " | %-" + String.format(addressMaxSize + "s")
                    + " | %-" + String.format(salaryMaxSize + "s") + " |\n",
                    e.getCCCD(),
                    e.getFirstName(),
                    e.getLastName(),
                    e.getPhoneNumber(),
                    e.getAge(),
                    e.getGender(),
                    e.getAddress(),
                    e.getSalaryPerDay());
            System.out.println("|" + "-".repeat(borderLength) + "|");
        }
    }

    private void computeSizeOfEachCol(EmployeeList employeeList) {
        salaryMaxSize = "Salary per day".length();
        CCCDmaxSize = "CCCD".length();
        firstNameMaxSize = "First Name".length();
        lastNameMaxSize = "Last Name".length();
        phoneNumberMaxSize = "Phone Number".length();
        addressMaxSize = "Address".length();
        for (Employee e : employeeList.getList()) {
            if ((e.getSalaryPerDay() + "").length() > salaryMaxSize) {
                salaryMaxSize = (e.getSalaryPerDay() + "").length();
            }
            if (e.getCCCD().length() > CCCDmaxSize) {
                CCCDmaxSize = e.getCCCD().length();
            }
            if (e.getFirstName().length() > firstNameMaxSize) {
                firstNameMaxSize = e.getFirstName().length();
            }
            if (e.getLastName().length() > lastNameMaxSize) {
                lastNameMaxSize = e.getLastName().length();
            }
            if (e.getPhoneNumber().length() > phoneNumberMaxSize) {
                phoneNumberMaxSize = e.getPhoneNumber().length();
            }
            if (e.getAddress().length() > addressMaxSize) {
                addressMaxSize = e.getAddress().length();
            }
        }
    }

}
