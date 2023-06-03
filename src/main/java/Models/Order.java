package Models;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

public class Order extends GoodsList<Goods> {

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/MM/yyyy hh:mm:ss")
    private LocalDateTime orderDateTime;
    @SerializedName("ID")
    @Expose
    private String ID;
    @SerializedName("VAT")
    @Expose
    private int tax = 0;
    @SerializedName("cusMoney")
    @Expose
    private BigDecimal cusMoney = BigDecimal.ZERO;
    @SerializedName("discount")
    @Expose
    private int discount = 0;
    @SerializedName("paymentOptions")
    @Expose
    private PaymentOptions paymentOptions;
    @SerializedName("customerCard")
    @Expose
    private CustomerCard customerCard;
    @SerializedName("pointDiscount")
    @Expose
    private BigInteger pointDiscount = BigInteger.ZERO;
    @SerializedName("cashier")
    @Expose 
    private Employee cashier;
    @SerializedName("shippingFee")
    @Expose 
    private BigDecimal shippingFee = BigDecimal.ZERO;
    
    public Order(String ID) {
        super(new ArrayList<>());
        this.ID = ID.trim();
    }

    public Order(LocalDateTime orderDateTime, String ID, PaymentOptions paymentOptions, CustomerCard customerCard, Employee cashier) {
        this.orderDateTime = orderDateTime;
        this.ID = ID;
        this.paymentOptions = paymentOptions;
        this.customerCard = customerCard;
        this.cashier = cashier;
    }

    public Order(LocalDateTime orderDateTime, String ID, PaymentOptions paymentOptions, CustomerCard customerCard, Employee cashier, List<Goods> goodsList) {
        super(goodsList);
        this.orderDateTime = orderDateTime;
        this.ID = ID;
        this.paymentOptions = paymentOptions;
        this.customerCard = customerCard;
        this.cashier = cashier;
    }

    public Order() {
        super(new ArrayList<>());
    }

    public int getTax() {
        return tax;
    }

    public void setTax(int tax){
        this.tax = tax;
    }
    
    public void setDiscount(int discount) {
        this.discount = discount;
    }

    public int getDiscount() {
        return this.discount;
    }

    public void setID(String ID) {
        this.ID = ID.trim();
    }

    public String getID() {
        return this.ID;
    }

    public LocalDateTime getOrderDateTime() {
        return this.orderDateTime;
    }

    public void setOrderDateTime(){
        String current = LocalDateTime.now()
                .format(DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss"));
        this.orderDateTime = LocalDateTime.parse(current, 
                DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss"));
    }
    
    public PaymentOptions getPaymentOptions() {
        return this.paymentOptions;
    }

    public BigInteger getPointDiscount() {
        return this.pointDiscount;
    }

    public void setPointDiscount(BigInteger pointDiscount) {
        this.pointDiscount = pointDiscount;
    }

    public void setPaymentOptions(PaymentOptions typeOfPayment) {
        this.paymentOptions = typeOfPayment;
    }

    public BigDecimal getCusMoney() {
        return this.cusMoney;
    }

    public void setCusMoney(BigDecimal customerMoney) {
        this.cusMoney = customerMoney;
    }

    public CustomerCard getCustomerCard() {
        return customerCard;
    }

    public void setCustomerCard(CustomerCard customerCard) {
        this.customerCard = customerCard;
    }

    public Employee getCashier() {
        return cashier;
    }

    public void setCashier(Employee cashier) {
        this.cashier = cashier;
    }

    public BigDecimal getShippingFee() {
        return shippingFee;
    }

    public void setShippingFee(BigDecimal shippingFee) {
        this.shippingFee = shippingFee;
    }
    
    
}
