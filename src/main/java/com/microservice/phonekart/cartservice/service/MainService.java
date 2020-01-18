package com.microservice.phonekart.cartservice.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.microservice.phonekart.cartservice.TO.OrderTO;
import com.microservice.phonekart.cartservice.repository.CartRepository;

@Service
public class MainService {

	@Autowired
	CartRepository cartRepo;

	
	public List<OrderTO> getBookedOrder()  {
		return cartRepo.getLimitedOrders(10101, "Shipped");
	}
}
