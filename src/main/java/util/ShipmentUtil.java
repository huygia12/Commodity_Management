package util;

import java.time.LocalDate;
import java.util.List;
import model.entities.Product;
import model.entities.Shipment;


public class ShipmentUtil {
    public static String calculateStatus(Shipment shipment) {
        if (shipment.getExpiryDate() == null || shipment.getManufacturingDate() == null) {
            return "Không có hạn sử dụng";
        } else if (!shipment.getExpiryDate().isAfter(LocalDate.now())) {
            return "Hết hạn";
        } else {
            return "Còn hạn";
        }
    }
    
    public static Shipment getShipmentFrom(Long shipmentId, Product product) {
        List<Shipment> shipments = product.getShipments();
        if (shipments.isEmpty()) {
            return null;
        }

        return shipments
                .stream()
                .filter(shipment -> shipment.getShipmentId().equals(shipmentId))
                .findFirst()
                .orElse(null);
    }
    
    public static boolean isInStock (Shipment shipment, int quantity){
        return shipment.getQuantityInStock() - quantity > 0;
    }
}
