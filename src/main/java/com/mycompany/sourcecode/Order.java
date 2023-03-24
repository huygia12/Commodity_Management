package com.mycompany.sourcecode;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class Order {

    private String orderID = null;
    private int discount;
    Scanner sc = new Scanner(System.in);
    List<Goods> myGoodsList = new ArrayList<>();
    List<Goods> orderGoodsList = new ArrayList<>();
    String invoiceDate = LocalDateTime.now().format(DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss"));

    public Order() {
    }

    public Order(List<Goods> myGoodsList) {
        this.myGoodsList = myGoodsList;
    }

    public void setDiscount(int discount) {
        this.discount = discount;
    }

    public int getDiscount() {
        return this.discount;
    }

    public String getOrderID() {
        return this.orderID;
    }

    private int totalPayment() {
        return 0;
    }

    private int totalAfterDiscount() {
        return 0;
    }

    //funtion 1
    private void addToOrder() {
        //undeveloped
    }

    //function 2
    private void deleteFromOrder() {
        //undeveloped
    }

    //funtion 3
    private void pay() {
        //undeveloped
    }
    //function 4

    public void showBill() {
        System.out.println("----------------------");
        System.out.println("|      YOUR BILL     |");
        System.out.println("----------------------");
        System.out.println("Date: " + invoiceDate);
        System.out.println("");
        System.out.println("Order items:");
        System.out.format("%-25s %-10s %-15s\n", "Name", "Quantity", "Price");
        System.out.format("%-25s %-10s %-15s\n", "-------------------------", "----------", "---------------");
        for (int i = 0; i < orderGoodsList.size(); i++) {
            Goods goods = orderGoodsList.get(i);

            int totalQuantity = goods.getTotalQuantity();
            int totalPrice = totalQuantity * goods.getListPrice();
            System.out.format("%-25s %-10d %-15d\n", goods.getGoodsName(), totalQuantity, totalPrice);
        }
        System.out.println("");
        System.out.println("Total payment: " + totalPayment());
        System.out.println("Discount: " + discount + "%");
        System.out.println("Total after discount: " + totalAfterDiscount());
        System.out.println("----------------------");
    }

    public void makeNewOrder() {
        int choice;
        do {
            try {
                System.out.println("----------------------");
                System.out.println("| MAKE A NEW ORDER    |");
                System.out.println("----------------------");
                System.out.println("| 1. Add to order     |");
                System.out.println("| 2. Delete from order|");
                System.out.println("| 3. Pay              |");
                System.out.println("----------------------");
                choice = sc.nextInt();
                switch (choice) {
                    case 1:
                        addToOrder();
                        break;
                    case 2:
                        deleteFromOrder();
                        break;
                    case 3:
                        pay();
                        break;
                    default:
                        System.out.println("Wrong input! Please type form 1->3!");
                        break;
                }
            } catch (InputMismatchException ime) {
                System.out.println("Wrong input!");
                choice = -1;
            }
        } while (choice != 3);
    }
}
