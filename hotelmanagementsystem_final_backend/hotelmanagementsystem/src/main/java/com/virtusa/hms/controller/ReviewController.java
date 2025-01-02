package com.virtusa.hms.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.virtusa.hms.exceptions.ReviewsNotFoundException;
import com.virtusa.hms.service.ReviewService;
import com.virtusa.hms.utility.Message;
import com.virtusa.hms.utility.ReviewDto;

@RestController
@RequestMapping("/review")
@CrossOrigin(origins = "http://localhost:4200")
public class ReviewController {

	@Autowired
	private ReviewService reviewService;
	
	@Autowired
	private Message message;
	
	@PostMapping("/add/hotel/{hotelId}/{userId}")
	public ResponseEntity<Message> addReviewByHotelIdAndUserId(@PathVariable("hotelId") String hotelId,@PathVariable("userId") String userId,@RequestBody ReviewDto reviewDto){
		String response = reviewService.addReviewByHotelIdAndUserId(hotelId,userId,reviewDto);
		message.setMessage(response);
		return ResponseEntity.status(HttpStatus.CREATED).body(message);
	}
	
	@PostMapping("/add/dining/{diningId}/{userId}")
	public ResponseEntity<Message> addReviewByDiningIdAndUserId(@PathVariable("diningId") String diningId,@PathVariable("userId") String userId,@RequestBody ReviewDto reviewDto){
		String response = reviewService.addReviewByDiningIdAndUserId(diningId,userId,reviewDto);
		message.setMessage(response);
		return ResponseEntity.status(HttpStatus.CREATED).body(message);
	}
	
	@GetMapping("/get/hotel/{hotelId}")
	public ResponseEntity<List<ReviewDto>> getAllReviewsByHotelId(@PathVariable("hotelId") String hotelId) throws ReviewsNotFoundException {
		List<ReviewDto> reviewsList = reviewService.getgetAllReviewsByHotelId(hotelId);
		return ResponseEntity.status(HttpStatus.OK).body(reviewsList);
	}
	
	@GetMapping("/get/dining/{diningId}")
	public ResponseEntity<List<ReviewDto>> getAllReviewsByDiningId(@PathVariable("diningId") String diningId) throws ReviewsNotFoundException {
		List<ReviewDto> reviewsList = reviewService.getAllReviewsByDiningId(diningId);
		return ResponseEntity.status(HttpStatus.OK).body(reviewsList);
	}
	
	
	
}
