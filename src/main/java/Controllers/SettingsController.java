/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controllers;

import Models.Settings;
import Models.Shift;
import Ultility.Cautions;
import Ultility.CustomPair;
import View.SettingsView;
import java.math.BigDecimal;
import java.util.Scanner;

/**
 *
 * @author FPTSHOP
 */
public class SettingsController {

    private final SettingsView settingsView = new SettingsView();
    final BigDecimal BIG_NUMBER = new BigDecimal("100000000000000000000");
    final Cautions ctions = new Cautions();
    final Scanner sc = new Scanner(System.in);
    final StoreController storeCtr = new StoreController();

    public SettingsController() {
    }

    public SettingsView getSettingsView() {
        return this.settingsView;
    }

    public void settingsManagement(Shift currentShift, Settings settings) {
        String choice;
        do {
            this.settingsView.menuOfSettings();
            choice = sc.nextLine();
            switch (choice) {
                case "1":
                    storeCtr.getStoreView().showStoreInfor(settings.getStore());
                    break;
                case "2":
                    storeCtr.setStoreInfor(currentShift, settings.getStore());
                    break;
                case "3":
                    pointsExchangeMechanism(settings);
                    break;
                case "4":
                    break;
                default:
                    System.out.println("Wrong input, Please type from 1->4!");
                    break;
            }
        } while (!choice.equalsIgnoreCase("4"));
    }

    private void pointsExchangeMechanism(Settings settings) {
        String choice;
        do {
            this.settingsView.menuOfPointsExchangeMechanism();
            choice = sc.nextLine();
            switch (choice) {
                case "1":
                    this.settingsView.typeInAmountForOnePoint(settings);
                    break;
                case "2":
                    this.settingsView.typeInPointsForOneVND(settings);
                    break;
                case "3":
                    break;
                default:
                    System.out.println("Wrong input, Please type from 1->3!");
                    break;
            }
        } while (!choice.equalsIgnoreCase("3"));
    }

    public CustomPair<BigDecimal, BigDecimal> convertFromComparisonOperatorToRange(String comparisonOperator) {
        if (!comparisonOperator.contains(">")
                && !comparisonOperator.contains("=")
                && !comparisonOperator.contains("<")
                && !comparisonOperator.contains("-")) {
            return null;
        }
        String[] arrStr = comparisonOperator.split(" ");
        int length = arrStr.length;
        CustomPair<BigDecimal, BigDecimal> range = null;
        if (length == 2) {
            if (ctions.checkIfANumberSequenceForGUI(arrStr[1])) {
                switch (arrStr[0]) {
                    case ">":
                        range = new CustomPair<>(new BigDecimal(arrStr[1]), BIG_NUMBER);
                        break;
                    case "<":
                        range = new CustomPair<>(BigDecimal.ZERO, new BigDecimal(arrStr[1]));
                        break;
                    case "=":
                        range = new CustomPair<>(new BigDecimal(arrStr[1]), new BigDecimal(arrStr[1]));
                        break;
                    case ">=":
                        range = new CustomPair<>(new BigDecimal(arrStr[1]).subtract(BigDecimal.ONE), BIG_NUMBER);
                        break;
                    case "<=":
                        range = new CustomPair<>(BigDecimal.ZERO, new BigDecimal(arrStr[1]).add(BigDecimal.ONE));
                        break;
                    default:
                        break;
                }
            }
        } else if (length == 3) {
            if (ctions.checkIfANumberSequenceForGUI(arrStr[0]) 
                    && ctions.checkIfANumberSequenceForGUI(arrStr[2]) 
                    && arrStr[1].equals("-")) {
                BigDecimal n1 = new BigDecimal(arrStr[0]);
                BigDecimal n2 = new BigDecimal(arrStr[2]);
                if(n1.compareTo(n2)<=0){
                    range = new CustomPair<>(n1, n2);
                }
            }
        }
        return range;
    }
}
