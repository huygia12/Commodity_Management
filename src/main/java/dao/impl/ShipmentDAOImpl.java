package dao.impl;

import dao.ShipmentDAO;
import javax.persistence.EntityManager;
import java.util.UUID;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.persistence.EntityTransaction;
import model.entities.Shipment;

public class ShipmentDAOImpl implements ShipmentDAO {

    @Override
    public boolean addShipment(Shipment shipment, EntityManager em) {
        EntityTransaction transaction = em.getTransaction();
        try {
            transaction.begin();
            em.persist(shipment);
            transaction.commit();
            return true;
        } catch (RuntimeException e) {
            if (transaction.isActive()) {
                transaction.rollback();
            }
            Logger.getLogger(this.getClass().getName()).log(Level.SEVERE, null, e);
            return false;
        } finally {
            if (em.isOpen()) {
                em.close();
            }
        }
    }

    @Override
    public boolean updateShipment(Shipment shipment, EntityManager em) {
        EntityTransaction transaction = em.getTransaction();
        try {
            Shipment s = getShipment(shipment.getShipmentId(), em);
            transaction.begin();

            s.setImportPrice(shipment.getImportPrice());
            s.setQuantity(shipment.getQuantity());
            s.setManufacturingDate(shipment.getManufacturingDate());
            s.setExpiryDate(shipment.getExpiryDate());
            
            em.merge(s);
            transaction.commit();
            return true;
        } catch (RuntimeException e) {
            if (transaction.isActive()) {
                transaction.rollback();
            }
            Logger.getLogger(this.getClass().getName()).log(Level.SEVERE, null, e);
            return false;
        } finally {
            if (em.isOpen()) {
                em.close();
            }
        }
    }

    @Override
    public boolean deleteShipment(UUID shipmentId, EntityManager em) {
        EntityTransaction transaction = em.getTransaction();
        try {
            Shipment p = getShipment(shipmentId, em);
            transaction.begin();

            if (p != null) {
                em.remove(p);
            } else {
                Logger.getLogger(this.getClass().getName()).log(Level.INFO, null, "Shipment not found");
            }
            transaction.commit();
            return true;
        } catch (Exception e) {
            if (transaction.isActive()) {
                transaction.rollback();
            }
            Logger.getLogger(this.getClass().getName()).log(Level.SEVERE, null, e);
            return false;
        } finally {
            em.close();
        }
    }

    @Override
    public Shipment getShipment(UUID shipmentId, EntityManager em) {
        Shipment s = em.find(Shipment.class, shipmentId);
        return s;
    }
}
