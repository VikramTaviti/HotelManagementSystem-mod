package com.virtusa.hms.service;

import com.virtusa.hms.utility.UserDto;

public interface UserService {

	public String insertUserDetails(UserDto userDto);

	public String updateUserDetails(UserDto userDto);

	public UserDto getUserDetailsByEmail(String email);

	public UserDto getUserDetailsByUserId(String userId);

	public String deleteUserByUserId(String userId);


}
