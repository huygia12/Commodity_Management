/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Models;

import View.SettingsView;
import java.util.Scanner;

/**
 *
 * @author FPTSHOP
 */
public class Store {

    final Scanner sc = new Scanner(System.in);
    private String name = "";
    private String email = "";
    private String address = "";
    private int VAT = 0;
    private String phoneNumber = "";

    public Store(String name, String email, String address, int VAT, String phoneNumber) {
        this.name = name.trim();
        this.email = email.trim();
        this.address = address.trim();
        this.VAT = VAT;
        this.phoneNumber = phoneNumber.trim();
    }

    public Store() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name.trim();
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email.trim();
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address.trim();
    }

    public int getVAT() {
        return VAT;
    }

    public void setVAT(int VAT) {
        this.VAT = VAT;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber.trim();
    }

    public void showStoreInfor() {
        System.out.println("");
        System.out.println(String.format("%20s" + " | " + "%-20s", "STORE NAME", this.name));
        System.out.println(String.format("%20s" + " | " + "%-20s", "EMAIL", this.email));
        System.out.println(String.format("%20s" + " | " + "%-20s", "ADDRESS", this.address));
        System.out.println(String.format("%20s" + " | " + "%-20s", "PHONE NUMBER", this.phoneNumber));
        System.out.println(String.format("%20s" + " | " + "%-20s", "VAT", this.VAT + "%"));
        System.out.println("     (VAT is applied to all products)");
        System.out.println("");
    }

    public void setStoreInfor(SettingsView settingsView, Shift currentShift) {
        String choice;
        do {
            settingsView.menuOfChangeStoreInfor();
            choice = sc.nextLine();
            switch (choice) {
                case "1":
                    if (settingsView.typeInStoreName(this) == 0) {
                        return;
                    }
                    break;
                case "2":
                    if (settingsView.typeInEmail(this) == 0) {
                        return;
                    }
                    break;
                case "3":
                    if (settingsView.typeInAndress(this) == 0) {
                        return;
                    }
                    break;
                case "4":
                    if (settingsView.typeInPhoneNumber(this) == 0) {
                        return;
                    }
                    break;
                case "5":
                    if(currentShift != null){
                        System.out.println("This current Shift is not over yet, change cannot be performed!");
                        break;
                    }
                    if (settingsView.typeInVAT(this) == 0) {
                        return;
                    }
                    break;
                case "6":
                    break;
                default:
                    System.out.println("Wrong input, Please type from 1->6!");
                    break;
            }
        } while (!choice.equalsIgnoreCase("6"));
    }
}
