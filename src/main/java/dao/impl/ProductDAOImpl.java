/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao.impl;

import dao.ProductDAO;
import javax.persistence.EntityManager;
import model.entities.Product;
import java.util.UUID;

/**
 *
 * @author huy
 */
public class ProductDAOImpl implements ProductDAO{

    @Override
    public void addProduct(Product product, EntityManager em) {
        em.getTransaction().begin();
        em.persist(product);
        em.getTransaction().commit();
        em.close();
    }

    @Override
    public void updateProduct(Product product, EntityManager em) {
        Product p = getProduct(product.getProductId(), em);
        em.getTransaction().begin();
        
        p.setProductCode(product.getProductCode());
        p.setThump(product.getThump());
        p.setProductName(product.getProductName());
        p.setUnit(product.getUnit());
        p.setPrice(product.getPrice());
        p.setProvider(product.getProvider());
        
        em.merge(p);
        em.getTransaction().commit();
        em.close();
    }

    @Override
    public void deleteProduct(Product product, EntityManager em) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
    private Product getProduct (UUID productId, EntityManager em){
        Product p = em.find(Product.class, productId);
        return p;
    }
}
