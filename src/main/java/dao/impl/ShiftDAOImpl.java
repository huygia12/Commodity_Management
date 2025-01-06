package dao.impl;

import dao.ShiftDAO;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;
import java.util.UUID;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.persistence.EntityTransaction;
import javax.persistence.NoResultException;
import javax.persistence.TypedQuery;
import model.entities.Employee;
import model.entities.Shift;
import model.entities.ShiftEmployee;
import model.entities.Store;
import model.enums.ShiftState;

public class ShiftDAOImpl implements ShiftDAO {

    @Override
    public Shift addShift(Store store, EntityManager em) {
        EntityTransaction transaction = em.getTransaction();
        try {
            Shift newShift = Shift.builder().store(store).state(ShiftState.STAGED).build();
            em.persist(newShift);
            transaction.commit();
            return newShift;
        } catch (RuntimeException e) {
            if (transaction.isActive()) {
                transaction.rollback();
            }
            Logger.getLogger(this.getClass().getName()).log(Level.SEVERE, null, e);
            return null;
        } finally {
            if (em.isOpen()) {
                em.close();
            }
        }
    }

    @Override
    public boolean openShift(Shift shift, List<Employee> employees, EntityManager em) {
        EntityTransaction transaction = em.getTransaction();
        try {
            List<ShiftEmployee> shiftEmployees = new ArrayList<>();

            employees.forEach(e -> {
                shiftEmployees.add(ShiftEmployee
                        .builder()
                        .employeeName(e.getFullname())
                        .employee(e)
                        .build());
            });

            shift.setEmployees(shiftEmployees);
            shift.setOpenAt(LocalDateTime.now());
            shift.setState(ShiftState.OPENED);

            transaction.begin();
            em.merge(shift);
            transaction.commit();
            return true;
        } catch (RuntimeException e) {
            if (transaction.isActive()) {
                transaction.rollback();
            }
            Logger.getLogger(this.getClass().getName()).log(Level.SEVERE, null, e);
            return false;
        } finally {
            if (em.isOpen()) {
                em.close();
            }
        }
    }

    @Override
    public boolean closeShift(Shift shift, EntityManager em) {
        EntityTransaction transaction = em.getTransaction();
        try {
            shift.setEndAt(LocalDateTime.now());
            shift.setState(ShiftState.CLOSED);

            transaction.begin();
            em.merge(shift);
            transaction.commit();
            return true;
        } catch (RuntimeException e) {
            if (transaction.isActive()) {
                transaction.rollback();
            }
            Logger.getLogger(this.getClass().getName()).log(Level.SEVERE, null, e);
            return false;
        } finally {
            if (em.isOpen()) {
                em.close();
            }
        }
    }

    @Override
    public boolean updateShift(Shift shift, List<Employee> employees, EntityManager em) {
        EntityTransaction transaction = em.getTransaction();
        try {
            List<ShiftEmployee> shiftEmployees = new ArrayList<>();

            employees.forEach(e -> {
                shiftEmployees.add(ShiftEmployee
                        .builder()
                        .employeeName(e.getFullname())
                        .employee(e)
                        .build());
            });

            shift.setEmployees(shiftEmployees);
            
            transaction.begin();
            em.merge(shift);
            transaction.commit();
            return true;
        } catch (RuntimeException e) {
            if (transaction.isActive()) {
                transaction.rollback();
            }
            Logger.getLogger(this.getClass().getName()).log(Level.SEVERE, null, e);
            return false;
        } finally {
            if (em.isOpen()) {
                em.close();
            }
        }
    }

    @Override
    public Shift getShift(UUID shiftId, EntityManager em) {
        Shift s = em.find(Shift.class, shiftId);
        return s;
    }

    @Override
    public Shift getLatestShift(EntityManager em) {
        try {
            TypedQuery<Shift> query = em.createQuery(
                    "SELECT s FROM Shift s ORDER BY s.createdAt DESC", Shift.class
            );
            query.setMaxResults(1);
            return query.getSingleResult();
        } catch (NoResultException e) {
            return null;
        }

    }
}
