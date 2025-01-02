package com.virtusa.hms.repository;


import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.virtusa.hms.entity.payment.Payment;

@Repository
public interface PaymentRepository extends JpaRepository<Payment, String> {

	@Query("SELECT p FROM Payment p JOIN p.booking b WHERE b.user.userId = :userId")
	public List<Payment> getAllPaymentsByUserId(@Param("userId") String userId);

}
