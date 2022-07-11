package com.cidr.rest.service;

import java.util.List;

import com.cidr.rest.model.Customer;
 
public interface CustomerService {
 
	public List<Customer> findAllCustomers() ;
	public Customer findById(int id) ;
	public void create(Customer customer) ;
	public void delete(int id) ;
	public Customer update(Customer customer) ;
     
}
