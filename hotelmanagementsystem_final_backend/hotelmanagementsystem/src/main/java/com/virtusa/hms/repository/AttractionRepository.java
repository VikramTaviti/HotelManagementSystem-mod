package com.virtusa.hms.repository;

import java.util.List;  

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.virtusa.hms.entity.hotel.Attraction;

@Repository
public interface AttractionRepository extends JpaRepository<Attraction, String> {

	//@Query("select a from Attraction a where a.email =:email")
	//public Attraction findByEmail( String email);
	
	public Attraction findByAttractionEmail(String email);
	
	@Query("select a from Attraction a where a.location.street =:street and a.location.city =:city and a.location.state =:state and a.location.pincode =:pincode and a.location.country =:country")
	public List<Attraction> findAttractionByLocation(
			@Param("street") String street,
			@Param("city") String city,
			@Param("state") String state,
			@Param("pincode") int pincode,
			@Param("country") String country
			);
	
	@Query("SELECT a FROM Attraction a")
	public List<Attraction> findAllAttractions();

	@Query("SELECT a FROM Attraction a WHERE a.location.street=:street AND a.location.city=:city")
	public List<Attraction> getAllAttractionDetailsByStreetAndCity(@Param("street") String street,@Param("city") String city);
	
	
}
