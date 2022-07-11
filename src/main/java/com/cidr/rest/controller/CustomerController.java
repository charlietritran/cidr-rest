package com.cidr.rest.controller;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

import org.joda.time.LocalDate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cidr.rest.dao.CustomerDao;
import com.cidr.rest.dto.CustomerDto;
import com.cidr.rest.dto.EmployeeDto;
import com.cidr.rest.model.Customer;
import com.cidr.rest.model.Employee;
import com.cidr.rest.service.CustomerService;
import com.cidr.rest.service.EmployeeService;

@RestController
@RequestMapping("/")
public class CustomerController {

	private static final Logger logger = Logger.getLogger(CustomerController.class.getName());

	
	@Autowired
	CustomerService service;

	@CrossOrigin(origins = "http://localhost:5000")
	@GetMapping("/customers")
	public List<CustomerDto> getCustomers() {
		
		logger.info("ACCESS GET CUSTOMERS");
		List<Customer> ls = service.findAllCustomers();
		List<CustomerDto> dtos = new ArrayList<CustomerDto>();
		for (int i = 0; i < ls.size(); i++) {
			dtos.add(entityToDto(ls.get(i)));
		}
		return dtos;
		
	}
	@CrossOrigin(origins = "http://localhost:5000")
	@GetMapping("/customers/{id}")
	public ResponseEntity getCustomer(@PathVariable("id") int id) {

		Customer customer = service.findById(id);
		if (customer == null) {
			return new ResponseEntity("No Customer found for ID " + id, HttpStatus.NOT_FOUND);
		}

		return new ResponseEntity(entityToDto(customer), HttpStatus.OK);
	}
	
	
	@CrossOrigin(origins = "http://localhost:5000")
	@PostMapping(value = "/customers")
	public ResponseEntity createCustomer(@RequestBody CustomerDto dto) {
		
		logger.info("ACCESS CREATE CUSTOMER");
		service.create(dtoToEntity(dto, true));
		return new ResponseEntity(dto, HttpStatus.OK);
	}
	
	
	
	@CrossOrigin(origins = "http://localhost:5000")
	@DeleteMapping("/customers/{id}")
	public ResponseEntity deleteCustomer(@PathVariable int id) {

		service.delete(id);
		//if (null == customerDao.delete(id)) {
		//	return new ResponseEntity("No Customer found for ID " + id, HttpStatus.NOT_FOUND);
		//}

		return new ResponseEntity(id, HttpStatus.OK);

	}
	
	
	@CrossOrigin(origins = "http://localhost:5000")
	@PutMapping("/customers/{id}")
	public ResponseEntity updateCustomer(@PathVariable Long id, @RequestBody CustomerDto dto) {

		logger.info("ACCESS UPDATE CUSTOMERS");
		service.update(dtoToEntity(dto, false));

		//if (null == customer) {
		//	return new ResponseEntity("No Customer found for ID " + id, HttpStatus.NOT_FOUND);
		//}

		return new ResponseEntity(dto, HttpStatus.OK);
	}
	
	private CustomerDto entityToDto(Customer customer) {
		
		CustomerDto dto = new CustomerDto();
		dto.setId(customer.getId());
		dto.setFirstName(customer.getFirstName());
		dto.setLastName(customer.getLastName());
		dto.setEmail(customer.getEmail());
		dto.setMobile(customer.getMobile());
		dto.setDateOfBirth(customer.getDateOfBirth().toString());
		return dto;
	}
	
	private Customer dtoToEntity(CustomerDto dto, boolean bNewRecord ) {
		
		Customer customer = new Customer();
		if(!bNewRecord) {
			customer.setId(dto.getId());
		}
    	//ee.setId(employee.getId()); // skip this for sequence id be generated.
		customer.setFirstName(dto.getFirstName());
		customer.setLastName(dto.getLastName());
		customer.setEmail(dto.getEmail());
		//customer.setMobile(dto.getMobile());
		customer.setMobile("703-249-5150");
		customer.setDateOfBirth(LocalDate.parse(dto.getDateOfBirth()));
		//customer.setDateOfBirth(LocalDate.now());		
		return customer;
	}
	
	
}
