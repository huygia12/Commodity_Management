/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Models;

import View.CustomerView;

/**
 *
 * @author FPTSHOP
 */
public class CustomerCard {

    private String ID;
    private long point;
    private Customer customer = new Customer();


    public CustomerCard() {
    }

    public CustomerCard(String ID) {
        this.ID = ID;
    }
    
    public String getID() {
        return ID;
    }

    public void setID(String ID) {
        this.ID = ID;
    }

    public long getPoint() {
        return point;
    }

    public void setPoint(long point) {
        this.point = point;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public CustomerCard generateCard(CustomerView customerView, CustomerCardList customerCardList) {
        CustomerCard newCustomerCard = new CustomerCard();
        int n = 1;
        int nextProcess;
        while (n != 6) {
            switch (n) {
                case 1:
                    nextProcess = customerView.typeInFirstName(newCustomerCard.getCustomer());
                    if (nextProcess == 0 || nextProcess == -1) {
                        return null;
                    }
                case 2:
                    nextProcess = customerView.typeInLastName(newCustomerCard.getCustomer());
                    if (nextProcess == 0) {
                        return null;
                    } else if (nextProcess == -1) {
                        break;
                    }
                case 3:
                    nextProcess = customerView.typeInAge(newCustomerCard.getCustomer());
                    if (nextProcess == 0) {
                        return null;
                    } else if (nextProcess == -1) {
                        n = 2;
                        break;
                    }
                case 4:
                    nextProcess = customerView.typeInPhoneNumber(newCustomerCard.getCustomer());
                    if (nextProcess == 0) {
                        return null;
                    } else if (nextProcess == -1) {
                        n = 3;
                        break;
                    } else if (customerCardList.phoneNumAlreadyExisted(newCustomerCard.getCustomer()
                            .getPhoneNumber()) != null) {
                        n =4;
                        System.out.println("This phone number already existed.");
                        break;
                    }
                case 5:
                    nextProcess = customerView.typeInGender(newCustomerCard.getCustomer());
                    if (nextProcess == 0) {
                        return null;
                    } else if (nextProcess == -1) {
                        n = 4;
                        break;
                    }
                case 6:
                    nextProcess = customerView.typeInAndress(newCustomerCard.getCustomer());
                    if (nextProcess == 0) {
                        return null;
                    } else if (nextProcess == -1) {
                        n = 5;
                        break;
                    }
                    n = 6;
            }
        }
        newCustomerCard.setPoint(0);
        newCustomerCard.setID(String.format("%06d", customerCardList.getList().size()));
        return newCustomerCard;
    }
    
    public CustomerCard cloneCustomerCard(){
        CustomerCard customerCard = new CustomerCard();
        customerCard.setCustomer(this.customer.cloneCustomer());
        customerCard.setID(this.getID());
        customerCard.setPoint(this.getPoint());
        return customerCard;
    }
    
}
