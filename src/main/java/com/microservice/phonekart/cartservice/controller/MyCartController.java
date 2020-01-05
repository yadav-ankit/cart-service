package com.microservice.phonekart.cartservice.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MyCartController {

	@Autowired
	Environment  environment;
	
	@GetMapping(path="/mycart/getTotalItems")
	public String getCartCount() {
		
		return "any Number of items " + environment.getProperty("local.server.port");
	}
}
