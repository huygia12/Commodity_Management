/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Factory;

import Builder.CustomerBuilder;
import Builder.EmployeeBuilder;
import Builder.HumanBuilder;

/**
 *
 * @author s1rja
 */
public class HumanFactory {
    
    private HumanFactory() {
        
    }
    
    public static final HumanBuilder getHuman (HumanType type) {
        switch (type) {
            case EMPLOYEE:
                return new EmployeeBuilder();
            case CUSTOMER:
                return new CustomerBuilder();
            default:
                return null;
        }
    }
}
