/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import java.math.BigDecimal;
import java.math.BigInteger;

/**
 *
 * @author FPTSHOP
 */
public class Store {
    @SerializedName("name")
    @Expose
    private String name = "";
    @SerializedName("email")
    @Expose
    private String email = "";
    @SerializedName("address")
    @Expose
    private String address = "";
    @SerializedName("VAT")
    @Expose
    private int VAT = 0;
    @SerializedName("phoneNumber")
    @Expose
    private String phoneNumber = "";
    @SerializedName("amountForOnePoint")
    @Expose
    private BigDecimal amountForOnePoint = BigDecimal.ZERO;
    @SerializedName("pointsForOneVNDOut")
    @Expose
    private BigInteger pointsForOneVNDOut = BigInteger.ZERO;
    @SerializedName("pointsForOneVNDIn")
    @Expose
    private BigInteger pointsForOneVNDIn = BigInteger.ZERO;
    public Store(String name, String email, String address, int VAT, String phoneNumber) {
        this.name = name.trim();
        this.email = email.trim();
        this.address = address.trim();
        this.VAT = VAT;
        this.phoneNumber = phoneNumber.trim();
    }

    public Store() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name.trim();
    }
    
    public BigDecimal getAmountForOnePoint() {
        return amountForOnePoint;
    }

    public void setAmountForOnePoint(BigDecimal amountForOnePoint) {
        this.amountForOnePoint = amountForOnePoint;
    }

    public BigInteger getPointsForOneVNDIn() {
        return pointsForOneVNDIn;
    }

    public void setPointsForOneVNDIn(BigInteger pointsForOneVNDIn) {
        this.pointsForOneVNDIn = pointsForOneVNDIn;
    }

    public BigInteger getPointsForOneVNDOut() {
        return pointsForOneVNDOut;
    }

    public void setPointsForOneVNDOut(BigInteger pointsForOneVNDOut) {
        this.pointsForOneVNDOut = pointsForOneVNDOut;
    }
    
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email.trim();
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address.trim();
    }

    public int getVAT() {
        return VAT;
    }

    public void setVAT(int VAT) {
        this.VAT = VAT;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber.trim();
    }
}
