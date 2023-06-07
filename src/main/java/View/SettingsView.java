/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package View;

import Models.Settings;
import Ultility.Cautions;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Scanner;

/**
 *
 * @author FPTSHOP
 */
public class SettingsView {

    final Scanner sc = new Scanner(System.in);
    final Cautions ctions = new Cautions();
    public void menuOfSettings() {
        System.out.print("""
                           \n************SETTINGS************
                           * 1. Show Store Information    *
                           * 2. Change Store Information  *
                           * 3. Points Exchange Mechanism *
                           * 4. Back                      *
                           ********************************
                           Options => """);
    }

    public void menuOfPointsExchangeMechanism() {
        System.out.print("""
                           \n**************POINTS_EXCHANGE_MECHANISM**************
                           * 1. Set amount to exchange for 1 Point             *
                           * 2. Set amount of Points to exchange for 1000 VND  *
                           * 3. Back                                           *
                           *****************************************************
                           Options => """);
    }

    public int typeInAmountForOnePoint(Settings settings) {
        System.out.printf("The Current amount(VND) to exchange for 1 Point: %.1f\n", 
                settings.getStore().getAmountForOnePoint());
        while (true) {
            System.out.print("Type in amount(VND) or type BACK to go back: ");
            String input = sc.nextLine().trim();
            try {
                BigDecimal amountForOnePoint = new BigDecimal(input);
                settings.getStore().setAmountForOnePoint(amountForOnePoint);
                return 1;
            } catch (NumberFormatException nfe) {
                if (input.equalsIgnoreCase("back")) {
                    return -1;
                } else if(ctions.checkIfNoInput(input)) {
                }else{
                    ctions.wrInput();
                }
            }
        }
    }

    public int typeInPointsForOneVND(Settings settings) {
        System.out.printf("The Current number of points to exchange for 1000VND: %s\n", 
                settings.getStore().getPointsForOneVNDIn());
        while (true) {
            System.out.print("Type in the number of points or type BACK to go back: ");
            String input = sc.nextLine().trim();
            try {
                BigInteger amountForOnePoint = new BigInteger(input);
                settings.getStore().setPointsForOneVNDIn(amountForOnePoint);
                return 1;
            } catch (NumberFormatException nfe) {
                if (input.equalsIgnoreCase("back")) {
                    return -1;
                } else if(ctions.checkIfNoInput(input)) {
                }else{
                    ctions.wrInput();
                }
            }
        }
    }
}
