/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package View;

/**
 *
 * @author FPTSHOP
 */
public class EmployeeListView {

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
}
