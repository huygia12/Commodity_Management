/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Models;

import View.ShiftView;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.Stack;

/**
 *
 * @author FPTSHOP
 */
public class Shift {


    final Scanner sc = new Scanner(System.in);
    private Stack<Order> orderHisPerShift = new Stack<>();
    private Stack<ImportedGoods> importGoodsHis = new Stack<>();
    private String openDateTime = null;
    private String endDateTime = null;
    private BigDecimal openingBalance = null;
    private BigDecimal shippingFee = null;
    private EmployeeList employeeOfThisShift;
    private Employee cashier;
    private String ID;
    private int VAT;

    public Shift() {
    }

    public Shift(String ID, int VAT) {
        this.ID = ID.trim();
        this.VAT = VAT;
    }

    public int getVAT() {
        return VAT;
    }

    public Stack<Order> getOrderHisPerShift() {
        return orderHisPerShift;
    }

    public Stack<ImportedGoods> getImportGoodsHis() {
        return importGoodsHis;
    }

    public void setOrderHisPerShift(Stack<Order> orderHisPerShift) {
        this.orderHisPerShift = orderHisPerShift;
    }

    public void setImportGoodsHis(Stack<ImportedGoods> importGoodsHis) {
        this.importGoodsHis = importGoodsHis;
    }

    public String getOpenTime() {
        return openDateTime;
    }

    public void setOpenTime() {
        this.openDateTime = LocalDateTime.now()
                .format(DateTimeFormatter.ofPattern("HH:mm:ss"));
    }

    public String getEndTime() {
        return endDateTime;
    }

    public void setEndTime() {
        this.endDateTime = LocalDateTime.now()
                .format(DateTimeFormatter.ofPattern("HH:mm:ss"));
    }

    public String getID() {
        return ID;
    }

    public void setID(String ID) {
        this.ID = ID.trim();
    }

    public BigDecimal getOpeningBalance() {
        return openingBalance;
    }

    public void setOpeningBalance(BigDecimal openingBalance) {
        this.openingBalance = openingBalance;
    }

    public BigDecimal getTransportFee() {
        return shippingFee;
    }

    public void setTransportFee(BigDecimal transportFee) {
        this.shippingFee = transportFee;
    }

    public EmployeeList getEmployeeOfThisShift() {
        return employeeOfThisShift;
    }

    public void setEmployeeOfThisShift(EmployeeList employeeList) {
        this.employeeOfThisShift = employeeList;
    }

    public Employee getCashier() {
        return cashier;
    }

    public void setCashier(Employee cashier) {
        this.cashier = cashier;
    }

    public BigDecimal getGrossRevenue() {
        BigDecimal result = BigDecimal.ZERO;
        for (Order order : this.orderHisPerShift) {
            result = result.add(order.getSubTotal());
        }
        return result;
    }

    public BigDecimal getNetRevenue() {
        BigDecimal result = BigDecimal.ZERO;
        for (Order order : this.orderHisPerShift) {
            result = result.add(order.getTotal());
        }
        return result;
    }

    public BigDecimal getTotalDiscountMoney() {
        BigDecimal result = BigDecimal.ZERO;
        for (Order order : orderHisPerShift) {
            result = result.add(order.getDiscountMoney());
        }
        return result;
    }

    public BigDecimal getTotalPaymentByCash() {
        BigDecimal result = BigDecimal.ZERO;
        for (Order order : orderHisPerShift) {
            if (order.getPaymentOptions().equals(PaymentOptions.Wire_Transfer_Payment)) {
                result = result.add(order.getTotal());
            }
        }
        return result;
    }

    public BigDecimal getTotalPaymentByWireTransfer() {
        BigDecimal result = BigDecimal.ZERO;
        for (Order order : orderHisPerShift) {
            if (order.getPaymentOptions().equals(PaymentOptions.Wire_Transfer_Payment)) {
                result = result.add(order.getTotal());
            }
        }
        return result;
    }

    public BigDecimal getTotalVAT() {
        BigDecimal result = BigDecimal.ZERO;
        for (Order order : orderHisPerShift) {
            result = result.add(order.getTaxFee());
        }
        return result;
    }

    public long getNumberOfOrder() {
        return orderHisPerShift.stream().count();
    }

