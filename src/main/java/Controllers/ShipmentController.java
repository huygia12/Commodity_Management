/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controllers;

import Models.Shipment;
import View.ShipmentView;

/**
 *
 * @author FPTSHOP
 */
public class ShipmentController {

    final private ShipmentView shipmentView = new ShipmentView();
    private Shipment shipment;

    public ShipmentController() {
    }

    public ShipmentController(Shipment shipment) {
        this.shipment = shipment;
    }

    
    public Shipment getShipment() {
        return shipment;
    }

    public void setShipment(Shipment shipmentModel) {
        this.shipment = shipmentModel;
    }

    public ShipmentView getView() {
        return shipmentView;
    }
    
}
