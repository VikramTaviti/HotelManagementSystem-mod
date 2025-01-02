package com.virtusa.hms.utility;

import java.time.LocalDate;

import org.springframework.format.annotation.DateTimeFormat;

import com.virtusa.hms.entity.Status;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;

public class UpgradeRoomDto {
	
	private String upgradeId;
	
	private RoomDto oldRoomDto;
	
	private RoomDto newRoomDto;
	
	@NotNull
    @DateTimeFormat(pattern = "yyyy-MM-dd")
	private LocalDate upgradeDate;
	
	private double upgradeCharges;
	
	@NotNull
	private String reasonForUpgrade;
	
	@NotNull
	private Status upgradeStatus;

	public UpgradeRoomDto() {
		super();
	}

	public UpgradeRoomDto(String upgradeId, RoomDto oldRoomDto, RoomDto newRoomDto,
			@NotNull LocalDate upgradeDate, @Valid double upgradeCharges,
			@NotNull String reasonForUpgrade, @NotNull Status upgradeStatus) {
		super();
		this.upgradeId = upgradeId;
		this.oldRoomDto = oldRoomDto;
		this.newRoomDto = newRoomDto;
		this.upgradeDate = upgradeDate;
		this.upgradeCharges = upgradeCharges;
		this.reasonForUpgrade = reasonForUpgrade;
		this.upgradeStatus = upgradeStatus;
	}

	public String getUpgradeId() {
		return upgradeId;
	}

	public void setUpgradeId(String upgradeId) {
		this.upgradeId = upgradeId;
	}

	public RoomDto getOldRoomDto() {
		return oldRoomDto;
	}

	public void setOldRoomDto(RoomDto oldRoomDto) {
		this.oldRoomDto = oldRoomDto;
	}

	public RoomDto getNewRoomDto() {
		return newRoomDto;
	}

	public void setNewRoomDto(RoomDto newRoomDto) {
		this.newRoomDto = newRoomDto;
	}

	public LocalDate getUpgradeDate() {
		return upgradeDate;
	}

	public void setUpgradeDate(LocalDate upgradeDate) {
		this.upgradeDate = upgradeDate;
	}

	public double getUpgradeCharges() {
		return upgradeCharges;
	}

	public void setUpgradeCharges(double upgradeCharges) {
		this.upgradeCharges= upgradeCharges;
	}

	public String getReasonForUpgrade() {
		return reasonForUpgrade;
	}

	public void setReasonForUpgrade(String reasonForUpgrade) {
		this.reasonForUpgrade = reasonForUpgrade;
	}

	public Status getUpgradeStatus() {
		return upgradeStatus;
	}

	public void setUpgradeStatus(Status upgradeStatus) {
		this.upgradeStatus = upgradeStatus;
	}

	@Override
	public String toString() {
		return "UpgradeRoomDto [upgradeId=" + upgradeId +", oldRoomDto=" + oldRoomDto
				+ ", newRoomDto=" + newRoomDto + ", upgradeDate=" + upgradeDate + ", upgradeChargesDto="
				 + ", reasonForUpgrade=" + reasonForUpgrade + ", upgradeStatus=" + upgradeStatus
				+ "]";
	}
 
}
