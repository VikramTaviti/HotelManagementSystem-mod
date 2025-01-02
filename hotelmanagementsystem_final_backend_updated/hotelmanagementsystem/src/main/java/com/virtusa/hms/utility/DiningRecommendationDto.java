package com.virtusa.hms.utility;

import java.util.List;

import jakarta.validation.Valid;
import jakarta.validation.constraints.DecimalMax;
import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;

public class DiningRecommendationDto {

    private String diningId;

    @NotNull
    private String diningname;

    @DecimalMin(value = "1.0", inclusive = true)
    @DecimalMax(value = "5.0", inclusive = true)
    @NotNull
    private Double diningOverallRating;

    @NotNull(message = "diningOption email can't be null")
    @Pattern(regexp = "^[a-zA-Z0-9.!#$%&'*+/=?^_`{|}~-]{1,64}@(?:[a-zA-Z0-9-]{1,63}\\.){1,8}[a-zA-Z]{2,63}$", message = "Invalid email")
    private String diningRecommendationEmail;

    private List<ReviewDto> reviewDto;

    @Valid
    private LocationDto locationDto;

    // New fields
    private String cuisineType;
    private String priceRange;
    private String operatingHours;
    private String contactNumber;
    private String websiteUrl;
    private Integer capacity;
    private Boolean isOutdoorSeatingAvailable;
    private Boolean isParkingAvailable;
    private Boolean isWifiAvailable;
    private Boolean isReservationRequired;
    private String specialFeatures;

    public DiningRecommendationDto() {
        super();
    }

    // Getters and Setters for existing fields
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

    public List<ReviewDto> getReviewDto() {
        return reviewDto;
    }

    public void setReviewDto(List<ReviewDto> reviewDto) {
        this.reviewDto = reviewDto;
    }

    public LocationDto getLocationDto() {
        return locationDto;
    }

    public void setLocationDto(LocationDto locationDto) {
        this.locationDto = locationDto;
    }

    // Getters and Setters for new fields
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
        return "DiningRecommendationDto [diningId=" + diningId + ", diningname=" + diningname + ", diningOverallRating="
                + diningOverallRating + ", diningRecommendationEmail=" + diningRecommendationEmail + ", reviewDto="
                + reviewDto + ", locationDto=" + locationDto + ", cuisineType=" + cuisineType + ", priceRange="
                + priceRange + ", operatingHours=" + operatingHours + ", contactNumber=" + contactNumber
                + ", websiteUrl=" + websiteUrl + ", capacity=" + capacity + ", isOutdoorSeatingAvailable="
                + isOutdoorSeatingAvailable + ", isParkingAvailable=" + isParkingAvailable + ", isWifiAvailable="
                + isWifiAvailable + ", isReservationRequired=" + isReservationRequired + ", specialFeatures="
                + specialFeatures + "]";
    }
}