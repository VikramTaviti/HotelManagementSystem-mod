package com.virtusa.hms.service;

import java.util.List;

import com.virtusa.hms.exceptions.AttractionNotFoundException;
import com.virtusa.hms.exceptions.LocationAlreadyExistException;
import com.virtusa.hms.utility.AttractionDto;

public interface AttractionService {

	public String insertAttractionDetails(AttractionDto attractionDto) throws LocationAlreadyExistException;

	public List<AttractionDto> getgetAllAttractionDetails();
	
	public AttractionDto getAttractionDetailsByAttractionId(String email);

	public String updateAttractionDetails(AttractionDto attractionDto);

	public String deleteAttractionDetails(String attractionId);

	public List<AttractionDto> getAllAttractionDetailsByStreetAndCity(String street, String city) throws AttractionNotFoundException;

}
