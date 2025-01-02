package com.virtusa.hms.entity.hotel;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.virtusa.hms.keygenerator.CustomPrimaryKeyId;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
public class Attraction {

    @Id
    @CustomPrimaryKeyId
    @Column(name = "attraction_id")
    private String attractionId;

    @Column(name = "attraction_name")
    private String attractionName;

    @Column(name = "attraction_email", unique = true, nullable = false)
    private String attractionEmail;

    @Column(name = "attraction_phone", nullable = false)
    private String attractionPhone;

    @Column(name = "attraction_description", length = 1000)
    private String attractionDescription;

    @Column(name = "attraction_image")
    private String attractionImage;

    @Column(name = "attraction_rating")
    private Double attractionRating;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "location_id")
    @JsonBackReference
    private Location location;

    public Attraction() {
    }

    public Attraction(String attractionName, String attractionEmail, String attractionPhone, String attractionDescription, String attractionImage, Double attractionRating) {
        this.attractionName = attractionName;
        this.attractionEmail = attractionEmail;
        this.attractionPhone = attractionPhone;
        this.attractionDescription = attractionDescription;
        this.attractionImage = attractionImage;
        this.attractionRating = attractionRating;
    }

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

    public Location getLocation() {
        return location;
    }

    public void setLocation(Location location) {
        this.location = location;
    }

    @Override
    public String toString() {
        return "Attraction [attractionId=" + attractionId + ", attractionName=" + attractionName + ", attractionEmail=" + attractionEmail
                + ", attractionPhone=" + attractionPhone + ", attractionDescription=" + attractionDescription + ", attractionImage=" + attractionImage
                + ", attractionRating=" + attractionRating + ", location=" + location + "]";
    }
}