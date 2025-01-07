package dao.impl;

import dao.StoreDAO;
import java.util.UUID;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.TypedQuery;
import model.entities.Store;
import util.BcryptUtil;

public class StoreDAOImpl implements StoreDAO {

    @Override
    public Store login(String email, String password, EntityManager em) {
        Store store;

        try {
            TypedQuery<Store> query = em.createQuery(
                    "SELECT s FROM Store s WHERE s.email = :email", Store.class);
            query.setParameter("email", email);

            store = query.getSingleResult();
        } catch (Exception e) {
            Logger.getLogger(this.getClass().getName()).log(Level.SEVERE, null, e);
            return null;
        } 
        
        return BcryptUtil.checkPassword(password, store.getPassword()) ? store : null;
    }

    @Override
    public boolean signup(Store store, EntityManager em) {
        Store storeHolder = getStoreWithEmail(store.getEmail(), em);
        if (storeHolder != null) return false;

        EntityTransaction transaction = em.getTransaction();
        try {
            transaction.begin();
            em.persist(store);
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
    public boolean updateStore(Store store, EntityManager em) {
        EntityTransaction transaction = em.getTransaction();
        try {
            Store s = getStore(store.getStoreId(), em);
            transaction.begin();

            s.setStoreName(store.getStoreName());
            s.setEmail(store.getEmail());

            em.merge(s);
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
    public boolean updateStoreAvatar(Long storeId, String avatarPath, EntityManager em) {
        EntityTransaction transaction = em.getTransaction();
        try {
            Store s = getStore(storeId, em);
            transaction.begin();
            s.setAvatar(avatarPath);
            em.merge(s);
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
    public Store getStore(Long storeId, EntityManager em) {
        Store s = em.find(Store.class, storeId);
        return s;
    }

    @Override
    public boolean updateStorePassword(Long storeId, String newPlainPasswordx, EntityManager em) {
        EntityTransaction transaction = em.getTransaction();
        try {
            Store s = getStore(storeId, em);
            transaction.begin();
            s.setPassword(BcryptUtil.hashPassword(newPlainPasswordx));
            em.merge(s);
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
    public Store getStoreWithEmail(String email, EntityManager em) {
        try {
            TypedQuery<Store> query = em.createQuery(
                    "SELECT s FROM Store s WHERE s.email = :email", Store.class);
            query.setParameter("email", email);

            Store store = query.getSingleResult();
            return store;
        } catch (Exception e) {
            Logger.getLogger(this.getClass().getName()).log(Level.SEVERE, null, e);
            return null;
        }
    }
}
