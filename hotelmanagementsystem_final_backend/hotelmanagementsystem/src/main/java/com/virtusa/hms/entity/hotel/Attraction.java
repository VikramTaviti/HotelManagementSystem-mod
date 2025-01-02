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
	
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "location_id")
	@JsonBackReference
	private Location location;
 
	public Attraction() {
 
	}
 
	public Attraction(String attractionName, String email) {
		super();
		this.attractionName = attractionName;
		this.attractionEmail = email;
	}

	public String getAttractionEmail() {
		return attractionEmail;
	}

	public void setAttractionEmail(String email) {
		this.attractionEmail = email;
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
 

	public Location getLocation() {
		return location;
	}

	public void setLocation(Location location) {
		this.location = location;
	}

	@Override
	public String toString() {
		return "Attraction [attractionId=" + attractionId + ", attractionName=" + attractionName + ", location="
				+ location + "]";
	}
	
 
}