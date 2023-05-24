package Models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

public class Order extends GoodsList<Goods> {

    @SerializedName("orderDate")
    @Expose
    private final String orderDate;
    @SerializedName("ID")
    @Expose
    private String ID;
    @SerializedName("VAT")
    @Expose
    private int VAT = 0;
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
    private Employee cashier = new Employee();
    @SerializedName("shippingFee")
    @Expose 
    private BigDecimal shippingFee = BigDecimal.ZERO;
    
    public Order(String ID, int VAT) {
        super(new ArrayList<>());
        this.ID = ID.trim();
        this.VAT = VAT;
        this.orderDate = LocalDateTime
                .now()
                .format(DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss"));
    }

    public Order() {
        super(new ArrayList<>());
        this.orderDate = LocalDateTime
                .now()
                .format(DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss"));
    }

    public int getVAT() {
        return VAT;
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

    public String getOrderDateTime() {
        return this.orderDate;
    }

    public PaymentOptions getPaymentOptions() {
        return this.paymentOptions;
    }

    public BigInteger getPointDiscount() {
        return pointDiscount;
    }

    public void setPointDiscount(BigInteger pointDiscount) {
        this.pointDiscount = pointDiscount;
    }

    public void setPaymentOptions(int option) {
        if (option == 1) {
            this.paymentOptions = PaymentOptions.Cash_Payment;
        } else {
            this.paymentOptions = PaymentOptions.Wire_Transfer_Payment;
        }
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
