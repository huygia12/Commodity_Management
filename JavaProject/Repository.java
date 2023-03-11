/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package JavaProject;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

/**
 *
 * @author s1rja
 */
public class Repository {

    List<Goods> goodsList = new ArrayList<>();
    Scanner sc = new Scanner(System.in);

    public void showRepository(List<Goods> goodsList) {
        // Chi
    }

    public void searchGoods() {
        // Tuyen
    }

    private void menuOfRepoManagement() {
        System.out.println("\n********************************");
        System.out.println("* 1. Add New Goods             *");
        System.out.println("* 2. Import Goods              *");
        System.out.println("* 3. Change Goods Infor        *");
        System.out.println("* 4. Delete Goods              *");
        System.out.println("* 5. Show Repository           *");
        System.out.println("* 6. Make a filter             *");
        System.out.println("* 7. Back                      *");
        System.out.println("********************************");
        System.out.print("Option => ");
    }

    private void addNewGoods() {
        sc.nextLine();
        Goods good = new Goods();
        int n = 1;
        String input;
        while (n != 3) {
            switch (n) {
                case 1:
                    System.out.print("Input product name or type EXIT to exit: ");
                    input = sc.nextLine();
                    if (input.equalsIgnoreCase("exit")) {
                        return;
                    } else {
                        good.setGoodsName(input);
                    }
                case 2:
                    System.out.print("Input product manufacturer or type BACK/EXIT to go back/exit: ");
                    input = sc.nextLine();
                    if (input.equalsIgnoreCase("exit")) {
                        return;
                    } else if (input.equalsIgnoreCase("back")) {
                        continue;
                    } else {
                        good.setProvider(input);
                    }
                case 3:
                    n = 2;
                    boolean completed = false;
                    boolean chooseBack = false;
                    while (!completed) {
                        System.out.print("Input listed price or type BACK/EXIT to go back/exit: ");
                        input = sc.nextLine();
                        if (input.equalsIgnoreCase("exit")) {
                            return;
                        } else if (input.equalsIgnoreCase("back")) {
                            chooseBack = true;
                            break;
                        } else {
                            try {
                                int listPrice = Integer.parseInt(input);
                                good.setListPrice(listPrice);
                                completed = true;
                            } catch (NumberFormatException nfe) {
                                System.out.println("Wrong input!");
                            }
                        }
                    }
                    if (chooseBack) {
                        continue;
                    }
                    n = 3;
            }
        }

        goodsList.add(good);
        good.setGoodsID(String.format("%06d", goodsList.indexOf(good)));
    }

    private void importGoods() {
        // Huy
        sc.nextLine();
    }

    private void deleteAGoods() {
        // Huy
    }

    public void repositoryManagement() {
        // Huy
        int choice;
        do {
            try {
                menuOfRepoManagement();
                choice = sc.nextInt();
                switch (choice) {
                    case 1:
                        addNewGoods();
                        break;
                    case 2:
                        importGoods();
                        break;
                    case 3:

                        break;
                    case 4:
                        deleteAGoods();
                        break;
                    case 5:
                        showRepository(goodsList);
                        break;
                    case 6:

                        break;
                    case 7:
                        System.out.println("Back...");
                        break;
                }
            } catch (InputMismatchException ime) {
                System.out.println("Wrong input, Please type from 1->7!");
                choice = -1;
            }
        } while (choice != 7);
    }
}
