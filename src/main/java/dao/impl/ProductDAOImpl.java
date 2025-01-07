package dao.impl;

import dao.ProductDAO;
import javax.persistence.EntityManager;
import model.entities.Product;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.persistence.EntityTransaction;

public class ProductDAOImpl implements ProductDAO {

    @Override
    public boolean addProduct(Product product, EntityManager em) {
        EntityTransaction transaction = em.getTransaction();
        try {
            transaction.begin();
            em.persist(product);
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
    public boolean updateProduct(Product product, EntityManager em) {
        EntityTransaction transaction = em.getTransaction();
        try {
            Product p = getProduct(product.getProductId(), em);
            transaction.begin();

            p.setProductCode(product.getProductCode());
            p.setProductName(product.getProductName());
            p.setUnit(product.getUnit());
            p.setPrice(product.getPrice());
            p.setProvider(product.getProvider());

            em.merge(p);
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
    public boolean deleteProduct(Long productId, EntityManager em) {
        EntityTransaction transaction = em.getTransaction();
        try {
            Product p = getProduct(productId, em);
            transaction.begin();

            if (p != null) {
                em.remove(p);
            } else {
                Logger.getLogger(this.getClass().getName()).log(Level.INFO, null, "Product not found");
            }
            transaction.commit();
            return true;
        } catch (Exception e) {
            if (transaction.isActive()) {
                transaction.rollback();
            }
            Logger.getLogger(this.getClass().getName()).log(Level.SEVERE, null, e);
            return false;
        }
    }

    @Override
    public Product getProduct(Long productId, EntityManager em) {
        Product p = em.find(Product.class, productId);
        return p;
    }
}
