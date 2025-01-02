package com.virtusa.hms.service;

import com.virtusa.hms.entity.hotel.Location;
import com.virtusa.hms.exceptions.LocationAlreadyExistException;
import com.virtusa.hms.utility.LocationDto;


public interface LocationService {

	public String addLocation(LocationDto locationDto) throws LocationAlreadyExistException;

	public Location getLocationByStreetNumber(String streetNumber);
}
