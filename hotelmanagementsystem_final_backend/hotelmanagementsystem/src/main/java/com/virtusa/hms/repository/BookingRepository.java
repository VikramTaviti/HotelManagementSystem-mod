package com.virtusa.hms.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.virtusa.hms.entity.booking.Booking;

@Repository
public interface BookingRepository extends JpaRepository<Booking, String> {

}
