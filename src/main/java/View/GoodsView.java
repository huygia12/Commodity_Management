/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package View;

import Models.Goods;
import Models.GoodsList;
import java.math.BigDecimal;
import java.util.Scanner;

/**
 *
 * @author FPTSHOP
 */
public class GoodsView {

    Cautions ctions = new Cautions();
    Scanner sc = new Scanner(System.in);

    public int typeInManufac(Goods goods, GoodsList goodsList) {
        while (true) {
            System.out.print("Type in manufacturer or type EXIT/BACK to go exit/back: ");
            String inputStr = sc.nextLine();
            if ("exit".equalsIgnoreCase(inputStr)) {
                return 0;
            } else if ("back".equalsIgnoreCase(inputStr)) {
                return -1;
            } else if (ctions.checkIfNoInput(inputStr)) {
            }else {
                goods.setManufacture(inputStr);
                return 1;
            }
        }
    }

    public int typeInName(Goods goods) {
        while (true) {
            System.out.print("Type in name or type EXIT/BACK to exit/back: ");
            String inputStr = sc.nextLine();
            if ("exit".equalsIgnoreCase(inputStr)) {
                return 0;
            } else if ("back".equalsIgnoreCase(inputStr)) {
                return -1;
            } else if (ctions.checkIfNoInput(inputStr)) {
            } else {
                goods.setGoodsName(inputStr);
                return 1;
            }
        }
    }

    public int typeInListPrice(Goods goods) {
        while (true) {
            System.out.print("Type in listed price or type EXIT/BACK to go exit/back: ");
            String inputStr = sc.nextLine();
            if ("exit".equalsIgnoreCase(inputStr)) {
                return 0;
            } else if ("back".equalsIgnoreCase(inputStr)) {
                return -1;
            } else if (ctions.checkIfNoInput(inputStr)) {
            } else {
                try {
                    BigDecimal listPrice = new BigDecimal(inputStr);
                    if (!ctions.checkIfBigIntPositive(listPrice)) {
                        continue;
                    }
                    goods.setListPrice(listPrice);
                    return 1;
                } catch (NumberFormatException nfe) {
                    ctions.wrInput();
                }
            }
        }
    }

}
