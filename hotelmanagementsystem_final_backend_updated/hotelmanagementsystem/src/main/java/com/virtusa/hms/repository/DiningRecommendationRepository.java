package com.virtusa.hms.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.virtusa.hms.entity.hotel.DiningRecommendation;

@Repository
public interface DiningRecommendationRepository extends JpaRepository<DiningRecommendation, String> {

    // Find dining recommendation by email
    public DiningRecommendation findByDiningRecommendationEmail(String email);

    // Find dining recommendations by full location details
    @Query("select d from DiningRecommendation d where d.location.street = :street and d.location.city = :city and d.location.state = :state and d.location.pincode = :pincode and d.location.country = :country")
    public List<DiningRecommendation> findDiningRecommendationsByLocation(
            @Param("street") String street,
            @Param("city") String city,
            @Param("state") String state,
            @Param("pincode") int pincode,
            @Param("country") String country);

    // Find dining recommendation by ID
    @Query("select d from DiningRecommendation d where d.diningId = :diningId")
    public DiningRecommendation getDiningRecommendationById(@Param("diningId") String diningId);

    // Find dining recommendations by street and city
    @Query("select d from DiningRecommendation d where d.location.street = :street and d.location.city = :city")
    public List<DiningRecommendation> getAllDiningRecommendationsByStreetAndCity(
            @Param("street") String street,
            @Param("city") String city);

    // Find dining recommendations by cuisine type
    @Query("select d from DiningRecommendation d where d.cuisineType = :cuisineType")
    public List<DiningRecommendation> findByCuisineType(@Param("cuisineType") String cuisineType);

    // Find dining recommendations by price range
    @Query("select d from DiningRecommendation d where d.priceRange = :priceRange")
    public List<DiningRecommendation> findByPriceRange(@Param("priceRange") String priceRange);

    // Find dining recommendations with outdoor seating available
    @Query("select d from DiningRecommendation d where d.isOutdoorSeatingAvailable = true")
    public List<DiningRecommendation> findByOutdoorSeatingAvailable();

    // Find dining recommendations with parking available
    @Query("select d from DiningRecommendation d where d.isParkingAvailable = true")
    public List<DiningRecommendation> findByParkingAvailable();

    // Find dining recommendations with Wi-Fi available
    @Query("select d from DiningRecommendation d where d.isWifiAvailable = true")
    public List<DiningRecommendation> findByWifiAvailable();

    // Find dining recommendations by reservation requirement
    @Query("select d from DiningRecommendation d where d.isReservationRequired = :isReservationRequired")
    public List<DiningRecommendation> findByReservationRequired(@Param("isReservationRequired") Boolean isReservationRequired);

    // Find dining recommendations by special features
    @Query("select d from DiningRecommendation d where d.specialFeatures like %:specialFeature%")
    public List<DiningRecommendation> findBySpecialFeature(@Param("specialFeature") String specialFeature);

    // Find dining recommendations by operating hours
    @Query("select d from DiningRecommendation d where d.operatingHours = :operatingHours")
    public List<DiningRecommendation> findByOperatingHours(@Param("operatingHours") String operatingHours);

    // Find dining recommendations by capacity
    @Query("select d from DiningRecommendation d where d.capacity >= :minCapacity")
    public List<DiningRecommendation> findByMinCapacity(@Param("minCapacity") Integer minCapacity);

    // Find dining recommendations by overall rating greater than or equal to a value
    @Query("select d from DiningRecommendation d where d.diningOverallRating >= :minRating")
    public List<DiningRecommendation> findByMinRating(@Param("minRating") Double minRating);
}