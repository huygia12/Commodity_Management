/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package View;

import Models.Goods;
import Models.Order;
import java.math.BigDecimal;
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
            System.out.print("Please enter the discount percentage (must be a positive number), or type EXIT/BACK to go exit/back: ");
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
                        return 1;
                    } else {
                        order.setDiscount(0);
                    }
                } catch (NumberFormatException nfe) {
                    ctions.wrInput();
                }
            }
        }
    }

    public int typeInCusMoney(Order order) {
        while (true) {
            System.out.print("Please enter the amount of money customer give, or type EXIT/BACK to exit/back from payment : ");
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
                    } else if (order.getCusMoney().compareTo(order.getTotalAfterDis()) < 0) {
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
                int choice = sc.nextInt();
                switch (choice) {
                    case 3:
                        return -1;
                    case 4:
                        return 0;
                    case 1, 2:
                        order.setPaymentOptions(choice);
                        return 1;
                    default:
                        System.out.println("Wrong input! Please choose from 1->4");
                        break;
                }
            } catch (InputMismatchException ime) {
                System.out.println("Wrong input!");
                sc.next();
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
            BigDecimal totalQuantity = goods.getTotalQuantity();
            BigDecimal price = goods.getListPrice();
            BigDecimal totalPrice = totalQuantity.multiply(price);
            System.out.format("%-25s %-10s %-15s %-15s\n", goods.getGoodsName(), totalQuantity + "", price + "", totalPrice + "");
        }
        BigDecimal totalPayment = order.getTotalPayment();
        System.out.println(" ");
        System.out.println("Total payment: " + totalPayment);
        System.out.println("--------------------------------------------------------------------");
    }

    public void showBill(Order order) {
        BigDecimal change = order.getCusMoney().subtract(order.getTotalAfterDis());
        System.out.println("");
        System.out.println("-------------- YOUR BILL ---------------");
        System.out.println("----------------------");
        System.out.println("Date: " + order.getInVoiceDateTime());
        System.out.println("");
        System.out.format("%-25s %-10s %-15s %-15s\n", "Name", "Quantity", "Price", "Total");
        System.out.format("%-25s %-10s %-15s %-15s\n", "-------------------------", "----------", "---------------", "---------------");
        for (int i = 0; i < order.getGoodsList().size(); i++) {
            Goods goods = order.getGoodsList().get(i);
            BigDecimal totalQuantity = goods.getTotalQuantity();
            BigDecimal price = goods.getListPrice();
            BigDecimal totalPrice = totalQuantity.multiply(price);
            System.out.format("%-25s %-10s %-15s %-15s\n", goods.getGoodsName(), totalQuantity, price, totalPrice);
        }
        System.out.println("Total payment: " + order.getTotalPayment());
        System.out.println("Discount: " + order.getDiscount() + "%");
        System.out.println("Total after discount: " + order.getTotalAfterDis());
        System.out.println("Customer payment: " + order.getCusMoney());
        System.out.println("Payment Option: "+ order.getPaymentOptions());
        System.out.println("Change: " + change);
        System.out.println("----------------------------------------");
    }

}
