package dao;

import java.util.UUID;
import javax.persistence.EntityManager;
import model.entities.Invoice;

public interface InvoiceDAO {
    public boolean addInvoice (Invoice invoice, EntityManager em);
    
    public Invoice getInvoice(UUID invoiceId, EntityManager em);
}
