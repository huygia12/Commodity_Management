/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author s1rja
 */
public class Employee extends AbstractHuman {

    @SerializedName("salaryPerDay")
    @Expose
    private BigDecimal salaryPerDay = BigDecimal.ZERO;
    @SerializedName("CCCD")
    @Expose
    private String CCCD;
    @SerializedName("IDOfOrdersInCharge")
    @Expose
    private List<String> IDOfOrdersInCharge = new ArrayList<>();
    private int stt;

    public Employee() {
    }

    public Employee(BigDecimal salaryPerDay, String CCCD, String firstName, String lastName, String phoneNumber, String address, int age, Gender gender) {
        this.address = address;
        this.age = age;
        this.firstName = firstName;
        this.lastName = lastName;
        this.phoneNumber = phoneNumber;
        this.gender = gender;
        this.salaryPerDay = salaryPerDay;
        this.CCCD = CCCD;
    }

    public Employee(int stt, String firstName, String lastName, int age, String address, String cccd, String phone, double salary, String gender) {
        this.stt = stt;
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
        this.address = address;
        this.CCCD = cccd;
        this.phoneNumber = phone;
        this.salaryPerDay = BigDecimal.valueOf(salary);
        this.gender = Gender.valueOf(gender.toUpperCase());
    }

    public Employee(String firstName, String lastName, int age, String address, String cccd, String phone, double salary, String gender) {

        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
        this.address = address;
        this.CCCD = cccd;
        this.phoneNumber = phone;
        this.salaryPerDay = BigDecimal.valueOf(salary);
        this.gender = Gender.valueOf(gender.toUpperCase());
    }
      public Employee(String firstName, String lastName, int age, String address, String cccd, String phone, BigDecimal  salary, String gender) {

        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
        this.address = address;
        this.CCCD = cccd;
        this.phoneNumber = phone;
        this.salaryPerDay =salary;
        this.gender = Gender.valueOf(gender.toUpperCase());
    }


    public int getStt() {

        return stt;
    }

    public void setStt(int stt) {
        this.stt = stt;
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

    public List<String> getIDOfOrdersInCharge() {
        return IDOfOrdersInCharge;
    }

    public void setIDOfOrdersInCharge(List<String> IDOfOrdersInCharge) {
        this.IDOfOrdersInCharge = IDOfOrdersInCharge;
    }

    @Override
    public String toString() {
        return this.lastName + "-" + this.phoneNumber;
    }

}
