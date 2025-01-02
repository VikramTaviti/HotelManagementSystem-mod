package com.virtusa.hms.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.virtusa.hms.entity.hotel.Review;

public interface ReviewRepository extends JpaRepository<Review, String> {

	@Query("SELECT r FROM Review r WHERE r.user.userId=:userId AND r.hotel.hotelId=:hotelId")
	public Review getReviewByHotelIdAndUserId(@Param("hotelId") String hotelId,@Param("userId") String userId);

	@Query("SELECT r FROM Review r WHERE r.user.userId=:userId AND r.diningRecommendation.diningId=:diningId")
	public Review getReviewByDiningIdAndUserId(@Param("diningId") String diningId,@Param("userId") String userId);

	@Query("SELECT r FROM Review r WHERE r.hotel.hotelId=:hotelId")
	public List<Review> getReviewByHotelId(@Param("hotelId") String hotelId);

	@Query("SELECT r FROM Review r WHERE r.diningRecommendation.diningId=:diningId")
	public List<Review> getReviewByDiningId(@Param("diningId") String diningId);

}
