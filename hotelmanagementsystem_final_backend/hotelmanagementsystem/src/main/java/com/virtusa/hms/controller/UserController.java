package com.virtusa.hms.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.virtusa.hms.entity.user.Role;
import com.virtusa.hms.jwt.JwtUtils;
import com.virtusa.hms.service.UserService;
import com.virtusa.hms.utility.LoginRequest;
import com.virtusa.hms.utility.LoginResponse;
import com.virtusa.hms.utility.Message;
import com.virtusa.hms.utility.UserDto;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/users")
@CrossOrigin(origins = "http://localhost:4200")
public class UserController {

	@Autowired
	private UserService userService;
	
	@Autowired
    private JwtUtils jwtUtils;

    @Autowired
    private AuthenticationManager authenticationManager;
    
    @Autowired
    private Message message;


	@PostMapping("/register")
	public ResponseEntity<Message> insertUserDetails(@Valid @RequestBody UserDto userDto) {
		userDto.setRole(Role.USER);
		String responseMessage = userService.insertUserDetails(userDto);
		message.setMessage(responseMessage);
		return ResponseEntity.status(HttpStatus.CREATED).body(message);
	}
	
	@PutMapping("/editUser")
	public ResponseEntity<Message> updateUserDetails(@Valid @RequestBody UserDto userDto ){
		String response = userService.updateUserDetails(userDto);
		message.setMessage(response);
		return ResponseEntity.status(HttpStatus.CREATED).body(message);
	}
	
	@GetMapping("/{email}")
	public ResponseEntity<UserDto> getUserDetailsByEmail(@PathVariable String email){
		return ResponseEntity.status(HttpStatus.OK).body(userService.getUserDetailsByEmail(email));
	} 
	
	@GetMapping("/singleUser/{userId}")
	public ResponseEntity<UserDto> getUserDetailsByUserId(@PathVariable String userId){
		UserDto userDto = userService.getUserDetailsByUserId(userId);
		return ResponseEntity.status(HttpStatus.OK).body(userDto);
	}
	
	
	@PostMapping("/signin")
    public ResponseEntity<?> authenticateUser(@RequestBody LoginRequest loginRequest) {
        Authentication authentication;
        try {
            authentication = authenticationManager
                    .authenticate(new UsernamePasswordAuthenticationToken(loginRequest.getEmail(), loginRequest.getPassword()));
        } catch (AuthenticationException exception) {
            Map<String, Object> map = new HashMap<>();
            map.put("message", "Incorrect credentials or account doesn't exist!");
            map.put("status", false);
            return new ResponseEntity<Object>(map, HttpStatus.NOT_FOUND);
        }

        SecurityContextHolder.getContext().setAuthentication(authentication);

        UserDetails userDetails = (UserDetails) authentication.getPrincipal();

        String jwtToken = jwtUtils.generateTokenFromUsername(userDetails);

        List<String> roles = userDetails.getAuthorities().stream()
                .map(item -> item.getAuthority())
                .collect(Collectors.toList());
        
        UserDto userDto = userService.getUserDetailsByEmail(loginRequest.getEmail());

        LoginResponse response = new LoginResponse(jwtToken,userDetails.getUsername(),userDto.getFirstName(),userDto.getUserId(), roles);

        return ResponseEntity.ok(response);
    }
	
	@DeleteMapping("{userId}")
	public ResponseEntity<Message> deleteUserByUserId(@PathVariable String userId){
		String response = userService.deleteUserByUserId(userId);
		message.setMessage(response);
		return ResponseEntity.status(HttpStatus.OK).body(message);
	}


}
