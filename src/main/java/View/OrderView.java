/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package View;

import Models.CustomerCard;
import Models.CustomerCardList;
import Models.Goods;
import Models.Order;
import Models.PaymentOptions;
import Models.Store;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.InputMismatchException;
import java.util.Scanner;

/**
 *
 * @author FPTSHOP
 */
public class OrderView {

    final Scanner sc = new Scanner(System.in);
    final Cautions ctions = new Cautions();

    public void orderMenu() {
        System.out.println("");
        System.out.println("--------------------------");
        System.out.println("|    MAKE A NEW ORDER    |");
        System.out.println("--------------------------");
        System.out.println("| 1. Add to order        |");
        System.out.println("| 2. Edit Current Order  |");
        System.out.println("| 3. Pay                 |");
        System.out.println("| 4. Back                |");
        System.out.println("--------------------------");
        System.out.print("Option=> ");
    }

    public void editOrderMenu() {
        System.out.println("");
        System.out.println("------------------------------");
        System.out.println("|      CHOOSE FUNCTION       |");
        System.out.println("------------------------------");
        System.out.println("| 1. Incerase Quantity       |");
        System.out.println("| 2. Decrease Quantity       |");
        System.out.println("| 3. Delete from order       |");
        System.out.println("| 4. Back                    |");
        System.out.println("------------------------------");
        System.out.print("Option=> ");
    }

    public int typeInDcountPctage(Order order) {
        while (true) {
            System.out.print("Please enter the discount percentage (must be a positive number), \nor type EXIT/BACK to go exit/back: ");
            String input = sc.nextLine();
            if ("back".equalsIgnoreCase(input)) {
                return -1;
            } else if ("exit".equalsIgnoreCase(input)) {
                return 0;
            } else if (ctions.checkIfNoInput(input)) {
            } else {
                try {
                    order.setDiscount(Math.min(100, Integer.parseInt(input)));
                    if (ctions.checkIfIntNegative(order.getDiscount())) {
                        order.setDiscount(0);
                    } else {
                        return 1;
                    }
                } catch (NumberFormatException nfe) {
                    ctions.wrInput();
                }
            }
        }
    }

    public int typeInCusMoney(Order order) {
        while (true) {
            System.out.print("Please enter the amount of money customer give, \nor type EXIT/BACK to exit/back from payment : ");
            String input = sc.nextLine();
            if ("back".equalsIgnoreCase(input)) {
                return -1;
            } else if ("exit".equalsIgnoreCase(input)) {
                return 0;
            } else if (ctions.checkIfNoInput(input)) {
            } else {
                try {
                    order.setCusMoney(new BigDecimal(input));
                    if (!ctions.checkIfBigDecimalNegative(order.getCusMoney())) {
                        order.setCusMoney(BigDecimal.ZERO);
                    } else if (order.getCusMoney().compareTo(order.getTotal()) < 0) {
                        order.setCusMoney(BigDecimal.ZERO);
                        System.out.println("Insufficient payment! Please pay more.");
                    } else {
                        return 1;
                    }
                } catch (NumberFormatException nfe) {
                    ctions.wrInput();
                }
            }
        }
    }

    public int typeOfPayment(Order order) {
        while (true) {
            try {
                System.out.print("""
                                 1: Cash Payment  2: Wire Transfer Payment 
                                 3: Back          4: Exit
                                 Please choose one payment options => """);
                String choice = sc.nextLine();
                switch (choice) {
                    case "3":
                        return -1;
                    case "4":
                        return 0;
                    case "1", "2":
                        order.setPaymentOptions(Integer.parseInt(choice));
                        return 1;
                    default:
                        System.out.println("Wrong input! Please choose from 1->4");
                        break;
                }
            } catch (InputMismatchException ime) {
                ctions.wrInput();
                sc.next();
            }
        }
    }

    public int typeInCustomerID(CustomerCardList customerCardList, Order order) {
        while (true) {
            System.out.print("Please enter the Member Card ID(for member-only), \nor type EXIT/BACK to exit/back(press ENTER to skip) : ");
            String input = sc.nextLine();
            CustomerCard customerCard = customerCardList.findCustomerCardWithID(input);
            if ("back".equalsIgnoreCase(input)) {
                return -1;
            } else if ("exit".equalsIgnoreCase(input)) {
                return 0;
            } else if (customerCard == null && !input.equals("")) {
                System.out.println("This member ID doesnt exist!");
            } else {
                order.setCustomerCard(customerCard);
                return 1;
            }
        }
    }

