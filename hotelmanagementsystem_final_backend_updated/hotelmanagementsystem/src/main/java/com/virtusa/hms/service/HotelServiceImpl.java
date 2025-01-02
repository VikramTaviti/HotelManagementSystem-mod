package com.virtusa.hms.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import com.virtusa.hms.converter.ListDtoEntityConverter;
import com.virtusa.hms.entity.Status;
import com.virtusa.hms.entity.hotel.Hotel;
import com.virtusa.hms.entity.hotel.Location;
import com.virtusa.hms.exceptions.EmailAlreadyExistsException;
import com.virtusa.hms.exceptions.HotelNotFoundException;
import com.virtusa.hms.exceptions.LocationAlreadyExistException;
import com.virtusa.hms.repository.HotelRepository;
import com.virtusa.hms.repository.LocationRepository;
import com.virtusa.hms.utility.HotelDto;
import com.virtusa.hms.utility.SearchFields;


@Service
public class HotelServiceImpl implements HotelService {

	@Autowired
	private HotelRepository hotelRepository;

	@Autowired
	private LocationService locationService;

	@Autowired
	private ListDtoEntityConverter listDtoEntityConverter;
	
	@Autowired
	private LocationRepository locationRepository;

	@Override
	public String insertHotelDetails(HotelDto hotelDto) throws LocationAlreadyExistException {
		Hotel existingHotel = hotelRepository.findByHotelEmail(hotelDto.getHotelEmail());
		if (existingHotel != null) {
			throw new EmailAlreadyExistsException("Email already exixts ,please give another email");
		}
		Hotel hotel = listDtoEntityConverter.convertHotelDtoToEntity(hotelDto);
		String message = locationService.addLocation(hotelDto.getLocationDto());
		if(message.isEmpty()) {
			System.out.println("Location already exist");
			return "Location already exist";
		}
		Location location = locationService.getLocationByStreetNumber(hotelDto.getLocationDto().getStreetNumber());
		hotel.setLocation(location);
		hotelRepository.save(hotel); 
		return "hotel details inserted successfully";
	}

	@Override
	public String updateHotelDetails(HotelDto hotelDto) {
		try {
			Hotel hotel = listDtoEntityConverter.convertHotelDtoToEntity(hotelDto);
			locationRepository.save(hotel.getLocation());
			hotelRepository.save(hotel);
			return "hotel details updated successfully";
		} catch (DataIntegrityViolationException e) {
			throw new EmailAlreadyExistsException("Email or street number already exixts ,use another email or street number");
		}
	}

	@Override
	public List<HotelDto> getAllHotelDetails() {
		return listDtoEntityConverter.convertHotelEntityListToDtoList(hotelRepository.findAll());
	}

	@Override
	public HotelDto getHotelDetailsById(String hotelId) {
		Optional<Hotel> optionalHotel = hotelRepository.findById(hotelId);
		Hotel hotel = optionalHotel.get();
		HotelDto hotelDto = listDtoEntityConverter.convertHotelEntityToDto(hotel);
		hotelDto.setLocationDto(listDtoEntityConverter.convertLocationEntityToDto(hotel.getLocation()));
		return hotelDto;
	}
	
	@Override
	public String deleteHotelDetailsw(String hotelId) throws HotelNotFoundException {
		System.out.println("**************************   " + hotelId);
		Optional<Hotel> hotel = hotelRepository.findById(hotelId);
		
		locationRepository.delete(hotel.get().getLocation());
		hotel.get().setLocation(null);
		if (hotel.isEmpty()) {
			throw new HotelNotFoundException("Id not found in the database.");
		}
		
		hotelRepository.delete(hotel.get());
		return "Hotel details deleted successfully";
	}

	@Override
	public List<HotelDto> getAvailableHotelByLocationAndcheckInAndcheckOutDates(SearchFields searchFields) {
		String[] parts = searchFields.getLocation().split(",");
		String city = parts[0];
		String street = parts[1];
		 List<Hotel> availableHotels= hotelRepository.getAvailableHotelByLocationAndCheckInAndCheckOutDates(city,street,searchFields.getRoomType(),searchFields.getCheckinDate(),searchFields.getCheckoutDate(),Status.CONFIRMED);
		 List<HotelDto> availableHotelsDto = listDtoEntityConverter.convertHotelEntityListToDtoList(availableHotels);
		 return availableHotelsDto;
	}

}
