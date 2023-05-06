/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controllers;

import Models.CustomerCard;
import Models.CustomerCardList;
import Models.IDGenerator;
import View.CustomerCardListView;
import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author FPTSHOP
 */
public class CustomerCardListController {
    final Scanner sc = new Scanner(System.in);
    private CustomerCardList customerCardList;
    private final CustomerCardListView view = new CustomerCardListView();

    public CustomerCardListController(CustomerCardList customerCardList) {
        this.customerCardList = customerCardList;
    }

    public CustomerCardList getCustomerCardList() {
        return customerCardList;
    }

    public void setCustomerCardList(CustomerCardList customerCardList) {
        this.customerCardList = customerCardList;
    }
    
    public CustomerCardListView getCustomerCardListView(){
        return this.view;
    }
    
    public void customerCardListManagement(IDGenerator idGenerator) {
        CustomerCardController customerCardCtr = new CustomerCardController();
        CustomerCard searchedcustomerCard;
        String choice;
        do {
            this.view.menuOfcustomerCardListManagement();
            choice = sc.nextLine().trim();
            switch (choice) {
                case "1":
                    this.getCustomerCardList().addNewCard(customerCardCtr.getCustomerView(), idGenerator);
                    break;
                case "2":
                    searchedcustomerCard = this.customerCardList.searchCustomerCard();
                    if (searchedcustomerCard != null) {
                        this.getCustomerCardList().editCardInfor(searchedcustomerCard
                                , view, customerCardCtr.getCustomerView());
                    }
                    break;
                case "3":
                    searchedcustomerCard = this.customerCardList.searchCustomerCard();
                    if (searchedcustomerCard != null) {
                        this.customerCardList.deleteCustomerCard(searchedcustomerCard);
                    }
                    break;
                case "4":
                    searchedcustomerCard = this.customerCardList.searchCustomerCard();
                    if (searchedcustomerCard != null) {
                        CustomerCardList tmp = new CustomerCardList(new ArrayList<>());
                        tmp.getList().add(searchedcustomerCard);
                        tmp.showList();
                    }
                    break;
                case "5":
                    this.customerCardList.showList();
                    break;
                case "6":
                    break;
                default:
                    System.out.println("Wrong input, Please type from 1->6!");
                    break;
            }
        } while (!choice.equals("6"));
    }
}
