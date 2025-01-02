package com.virtusa.hms.service;

import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
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

    private static final Logger logger = LoggerFactory.getLogger(AttractionServiceImpl.class);

    @Autowired
    private AttractionRepository attractionRepository;

    @Autowired
    private ListDtoEntityConverter listDtoEntityConverter;

    @Autowired
    private LocationRepository locationRepository;

    @Override
    public String insertAttractionDetails(AttractionDto attractionDto) throws LocationAlreadyExistException {
        logger.info("Inserting attraction details: {}", attractionDto);

        // Validate attraction_phone
        if (attractionDto.getAttractionPhone() == null || attractionDto.getAttractionPhone().isEmpty()) {
            logger.error("Attraction phone number is null or empty");
            throw new IllegalArgumentException("Attraction phone number cannot be null or empty");
        }

        // Check if email already exists
        Attraction existingAttraction = attractionRepository.findByAttractionEmail(attractionDto.getAttractionEmail());
        if (existingAttraction != null) {
            logger.error("Email already exists: {}", attractionDto.getAttractionEmail());
            throw new EmailAlreadyExistsException("Email already exists. Please use another email.");
        }

        // Convert DTO to entity
        Attraction attraction = listDtoEntityConverter.convertAttractionDtoToEntity(attractionDto);

        // Check if location already exists
        Location location = locationRepository.getLocationByStreetNumber(attraction.getLocation().getStreetNumber());
        if (location != null) {
            logger.error("Street number already exists: {}", attraction.getLocation().getStreetNumber());
            throw new LocationAlreadyExistException("Street number already exists.");
        }

        // Save attraction
        try {
            attractionRepository.save(attraction);
            logger.info("Attraction saved successfully: {}", attraction);
            return "Attraction details inserted successfully";
        } catch (DataIntegrityViolationException e) {
            logger.error("Data integrity violation while saving attraction: {}", e.getMessage());
            throw new IllegalArgumentException("Invalid data provided. Please check the input fields.");
        }
    }

    @Override
    public List<AttractionDto> getgetAllAttractionDetails() {
        logger.info("Fetching all attraction details");
        List<Attraction> listOfAttractions = attractionRepository.findAll();
        return listDtoEntityConverter.convertAttractionEntityListToDtoList(listOfAttractions);
    }

    @Override
    public AttractionDto getAttractionDetailsByAttractionId(String attractionID) {
        logger.info("Fetching attraction details by ID: {}", attractionID);
        Optional<Attraction> attraction = attractionRepository.findById(attractionID);
        if (!attraction.isPresent()) {
            logger.error("Attraction not found with ID: {}", attractionID);
            throw new EmailNotFoundException("Attraction not found with ID: " + attractionID);
        }
        return listDtoEntityConverter.convertAttractionEntityToDto(attraction.get());
    }

    @Override
    public String updateAttractionDetails(AttractionDto attractionDto) {
        logger.info("Updating attraction details: {}", attractionDto);

        // Validate attraction_phone
        if (attractionDto.getAttractionPhone() == null || attractionDto.getAttractionPhone().isEmpty()) {
            logger.error("Attraction phone number is null or empty");
            throw new IllegalArgumentException("Attraction phone number cannot be null or empty");
        }

        try {
            attractionRepository.save(listDtoEntityConverter.convertAttractionDtoToEntity(attractionDto));
            logger.info("Attraction updated successfully: {}", attractionDto);
            return "Attraction details updated successfully";
        } catch (DataIntegrityViolationException e) {
            logger.error("Data integrity violation while updating attraction: {}", e.getMessage());
            throw new EmailAlreadyExistsException("Email already exists. Please use another email.");
        }
    }

    @Override
    public String deleteAttractionDetails(String attractionId) {
        logger.info("Deleting attraction details by ID: {}", attractionId);
        Optional<Attraction> attraction = attractionRepository.findById(attractionId);
        if (!attraction.isPresent()) {
            logger.error("Attraction not found with ID: {}", attractionId);
            throw new EmailNotFoundException("Attraction not found with ID: " + attractionId);
        }
        attractionRepository.delete(attraction.get());
        logger.info("Attraction deleted successfully: {}", attractionId);
        return "Attraction details deleted successfully";
    }

    @Override
    public List<AttractionDto> getAllAttractionDetailsByStreetAndCity(String street, String city) throws AttractionNotFoundException {
        logger.info("Fetching attraction details by street: {} and city: {}", street, city);
        List<Attraction> attractionList = attractionRepository.getAllAttractionDetailsByStreetAndCity(street, city);
        if (attractionList == null || attractionList.isEmpty()) {
            logger.error("No attractions found for street: {} and city: {}", street, city);
            throw new AttractionNotFoundException("No attractions found for the given street and city.");
        }
        return listDtoEntityConverter.convertAttractionEntityListToDtoList(attractionList);
    }
}