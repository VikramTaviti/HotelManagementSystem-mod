package com.virtusa.hms.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.virtusa.hms.entity.user.User;

@Repository
public interface UserRepository extends JpaRepository<User, String> {

	User findByEmail(String email);

	@Query("SELECT u FROM User u WHERE u.email=:userEmail")
	public User getUserByUserEmail(@Param("userEmail") String userEmail);

	@Query("SELECT u FROM User u WHERE u.userId=:userId")
	User getUserByUserId(@Param("userId") String userId);
	
}
