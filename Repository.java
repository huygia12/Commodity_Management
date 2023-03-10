/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package JavaProject;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 *
 * @author s1rja
 */
public class Repository {

    List<Goods> goods = new ArrayList<>();
    Scanner sc = new Scanner(System.in);

    public void addNewGoods() {
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

        goods.add(good);
        good.setGoodsID(String.format("%06d", goods.indexOf(good)));
    }

    public void importGoods() {

    }

    public void deleteAGoods() {

    }
}
