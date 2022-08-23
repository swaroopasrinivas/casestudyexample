package com.example.logger.dto;

import com.example.logger.entity.User;

public class OrderRequest {
	
	private User user;

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public OrderRequest(User user) {
		super();
		this.user = user;
	}

	public OrderRequest() {
		super();
	}

	@Override
	public String toString() {
		return "OrderRequest [user=" + user + "]";
	}

	

}
