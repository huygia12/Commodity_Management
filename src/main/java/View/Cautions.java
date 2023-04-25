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

    public boolean checkIfBigIntPositive(BigDecimal num) {
        if (num.compareTo(BigDecimal.ZERO) < 0) {
            System.out.println("This number cannot take a negative value!");
            return false;
        }
        return true;
    }
    
    public boolean checkIfIntPositive(int num){
        if (num < 0) {
            System.out.println("This number cannot take a negative value!");
            return false;
        }
        return true;
    }
    
    public void wrInput() {
        System.out.println("Invalid input! Please try again.");
    }
}
