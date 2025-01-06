package dao;

import java.util.UUID;
import javax.persistence.EntityManager;
import model.entities.Store;


public interface StoreDAO {
    
    public Store login(String email, String password, EntityManager em);
    
    public boolean signup(Store store, EntityManager em);
    
    public boolean updateStore(Store store, EntityManager em);
    
    public boolean updateStorePassword(UUID storeId, String newPassword, EntityManager em);
    
    public Store getStore(UUID storeId, EntityManager em);
    
    public Store getStoreWithEmail(String email, EntityManager em);
    
    public boolean updateStoreAvatar(UUID storeId, String avatarPath, EntityManager em);
}
