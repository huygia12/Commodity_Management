/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controllers;

import java.lang.instrument.UnmodifiableClassException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collections;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

/**
 *
 * @author FPTSHOP
 */
public class CommodityManagement {

    static final List<Goods> myGoodsList = new ArrayList<>();
    static final List<Order> myOrderHistory = new ArrayList<>();
    static final UsefulFunctions uf = new UsefulFunctions();
    static Scanner sc = new Scanner(System.in);

    public static void menuOfMainFunction() {
        System.out.println("\n********************************");
        System.out.println("* 1. Repository Management     *");
        System.out.println("* 2. Make New Order            *");
        System.out.println("* 3. Current Revenue Overview  *");
        System.out.println("* 4. Exit                      *");
        System.out.println("********************************");
        System.out.print("Option => ");
    }

    public static void reloadGoodsList(List<Goods> orderGoodsList) {
        // reload list after make an order
        for (Goods orderGoods : orderGoodsList) {
            Goods repoGoods = uf.containGoods(orderGoods.getGoodsID(), myGoodsList);
            for (Shipment orderShipment : orderGoods.getShipments()) {
                Shipment repoShipment = repoGoods.containShipment(orderShipment.getShipmentID());
                int quanBefore = repoShipment.getQuantity();
                repoShipment.setQuantity(quanBefore - orderShipment.getQuantity());
            }
        }
    }

    public static void main(String[] args) {
        Repository myRepository = new Repository(myGoodsList);
        //UsefulFunctions uf = new UsefulFunctions();
        int choice;
        add();
        do {
            try {
                menuOfMainFunction();
                choice = sc.nextInt();
                //uf.clearScreen();
                sc.nextLine();
                switch (choice) {
                    case 1:
                        myRepository.repositoryManagement();
                        //uf.clearScreen();
                        break;
                    case 2:
                        // not done yet
                        List<Goods> readOnlyGoodsList = Collections.unmodifiableList(myGoodsList);
                        Order order = new Order(readOnlyGoodsList,
                                String.format("%06d", myOrderHistory.size()));
                        List<Goods> orderGoodsList = order.makeNewOrder();
                        myOrderHistory.add(order);
                        reloadGoodsList(orderGoodsList);
                        break;
                    case 3:
                        //undeveloped
                        break;
                    case 4:
                        System.out.println("Exiting...");
                        break;
                    default:
                        System.out.println("Wrong input, Please type from 1->4!");
                        break;
                }
            } catch (InputMismatchException ime) {
                uf.wrInput();
                choice = -1;
                sc.next();
            }
        } while (choice != 4);
    }

