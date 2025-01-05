/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import javax.persistence.EntityManager;
import model.entities.Store;

/**
 *
 * @author huy
 */
public interface StoreDAO {
    
    public Store login(String email, String password, EntityManager em);
    
    public boolean signup(Store store, EntityManager em);
    
    public void updateStore(Store store, EntityManager em);
    
    public void deleteStore(Store store, EntityManager em);
}