    public BigDecimal getAveragePerOrder() {
        return this.getNetRevenue().divide(new BigDecimal(this.getNumberOfOrder()));
    }

    public BigDecimal getTotalGoodsQuanOfThisShift() {
        BigDecimal result = BigDecimal.ZERO;
        for (Order order : orderHisPerShift) {
            for (Goods goods : order.getGoodsList()) {
                result = result.add(goods.getTotalQuantity());
            }
        }
        return result;
    }

    public Map<String, StaticalItems> getStaticalList() {
        Map<String, StaticalItems> staticalList = new HashMap<>();
        for (Order order : orderHisPerShift) {
            for (Goods goods : order.getGoodsList()) {
                StaticalItems newStaticalItems = new StaticalItems();
                newStaticalItems.setName(goods.getGoodsName());
                newStaticalItems.setQuantity(goods.getTotalQuantity());
                newStaticalItems.setRevenue(goods.getListPrice()
                        .multiply(goods.getTotalQuantity()
                                .multiply(new BigDecimal(1.0 - order.getDiscount() * 1.0 / 100 + order.getVAT() * 1.0 / 100))));
                if (staticalList.containsKey(goods.getID())) {
                    BigDecimal quanBefore = staticalList.get(goods.getID()).getQuantity();
                    BigDecimal revenueBefore = staticalList.get(goods.getID()).getRevenue();
                    newStaticalItems.setQuantity(quanBefore.add(newStaticalItems.getQuantity()));
                    newStaticalItems.setQuantity(revenueBefore.add(newStaticalItems.getRevenue()));
                }
                staticalList.put(goods.getID(), newStaticalItems);
            }
        }
        BigDecimal totalQuan = this.getTotalGoodsQuanOfThisShift();
        for (Map.Entry<String, StaticalItems> entry : staticalList.entrySet()) {
            entry.getValue().setRatio(Double.parseDouble(entry
                    .getValue()
                    .getQuantity()
                    .divide(totalQuan) + ""));
        }
        return staticalList;
    }

    public void openShift(ShiftView shiftView, EmployeeList employeeList) {
        if (this.endDateTime != null) {
            shiftView.shiftNotEndCaution();
            return;
        }
        this.setOpenTime();
        int n = 1;
        int nextProcess;
        while (n != 3) {
            switch (n) {
                case 1:
                    nextProcess = shiftView.typeInOpeningBalance(this);
                    if (nextProcess == 0 || nextProcess == -1) {
                        return;
                    }
                    break;
                case 2:
                    nextProcess = shiftView.typeInEmployeesOfThisShift(this, employeeList);
                    if (nextProcess == 0) {
                        return;
                    } else if (nextProcess == -1) {
                        break;
                    }
                    break;
                case 3:
                    nextProcess = shiftView.typeInCashier(this);
                    break;
            }
        }
        this.openDateTime = LocalDateTime.now()
                .format(DateTimeFormatter.ofPattern("HH:mm:ss dd/MM/yyyy"));

    }

    public void modifyEmployeeOfThisShift(ShiftView shiftView, EmployeeList employeeList) {
        String choice;
        Employee e;
        do {
            shiftView.menuOfModifyEmployeeListOfThisShift();
            choice = sc.nextLine();
            switch (choice) {
                case "1":
                    e = employeeList.searchEmployee();
                    if (e != null) {
                        this.employeeOfThisShift.getList().add(e);
                    }
                    break;
                case "2":
                    e = this.employeeOfThisShift.searchEmployee();
                    if (e != null) {
                        this.employeeOfThisShift.getList().remove(e);
                    }
                    break;
                case "3":
                    this.employeeOfThisShift.getList().clear();
                    shiftView.typeInEmployeesOfThisShift(this, employeeList);
                    break;
                case "4":
                    System.out.println("Back...");
                    break;
                default:
                    System.out.println("Wrong input, Please type from 1->4!");
            }
        } while (!choice.equalsIgnoreCase("4"));
    }

    public void endShift(ShiftView shiftView, Store myStore) {
        if (this.openDateTime != null) {
            shiftView.shiftNotOpenCaution();
            return;
        }
        if (this.shippingFee != null) {
            shiftView.typeInShippingFee(this);
        }
        this.setEndTime();
        shiftView.printFileOfThisShiftOverView(myStore, this);
    }

}
