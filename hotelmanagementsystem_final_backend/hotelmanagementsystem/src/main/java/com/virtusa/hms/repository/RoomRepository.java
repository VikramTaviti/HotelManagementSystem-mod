package com.virtusa.hms.repository;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.virtusa.hms.entity.room.Room;

@Repository
public interface RoomRepository extends JpaRepository<Room, String> {

    @Query("SELECT r FROM Room r where r.hotel.hotelId= :hotelId")
	public List<Room> getRoomsInHotelByHotelId(@Param("hotelId") String hotelId);

    @Query("SELECT r FROM Room r WHERE r.hotel.hotelId = :hotelId " +
            "AND r.roomType = :roomType " +
            "AND NOT EXISTS (SELECT b FROM Booking b WHERE b.room = r " +
            "AND ((b.checkIn <= :checkOut AND b.checkOut >= :checkIn) " +
            "AND b.bookingStatus <> 'CANCELLED'))")
    List<Room> getAvailableRoomsInHotelByHotelIdAndRoomType(
            @Param("hotelId") String hotelId,
            @Param("roomType") String roomType,
            @Param("checkIn") LocalDate checkInDate,
            @Param("checkOut") LocalDate checkOutDate);

    
    @Query("SELECT COUNT(DISTINCT r.roomNo) FROM Room r JOIN r.bookings b " +
            "WHERE r.hotel.hotelId = :hotelId AND b.checkIn <= :currentDate AND b.checkOut >= :currentDate " +
            "AND b.bookingStatus = 'CONFIRMED'")
    long countOccupiedRoomsByHotel(@Param("hotelId") String hotelId, @Param("currentDate") LocalDate currentDate);

 
    
    @Query("SELECT COALESCE(SUM(r.price), 0) FROM Room r JOIN r.bookings b " +
            "WHERE b.bookingStatus = 'CONFIRMED' AND r.hotel.hotelId = :hotelId")
    Double calculateRevenueByHotel(@Param("hotelId") String hotelId);

        
        
    }

