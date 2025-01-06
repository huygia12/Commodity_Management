/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package util;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.time.DateTimeException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;

/**
 *
 * @author FPTSHOP
 */
class Cautions {

    final String INPUT_DATE_PATTERN = "d/M/y";

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

    public <T extends Number> boolean checkIfNumberNegative(T number) {
        BigDecimal numToBigDecimal = new BigDecimal(number + "");
        if (numToBigDecimal.compareTo(BigDecimal.ZERO) < 0) {
            System.out.println("This number cannot take a negative value!");
            return true;
        }
        return false;
    }

    public <T extends Number> boolean checkIfNumberEqualZero(T number) {
        BigDecimal numToBigDecimal = new BigDecimal(number + "");
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

    public boolean checkIfANumberSequenceForGUI(String str) {
        try {
            BigInteger number = new BigInteger(str.trim());
            if (!Cautions.this.checkIfNumberNegativeForGUI(number)) {
                return true;
            }
        } catch (NumberFormatException nfe) {
        }
        return false;
    }
    
    public boolean checkIfAValidNumberForGUI(String str) {
        try {
            BigDecimal number = new BigDecimal(str.trim());
            if (!Cautions.this.checkIfNumberNegativeForGUI(number)) {
                return true;
            }
        } catch (NumberFormatException nfe) {
        }
        return false;
    }

    public <T extends Number> boolean checkIfNumberNegativeForGUI(T number) {
        return new BigDecimal(number + "").compareTo(BigDecimal.ZERO) < 0;
    }

    public boolean checkIfDateIsBeforeAnotherDate(String dateString, String anotherDateString) {
        if(!checkIfValidDate(dateString)){
            return false;
        }
        if(!checkIfValidDate(anotherDateString)){
            return false;
        }
        LocalDate date = LocalDate.parse(dateString, DateTimeFormatter
                .ofPattern(INPUT_DATE_PATTERN));
        LocalDate anotherDate = LocalDate.parse(anotherDateString, DateTimeFormatter
                .ofPattern(INPUT_DATE_PATTERN));
        return date.isBefore(anotherDate) || date.isEqual(date);
    }

    public boolean checkIfValidDate(String dateString) {
        try {
            LocalDate.parse(dateString, DateTimeFormatter
                    .ofPattern(INPUT_DATE_PATTERN));
            return true;
        } catch (DateTimeException dte) {
        }
        return false;
    }
    
    public boolean checkIfValidHours(String str){
        if(!checkIfANumberSequenceForGUI(str)){
            return false;
        }
        return Integer.parseInt(str) <= 23;
    }
    
    public boolean checkIfValidMinute(String str){
        if(!checkIfANumberSequenceForGUI(str)){
            return false;
        }
        return Integer.parseInt(str) <= 59;
    }
    
    public boolean checkIfValidSecond(String str){
        if(!checkIfANumberSequenceForGUI(str)){
            return false;
        }
        return Integer.parseInt(str) <= 59;
    }
}
