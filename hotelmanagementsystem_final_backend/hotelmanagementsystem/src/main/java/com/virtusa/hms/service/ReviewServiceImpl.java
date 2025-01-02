package com.virtusa.hms.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.virtusa.hms.converter.ListDtoEntityConverter;
import com.virtusa.hms.entity.hotel.DiningRecommendation;
import com.virtusa.hms.entity.hotel.Hotel;
import com.virtusa.hms.entity.hotel.Review;
import com.virtusa.hms.entity.user.User;
import com.virtusa.hms.exceptions.ReviewsNotFoundException;
import com.virtusa.hms.repository.DiningRecommendationRepository;
import com.virtusa.hms.repository.HotelRepository;
import com.virtusa.hms.repository.ReviewRepository;
import com.virtusa.hms.repository.UserRepository;
import com.virtusa.hms.utility.DiningRecommendationDto;
import com.virtusa.hms.utility.HotelDto;
import com.virtusa.hms.utility.ReviewDto;
import com.virtusa.hms.utility.UserDto;

@Service
public class ReviewServiceImpl implements ReviewService {

	@Autowired
	private ReviewRepository reviewRepository;

	@Autowired
	private HotelRepository hotelRepository;

	@Autowired
	private UserRepository userRepository;

	@Autowired
	private DiningRecommendationRepository diningRecommendationRepository;

	@Autowired
	private ListDtoEntityConverter listDtoEntityConverter;

	@Override
	public String addReviewByHotelIdAndUserId(String hotelId, String userId, ReviewDto reviewDto) {
		Review existingReview = reviewRepository.getReviewByHotelIdAndUserId(hotelId, userId);

		if (existingReview != null) {
			Review review = listDtoEntityConverter.convertReviewDtoToEntity(reviewDto);
			existingReview.setComment(review.getComment());
			existingReview.setRating(review.getRating());
			reviewRepository.save(existingReview);
			return "Review Saved Successfully";
		}

		Hotel hotel = hotelRepository.getHotelById(hotelId);
		HotelDto hotelDto = listDtoEntityConverter.convertHotelEntityToDto(hotel);
		User user = userRepository.getUserByUserId(userId);
		UserDto userDto = listDtoEntityConverter.convertUserEntityToDto(user);
		reviewDto.setHotelDto(hotelDto);
		reviewDto.setUserDto(userDto);
		Review review = listDtoEntityConverter.convertReviewDtoToEntity(reviewDto);
		reviewRepository.save(review);
		return "Review Saved Successfully";
	}

	@Override
	public String addReviewByDiningIdAndUserId(String diningId, String userId, ReviewDto reviewDto) {
		Review existingReview = reviewRepository.getReviewByDiningIdAndUserId(diningId, userId);
		
		if (existingReview != null) {
			Review review = listDtoEntityConverter.convertReviewDtoToEntity(reviewDto);
			review.setComment(existingReview.getComment());
			review.setRating(existingReview.getRating());
			reviewRepository.save(existingReview);
			return "Review Saved Successfully";
		}
		DiningRecommendation diningRecommendation = diningRecommendationRepository.getDiningRecommendationById(diningId);
		DiningRecommendationDto diningRecommendationDto = listDtoEntityConverter.convertDiningRecommendationEntityToDto(diningRecommendation);
		User user = userRepository.getUserByUserId(userId);
		UserDto userDto = listDtoEntityConverter.convertUserEntityToDto(user);
		reviewDto.setDiningRecommendationDto(diningRecommendationDto);
		reviewDto.setUserDto(userDto);
		Review review = listDtoEntityConverter.convertReviewDtoToEntity(reviewDto);
		reviewRepository.save(review);
		return "Review Saved Successfully";
	}

	@Override
	public List<ReviewDto> getgetAllReviewsByHotelId(String hotelId) throws ReviewsNotFoundException {
		List<Review> reviewList = reviewRepository.getReviewByHotelId(hotelId);
		if(reviewList == null) {
			throw new ReviewsNotFoundException("No Reviews Data Found");
		}
		return listDtoEntityConverter.convertReviewEntityListToDto(reviewList);
	}

	@Override
	public List<ReviewDto> getAllReviewsByDiningId(String diningId) throws ReviewsNotFoundException {
		List<Review> reviewList = reviewRepository.getReviewByDiningId(diningId);
		if(reviewList == null) {
			throw new ReviewsNotFoundException("No Reviews Data Found");
		}
		return listDtoEntityConverter.convertReviewEntityListToDto(reviewList);
	}

}
