package com.virtusa.hms.utility;

import jakarta.validation.Valid;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;

public class AttractionDto {

    private String attractionId;

    @NotBlank(message = "Attraction name cannot be blank")
    private String attractionName;

    @NotBlank(message = "Attraction email cannot be blank")
    @Pattern(regexp = "^[a-zA-Z0-9.!#$%&'*+/=?^_`{|}~-]{1,64}@(?:[a-zA-Z0-9-]{1,63}\\.){1,8}[a-zA-Z]{2,63}$", message = "Invalid email")
    private String attractionEmail;

    @NotBlank(message = "Attraction phone cannot be blank")
    @Pattern(regexp = "^\\d{10}$", message = "Phone number must be 10 digits")
    private String attractionPhone;

    @Size(min = 10, max = 1000, message = "Description must be between 10 and 1000 characters")
    private String attractionDescription;

    @Pattern(regexp = "https?:\\/\\/.+\\.(jpg|jpeg|png|gif)", message = "Invalid image URL. Must be a direct link to an image (jpg, jpeg, png, gif).")
    private String attractionImage;

    @Min(value = 1, message = "Rating must be at least 1")
    @Max(value = 5, message = "Rating cannot be more than 5")
    private Double attractionRating;

    @Valid
    private LocationDto locationDto;

    // Getters and Setters
    public String getAttractionId() {
        return attractionId;
    }

    public void setAttractionId(String attractionId) {
        this.attractionId = attractionId;
    }

    public String getAttractionName() {
        return attractionName;
    }

    public void setAttractionName(String attractionName) {
        this.attractionName = attractionName;
    }

    public String getAttractionEmail() {
        return attractionEmail;
    }

    public void setAttractionEmail(String attractionEmail) {
        this.attractionEmail = attractionEmail;
    }

    public String getAttractionPhone() {
        return attractionPhone;
    }

    public void setAttractionPhone(String attractionPhone) {
        this.attractionPhone = attractionPhone;
    }

    public String getAttractionDescription() {
        return attractionDescription;
    }

    public void setAttractionDescription(String attractionDescription) {
        this.attractionDescription = attractionDescription;
    }

    public String getAttractionImage() {
        return attractionImage;
    }

    public void setAttractionImage(String attractionImage) {
        this.attractionImage = attractionImage;
    }

    public Double getAttractionRating() {
        return attractionRating;
    }

    public void setAttractionRating(Double attractionRating) {
        this.attractionRating = attractionRating;
    }

    public LocationDto getLocationDto() {
        return locationDto;
    }

    public void setLocationDto(LocationDto locationDto) {
        this.locationDto = locationDto;
    }

    @Override
    public String toString() {
        return "AttractionDto [attractionId=" + attractionId + ", attractionName=" + attractionName + ", attractionEmail=" + attractionEmail + ", attractionPhone=" + attractionPhone + ", attractionDescription=" + attractionDescription + ", attractionImage=" + attractionImage + ", attractionRating=" + attractionRating + ", locationDto=" + locationDto + "]";
    }
}