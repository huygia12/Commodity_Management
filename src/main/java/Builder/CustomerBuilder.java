/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Builder;

import Models.Customer;
import Models.Gender;

/**
 *
 * @author s1rja
 */
public class CustomerBuilder implements HumanBuilder {
    
    private String firstName;
    private String lastName;
    private String phoneNumber;
    private String address;
    private int age;
    private Gender gender;
    
    @Override
    public CustomerBuilder withFirstName(String firstName) {
        this.firstName = firstName;
        return this;
    }

    @Override
    public CustomerBuilder withLastName(String lastName) {
        this.lastName = lastName;
        return this;
    }

    @Override
    public CustomerBuilder withPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
        return this;
    }

    @Override
    public CustomerBuilder withAddress(String address) {
        this.address = address;
        return this;
    }

    @Override
    public CustomerBuilder withAge(int age) {
        this.age = age;
        return this;
    }

    @Override
    public CustomerBuilder withGender(Gender gender) {
        this.gender = gender;
        return this;
    }
    
    public Customer build() {
        return new Customer(firstName, lastName, address, age, phoneNumber, gender);
    }
    
}
