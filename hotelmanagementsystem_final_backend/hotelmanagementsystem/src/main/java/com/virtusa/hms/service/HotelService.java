package com.virtusa.hms.service;

import java.util.List;

import com.virtusa.hms.exceptions.HotelNotFoundException;
import com.virtusa.hms.exceptions.LocationAlreadyExistException;
import com.virtusa.hms.utility.HotelDto;
import com.virtusa.hms.utility.SearchFields;


public interface HotelService {

	public String insertHotelDetails(HotelDto hotelDto) throws LocationAlreadyExistException;
	
	public String updateHotelDetails(HotelDto hotelDto);

	public List<HotelDto> getAllHotelDetails();
	
	public HotelDto getHotelDetailsById(String hotelId);
	
	public String deleteHotelDetailsw(String hotelId) throws HotelNotFoundException;

	public List<HotelDto> getAvailableHotelByLocationAndcheckInAndcheckOutDates(SearchFields searchFields);
	

}
