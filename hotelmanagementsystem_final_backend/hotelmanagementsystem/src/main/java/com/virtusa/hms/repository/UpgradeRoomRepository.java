package com.virtusa.hms.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.virtusa.hms.entity.room.UpgradeRoom;

@Repository
public interface UpgradeRoomRepository extends JpaRepository<UpgradeRoom, String> {

}
