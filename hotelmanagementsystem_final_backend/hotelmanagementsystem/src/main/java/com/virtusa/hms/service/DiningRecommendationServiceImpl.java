package com.virtusa.hms.service;

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
	private  ListDtoEntityConverter listDtoEntityConverter;

	@Override
	public String insertDiningRecommendationDetails(DiningRecommendationDto diningRecommendationDto) throws LocationAlreadyExistException {
		DiningRecommendation diningRecommendation = diningRecommendationRepository
				.findByDiningRecommendationEmail(diningRecommendationDto.getDiningRecommendationEmail());
		if (diningRecommendation != null) {
			throw new EmailAlreadyExistsException("Email already exixts ,please give another email");
		}
		DiningRecommendation convertedDiningRecommendation = listDtoEntityConverter.convertDiningRecommendationDtoToEntity(diningRecommendationDto);
		Location location = locationRepository.getLocationByStreetNumber(convertedDiningRecommendation.getLocation().getStreetNumber());
		if(location!=null) {
			throw new LocationAlreadyExistException("StreetNumber already exists");
		}
		diningRecommendationRepository.save(convertedDiningRecommendation);
		return "Dining details inserted successfully";
	}
	
	@Override
	public List<DiningRecommendationDto> getAllDiningRecommendations() {
		return  listDtoEntityConverter.convertDiningRecommendationEntityListToDtoList(diningRecommendationRepository.findAll());
	}
	
	@Override
	public DiningRecommendationDto getDiningRecommendationDetailsByDiningOptionId(String diningOptionId) {
		return listDtoEntityConverter.convertDiningRecommendationEntityToDto(diningRecommendationRepository.findById(diningOptionId).get());
	}

	@Override
	public String updateDiningRecommendationDetails(DiningRecommendationDto diningRecommendationDto) {
		try {
			diningRecommendationRepository
					.save(listDtoEntityConverter.convertDiningRecommendationDtoToEntity(diningRecommendationDto));
			return "Dining details updated successfully";
		} catch (DataIntegrityViolationException e) {
			throw new EmailAlreadyExistsException("Email already exixts ,please give another email");
		}
	}
	
	@Override
	public String deleteDiningRecommendationDetails(String diningOptionId) {
		Optional<DiningRecommendation> diningRecommendation = diningRecommendationRepository.findById(diningOptionId);
		if (diningRecommendation == null) {
			throw new EmailNotFoundException("Email not found in the database.");
		}
		diningRecommendationRepository.delete(diningRecommendation.get());
		return "Dining Option details deleted successfully";
	}

	@Override
	public List<DiningRecommendationDto> getAllDiningRecommendationsByStreetAndCity(String street, String city) throws DiningRecommendationNotFoundException {
		List<DiningRecommendation> diningRecommendationsList = diningRecommendationRepository.getAllDiningRecommendationsByStreetAndCity(street,city);
		if(diningRecommendationsList == null) {
			throw new DiningRecommendationNotFoundException("No Attractions Found");
		}
		return listDtoEntityConverter.convertDiningRecommendationEntityListToDtoList(diningRecommendationsList);
	}

	
}