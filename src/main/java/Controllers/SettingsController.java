/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controllers;

import util.Cautions;
import Ultility.CustomPair;
import java.math.BigDecimal;

/**
 *
 * @author FPTSHOP
 */
public class SettingsController {

    final BigDecimal BIG_NUMBER = new BigDecimal("100000000000000000000");
    final Cautions ctions = new Cautions();

    public SettingsController() {
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
