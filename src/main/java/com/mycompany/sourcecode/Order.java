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
    private void DecreaseQuantity(Goods goods, Shipment shipment) {
        String input;
        int value = 1;
        while (true) {
            System.out.print("Enter the quantity you want to decrease or type BACK to get back: ");
            input = sc.nextLine();
            if (input.equalsIgnoreCase("back")) {
                return;
            } else {
                try {
                    value = Integer.parseInt(input);
                    if (value < 0) {
                        System.out.println(
                                "Product quantity must be a positive number !");
                        continue;
                    } else if ((shipment.getQuantity() - value) <= 0) {
                        System.out.println(
                                "Your changes make quantity equal 0, keep your changes?");
                        System.out.println(
                                "(Y: automatically delete from your order / N: retype the quantity)=>Y/N: ");
                        String yesNo = sc.nextLine();
                        if (yesNo.equalsIgnoreCase("y")) {
                            goods.getShipments().remove(shipment);
                            System.out.println("Delete succeed...");
                        } else if (yesNo.equalsIgnoreCase("n")) {
                            continue;
                        } else {
                            System.out.println("Wrong input!");
                            continue;
                        }

                        continue;
                    } else if (value == 0) {
                        break;
                    }
                } catch (NumberFormatException nfe) {
                    if ("".equals(input)) {
                        System.out.println("Input is required!");
                    } else {
                        System.out.println("Wrong input!");
                    }
                }
            }
            int quantity = shipment.getQuantity();
            shipment.setQuantity(quantity - value);
        }
    }

    private void IncreaseQuantity(Shipment searchShipment, Shipment shipment) {
        String input;
        int value = 1;
        while (true) {
            System.out.print("Enter the quantity you want to increase or type BACK to get back: ");
            input = sc.nextLine();
            if (input.equalsIgnoreCase("back")) {
                return;
            } else {
                try {
                    value = Integer.parseInt(input);
                    if (value < 0) {
                        System.out.println(
                                "Product quantity must be a positive number !");
                        continue;
                    } else if ((shipment.getQuantity() + value) > searchShipment.getQuantity()) {
                        System.out.println(
                                "Warning: Does not have enough required quantity !");
                        continue;
                    } else if (value == 0) {
                        break;
                    }
                } catch (NumberFormatException nfe) {
                    if ("".equals(input)) {
                        System.out.println("Input is required!");
                    } else {
                        System.out.println("Wrong input!");
                    }
                }
            }
            int quantity = shipment.getQuantity();
            shipment.setQuantity(quantity + value);
        }
    }

    private int checkExistingOrderShipment(Goods searchGoods, Shipment searchShipment) {
        boolean check_goods = false;
        for (Goods goods : orderGoodsList) {
            if (goods.getGoodsID().equals(searchGoods.getGoodsID())) {
                check_goods = true;
                break;
            }
        }
        if(!check_goods){
            return -1;
        }
        for (Shipment shipment : searchGoods.getShipments()) {
            if (shipment.getShipmentID().equals(searchShipment.getShipmentID())) {
                return 1;
            }
        }
        return -1;
    }

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
        int checkExistingOrderShipment = checkExistingOrderShipment(searchGoods, searchShipment);
        if (checkExistingOrderShipment == 1) {
            System.out.println("This product shipment has been already exist. You choose?");
            int choice;
            do {
                try {
                    System.out.println("-----------------------------------");
                    System.out.println("| 1. Increase shipment's quantity |");
                    System.out.println("| 2. Decrease shipment's quantity |");
                    System.out.println("| 3. Exit                         |");
                    System.out.println("-----------------------------------");
                    System.out.print("Option => ");
                    choice = sc.nextInt();
                    sc.nextLine();
                    switch (choice) {
                        case 1:
                            IncreaseQuantity(searchShipment, orderShipment);
                            break;
                        case 2:
                            DecreaseQuantity(orderGoods, orderShipment);
                            break;
                        case 3:
                            return;
                        default:
                            System.out.println("Wrong input! Please type form 1->3!");
                            break;
                    }
                } catch (InputMismatchException ime) {
                    System.out.println("Wrong input!");
                    choice = -1;
                }
            } while (choice != 3);
        } else {
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
                        orderGoods.getShipments().add(orderShipment);
                        orderGoodsList.add(orderGoods);
                        showOrder();
                        break;
                    } catch (NumberFormatException ne) {
                        if ("".equals(input)) {
                            System.out.println("Input is required!");
                        } else {
                            System.out.println("Wrong input!");
                        }
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
                System.out.print("Please enter the discount percentage (must be a positive number): ");
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
                System.out.print("Please enter the amount of money you give: ");
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
        System.out.println("");
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
        System.out.println("");
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

    public void orderMenu() {
        System.out.println("");
        System.out.println("-----------------------");
        System.out.println("|  MAKE A NEW ORDER   |");
        System.out.println("----------------------");
        System.out.println("| 1. Add to order     |");
        System.out.println("| 2. Delete from order|");
        System.out.println("| 3. Pay              |");
        System.out.println("| 4. Back             |");
        System.out.println("----------------------");
        System.out.print("Option=> ");
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
