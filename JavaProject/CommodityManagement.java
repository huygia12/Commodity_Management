package JavaProject;

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
        Repository goodsList = new Repository();
        int choice;
        do {
            try {
                menuOfMainFunction();
                choice = sc.nextInt();
                switch (choice) {
                    case 1:
                        goodsList.repositoryManagement();
                        break;
                    case 2:
                        Order order = new Order();
                        order.makeNewOrder();
                        break;
                    case 3:
                        
                        break;
                    case 4:
                        System.out.println("Exiting...");
                        break;
                }
            } catch (InputMismatchException ime) {
                System.out.println("Wrong input! Please type form 1->4!");
                choice = -1;
            }
        } while (choice != 4);
    }
}
