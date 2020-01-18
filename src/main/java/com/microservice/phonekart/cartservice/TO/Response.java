package com.microservice.phonekart.cartservice.TO;

import java.io.Serializable;
import java.util.List;

public class Response implements Serializable {

	private static final long serialVersionUID = -8091879091924046844L;
	private String token;

	private String message;

	private String error;
	
	private List<OrderTO> order;

	public Response(String token) {
		this.token = token;
	}

	public String getToken() {
		return this.token;
	}

	public void setToken(String token) {
		this.token = token;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public String getError() {
		return error;
	}

	public void setError(String error) {
		this.error = error;
	}

	public List<OrderTO> getOrder() {
		return order;
	}

	public void setOrder(List<OrderTO> order) {
		this.order = order;
	}
}
