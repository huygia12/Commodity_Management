/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Models;

import View.ShiftView;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.HashMap;
import java.util.List;
import java.util.ArrayList;
import java.util.Map;
import java.util.Scanner;

/**
 *
 * @author FPTSHOP
 */
public class Shift {
    @SerializedName("orderHisPerShift")
    @Expose
    private List<Order> orderHisPerShift = new ArrayList<>();
    @SerializedName("importGoodsHis")
    @Expose
    private GoodsList<ImportedGoods> importGoodsHis = new GoodsList<>();
    @SerializedName("openDateTime")
    @Expose
    private String openDateTime = null;
    @SerializedName("endDateTime")
    @Expose
    private String endDateTime = null;
    @SerializedName("openingBalance")
    @Expose
    private BigDecimal openingBalance = BigDecimal.ZERO;
    @SerializedName("shippingFee")
    @Expose
    private BigDecimal shippingFee = BigDecimal.ZERO;
    @SerializedName("employeeOfThisShift")
    @Expose
    private EmployeeList employeeOfThisShift = new EmployeeList(new ArrayList());
    @SerializedName("cashier")
    @Expose
    private Employee cashier;
    @SerializedName("ID")
    @Expose
    private String ID;
    @SerializedName("VAT")
    @Expose
    private int VAT;

    public Shift() {
    }

    public Shift(String ID, int VAT) {
        this.ID = ID.trim();
        this.VAT = VAT;
    }

    public void setVAT(int VAT) {
        this.VAT = VAT;
    }

    public int getVAT() {
        return this.VAT;
    }

    public List<Order> getOrderHisPerShift() {
        return this.orderHisPerShift;
    }

    public GoodsList<ImportedGoods> getImportGoodsHis() {
        return this.importGoodsHis;
    }

    public void setOrderHisPerShift(List<Order> orderHisPerShift) {
        this.orderHisPerShift = orderHisPerShift;
    }

    public void setImportGoodsHis(GoodsList<ImportedGoods> importGoodsHis) {
        this.importGoodsHis = importGoodsHis;
    }

    public String getOpenTime() {
        return this.openDateTime;
    }

