package com.cidr.rest.controller;

import java.math.BigDecimal;
//import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

import java.util.Locale;

import javax.validation.Valid;

import org.joda.time.LocalDate;
import org.joda.time.format.DateTimeFormatter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;
import com.cidr.rest.dto.*;
import com.cidr.rest.model.*;
import com.cidr.rest.service.*;

import java.util.logging.Logger;

@RestController
@RequestMapping("/")
public class EmployeeController {
	
	
	private static final Logger logger = Logger.getLogger(EmployeeController.class.getName());

	@Autowired
	EmployeeService service;
	
	@Autowired
	MessageSource messageSource;
	
	@CrossOrigin(origins = "http://localhost:5000")
	@GetMapping("/employees")
	public List getEmployees() {
		List<Employee> ee = service.findAllEmployees();
		List<EmployeeDto> eDtos = new ArrayList<EmployeeDto>();
		for (int i = 0; i < eDtos.size(); i++) {
			EmployeeDto eDto = new EmployeeDto();
			eDto.setId(ee.get(i).getId());
			eDto.setName(ee.get(i).getName());
			eDto.setSsn(ee.get(i).getSsn());
			eDto.setSalary(ee.get(i).getSalary().intValue());
			eDto.setJoiningDate(ee.get(i).getJoiningDate().toString());
			eDtos.add(eDto);
			
		}
		return eDtos;

	}
	
	@CrossOrigin(origins = "http://localhost:5000")
	@PostMapping(value = "/employees")
	public ResponseEntity createEmployee(@RequestBody EmployeeDto eDto) {
    	logger.info("ID:" + eDto.getId());
    	logger.info("NAME:" + eDto.getName());
    	
    	Employee ee = new Employee();
    	//ee.setId(employee.getId()); // skip this for sequence id be generated.
    	ee.setName(eDto.getName());
    	ee.setSalary(new BigDecimal(eDto.getSalary()));
    	ee.setSsn(eDto.getSsn());
		ee.setJoiningDate(LocalDate.parse(eDto.getJoiningDate()));
    	
    	
		service.saveEmployee(ee);
		return new ResponseEntity(eDto, HttpStatus.OK);
	}


}
