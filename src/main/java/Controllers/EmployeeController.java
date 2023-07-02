/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controllers;

import Models.Employee;

/**
 *
 * @author FPTSHOP
 */
public class EmployeeController {

    public EmployeeController(){}

    public Employee cloneEmployee(Employee employee) {
        Employee cloneEmployee = new Employee();
        cloneEmployee.setAddress(employee.getAddress());
        cloneEmployee.setAge(employee.getAge());
        cloneEmployee.setCCCD(employee.getCCCD());
        cloneEmployee.setFirstName(employee.getFirstName());
        cloneEmployee.setLastName(employee.getLastName());
        cloneEmployee.setPhoneNumber(employee.getPhoneNumber());
        cloneEmployee.setSalaryPerDay(employee.getSalaryPerDay());
        cloneEmployee.setGender(employee.getGender());
        return cloneEmployee;
    }
    
    public boolean equals(Employee employee, Employee anotherEmployee) {
        return employee.getCCCD().equalsIgnoreCase(anotherEmployee.getCCCD())
                && employee.getAddress().equalsIgnoreCase(anotherEmployee.getAddress())
                && (employee.getAge() == anotherEmployee.getAge())
                && employee.getGender().equals(anotherEmployee.getGender())
                && employee.getFirstName().equalsIgnoreCase(anotherEmployee.getFirstName())
                && employee.getLastName().equalsIgnoreCase(anotherEmployee.getLastName())
                && employee.getPhoneNumber().equalsIgnoreCase(anotherEmployee.getPhoneNumber())
                && (employee.getSalaryPerDay().compareTo(anotherEmployee.getSalaryPerDay()) == 0);
    }
}
