package com.microservice.phonekart.cartservice.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MyCartController {

	
	@LocalServerPort
	 int randomPort;
	
	@GetMapping(path="/mycart/getTotalItems")
	public String getCartCount() {
		

		Integer port = randomPort; 
		
		String x= port.toString();
		
		return "any Number of items " + x;
	}
}
