package com.cidr.rest.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import com.cidr.rest.controller.EmployeeController;
import com.cidr.rest.model.*;
import java.util.logging.Logger;
 
@Repository("employeeDao")
public class EmployeeDaoImpl extends AbstractDao<Integer, Employee> implements EmployeeDao {
 
	private static final Logger logger = Logger.getLogger(EmployeeDaoImpl.class.getName());
    public Employee findById(int id) {
        return getByKey(id);
    }
 
    public void saveEmployee(Employee employee) {
    	logger.info("EMP - NAME:" + employee.getName());
        persist(employee);
    }
 
    public void deleteEmployeeBySsn(String ssn) {
        Query query = getSession().createSQLQuery("delete from Employee where ssn = :ssn");
        query.setString("ssn", ssn);
        query.executeUpdate();
    }
 
    @SuppressWarnings("unchecked")
    public List<Employee> findAllEmployees() {
        Criteria criteria = createEntityCriteria();
        return (List<Employee>) criteria.list();
    }
 
    public Employee findEmployeeBySsn(String ssn) {
        Criteria criteria = createEntityCriteria();
        criteria.add(Restrictions.eq("ssn", ssn));
        return (Employee) criteria.uniqueResult();
    }
}
