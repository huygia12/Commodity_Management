/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controllers;

import Models.EmployeeList;
import Models.History;
import Models.IDGenerator;
import Models.Shift;
import Models.Store;
import View.ShiftView;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 *
 * @author FPTSHOP
 */
public class ShiftController {

    @SerializedName("view")
    @Expose
    private final ShiftView view = new ShiftView();
    @SerializedName("shift")
    @Expose
    private Shift shift;

    public ShiftController() {
    }

    public ShiftController(Shift shift) {
        this.shift = shift;
    }

    public ShiftView getView() {
        return this.view;
    }

    public Shift getShift() {
        return this.shift;
    }

    public void setShift(Shift shift) {
        this.shift = shift;
    }

    public void ShiftManagement(EmployeeList employeeList, Store myStore, IDGenerator idGenerator, History currentHistory, Scanner sc) {
        if (employeeList.getList().isEmpty()) {
            System.out.println("Please add employees first to open shift!\n(Go to 'Employee Management'->'Add new Employee')");
            return;
        }
        List<Shift> shiftList = new ArrayList<>();
        shiftList.add(this.shift);
        HistoryController hisCtr = new HistoryController(new History(shiftList));
        String choice;
        do {
            this.view.menuOfShiftManagement();
            choice = sc.nextLine();
            switch (choice) {
                case "1":
                    if (this.shift != null) {
                        this.view.shiftNotEndCaution();
                        break;
                    }
                    this.setShift(new Shift());
                    if (!this.shift.openShift(this.view, employeeList,
                            idGenerator, myStore, sc)) {
                        this.setShift(null);
                    }
                    currentHistory.getShiftHistory().add(this.shift);
                    break;
                case "2":
                    if (this.shift == null) {
                        this.view.shiftNotOpenCaution();
                        break;
                    }
                    this.view.typeInShippingFee(this.shift, sc);
                    break;
                case "3":
                    if (this.shift == null) {
                        this.view.shiftNotOpenCaution();
                        break;
                    }
                    this.shift.modifyEmployeeOfThisShift(view, employeeList, sc);
                    break;
                case "4":
                    if (this.shift == null) {
                        this.view.shiftNotOpenCaution();
                        break;
                    }
                    this.view.typeInOpeningBalance(this.shift, sc);
                    break;
                case "5":
                    if (this.shift == null) {
                        this.view.shiftNotOpenCaution();
                        break;
                    }
                    if (this.shift.getOrderHisPerShift().isEmpty()) {
                        System.out.println("Your current order history is empty!");
                        break;
                    }
                    hisCtr.getHistoryView().showOrderHistory(new History(shiftList));
                    hisCtr.getHistoryView().showOrderHistory(
                            hisCtr.makeHisoryOrderGoodsList(shiftList));
                    break;
                case "6":
                    if (this.shift == null) {
                        this.view.shiftNotOpenCaution();
                        break;
                    }
                    if (this.shift.getImportGoodsHis().getGoodsList().isEmpty()) {
                        System.out.println("Your current import history is empty!");
                        break;
                    }
                    hisCtr.getHistoryView().showImportGoodsHistory(new History(shiftList));
                    hisCtr.getHistoryView().showImportGoodsHistory(
                            hisCtr.makeHistoryImportGoodsList(shiftList));
                    break;
                case "7":
                    if (this.shift == null) {
                        this.view.shiftNotOpenCaution();
                        break;
                    }
                    hisCtr.getHistoryView().showAnShiftInDetail(this.shift);
                    break;
                case "8":
                    if (this.shift == null) {
                        this.view.shiftNotOpenCaution();
                        break;
                    }
                    if (this.shift.endShift(this.view, myStore, sc)) {
                        this.shift = null;
                    }
                    break;
                case "9":
                    System.out.println("Back...");
                    break;
                default:
                    System.out.println("Wrong input, Please type from 1->9!");
                    break;
            }
        } while (!choice.equals("9"));
    }
}
