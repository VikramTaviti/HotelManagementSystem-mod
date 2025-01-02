package com.virtusa.hms.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.virtusa.hms.repository.UpgradeRoomchargesRepository;

@Service
public class UpgradeRoomchargesServiceImpl implements UpgradeRoomchargesService {

	@Autowired
	private UpgradeRoomchargesRepository upgradeRoomchargesRepository;
	
	@Override
	public Double getRoomUpgradeCharge(String roomType) {
		return upgradeRoomchargesRepository.getUpgradeRoomChargeByRoomType(roomType);
	}

}
