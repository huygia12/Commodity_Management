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
    
}
