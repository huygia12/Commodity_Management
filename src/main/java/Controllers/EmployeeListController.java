/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controllers;

import Models.Employee;
import Models.EmployeeList;
import View.EmployeeListView;
import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author FPTSHOP
 */
public class EmployeeListController {
    
    final Scanner sc = new Scanner(System.in);
    private final EmployeeListView view = new EmployeeListView();
    private EmployeeList employeeList;

    public EmployeeListController() {
    }

    public EmployeeListController(EmployeeList employeeList) {
        this.employeeList = employeeList;
    }

    public EmployeeList getEmployeeList() {
        return employeeList;
    }

    public void setEmployeeList(EmployeeList employeeList) {
        this.employeeList = employeeList;
    }

    public EmployeeListView getView() {
        return view;
    }

    public void employeeListManagement() {
        EmployeeController employeeCtr = new EmployeeController();
        Employee searchedEmployee;
        String choice;
        do {
            this.view.menuOfEmployeeManagement();
            choice = sc.nextLine().trim();
            switch (choice) {
                case "1":
                    this.getEmployeeList()
                            .addNewEmployee(employeeCtr.getView());
                    break;
                case "2":
                    searchedEmployee = this.getEmployeeList().searchEmployee();
                    if (searchedEmployee != null) {
                        this.getEmployeeList().editEmployeeInfor(searchedEmployee, view, employeeCtr.getView());
                    }
                    break;
                case "3":
                    Employee delEmployee = this.employeeList.searchEmployee();
                    if (delEmployee != null) {
                        this.getEmployeeList().deleteEmpployee(delEmployee);
                    }
                    break;
                case "4":
                    searchedEmployee = this.getEmployeeList().searchEmployee();
                    if (searchedEmployee != null) {
                        EmployeeList tmp = new EmployeeList(new ArrayList<>());
                        tmp.getList().add(searchedEmployee);
                        tmp.showList();
                    }
                    break;
                case "5":
                    this.getEmployeeList().showList();
                    break;
                case "6":
                    break;
                default:
                    System.out.println("Wrong input, Please type from 1->6!");
                    break;
            }
        } while (!choice.equals("6"));
    }
}
