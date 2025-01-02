package com.virtusa.hms.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.virtusa.hms.service.UpgradeRoomchargesService;

@RestController
@RequestMapping("/roomCharges")
@CrossOrigin(origins = "http://localhost:4200")
public class UpgradeRoomchargesController {
	
	
	@Autowired
	private UpgradeRoomchargesService upgradeRoomchargesService;
	
	@GetMapping("/ByRoomType/{roomType}")
	public ResponseEntity<Double> getRoomUpgradeCharge(@PathVariable("roomType") String roomType ){
		return ResponseEntity.ok().body(upgradeRoomchargesService.getRoomUpgradeCharge(roomType));
	}
	

}
