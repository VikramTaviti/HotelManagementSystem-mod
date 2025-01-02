package com.virtusa.hms.service;
 
import com.virtusa.hms.entity.hotel.Hotel; 
import com.virtusa.hms.repository.HotelRepository;
import com.virtusa.hms.repository.RoomRepository;
import com.virtusa.hms.utility.OccupancyReport;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
 
@Service
public class OccupancyServiceImpl implements OccupancyService {

    @Autowired
    private HotelRepository hotelRepository;

    @Autowired
    private RoomRepository roomRepository;

    @Override
    public List<OccupancyReport> generateOccupancyReportsForAllHotels() {

        List<Hotel> hotels = hotelRepository.findAll();
        List<OccupancyReport> reports = new ArrayList<>();

        for (Hotel hotel : hotels) {
            OccupancyReport report = new OccupancyReport();
            report.setHotelName(hotel.getHotelName());

            long totalRooms = hotel.getRooms().size();
            report.setTotalRooms(totalRooms);

            long occupiedRooms = roomRepository.countOccupiedRoomsByHotel(hotel.getHotelId(), LocalDate.now());
            report.setOccupiedRooms(occupiedRooms);

            long availableRooms = totalRooms - occupiedRooms;
            report.setAvailableRooms(availableRooms);

            double revenue = roomRepository.calculateRevenueByHotel(hotel.getHotelId());
            report.setRevenue(revenue);

            double occupancyRate = totalRooms > 0 ? (double) occupiedRooms / totalRooms * 100 : 0;
            report.setOccupancyRate(occupancyRate);

            reports.add(report);
        }

        return reports;
    }
}
