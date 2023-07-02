/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controllers;

import Models.Shipment;
import java.math.BigDecimal;

/**
 *
 * @author FPTSHOP
 */
public class ShipmentController {


    public ShipmentController() {
    }

    public Shipment cloneShipment(Shipment shipment) {
        Shipment cloneShipment = new Shipment();
        cloneShipment.setID(shipment.getID());
        cloneShipment.setImportPrice(shipment.getImportPrice());
        cloneShipment.setQuantity(shipment.getQuantity());
        cloneShipment.setHsd(shipment.getHsd());
        cloneShipment.setNsx(shipment.getNsx());
        cloneShipment.setImportedDate(shipment.getImportedDate());
        return cloneShipment;
    }
    
    public boolean compare(Shipment shipment, Shipment anotherShipment) {
        boolean check = true;
        if (!shipment.getID().equals(anotherShipment.getID())) {
            check = false;
        } else if (shipment.getQuantity().compareTo(anotherShipment.getQuantity()) != 0) {
            check = false;
        } else if (!shipment.getNsx().isEqual(anotherShipment.getNsx())) {
            check = false;
        } else if (!shipment.getHsd().isEqual(anotherShipment.getHsd())) {
            check = false;
        } else if (!shipment.getImportedDate().isEqual(anotherShipment.getImportedDate())) {
            check = false;
        } else if (shipment.getImportPrice().compareTo(anotherShipment.getImportPrice()) != 0) {
            check = false;
        }
        return check;
    }
}
