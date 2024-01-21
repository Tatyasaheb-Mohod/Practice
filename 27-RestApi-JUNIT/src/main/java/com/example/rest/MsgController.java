package com.example.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.service.Service;

@RestController
public class MsgController {
	
	@Autowired
	private Service service;
	
	@GetMapping("/welcome")
	public ResponseEntity<String> getMsg(){
		
		String welcomeMsg = service.getWelcomeMsg();
		String upperCase = welcomeMsg.toUpperCase();
		
		
		return new ResponseEntity<>(upperCase, HttpStatus.OK);
		
		
		
	}

}
