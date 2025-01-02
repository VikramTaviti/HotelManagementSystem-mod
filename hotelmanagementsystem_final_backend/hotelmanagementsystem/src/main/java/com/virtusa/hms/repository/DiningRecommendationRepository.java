package com.virtusa.hms.repository;

import java.util.List; 

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.virtusa.hms.entity.hotel.DiningRecommendation;

@Repository
public interface DiningRecommendationRepository extends JpaRepository<DiningRecommendation, String> {

	public DiningRecommendation findByDiningRecommendationEmail(String email);
	
	@Query("select d from DiningRecommendation d where d.location.street =:street and d.location.city =:city and d.location.state =:state and d.location.pincode =:pincode and d.location.country =:country")
	public List<DiningRecommendation> findDiningRecommendationsByLocation(
			@Param("street") String street,
			@Param("city") String city,
			@Param("state") String state,
			@Param("pincode") int pincode,
			@Param("country") String country);
	
	@Query("select d from DiningRecommendation d where d.diningId=:diningId")
	public DiningRecommendation getDiningRecommendationById(@Param("diningId") String diningId);

	@Query("select d from DiningRecommendation d where d.location.street =:street and d.location.city =:city")
	public List<DiningRecommendation> getAllDiningRecommendationsByStreetAndCity(@Param("street") String street,@Param("city") String city);

}
