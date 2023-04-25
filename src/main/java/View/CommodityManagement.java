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
import java.math.BigInteger;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author FPTSHOP
 */
public class CommodityManagement {
    static Cautions ctions = new Cautions();
    static final List<Goods> myGoodsList = new ArrayList<>();
    static final List<Order> myOrderHistory = new ArrayList<>();
    static Scanner sc = new Scanner(System.in);

    public static void menuOfMainFunction() {
        System.out.println("\n********************************");
        System.out.println("* 1. Repository Management     *");
        System.out.println("* 2. Make New Order            *");
        System.out.println("* 3. Current Revenue Overview  *");
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
                        repoCtr.repositoryManagement();
                        break;
                    case 2:
                        Order newOrder = new Order(new ArrayList<>(), String.format("%06d", myOrderHistory.size()));
                        OrderController orderCtr = new OrderController(newOrder, repoGoodsList);
                        if (orderCtr.makeNewOrder()) {
                            myOrderHistory.add(newOrder);
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
        myGoodsList.add(new Goods("Custard Cake", "TuyenIndustry", new BigInteger("3000"), "000000"));
        myGoodsList.add(new Goods("Cup Cake", "TuyenIndustry", new BigInteger("8000"), "000001"));
        myGoodsList.add(new Goods("Donut", "TuyenIndustry", new BigInteger("12000"), "000002"));
        myGoodsList.add(new Goods("Flan", "Kem cacao", new BigInteger("5000"), "000003"));
        myGoodsList.add(new Goods("Strawberry ice-cream", "Kem cacao", new BigInteger("9000"), "000004"));
        myGoodsList.add(new Goods("Paddle pop", "Kem cacao", new BigInteger("5000"), "000005"));
        myGoodsList.add(new Goods("Lemon Soda", "Kem cacao", new BigInteger("8000"), "000006"));
        myGoodsList.add(new Goods("Ruler", "HuyStationery", new BigInteger("3000"), "000007"));
        myGoodsList.add(new Goods("Pencil", "HuyStationery", new BigInteger("2000"), "000008"));
        myGoodsList.add(new Goods("Rubber", "HuyStationery", new BigInteger("2000"), "000009"));
        myGoodsList.add(new Goods("Note", "HuyStationery", new BigInteger("7000"), "000010"));
        myGoodsList.add(new Goods("Sugar", "CookWithTung", new BigInteger("22000"), "000011"));
        myGoodsList.add(new Goods("Cooking oil", "CookWithTung", new BigInteger("48000"), "000012"));
        myGoodsList.add(new Goods("Spring-roll", "CookWithTung", new BigInteger("50000"), "000013"));
        myGoodsList.add(new Goods("Salt", "CookWithTung", new BigInteger("5000"), "000014"));
        myGoodsList.add(new Goods("Instant Noodle", "CookWithTung", new BigInteger("14000"), "000015"));
        myGoodsList.get(0).getShipments().add(new Shipment(new BigInteger("20"), new BigInteger("20000"), LocalDate.of(2023, 3, 13), LocalDate.of(2023, 5, 14), "000000"));
        myGoodsList.get(0).getShipments().add(new Shipment(new BigInteger("40"), new BigInteger("19000"), LocalDate.of(2023, 3, 15), LocalDate.of(2023, 5, 16), "000001"));
        myGoodsList.get(0).getShipments().add(new Shipment(new BigInteger("30000"), new BigInteger("18000"), LocalDate.of(2023, 3, 17), LocalDate.of(2023, 5, 18), "000002"));
        myGoodsList.get(1).getShipments().add(new Shipment(new BigInteger("50"), new BigInteger("3000"), LocalDate.of(2023, 3, 13), LocalDate.of(2023, 5, 14), "000000"));
        myGoodsList.get(1).getShipments().add(new Shipment(new BigInteger("20"), new BigInteger("4000"), LocalDate.of(2023, 3, 15), LocalDate.of(2023, 5, 16), "000001"));
        myGoodsList.get(1).getShipments().add(new Shipment(new BigInteger("10"), new BigInteger("5000"), LocalDate.of(2023, 3, 17), LocalDate.of(2023, 5, 18), "000002"));
        myGoodsList.get(2).getShipments().add(new Shipment(new BigInteger("35"), new BigInteger("5000"), LocalDate.of(2023, 3, 13), LocalDate.of(2023, 5, 14), "000000"));
        myGoodsList.get(2).getShipments().add(new Shipment(new BigInteger("22"), new BigInteger("6000"), LocalDate.of(2023, 3, 15), LocalDate.of(2023, 5, 16), "000001"));
        myGoodsList.get(2).getShipments().add(new Shipment(new BigInteger("29"), new BigInteger("7000"), LocalDate.of(2023, 3, 17), LocalDate.of(2023, 5, 18), "000002"));
        myGoodsList.get(3).getShipments().add(new Shipment(new BigInteger("50"), new BigInteger("2500"), LocalDate.of(2023, 3, 13), LocalDate.of(2023, 4, 14), "000000"));
        myGoodsList.get(3).getShipments().add(new Shipment(new BigInteger("51"), new BigInteger("2400"), LocalDate.of(2023, 3, 15), LocalDate.of(2023, 4, 16), "000001"));
        myGoodsList.get(3).getShipments().add(new Shipment(new BigInteger("33"), new BigInteger("2100"), LocalDate.of(2023, 3, 17), LocalDate.of(2023, 4, 18), "000002"));
        myGoodsList.get(4).getShipments().add(new Shipment(new BigInteger("56"), new BigInteger("4500"), LocalDate.of(2023, 3, 13), LocalDate.of(2023, 4, 14), "000000"));
        myGoodsList.get(4).getShipments().add(new Shipment(new BigInteger("44"), new BigInteger("4700"), LocalDate.of(2023, 3, 15), LocalDate.of(2023, 4, 16), "000001"));
        myGoodsList.get(4).getShipments().add(new Shipment(new BigInteger("33"), new BigInteger("3800"), LocalDate.of(2023, 3, 17), LocalDate.of(2023, 4, 18), "000002"));
        myGoodsList.get(5).getShipments().add(new Shipment(new BigInteger("22"), new BigInteger("2500"), LocalDate.of(2023, 3, 13), LocalDate.of(2023, 4, 14), "000000"));
        myGoodsList.get(5).getShipments().add(new Shipment(new BigInteger("46"), new BigInteger("2700"), LocalDate.of(2023, 3, 15), LocalDate.of(2023, 4, 16), "000001"));
        myGoodsList.get(5).getShipments().add(new Shipment(new BigInteger("68"), new BigInteger("2200"), LocalDate.of(2023, 3, 17), LocalDate.of(2023, 4, 18), "000002"));
        myGoodsList.get(6).getShipments().add(new Shipment(new BigInteger("42"), new BigInteger("4000"), LocalDate.of(2023, 3, 13), LocalDate.of(2023, 4, 14), "000000"));
        myGoodsList.get(6).getShipments().add(new Shipment(new BigInteger("65"), new BigInteger("4300"), LocalDate.of(2023, 3, 15), LocalDate.of(2023, 4, 16), "000001"));
        myGoodsList.get(6).getShipments().add(new Shipment(new BigInteger("26"), new BigInteger("5000"), LocalDate.of(2023, 3, 17), LocalDate.of(2023, 4, 18), "000002"));
        myGoodsList.get(7).getShipments().add(new Shipment(new BigInteger("33"), new BigInteger("1000"), LocalDate.of(2023, 3, 13), LocalDate.of(2025, 3, 14), "000000"));
        myGoodsList.get(7).getShipments().add(new Shipment(new BigInteger("77"), new BigInteger("1200"), LocalDate.of(2023, 3, 15), LocalDate.of(2025, 3, 16), "000001"));
        myGoodsList.get(7).getShipments().add(new Shipment(new BigInteger("88"), new BigInteger("1000"), LocalDate.of(2023, 3, 17), LocalDate.of(2025, 3, 18), "000002"));
        myGoodsList.get(8).getShipments().add(new Shipment(new BigInteger("13"), new BigInteger("800"), LocalDate.of(2023, 3, 13), LocalDate.of(2025, 3, 14), "000000"));
        myGoodsList.get(8).getShipments().add(new Shipment(new BigInteger("16"), new BigInteger("750"), LocalDate.of(2023, 3, 15), LocalDate.of(2025, 3, 16), "000001"));
        myGoodsList.get(8).getShipments().add(new Shipment(new BigInteger("44"), new BigInteger("700"), LocalDate.of(2023, 3, 17), LocalDate.of(2025, 3, 18), "000002"));
        myGoodsList.get(9).getShipments().add(new Shipment(new BigInteger("15"), new BigInteger("700"), LocalDate.of(2023, 3, 13), LocalDate.of(2025, 3, 14), "000000"));
        myGoodsList.get(9).getShipments().add(new Shipment(new BigInteger("17"), new BigInteger("750"), LocalDate.of(2023, 3, 15), LocalDate.of(2025, 3, 16), "000001"));
        myGoodsList.get(9).getShipments().add(new Shipment(new BigInteger("44"), new BigInteger("750"), LocalDate.of(2023, 3, 17), LocalDate.of(2025, 3, 18), "000002"));
        myGoodsList.get(10).getShipments().add(new Shipment(new BigInteger("42"), new BigInteger("3000"), LocalDate.of(2023, 3, 13), LocalDate.of(2025, 3, 14), "000000"));
        myGoodsList.get(10).getShipments().add(new Shipment(new BigInteger("19"), new BigInteger("3000"), LocalDate.of(2023, 3, 15), LocalDate.of(2025, 3, 16), "000001"));
        myGoodsList.get(10).getShipments().add(new Shipment(new BigInteger("18"), new BigInteger("4000"), LocalDate.of(2023, 3, 17), LocalDate.of(2025, 3, 18), "000002"));
        myGoodsList.get(11).getShipments().add(new Shipment(new BigInteger("15"), new BigInteger("11000"), LocalDate.of(2023, 3, 13), LocalDate.of(2023, 8, 14), "000000"));
        myGoodsList.get(11).getShipments().add(new Shipment(new BigInteger("22"), new BigInteger("11000"), LocalDate.of(2023, 3, 15), LocalDate.of(2023, 8, 16), "000001"));
        myGoodsList.get(11).getShipments().add(new Shipment(new BigInteger("23"), new BigInteger("12000"), LocalDate.of(2023, 3, 17), LocalDate.of(2023, 8, 18), "000002"));
        myGoodsList.get(12).getShipments().add(new Shipment(new BigInteger("32"), new BigInteger("24000"), LocalDate.of(2023, 3, 13), LocalDate.of(2023, 8, 14), "000000"));
        myGoodsList.get(12).getShipments().add(new Shipment(new BigInteger("31"), new BigInteger("24000"), LocalDate.of(2023, 3, 15), LocalDate.of(2023, 8, 16), "000001"));
        myGoodsList.get(12).getShipments().add(new Shipment(new BigInteger("33"), new BigInteger("25000"), LocalDate.of(2023, 3, 17), LocalDate.of(2023, 8, 18), "000002"));
        myGoodsList.get(13).getShipments().add(new Shipment(new BigInteger("35"), new BigInteger("25000"), LocalDate.of(2023, 3, 13), LocalDate.of(2023, 4, 14), "000000"));
        myGoodsList.get(13).getShipments().add(new Shipment(new BigInteger("37"), new BigInteger("25000"), LocalDate.of(2023, 3, 15), LocalDate.of(2023, 4, 16), "000001"));
        myGoodsList.get(13).getShipments().add(new Shipment(new BigInteger("28"), new BigInteger("25000"), LocalDate.of(2023, 3, 17), LocalDate.of(2023, 4, 18), "000002"));
        myGoodsList.get(14).getShipments().add(new Shipment(new BigInteger("43"), new BigInteger("2000"), LocalDate.of(2023, 3, 13), LocalDate.of(2023, 12, 14), "000000"));
        myGoodsList.get(14).getShipments().add(new Shipment(new BigInteger("22"), new BigInteger("2000"), LocalDate.of(2023, 3, 15), LocalDate.of(2023, 12, 16), "000001"));
        myGoodsList.get(14).getShipments().add(new Shipment(new BigInteger("25"), new BigInteger("2000"), LocalDate.of(2023, 3, 17), LocalDate.of(2023, 12, 18), "000002"));
        myGoodsList.get(15).getShipments().add(new Shipment(new BigInteger("23"), new BigInteger("6500"), LocalDate.of(2023, 3, 13), LocalDate.of(2023, 10, 14), "000000"));
        myGoodsList.get(15).getShipments().add(new Shipment(new BigInteger("27"), new BigInteger("6500"), LocalDate.of(2023, 3, 15), LocalDate.of(2023, 10, 16), "000001"));
        myGoodsList.get(15).getShipments().add(new Shipment(new BigInteger("11"), new BigInteger("6500"), LocalDate.of(2023, 3, 17), LocalDate.of(2023, 10, 18), "000002"));
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
