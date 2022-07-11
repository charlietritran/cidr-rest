package com.cidr.rest.service;

import java.util.List;
import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cidr.rest.controller.CustomerController;
import com.cidr.rest.dao.CustomerDao;
import com.cidr.rest.dao.EmployeeDao;
import com.cidr.rest.model.Customer;
import com.cidr.rest.model.Employee;
 
@Service("customerService")
@Transactional
public class CustomerServiceImpl implements CustomerService {
 
	private static final Logger logger = Logger.getLogger(CustomerServiceImpl.class.getName());
	
    @Autowired
    private CustomerDao dao;
     
    
    public List<Customer> findAllCustomers() {
        return dao.findAllCustomers();
    }
    
    public Customer findById(int id) {
        return dao.findById(id);
    }
 
    public void create(Customer customer) {
        dao.create(customer);
    }
 
    /*
     * Since the method is running with Transaction, No need to call hibernate update explicitly.
     * Just fetch the entity from db and update it with proper values within transaction.
     * It will be updated in db once transaction ends. 
     */
    public Customer update(Customer customer) {
        Customer entity = dao.findById(customer.getId());
        if(entity!=null){
        	
        	entity.setFirstName(customer.getFirstName());
        	entity.setLastName(customer.getLastName());
        	entity.setEmail(customer.getEmail());
        	entity.setMobile(customer.getMobile());
        	entity.setDateOfBirth(customer.getDateOfBirth());
        	dao.update(entity);
        }
        entity = dao.findById(customer.getId());
        return entity;
    }
 
    public void delete(int id) {
        dao.delete(id);
    }
     

 

     
}