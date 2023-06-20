/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Models;

import Ultility.CustomPair;
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
    private BigDecimal amountForOnePoint = BigDecimal.ONE;
    @SerializedName("pointsForOneVND")
    @Expose
    private BigInteger pointsForOneVND = BigInteger.ONE;
    @SerializedName("bronzeDiscountOffer")
    @Expose
    private CustomPair<BigDecimal, Double> bronzeDiscountOffer = new CustomPair(BigDecimal.ZERO, 0f);
    @SerializedName("silverDiscountOffer")
    @Expose
    private CustomPair<BigDecimal, Double> silverDiscountOffer = new CustomPair(BigDecimal.ZERO, 0f);
    @SerializedName("goldDiscountOffer")
    @Expose
    private CustomPair<BigDecimal, Double> goldDiscountOffer = new CustomPair(BigDecimal.ZERO, 0f);
    @SerializedName("diamondDiscountOffer")
    @Expose
    private CustomPair<BigDecimal, Double> diamondDiscountOffer = new CustomPair(BigDecimal.ZERO, 0f);
    
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
    
    public BigDecimal getAmountForOnePoint() {
        return amountForOnePoint;
    }

    public void setAmountForOnePoint(BigDecimal amountForOnePoint) {
        this.amountForOnePoint = amountForOnePoint;
    }

    public BigInteger getPointsForOneVND() {
        return pointsForOneVND;
    }

    public void setPointsForOneVND(BigInteger pointsForOneVND) {
        this.pointsForOneVND = pointsForOneVND;
    }

    public CustomPair<BigDecimal, Double> getBronzeDiscountOffer() {
        return bronzeDiscountOffer;
    }

    public void setBronzeDiscountOffer(CustomPair<BigDecimal, Double> bronzeDiscountOffer) {
        this.bronzeDiscountOffer = bronzeDiscountOffer;
    }

    public CustomPair<BigDecimal, Double> getSilverDiscountOffer() {
        return silverDiscountOffer;
    }

    public void setSilverDiscountOffer(CustomPair<BigDecimal, Double> silverDiscountOffer) {
        this.silverDiscountOffer = silverDiscountOffer;
    }

    public CustomPair<BigDecimal, Double> getGoldDiscountOffer() {
        return goldDiscountOffer;
    }

    public void setGoldDiscountOffer(CustomPair<BigDecimal, Double> goldDiscountOffer) {
        this.goldDiscountOffer = goldDiscountOffer;
    }

    public CustomPair<BigDecimal, Double> getDiamondDiscountOffer() {
        return diamondDiscountOffer;
    }

    public void setDiamondDiscountOffer(CustomPair<BigDecimal, Double> diamondDiscountOffer) {
        this.diamondDiscountOffer = diamondDiscountOffer;
    }

    
}
