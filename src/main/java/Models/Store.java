/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

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
}
