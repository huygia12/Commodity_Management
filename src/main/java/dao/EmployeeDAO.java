package dao;

import javax.persistence.EntityManager;
import model.entities.Employee;

/**
 *
 * @author huy
 */
public interface EmployeeDAO {
    public boolean addEmployee(Employee employee, EntityManager em);

    public boolean updateEmployee(Employee employee, EntityManager em);
    
    public boolean deleteEmployee(Long employeeID, EntityManager em);
    
    public Employee getEmployee(Long employeeId, EntityManager em);
}
