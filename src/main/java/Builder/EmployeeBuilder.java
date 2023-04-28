/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Builder;

import Models.Employee;
import Models.Gender;

/**
 *
 * @author s1rja
 */
public class EmployeeBuilder implements HumanBuilder {
    
    private String firstName;
    private String lastName;
    private String phoneNumber;
    private String address;
    private int age;
    private Gender gender;
    private int salary;
    private String CCCD;
    
    public EmployeeBuilder withSalary (int salary) {
        this.salary = salary;
        return this;
    }

    @Override
    public EmployeeBuilder withFirstName(String firstName) {
        this.firstName = firstName;
        return this;
    }

    @Override
    public EmployeeBuilder withLastName(String lastName) {
        this.lastName = lastName;
        return this;
    }

    @Override
    public EmployeeBuilder withPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
        return this;
    }

    @Override
    public EmployeeBuilder withAddress(String address) {
        this.address = address;
        return this;
    }

    @Override
    public EmployeeBuilder withAge(int age) {
        this.age = age;
        return this;
    }

    @Override
    public EmployeeBuilder withGender(Gender gender) {
        this.gender = gender;
        return this;
    }
    
    public EmployeeBuilder withCCCD (String CCCD) {
        this.CCCD = CCCD;
        return this;
    }
    
    public Employee build () {
        return new Employee(firstName, lastName, gender, age, phoneNumber, CCCD, salary, address);
    }
}
