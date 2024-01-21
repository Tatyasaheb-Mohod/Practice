package com.example.test;

import static org.mockito.Mockito.when;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import com.example.rest.MsgController;
import com.example.service.Service;

@WebMvcTest(value=MsgController.class)
public class TestRestApi {
	
	@MockBean
	private Service service;
	
	@Autowired
	private MockMvc mvc;
	
	@Test
	public void testMethod() throws Exception  {
		
		
	//Prepare Behaviour Of mock object
	 when(service.getWelcomeMsg()).thenReturn("hello");
	 
	 //Prepare Http Request for sending to test class to restcontroller
	 MockHttpServletRequestBuilder mockHttpServletRequestBuilder = MockMvcRequestBuilders.get("/welcome");
	 
	 MvcResult andReturn = mvc.perform(mockHttpServletRequestBuilder).andReturn();
	 
	 MockHttpServletResponse response = andReturn.getResponse();
	 
	 String contentAsString = response.getContentAsString();
	 
	 int status = response.getStatus();
	 
	 
	Assertions.assertEquals(200,status);
	 
	 

		
	}
	
	
	
	

}
