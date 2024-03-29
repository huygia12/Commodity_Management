/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Models;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Stack;

/**
 *
 * @author FPTSHOP
 */
public class Shift {

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/MM/yyyy HH:mm:ss")
    private LocalDateTime openDateTime;
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/MM/yyyy HH:mm:ss")
    private LocalDateTime endDateTime;
    @SerializedName("openingBalance")
    @Expose
    private BigDecimal openingBalance = BigDecimal.ZERO;
    @SerializedName("surCharge")
    @Expose
    private BigDecimal surCharge = BigDecimal.ZERO;
    @SerializedName("cashier")
    @Expose
    private Employee cashier;
    @SerializedName("ID")
    @Expose
    private String ID;
    @SerializedName("VAT")
    @Expose
    private int VAT = 0;
    @SerializedName("orderHisPerShift")
    @Expose
    private Stack<Order> orderHisPerShift = new Stack<>();
    @SerializedName("employeeOfThisShift")
    @Expose
    private EmployeeList employeeOfThisShift = new EmployeeList(new Stack());
    @SerializedName("state")
    @Expose
    private ShiftState state = ShiftState.STAGED;
    @SerializedName("note")
    @Expose
    private String note;
    
    public Shift() {
    }

    public Shift(String ID, int VAT) {
        this.ID = ID.trim();
        this.VAT = VAT;
    }

    public Shift(String ID) {
        this.ID = ID.trim();
    }

    public void setTax(int VAT) {
        this.VAT = VAT;
    }

    public int getTax() {
        return this.VAT;
    }

    public Stack<Order> getOrderHisPerShift() {
        return this.orderHisPerShift;
    }

    public void setOrderHisPerShift(Stack<Order> orderHisPerShift) {
        this.orderHisPerShift = orderHisPerShift;
    }

    public LocalDateTime getOpenTime() {
        return this.openDateTime;
    }

    public void setOpenTime() {
        String current = LocalDateTime.now()
                .format(DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss"));
        this.openDateTime = LocalDateTime.parse(current,
                DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss"));
    }

    public LocalDateTime getEndTime() {
        return this.endDateTime;
    }

    public void setEndTime() {
        String current = LocalDateTime.now()
                .format(DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss"));
        this.endDateTime = LocalDateTime.parse(current,
                DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss"));
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

    public BigDecimal getSurcharge() {
        return this.surCharge;
    }

    public void setSurcharge(BigDecimal surCharge) {
        this.surCharge = surCharge;
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

    public ShiftState getState() {
        return state;
    }

    public void setState(ShiftState state) {
        this.state = state;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }
}
