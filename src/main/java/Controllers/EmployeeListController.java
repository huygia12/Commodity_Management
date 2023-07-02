/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controllers;

import Models.Employee;
import Models.EmployeeList;
import Models.Shift;
import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author FPTSHOP
 */
public class EmployeeListController {
    public final int BY_CCCD = 0;
    public final int BY_PHONE_NUMBER = 1;
    
    public EmployeeListController() {
    }

    public Employee containEmployee(EmployeeList employeeList, String key, int keyType) {
        for (Employee e : employeeList.getList()) {
            String comparedStr;
            if(keyType == this.BY_CCCD){
                comparedStr = e.getCCCD();
            }else{
                comparedStr = e.getPhoneNumber();
            }
            
            if (comparedStr.equals(key)) {
                return e;
            }
        }
        return null;
    }
}
