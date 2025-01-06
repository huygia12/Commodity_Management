package dao;

import java.util.UUID;
import javax.persistence.EntityManager;
import model.entities.Shipment;

public interface ShipmentDAO {
    public boolean addShipment (Shipment shipment, EntityManager em);
    
    public boolean updateShipment (Shipment shipment, EntityManager em);
    
    public boolean deleteShipment (UUID shipmentId, EntityManager em);
    
    public Shipment getShipment (UUID shipmentId, EntityManager em);
}
