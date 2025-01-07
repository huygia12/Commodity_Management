package dao;

import javax.persistence.EntityManager;
import model.entities.Store;


public interface StoreDAO {
    
    public Store login(String email, String password, EntityManager em);
    
    public boolean signup(Store store, EntityManager em);
    
    public boolean updateStore(Store store, EntityManager em);
    
    public boolean updateStorePassword(Long storeId, String newPassword, EntityManager em);
    
    public Store getStore(Long storeId, EntityManager em);
    
    public Store getStoreWithEmail(String email, EntityManager em);
    
    public boolean updateStoreAvatar(Long storeId, String avatarPath, EntityManager em);
}
