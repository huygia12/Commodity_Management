/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Models;

/**
 *
 * @author s1rja
 */
public class Employee extends AbstractHuman {
    
    private int salary;
    private String CCCD;

    public Employee(){
    }
    
    public Employee(String firstName, String lastName, Gender gender, int age, String phoneNumber, String CCCD, int salary, String address) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.address = address;
        this.gender = gender;
        this.age = age;
        this.phoneNumber = phoneNumber;
        this.CCCD = CCCD;
        this.salary = salary;
    }

    public int getSalary() {
        return salary;
    }

    public String getCCCD() {
        return CCCD;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public String getAddress() {
        return address;
    }

    public int getAge() {
        return age;
    }

    public Gender getGender() {
        return gender;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }

    public void setCCCD(String CCCD) {
        this.CCCD = CCCD;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void setGender(Gender gender) {
        this.gender = gender;
    }

}
