package com.virtusa.hms.utility; 

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;

import com.virtusa.hms.entity.user.Role;

public class UserDto {

	private String userId;
	
	@NotNull
	@Size(min = 3, max = 25)
	private String firstName;
	
	@NotNull
	@Size(min = 3, max = 25)
	private String lastName;
	
	@NotNull
	@Pattern(regexp = "^[0-9]{10}$")
	private String phoneNo;
	
	@NotNull
	@Pattern(regexp = "^[a-zA-Z0-9.!#$%&'*+/=?^_`{|}~-]{1,64}@(?:[a-zA-Z0-9-]{1,63}\\.){1,8}[a-zA-Z]{2,63}$")
	private String email;
	
	@NotNull
	@Pattern(regexp = "^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d)(?=.*[@._-])[A-Za-z\\d@._-]{8,}$")
	private String password;
	
	private Role role;

	public UserDto() {
		super();
	}

	public UserDto(String firstName, String lastName, String phoneNo, String email, String password, Role role) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.phoneNo = phoneNo;
		this.email = email;
		this.password = password;
		this.role = role;
	}

	public UserDto(String email, String password) {
		super();
		this.email = email;
		this.password = password;
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

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getPhoneNo() {
		return phoneNo;
	}

	public void setPhoneNo(String phoneNo) {
		this.phoneNo = phoneNo;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Role getRole() {
		return role;
	}

	public void setRole(Role role) {
		this.role = role;
	}

	@Override
	public String toString() {
		return "User [firstName=" + firstName + ", lastName=" + lastName + ", phoneNo=" + phoneNo + ", email=" + email
				+ ", password=" + password + ", role=" + role + "]";
	}

}

