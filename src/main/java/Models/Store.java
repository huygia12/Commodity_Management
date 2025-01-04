/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Models;

import Ultility.IDGenerator;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 *
 * @author FPTSHOP
 */
public class Store {
    @SerializedName("id")
    @Expose
    private String ID;
    @SerializedName("name")
    @Expose
    private String name = "";
    @SerializedName("email")
    @Expose
    private String email = "";
    @SerializedName("passWord")
    @Expose
    private String passWord = "";
    @SerializedName("address")
    @Expose
    private String address = "";
    @SerializedName("phoneNumber")
    @Expose
    private String phoneNumber = "";
    @SerializedName("shift")
    @Expose
    private Shift shift = new Shift();
    @SerializedName("employeeList")
    @Expose
    private EmployeeList employeeList = new EmployeeList();
    @SerializedName("history")
    @Expose
    private History history = new History();
    @SerializedName("iDGenerator")
    @Expose
    private IDGenerator iDGenerator = new IDGenerator();
    @SerializedName("settings")
    @Expose
    private Settings settings = new Settings();
    @SerializedName("repository")
    @Expose
    private Repository repository = new Repository();
    @SerializedName("units")
    @Expose
    private Units units = new Units();
    
    public Store(String name, String email, String address, String phoneNumber) {
        this.name = name.trim();
        this.email = email.trim();
        this.address = address.trim();
        this.phoneNumber = phoneNumber.trim();
    }

    public Store() {
    }

    public String getID() {
        return ID;
    }

    public void setID(String ID) {
        this.ID = ID;
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

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber.trim();
    }

    public Shift getShift() {
        return shift;
    }

    public void setShift(Shift shift) {
        this.shift = shift;
    }

    public String getPassWord() {
        return passWord;
    }

    public void setPassWord(String passWord) {
        this.passWord = passWord;
    }


    public EmployeeList getEmployeeList() {
        return employeeList;
    }

    public void setEmployeeList(EmployeeList employeeList) {
        this.employeeList = employeeList;
    }

    public History getHistory() {
        return history;
    }

    public void setHistory(History history) {
        this.history = history;
    }

    public IDGenerator getiDGenerator() {
        return iDGenerator;
    }

    public void setiDGenerator(IDGenerator iDGenerator) {
        this.iDGenerator = iDGenerator;
    }

    public Settings getSettings() {
        return settings;
    }

    public void setSettings(Settings settings) {
        this.settings = settings;
    }

    public Repository getRepository() {
        return repository;
    }

    public void setRepository(Repository repository) {
        this.repository = repository;
    }

    public Units getUnits() {
        return units;
    }

    public void setUnits(Units units) {
        this.units = units;
    }

    
}
