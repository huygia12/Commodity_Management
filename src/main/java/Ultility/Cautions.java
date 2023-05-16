/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Ultility;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.List;

/**
 *
 * @author FPTSHOP
 */
public class Cautions {

    public boolean checkIfNoInput(String str) {
        if ("".equalsIgnoreCase(str)) {
            System.out.println("Input is required!");
            return true;
        }
        return false;
    }

    public <E> boolean checkIfListEmpty(List<E> goodsList) {
        if (goodsList.isEmpty()) {
            System.out.println("Cannot process in an empty List!");
            return true;
        }
        return false;
    }

    public<T extends Number> boolean checkIfNumberNegative(T number) {
        BigDecimal numToBigDecimal = new BigDecimal(number+"");
        if (numToBigDecimal.compareTo(BigDecimal.ZERO) < 0) {
            System.out.println("This number cannot take a negative value!");
            return true;
        }
        return false;
    }

    public<T extends Number> boolean checkIfNumberEqualZero(T number) {
        BigDecimal numToBigDecimal = new BigDecimal(number+"");
        if (numToBigDecimal.compareTo(BigDecimal.ZERO) == 0) {
            System.out.println("This number cannot equal zero!");
            return true;
        }
        return false;
    }

    public boolean checkIfANumberSequence(String str) {
        try {
            BigInteger number = new BigInteger(str.trim());
            if (!Cautions.this.checkIfNumberNegative(number)) {
                return true;
            }
        } catch (NumberFormatException nfe) {
            System.out.println("This input must be a number sequence!");
        }
        return false;
    }

    public void wrInput() {
        System.out.println("Invalid input! Please try again.");
    }
}
