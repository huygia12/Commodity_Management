/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package View;

import Models.*;
import Controllers.OrderController;
import Controllers.RepositoryController;
import java.awt.AWTException;
import java.awt.Robot;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;
import java.util.Stack;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author FPTSHOP
 */
public class CommodityManagement {
    static Cautions ctions = new Cautions();
    static final List<Goods> myGoodsList = new ArrayList<>();
    static final Shift detailPerDay = new Shift(new Stack<ImportedGoods>(), new Stack<Order>());
    static Scanner sc = new Scanner(System.in);

    public static void menuOfMainFunction() {
        System.out.println("\n********************************");
        System.out.println("* 1. Repository Management     *");
        System.out.println("* 2. Make New Order            *");
        System.out.println("* 3. Statistics                *");
        System.out.println("* 4. Settings                  *");
        System.out.println("* 5. Exit                      *");
        System.out.println("********************************");
        System.out.print("Option => ");
    }

    public static void main(String[] args) {
        GoodsList repoGoodsList = new GoodsList(myGoodsList);
        RepositoryController repoCtr = new RepositoryController(new Repository(myGoodsList));
        int choice;
        insertInformation();
        do {
            try {
                menuOfMainFunction();
                choice = sc.nextInt();
                sc.nextLine();
                switch (choice) {
                    case 1:
                        repoCtr.repositoryManagement(detailPerDay.getShipmentHistory());
                        break;
                    case 2:
                        Order newOrder = new Order(new ArrayList<>(), String.format("%06d", 
                                detailPerDay.getOrderHistory().size()));
                        OrderController orderCtr = new OrderController(newOrder, repoGoodsList);
                        if (orderCtr.makeNewOrder()) {
                            detailPerDay.getOrderHistory().add(newOrder);
                        }
                        break;
                    case 3:
                        //undeveloped
                        break;
                    case 4:
                        //undeveloped
                        break;
                    case 5:
                        System.out.println("Exiting...");
                        break;
                    default:
                        System.out.println("Wrong input, Please type from 1->4!");
                        break;
                }
            } catch (InputMismatchException ime) {
                ctions.wrInput();
                choice = -1;
                sc.next();
            }
        } while (choice != 5);
    }

