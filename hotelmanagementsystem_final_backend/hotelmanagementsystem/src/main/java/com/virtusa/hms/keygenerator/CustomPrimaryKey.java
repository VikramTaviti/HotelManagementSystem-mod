package com.virtusa.hms.keygenerator;

import java.util.UUID; 

import org.hibernate.engine.spi.SharedSessionContractImplementor;
import org.hibernate.id.IdentifierGenerator;

import com.virtusa.hms.entity.booking.Booking;
import com.virtusa.hms.entity.hotel.Attraction;
import com.virtusa.hms.entity.hotel.DiningRecommendation;
import com.virtusa.hms.entity.hotel.Facility;
import com.virtusa.hms.entity.hotel.Hotel;
import com.virtusa.hms.entity.hotel.Location;
import com.virtusa.hms.entity.hotel.Review;
import com.virtusa.hms.entity.payment.Payment;
import com.virtusa.hms.entity.room.Room;
import com.virtusa.hms.entity.room.UpgradeRoom;
import com.virtusa.hms.entity.room.UpgradeRoomCharges;
import com.virtusa.hms.entity.user.User;

public class CustomPrimaryKey implements IdentifierGenerator {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	public Object generate(SharedSessionContractImplementor session, Object object) {
		if(object instanceof Hotel) {
			Hotel hotel = (Hotel) object;
			return generateUniqueKey(hotel.getHotelName(),hotel.getHotelEmail(),hotel.getHotelPhone());
		}else if(object instanceof Location) {
			return generateRandomUniqueKey();
		}else if(object instanceof Facility) {
			Facility facility = (Facility) object;
			return generateUniqueKey(facility.getPrice(),facility.getServiceType());
		}else if(object instanceof Review) {
			Review review = (Review) object;
			return generateUniqueKey(review.getRating(),review.getComment(),review.getUser().getEmail());
		}else if(object instanceof DiningRecommendation) {
			DiningRecommendation diningRecommendation = (DiningRecommendation) object;
			return generateUniqueKey(diningRecommendation.getDiningOverallRating(),diningRecommendation.getDiningname(),diningRecommendation.getLocation().getStreet(),diningRecommendation.getLocation().getCity());
		}else if(object instanceof Attraction) {
			Attraction attraction = (Attraction) object;
			return generateUniqueKey(attraction.getAttractionName(),attraction.getLocation().getStreet(),attraction.getLocation().getCity());
		}else if(object instanceof User) {
			User user = (User) object;
			return generateUniqueKey(user.getRole().toString(),user.getEmail(),user.getFirstName(),user.getLastName(),user.getPhoneNo());
		}else if(object instanceof Booking) {
			return generateRandomUniqueKey();
		}else if(object instanceof Payment) {
			Payment payment = (Payment) object;
			return generateUniqueKey(payment.getAmount(),payment.getPaymentDateTime().toString(),payment.getPaymentMethod().toString(),payment.getPaymentStatus().toString(),payment.getBooking().getBookingId());
		}else if(object instanceof Room) {
			return generateRandomUniqueKey();
		}else if(object instanceof UpgradeRoom) {
			UpgradeRoom upgradeRoom = (UpgradeRoom) object;
			return generateUniqueKey(upgradeRoom.getReasonForUpgrade(),upgradeRoom.getUpgradeDate().toString(),upgradeRoom.getUpgradeStatus().toString());
		}else if(object instanceof UpgradeRoomCharges) {
			UpgradeRoomCharges upgradeRoomCharges = (UpgradeRoomCharges) object;
			return generateUniqueKey(upgradeRoomCharges.getUpgradePrice(),upgradeRoomCharges.getUpgradeRoomType());
		}
		throw new IllegalArgumentException("Unsupported entity type");
	}
	
	private Object generateRandomUniqueKey() {
		return UUID.randomUUID().toString();
	}

	private String generateUniqueKey(double value, String... fields) {
		String resultUUID = generateUniqueKey(fields);
		String details = resultUUID + String.valueOf(value);
		UUID uuid = UUID.nameUUIDFromBytes(details.getBytes());
		return uuid.toString();
	}

	private String generateUniqueKey(String... fields) {
		String details = "";
		for(String field : fields) {
			details+=field;
		}
		UUID uuid = UUID.nameUUIDFromBytes(details.getBytes());
		return uuid.toString();
	}
	
	private String generateUniqueKey(int value,String... fields) {
		String resultUUID = generateUniqueKey(fields);
		String details = resultUUID + String.valueOf(value);
		UUID uuid = UUID.nameUUIDFromBytes(details.getBytes());
		return uuid.toString();
		
	}

}
