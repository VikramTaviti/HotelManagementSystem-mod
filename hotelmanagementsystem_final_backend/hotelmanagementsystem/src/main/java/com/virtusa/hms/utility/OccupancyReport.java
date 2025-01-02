package com.virtusa.hms.utility;
 
public class OccupancyReport {
	
	private String hotelName;
	
	private Long totalRooms;
	
	private Long occupiedRooms;
	
	private Long availableRooms;
	
	private Double occupancyRate;
	
	private Double revenue;
 
	public OccupancyReport() {
		super();
	}
 
	public String getHotelName() {
		return hotelName;
	}
 
	public void setHotelName(String hotelName) {
		this.hotelName = hotelName;
	}
 
	public Long getTotalRooms() {
		return totalRooms;
	}
 
	public void setTotalRooms(Long totalRooms) {
		this.totalRooms = totalRooms;
	}
 
	public Long getOccupiedRooms() {
		return occupiedRooms;
	}
 
	public void setOccupiedRooms(Long occupiedRooms) {
		this.occupiedRooms = occupiedRooms;
	}
 
	public Long getAvailableRooms() {
		return availableRooms;
	}
 
	public void setAvailableRooms(Long availableRooms) {
		this.availableRooms = availableRooms;
	}
 
	public Double getOccupancyRate() {
		return occupancyRate;
	}
 
	public void setOccupancyRate(Double occupancyRate) {
		this.occupancyRate = occupancyRate;
	}
	
	public Double getRevenue() {
		return revenue;
	}
 
	public void setRevenue(Double revenue) {
		this.revenue = revenue;
	}
 
	public void calculateOccupancyRate() {
		if (totalRooms != null && totalRooms > 0) {
			this.occupancyRate = (occupiedRooms.doubleValue() / totalRooms.doubleValue()) * 100;
		} else {
			this.occupancyRate = 0.0;
		}
	}
 
	@Override
	public String toString() {
		return "OccupancyReport [hotelName=" + hotelName + ", totalRooms=" + totalRooms + ", occupiedRooms="
				+ occupiedRooms + ", availableRooms=" + availableRooms + ", occupancyRate=" + occupancyRate + "]";
	}
	
 
}