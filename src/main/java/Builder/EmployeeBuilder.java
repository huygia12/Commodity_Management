/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Builder;

import Models.Employee;
import Models.Gender;
import java.math.BigDecimal;

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
    private BigDecimal salaryPerDay;
    private String CCCD;
    
    public EmployeeBuilder(String lastName) {
        this.lastName = lastName;
    }
    
    public EmployeeBuilder withSalary (BigDecimal salary) {
        this.salaryPerDay = salary;
        return this;
    }

    @Override
    public EmployeeBuilder withFirstName(String firstName) {
        this.firstName = firstName;
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
        return new Employee(salaryPerDay, CCCD, firstName, lastName, phoneNumber, address, age, gender);
    }
}
