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
    UsefulFunctions uf = new UsefulFunctions();
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
        Goods searchGoods = uf.searchGoods(myGoodsList);
        String input;
        Goods orderGoods = new Goods();
        Shipment orderShipment = new Shipment();
        if (searchGoods == null) {
            return;
        }
        Shipment searchShipment = uf.searchShipments(searchGoods);
        sc.nextLine();
        if (searchShipment == null) {
            return;
        }
        while (true) {
            System.out.print("Input product quantity or type BACK to get back: ");
            input = sc.nextLine();
            if (input.equalsIgnoreCase("back")) {
                break;
            } else {
                try {
                    int quantity = Integer.parseInt(input);
                    if (quantity < 0) {
                        System.out.println(
                                "Product quantity must be a positive number !");
                        continue;
                    } else if (quantity > searchShipment.getQuantity()) {
                        System.out.println(
                                "Warning: Does not have enough required quantity !");
                        continue;
                    } else if (quantity == 0) {
                        break;
                    }
                    orderGoods.setGoodsID(searchGoods.getGoodsID());
                    orderGoods.setGoodsName(searchGoods.getGoodsName());
                    orderGoods.setListPrice(searchGoods.getListPrice());
                    orderShipment.setShipmentID(searchShipment.getShipmentID());
                    orderShipment.setQuantity(quantity);
                    boolean compare = false;
                    for (Goods orderGoods1 : orderGoodsList) {
                        if (orderGoods1.getGoodsID().equals(searchGoods.getGoodsID())) {
                            orderGoods1.getShipments().remove(0);
                            orderGoods1.getShipments().add(orderShipment);
                            compare = true;
                            break;
                        }
                    }
                    if (compare == true) {
                        // Giảm số lượng hàng trong lô hàng sau khi thêm vào đơn hàng
                        searchShipment.reduceQuantity(quantity);
                        showOrder();
                        break;
                    }
                    orderGoods.getShipments().add(orderShipment);
                    orderGoodsList.add(orderGoods);
                    // Giảm số lượng hàng trong lô hàng sau khi thêm vào đơn hàng
                    searchShipment.reduceQuantity(quantity);
                    showOrder();
                    break;
                } catch (NumberFormatException nfe) {
                    if ("".equals(input)) {
                        System.out.println("Input is required!");
                    } else {
                        System.out.println("Wrong input!");
                    }
                }
            }
        }
    }

    //function 2
    private void deleteFromOrder() {

    }
    //function 3

    private void pay() {
        Scanner scanner = new Scanner(System.in);

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
        int totalPayment = totalPayment();
        int totalAfterDiscount = totalAfterDiscount(totalPayment);

        int change = 0;
        while (true) {
            try {
                System.out.println("Please enter the amount of money you give: ");
                customerMoney = scanner.nextInt();

                if (customerMoney < 0) {
                    System.out.println("Payment amount must be a positive number. Please try again.");
                    continue;
                } else if (customerMoney < totalAfterDiscount) {
                    System.out.println("Insufficient payment. Please pay more.");
                    continue;
                } else {
                    change = customerMoney - totalAfterDiscount;
                    showBill(totalPayment, totalAfterDiscount, change);
                    break;
                }
            } catch (InputMismatchException e) {
                System.out.println("Invalid input. Payment amount must be a positive number. Please try again.");
                scanner.next();
            }
        }

    }

    //function 4
    private void showOrder() {
        System.out.println("-------------------- YOUR ORDER --------------------");
        System.out.println("------------------------------------------------------");
        System.out.format("%-25s %-10s %-15s %-15s\n", "Name", "Quantity", "Price", "Total");
        System.out.format("%-25s %-10s %-15s %-15s\n", "-------------------------", "----------", "---------------", "---------------");
        for (int i = 0; i < orderGoodsList.size(); i++) {
            Goods goods = orderGoodsList.get(i);
            long totalQuantity = goods.getTotalQuantity();
            long price = goods.getListPrice();
            long totalPrice = totalQuantity * price;
            System.out.format("%-25s %-10d %-15d %-15d\n", goods.getGoodsName(), totalQuantity, price, totalPrice);
        }
        System.out.println("------------------------------------------------------");
    }

    //function 5
    private void showBill(int totalPayment, int totalAfterDiscount, int change) {
        System.out.println("-------------- YOUR BILL ---------------");
        System.out.println("----------------------");
        System.out.println("Date: " + invoiceDate);
        System.out.println("");
        System.out.format("%-25s %-10s %-15s %-15s\n", "Name", "Quantity", "Price", "Total");
        System.out.format("%-25s %-10s %-15s %-15s\n", "-------------------------", "----------", "---------------", "---------------");
        for (int i = 0; i < orderGoodsList.size(); i++) {
            Goods goods = orderGoodsList.get(i);
            long totalQuantity = goods.getTotalQuantity();
            long price = goods.getListPrice();
            long totalPrice = totalQuantity * price;
            System.out.format("%-25s %-10d %-15d %-15d\n", goods.getGoodsName(), totalQuantity, price, totalPrice);
        }
        System.out.println("Total payment: " + totalPayment);
        System.out.println("Discount: " + discount + "%");
        System.out.println("Total after discount: " + totalAfterDiscount);
        System.out.println("Customer payment: " + customerMoney);
        System.out.println("Change: " + change);
        System.out.println("----------------------------------------");
    }

    public void makeNewOrder() {
        int choice;
        do {
            try {
                System.out.println("\n********************************");
                System.out.println("|   MAKE A NEW ORDER   |");
                System.out.println("-----------------------");
                System.out.println("| 1. Add to order      |");
                System.out.println("| 2. Delete from order |");
                System.out.println("| 3. Pay               |");
                System.out.println("| 4. Back              |");
                System.out.println("********************************");
                System.out.print("Option => ");
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
                    case 4:
                        break;
                    default:
                        System.out.println("Wrong input! Please type form 1->4!");
                        break;
                }
            } catch (InputMismatchException ime) {
                System.out.println("Wrong input!");
                choice = -1;
            }
        } while (choice != 4);
    }
}
