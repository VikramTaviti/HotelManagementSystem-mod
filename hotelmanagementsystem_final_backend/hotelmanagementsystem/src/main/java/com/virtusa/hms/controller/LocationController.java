package com.virtusa.hms.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.virtusa.hms.entity.hotel.Location;
import com.virtusa.hms.exceptions.LocationAlreadyExistException;
import com.virtusa.hms.service.LocationService;
import com.virtusa.hms.utility.LocationDto;
import com.virtusa.hms.utility.Message;

import jakarta.validation.Valid;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class LocationController {
	
	@Autowired
	private LocationService locationService;
	
	@PostMapping("/add/location")
	public ResponseEntity<Message> addLocation(@Valid @RequestBody LocationDto locationDto) throws LocationAlreadyExistException{
		String message = locationService.addLocation(locationDto);
		return ResponseEntity.status(HttpStatus.OK).body(new Message(message));
	}
	
	@GetMapping("/get/location/{streetNumber}")
	public ResponseEntity<Location> getLocationByStreet(@PathVariable String streetNumber){
		Location location = locationService.getLocationByStreetNumber(streetNumber);
		return ResponseEntity.status(HttpStatus.OK).body(location);
	}
}
