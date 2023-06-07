/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package View;

import Ultility.Cautions;
import Controllers.CustomerCardListController;
import Controllers.GoodsController;
import Controllers.OrderController;
import Models.CustomerCard;
import Models.CustomerCardList;
import Models.Goods;
import Models.Order;
import Models.PaymentOptions;
import Models.Store;
import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;
import java.time.format.DateTimeFormatter;
import java.util.InputMismatchException;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author FPTSHOP
 */
public class OrderView {
    private final String HOME = System.getProperty("user.dir");
    private final String SEPARATOR = File.separator;
    private final String FILE_PRINT = HOME + SEPARATOR + "output" + SEPARATOR + "bill.txt";
    private final String DATE_TIME_FORMAT = "dd/MM/yyyy hh:mm:ss";
    final Cautions ctions = new Cautions();
    final Scanner sc = new Scanner(System.in);
    final CustomerCardListController cardListCtr = new CustomerCardListController();
    private final GoodsController goodsCtr = new GoodsController();
    
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
                    if (ctions.checkIfNumberNegative(order.getDiscount())) {
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

    public int typeInCusMoney(Order order, OrderController orderCtr, Store store) {
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
                    if (ctions.checkIfNumberNegative(order.getCusMoney())) {
                        order.setCusMoney(BigDecimal.ZERO);
                    } else if (order.getCusMoney().compareTo(orderCtr.getTotal(order, store)) < 0) {
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
                        order.setPaymentOptions(choice.equals("1") 
                                ?  PaymentOptions.CASH_PAYMENT : PaymentOptions.OTHER_PAYMENT);
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
            CustomerCard customerCard = cardListCtr.containCustomerCard(customerCardList, input);
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

    public int typeInPoint(Order order) {
        while (true) {
            System.out.printf("Current points in card: %s\n", order.getCustomerCard().getPoint());
            System.out.print("Please enter the amount of points you want to use, or type EXIT/BACK to exit/back : ");
            String input = sc.nextLine();
            if ("back".equalsIgnoreCase(input)) {
                return -1;
            } else if ("exit".equalsIgnoreCase(input)) {
                return 0;
            } else {
                try {
                    BigInteger point = new BigInteger(input);
                    order.setPointDiscount(point);
                    return 1;
                } catch (NumberFormatException nfe) {
                    ctions.wrInput();
                }
            }
        }
    }

    public boolean makeDecisionToPrintOrder() {
        while (true) {
            System.out.print("Do yout want to print out this bill?\n(Y/N): ");
            String yesNo = sc.nextLine();
            if (yesNo.equalsIgnoreCase("y")) {
                return true;
            } else if (yesNo.equalsIgnoreCase("n")) {
                return false;
            } else {
                ctions.wrInput();
            }
        }
    }

    public void showDraftOrder(Order order, OrderController orderCtr, Store store) {
        System.out.println("");
        System.out.println("-------------------------- YOUR ORDER ------------------------------");
        System.out.println("--------------------------------------------------------------------");
        System.out.format("%-25s %-10s %-15s %-15s\n", "Name", "Quantity", "Price", "Total");
        System.out.format("%-25s %-10s %-15s %-15s\n", "-------------------------", "----------", "---------------", "---------------");
        for (int i = 0; i < order.getList().size(); i++) {
            Goods goods = order.getList().get(i);
            BigDecimal totalQuantity = goodsCtr.getTotalQuanByShipments(goods);
            BigDecimal price = goods.getListPrice();
            BigDecimal totalPrice = totalQuantity.multiply(price);
            System.out.format("%-25s %-10s %-15s %-15s\n", goods.getGoodsName(), totalQuantity + "", price + "", totalPrice + "");
        }
        System.out.println(" ");
        System.out.printf("Total payment: %.1f\n", orderCtr.getSubTotal(order));
        System.out.printf("Total(Taxed: %s): %.1f\n",order.getTax()+"%",  orderCtr.getTotal(order, store));
        System.out.println("--------------------------------------------------------------------");
    }

    public void showBill(Order order, Store store, OrderController orderCtr) {
        String customerID = "";
        if (order.getCustomerCard() != null) {
            customerID = order.getCustomerCard().getID();
        }
        System.out.println("");
        System.out.println("-------------- YOUR BILL ---------------");
        System.out.println("----------------------------------------");
        System.out.println("Store Name: " + store.getName());
        System.out.println("Email: " + store.getEmail());
        System.out.println("Address: " + store.getAddress());
        System.out.println("Phone Number: " + store.getPhoneNumber());
        System.out.println("Date: " + order.getOrderDateTime());
        System.out.println("");
        System.out.format("%-25s %-10s %-15s %-15s\n", "Name", "Quantity", "Price", "Total");
        System.out.format("%-25s %-10s %-15s %-15s\n", "-------------------------", "----------", "---------------", "---------------");
        for (int i = 0; i < order.getList().size(); i++) {
            Goods goods = order.getList().get(i);
            BigDecimal totalQuantity = goodsCtr.getTotalQuanByShipments(goods);
            BigDecimal price = goods.getListPrice();
            BigDecimal totalPrice = totalQuantity.multiply(price);
            System.out.format("%-25s %-10.1f %-15.1f %-15.1f\n", goods.getGoodsName(), totalQuantity, price, totalPrice);
        }
        System.out.printf("SubTotal: %.1f\n", orderCtr.getSubTotal(order));
        System.out.printf("Discount Amount(Discount=%s): %.1f\n", order.getDiscount() + "%", orderCtr.getDiscountAmount(order));
        System.out.printf("Tax(VAT=%s): %.1f\n", store.getVAT() + "%", orderCtr.getTaxAmount(order));
        System.out.println("Payment Option: " + order.getPaymentOptions());
        System.out.println("Member Card ID: " + customerID);
        System.out.printf("Point Discount: %.1f\n", orderCtr.getPointDiscountAmount(order, store));
        System.out.printf("Total: %.1f\n", orderCtr.getTotal(order, store));
        if (order.getPaymentOptions().equals(PaymentOptions.CASH_PAYMENT)) {
            System.out.printf("Customer payment: %.1f\n", order.getCusMoney());
            System.out.printf("Change: %.1f\n", orderCtr.getChange(order, store));
        }
        System.out.println("----------------------------------------");
    }

    public void printBillToFile(Order order, Store store, OrderController orderCtr) {
        try ( PrintWriter pw = new PrintWriter(Files.newBufferedWriter(Path.of(FILE_PRINT),
                StandardOpenOption.CREATE,
                StandardOpenOption.WRITE,
                StandardOpenOption.TRUNCATE_EXISTING))) {
            String customerID = "";
            if (order.getCustomerCard() != null) {
                customerID = order.getCustomerCard().getID();
            }
            pw.println("");
            pw.println("-------------- YOUR BILL ---------------");
            pw.println("----------------------------------------");
            pw.println("Store Name: " + store.getName());
            pw.println("Email: " + store.getEmail());
            pw.println("Address: " + store.getAddress());
            pw.println("Phone Number: " + store.getPhoneNumber());
            pw.println("Date: " + order.getOrderDateTime().format(DateTimeFormatter.ofPattern(DATE_TIME_FORMAT)));
            pw.println("");
            pw.format("%-25s %-10s %-15s %-15s\n", "Name", "Quantity", "Price", "Total");
            pw.format("%-25s %-10s %-15s %-15s\n", "-------------------------", "----------", "---------------", "---------------");
            for (int i = 0; i < order.getList().size(); i++) {
                Goods goods = order.getList().get(i);
                BigDecimal totalQuantity = goodsCtr.getTotalQuanByShipments(goods);
                BigDecimal price = goods.getListPrice();
                BigDecimal totalPrice = totalQuantity.multiply(price);
                pw.format("%-25s %-10.1f %-15.1f %-15.1f\n", goods.getGoodsName(), totalQuantity, price, totalPrice);
            }
            pw.printf("SubTotal: %.1f\n", orderCtr.getSubTotal(order));
            pw.printf("Discount Amount(Discount=%s): %.1f\n", order.getDiscount() + "%", orderCtr.getDiscountAmount(order));
            pw.printf("Tax(VAT=%s): %.1f\n", store.getVAT() + "%", orderCtr.getTaxAmount(order));
            pw.println("Payment Option: " + order.getPaymentOptions());
            pw.println("Member Card ID: " + customerID);
            pw.printf("Point Discount: \n", orderCtr.getPointDiscountAmount(order, store));
            pw.printf("Total: %.1f\n", orderCtr.getTotal(order, store));
            if (order.getPaymentOptions().equals(PaymentOptions.CASH_PAYMENT)) {
                pw.printf("Customer payment: %.1f\n", order.getCusMoney());
                pw.printf("Change: %.1f\n", orderCtr.getChange(order, store));
            }
            pw.println("----------------------------------------");
        } catch (IOException ex) {
            Logger.getLogger(OrderView.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
