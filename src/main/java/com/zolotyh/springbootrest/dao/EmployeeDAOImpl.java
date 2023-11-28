package com.zolotyh.springbootrest.dao;

import com.zolotyh.springbootrest.entity.Employee;
import jakarta.persistence.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import jakarta.persistence.EntityManager;

import java.util.List;

@Repository
public class EmployeeDAOImpl implements EmployeeDAO{
    @Autowired
    private EntityManager entityManager;

    public List<Employee> getAllEmployees() {
//        Session session = entityManager.unwrap(Session.class);
//        Query<Employee> query = session.createQuery("FROM Employee", Employee.class);
//        List<Employee> allEmployees = query.getResultList();
        Query query = entityManager.createQuery("FROM Employee");
        List<Employee> allEmployees = query.getResultList();
        return allEmployees;
    }

    public void saveEmployee(Employee employee) {
//        Session session = entityManager.unwrap(Session.class);
//        session.saveOrUpdate(employee);
        Employee emp = entityManager.merge(employee);
        employee.setId(emp.getId());
    }

    public Employee getEmployee(int id) {
//        Session session = entityManager.unwrap(Session.class);
//        Employee employee = session.get(Employee.class, id);
        Employee employee = entityManager.find(Employee.class, id);
        return employee;
    }

    public void deleteEmployee(int id) {
//        Session session = entityManager.unwrap(Session.class);
//        Query<Employee> query = session.createQuery("DELETE FROM Employee WHERE id =:employeeId");
//        query.setParameter("employeeId", id);
//        query.executeUpdate();
        Query query = entityManager.createQuery("DELETE FROM Employee WHERE id =:employeeId");
        query.setParameter("employeeId", id);
        query.executeUpdate();
    }
}
