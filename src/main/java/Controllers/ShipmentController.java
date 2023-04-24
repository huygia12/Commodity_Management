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

    private Shipment shipment;
    private ShipmentView shipmentView;

    public ShipmentController() {
    }

    public ShipmentController(Shipment shipment, ShipmentView view) {
        this.shipmentView = view;
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

    public void setView(ShipmentView view) {
        this.shipmentView = view;
    }
    
}
