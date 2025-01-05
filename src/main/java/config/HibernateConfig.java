package config;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import lombok.Getter;
import lombok.Setter;

/**
 *
 * @author huy
 */
@Setter
@Getter
public class HibernateConfig {

    private EntityManagerFactory factory;
    private EntityManager entityManager;

    public HibernateConfig() {
        this.setFactory(Persistence.createEntityManagerFactory("user_role"));
    }

    public EntityManager getEntityManager() {
        if (entityManager == null || !entityManager.isOpen()) {
            entityManager = getFactory().createEntityManager(); 
        }
        return entityManager;
    }

    public void closeConnection() {
        this.entityManager.close();
        this.factory.close();
    }
}
