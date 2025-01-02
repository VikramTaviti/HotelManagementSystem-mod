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

import com.virtusa.hms.exceptions.AttractionNotFoundException;
import com.virtusa.hms.exceptions.LocationAlreadyExistException;
import com.virtusa.hms.service.AttractionService;
import com.virtusa.hms.utility.AttractionDto;
import com.virtusa.hms.utility.Message;

import jakarta.validation.Valid;

@RestController
@Validated
@RequestMapping("/attractions")
@CrossOrigin(origins = "http://localhost:4200")
public class AttractionController {
	
	@Autowired
	private AttractionService attractionService;
	
	@Autowired
	private Message message;
	
	@PostMapping("/add")
	public ResponseEntity<Message> insertAttractionDetails(@Valid @RequestBody AttractionDto attractionDto) throws LocationAlreadyExistException{
		String response = attractionService.insertAttractionDetails(attractionDto);
		message.setMessage(response);
		return ResponseEntity.status(HttpStatus.CREATED).body(message);
	}
	
	@GetMapping("/allAttractions")
	public ResponseEntity<List<AttractionDto>> getAllAttractionDetails(){
		List<AttractionDto> attractions = attractionService.getgetAllAttractionDetails();
		return ResponseEntity.ok(attractions);
	}
	
	@GetMapping("/{attractionId}")
	public ResponseEntity<AttractionDto> getAttractionDetailsByEmail(@PathVariable String attractionId){
		return ResponseEntity.status(HttpStatus.OK).body(attractionService.getAttractionDetailsByAttractionId(attractionId));
	} 
	
	@PutMapping("/edit")
	public ResponseEntity<Message> updateAttractionDetails(@Valid @RequestBody AttractionDto attractionDto){
		return ResponseEntity.status(HttpStatus.CREATED).body(new Message(attractionService.updateAttractionDetails(attractionDto)));
	}
	
	@DeleteMapping("/delete/{attractionId}")
	public ResponseEntity<Message> deleteAttractionDetails(@PathVariable String attractionId){
		return ResponseEntity.ok().body(new Message(attractionService.deleteAttractionDetails(attractionId)));
	}
	
	@GetMapping("/allAttractions/{street}/{city}")
	public ResponseEntity<List<AttractionDto>> getAllAttractionDetailsByStreetAndCity(@PathVariable("street") String street,@PathVariable("city") String city) throws AttractionNotFoundException{
		List<AttractionDto> attractions = attractionService.getAllAttractionDetailsByStreetAndCity(street,city);
		return ResponseEntity.ok(attractions);
	} 

}
