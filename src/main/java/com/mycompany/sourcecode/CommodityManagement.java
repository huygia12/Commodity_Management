package com.mycompany.sourcecode;

import java.util.InputMismatchException;
import java.util.Scanner;

public class CommodityManagement {

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
        Scanner sc = new Scanner(System.in);
        Repository myRepository = new Repository();
        int choice;
        do {
            try {
                menuOfMainFunction();
                choice = sc.nextInt();
                switch (choice) {
                    case 1:
                        myRepository.repositoryManagement();
                        break;
                    case 2:
                        Order order = new Order(myRepository);
                        order.makeNewOrder();
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
                System.out.println("Wrong input!");
                choice = -1;
                sc.next();
            }
        } while (choice != 4);
        sc.close();
    }
}
