package com.virtusa.hms.utility;

import java.util.List;

public class LoginResponse {
	private String jwtToken;

	private String username;
	
	private String firstName;
	
	private String userId;
	
	private List<String> role;

	public LoginResponse(String jwtToken, String username, String firstName, String userId, List<String> role) {
		super();
		this.jwtToken = jwtToken;
		this.username = username;
		this.firstName = firstName;
		this.userId = userId;
		this.role = role;
	}

	public LoginResponse() {
		super();
	}

	public String getJwtToken() {
		return jwtToken;
	}

	public void setJwtToken(String jwtToken) {
		this.jwtToken = jwtToken;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public List<String> getRole() {
		return role;
	}

	public void setRole(List<String> role) {
		this.role = role;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}	
	
}
