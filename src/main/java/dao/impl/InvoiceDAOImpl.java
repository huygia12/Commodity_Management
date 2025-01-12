package dao.impl;

import dao.InvoiceDAO;
import java.util.List;
import javax.persistence.EntityManager;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.persistence.EntityTransaction;
import javax.persistence.TypedQuery;
import model.entities.Invoice;
import model.entities.InvoiceProduct;
import model.entities.Shipment;

public class InvoiceDAOImpl implements InvoiceDAO {

    @Override
    public boolean addInvoice(Invoice invoice, EntityManager em) {
        EntityTransaction transaction = em.getTransaction();
        try {
            transaction.begin();

            for (InvoiceProduct p : invoice.getInvoiceProducts()) {
                Shipment s = em.find(Shipment.class, p.getShipmentId());
                if (s == null) {
                    throw new RuntimeException("Shipment not found for ID: " + p.getShipmentId());
                }
                if (s.getQuantityInStock() < p.getQuantity()) {
                    throw new RuntimeException("Not enough stock for Shipment ID: " + p.getShipmentId());
                }

                s.setQuantityInStock(s.getQuantityInStock() - p.getQuantity());
                em.merge(s);
            }

            em.persist(invoice);
            transaction.commit();
            return true;
        } catch (RuntimeException e) {
            if (transaction.isActive()) {
                transaction.rollback();
            }
            Logger.getLogger(this.getClass().getName()).log(Level.SEVERE, null, e);
            return false;
        }
    }

    @Override
    public Invoice getInvoice(Long invoiceId, EntityManager em) {
        Invoice i = em.find(Invoice.class, invoiceId);
        return i;
    }

    @Override
    public List<Invoice> getInvoices(Long shiftId, EntityManager em) {
        String jpql = "SELECT p FROM Invoice p WHERE shiftId = :shiftId";
        TypedQuery<Invoice> query = em.createQuery(jpql, Invoice.class);
        query.setParameter("shiftId", shiftId);
        return query.getResultList();
    }
}
