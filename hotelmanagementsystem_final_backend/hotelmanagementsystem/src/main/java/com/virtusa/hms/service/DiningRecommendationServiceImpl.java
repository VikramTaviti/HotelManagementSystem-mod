package com.virtusa.hms.service;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import com.virtusa.hms.converter.ListDtoEntityConverter;
import com.virtusa.hms.entity.hotel.DiningRecommendation;
import com.virtusa.hms.entity.hotel.Location;
import com.virtusa.hms.exceptions.DiningRecommendationNotFoundException;
import com.virtusa.hms.exceptions.EmailAlreadyExistsException;
import com.virtusa.hms.exceptions.EmailNotFoundException;
import com.virtusa.hms.exceptions.LocationAlreadyExistException;
import com.virtusa.hms.repository.DiningRecommendationRepository;
import com.virtusa.hms.repository.LocationRepository;
import com.virtusa.hms.utility.DiningRecommendationDto;

@Service
public class DiningRecommendationServiceImpl implements DiningRecommendationService {

    @Autowired
    private DiningRecommendationRepository diningRecommendationRepository;

    @Autowired
    private LocationRepository locationRepository;

    @Autowired
    private ListDtoEntityConverter listDtoEntityConverter;

    @Override
    public String insertDiningRecommendationDetails(DiningRecommendationDto diningRecommendationDto) throws LocationAlreadyExistException {
        DiningRecommendation diningRecommendation = diningRecommendationRepository
                .findByDiningRecommendationEmail(diningRecommendationDto.getDiningRecommendationEmail());
        if (diningRecommendation != null) {
            throw new EmailAlreadyExistsException("Email already exists, please provide another email.");
        }
        DiningRecommendation convertedDiningRecommendation = listDtoEntityConverter.convertDiningRecommendationDtoToEntity(diningRecommendationDto);
        Location location = locationRepository.getLocationByStreetNumber(convertedDiningRecommendation.getLocation().getStreetNumber());
        if (location != null) {
            throw new LocationAlreadyExistException("Street number already exists.");
        }
        diningRecommendationRepository.save(convertedDiningRecommendation);
        return "Dining details inserted successfully.";
    }

    @Override
    public List<DiningRecommendationDto> getAllDiningRecommendations() {
        return listDtoEntityConverter.convertDiningRecommendationEntityListToDtoList(diningRecommendationRepository.findAll());
    }

