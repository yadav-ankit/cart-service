package com.microservice.phonekart.cartservice.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.core.env.Environment;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.microservice.phonekart.cartservice.TO.OrderTO;
import com.microservice.phonekart.cartservice.TO.Response;
import com.microservice.phonekart.cartservice.service.MainService;

@RestController
public class MyCartController {

	@Autowired
	Environment  environment;
	
	@Autowired
	MainService cartService;
	
	@GetMapping(path="/mycart/getTotalItems")
	public String getCartCount() {
		
		return "Items returned from CartService : " + environment.getProperty("local.server.port");
	}
	
	

	@GetMapping(path="/mycart/getOrder")
	public ResponseEntity<?> getCartOrder() {
		
		Response response = new Response("anything");
		
		List<OrderTO> orders =  cartService.getBookedOrder();
		
		response.setOrder(orders);
		response.setMessage("Hope it works in  first time !!!");
		
		return ResponseEntity.ok(response);
	}
	
	
}
