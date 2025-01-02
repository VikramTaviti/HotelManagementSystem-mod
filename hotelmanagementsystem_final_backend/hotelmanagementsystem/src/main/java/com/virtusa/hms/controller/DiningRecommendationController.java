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

import com.virtusa.hms.exceptions.DiningRecommendationNotFoundException;
import com.virtusa.hms.exceptions.LocationAlreadyExistException;
import com.virtusa.hms.service.DiningRecommendationService;
import com.virtusa.hms.utility.DiningRecommendationDto;
import com.virtusa.hms.utility.Message;

import jakarta.validation.Valid;


@RestController
@Validated
@RequestMapping("/diningRecom")
@CrossOrigin(origins = "http://localhost:4200")
public class DiningRecommendationController {
	
	@Autowired
	private DiningRecommendationService diningRecommendationService;
	
	@Autowired
	private Message message;
	
	
	@PostMapping("/add")
	public ResponseEntity<Message> insertDiningRecommendationDetails(@Valid @RequestBody DiningRecommendationDto diningRecommendationDto) throws LocationAlreadyExistException{
		String response = diningRecommendationService.insertDiningRecommendationDetails(diningRecommendationDto);
		message.setMessage(response);
		return ResponseEntity.status(HttpStatus.CREATED).body(message);
	}
	
	@GetMapping("/alldiningOptions")
	public ResponseEntity<List<DiningRecommendationDto>> getAllDiningRecommendations(){
		return ResponseEntity.status(HttpStatus.OK).body(diningRecommendationService.getAllDiningRecommendations());
	}
	
	@GetMapping("/{diningOptionId}")
	public ResponseEntity<DiningRecommendationDto> getDiningRecommendationDetailsByDiningOptionId(@PathVariable String diningOptionId){
		return ResponseEntity.status(HttpStatus.OK).body(diningRecommendationService.getDiningRecommendationDetailsByDiningOptionId(diningOptionId));
	}
	
	@PutMapping("/edit")
	public ResponseEntity<Message> updateDiningRecommendationDetails(@Valid @RequestBody DiningRecommendationDto diningRecommendationDto){
		String response = diningRecommendationService.updateDiningRecommendationDetails(diningRecommendationDto);
		message.setMessage(response);
		return ResponseEntity.status(HttpStatus.CREATED).body(message);
	}
	
	@DeleteMapping("/{diningOptionId}")
	public ResponseEntity<Message> deleteDiningRecommendationDetails(@PathVariable String diningOptionId){
		String response = diningRecommendationService.deleteDiningRecommendationDetails(diningOptionId);
		message.setMessage(response);
		return ResponseEntity.ok(message);
	}
	
	@GetMapping("/alldiningOptions/{street}/{city}")
	public ResponseEntity<List<DiningRecommendationDto>> getAllDiningRecommendationsByStreetAndCity(@PathVariable("street") String street,@PathVariable("city") String city) throws DiningRecommendationNotFoundException{
		return ResponseEntity.status(HttpStatus.OK).body(diningRecommendationService.getAllDiningRecommendationsByStreetAndCity(street,city));
	}

	
	
}
