package com.virtusa.hms.repository;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.virtusa.hms.entity.Status;
import com.virtusa.hms.entity.hotel.Hotel;

@Repository
public interface HotelRepository extends JpaRepository<Hotel, String> {

	public Hotel findByHotelEmail(String hotelEmail);

	@Query("select h from Hotel h where h.location.street =:street and h.location.city =:city and h.location.state =:state and h.location.pincode =:pincode and h.location.country =:country")
	public List<Hotel> findHotelsByLocation(
	        @Param("street") String street,
	        @Param("city") String city,
	        @Param("state") String state,
	        @Param("pincode") int pincode,
	        @Param("country") String country);
	
	@Query("SELECT h FROM Hotel h " + "JOIN h.rooms r " + "WHERE h.location.city = :city "
			+ "AND h.location.street = :street " + "AND r.roomType = :roomType " + "AND NOT EXISTS ("
			+ "SELECT 1 FROM Booking b " + "WHERE b.room = r "
			+ "AND ((b.checkIn <= :checkoutDate AND b.checkOut >= :checkinDate) "
			+ "AND (b.bookingStatus <> :cancelledStatus))" + ")")
	public List<Hotel> getAvailableHotelByLocationAndCheckInAndCheckOutDates(
			@Param("city") String city,
			@Param("street") String street,
			@Param("roomType") String roomType,
			@Param("checkinDate") LocalDate checkinDate,
			@Param("checkoutDate") LocalDate checkoutDate,
			@Param("cancelledStatus") Status cancelledStatus);
	
	@Query("SELECT h FROM Hotel h WHERE h.hotelId=:hotelId")
	public Hotel getHotelById(@Param("hotelId") String hotelId);

}
