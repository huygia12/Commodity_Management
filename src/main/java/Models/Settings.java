/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author FPTSHOP
 */
public class Settings {
    @SerializedName("myStore")
    @Expose
    private Store myStore = new Store();
    @SerializedName("amountForOnePoint")
    @Expose
    private BigDecimal amountForOnePoint = BigDecimal.ZERO;
    @SerializedName("pointsForOneVND")
    @Expose
    private BigInteger pointsForOneVND = BigInteger.ZERO;
    @SerializedName("priceAmountList")
    @Expose
    private List<String> priceAmountList = new ArrayList<>();
    
    public Settings() {
    }

    public Store getMyStore() {
        return myStore;
    }

    public void setMyStore(Store myStore) {
        this.myStore = myStore;
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

    public List<String> getPriceAmountList() {
        return priceAmountList;
    }

    public void setPriceAmountList(List<String> priceAmountList) {
        this.priceAmountList = priceAmountList;
    }
}
