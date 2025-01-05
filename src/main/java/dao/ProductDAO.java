/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import java.util.List;
import javax.persistence.EntityManager;
import model.entities.Product;

/**
 *
 * @author huy
 */
public interface ProductDAO {
    public void addProduct (Product product, EntityManager em);
    
    public void updateProduct (Product product, EntityManager em);
    
    public void deleteProduct (Product product, EntityManager em);

}
