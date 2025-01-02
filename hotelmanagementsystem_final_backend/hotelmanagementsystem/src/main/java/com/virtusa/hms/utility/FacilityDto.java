package com.virtusa.hms.utility;

import java.util.List;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;

public class FacilityDto {
	
	private String serviceId;
	
	@NotNull
	private String serviceType;
	
	@Min(value = 100)
    @NotNull
	private double price;
	
	private List<HotelDto> hotelDto;

	public FacilityDto() {
		super();
	}

	public FacilityDto(String serviceId, @NotNull String serviceType, @Min(100) @NotNull double price,
			List<HotelDto> hotelDto) {
		super();
		this.serviceId = serviceId;
		this.serviceType = serviceType;
		this.price = price;
		this.hotelDto = hotelDto;
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

	public List<HotelDto> getHotelDto() {
		return hotelDto;
	}

	public void setHotelDto(List<HotelDto> hotelDto) {
		this.hotelDto = hotelDto;
	}

	@Override
	public String toString() {
		return "ServiceDto [serviceId=" + serviceId + ", serviceType=" + serviceType + ", price=" + price
				+ ", hotelDto=" + hotelDto + "]";
	}
	

}
