package com.virtusa.hms.entity.room;
 
import com.virtusa.hms.keygenerator.CustomPrimaryKeyId;
 
import jakarta.persistence.Column;  
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
 
@Entity
@Table(name="upgrade_room_charges")
public class UpgradeRoomCharges {
    @Id
    @CustomPrimaryKeyId
    @Column(name="upgrade_charge_id")
    private String upgradeChargeId;
   
    @Column(name="upgrade_room_type")
    private String upgradeRoomType;
   
    @Column(name="upgrade_price")
    private double upgradePrice;
   
   
    public UpgradeRoomCharges() {
    }
    public UpgradeRoomCharges(String upgradeRoomType, double upgradePrice) {
 
        this.upgradeRoomType = upgradeRoomType;
        this.upgradePrice = upgradePrice;
    }
    public String getUpgradeChangeId() {
        return upgradeChargeId;
    }
    public void setUpgradeChangeId(String upgradeChargeId) {
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
    @Override
    public String toString() {
        return "UpgradeRoomCharges [upgradeChargeId=" + upgradeChargeId + ", upgradeRoomType=" + upgradeRoomType
                + ", upgradePrice=" + upgradePrice + "]";
    }
}
 
