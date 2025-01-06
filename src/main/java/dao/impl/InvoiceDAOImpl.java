package dao.impl;

import dao.InvoiceDAO;
import javax.persistence.EntityManager;
import java.util.UUID;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.persistence.EntityTransaction;
import model.entities.Invoice;

public class InvoiceDAOImpl implements InvoiceDAO {

    @Override
    public boolean addInvoice(Invoice invoice, EntityManager em) {
        EntityTransaction transaction = em.getTransaction();
        try {
            transaction.begin();
            em.persist(invoice);
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
    public Invoice getInvoice(UUID invoiceId, EntityManager em) {
        Invoice i = em.find(Invoice.class, invoiceId);
        return i;
    }
}
