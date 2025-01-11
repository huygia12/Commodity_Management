package dao;

import java.util.List;
import javax.persistence.EntityManager;
import model.entities.Product;

public interface ProductDAO {
    public boolean addProduct (Product product, EntityManager em);
    
    public boolean updateProduct (Product product, EntityManager em);
    
    public boolean deleteProduct (Long productId, EntityManager em);
    
    public Product getProduct (Long productId, EntityManager em);
    
    public List<Product> findProductsByNameKeyword (String keyword, EntityManager em);
    
    public List<Product> getProductsInStore(Long storeId, EntityManager em);
}