    @Override
    public DiningRecommendationDto getDiningRecommendationDetailsByDiningOptionId(String diningOptionId) throws DiningRecommendationNotFoundException {
        Optional<DiningRecommendation> diningRecommendation = diningRecommendationRepository.findById(diningOptionId);
        try {
			if (diningRecommendation.isEmpty()) {
			    throw new DiningRecommendationNotFoundException("Dining recommendation not found with ID: " + diningOptionId);
			}
		} catch (DiningRecommendationNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        return listDtoEntityConverter.convertDiningRecommendationEntityToDto(diningRecommendation.get());
    }

    @Override
    public String updateDiningRecommendationDetails(DiningRecommendationDto diningRecommendationDto) {
        try {
            diningRecommendationRepository.save(listDtoEntityConverter.convertDiningRecommendationDtoToEntity(diningRecommendationDto));
            return "Dining details updated successfully.";
        } catch (DataIntegrityViolationException e) {
            throw new EmailAlreadyExistsException("Email already exists, please provide another email.");
        }
    }

    @Override
    public String deleteDiningRecommendationDetails(String diningOptionId) {
        Optional<DiningRecommendation> diningRecommendation = diningRecommendationRepository.findById(diningOptionId);
        if (diningRecommendation.isEmpty()) {
            throw new EmailNotFoundException("Dining recommendation not found with ID: " + diningOptionId);
        }
        diningRecommendationRepository.delete(diningRecommendation.get());
        return "Dining option details deleted successfully.";
    }

    @Override
    public List<DiningRecommendationDto> getAllDiningRecommendationsByStreetAndCity(String street, String city) throws DiningRecommendationNotFoundException {
        List<DiningRecommendation> diningRecommendationsList = diningRecommendationRepository.getAllDiningRecommendationsByStreetAndCity(street, city);
        if (diningRecommendationsList.isEmpty()) {
            throw new DiningRecommendationNotFoundException("No dining recommendations found for the given street and city.");
        }
        return listDtoEntityConverter.convertDiningRecommendationEntityListToDtoList(diningRecommendationsList);
    }

    @Override
    public List<DiningRecommendationDto> findByCuisineType(String cuisineType) throws DiningRecommendationNotFoundException {
        List<DiningRecommendation> diningRecommendations = diningRecommendationRepository.findByCuisineType(cuisineType);
        if (diningRecommendations.isEmpty()) {
            throw new DiningRecommendationNotFoundException("No dining recommendations found for cuisine type: " + cuisineType);
        }
        return listDtoEntityConverter.convertDiningRecommendationEntityListToDtoList(diningRecommendations);
    }

    @Override
    public List<DiningRecommendationDto> findByPriceRange(String priceRange) throws DiningRecommendationNotFoundException {
        List<DiningRecommendation> diningRecommendations = diningRecommendationRepository.findByPriceRange(priceRange);
        if (diningRecommendations.isEmpty()) {
            throw new DiningRecommendationNotFoundException("No dining recommendations found for price range: " + priceRange);
        }
        return listDtoEntityConverter.convertDiningRecommendationEntityListToDtoList(diningRecommendations);
    }

    @Override
    public List<DiningRecommendationDto> findByOutdoorSeatingAvailable() throws DiningRecommendationNotFoundException {
        List<DiningRecommendation> diningRecommendations = diningRecommendationRepository.findByOutdoorSeatingAvailable();
        if (diningRecommendations.isEmpty()) {
            throw new DiningRecommendationNotFoundException("No dining recommendations found with outdoor seating available.");
        }
        return listDtoEntityConverter.convertDiningRecommendationEntityListToDtoList(diningRecommendations);
    }

    @Override
    public List<DiningRecommendationDto> findByParkingAvailable() throws DiningRecommendationNotFoundException {
        List<DiningRecommendation> diningRecommendations = diningRecommendationRepository.findByParkingAvailable();
        if (diningRecommendations.isEmpty()) {
            throw new DiningRecommendationNotFoundException("No dining recommendations found with parking available.");
        }
        return listDtoEntityConverter.convertDiningRecommendationEntityListToDtoList(diningRecommendations);
    }

    @Override
    public List<DiningRecommendationDto> findByWifiAvailable() throws DiningRecommendationNotFoundException {
        List<DiningRecommendation> diningRecommendations = diningRecommendationRepository.findByWifiAvailable();
        if (diningRecommendations.isEmpty()) {
            throw new DiningRecommendationNotFoundException("No dining recommendations found with Wi-Fi available.");
        }
        return listDtoEntityConverter.convertDiningRecommendationEntityListToDtoList(diningRecommendations);
    }

    @Override
    public List<DiningRecommendationDto> findByReservationRequired(Boolean isReservationRequired) throws DiningRecommendationNotFoundException {
        List<DiningRecommendation> diningRecommendations = diningRecommendationRepository.findByReservationRequired(isReservationRequired);
        if (diningRecommendations.isEmpty()) {
            throw new DiningRecommendationNotFoundException("No dining recommendations found with reservation required: " + isReservationRequired);
        }
        return listDtoEntityConverter.convertDiningRecommendationEntityListToDtoList(diningRecommendations);
    }

    @Override
    public List<DiningRecommendationDto> findBySpecialFeature(String specialFeature) throws DiningRecommendationNotFoundException {
        List<DiningRecommendation> diningRecommendations = diningRecommendationRepository.findBySpecialFeature(specialFeature);
        if (diningRecommendations.isEmpty()) {
            throw new DiningRecommendationNotFoundException("No dining recommendations found with special feature: " + specialFeature);
        }
        return listDtoEntityConverter.convertDiningRecommendationEntityListToDtoList(diningRecommendations);
    }

    @Override
    public List<DiningRecommendationDto> findByOperatingHours(String operatingHours) throws DiningRecommendationNotFoundException {
        List<DiningRecommendation> diningRecommendations = diningRecommendationRepository.findByOperatingHours(operatingHours);
        if (diningRecommendations.isEmpty()) {
            throw new DiningRecommendationNotFoundException("No dining recommendations found with operating hours: " + operatingHours);
        }
        return listDtoEntityConverter.convertDiningRecommendationEntityListToDtoList(diningRecommendations);
    }

    @Override
    public List<DiningRecommendationDto> findByMinCapacity(Integer minCapacity) throws DiningRecommendationNotFoundException {
        List<DiningRecommendation> diningRecommendations = diningRecommendationRepository.findByMinCapacity(minCapacity);
        if (diningRecommendations.isEmpty()) {
            throw new DiningRecommendationNotFoundException("No dining recommendations found with minimum capacity: " + minCapacity);
        }
        return listDtoEntityConverter.convertDiningRecommendationEntityListToDtoList(diningRecommendations);
    }

    @Override
    public List<DiningRecommendationDto> findByMinRating(Double minRating) throws DiningRecommendationNotFoundException {
        List<DiningRecommendation> diningRecommendations = diningRecommendationRepository.findByMinRating(minRating);
        if (diningRecommendations.isEmpty()) {
            throw new DiningRecommendationNotFoundException("No dining recommendations found with minimum rating: " + minRating);
        }
        return listDtoEntityConverter.convertDiningRecommendationEntityListToDtoList(diningRecommendations);
    }
}