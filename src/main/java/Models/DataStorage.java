/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Models;

import Controllers.CustomerCardListController;
import Controllers.EmployeeListController;
import Controllers.HistoryController;
import Controllers.OrderController;
import Controllers.RepositoryController;
import Controllers.SettingsController;
import Controllers.ShiftController;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import java.util.ArrayList;
import java.util.HashMap;

/**
 *
 * @author FPTSHOP
 */
public class DataStorage {
    @SerializedName("idGenerator")
    @Expose
    private IDGenerator idGenerator = new IDGenerator(new HashMap<>());
    @SerializedName("shiftCtr")
    @Expose
    private ShiftController shiftCtr = new ShiftController();
    @SerializedName("employeeListCtr")
    @Expose
    private EmployeeListController employeeListCtr = new EmployeeListController();
    @SerializedName("customerCardListCtr")
    @Expose
    private CustomerCardListController customerCardListCtr = new CustomerCardListController(new CustomerCardList(new ArrayList<>()));
    @SerializedName("settingsCtr")
    @Expose
    private SettingsController settingsCtr = new SettingsController(new Store());
    @SerializedName("repoCtr")
    @Expose
    private RepositoryController repoCtr = new RepositoryController(new Repository(new ArrayList<>()));
    @SerializedName("hisCtr")
    @Expose
    private HistoryController hisCtr = new HistoryController(new History());
    @SerializedName("orderCtr")
    @Expose
    private OrderController orderCtr = new OrderController();
    
    public DataStorage() {
    }

    public IDGenerator getIdGenerator() {
        return idGenerator;
    }

    public void setIdGenerator(IDGenerator idGenerator) {
        this.idGenerator = idGenerator;
    }

    public ShiftController getShiftCtr() {
        return shiftCtr;
    }

    public void setShiftCtr(ShiftController shiftCtr) {
        this.shiftCtr = shiftCtr;
    }

    public EmployeeListController getEmployeeListCtr() {
        return employeeListCtr;
    }

    public void setEmployeeListCtr(EmployeeListController employeeListCtr) {
        this.employeeListCtr = employeeListCtr;
    }

    public CustomerCardListController getCustomerCardListCtr() {
        return customerCardListCtr;
    }

    public void setCustomerCardListCtr(CustomerCardListController customerCardListCtr) {
        this.customerCardListCtr = customerCardListCtr;
    }

    public SettingsController getSettingsCtr() {
        return settingsCtr;
    }

    public void setSettingsCtr(SettingsController settingsCtr) {
        this.settingsCtr = settingsCtr;
    }

    public RepositoryController getRepoCtr() {
        return repoCtr;
    }

    public void setRepoCtr(RepositoryController repoCtr) {
        this.repoCtr = repoCtr;
    }

    public HistoryController getHisCtr() {
        return hisCtr;
    }

    public void setHisCtr(HistoryController hisCtr) {
        this.hisCtr = hisCtr;
    }

    public OrderController getOrderCtr() {
        return orderCtr;
    }

    public void setOrderCtr(OrderController orderCtr) {
        this.orderCtr = orderCtr;
    }
    
}
