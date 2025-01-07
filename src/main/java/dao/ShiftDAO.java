package dao;

import java.util.List;
import javax.persistence.EntityManager;
import model.entities.Employee;
import model.entities.Shift;
import model.entities.Store;

public interface ShiftDAO {
    public Shift addShift (Store store,EntityManager em);
    
    public boolean openShift (Shift shipment, List<Employee> shiftEmployees, EntityManager em);
    
    public boolean closeShift (Shift shipment, EntityManager em);
    
    public boolean updateShift (Shift shipment, List<Employee> employees, EntityManager em);
    
    public Shift getShift (Long shipmentId, EntityManager em);
    
    public Shift getLatestShift(EntityManager em);
}
