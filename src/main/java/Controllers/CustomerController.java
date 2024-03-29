/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controllers;

import Models.Customer;

/**
 *
 * @author FPTSHOP
 */
public class CustomerController {

    public CustomerController() {
    }

    public Customer cloneCustomer(Customer customer) {
        Customer cus = new Customer();
        cus.setAddress(customer.getAddress());
        cus.setAge(customer.getAge());
        cus.setFirstName(customer.getFirstName());
        cus.setLastName(customer.getLastName());
        cus.setPhoneNumber(customer.getPhoneNumber());
        cus.setGender(customer.getGender());
        return cus;
    }
    
    public boolean equals(Customer customer, Customer anotherCustomer) {
        return customer.getAddress().equalsIgnoreCase(anotherCustomer.getAddress())
                && (customer.getAge() == anotherCustomer.getAge())
                && customer.getGender().equals(anotherCustomer.getGender())
                && customer.getFirstName().equalsIgnoreCase(anotherCustomer.getFirstName())
                && customer.getLastName().equalsIgnoreCase(anotherCustomer.getLastName())
                && customer.getPhoneNumber().equalsIgnoreCase(anotherCustomer.getPhoneNumber());
    }
}
