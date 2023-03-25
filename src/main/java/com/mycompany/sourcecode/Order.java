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

    private int totalPayment() {
        return 0;
    }

    private int totalAfterDiscount() {
        return 0;
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
                        showBill();
                        break;
                    }
                    orderGoods.getShipments().add(orderShipment);
                    orderGoodsList.add(orderGoods);
                    showBill();
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

    //funtion 3
    private void pay() {
        //undeveloped
    }
    //function 4

    public void showBill() {
        System.out.println("----------------------");
        System.out.println("|      RECEIPT     |");
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
        System.out.println("----------------------");
        System.out.println("Total after discount: " + totalAfterDiscount());
        System.out.println("----------------------");
        System.out.println("");
    }

    public void makeNewOrder() {
        int choice;
        do {
            try {
                System.out.println("-----------------------");
                System.out.println("|   MAKE A NEW ORDER   |");
                System.out.println("-----------------------");
                System.out.println("| 1. Add to order      |");
                System.out.println("| 2. Delete from order |");
                System.out.println("| 3. Pay               |");
                System.out.println("| 4. Back              |");
                System.out.println("-----------------------");
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
