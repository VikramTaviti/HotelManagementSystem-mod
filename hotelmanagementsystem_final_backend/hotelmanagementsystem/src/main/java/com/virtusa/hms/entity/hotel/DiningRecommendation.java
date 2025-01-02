package com.virtusa.hms.entity.hotel;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.virtusa.hms.keygenerator.CustomPrimaryKeyId;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "dining_recom")
public class DiningRecommendation {

    @Id
    @CustomPrimaryKeyId
    @Column(name = "dining_id")
    private String diningId;

    @Column(name = "dining_name")
    private String diningname;

    private Double diningOverallRating;

    @Column(name = "email", unique = true, nullable = false)
    private String diningRecommendationEmail;

    @OneToMany(mappedBy = "diningRecommendation", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<Review> review;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "location_id")
    @JsonBackReference
    private Location location;

    @Column(name = "cuisine_type")
    private String cuisineType;

    @Column(name = "price_range")
    private String priceRange;

    @Column(name = "operating_hours")
    private String operatingHours;

    @Column(name = "contact_number")
    private String contactNumber;

    @Column(name = "website_url")
    private String websiteUrl;

    @Column(name = "capacity")
    private Integer capacity;

    @Column(name = "is_outdoor_seating_available")
    private Boolean isOutdoorSeatingAvailable;

    @Column(name = "is_parking_available")
    private Boolean isParkingAvailable;

    @Column(name = "is_wifi_available")
    private Boolean isWifiAvailable;

    @Column(name = "is_reservation_required")
    private Boolean isReservationRequired;

    @Column(name = "special_features")
    private String specialFeatures;

    public DiningRecommendation() {
        super();
    }

    public DiningRecommendation(String diningId, String diningname, Double diningOverallRating,
                                String diningRecommendationEmail, List<Review> review, Location location,
                                String cuisineType, String priceRange, String operatingHours, String contactNumber,
                                String websiteUrl, Integer capacity, Boolean isOutdoorSeatingAvailable,
                                Boolean isParkingAvailable, Boolean isWifiAvailable, Boolean isReservationRequired,
                                String specialFeatures) {
        super();
        this.diningId = diningId;
        this.diningname = diningname;
        this.diningOverallRating = diningOverallRating;
        this.diningRecommendationEmail = diningRecommendationEmail;
        this.review = review;
        this.location = location;
        this.cuisineType = cuisineType;
        this.priceRange = priceRange;
        this.operatingHours = operatingHours;
        this.contactNumber = contactNumber;
        this.websiteUrl = websiteUrl;
        this.capacity = capacity;
        this.isOutdoorSeatingAvailable = isOutdoorSeatingAvailable;
        this.isParkingAvailable = isParkingAvailable;
        this.isWifiAvailable = isWifiAvailable;
        this.isReservationRequired = isReservationRequired;
        this.specialFeatures = specialFeatures;
    }

    // Getters and Setters for all fields

    public String getDiningId() {
        return diningId;
    }

    public void setDiningId(String diningId) {
        this.diningId = diningId;
    }

    public String getDiningname() {
        return diningname;
    }

    public void setDiningname(String diningname) {
        this.diningname = diningname;
    }

    public Double getDiningOverallRating() {
        return diningOverallRating;
    }

    public void setDiningOverallRating(Double diningOverallRating) {
        this.diningOverallRating = diningOverallRating;
    }

    public String getDiningRecommendationEmail() {
        return diningRecommendationEmail;
    }

    public void setDiningRecommendationEmail(String diningRecommendationEmail) {
        this.diningRecommendationEmail = diningRecommendationEmail;
    }

    public List<Review> getReview() {
        return review;
    }

    public void setReview(List<Review> review) {
        this.review = review;
    }

    public Location getLocation() {
        return location;
    }

    public void setLocation(Location location) {
        this.location = location;
    }

    public String getCuisineType() {
        return cuisineType;
    }

    public void setCuisineType(String cuisineType) {
        this.cuisineType = cuisineType;
    }

    public String getPriceRange() {
        return priceRange;
    }

    public void setPriceRange(String priceRange) {
        this.priceRange = priceRange;
    }

    public String getOperatingHours() {
        return operatingHours;
    }

    public void setOperatingHours(String operatingHours) {
        this.operatingHours = operatingHours;
    }

    public String getContactNumber() {
        return contactNumber;
    }

    public void setContactNumber(String contactNumber) {
        this.contactNumber = contactNumber;
    }

    public String getWebsiteUrl() {
        return websiteUrl;
    }

    public void setWebsiteUrl(String websiteUrl) {
        this.websiteUrl = websiteUrl;
    }

    public Integer getCapacity() {
        return capacity;
    }

    public void setCapacity(Integer capacity) {
        this.capacity = capacity;
    }

    public Boolean getIsOutdoorSeatingAvailable() {
        return isOutdoorSeatingAvailable;
    }

    public void setIsOutdoorSeatingAvailable(Boolean isOutdoorSeatingAvailable) {
        this.isOutdoorSeatingAvailable = isOutdoorSeatingAvailable;
    }

    public Boolean getIsParkingAvailable() {
        return isParkingAvailable;
    }

    public void setIsParkingAvailable(Boolean isParkingAvailable) {
        this.isParkingAvailable = isParkingAvailable;
    }

    public Boolean getIsWifiAvailable() {
        return isWifiAvailable;
    }

    public void setIsWifiAvailable(Boolean isWifiAvailable) {
        this.isWifiAvailable = isWifiAvailable;
    }

    public Boolean getIsReservationRequired() {
        return isReservationRequired;
    }

    public void setIsReservationRequired(Boolean isReservationRequired) {
        this.isReservationRequired = isReservationRequired;
    }

    public String getSpecialFeatures() {
        return specialFeatures;
    }

    public void setSpecialFeatures(String specialFeatures) {
        this.specialFeatures = specialFeatures;
    }

    @Override
    public String toString() {
        return "DiningRecommendation [diningId=" + diningId + ", diningname=" + diningname + ", diningOverallRating="
                + diningOverallRating + ", diningRecommendationEmail=" + diningRecommendationEmail + ", review="
                + review + ", location=" + location + ", cuisineType=" + cuisineType + ", priceRange=" + priceRange
                + ", operatingHours=" + operatingHours + ", contactNumber=" + contactNumber + ", websiteUrl="
                + websiteUrl + ", capacity=" + capacity + ", isOutdoorSeatingAvailable=" + isOutdoorSeatingAvailable
                + ", isParkingAvailable=" + isParkingAvailable + ", isWifiAvailable=" + isWifiAvailable
                + ", isReservationRequired=" + isReservationRequired + ", specialFeatures=" + specialFeatures + "]";
    }
}