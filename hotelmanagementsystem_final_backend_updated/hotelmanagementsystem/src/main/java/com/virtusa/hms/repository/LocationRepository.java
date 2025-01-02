package com.virtusa.hms.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.virtusa.hms.entity.hotel.Location;

@Repository
public interface LocationRepository extends JpaRepository<Location, String> {
	
	@Query("select l from Location l where l.streetNumber=:streetNumber and l.street =:street and l.city =:city and l.state =:state and l.pincode =:pincode and l.country =:country ")
	public Location getLocationByLocationDetails(
			@Param("streetNumber") String streetNumber,
			@Param("street") String street,
			@Param("city") String city,
			@Param("state") String state,
			@Param("pincode") int pincode,
			@Param("country") String country);
	
	@Query("select l from Location l where l.streetNumber =:streetNumber")
	public Location getLocationByStreetNumber(@Param("streetNumber") String streetNumber);
	
	
}
