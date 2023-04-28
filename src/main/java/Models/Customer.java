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
    
    public Customer(String firstName, String lastName, String address, int age, String phoneNumber, Gender gender) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.address = address;
        this.age = age;
        this.phoneNumber = phoneNumber;
        this.gender = gender;
    }
    
}
