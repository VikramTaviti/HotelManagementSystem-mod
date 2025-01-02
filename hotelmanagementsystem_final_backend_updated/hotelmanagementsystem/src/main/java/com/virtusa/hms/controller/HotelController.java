package com.virtusa.hms.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.virtusa.hms.exceptions.HotelNotFoundException;
import com.virtusa.hms.exceptions.LocationAlreadyExistException;
import com.virtusa.hms.service.HotelService;
import com.virtusa.hms.utility.HotelDto;
import com.virtusa.hms.utility.Message;
import com.virtusa.hms.utility.SearchFields;

import jakarta.validation.Valid;

@RestController
@Validated
@RequestMapping("/hotel")
@CrossOrigin(origins = "http://localhost:4200")
public class HotelController {

	@Autowired
	private HotelService hotelService;

	@Autowired
	private Message message;

	@PostMapping("/add")
	public ResponseEntity<Message> insertHotelDetails(@Valid @RequestBody HotelDto hotelDto) throws LocationAlreadyExistException {
		String response = hotelService.insertHotelDetails(hotelDto);
		message.setMessage(response);
		return ResponseEntity.status(HttpStatus.CREATED).body(message);
	}

	@PutMapping("/edit/{hotelId}")
	public ResponseEntity<Message> updateHotelDetails(@PathVariable String hotelId,
			@Valid @RequestBody HotelDto hotelDto) {
		hotelDto.setHotelId(hotelId);
		String response = hotelService.updateHotelDetails(hotelDto);
		message.setMessage(response);
		return ResponseEntity.status(HttpStatus.OK).body(message);
	}

	@GetMapping("/allHotels")
	public ResponseEntity<List<HotelDto>> getAllHotelsDetails() {
		List<HotelDto> hotels = hotelService.getAllHotelDetails();
		return ResponseEntity.ok(hotels);
	}

	@GetMapping("/{hotelId}")
	public ResponseEntity<HotelDto> getHotelDetailsById(@PathVariable String hotelId) {
		return ResponseEntity.status(HttpStatus.OK).body(hotelService.getHotelDetailsById(hotelId));
	}

	@DeleteMapping("/{hotelId}")
	public ResponseEntity<Message> deleteHotelDetails(@PathVariable String hotelId) throws HotelNotFoundException {
		String response = hotelService.deleteHotelDetailsw(hotelId);
		message.setMessage(response);
		return ResponseEntity.ok().body(message);
	}
	
	@PostMapping("/availableHotels")
	public ResponseEntity<List<HotelDto>> getAvailableHotelByLocationAndcheckInAndcheckOutDates(@Valid @RequestBody SearchFields searchFields){
		List<HotelDto> hotels =hotelService.getAvailableHotelByLocationAndcheckInAndcheckOutDates(searchFields);
		return ResponseEntity.ok(hotels);
	}

}
