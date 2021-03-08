package com.example.product.model;

public class AuthRequest {
	private String userEmail;
	private String userPwd;

	public String getUserEmail() {
		return userEmail;
	}
	public void setUserEmail(String userEmail) {
		this.userEmail = userEmail;
	}
	public String getUserPwd() {
		return userPwd;
	}
	public void setUserPwd(String userPwd) {
		this.userPwd = userPwd;
	}
	
	public AuthRequest(String userEmail, String userPwd) {
		super();
		this.userEmail = userEmail;
		this.userPwd = userPwd;
	}
	
	public AuthRequest() {
		super();
	}
}
