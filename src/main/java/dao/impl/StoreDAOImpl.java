package dao.impl;

import dao.StoreDAO;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.TypedQuery;
import model.entities.Store;
import util.BcryptUtil;

/**
 *
 * @author huy
 */
public class StoreDAOImpl implements StoreDAO {

    @Override
    public Store login(String email, String password, EntityManager em) {
        Store store = null;
        
        try {
            TypedQuery<Store> query = em.createQuery(
                "SELECT s FROM Store s WHERE s.email = :email", Store.class);
            query.setParameter("email", email);

            store = query.getSingleResult();
        } catch (Exception e) {
            return null;
        } finally {
            if (em.isOpen()) {
                em.close();
            }
        }

        return BcryptUtil.checkPassword(password, store.getPassword()) ? store : null;

    }

    @Override
    public boolean signup(Store store, EntityManager em) {
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
            return false;
        } finally {
            if (em.isOpen()) {
                em.close();
            }
        }
    }

    @Override
    public void updateStore(Store store, EntityManager em) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void deleteStore(Store store, EntityManager em) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
}
