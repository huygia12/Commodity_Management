/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controllers;

import Models.CustomerCard;
import Models.CustomerCardList;
import Ultility.IDGenerator;
import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author FPTSHOP
 */
public class CustomerCardListController {
    
    public CustomerCardListController() {
    }
    
    public CustomerCard containCustomerCard(CustomerCardList customerCardList, String ID) {
        for (CustomerCard customerCard : customerCardList.getList()) {
            if (customerCard.getID().equalsIgnoreCase(ID)) {
                return customerCard;
            }
        }
        return null;
    }
}
