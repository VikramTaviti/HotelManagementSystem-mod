package com.virtusa.hms.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.virtusa.hms.converter.ListDtoEntityConverter;
import com.virtusa.hms.entity.hotel.Location;
import com.virtusa.hms.exceptions.LocationAlreadyExistException;
import com.virtusa.hms.repository.LocationRepository;
import com.virtusa.hms.utility.LocationDto;


@Service
public class LocationServiceImpl implements LocationService {
	
	@Autowired
	private LocationRepository locationRepository;
	
	@Autowired
	private ListDtoEntityConverter listDtoEntityConverter;

	@Override
	public String addLocation(LocationDto locationDto) throws LocationAlreadyExistException {
		Location existingLocation = getLocationByStreetNumber(locationDto.getStreetNumber());
		if(existingLocation==null) {
			Location location = listDtoEntityConverter.convertLocationDtoToEntity(locationDto); 
			locationRepository.save(location);
			return "location saved successFully";
		}
		
		throw new LocationAlreadyExistException("location already exists..");
	}

	@Override
	public Location getLocationByStreetNumber(String streetNumber) {
		Location location = locationRepository.getLocationByStreetNumber(streetNumber);
		if(location == null) {
			
		}
		return location;
	}
	
	

}
