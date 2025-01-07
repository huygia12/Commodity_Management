package dao.impl;

import dao.EmployeeDAO;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import model.entities.Employee;

/**
 *
 * @author huy
 */
public class EmployeeDAOImpl implements EmployeeDAO {

    @Override
    public boolean addEmployee(Employee employee, EntityManager em) {
        EntityTransaction transaction = em.getTransaction();
        try {
            transaction.begin();
            em.persist(employee);
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
    public boolean updateEmployee(Employee employee, EntityManager em) {
        EntityTransaction transaction = em.getTransaction();
        try {
            Employee e = getEmployee(employee.getEmployeeId(), em);
            transaction.begin();

            e.setFullname(employee.getFullname());
            e.setGender(employee.getGender());
            em.merge(e);
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
    public boolean deleteEmployee(Long employeeId, EntityManager em) {
        EntityTransaction transaction = em.getTransaction();
        try {
            Employee e = getEmployee(employeeId, em);
            transaction.begin();

            if (e != null) {
                em.remove(e);
            } else {
                Logger.getLogger(this.getClass().getName()).log(Level.INFO, null, "Employee not found");
            }
            transaction.commit();
            return true;
        } catch (Exception e) {
            if (transaction.isActive()) {
                transaction.rollback();
            }
            Logger.getLogger(this.getClass().getName()).log(Level.SEVERE, null, e);
            return false;
        }
    }

    @Override
    public Employee getEmployee(Long employeeId, EntityManager em) {
        Employee e = em.find(Employee.class, employeeId);
        return e;
    }
}
