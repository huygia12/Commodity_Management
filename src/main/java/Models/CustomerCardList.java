/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Models;

import View.CustomerCardListView;
import View.CustomerView;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 *
 * @author FPTSHOP
 */
public class CustomerCardList {

    final Scanner sc = new Scanner(System.in);
    private List<CustomerCard> cardList;
     private int pointMaxSize;
    private int IDMaxSize;
    private int firstNameMaxSize;
    private int lastNameMaxSize;
    private int phoneNumberMaxSize;
    private int addressMaxSize;

    public CustomerCardList() {
    }

    public CustomerCardList(List<CustomerCard> cardList) {
        this.cardList = cardList;
    }

    public List<CustomerCard> getList() {
        return cardList;
    }

    public void setList(List<CustomerCard> cardList) {
        this.cardList = cardList;
    }

    public CustomerCard phoneNumAlreadyExisted(String checkingPhoneNum) {
        // neu nhu ton tai human co cung sdt voi human truyen vao thi tra ve true
        // nguoc lai tra ve false
        for (CustomerCard temp : this.cardList) {
            if (temp.getCustomer().getPhoneNumber().equalsIgnoreCase(checkingPhoneNum)) {
                return temp;
            }
        }
        return null;
    }

    public void addNewCard(CustomerView customerView, IDGenerator idGenerator) {
        CustomerCard customerCard = new CustomerCard().generateCard(customerView, this, idGenerator);
        this.cardList.add(customerCard);
    }

    public void editCardInfor(CustomerCard customerCard, CustomerCardListView customerCardListView, CustomerView customerView) {
        CustomerCard cloneCustomerCard = customerCard.cloneCustomerCard();
        String choice;
        do {
            customerCardListView.menuOfEditCustomerCardInfor();
            choice = sc.nextLine().trim();
            switch (choice) {
                case "1":
                    if (customerView.typeInFirstName(cloneCustomerCard.getCustomer()) == 0) {
                        return;
                    }
                    break;
                case "2":
                    if (customerView.typeInLastName(cloneCustomerCard.getCustomer()) == 0) {
                        return;
                    }
                    break;
                case "3":
                    String tmp = cloneCustomerCard.getCustomer().getPhoneNumber();
                    int nextProcess = customerView.typeInPhoneNumber(cloneCustomerCard.getCustomer());
                    if (nextProcess == 0) {
                        return;
                    } else if (this.phoneNumAlreadyExisted(cloneCustomerCard.getCustomer().getPhoneNumber()) != null) {
                        System.out.println("This phone number already existed.");
                        cloneCustomerCard.getCustomer().setPhoneNumber(tmp);
                    }
                    break;
                case "4":
                    if (customerView.typeInAge(cloneCustomerCard.getCustomer()) == 0) {
                        return;
                    }
                    break;
                case "5":
                    if (customerView.typeInGender(cloneCustomerCard.getCustomer()) == 0) {
                        return;
                    }
                    break;
                case "6":
                    if (customerView.typeInAndress(cloneCustomerCard.getCustomer()) == 0) {
                        return;
                    }
                    break;
                case "7":
                    if (!cloneCustomerCard.getCustomer().equals(customerCard.getCustomer())) {
                        this.getList().set(this.getList().indexOf(customerCard), cloneCustomerCard);
                        System.out.println("Edit succeed...");
                    }
                    System.out.println("Back...");
                    break;
            }
        } while (!choice.equals("7"));
    }

    public void deleteCustomerCard(CustomerCard customerCard) {
        this.getList().remove(customerCard);
        System.out.println("Delete succeed!");
    }

    public CustomerCard searchCustomerCard() {
        CustomerCard searchingCustomerCard = null;
        if (this.getList().isEmpty()) {
            System.out.println("Cannot search in an empty List!");
        } else {
            String inputStr;
            boolean completed = false;
            do {
                System.out.print("Input ID of card to search(Type last name for suggestion or press 'Enter' to see the whole List) or BACK to go back: ");
                inputStr = sc.nextLine();
                try {
                    int searchingID = Integer.parseInt(inputStr);
                    searchingCustomerCard = findCustomerCardWithID(inputStr);
                    if (searchingCustomerCard == null) {
                        System.out.println("CustomerCard with this ID doesnt existed.");
                        continue;
                    }
                    completed = true;
                } catch (NumberFormatException nfe) {
                    if (inputStr.equalsIgnoreCase("back")) {
                        return null;
                    }
                    CustomerCardList bucket = new CustomerCardList(new ArrayList<>());
                    String inputStrToLowCase = inputStr.toLowerCase();
                    for (CustomerCard tmp : this.getList()) {
                        String lastName = tmp.getCustomer().getLastName().toLowerCase();
                        if (lastName.contains(inputStrToLowCase)) {
                            bucket.getList().add(tmp);
                        }
                    }
                    if (bucket.getList().isEmpty()) {
                        System.out.println("No Customer Card match with your input!");
                    } else {
                        System.out.print("\nSearching : \"" + inputStr + "\"");
                        bucket.showList();
                    }
                }
            } while (!completed);
        }
        return searchingCustomerCard;
    }

    public CustomerCard findCustomerCardWithID(String ID) {
        for (CustomerCard customerCard : this.cardList) {
            if (customerCard.getID().equalsIgnoreCase(ID)) {
                return customerCard;
            }
        }
        return null;
    }

    public void showList() {
        if (this.getList().isEmpty()) {
            System.out.println("Nothing found in this List!");
            return;
        }
        computeSizeOfEachCol();
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
        for (CustomerCard customerCard : this.getList()) {
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

    private void computeSizeOfEachCol() {
        pointMaxSize = "Point".length();
        IDMaxSize = "ID".length();
        firstNameMaxSize = "First Name".length();
        lastNameMaxSize = "Last Name".length();
        phoneNumberMaxSize = "Phone Number".length();
        addressMaxSize = "Address".length();
        for (CustomerCard customerCard : this.getList()) {
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

}
