package com.virtusa.hms.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.virtusa.hms.entity.room.UpgradeRoomCharges;


public interface UpgradeRoomchargesRepository extends JpaRepository<UpgradeRoomCharges, String> {
	
	@Query("SELECT u.upgradePrice FROM UpgradeRoomCharges u WHERE u.upgradeRoomType =:roomType")
    Double getUpgradeRoomChargeByRoomType(@Param("roomType") String roomType);

}
