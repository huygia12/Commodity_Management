/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package View;

import Models.CustomerCard;
import Models.CustomerCardList;

/**
 *
 * @author FPTSHOP
 */
public class CustomerCardListView {
    private int pointMaxSize;
    private int IDMaxSize;
    private int firstNameMaxSize;
    private int lastNameMaxSize;
    private int phoneNumberMaxSize;
    private int addressMaxSize;
    
    public void menuOfcustomerCardListManagement() {
        System.out.print("""
                           \n*******CUSTOMER_CARD_MANAGEMENT********
                           * 1. New customer card generate       *
                           * 2. Change card Information          *
                           * 3. Delete a card                    *
                           * 4. Search a card                    *
                           * 5. Show all card & details          *
                           * 6. Back                             *
                           ***************************************
                           Options =>  """);
    }

    public void menuOfEditCustomerCardInfor() {
        System.out.print("""
                           \n*********CHANGE_CARD_INFOR***********
                           * 1. Change Customer first Name     *
                           * 2. Change Customer last Name      *
                           * 3. Change Customer phone number   *
                           * 4. Change Customer age            *
                           * 5. Change Customer gender         *
                           * 6. Change Customer address        *
                           * 7. Back                           *
                           *************************************
                           Options => """);
    }

    private void computeSizeOfEachCol(CustomerCardList customerCardList) {
        pointMaxSize = "Point".length();
        IDMaxSize = "ID".length();
        firstNameMaxSize = "First Name".length();
        lastNameMaxSize = "Last Name".length();
        phoneNumberMaxSize = "Phone Number".length();
        addressMaxSize = "Address".length();
        for (CustomerCard customerCard : customerCardList.getList()) {
            if ((customerCard.getPoint() + "").length() > pointMaxSize) {
                pointMaxSize = (customerCard.getPoint() + "").length();
            }
            if (customerCard.getID().length() > IDMaxSize) {
                IDMaxSize = customerCard.getID().length();
            }
            if (customerCard.getCustomer().getFirstName().length() > firstNameMaxSize) {
                firstNameMaxSize = customerCard.getCustomer().getFirstName().length();
            }
            if (customerCard.getCustomer().getLastName().length() > lastNameMaxSize) {
                lastNameMaxSize = customerCard.getCustomer().getLastName().length();
            }
            if (customerCard.getCustomer().getPhoneNumber().length() > phoneNumberMaxSize) {
                phoneNumberMaxSize = customerCard.getCustomer().getPhoneNumber().length();
            }
            if (customerCard.getCustomer().getAddress().length() > addressMaxSize) {
                addressMaxSize = customerCard.getCustomer().getAddress().length();
            }
        }
    } 

    public void showList(CustomerCardList customerCardList) {
        if (customerCardList.getList().isEmpty()) {
            System.out.println("Nothing found in this List!");
            return;
        }
        computeSizeOfEachCol(customerCardList);
        int totalColSize = pointMaxSize + IDMaxSize + firstNameMaxSize
                + lastNameMaxSize + phoneNumberMaxSize + addressMaxSize + 3 + 6;
        final int extraLengthOfBorder = 23;
        int borderLength = totalColSize + extraLengthOfBorder;
        System.out.println("|" + "-".repeat(borderLength) + "|");
        System.out.printf("| %-" + String.format(IDMaxSize + "s")
                + " | %-" + String.format(firstNameMaxSize + "s")
                + " | %-" + String.format(lastNameMaxSize + "s")
                + " | %-" + String.format(phoneNumberMaxSize + "s")
                + " | %-" + String.format(3 + "s")
                + " | %-" + String.format(6 + "s")
                + " | %-" + String.format(addressMaxSize + "s")
                + " | %-" + String.format(pointMaxSize + "s") + " |\n",
                "ID",
                "First Name",
                "Last Name",
                "Phone Number",
                "Age",
                "Gender",
                "Address",
                "Point");
        System.out.println("|" + "-".repeat(borderLength) + "|");
        for (CustomerCard customerCard : customerCardList.getList()) {
            System.out.printf("| %-" + String.format(IDMaxSize + "s")
                    + " | %-" + String.format(firstNameMaxSize + "s")
                    + " | %-" + String.format(lastNameMaxSize + "s")
                    + " | %-" + String.format(phoneNumberMaxSize + "s")
                    + " | %-" + String.format(3 + "s")
                    + " | %-" + String.format(6 + "s")
                    + " | %-" + String.format(addressMaxSize + "s")
                    + " | %-" + String.format(pointMaxSize + "s") + " |\n",
                    customerCard.getID(),
                    customerCard.getCustomer().getFirstName(),
                    customerCard.getCustomer().getLastName(),
                    customerCard.getCustomer().getPhoneNumber(),
                    customerCard.getCustomer().getAge(),
                    customerCard.getCustomer().getGender(),
                    customerCard.getCustomer().getAddress(),
                    customerCard.getPoint());
            System.out.println("|" + "-".repeat(borderLength) + "|");
        }
    }
}
