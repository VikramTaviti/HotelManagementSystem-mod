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
@Table(name="dining_recom")
public class DiningRecommendation {
 
	@Id
	@CustomPrimaryKeyId
	@Column(name="dining_id")
	private String diningId;
	
	@Column(name="dining_name")
	private String diningname;
	
	private Double diningOverallRating;
	
	@Column(name = "email", unique = true, nullable = false)
	private String diningRecommendationEmail;
	
	@OneToMany(mappedBy = "diningRecommendation", cascade = CascadeType.ALL , fetch = FetchType.LAZY)
	private List<Review> review;
	
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "location_id")
	@JsonBackReference
	private Location location;

	public DiningRecommendation() {
		super();
	}

	public DiningRecommendation(String diningId, String diningname, Double diningOverallRating,
			String diningRecommendationEmail, List<Review> review, Location location) {
		super();
		this.diningId = diningId;
		this.diningname = diningname;
		this.diningOverallRating = diningOverallRating;
		this.diningRecommendationEmail = diningRecommendationEmail;
		this.review = review;
		this.location = location;
	}

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

	@Override
	public String toString() {
		return "DiningRecommendation [diningId=" + diningId + ", diningname=" + diningname + ", diningOverallRating="
				+ diningOverallRating + ", diningRecommendationEmail=" + diningRecommendationEmail + ", review="
				+ review + ", location=" + location + "]";
	}
 
}