    static void add() {
        myGoodsList.add(new Goods("Custard Cake", "TuyenIndustry", 30000, "000000"));
        myGoodsList.add(new Goods("Cup Cake", "TuyenIndustry", 8000, "000001"));
        myGoodsList.add(new Goods("Donut", "TuyenIndustry", 12000, "000002"));
        myGoodsList.add(new Goods("Flan", "Kem cacao", 5000, "000003"));
        myGoodsList.add(new Goods("Strawberry ice-cream", "Kem cacao", 9000, "000004"));
        myGoodsList.add(new Goods("Paddle pop", "Kem cacao", 5000, "000005"));
        myGoodsList.add(new Goods("Lemon Soda", "Kem cacao", 8000, "000006"));
        myGoodsList.add(new Goods("Ruler", "HuyStationery", 3000, "000007"));
        myGoodsList.add(new Goods("Pencil", "HuyStationery", 2000, "000008"));
        myGoodsList.add(new Goods("Rubber", "HuyStationery", 2000, "000009"));
        myGoodsList.add(new Goods("Note", "HuyStationery", 7000, "000010"));
        myGoodsList.add(new Goods("Sugar", "CookWithTung", 22000, "000011"));
        myGoodsList.add(new Goods("Cooking oil", "CookWithTung", 48000, "000012"));
        myGoodsList.add(new Goods("Spring-roll", "CookWithTung", 50000, "000013"));
        myGoodsList.add(new Goods("Salt", "CookWithTung", 5000, "000014"));
        myGoodsList.add(new Goods("Instant Noodle", "CookWithTung", 14000, "000015"));
        myGoodsList.get(0).getShipments().add(new Shipment(20, 20000, LocalDate.of(2023, 3, 13), LocalDate.of(2023, 5, 14), "000000"));
        myGoodsList.get(0).getShipments().add(new Shipment(40, 19000, LocalDate.of(2023, 3, 15), LocalDate.of(2023, 5, 16), "000001"));
        myGoodsList.get(0).getShipments().add(new Shipment(30, 18000, LocalDate.of(2023, 3, 17), LocalDate.of(2023, 5, 18), "000002"));
        myGoodsList.get(1).getShipments().add(new Shipment(50, 3000, LocalDate.of(2023, 3, 13), LocalDate.of(2023, 5, 14), "000000"));
        myGoodsList.get(1).getShipments().add(new Shipment(20, 4000, LocalDate.of(2023, 3, 15), LocalDate.of(2023, 5, 16), "000001"));
        myGoodsList.get(1).getShipments().add(new Shipment(10, 5000, LocalDate.of(2023, 3, 17), LocalDate.of(2023, 5, 18), "000002"));
        myGoodsList.get(2).getShipments().add(new Shipment(35, 5000, LocalDate.of(2023, 3, 13), LocalDate.of(2023, 5, 14), "000000"));
        myGoodsList.get(2).getShipments().add(new Shipment(22, 6000, LocalDate.of(2023, 3, 15), LocalDate.of(2023, 5, 16), "000001"));
        myGoodsList.get(2).getShipments().add(new Shipment(29, 7000, LocalDate.of(2023, 3, 17), LocalDate.of(2023, 5, 18), "000002"));
        myGoodsList.get(3).getShipments().add(new Shipment(50, 2500, LocalDate.of(2023, 3, 13), LocalDate.of(2023, 4, 14), "000000"));
        myGoodsList.get(3).getShipments().add(new Shipment(51, 2400, LocalDate.of(2023, 3, 15), LocalDate.of(2023, 4, 16), "000001"));
        myGoodsList.get(3).getShipments().add(new Shipment(33, 2100, LocalDate.of(2023, 3, 17), LocalDate.of(2023, 4, 18), "000002"));
        myGoodsList.get(4).getShipments().add(new Shipment(56, 4500, LocalDate.of(2023, 3, 13), LocalDate.of(2023, 4, 14), "000000"));
        myGoodsList.get(4).getShipments().add(new Shipment(44, 4700, LocalDate.of(2023, 3, 15), LocalDate.of(2023, 4, 16), "000001"));
        myGoodsList.get(4).getShipments().add(new Shipment(33, 3800, LocalDate.of(2023, 3, 17), LocalDate.of(2023, 4, 18), "000002"));
        myGoodsList.get(5).getShipments().add(new Shipment(22, 2500, LocalDate.of(2023, 3, 13), LocalDate.of(2023, 4, 14), "000000"));
        myGoodsList.get(5).getShipments().add(new Shipment(46, 2700, LocalDate.of(2023, 3, 15), LocalDate.of(2023, 4, 16), "000001"));
        myGoodsList.get(5).getShipments().add(new Shipment(68, 2200, LocalDate.of(2023, 3, 17), LocalDate.of(2023, 4, 18), "000002"));
        myGoodsList.get(6).getShipments().add(new Shipment(42, 4000, LocalDate.of(2023, 3, 13), LocalDate.of(2023, 4, 14), "000000"));
        myGoodsList.get(6).getShipments().add(new Shipment(65, 4300, LocalDate.of(2023, 3, 15), LocalDate.of(2023, 4, 16), "000001"));
        myGoodsList.get(6).getShipments().add(new Shipment(26, 5000, LocalDate.of(2023, 3, 17), LocalDate.of(2023, 4, 18), "000002"));
        myGoodsList.get(7).getShipments().add(new Shipment(33, 1000, LocalDate.of(2023, 3, 13), LocalDate.of(2025, 3, 14), "000000"));
        myGoodsList.get(7).getShipments().add(new Shipment(77, 1200, LocalDate.of(2023, 3, 15), LocalDate.of(2025, 3, 16), "000001"));
        myGoodsList.get(7).getShipments().add(new Shipment(88, 1000, LocalDate.of(2023, 3, 17), LocalDate.of(2025, 3, 18), "000002"));
        myGoodsList.get(8).getShipments().add(new Shipment(13, 800, LocalDate.of(2023, 3, 13), LocalDate.of(2025, 3, 14), "000000"));
        myGoodsList.get(8).getShipments().add(new Shipment(16, 750, LocalDate.of(2023, 3, 15), LocalDate.of(2025, 3, 16), "000001"));
        myGoodsList.get(8).getShipments().add(new Shipment(44, 750, LocalDate.of(2023, 3, 17), LocalDate.of(2025, 3, 18), "000002"));
        myGoodsList.get(9).getShipments().add(new Shipment(15, 700, LocalDate.of(2023, 3, 13), LocalDate.of(2025, 3, 14), "000000"));
        myGoodsList.get(9).getShipments().add(new Shipment(17, 750, LocalDate.of(2023, 3, 15), LocalDate.of(2025, 3, 16), "000001"));
        myGoodsList.get(9).getShipments().add(new Shipment(44, 750, LocalDate.of(2023, 3, 17), LocalDate.of(2025, 3, 18), "000002"));
        myGoodsList.get(10).getShipments().add(new Shipment(42, 3000, LocalDate.of(2023, 3, 13), LocalDate.of(2025, 3, 14), "000000"));
        myGoodsList.get(10).getShipments().add(new Shipment(19, 3000, LocalDate.of(2023, 3, 15), LocalDate.of(2025, 3, 16), "000001"));
        myGoodsList.get(10).getShipments().add(new Shipment(18, 4000, LocalDate.of(2023, 3, 17), LocalDate.of(2025, 3, 18), "000002"));
        myGoodsList.get(11).getShipments().add(new Shipment(15, 11000, LocalDate.of(2023, 3, 13), LocalDate.of(2023, 8, 14), "000000"));
        myGoodsList.get(11).getShipments().add(new Shipment(22, 11000, LocalDate.of(2023, 3, 15), LocalDate.of(2023, 8, 16), "000001"));
        myGoodsList.get(11).getShipments().add(new Shipment(23, 12000, LocalDate.of(2023, 3, 17), LocalDate.of(2023, 8, 18), "000002"));
        myGoodsList.get(12).getShipments().add(new Shipment(32, 24000, LocalDate.of(2023, 3, 13), LocalDate.of(2023, 8, 14), "000000"));
        myGoodsList.get(12).getShipments().add(new Shipment(31, 24000, LocalDate.of(2023, 3, 15), LocalDate.of(2023, 8, 16), "000001"));
        myGoodsList.get(12).getShipments().add(new Shipment(33, 25000, LocalDate.of(2023, 3, 17), LocalDate.of(2023, 8, 18), "000002"));
        myGoodsList.get(13).getShipments().add(new Shipment(35, 25000, LocalDate.of(2023, 3, 13), LocalDate.of(2023, 4, 14), "000000"));
        myGoodsList.get(13).getShipments().add(new Shipment(37, 25000, LocalDate.of(2023, 3, 15), LocalDate.of(2023, 4, 16), "000001"));
        myGoodsList.get(13).getShipments().add(new Shipment(28, 25000, LocalDate.of(2023, 3, 17), LocalDate.of(2023, 4, 18), "000002"));
        myGoodsList.get(14).getShipments().add(new Shipment(43, 2000, LocalDate.of(2023, 3, 13), LocalDate.of(2023, 12, 14), "000000"));
        myGoodsList.get(14).getShipments().add(new Shipment(22, 2000, LocalDate.of(2023, 3, 15), LocalDate.of(2023, 12, 16), "000001"));
        myGoodsList.get(14).getShipments().add(new Shipment(25, 2000, LocalDate.of(2023, 3, 17), LocalDate.of(2023, 12, 18), "000002"));
        myGoodsList.get(15).getShipments().add(new Shipment(23, 6500, LocalDate.of(2023, 3, 13), LocalDate.of(2023, 10, 14), "000000"));
        myGoodsList.get(15).getShipments().add(new Shipment(27, 6500, LocalDate.of(2023, 3, 15), LocalDate.of(2023, 10, 16), "000001"));
        myGoodsList.get(15).getShipments().add(new Shipment(11, 6500, LocalDate.of(2023, 3, 17), LocalDate.of(2023, 10, 18), "000002"));
    }
}
