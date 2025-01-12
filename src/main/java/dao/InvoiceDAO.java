package dao;

import java.util.List;
import javax.persistence.EntityManager;
import model.entities.Invoice;

public interface InvoiceDAO {
    public boolean addInvoice (Invoice invoice, EntityManager em);
    
    public Invoice getInvoice(Long invoiceId, EntityManager em);
    
    public List<Invoice> getInvoices(Long shiftId, EntityManager em);
}