    static void insertInformation() {
        myGoodsList.add(new Goods("Custard Cake", "TuyenIndustry", new BigDecimal("3000"), "000000"));
        myGoodsList.add(new Goods("Cup Cake", "TuyenIndustry", new BigDecimal("8000"), "000001"));
        myGoodsList.add(new Goods("Donut", "TuyenIndustry", new BigDecimal("12000"), "000002"));
        myGoodsList.add(new Goods("Flan", "Kem cacao", new BigDecimal("5000"), "000003"));
        myGoodsList.add(new Goods("Strawberry ice-cream", "Kem cacao", new BigDecimal("9000"), "000004"));
        myGoodsList.add(new Goods("Paddle pop", "Kem cacao", new BigDecimal("5000"), "000005"));
        myGoodsList.add(new Goods("Lemon Soda", "Kem cacao", new BigDecimal("8000"), "000006"));
        myGoodsList.add(new Goods("Ruler", "HuyStationery", new BigDecimal("3000"), "000007"));
        myGoodsList.add(new Goods("Pencil", "HuyStationery", new BigDecimal("2000"), "000008"));
        myGoodsList.add(new Goods("Rubber", "HuyStationery", new BigDecimal("2000"), "000009"));
        myGoodsList.add(new Goods("Note", "HuyStationery", new BigDecimal("7000"), "000010"));
        myGoodsList.add(new Goods("Sugar", "CookWithTung", new BigDecimal("22000"), "000011"));
        myGoodsList.add(new Goods("Cooking oil", "CookWithTung", new BigDecimal("48000"), "000012"));
        myGoodsList.add(new Goods("Spring-roll", "CookWithTung", new BigDecimal("50000"), "000013"));
        myGoodsList.add(new Goods("Salt", "CookWithTung", new BigDecimal("5000"), "000014"));
        myGoodsList.add(new Goods("Instant Noodle", "CookWithTung", new BigDecimal("14000"), "000015"));
        myGoodsList.get(0).getShipments().add(new Shipment(new BigDecimal("20"), new BigDecimal("20000"), LocalDate.of(2023, 3, 13), LocalDate.of(2023, 5, 14), "000000"));
        myGoodsList.get(0).getShipments().add(new Shipment(new BigDecimal("40"), new BigDecimal("19000"), LocalDate.of(2023, 3, 15), LocalDate.of(2023, 5, 16), "000001"));
        myGoodsList.get(0).getShipments().add(new Shipment(new BigDecimal("30000"), new BigDecimal("18000"), LocalDate.of(2023, 3, 17), LocalDate.of(2023, 5, 18), "000002"));
        myGoodsList.get(1).getShipments().add(new Shipment(new BigDecimal("50"), new BigDecimal("3000"), LocalDate.of(2023, 3, 13), LocalDate.of(2023, 5, 14), "000000"));
        myGoodsList.get(1).getShipments().add(new Shipment(new BigDecimal("20"), new BigDecimal("4000"), LocalDate.of(2023, 3, 15), LocalDate.of(2023, 5, 16), "000001"));
        myGoodsList.get(1).getShipments().add(new Shipment(new BigDecimal("10"), new BigDecimal("5000"), LocalDate.of(2023, 3, 17), LocalDate.of(2023, 5, 18), "000002"));
        myGoodsList.get(2).getShipments().add(new Shipment(new BigDecimal("35"), new BigDecimal("5000"), LocalDate.of(2023, 3, 13), LocalDate.of(2023, 5, 14), "000000"));
        myGoodsList.get(2).getShipments().add(new Shipment(new BigDecimal("22"), new BigDecimal("6000"), LocalDate.of(2023, 3, 15), LocalDate.of(2023, 5, 16), "000001"));
        myGoodsList.get(2).getShipments().add(new Shipment(new BigDecimal("29"), new BigDecimal("7000"), LocalDate.of(2023, 3, 17), LocalDate.of(2023, 5, 18), "000002"));
        myGoodsList.get(3).getShipments().add(new Shipment(new BigDecimal("50"), new BigDecimal("2500"), LocalDate.of(2023, 3, 13), LocalDate.of(2023, 4, 14), "000000"));
        myGoodsList.get(3).getShipments().add(new Shipment(new BigDecimal("51"), new BigDecimal("2400"), LocalDate.of(2023, 3, 15), LocalDate.of(2023, 4, 16), "000001"));
        myGoodsList.get(3).getShipments().add(new Shipment(new BigDecimal("33"), new BigDecimal("2100"), LocalDate.of(2023, 3, 17), LocalDate.of(2023, 4, 18), "000002"));
        myGoodsList.get(4).getShipments().add(new Shipment(new BigDecimal("56"), new BigDecimal("4500"), LocalDate.of(2023, 3, 13), LocalDate.of(2023, 4, 14), "000000"));
        myGoodsList.get(4).getShipments().add(new Shipment(new BigDecimal("44"), new BigDecimal("4700"), LocalDate.of(2023, 3, 15), LocalDate.of(2023, 4, 16), "000001"));
        myGoodsList.get(4).getShipments().add(new Shipment(new BigDecimal("33"), new BigDecimal("3800"), LocalDate.of(2023, 3, 17), LocalDate.of(2023, 4, 18), "000002"));
        myGoodsList.get(5).getShipments().add(new Shipment(new BigDecimal("22"), new BigDecimal("2500"), LocalDate.of(2023, 3, 13), LocalDate.of(2023, 4, 14), "000000"));
        myGoodsList.get(5).getShipments().add(new Shipment(new BigDecimal("46"), new BigDecimal("2700"), LocalDate.of(2023, 3, 15), LocalDate.of(2023, 4, 16), "000001"));
        myGoodsList.get(5).getShipments().add(new Shipment(new BigDecimal("68"), new BigDecimal("2200"), LocalDate.of(2023, 3, 17), LocalDate.of(2023, 4, 18), "000002"));
        myGoodsList.get(6).getShipments().add(new Shipment(new BigDecimal("42"), new BigDecimal("4000"), LocalDate.of(2023, 3, 13), LocalDate.of(2023, 4, 14), "000000"));
        myGoodsList.get(6).getShipments().add(new Shipment(new BigDecimal("65"), new BigDecimal("4300"), LocalDate.of(2023, 3, 15), LocalDate.of(2023, 4, 16), "000001"));
        myGoodsList.get(6).getShipments().add(new Shipment(new BigDecimal("26"), new BigDecimal("5000"), LocalDate.of(2023, 3, 17), LocalDate.of(2023, 4, 18), "000002"));
        myGoodsList.get(7).getShipments().add(new Shipment(new BigDecimal("33"), new BigDecimal("1000"), LocalDate.of(2023, 3, 13), LocalDate.of(2025, 3, 14), "000000"));
        myGoodsList.get(7).getShipments().add(new Shipment(new BigDecimal("77"), new BigDecimal("1200"), LocalDate.of(2023, 3, 15), LocalDate.of(2025, 3, 16), "000001"));
        myGoodsList.get(7).getShipments().add(new Shipment(new BigDecimal("88"), new BigDecimal("1000"), LocalDate.of(2023, 3, 17), LocalDate.of(2025, 3, 18), "000002"));
        myGoodsList.get(8).getShipments().add(new Shipment(new BigDecimal("13"), new BigDecimal("800"), LocalDate.of(2023, 3, 13), LocalDate.of(2025, 3, 14), "000000"));
        myGoodsList.get(8).getShipments().add(new Shipment(new BigDecimal("16"), new BigDecimal("750"), LocalDate.of(2023, 3, 15), LocalDate.of(2025, 3, 16), "000001"));
        myGoodsList.get(8).getShipments().add(new Shipment(new BigDecimal("44"), new BigDecimal("700"), LocalDate.of(2023, 3, 17), LocalDate.of(2025, 3, 18), "000002"));
        myGoodsList.get(9).getShipments().add(new Shipment(new BigDecimal("15"), new BigDecimal("700"), LocalDate.of(2023, 3, 13), LocalDate.of(2025, 3, 14), "000000"));
        myGoodsList.get(9).getShipments().add(new Shipment(new BigDecimal("17"), new BigDecimal("750"), LocalDate.of(2023, 3, 15), LocalDate.of(2025, 3, 16), "000001"));
        myGoodsList.get(9).getShipments().add(new Shipment(new BigDecimal("44"), new BigDecimal("750"), LocalDate.of(2023, 3, 17), LocalDate.of(2025, 3, 18), "000002"));
        myGoodsList.get(10).getShipments().add(new Shipment(new BigDecimal("42"), new BigDecimal("3000"), LocalDate.of(2023, 3, 13), LocalDate.of(2025, 3, 14), "000000"));
        myGoodsList.get(10).getShipments().add(new Shipment(new BigDecimal("19"), new BigDecimal("3000"), LocalDate.of(2023, 3, 15), LocalDate.of(2025, 3, 16), "000001"));
        myGoodsList.get(10).getShipments().add(new Shipment(new BigDecimal("18"), new BigDecimal("4000"), LocalDate.of(2023, 3, 17), LocalDate.of(2025, 3, 18), "000002"));
        myGoodsList.get(11).getShipments().add(new Shipment(new BigDecimal("15"), new BigDecimal("11000"), LocalDate.of(2023, 3, 13), LocalDate.of(2023, 8, 14), "000000"));
        myGoodsList.get(11).getShipments().add(new Shipment(new BigDecimal("22"), new BigDecimal("11000"), LocalDate.of(2023, 3, 15), LocalDate.of(2023, 8, 16), "000001"));
        myGoodsList.get(11).getShipments().add(new Shipment(new BigDecimal("23"), new BigDecimal("12000"), LocalDate.of(2023, 3, 17), LocalDate.of(2023, 8, 18), "000002"));
        myGoodsList.get(12).getShipments().add(new Shipment(new BigDecimal("32"), new BigDecimal("24000"), LocalDate.of(2023, 3, 13), LocalDate.of(2023, 8, 14), "000000"));
        myGoodsList.get(12).getShipments().add(new Shipment(new BigDecimal("31"), new BigDecimal("24000"), LocalDate.of(2023, 3, 15), LocalDate.of(2023, 8, 16), "000001"));
        myGoodsList.get(12).getShipments().add(new Shipment(new BigDecimal("33"), new BigDecimal("25000"), LocalDate.of(2023, 3, 17), LocalDate.of(2023, 8, 18), "000002"));
        myGoodsList.get(13).getShipments().add(new Shipment(new BigDecimal("35"), new BigDecimal("25000"), LocalDate.of(2023, 3, 13), LocalDate.of(2023, 4, 14), "000000"));
        myGoodsList.get(13).getShipments().add(new Shipment(new BigDecimal("37"), new BigDecimal("25000"), LocalDate.of(2023, 3, 15), LocalDate.of(2023, 4, 16), "000001"));
        myGoodsList.get(13).getShipments().add(new Shipment(new BigDecimal("28"), new BigDecimal("25000"), LocalDate.of(2023, 3, 17), LocalDate.of(2023, 4, 18), "000002"));
        myGoodsList.get(14).getShipments().add(new Shipment(new BigDecimal("43"), new BigDecimal("2000"), LocalDate.of(2023, 3, 13), LocalDate.of(2023, 12, 14), "000000"));
        myGoodsList.get(14).getShipments().add(new Shipment(new BigDecimal("22"), new BigDecimal("2000"), LocalDate.of(2023, 3, 15), LocalDate.of(2023, 12, 16), "000001"));
        myGoodsList.get(14).getShipments().add(new Shipment(new BigDecimal("25"), new BigDecimal("2000"), LocalDate.of(2023, 3, 17), LocalDate.of(2023, 12, 18), "000002"));
        myGoodsList.get(15).getShipments().add(new Shipment(new BigDecimal("23"), new BigDecimal("6500"), LocalDate.of(2023, 3, 13), LocalDate.of(2023, 10, 14), "000000"));
        myGoodsList.get(15).getShipments().add(new Shipment(new BigDecimal("27"), new BigDecimal("6500"), LocalDate.of(2023, 3, 15), LocalDate.of(2023, 10, 16), "000001"));
        myGoodsList.get(15).getShipments().add(new Shipment(new BigDecimal("11"), new BigDecimal("6500"), LocalDate.of(2023, 3, 17), LocalDate.of(2023, 10, 18), "000002"));
    }

    public void clearScreen() {
        try {
            Robot pressbot = new Robot();
            pressbot.keyPress(17); // Holds CTRL key.
            pressbot.keyPress(76); // Holds L key.
            pressbot.keyRelease(17); // Releases CTRL key.
            pressbot.keyRelease(76); // Releases L key.
        } catch (AWTException ex) {
            Logger.getLogger(Logger.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void typeAnyKeyToContinue() {
        System.out.println("\nType any key to continue...");
        sc.nextLine();
    }

}
