/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controllers;

import Models.EmployeeList;
import Models.Shift;
import Models.Store;
import View.Cautions;
import View.ShiftView;
import java.util.Scanner;

/**
 *
 * @author FPTSHOP
 */
public class ShiftController {

    private final ShiftView view = new ShiftView();
    final Scanner sc = new Scanner(System.in);
    final Cautions ctions = new Cautions();
    private Shift shift;

    public ShiftController() {
    }

    public ShiftController(Shift shift) {
        this.shift = shift;
    }

    public ShiftView getView() {
        return view;
    }

    public Shift getShift() {
        return shift;
    }

    public void setShift(Shift shift) {
        this.shift = shift;
    }

    public void ShiftManagement(EmployeeList employeeList, Store myStore) {
        String choice;
        do {
            this.view.menuOfShiftManagement();
            choice = sc.nextLine();
            switch (choice) {
                case "1":
                    this.shift.openShift(this.view, employeeList);
                    break;
                case "2":
                    this.view.typeInShippingFee(this.shift);
                    break;
                case "3":
                    this.shift.modifyEmployeeOfThisShift(view, employeeList);
                    break;
                case "4":
                    this.view.typeInOpeningBalance(this.shift);
                    break;
                case "5":
                    break;
                case "6":
                    break;
                case "7":
                    break;
                case "8":
                    this.shift.endShift(this.view, myStore);
                    break;
                case "9":
                    System.out.println("Back...");
                    break;
                default:
                    System.out.println("Wrong input, Please type from 1->5!");
                    break;
            }
        } while (!choice.equals("8") && !choice.equals("9"));
    }
}
