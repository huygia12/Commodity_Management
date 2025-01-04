/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package config;

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
    
    public HibernateConfig() {
        this.setFactory(Persistence.createEntityManagerFactory("user_role"));
    }
    
}
