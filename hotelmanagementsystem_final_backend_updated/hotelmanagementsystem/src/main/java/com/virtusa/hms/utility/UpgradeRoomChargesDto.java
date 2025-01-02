package com.virtusa.hms.utility;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;

public class UpgradeRoomChargesDto {
	
	private String upgradeChargeId;
	
	@NotNull
	private String upgradeRoomType;
	
	@Min(value = 100)
    @NotNull
	private double upgradePrice;

	public UpgradeRoomChargesDto() {
		super();
	}

	public UpgradeRoomChargesDto(String upgradeChargeId, @NotNull String upgradeRoomType,
			@Min(100) @NotNull double upgradePrice) {
		super();
		this.upgradeChargeId = upgradeChargeId;
		this.upgradeRoomType = upgradeRoomType;
		this.upgradePrice = upgradePrice;
	}

	public String getUpgradeChargeId() {
		return upgradeChargeId;
	}

	public void setUpgradeChargeId(String upgradeChargeId) {
		this.upgradeChargeId = upgradeChargeId;
	}

	public String getUpgradeRoomType() {
		return upgradeRoomType;
	}

	public void setUpgradeRoomType(String upgradeRoomType) {
		this.upgradeRoomType = upgradeRoomType;
	}

	public double getUpgradePrice() {
		return upgradePrice;
	}

	public void setUpgradePrice(double upgradePrice) {
		this.upgradePrice = upgradePrice;
	}
	

}
