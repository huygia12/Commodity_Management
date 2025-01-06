package dao;

import java.util.UUID;
import javax.persistence.EntityManager;
import model.entities.Product;

public interface ProductDAO {
    public boolean addProduct (Product product, EntityManager em);
    
    public boolean updateProduct (Product product, EntityManager em);
    
    public boolean deleteProduct (UUID productId, EntityManager em);
    
    public Product getProduct (UUID productId, EntityManager em);
}
