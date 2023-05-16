/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controllers;

import Models.ImportedGoods;
import Models.Shipment;

/**
 *
 * @author FPTSHOP
 */
public class ImportedGoodsController extends GoodsController {

    private final ShipmentController shipmentCtr = new ShipmentController();

    public ImportedGoodsController() {
    }

    public ImportedGoods cloneImportGoods(ImportedGoods importedGoods) {
        ImportedGoods cloneImportedGoods = new ImportedGoods(importedGoods);
        cloneImportedGoods.setTotalQuantity(getTotalQuanByShipments(importedGoods));
        cloneImportedGoods.setImportDateTime(importedGoods.getImportDateTime());
        for (Shipment shipment : importedGoods.getShipments()) {
            Shipment cloneShipment = shipmentCtr.cloneShipment(shipment);
            cloneImportedGoods.getShipments().add(cloneShipment);
        }
        return cloneImportedGoods;
    }
}
