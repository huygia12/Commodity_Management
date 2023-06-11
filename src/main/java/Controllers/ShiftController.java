/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controllers;

import Models.Employee;
import Models.EmployeeList;
import Models.Goods;
import Models.History;
import Models.ImportedGoods;
import Models.Order;
import Models.PaymentOptions;
import Ultility.IDGenerator;
import Models.Shift;
import Models.StaticalItems;
import Models.Store;
import View.ShiftView;
import java.math.BigDecimal;
import java.util.ArrayList;
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
                    if (shift != null) {
                        this.shiftView.shiftNotEndCaution();
                        break;
                    }
                    shift = openShift(employeeList, idGenerator, myStore, shift);
                    if (shift != null) {
                        currentHistory.getShiftHistory().add(shift);
                    }
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
                    showorderHistory(shift, hisCtr);
                    break;
                case "6":
                    if (shift == null) {
                        this.shiftView.shiftNotOpenCaution();
                        break;
                    }
                    showImportGoodsHistory(shift, hisCtr);
                    break;
                case "7":
                    if (shift == null) {
                        this.shiftView.shiftNotOpenCaution();
                        break;
                    }
                    hisCtr.getHistoryView().showAnShiftInDetail(shift);
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

    public BigDecimal getNetRevenue(Shift shift) {
        BigDecimal result = BigDecimal.ZERO;
        for (Order order : shift.getOrderHisPerShift()) {
            result = result.add(orderCtr.getTotal(order));
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

    public BigDecimal getTotalPaymentByCash(Shift shift) {
        BigDecimal result = BigDecimal.ZERO;
        for (Order order : shift.getOrderHisPerShift()) {
            if (order.getPaymentOptions().equals(PaymentOptions.CASH_PAYMENT)) {
                result = result.add(orderCtr.getTotal(order));
            }
        }
        return result;
    }

    public BigDecimal getTotalPaymentByWireTransfer(Shift shift) {
        BigDecimal result = BigDecimal.ZERO;
        for (Order order : shift.getOrderHisPerShift()) {
            if (order.getPaymentOptions().equals(PaymentOptions.OTHER_PAYMENT)) {
                result = result.add(orderCtr.getTotal(order));
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

    public BigDecimal getTotalPointDiscount(Shift shift) {
        BigDecimal result = BigDecimal.ZERO;
        for (Order order : shift.getOrderHisPerShift()) {
            result = result.add(orderCtr.getPointDiscountAmount(order));
        }
        return result;
    }

    public long getNumberOfOrder(Shift shift) {
        return shift.getOrderHisPerShift().stream().count();
    }

    public BigDecimal getAveragePerOrder(Shift shift) {
        if (getNumberOfOrder(shift) == 0) {
            return BigDecimal.ZERO;
        }
        return getNetRevenue(shift).divide(new BigDecimal(getNumberOfOrder(shift)));
    }

    public BigDecimal getTotalGoodsQuanOfThisShift(Shift shift) {
        BigDecimal result = BigDecimal.ZERO;
        for (Order order : shift.getOrderHisPerShift()) {
            for (Goods goods : order.getList()) {
                result = result.add(goodsCtr.getTotalQuanByShipments(goods));
            }
        }
        return result;
    }

    public Map<String, StaticalItems> getStaticalList(Shift shift) {
        // Tao danh sach consumptions de thong ke sanpham/soluongBan/SoTienThuDuoc/phanTram 
        // cua tat ca san pham trong 1 ca lam viec
        Map<String, StaticalItems> consumptions = new HashMap<>();
        for (Order order : shift.getOrderHisPerShift()) {
            for (Goods goods : order.getList()) {
                StaticalItems newStaticalItems = new StaticalItems();
                newStaticalItems.setName(goods.getGoodsName());
                newStaticalItems.setQuantity(goodsCtr.getTotalQuanByShipments(goods));
                newStaticalItems.setRevenue((goods.getListPrice().add(goodsCtr.getVATMoneyPerGoods(goods, order.getTax())))
                        .multiply(goodsCtr.getTotalQuanByShipments(goods)
                                .multiply(new BigDecimal(1.0 - order.getDiscount() * 1.0 / 100))));
                if (consumptions.containsKey(goods.getID())) {
                    BigDecimal quanBefore = consumptions.get(goods.getID()).getQuantity();
                    BigDecimal revenueBefore = consumptions.get(goods.getID()).getRevenue();
                    newStaticalItems.setQuantity(quanBefore.add(newStaticalItems.getQuantity()));
                    newStaticalItems.setQuantity(revenueBefore.add(newStaticalItems.getRevenue()));
                }
                consumptions.put(goods.getID(), newStaticalItems);
            }
        }
        BigDecimal totalQuan = getTotalGoodsQuanOfThisShift(shift);
        for (Map.Entry<String, StaticalItems> entry : consumptions.entrySet()) {
            entry.getValue().setRatio(Double.parseDouble(entry
                    .getValue()
                    .getQuantity()
                    .divide(totalQuan) + ""));
        }
        return consumptions;
    }

    public Order containOrder(List<Order> orderList, String orderID) {
        for (Order order : orderList) {
            if (order.getID().equals(orderID)) {
                return order;
            }
        }
        return null;
    }

    public ImportedGoods containImportedGoods(List<ImportedGoods> importedGoodsList, String importedGoodsID) {
        for (ImportedGoods importedGoods : importedGoodsList) {
            if (importedGoods.getID().equals(importedGoodsID)) {
                return importedGoods;
            }
        }
        return null;
    }

    private Shift openShift(EmployeeList employeeList, IDGenerator iDGenerator, Store myStore, Shift shift) {
        shift = new Shift(iDGenerator.generateID(Shift.class.getName(), 6),
                myStore.getVAT());
        shift.setOpenTime();
        int n = 1;
        int nextProcess;
        while (n != 3) {
            switch (n) {
                case 1:
                    nextProcess = this.shiftView.typeInOpeningBalance(shift);
                    if (nextProcess == 0 || nextProcess == -1) {
                        return null;
                    }
                case 2:
                    nextProcess = this.shiftView.typeInEmployeesOfThisShift(shift, employeeList);
                    if (nextProcess == 0) {
                        return null;
                    } else if (nextProcess == -1) {
                        n = 1;
                        break;
                    }
                case 3:
                    nextProcess = this.shiftView.typeInCashier(shift, employeeList);
                    n = 3;
                    break;
            }
        }
        return shift;
    }

    private void showorderHistory(Shift shift, HistoryController hisCtr) {
        if (shift.getOrderHisPerShift().isEmpty()) {
            System.out.println("Your current order history is empty!");
            return;
        }
        List<Shift> shiftList = new ArrayList<>();
        shiftList.add(shift);
        hisCtr.getHistoryView().showOrderHistory(new History(shiftList));
        hisCtr.getHistoryView().showOrderHistory(
                hisCtr.makeHisoryOrderGoodsList(shiftList));
    }

    private void showImportGoodsHistory(Shift shift, HistoryController hisCtr) {
        if (shift.getImportGoodsHis().getList().isEmpty()) {
            System.out.println("Your current import history is empty!");
            return;
        }
        List<Shift> shiftList = new ArrayList<>();
        shiftList.add(shift);
        hisCtr.getHistoryView().showImportGoodsHistory(new History(shiftList));
        hisCtr.getHistoryView().showImportGoodsHistory(
                hisCtr.makeHistoryImportGoodsList(shiftList));
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

}
