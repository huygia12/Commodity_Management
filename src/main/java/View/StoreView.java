/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package View;

import Models.Store;
import Ultility.Cautions;
import java.math.BigDecimal;
import java.util.Scanner;

/**
 *
 * @author FPTSHOP
 */
public class StoreView {
    final Cautions ctions = new Cautions();
    final Scanner sc = new Scanner(System.in);
    
    public void menuOfChangeStoreInfor(){
        System.out.print("""
                           \n**************************
                           * 1. Change Store Name   *
                           * 2. Change Email        *
                           * 3. Change Address      *
                           * 4. Change Phone Number *
                           * 5. Change VAT          *
                           * 6. Done                *
                           **************************
                           Options => """);
    }
    
    public int typeInStoreName(Store store) {
        while (true) {
            System.out.print("Type in Store Name or type EXIT/BACK to exit/back: ");
            String inputStr = sc.nextLine();
            if ("exit".equalsIgnoreCase(inputStr)) {
                return 0;
            } else if ("back".equalsIgnoreCase(inputStr)) {
                return -1;
            } else if (ctions.checkIfNoInput(inputStr)) {
            } else {
                store.setName(inputStr);
                return 1;
            }
        }
    }
    
    public int typeInEmail(Store store) {
        while (true) {
            System.out.print("Type in Email or type EXIT/BACK to exit/back: ");
            String inputStr = sc.nextLine();
            if ("exit".equalsIgnoreCase(inputStr)) {
                return 0;
            } else if ("back".equalsIgnoreCase(inputStr)) {
                return -1;
            } else if (ctions.checkIfNoInput(inputStr)) {
            } else {
                store.setEmail(inputStr);
                return 1;
            }
        }
    }
    
    public int typeInPhoneNumber(Store store) {
        while (true) {
            System.out.print("Type in Phone Number or type EXIT/BACK to exit/back: ");
            String inputStr = sc.nextLine();
            if ("exit".equalsIgnoreCase(inputStr)) {
                return 0;
            } else if ("back".equalsIgnoreCase(inputStr)) {
                return -1;
            } else if (ctions.checkIfNoInput(inputStr)
                    || !ctions. checkIfANumberSequence(inputStr)) {
            }else {
                store.setPhoneNumber(inputStr);
                return 1;
            }
        }
    }
    
    public int typeInAndress(Store store) {
        while (true) {
            System.out.print("Type in Andress or type EXIT/BACK to exit/back: ");
            String inputStr = sc.nextLine();
            if ("exit".equalsIgnoreCase(inputStr)) {
                return 0;
            } else if ("back".equalsIgnoreCase(inputStr)) {
                return -1;
            } else if (ctions.checkIfNoInput(inputStr)) {
            } else {
                store.setAddress(inputStr);
                return 1;
            }
        }
    }

}
