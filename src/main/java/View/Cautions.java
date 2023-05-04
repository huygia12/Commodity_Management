/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package View;

import java.math.BigDecimal;
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

    public boolean checkIfBigDecimalNegative(BigDecimal num) {
        if (num.compareTo(BigDecimal.ZERO) < 0) {
            System.out.println("This number cannot take a negative value!");
            return false;
        }
        return true;
    }
    
    public boolean checkIfANumberSequence(String str){
        try{
            long number = Integer.parseInt(str);
            return true;
        }catch(NumberFormatException nfe){
            System.out.println("This input must be a number sequence!");
            return false;
        }
    }
    
    public boolean checkIfBigDecimalEqualZero(BigDecimal num) {
        if (num.compareTo(BigDecimal.ZERO) == 0) {
            System.out.println("This number cannot equal zero!");
            return false;
        }
        return true;
    }
    
    public boolean checkIfIntNegative(int num){
        if (num < 0) {
            System.out.println("This number cannot take a negative value!");
            return true;
        }
        return false;
    }
    
    public boolean checkIfIntEqualZero(int num){
        if (num == 0) {
            System.out.println("This number cannot equal zero!");
            return true;
        }
        return false;
    }
    
    public void wrInput() {
        System.out.println("Invalid input! Please try again.");
    }
}
