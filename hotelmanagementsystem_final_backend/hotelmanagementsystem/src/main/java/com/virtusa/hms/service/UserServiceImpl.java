package com.virtusa.hms.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.virtusa.hms.converter.ListDtoEntityConverter;
import com.virtusa.hms.entity.user.User;
import com.virtusa.hms.exceptions.EmailAlreadyExistsException;
import com.virtusa.hms.exceptions.EmailNotFoundException;
import com.virtusa.hms.repository.UserRepository;
import com.virtusa.hms.utility.UserDto;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserRepository userRepository;

	@Autowired
	private ListDtoEntityConverter listDtoEntityConverter;
	
	@Autowired
	private PasswordEncoder passwordEncoder;


	@Override
	public String insertUserDetails(UserDto userDto) {
		try {
			User user = listDtoEntityConverter.convertUserDtoToEntity(userDto);
			user.setPassword(passwordEncoder.encode(user.getPassword()));
			userRepository.save(user);
		} catch (DataIntegrityViolationException e) {
			throw new EmailAlreadyExistsException("Email or Phone Number already exists. Use different Email or Phone Number.");
		}
		return "User details inserted successfully";
	}

	@Override
	public String updateUserDetails(UserDto userDto) {
		try {
			User user = listDtoEntityConverter.convertUserDtoToEntity(userDto);
			User existingUserDetails = userRepository.getUserByUserId(user.getUserId());
			user.setPassword(existingUserDetails.getPassword());
			userRepository.save(user);
		} catch (DataIntegrityViolationException e) {
			throw new EmailAlreadyExistsException("Email already exists. Please provide a different email.");
		}
		return "User details updated successfully";
	}

	@Override
	public UserDto getUserDetailsByEmail(String email) {
	 	    User user = userRepository.getUserByUserEmail(email);
	    if (user == null) {
	        throw new EmailNotFoundException("Email not found in the database.");
	    }
	    UserDto userDto = listDtoEntityConverter.convertUserEntityToDto(user);
	    return userDto;
	}

	@Override
	public UserDto getUserDetailsByUserId(String userId) {
		User user = userRepository.getUserByUserId(userId);
		return listDtoEntityConverter.convertUserEntityToDto(user);
	}

	@Override
	public String deleteUserByUserId(String userId) {
		User user = userRepository.getUserByUserId(userId);
		userRepository.delete(user);
		return "Your account is deleted successfully...";
	}


}
