/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Models;

import java.math.BigDecimal;

/**
 *
 * @author s1rja
 */
public class Employee extends AbstractHuman {

    private BigDecimal salaryPerDay = BigDecimal.ZERO;
    private String CCCD;

    public Employee() {
    }

    public Employee(BigDecimal salaryPerDay, String CCCD,String firstName, String lastName, String phoneNumber, String address, int age, Gender gender) {
        this.address = address;
        this.age = age;
        this.firstName = firstName;
        this.lastName = lastName;
        this.phoneNumber = phoneNumber;
        this.gender = gender;
        this.salaryPerDay = salaryPerDay;
        this.CCCD = CCCD;
    }

    
    public BigDecimal getSalaryPerDay() {
        return salaryPerDay;
    }

    public String getCCCD() {
        return CCCD;
    }

    public void setSalaryPerDay(BigDecimal salary) {
        this.salaryPerDay = salary;
    }

    public void setCCCD(String CCCD) {
        this.CCCD = CCCD.trim();
    }

    
    
    public Employee cloneEmployee() {
        Employee e = new Employee();
        e.setAddress(this.getAddress());
        e.setAge(this.getAge());
        e.setCCCD(this.getCCCD());
        e.setFirstName(this.getFirstName());
        e.setLastName(this.getLastName());
        e.setPhoneNumber(this.getPhoneNumber());
        e.setSalaryPerDay(this.getSalaryPerDay());
        e.setGender(this.getGender());
        return e;
    }
    
    public boolean equals(Employee anotherEmployee) {
        return this.CCCD.equalsIgnoreCase(anotherEmployee.CCCD)
                && this.address.equalsIgnoreCase(anotherEmployee.address)
                && (this.age == anotherEmployee.age)
                && this.gender.equals(anotherEmployee.gender)
                && this.getFirstName().equalsIgnoreCase(anotherEmployee.getFirstName())
                && this.getLastName().equalsIgnoreCase(anotherEmployee.getLastName())
                && this.getPhoneNumber().equalsIgnoreCase(anotherEmployee.getPhoneNumber())
                && (this.getSalaryPerDay().compareTo(anotherEmployee.getSalaryPerDay()) == 0);
    }
}
