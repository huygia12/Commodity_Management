/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controllers;

import Ultility.IDGenerator;
import Models.*;
import View.ShiftView;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

/**
 *
 * @author FPTSHOP
 */
public class ShiftController {

    private final ShiftView shiftView = new ShiftView();
    final Scanner sc = new Scanner(System.in);
    final OrderController orderCtr = new OrderController();
    final GoodsController goodsCtr = new GoodsController();
    final EmployeeListController employeeListCtr = new EmployeeListController();

    public ShiftController() {
    }

    public ShiftView getView() {
        return this.shiftView;
    }

    public Shift ShiftManagement(EmployeeList employeeList, Store myStore, IDGenerator idGenerator, History currentHistory, Shift shift) {
        HistoryController hisCtr = new HistoryController();
        if (employeeList.getList().isEmpty()) {
            System.out.println("Please add employees first to open shift!\n(Go to 'Employee Management'->'Add new Employee')");
            return null;
        }
        String choice;
        do {
            this.shiftView.menuOfShiftManagement();
            choice = sc.nextLine();
            switch (choice) {
                case "1":
                    
                    break;
                case "2":
                    if (shift == null) {
                        this.shiftView.shiftNotOpenCaution();
                        break;
                    }
                    this.shiftView.typeInSurcharge(shift);
                    break;
                case "3":
                    if (shift == null) {
                        this.shiftView.shiftNotOpenCaution();
                        break;
                    }
                    modifyEmployeeOfThisShift(employeeList, shift);
                    break;
                case "4":
                    if (shift == null) {
                        this.shiftView.shiftNotOpenCaution();
                        break;
                    }
                    this.shiftView.typeInOpeningBalance(shift);
                    break;
                case "5":
                    if (shift == null) {
                        this.shiftView.shiftNotOpenCaution();
                        break;
                    }
                    break;
                case "6":
                    if (shift == null) {
                        this.shiftView.shiftNotOpenCaution();
                        break;
                    }
                    break;
                case "7":
                    if (shift == null) {
                        this.shiftView.shiftNotOpenCaution();
                        break;
                    }
                    break;
                case "8":
                    if (shift == null) {
                        this.shiftView.shiftNotOpenCaution();
                        break;
                    }
                    if (endShift(myStore, shift)) {
                        shift = null;
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
        return shift;
    }

    public BigDecimal getGrossRevenue(Shift shift) {
        BigDecimal result = BigDecimal.ZERO;
        for (Order order : shift.getOrderHisPerShift()) {
            result = result.add(orderCtr.getSubTotal(order));
        }
        return result;
    }

    public BigDecimal getNetRevenue(Shift shift, Store store) {
        BigDecimal result = BigDecimal.ZERO;
        for (Order order : shift.getOrderHisPerShift()) {
            result = result.add(orderCtr.getTotal(order, store));
        }
        return result;
    }

    public BigDecimal getTotalDiscountMoney(Shift shift) {
        BigDecimal result = BigDecimal.ZERO;
        for (Order order : shift.getOrderHisPerShift()) {
            result = result.add(orderCtr.getDiscountAmount(order));
        }
        return result;
    }

    public BigDecimal getTotalPaymentByCash(Shift shift, Store store) {
        BigDecimal result = BigDecimal.ZERO;
        for (Order order : shift.getOrderHisPerShift()) {
            if (order.getPaymentOptions().equals(PaymentOptions.CASH_PAYMENT)) {
                result = result.add(orderCtr.getTotal(order, store));
            }
        }
        return result;
    }

    public BigDecimal getTotalPaymentByWireTransfer(Shift shift, Store store) {
        BigDecimal result = BigDecimal.ZERO;
        for (Order order : shift.getOrderHisPerShift()) {
            if (order.getPaymentOptions().equals(PaymentOptions.OTHER_PAYMENT)) {
                result = result.add(orderCtr.getTotal(order, store));
            }
        }
        return result;
    }

    public BigDecimal getTotalVAT(Shift shift) {
        BigDecimal result = BigDecimal.ZERO;
        for (Order order : shift.getOrderHisPerShift()) {
            result = result.add(orderCtr.getTaxAmount(order));
        }
        return result;
    }

    public BigDecimal getTotalPointDiscount(Shift shift, Store store) {
        BigDecimal result = BigDecimal.ZERO;
        for (Order order : shift.getOrderHisPerShift()) {
            result = result.add(orderCtr.getPointDiscountAmount(order, store));
        }
        return result;
    }

    public long getNumberOfOrder(Shift shift) {
        return shift.getOrderHisPerShift().size();
    }

    public BigDecimal getAveragePerOrder(Shift shift, Store store) {
        if (getNumberOfOrder(shift) == 0) {
            return BigDecimal.ZERO;
        }
        return getNetRevenue(shift, store).divide(new BigDecimal(getNumberOfOrder(shift)+""), 2 , RoundingMode.HALF_UP);
    }

    public BigDecimal getTotalQuanOfThisShift(Shift shift) {
        BigDecimal result = BigDecimal.ZERO;
        for (Order order : shift.getOrderHisPerShift()) {
            for (Goods goods : order.getList()) {
                result = result.add(goods.getTotalQuantity());
            }
        }
        return result;
    }

    public Order containOrder(List<Order> orderList, String orderID) {
        for (Order order : orderList) {
            if (order.getID().equals(orderID)) {
                return order;
            }
        }
        return null;
    }

    private void addEmployeeToShift(EmployeeList employeeList, Shift shift) {
        Employee e = employeeListCtr.searchEmployee(employeeList);
        if (e != null) {
            if (this.shiftView.checkIfThisShiftContainThisEmployee(shift, e.getCCCD())) {
                return;
            }
            shift.getEmployeeOfThisShift().getList().add(e);
        }
    }

    private void deleteEmployeeFromShift(EmployeeList employeeList, Shift shift) {
        Employee e = employeeListCtr.searchEmployee(employeeList);
        if (e != null) {
            boolean checkRemoving = true;
            if (e.getCCCD().equalsIgnoreCase(shift.getCashier().getCCCD())) {
                if (this.shiftView.removeEmployeeCaution(shift)) {
                    int check = -1;
                    while (check == -1) {
                        check = shiftView.typeInCashier(shift, employeeList);
                    }
                }
                checkRemoving = false;
            }
            if (checkRemoving) {
                shift.getEmployeeOfThisShift().getList().remove(e);
            }
        }
    }

    private void retypeEmployeeListOfThisShift(EmployeeList employeeList, Shift shift) {
        shift.getEmployeeOfThisShift().getList().clear();
        System.out.println("EmployeeList clear!");
        int check = -1;
        while (check == -1) {
            check = this.shiftView.typeInEmployeesOfThisShift(shift, employeeList);
        }
        if (check == 1) {
            check = shiftView.typeInCashier(shift, employeeList);
        }
    }

    private void modifyEmployeeOfThisShift(EmployeeList employeeList, Shift shift) {
        String choice;
        do {
            shiftView.menuOfModifyEmployeeListOfThisShift();
            choice = sc.nextLine();
            switch (choice) {
                case "1":
                    addEmployeeToShift(employeeList, shift);
                    break;
                case "2":
                    deleteEmployeeFromShift(employeeList, shift);
                    break;
                case "3":
                    retypeEmployeeListOfThisShift(employeeList, shift);
                    break;
                case "4":
                    System.out.println("Back...");
                    break;
                default:
                    System.out.println("Wrong input, Please type from 1->4!");
            }
        } while (!choice.equalsIgnoreCase("4"));
    }

    private boolean endShift(Store myStore, Shift shift) {
        if (shift.getSurcharge() == BigDecimal.ZERO) {
            if (this.shiftView.typeInSurcharge(shift) != 1) {
                return false;
            }
        }
        shift.setEndTime();
        shiftView.printFileOfThisShiftOverView(myStore, shift, this);
        return true;
    }

    public void openShiftForGUI(Store store, Shift shift, 
            int tax, BigDecimal openBalance, 
            Employee cashier, EmployeeList employeeList,
            String note) {
        shift.setState(ShiftState.OPENED);
        shift.setID(store.getiDGenerator().generateID(Shift.class.getName(), 6));
        shift.setOpenTime();
        shift.setTax(tax);
        shift.setOpeningBalance(openBalance);
        shift.setCashier(cashier);
        shift.setEmployeeOfThisShift(employeeList);
        shift.setNote(note);
        store.getHistory().getShiftHistory().add(shift);
    }
    
    public void endShiftForGUI(Shift shift, String note, BigDecimal surcharge) {
        shift.setEndTime();
        shift.setNote(note);
        shift.setSurcharge(surcharge);
        shift.setState(ShiftState.CLOSED);
    }
}
