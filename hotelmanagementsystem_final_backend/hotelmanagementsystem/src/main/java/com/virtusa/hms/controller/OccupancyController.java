package com.virtusa.hms.controller;
 
import com.virtusa.hms.service.OccupancyService;
import com.virtusa.hms.utility.OccupancyReport;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
 
import java.util.List;
 
@RestController
@RequestMapping("/occupancy")
@CrossOrigin(origins = "http://localhost:4200")
public class OccupancyController {
 
    @Autowired
    private OccupancyService occupancyService;
 
    @GetMapping("/reports")
    public ResponseEntity<List<OccupancyReport>>getAllHotelOccupancyReports() {
        return ResponseEntity.ok(occupancyService.generateOccupancyReportsForAllHotels()); 
    }
}