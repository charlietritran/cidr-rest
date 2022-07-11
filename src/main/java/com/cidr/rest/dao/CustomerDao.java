package com.cidr.rest.dao;

import java.util.ArrayList;
import java.util.List;

import com.cidr.rest.model.Customer;

 
public interface CustomerDao {

		public List<Customer> findAllCustomers() ;
		public Customer findById(int id) ;
		public void create(Customer customer) ;
		public void delete(int id) ;
		public void update(Customer customer) ;
 
}
