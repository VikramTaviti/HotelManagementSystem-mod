package com.virtusa.hms.service;

import java.util.List;

import com.virtusa.hms.exceptions.DiningRecommendationNotFoundException;
import com.virtusa.hms.exceptions.LocationAlreadyExistException;
import com.virtusa.hms.utility.DiningRecommendationDto;

public interface DiningRecommendationService {

    String insertDiningRecommendationDetails(DiningRecommendationDto diningRecommendationDto) throws LocationAlreadyExistException;

    List<DiningRecommendationDto> getAllDiningRecommendations();

    DiningRecommendationDto getDiningRecommendationDetailsByDiningOptionId(String diningOptionId) throws DiningRecommendationNotFoundException;

    String updateDiningRecommendationDetails(DiningRecommendationDto diningRecommendationDto);

    String deleteDiningRecommendationDetails(String diningOptionId);

    List<DiningRecommendationDto> getAllDiningRecommendationsByStreetAndCity(String street, String city) throws DiningRecommendationNotFoundException;

    List<DiningRecommendationDto> findByCuisineType(String cuisineType) throws DiningRecommendationNotFoundException;

    List<DiningRecommendationDto> findByPriceRange(String priceRange) throws DiningRecommendationNotFoundException;

    List<DiningRecommendationDto> findByOutdoorSeatingAvailable() throws DiningRecommendationNotFoundException;

    List<DiningRecommendationDto> findByParkingAvailable() throws DiningRecommendationNotFoundException;

    List<DiningRecommendationDto> findByWifiAvailable() throws DiningRecommendationNotFoundException;

    List<DiningRecommendationDto> findByReservationRequired(Boolean isReservationRequired) throws DiningRecommendationNotFoundException;

    List<DiningRecommendationDto> findBySpecialFeature(String specialFeature) throws DiningRecommendationNotFoundException;

    List<DiningRecommendationDto> findByOperatingHours(String operatingHours) throws DiningRecommendationNotFoundException;

    List<DiningRecommendationDto> findByMinCapacity(Integer minCapacity) throws DiningRecommendationNotFoundException;

    List<DiningRecommendationDto> findByMinRating(Double minRating) throws DiningRecommendationNotFoundException;
}