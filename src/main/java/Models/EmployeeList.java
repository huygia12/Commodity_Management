/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Models;

import java.util.List;

/**
 *
 * @author FPTSHOP
 */
public class EmployeeList extends AbstractHumanList<Employee> {

    public EmployeeList() {
    }

    public EmployeeList(List<Employee> employeeList) {
        this.list = employeeList;
    }

    public List<Employee> getList() {
        return list;
    }

    public void setList(List<Employee> humanList) {
        this.list = humanList;
    }

}
