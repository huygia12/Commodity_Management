/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.ArrayList;

/**
 *
 * @author FPTSHOP
 */
public class Shift {
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
    @SerializedName("cashier")
    @Expose
    private Employee cashier;
    @SerializedName("ID")
    @Expose
    private String ID;
    @SerializedName("VAT")
    @Expose
    private int VAT;
    @SerializedName("orderHisPerShift")
    @Expose
    private List<Order> orderHisPerShift = new ArrayList<>();
    @SerializedName("importGoodsHis")
    @Expose
    private GoodsList<ImportedGoods> importGoodsHis = new GoodsList<>();
    @SerializedName("employeeOfThisShift")
    @Expose
    private EmployeeList employeeOfThisShift = new EmployeeList(new ArrayList());
    
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

}
