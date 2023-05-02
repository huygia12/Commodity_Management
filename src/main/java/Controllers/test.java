/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controllers;

import Builder.EmployeeBuilder;
import Models.Employee;
import Models.Gender;

/**
 *
 * @author FPTSHOP
 */
public class test {
    public static void main(String[] args) {
        Employee e = new EmployeeBuilder().withGender(Gender.OTHER).build();
        System.out.println(e);
    }
}
