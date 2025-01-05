package dao;

import java.util.UUID;
import javax.persistence.EntityManager;
import model.entities.Employee;

/**
 *
 * @author huy
 */
public interface EmployeeDAO {
    public boolean addEmployee(Employee employee, EntityManager em);

    public boolean updateEmployee(Employee employee, EntityManager em);
    
    public boolean deleteEmployee(UUID employeeID, EntityManager em);
    
    public Employee getEmployee(UUID employeeId, EntityManager em);
}
