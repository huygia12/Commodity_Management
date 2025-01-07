package dao;

import javax.persistence.EntityManager;
import model.entities.Product;

public interface ProductDAO {
    public boolean addProduct (Product product, EntityManager em);
    
    public boolean updateProduct (Product product, EntityManager em);
    
    public boolean deleteProduct (Long productId, EntityManager em);
    
    public Product getProduct (Long productId, EntityManager em);
}
