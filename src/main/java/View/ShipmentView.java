/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package View;

import Models.Shipment;
import java.math.BigInteger;
import java.time.DateTimeException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

/**
 *
 * @author FPTSHOP
 */
public class ShipmentView {

    final String INPUT_DATE_PATTERN = "d/M/y";
    final LocalDate CURRENT_DATE = LocalDate.now();
    Scanner sc = new Scanner(System.in);
    Cautions ctions = new Cautions();

    
    public int typeInQuan(Shipment shipment) {
        while (true) {
            System.out.print("Type in quantity or type EXIT/BACK to exit/back: ");
            String inputStr = sc.nextLine();
            if ("exit".equalsIgnoreCase(inputStr)) {
                return 0;
            } else if ("back".equalsIgnoreCase(inputStr)) {
                return -1;
            } else if (ctions.checkIfNoInput(inputStr)) {
            } else {
                try {
                    BigInteger quantity = new BigInteger(inputStr);
                    if (!ctions.checkIfBigIntPositive(quantity)) {
                        continue;
                    }
                    shipment.setQuantity(quantity);
                    return 1;
                } catch (NumberFormatException nfe) {
                    ctions.wrInput();
                }
            }
        }
    }

    public int typeInImportPrice(Shipment shipment) {
        while (true) {
            System.out.print("Input goods import price or type EXIT/BACK to go exit/back: ");
            String inputStr = sc.nextLine();
            if ("exit".equalsIgnoreCase(inputStr)) {
                return 0;
            } else if ("back".equalsIgnoreCase(inputStr)) {
                return -1;
            } else if (ctions.checkIfNoInput(inputStr)) {
            } else {
                try {
                    BigInteger importPrice = new BigInteger(inputStr);
                    if (ctions.checkIfBigIntPositive(importPrice)) {
                        shipment.setImportPrice(importPrice);
                        return 1;
                    }
                } catch (NumberFormatException nfe) {
                    ctions.wrInput();
                }
            }
        }
    }

    public int typeInProDate(Shipment shipment) {
        while (true) {
            System.out.print("Input production date or type EXIT/BACK to go exit/back: ");
            String inputStr = sc.nextLine();
            if ("exit".equalsIgnoreCase(inputStr)) {
                return 0;
            } else if ("back".equalsIgnoreCase(inputStr)) {
                return -1;
            } else {
                try {
                    LocalDate nsx = LocalDate.parse(inputStr, DateTimeFormatter
                            .ofPattern(INPUT_DATE_PATTERN));
                    if (nsx.isAfter(CURRENT_DATE)) {
                        System.out.println("Invalid Date, production date cannot be after current date!");
                    } else {
                        if (shipment.getHsd() != null) {
                            if (nsx.isAfter(shipment.getHsd())) {
                                System.out.println("Invalid Date, production date cannot be after expiration date!");
                                continue;
                            }
                        }
                        shipment.setNsx(nsx);
                        return 1;
                    }
                } catch (DateTimeException dte) {
                    ctions.wrInput();
                }
            }
        }
    }

    public int typeInEpirDate(Shipment shipment) {
        while (true) {
            System.out.print("Input expiration Date or type EXIT/BACK to go exit/back: ");
            String inputStr = sc.nextLine();
            if ("exit".equalsIgnoreCase(inputStr)) {
                return 0;
            } else if ("back".equalsIgnoreCase(inputStr)) {
                return -1;
            } else {
                try {
                    LocalDate hsd = LocalDate.parse(inputStr, DateTimeFormatter
                            .ofPattern(INPUT_DATE_PATTERN));
                    if (hsd.isBefore(shipment.getNsx())) {
                        System.out.println("Invalid Date, expiration date cannot be before production date!");
                    } else {
                        shipment.setHsd(hsd);
                        return 1;
                    }
                } catch (DateTimeException dte) {
                    ctions.wrInput();
                }
            }
        }
    }
    
    public boolean gainQuanDecision(BigInteger quantity, Shipment shipment) {
        // give the user to make a decision between gain the shipmentQuantity one or abort changes
        while (true) {
            System.out.println(
                    "This shipment already exists, do you want to keep your changes?");
            System.out
                    .print("(Y:add to the existing one / N:abort change)=>Y/N: ");
            String yesNo = sc.nextLine();
            if (yesNo.equalsIgnoreCase("y")) {
                BigInteger sumQuantity = shipment.getQuantity().add(quantity);
                shipment.setQuantity(sumQuantity);
                System.out.println("Add succceed...");
                return true;
            } else if (yesNo.equalsIgnoreCase("n")) {
                System.out.println("Aborting...");
                return false;
            } else {
                System.out.println("Wrong input!");
            }
        }
    }
}
