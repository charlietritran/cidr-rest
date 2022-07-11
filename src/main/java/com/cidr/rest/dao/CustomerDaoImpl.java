package com.cidr.rest.dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import com.cidr.rest.controller.EmployeeController;
import com.cidr.rest.model.*;
import java.util.logging.Logger;
 
@Repository("customerDao")
public class CustomerDaoImpl extends AbstractDao<Integer, Customer> implements CustomerDao {
 
	private static final Logger logger = Logger.getLogger(CustomerDaoImpl.class.getName());
    

 	/**
 	 * Returns list of customers from dummy database.
 	 * 
 	 * @return list of customers
 	 */
 	public List findAllCustomers() {
 		Criteria criteria = createEntityCriteria();
        return (List<Customer>) criteria.list();
 	}

 	/**
 	 * Return customer object for given id from dummy database. If customer is
 	 * not found for id, returns null.
 	 * 
 	 * @param id
 	 *            customer id
 	 * @return customer object for given id
 	 */
 	public Customer findById(int id) {
 		return getByKey(id);
 	}

 	/**
 	 * Create new customer in dummy database. Updates the id and insert new
 	 * customer in list.
 	 * 
 	 * @param customer
 	 *            Customer object
 	 * @return customer object with updated id
 	 */
 	public void create(Customer customer) {
 		persist(customer);
 	}

 	/**
 	 * Delete the customer object from dummy database. If customer not found for
 	 * given id, returns null.
 	 * 
 	 * @param id
 	 *            the customer id
 	 * @return id of deleted customer object
 	 */
    public void delete(int id) {
        Query query = getSession().createSQLQuery("delete from Customer where id = :id");
        query.setInteger("id", id);
        query.executeUpdate();
    }

 	/**
 	 * Update the customer object for given id in dummy database. If customer
 	 * not exists, returns null
 	 * 
 	 * @param id
 	 * @param customer
 	 * @return customer object with id
 	 */
 	public void update(Customer customer) {
 		//update(customer);
 		getSession().saveOrUpdate(customer);
 	}
}
