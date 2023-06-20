/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author FPTSHOP
 */
public class CustomerCard {

    @SerializedName("ID")
    @Expose
    private String ID;
    @SerializedName("point")
    @Expose
    private BigInteger point = BigInteger.ZERO;
    @SerializedName("customer")
    @Expose
    private Customer customer = new Customer();
    @SerializedName("IDOfBoughtOrders")
    @Expose
    private List<String> IDOfBoughtOrders = new ArrayList<>();
    @SerializedName("rank")
    @Expose
    private CustomerRank rank = CustomerRank.NONE; 
            
    public CustomerCard() {
    }

    public CustomerCard(String ID, Customer customer) {
        this.ID = ID;
        this.customer = customer;
    }

    public String getID() {
        return ID;
    }

    public void setID(String ID) {
        this.ID = ID;
    }

    public BigInteger getPoint() {
        return point;
    }

    public void setPoint(BigInteger point) {
        this.point = point;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public List<String> getIDOfBoughtOrders() {
        return IDOfBoughtOrders;
    }

    public void setIDOfBoughtOrders(List<String> IDOfBoughtOrders) {
        this.IDOfBoughtOrders = IDOfBoughtOrders;
    }

    public CustomerRank getRank() {
        return rank;
    }

    public void setRank(CustomerRank rank) {
        this.rank = rank;
    }
    
    
}
