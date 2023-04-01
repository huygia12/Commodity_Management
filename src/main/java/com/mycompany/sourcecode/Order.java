package com.mycompany.sourcecode;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class Order {

    private String orderID = null;
    private int customerMoney;
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

    public int getCustomerMoney() {
        return customerMoney;
    }

    public void setCustomerMoney(int customerMoney) {
        this.customerMoney = customerMoney;
    }

    private int totalPayment() {
        int totalPayment = 0;
        for (int i = 0; i < orderGoodsList.size(); i++) {
            Goods goods = orderGoodsList.get(i);
            totalPayment += goods.getListPrice() * goods.getTotalQuantity();
        }
        return totalPayment;
    }

    private int totalAfterDiscount(int totalPayment) {
        int totalAfterDiscount = totalPayment - (totalPayment * discount / 100);
        return totalAfterDiscount;
    }

    //funtion 1
    private void addToOrder() {
        //undeveloped
    }

    //function 2
    private void deleteFromOrder() {
        //undeveloped
    }
    
    //function 3
    private void pay() {
        Scanner scanner = new Scanner(System.in);
        int totalPayment = totalPayment();
        int totalAfterDiscount = totalAfterDiscount(totalPayment);
        while (true) {
            try {
                System.out.println("Please enter the discount percentage (must be a positive number): ");
                // //Phương thức Math.min trả về giá trị nhỏ hơn trong hai số chỉ định
                discount = Math.min(100, scanner.nextInt());

                if (discount < 0) {
                    System.out.println("Discount percentage must be a positive number. Please try again.");
                    continue;
                }

                break;
            } catch (InputMismatchException e) {
                System.out.println("Invalid input. Discount percentage must be a positive number. Please try again.");
                scanner.next();
            }
        }

        while (true) {
            try {
                System.out.println("Please enter the amount of money you give: ");
                customerMoney = scanner.nextInt();

                if (customerMoney < 0) {
                    System.out.println("Payment amount must be a positive number. Please try again.");
                    continue;
                }

                break;
            } catch (InputMismatchException e) {
                System.out.println("Invalid input. Payment amount must be a positive number. Please try again.");
                scanner.next();
            }
        }

        if (customerMoney < totalAfterDiscount) {
            System.out.println("Insufficient payment. Please pay more.");
        } else {
            int change = customerMoney - totalAfterDiscount;
            showBill(totalPayment, totalAfterDiscount, change);
        }
    }
    //function 4

    private void showBill(int totalPayment, int totalAfterDiscount, int change) {
        System.out.println("-------------- YOUR BILL ---------------");
        System.out.println("----------------------");
        System.out.println("Date: " + invoiceDate);
        System.out.println("");
        System.out.format("%-25s %-10s %-15s\n", "Name", "Quantity", "Price");
        System.out.format("%-25s %-10s %-15s\n", "-------------------------", "----------", "---------------");
        for (int i = 0; i < orderGoodsList.size(); i++) {
            Goods goods = orderGoodsList.get(i);
            long totalQuantity = goods.getTotalQuantity();
            long totalPrice = totalQuantity * goods.getListPrice();
            System.out.format("%-25s %-10d %-15d\n", goods.getGoodsName(), totalQuantity, totalPrice);
        }
        System.out.println("Total payment: " + totalPayment);
        System.out.println("Discount: " + discount + "%");
        System.out.println("Total after discount: " + totalAfterDiscount);
        System.out.println("Customer payment: " + customerMoney);
        System.out.println("Change: " + change);
        System.out.println("----------------------------------------");
    }

    public void orderMenu() {
        System.out.println("----------------------");
        System.out.println("| MAKE A NEW ORDER    |");
        System.out.println("----------------------");
        System.out.println("| 1. Add to order     |");
        System.out.println("| 2. Delete from order|");
        System.out.println("| 3. Pay              |");
        System.out.println("----------------------");
        System.out.println("Option=> ");
    }

    public void makeNewOrder() {
        int choice;
        UsefulFunctions uf = new UsefulFunctions();
        uf.showGoodsList(myGoodsList);
        do {
            try {
                orderMenu();
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
