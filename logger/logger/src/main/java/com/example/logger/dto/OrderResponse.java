package com.example.logger.dto;

public class OrderResponse {
	
	private String emailId;
	private String productName;
	
	public OrderResponse() {
		super();
	}
	public OrderResponse(String emailId, String productName) {
		super();
		this.emailId = emailId;
		this.productName = productName;
	}
	public String getEmailId() {
		return emailId;
	}
	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}
	public String getProductName() {
		return productName;
	}
	public void setProductName(String productName) {
		this.productName = productName;
	}
	@Override
	public String toString() {
		return "OrderResponse [emailId=" + emailId + ", productName=" + productName + "]";
	}

}
