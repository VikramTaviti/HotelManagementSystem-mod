package com.virtusa.hms.entity.room;

import java.time.LocalDate;   
import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import com.virtusa.hms.entity.Status;
import com.virtusa.hms.entity.booking.Booking;
import com.virtusa.hms.keygenerator.CustomPrimaryKeyId;
 
@Entity
@Table(name="upgrade_room")
public class UpgradeRoom {
 
	@Id
	@CustomPrimaryKeyId
	@Column(name="upgrade_id")
	private String upgradeId;

	@Column(name="upgrade_date")
	private LocalDate upgradeDate;
	
	@Column(name="reason_for_upgrade")
	private String reasonForUpgrade;
	
	@Enumerated(EnumType.STRING)
	@Column(name = "upgrade_status")
	private Status upgradeStatus;

    private double upgradeCharges;
	

	@OneToOne(cascade=CascadeType.ALL)
	private Room oldRoom;
 
	@OneToOne(cascade=CascadeType.ALL)
	private Room newRoom;
	
	@OneToOne(mappedBy = "upgradeRoom",cascade = CascadeType.ALL,fetch = FetchType.LAZY)
	private Booking booking;
 
	public UpgradeRoom() {
 
	}
 
	public UpgradeRoom(Room oldRoom, Room newRoom, LocalDate upgradeDate,
			double upgradeCharges, String reasonForUpgrade, Status upgradeStatus) {
		super();
		this.oldRoom = oldRoom;
		this.newRoom = newRoom;
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
 
	public Room getOldRoom() {
		return oldRoom;
	}
 
	public void setOldRoom(Room oldRoom) {
		this.oldRoom = oldRoom;
	}
 
	public Room getNewRoom() {
		return newRoom;
	}
 
	public void setNewRoom(Room newRoom) {
		this.newRoom = newRoom;
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
		this.upgradeCharges = upgradeCharges;
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
		return "UpgradeRoom [upgradeId=" + upgradeId + ", oldRoom=" + oldRoom + ", newRoom="
				+ newRoom + ", upgradeDate=" + upgradeDate + ", upgradeCharges=" + upgradeCharges
				+ ", reasonForUpgrade=" + reasonForUpgrade + ", upgradeStatus=" + upgradeStatus + "]";
	}
 
}
