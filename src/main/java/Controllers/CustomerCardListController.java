/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controllers;

import Models.CustomerCard;
import Models.CustomerCardList;
import Ultility.IDGenerator;
import View.CustomerCardListView;
import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author FPTSHOP
 */
public class CustomerCardListController {
    private final CustomerCardListView view = new CustomerCardListView();
    final Scanner sc = new Scanner(System.in);
    
    public CustomerCardListController() {
    }

    public CustomerCardListView getCustomerCardListView() {
        return this.view;
    }

    public void customerCardListManagement(CustomerCardList customerCardList, IDGenerator idGenerator) {
        CustomerCard searchedcustomerCard;
        String choice;
        do {
            this.view.menuOfcustomerCardListManagement();
            choice = sc.nextLine().trim();
            switch (choice) {
                case "1":
                    // them the moi vao danh sach cac the
                    addNewCard(customerCardList, idGenerator);
                    break;
                case "2":
                    // chinh sua thong tin the
                    searchedcustomerCard = searchCustomerCard(customerCardList);
                    if (searchedcustomerCard != null) {
                        editCardInfor(customerCardList, searchedcustomerCard);
                    }
                    break;
                case "3":
                    // xoa the
                    searchedcustomerCard = searchCustomerCard(customerCardList);
                    if (searchedcustomerCard != null) {
                        deleteCustomerCard(customerCardList, searchedcustomerCard);
                    }
                    break;
                case "4":
                    // tra thong tin cua 1 the
                    searchedcustomerCard = searchCustomerCard(customerCardList);
                    if (searchedcustomerCard != null) {
                        CustomerCardList tmp = new CustomerCardList(new ArrayList<>());
                        tmp.getList().add(searchedcustomerCard);
                        this.view.showList(customerCardList);
                    }
                    break;
                case "5":
                    // hien thi toan bo danh sach cac card hien tai
                    this.view.showList(customerCardList);
                    break;
                case "6":
                    break;
                default:
                    System.out.println("Wrong input, Please type from 1->6!");
                    break;
            }
        } while (!choice.equals("6"));
    }

    public CustomerCard phoneNumAlreadyExisted(CustomerCardList customerCardList, String checkingPhoneNum) {
        // neu nhu ton tai human co cung sdt voi human truyen vao thi tra ve true
        // nguoc lai tra ve false
        for (CustomerCard temp : customerCardList.getList()) {
            if (temp.getCustomer().getPhoneNumber().equalsIgnoreCase(checkingPhoneNum)) {
                return temp;
            }
        }
        return null;
    }

    public void addNewCard(CustomerCardList customerCardList, IDGenerator idGenerator) {
        CustomerCard customerCard = new CustomerCardController().generateCard(customerCardList, idGenerator);
        if (customerCard != null) {
            customerCardList.getList().add(customerCard);
        }
    }

    public void editCardInfor(CustomerCardList customerCardList, CustomerCard customerCard) {
        CustomerController cusCtr = new CustomerController();
        CustomerCard cloneCustomerCard = new CustomerCardController().cloneCustomerCard(customerCard);
        String choice;
        do {
            this.view.menuOfEditCustomerCardInfor();
            choice = sc.nextLine().trim();
            switch (choice) {
                case "1":
                    if (cusCtr.getView().typeInFirstName(cloneCustomerCard.getCustomer()) == 0) {
                        return;
                    }
                    break;
                case "2":
                    if (cusCtr.getView().typeInLastName(cloneCustomerCard.getCustomer()) == 0) {
                        return;
                    }
                    break;
                case "3":
                    String tmp = cloneCustomerCard.getCustomer().getPhoneNumber();
                    int nextProcess = cusCtr.getView().typeInPhoneNumber(cloneCustomerCard.getCustomer());
                    if (nextProcess == 0) {
                        return;
                    } else if (phoneNumAlreadyExisted(customerCardList, 
                            cloneCustomerCard.getCustomer().getPhoneNumber()) != null) {
                        System.out.println("This phone number already existed.");
                        cloneCustomerCard.getCustomer().setPhoneNumber(tmp);
                    }
                    break;
                case "4":
                    if (cusCtr.getView().typeInAge(cloneCustomerCard.getCustomer()) == 0) {
                        return;
                    }
                    break;
                case "5":
                    if (cusCtr.getView().typeInGender(cloneCustomerCard.getCustomer()) == 0) {
                        return;
                    }
                    break;
                case "6":
                    if (cusCtr.getView().typeInAndress(cloneCustomerCard.getCustomer()) == 0) {
                        return;
                    }
                    break;
                case "7":
                    // neu khong bi co it nhat 1 thuoc tinh thay doi thi Edit succceed
                    if (!cloneCustomerCard.getCustomer().equals(customerCard.getCustomer())) {
                        customerCardList.getList().set(customerCardList.getList().indexOf(customerCard), cloneCustomerCard);
                        System.out.println("Edit succeed...");
                    }
                    System.out.println("Back...");
                    break;
            }
        } while (!choice.equals("7"));
    }

    public void deleteCustomerCard(CustomerCardList customerCardList, CustomerCard customerCard) {
        customerCardList.getList().remove(customerCard);
        System.out.println("Delete succeed!");
    }

    public CustomerCard searchCustomerCard(CustomerCardList customerCardList) {
        CustomerCard searchingCustomerCard = null;
        if (customerCardList.getList().isEmpty()) {
            System.out.println("Cannot search in an empty List!");
        } else {
            String inputStr;
            boolean completed = false;
            do {
                System.out.print("Input ID of card to search(Type last name for suggestion or press 'Enter' to see the whole List) or BACK to go back: ");
                inputStr = sc.nextLine();
                try {
                    int searchingID = Integer.parseInt(inputStr);
                    searchingCustomerCard = findCustomerCardWithID(customerCardList, inputStr);
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
                    for (CustomerCard tmp : customerCardList.getList()) {
                        String lastName = tmp.getCustomer().getLastName().toLowerCase();
                        if (lastName.contains(inputStrToLowCase)) {
                            bucket.getList().add(tmp);
                        }
                    }
                    if (bucket.getList().isEmpty()) {
                        System.out.println("No Customer Card match with your input!");
                    } else {
                        System.out.print("\nSearching : \"" + inputStr + "\"");
                        this.view.showList(customerCardList);
                    }
                }
            } while (!completed);
        }
        return searchingCustomerCard;
    }

    public CustomerCard findCustomerCardWithID(CustomerCardList customerCardList, String ID) {
        for (CustomerCard customerCard : customerCardList.getList()) {
            if (customerCard.getID().equalsIgnoreCase(ID)) {
                return customerCard;
            }
        }
        return null;
    }
}
