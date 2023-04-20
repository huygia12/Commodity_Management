/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controllers;

import java.time.LocalDate;
import java.util.Scanner;

/**
 *
 * @author s1rja
 */
class Shipment {

    private int quantity;
    private long importPrice;
    private String shipmentID = null;
    private LocalDate nsx = null;
    private LocalDate hsd = null;

    public Shipment() {
    }

    public Shipment(int quantity, long importPrice, LocalDate nsx, LocalDate hsd) {
        this.quantity = quantity;
        this.importPrice = importPrice;
        this.nsx = nsx;
        this.hsd = hsd;
    }

    public Shipment(int quantity, long importPrice, LocalDate nsx, LocalDate hsd, String id) {
        this.quantity = quantity;
        this.importPrice = importPrice;
        this.nsx = nsx;
        this.hsd = hsd;
        this.shipmentID = id;
    }

    
    public LocalDate getNsx() {
        return nsx;
    }

    public void setNsx(LocalDate nsx) {
        this.nsx = nsx;
    }

    public LocalDate getHsd() {
        return hsd;
    }

    public void setHsd(LocalDate hsd) {
        this.hsd = hsd;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public long getImportPrice() {
        return importPrice;
    }

    public void setImportPrice(long importPrice) {
        this.importPrice = importPrice;
    }

    public String getShipmentID() {
        return shipmentID;
    }

    public void setShipmentID(String shipmentID) {
        this.shipmentID = shipmentID;
    }

    public void reduceQuantity(int quantity) {
        this.quantity -= quantity;
    }
    
    public Shipment cloneShipment(){
        Shipment cloneShipment = new Shipment();
        cloneShipment.setShipmentID(this.getShipmentID());
        cloneShipment.setImportPrice(this.getImportPrice());
        cloneShipment.setQuantity(this.getQuantity());
        cloneShipment.setHsd(this.getHsd());
        cloneShipment.setNsx(this.getNsx());
        return cloneShipment;
    }
    
    public boolean gainQuantityDecision(int quantity) {
        // give the user to make a decision between gain the shipmentQuantity one or abort changes
        Scanner sc = new Scanner(System.in);
        while (true) {
            System.out.println(
                    "This shipment already exists, do you want to keep your changes?");
            System.out
                    .print("(Y:add to the existing one / N:abort change)=>Y/N: ");
            String yesNo = sc.nextLine();
            if (yesNo.equalsIgnoreCase("y")) {
                int sumQuantity = this.getQuantity() + quantity;
                this.setQuantity(sumQuantity);
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
