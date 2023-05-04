/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controllers;

import Models.Employee;
import View.EmployeeView;

/**
 *
 * @author FPTSHOP
 */
public class EmployeeController {
    private Employee employee;
    private final EmployeeView view = new EmployeeView();

    public EmployeeController(){}
    
    public EmployeeController(Employee employee) {
        this.employee = employee;
    }

    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }

    public EmployeeView getView() {
        return view;
    }

}
