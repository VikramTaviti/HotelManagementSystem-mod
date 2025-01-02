package com.virtusa.hms.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.virtusa.hms.entity.hotel.Attraction;

@Repository
public interface AttractionRepository extends JpaRepository<Attraction, String> {

    // Find an attraction by email
    public Attraction findByAttractionEmail(String email);

    // Find attractions by location details
    @Query("SELECT a FROM Attraction a WHERE a.location.street = :street AND a.location.city = :city AND a.location.state = :state AND a.location.pincode = :pincode AND a.location.country = :country")
    public List<Attraction> findAttractionByLocation(
            @Param("street") String street,
            @Param("city") String city,
            @Param("state") String state,
            @Param("pincode") int pincode,
            @Param("country") String country
    );

    // Find all attractions
    @Query("SELECT a FROM Attraction a")
    public List<Attraction> findAllAttractions();

    // Find attractions by street and city
    @Query("SELECT a FROM Attraction a WHERE a.location.street = :street AND a.location.city = :city")
    public List<Attraction> getAllAttractionDetailsByStreetAndCity(
            @Param("street") String street,
            @Param("city") String city
    );

    // Find attractions by attraction name (custom query example)
    public List<Attraction> findByAttractionName(String attractionName);

    // Find attractions by rating greater than or equal to a given value
    @Query("SELECT a FROM Attraction a WHERE a.attractionRating >= :rating")
    public List<Attraction> findByAttractionRatingGreaterThanEqual(@Param("rating") double rating);

    // Find attractions by phone number (custom query example)
    public Attraction findByAttractionPhone(String attractionPhone);
}