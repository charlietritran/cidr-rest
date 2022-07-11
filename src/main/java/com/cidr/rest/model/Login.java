package com.cidr.rest.model;


public class Login {


    private Long id;

    private String userName;
    private String password;

    // getter, setters, contructors
    
    public Login() {
    	
    }
    
    public void setId(Long id) {
    	this.id = id;
    }
    public Long getId() {
    	return this.id;
    }
    
    public void setUserName(String userName) {
    	this.userName = userName;
    }
    public String getUserName() {
    	return userName;
    }
    
    public void setPassword(String password) {
    	this.password = password;
    }
    public String getPassword() {
    	return this.password;
    }
}
