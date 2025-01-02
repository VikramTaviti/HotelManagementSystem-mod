package com.virtusa.hms.entity.hotel;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.virtusa.hms.keygenerator.CustomPrimaryKeyId;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
 
@Entity
public class Facility {
	@Id
	@CustomPrimaryKeyId
	@Column(name="service_id")
	private String serviceId;
	
	@Column(name="service_type")
	private String serviceType;
	
	@Column(name="price")
	private double price;
	
	@ManyToMany
	@JoinTable(
			  name = "service_hotel",
			  joinColumns = @JoinColumn(name = "service_id"),
			  inverseJoinColumns = @JoinColumn(name = "hotel_id")
			)
	@JsonBackReference
	private List<Hotel> hotel;
 
	public Facility() {
		
	}
 
	public Facility(String serviceType, double price) {
 
		this.serviceType = serviceType;
		this.price = price;
	}
 
	public String getServiceId() {
		return serviceId;
	}
 
	public void setServiceId(String serviceId) {
		this.serviceId = serviceId;
	}
 
	public String getServiceType() {
		return serviceType;
	}
 
	public void setServiceType(String serviceType) {
		this.serviceType = serviceType;
	}
 
	public double getPrice() {
		return price;
	}
 
	public void setPrice(double price) {
		this.price = price;
	}
 
	public List<Hotel> getHotel() {
		return hotel;
	}
 
	public void setHotel(List<Hotel> hotel) {
		this.hotel = hotel;
	}

	@Override
	public String toString() {
		return "Facility [serviceId=" + serviceId + ", serviceType=" + serviceType + ", price=" + price + "]";
	}
	
}