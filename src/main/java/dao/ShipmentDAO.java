package dao;

import javax.persistence.EntityManager;
import model.entities.Shipment;

public interface ShipmentDAO {
    public boolean addShipment (Shipment shipment, EntityManager em);
    
    public boolean updateShipment (Shipment shipment, EntityManager em);
    
    public boolean deleteShipment (Long shipmentId, EntityManager em);
    
    public Shipment getShipment (Long shipmentId, EntityManager em);
}
