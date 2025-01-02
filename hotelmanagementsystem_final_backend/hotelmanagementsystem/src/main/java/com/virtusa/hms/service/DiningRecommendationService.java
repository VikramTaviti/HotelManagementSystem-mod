package com.virtusa.hms.service;

import java.util.List;

import com.virtusa.hms.exceptions.DiningRecommendationNotFoundException;
import com.virtusa.hms.exceptions.LocationAlreadyExistException;
import com.virtusa.hms.utility.DiningRecommendationDto;

public interface DiningRecommendationService {

	public String insertDiningRecommendationDetails(DiningRecommendationDto diningRecommendationDto) throws LocationAlreadyExistException;

	public String updateDiningRecommendationDetails(DiningRecommendationDto diningRecommendationDto);

	public String deleteDiningRecommendationDetails(String diningOptionId);

	public List<DiningRecommendationDto> getAllDiningRecommendations();

	public DiningRecommendationDto getDiningRecommendationDetailsByDiningOptionId(String diningOptionId);

	public List<DiningRecommendationDto> getAllDiningRecommendationsByStreetAndCity(String street, String city) throws DiningRecommendationNotFoundException;

}
