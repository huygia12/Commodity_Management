/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controllers;

import Models.CustomerCard;
import Models.CustomerCardList;
import Models.Store;
import Ultility.IDGenerator;
import View.CustomerView;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.stream.Collectors;

/**
 *
 * @author FPTSHOP
 */
public class CustomerCardController {
    final CustomerView customerView = new CustomerView();
    
    public CustomerCardController() {
    }

    public CustomerView getCustomerView() {
        return customerView;
    }

    public CustomerCard generateCard(CustomerCardList customerCardList,IDGenerator idGenerator) {
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
                        n = 1;
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
                    } else if (new CustomerCardListController().phoneNumAlreadyExisted(customerCardList, 
                            newCustomerCard.getCustomer().getPhoneNumber()) != null) {
                        n = 4;
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
        newCustomerCard.setID(idGenerator.generateID(CustomerCard.class.getName(), 6));
        return newCustomerCard;
    }

    public CustomerCard cloneCustomerCard(CustomerCard customerCard) {
        CustomerCard cloneCard = new CustomerCard();
        cloneCard.setCustomer(new CustomerController().cloneCustomer(customerCard.getCustomer()));
        cloneCard.setID(customerCard.getID());
        cloneCard.setPoint(customerCard.getPoint());
        cloneCard.setIDOfBoughtOrders(customerCard.getIDOfBoughtOrders()
                .stream()
                .map(x -> x)
                .collect(Collectors.toList()));
        return cloneCard;
    }

    public void gainPoint(CustomerCard custmomerCard, BigDecimal totalPayment, Store store) {
        custmomerCard.setPoint(custmomerCard
                .getPoint()
                .add(totalPayment.toBigInteger()
                        .divide(store.getAmountForOnePoint().toBigInteger())));
    }

    public BigDecimal convertPointToMoney(CustomerCard custmomerCard, BigInteger inputPoint, Store store) {
        if (inputPoint.compareTo(BigInteger.ZERO) <= 0) {
            return BigDecimal.ZERO;
        }
        if (inputPoint.compareTo(custmomerCard
                .getPoint()) >= 0) {
            inputPoint = custmomerCard.getPoint();
        }
        return new BigDecimal(inputPoint
                .divide(store.getPointsForOneVND())
                .multiply(new BigInteger("1000")));
    }

    public void usePoint(CustomerCard customerCard, BigInteger usedPoint){
        customerCard.setPoint(customerCard.getPoint().subtract(usedPoint));
    }
}
