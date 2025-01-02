package com.virtusa.hms.service;

import java.util.List;

import com.virtusa.hms.exceptions.ReviewsNotFoundException;
import com.virtusa.hms.utility.ReviewDto;

public interface ReviewService {

	public String addReviewByHotelIdAndUserId(String hotelId, String userId,ReviewDto reviewDto);

	public String addReviewByDiningIdAndUserId(String diningId, String userId, ReviewDto reviewDto);

	public List<ReviewDto> getgetAllReviewsByHotelId(String hotelId) throws ReviewsNotFoundException;

	public List<ReviewDto> getAllReviewsByDiningId(String diningId) throws ReviewsNotFoundException;

}