    public int typeInPoint(Order order, CustomerCard customerCard) {
        while (true) {
            System.out.print("Please enter the point you want to use, or type EXIT/BACK to exit/back : ");
            String input = sc.nextLine();
            if ("back".equalsIgnoreCase(input)) {
                return -1;
            } else if ("exit".equalsIgnoreCase(input)) {
                return 0;
            } else {
                try {
                    BigInteger point = new BigInteger(input);
                    order.setPointDiscount(customerCard.convertPointToMoney(point));
                    return 1;
                } catch (NumberFormatException nfe) {
                    ctions.wrInput();
                }
            }
        }
    }

    public void showDraftOrder(Order order) {
        System.out.println("");
        System.out.println("-------------------------- YOUR ORDER ------------------------------");
        System.out.println("--------------------------------------------------------------------");
        System.out.format("%-25s %-10s %-15s %-15s\n", "Name", "Quantity", "Price", "Total");
        System.out.format("%-25s %-10s %-15s %-15s\n", "-------------------------", "----------", "---------------", "---------------");
        for (int i = 0; i < order.getGoodsList().size(); i++) {
            Goods goods = order.getGoodsList().get(i);
            BigDecimal totalQuantity = goods.getTotalQuanByShipments();
            BigDecimal price = goods.getListPrice();
            BigDecimal totalPrice = totalQuantity.multiply(price);
            System.out.format("%-25s %-10s %-15s %-15s\n", goods.getGoodsName(), totalQuantity + "", price + "", totalPrice + "");
        }
        BigDecimal totalPayment = order.getSubTotal();
        System.out.println(" ");
        System.out.println("Total payment: " + totalPayment);
        System.out.println("--------------------------------------------------------------------");
    }

    public void showBill(Order order, Store myStore) {
        String customerID = "";
        if (order.getCustomerCard() != null) {
            customerID = order.getCustomerCard().getID();
        }
        BigDecimal change = order.getCusMoney().subtract(order.getTotal());
        System.out.println("");
        System.out.println("-------------- YOUR BILL ---------------");
        System.out.println("----------------------------------------");
        System.out.println("Store Name: " + myStore.getName());
        System.out.println("Email: " + myStore.getEmail());
        System.out.println("Address: " + myStore.getAddress());
        System.out.println("Phone Number: " + myStore.getPhoneNumber());
        System.out.println("Date: " + order.getOrderDateTime());
        System.out.println("");
        System.out.format("%-25s %-10s %-15s %-15s\n", "Name", "Quantity", "Price", "Total");
        System.out.format("%-25s %-10s %-15s %-15s\n", "-------------------------", "----------", "---------------", "---------------");
        for (int i = 0; i < order.getGoodsList().size(); i++) {
            Goods goods = order.getGoodsList().get(i);
            BigDecimal totalQuantity = goods.getTotalQuanByShipments();
            BigDecimal price = goods.getListPrice();
            BigDecimal totalPrice = totalQuantity.multiply(price);
            System.out.format("%-25s %-10s %-15s %-15s\n", goods.getGoodsName(), totalQuantity, price, totalPrice);
        }
        System.out.printf("SubTotal: %.0f\n",  order.getSubTotal());
        System.out.printf("Discount Amount(Discount=%s): %.0f\n", order.getDiscount() + "%", order.getDiscountMoney());
        System.out.printf("Tax(VAT=%s): %.0f\n", myStore.getVAT() + "%", order.getTaxFee());
        System.out.println("Payment Option: " + order.getPaymentOptions());
        System.out.println("Member Card ID: " + customerID);
        System.out.printf("Point Discount: %.0f\n",  order.getPointDiscount());
        System.out.printf("Total: %.0f\n",  order.getTotal());
        if (order.getPaymentOptions().equals(PaymentOptions.Cash_Payment)) {
            System.out.printf("Customer payment: %.0f\n", order.getCusMoney());
            System.out.printf("Change: %.0f\n", change);
        }
        System.out.println("----------------------------------------");
    }

}
