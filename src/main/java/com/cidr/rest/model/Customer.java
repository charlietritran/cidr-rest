package com.cidr.rest.model;


import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Digits;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
 
import org.hibernate.annotations.Type;
import org.hibernate.validator.constraints.NotEmpty;
import org.joda.time.LocalDate;
import org.springframework.format.annotation.DateTimeFormat;
 


@Entity
@Table(name="CUSTOMER")
public class Customer {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private int id;
    
    @Size(min=3, max=50)
    @Column(name = "FIRST_NAME", nullable = false)
	private String firstName;
    
    @Size(min=3, max=50)
    @Column(name = "LAST_NAME", nullable = false)
	private String lastName;
    
    @Size(min=10, max=50)
    @Column(name = "EMAIL", nullable = false)
	private String email;
    
    
    @Size(min=3, max=50)
    @Column(name = "MOBILE", nullable = false)
	private String mobile;
    
    @NotNull
    @DateTimeFormat(pattern="dd/MM/yyyy") 
    @Column(name = "DATE_OF_BIRTH", nullable = false)
    @Type(type="org.jadira.usertype.dateandtime.joda.PersistentLocalDate")
 	private LocalDate dateOfBirth;
	

    // ID
	public int getId() {
		return this.id;
	}
	public void setId(int id) {
		this.id = id;
	}
	
	// FIRST NAME
	public String getFirstName() {
		return this.firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	
	// LAST NAME
	public String getLastName() {
		return this.lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	
	public String getEmail() {
		return this.email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	
	// MOBILE
	public String getMobile() {
		return this.mobile;
	}
	public void setMobile(String mobile) {
		this.mobile = mobile;
	}
	
	// DOB
	public LocalDate getDateOfBirth() {
		return this.dateOfBirth;
	}
	public void setDateOfBirth(LocalDate dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}

	//... Getter and setter methods
}
