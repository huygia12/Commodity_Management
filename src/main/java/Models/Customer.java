/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Models;

/**
 *
 * @author s1rja
 */
public class Customer extends AbstractHuman {

    public Customer(){
    }
    
    public Customer(String firstName, String lastName, String phoneNumber, String address, int age, Gender gender) {
        this.address = address.trim();
        this.age = age;
        this.firstName = firstName.trim();
        this.lastName = lastName.trim();
        this.phoneNumber = phoneNumber.trim();
        this.gender = gender;
    }
    
    public Customer cloneCustomer() {
        Customer cus = new Customer();
        cus.setAddress(this.getAddress());
        cus.setAge(this.getAge());
        cus.setFirstName(this.getFirstName());
        cus.setLastName(this.getLastName());
        cus.setPhoneNumber(this.getPhoneNumber());
        cus.setGender(this.getGender());
        return cus;
    }
    
    public boolean equals(Customer anotherCustomer) {
        return this.address.equalsIgnoreCase(anotherCustomer.address)
                && (this.age == anotherCustomer.age)
                && this.gender.equals(anotherCustomer.gender)
                && this.getFirstName().equalsIgnoreCase(anotherCustomer.getFirstName())
                && this.getLastName().equalsIgnoreCase(anotherCustomer.getLastName())
                && this.getPhoneNumber().equalsIgnoreCase(anotherCustomer.getPhoneNumber());
    }
}