    public void setOpenTime() {
        this.openDateTime = LocalDateTime.now()
                .format(DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss"));
    }

    public String getEndTime() {
        return this.endDateTime;
    }

    public void setEndTime() {
        this.endDateTime = LocalDateTime.now()
                .format(DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss"));
    }

    public String getID() {
        return this.ID;
    }

    public void setID(String ID) {
        this.ID = ID.trim();
    }

    public BigDecimal getOpeningBalance() {
        return this.openingBalance;
    }

    public void setOpeningBalance(BigDecimal openingBalance) {
        this.openingBalance = openingBalance;
    }

    public BigDecimal getTransportFee() {
        return this.shippingFee;
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
        for (Order order : this.orderHisPerShift) {
            result = result.add(order.getDiscountMoney());
        }
        return result;
    }

    public BigDecimal getTotalPaymentByCash() {
        BigDecimal result = BigDecimal.ZERO;
        for (Order order : this.orderHisPerShift) {
            if (order.getPaymentOptions().equals(PaymentOptions.Cash_Payment)) {
                result = result.add(order.getTotal());
            }
        }
        return result;
    }

    public BigDecimal getTotalPaymentByWireTransfer() {
        BigDecimal result = BigDecimal.ZERO;
        for (Order order : this.orderHisPerShift) {
            if (order.getPaymentOptions().equals(PaymentOptions.Wire_Transfer_Payment)) {
                result = result.add(order.getTotal());
            }
        }
        return result;
    }

    public BigDecimal getTotalVAT() {
        BigDecimal result = BigDecimal.ZERO;
        for (Order order : this.orderHisPerShift) {
            result = result.add(order.getTaxFee());
        }
        return result;
    }

    public BigDecimal getTotalPointDiscount() {
        BigDecimal result = BigDecimal.ZERO;
        for (Order order : this.orderHisPerShift) {
            result = result.add(order.getPointDiscount());
        }
        return result;
    }

    public long getNumberOfOrder() {
        return this.orderHisPerShift.stream().count();
    }

    public BigDecimal getAveragePerOrder() {
        if (this.getNumberOfOrder() == 0) {
            return BigDecimal.ZERO;
        }
        return this.getNetRevenue().divide(new BigDecimal(this.getNumberOfOrder()));
    }

    public BigDecimal getTotalGoodsQuanOfThisShift() {
        BigDecimal result = BigDecimal.ZERO;
        for (Order order : this.orderHisPerShift) {
            for (Goods goods : order.getGoodsList()) {
                result = result.add(goods.getTotalQuanByShipments());
            }
        }
        return result;
    }

    public Map<String, StaticalItems> getStaticalList() {
        // Tao danh sach consumptions de thong ke sanpham/soluongBan/SoTienThuDuoc/phanTram 
        // cua tat ca san pham trong 1 ca lam viec
        Map<String, StaticalItems> consumptions = new HashMap<>();
        for (Order order : this.orderHisPerShift) {
            for (Goods goods : order.getGoodsList()) {
                StaticalItems newStaticalItems = new StaticalItems();
                newStaticalItems.setName(goods.getGoodsName());
                newStaticalItems.setQuantity(goods.getTotalQuanByShipments());
                newStaticalItems.setRevenue((goods.getListPrice().add(goods.getVATMoneyPerGoods(order.getVAT())))
                        .multiply(goods.getTotalQuanByShipments()
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
        BigDecimal totalQuan = this.getTotalGoodsQuanOfThisShift();
        for (Map.Entry<String, StaticalItems> entry : consumptions.entrySet()) {
            entry.getValue().setRatio(Double.parseDouble(entry
                    .getValue()
                    .getQuantity()
                    .divide(totalQuan) + ""));
        }
        return consumptions;
    }

    public boolean openShift(ShiftView shiftView, EmployeeList employeeList, IDGenerator iDGenerator, Store myStore, Scanner sc) {
        this.setOpenTime();
        this.setID(iDGenerator.generateID(Shift.class.getName(), 6));
        this.setVAT(myStore.getVAT());
        int n = 1;
        int nextProcess;
        while (n != 3) {
            switch (n) {
                case 1:
                    nextProcess = shiftView.typeInOpeningBalance(this, sc);
                    if (nextProcess == 0 || nextProcess == -1) {
                        return false;
                    }
                case 2:
                    nextProcess = shiftView.typeInEmployeesOfThisShift(this, employeeList, sc);
                    if (nextProcess == 0) {
                        return false;
                    } else if (nextProcess == -1) {
                        break;
                    }
                case 3:
                    nextProcess = shiftView.typeInCashier(this, this.getEmployeeOfThisShift(), sc);
                    n = 3;
                    break;
            }
        }
        return true;
    }

    private void deleteEmployeeFromShift(ShiftView shiftView, EmployeeList employeeList, Scanner sc) {
        Employee e = this.employeeOfThisShift.searchEmployee(sc);
        if (e != null) {
            boolean checkRemoving = true;
            if (e.getCCCD().equalsIgnoreCase(cashier.getCCCD())) {
                if (shiftView.removeEmployeeCaution(this, sc)) {
                    int check = -1;
                    while (check == -1) {
                        check = shiftView.typeInCashier(this, employeeList, sc);
                    }
                }
                checkRemoving = false;
            }
            if (checkRemoving) {
                this.employeeOfThisShift.getList().remove(e);
            }
        }
    }

    private void retypeEmployeeListOfThisShift(ShiftView shiftView, EmployeeList employeeList, Scanner sc) {
        this.employeeOfThisShift.getList().clear();
        System.out.println("EmployeeList clear!");
        int check = -1;
        while(check == -1 || check == 0){
            check = shiftView.typeInEmployeesOfThisShift(this, employeeList, sc);
        }
        while(check == -1){
            check = shiftView.typeInCashier(this, employeeList, sc);
        }
    }

    public void modifyEmployeeOfThisShift(ShiftView shiftView, EmployeeList employeeList, Scanner sc) {
        String choice;
        Employee e;
        do {
            shiftView.menuOfModifyEmployeeListOfThisShift();
            choice = sc.nextLine();
            switch (choice) {
                case "1":
                    e = employeeList.searchEmployee(sc);
                    if (e != null) {
                        this.employeeOfThisShift.getList().add(e);
                    }
                    break;
                case "2":
                    deleteEmployeeFromShift(shiftView, employeeList, sc);
                    break;
                case "3":
                    retypeEmployeeListOfThisShift(shiftView, employeeList, sc);
                    break;
                case "4":
                    System.out.println("Back...");
                    break;
                default:
                    System.out.println("Wrong input, Please type from 1->4!");
            }
        } while (!choice.equalsIgnoreCase("4"));
    }

    public boolean endShift(ShiftView shiftView, Store myStore, Scanner sc) {
        if (this.shippingFee == BigDecimal.ZERO) {
            if(shiftView.typeInShippingFee(this, sc)!=1){
                return false;
            }
        }
        this.setEndTime();
        shiftView.printFileOfThisShiftOverView(myStore, this);
        return true;
    }

}
