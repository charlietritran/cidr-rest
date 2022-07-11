package com.cidr.rest.controller;



import java.util.logging.Logger;


import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import com.cidr.rest.model.*;




@RestController
@RequestMapping("/login")
public class LoginController {
	
	private static final Logger logger = Logger.getLogger(LoginController.class.getName());

    @CrossOrigin(origins = "http://localhost:5000")
    @PostMapping
    public ResponseEntity<String>  getToken(@RequestBody Login login) {
    	logger.info("USERNAME:" + login.getUserName());
    	logger.info("PWD:" + login.getPassword());
    	if(login.getUserName().equals("admin")) {
    		return ResponseEntity.ok("{'token':'test12345'}");
    	}else {
    		return ResponseEntity.ok(null);
    	}
    }
    
}



