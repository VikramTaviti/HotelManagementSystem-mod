package com.virtusa.hms.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import com.virtusa.hms.converter.ListDtoEntityConverter;
import com.virtusa.hms.entity.hotel.Attraction;
import com.virtusa.hms.entity.hotel.Location;
import com.virtusa.hms.exceptions.AttractionNotFoundException;
import com.virtusa.hms.exceptions.EmailAlreadyExistsException;
import com.virtusa.hms.exceptions.EmailNotFoundException;
import com.virtusa.hms.exceptions.LocationAlreadyExistException;
import com.virtusa.hms.repository.AttractionRepository;
import com.virtusa.hms.repository.LocationRepository;
import com.virtusa.hms.utility.AttractionDto;


@Service
public class AttractionServiceImpl implements AttractionService {

	@Autowired
	private AttractionRepository attractionRepository;
	
	@Autowired
	private ListDtoEntityConverter listDtoEntityConverter;
	
	@Autowired
	private LocationRepository locationRepository;
	
	@Override
	public String insertAttractionDetails(AttractionDto attractionDto) throws LocationAlreadyExistException {
		Attraction existingAttraction = attractionRepository.findByAttractionEmail(attractionDto.getAttractionEmail());
		if (existingAttraction != null) {
			throw new EmailAlreadyExistsException("Email already exixts , please give another email");
		}
		Attraction attraction = listDtoEntityConverter.convertAttractionDtoToEntity(attractionDto);
		Location location = locationRepository.getLocationByStreetNumber(attraction.getLocation().getStreetNumber());
		if(location!=null) {
			throw new LocationAlreadyExistException("Street Number already Exists");
		}
		attractionRepository.save(attraction);
		return "Attraction details inserted successfully";
	}

	@Override
	public List<AttractionDto> getgetAllAttractionDetails() {
		List<Attraction> listOfAttractions = attractionRepository.findAll();
		System.out.println(listOfAttractions);
		return listDtoEntityConverter.convertAttractionEntityListToDtoList(listOfAttractions);
	}
	
	@Override
	public AttractionDto getAttractionDetailsByAttractionId(String attractionID) {
		Optional<Attraction> attraction = attractionRepository.findById(attractionID);
		AttractionDto attractionDto = listDtoEntityConverter
				.convertAttractionEntityToDto(attraction.get());
		if (attractionDto == null) {
			throw new EmailNotFoundException("Email not found in the database.");
		}
		return attractionDto;
	}

	@Override
	public String updateAttractionDetails(AttractionDto attractionDto) {
		try {
			attractionRepository.save(listDtoEntityConverter.convertAttractionDtoToEntity(attractionDto));
			return "Attraction details updated successfully";
		} catch (DataIntegrityViolationException e) {
			throw new EmailAlreadyExistsException("Email already exixts ,please give another email");
		}
	}
	
	@Override
	public String deleteAttractionDetails(String attractionId) {
		Optional<Attraction> attraction = attractionRepository.findById(attractionId);
		if (attraction == null) {
			throw new EmailNotFoundException("Email not found in the database.");
		}
		attractionRepository.delete(attraction.get());
		return "Attraction details deleted successfully";
	}

	@Override
	public List<AttractionDto> getAllAttractionDetailsByStreetAndCity(String street, String city) throws AttractionNotFoundException {
		List<Attraction> attractionList = attractionRepository.getAllAttractionDetailsByStreetAndCity(street,city);
		if(attractionList == null) {
			throw new AttractionNotFoundException("No Attractions Found");
		}
		return listDtoEntityConverter.convertAttractionEntityListToDtoList(attractionList);
	}


}
