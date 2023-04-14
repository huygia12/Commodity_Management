/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.sourcecode;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

/**
 *
 * @author FPTSHOP
 */
public class CommodityManagement {

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

    public static void main(String[] args) {
        List<Goods> myGoodsList = new ArrayList<>();
        List<Order> myOrderHistory = new ArrayList<>();
        Repository myRepository = new Repository(myGoodsList);
        //UsefulFunctions uf = new UsefulFunctions();
        String choice;
        do {
            menuOfMainFunction();
            choice = sc.nextLine().trim();
            //uf.clearScreen();
            //sc.nextLine();
            switch (choice) {
                case "1":
                    myRepository.repositoryManagement();
                    //uf.clearScreen();
                    break;
                case "2":
                    Order order = new Order(myGoodsList);
                    order.makeNewOrder();
                    myOrderHistory.add(order);
                    break;
                case "3":
                    //undeveloped
                    break;
                case "4":
                    System.out.println("Exiting...");
                    break;
                default:
                    System.out.println("Wrong input, Please type from 1->4!");
                    break;
            }

        } while (!choice.equals("4"));
    }
}
