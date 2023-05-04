/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controllers;

import Models.Customer;
import Models.CustomerCard;
import View.CustomerView;

/**
 *
 * @author FPTSHOP
 */
public class CustomerCardController {

    private final CustomerView customerView = new CustomerView();
    private Customer customer;
    private CustomerCard customerCard;

    public CustomerCardController() {
    }

    public CustomerCardController(Customer customer, CustomerCard customerCard) {
        this.customer = customer;
        this.customerCard = customerCard;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public CustomerCard getCustomerCard() {
        return customerCard;
    }

    public void setCustomerCard(CustomerCard customerCard) {
        this.customerCard = customerCard;
    }

    public CustomerView getCustomerView() {
        return customerView;
    }
    
}
