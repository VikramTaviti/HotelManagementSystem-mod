package com.virtusa.hms.converter;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Component;

import com.virtusa.hms.entity.booking.Booking;
import com.virtusa.hms.entity.hotel.Attraction;
import com.virtusa.hms.entity.hotel.DiningRecommendation;
import com.virtusa.hms.entity.hotel.Hotel;
import com.virtusa.hms.entity.hotel.Location;
import com.virtusa.hms.entity.hotel.Review;
import com.virtusa.hms.entity.payment.Payment;
import com.virtusa.hms.entity.room.Room;
import com.virtusa.hms.entity.room.UpgradeRoom;
import com.virtusa.hms.entity.user.User;
import com.virtusa.hms.utility.AttractionDto;
import com.virtusa.hms.utility.BookingDto;
import com.virtusa.hms.utility.DiningRecommendationDto;
import com.virtusa.hms.utility.HotelDto;
import com.virtusa.hms.utility.LocationDto;
import com.virtusa.hms.utility.PaymentDto;
import com.virtusa.hms.utility.ReviewDto;
import com.virtusa.hms.utility.RoomDto;
import com.virtusa.hms.utility.UpgradeRoomDto;
import com.virtusa.hms.utility.UserDto;

@Component
public class ListDtoEntityConverter {
	
	public User convertUserDtoToEntity(UserDto userDto) {
		if(userDto == null)
			return null;
		User user = new User();
		user.setUserId(userDto.getUserId());
		user.setFirstName(userDto.getFirstName());
		user.setLastName(userDto.getLastName());
		user.setPassword(userDto.getPassword());
		user.setPhoneNo(userDto.getPhoneNo());
		user.setEmail(userDto.getEmail());
		user.setRole(userDto.getRole());
		return user;
		
	}
	
	public UserDto convertUserEntityToDto(User user) {
		if(user == null)
			return null;
		UserDto userDto = new UserDto();
		userDto.setUserId(user.getUserId());
		userDto.setFirstName(user.getFirstName());
		userDto.setLastName(user.getLastName());
		userDto.setPassword(user.getPassword());
		userDto.setPhoneNo(user.getPhoneNo());
		userDto.setEmail(user.getEmail());
		userDto.setRole(user.getRole());
		return userDto;
	}
	
	public Hotel convertHotelDtoToEntity(HotelDto hotelDto) {
		if(hotelDto == null)
			return null;
		Hotel hotel = new Hotel();
		hotel.setHotelId(hotelDto.getHotelId());
		hotel.setHotelName(hotelDto.getHotelName());
		hotel.setHotelEmail(hotelDto.getHotelEmail());
		hotel.setHotelPhone(hotelDto.getHotelPhone());
		hotel.setOverAllRating(hotelDto.getOverAllRating());
		hotel.setHotelImage(hotelDto.getHotelImage());
		hotel.setLocation(convertLocationDtoToEntity(hotelDto.getLocationDto()));
		return hotel;
		
	}
	
	public HotelDto convertHotelEntityToDto(Hotel hotel) {
		if(hotel == null)
			return null;
		HotelDto hotelDto = new HotelDto();
		hotelDto.setHotelId(hotel.getHotelId());
		hotelDto.setHotelEmail(hotel.getHotelEmail());
		hotelDto.setHotelName(hotel.getHotelName());
		hotelDto.setHotelPhone(hotel.getHotelPhone());
		hotelDto.setOverAllRating(hotel.getOverAllRating());
		hotelDto.setHotelImage(hotel.getHotelImage());
		hotelDto.setLocationDto(convertLocationEntityToDto(hotel.getLocation()));
		return hotelDto;
	}
	
	
	public Room convertRoomDtoToEntity(RoomDto roomDto) {
	    if (roomDto == null) return null;
	    System.out.println("Converting RoomDto to Room: " + roomDto);
	    Room room = new Room();
	    room.setRoomId(roomDto.getRoomId());
	    room.setAmenities(roomDto.getAmenities());
	    room.setDescription(roomDto.getDescription());
	    room.setMaxOccupancy(roomDto.getMaxOccupancy());
	    room.setPrice(roomDto.getPrice());
	    room.setRoomNo(roomDto.getRoomNo());
	    room.setRoomStatus(roomDto.getRoomStatus());
	    room.setRoomType(roomDto.getRoomType());
	    room.setPhotoUrl(roomDto.getPhotoUrl());
	    room.setHotel(convertHotelDtoToEntity(roomDto.getHotelDto())); 
	    System.out.println("Converted Room: " + room.toString());
	    return room;
	}

	
	public RoomDto convertRoomEntityToDto(Room room) {
	    if (room == null) return null;
	    RoomDto roomDto = new RoomDto();
	    roomDto.setRoomId(room.getRoomId());
	    roomDto.setAmenities(room.getAmenities());
	    roomDto.setDescription(room.getDescription());
	    roomDto.setMaxOccupancy(room.getMaxOccupancy());
	    roomDto.setPrice(room.getPrice());
	    roomDto.setRoomNo(room.getRoomNo());
	    roomDto.setRoomStatus(room.getRoomStatus());
	    roomDto.setRoomType(room.getRoomType());
	    roomDto.setPhotoUrl(room.getPhotoUrl());
	    roomDto.setHotelDto(convertHotelEntityToDto(room.getHotel())); // Ensure this conversion is correct
	    return roomDto;
	}

	
	
	public Location convertLocationDtoToEntity(LocationDto locationDto) {
		if(locationDto == null)
			return null;
		Location location = new Location();
		location.setLocationId(locationDto.getLocationId());
		location.setStreet(locationDto.getStreet());
		location.setCity(locationDto.getCity());
		location.setCountry(locationDto.getCountry());
		location.setState(locationDto.getState());
		location.setPincode(locationDto.getPincode());
		location.setStreetNumber(locationDto.getStreetNumber());
		return location;
		
	}
	
	public LocationDto convertLocationEntityToDto(Location location) {
		if(location == null)
			return null;
		LocationDto locationDto = new LocationDto();
		locationDto.setLocationId(location.getLocationId());
		locationDto.setStreet(location.getStreet());
		locationDto.setCity(location.getCity());
		locationDto.setCountry(location.getCountry());
		locationDto.setState(location.getState());
		locationDto.setPincode(location.getPincode());
		locationDto.setStreetNumber(location.getStreetNumber());
		return locationDto;
		
	}

	public AttractionDto convertAttractionEntityToDto(Attraction attraction) {
		if(attraction == null)
			return null;
		AttractionDto attractionDto = new AttractionDto();
		attractionDto.setAttractionId(attraction.getAttractionId());
		attractionDto.setAttractionName(attraction.getAttractionName());
		attractionDto.setAttractionEmail(attraction.getAttractionEmail());
		attractionDto.setLocationDto(convertLocationEntityToDto(attraction.getLocation()));
		return attractionDto;
		
	}

	public Attraction convertAttractionDtoToEntity(AttractionDto attractionDto) {
		if(attractionDto == null)
			return null;
		Attraction attraction = new Attraction();
		attraction.setAttractionId(attractionDto.getAttractionId());
		attraction.setAttractionName(attractionDto.getAttractionName());
		attraction.setAttractionEmail(attractionDto.getAttractionEmail());
		attraction.setLocation(convertLocationDtoToEntity(attractionDto.getLocationDto()));
		return attraction;
		
	}
	
	public BookingDto convertBookingEntityToDto(Booking booking) {
	    if (booking == null) {
	        return null;
	    }
	    BookingDto bookingDto = new BookingDto();
	    bookingDto.setBookingId(booking.getBookingId());
	    bookingDto.setBookingStatus(booking.getBookingStatus());
	    bookingDto.setCheckIn(booking.getCheckIn());
	    bookingDto.setCheckOut(booking.getCheckOut());
	    bookingDto.setRoomDto(convertRoomEntityToDto(booking.getRoom()));
	    bookingDto.setUserDto(convertUserEntityToDto(booking.getUser()));
	    return bookingDto;
	}

	public Booking convertBookingDtoToEntity(BookingDto bookingDto) {
	    if (bookingDto == null) return null;
	    Booking booking = new Booking();
	    booking.setBookingId(bookingDto.getBookingId());
	    booking.setBookingStatus(bookingDto.getBookingStatus());
	    booking.setCheckIn(bookingDto.getCheckIn());
	    booking.setCheckOut(bookingDto.getCheckOut());
	    booking.setRoom(convertRoomDtoToEntity(bookingDto.getRoomDto()));
	    booking.setUser(convertUserDtoToEntity(bookingDto.getUserDto()));
	    return booking;
	}


	
	public PaymentDto convertPaymentEntityToDto(Payment payment) {
		if(payment == null) {
			return null;
		}
		PaymentDto paymentDto = new PaymentDto();
		paymentDto.setAmount(payment.getAmount());
		paymentDto.setPaymentDateTime(payment.getPaymentDateTime());
		paymentDto.setPaymentId(payment.getPaymentId());
		paymentDto.setPaymentMethod(payment.getPaymentMethod());
		paymentDto.setPaymentStatus(payment.getPaymentStatus());
		paymentDto.setBookingDto(convertBookingEntityToDto(payment.getBooking()));
		return paymentDto;
	}
	
	public Payment convertPaymentDtoToEntity(PaymentDto paymentDto) {
		if(paymentDto == null) {
			return null;
		}
		Payment payment = new Payment();
		payment.setAmount(paymentDto.getAmount());
		payment.setPaymentDateTime(paymentDto.getPaymentDateTime());
		payment.setPaymentId(paymentDto.getPaymentId());
		payment.setPaymentMethod(paymentDto.getPaymentMethod());
		payment.setPaymentStatus(paymentDto.getPaymentStatus());
		payment.setBooking(convertBookingDtoToEntity(paymentDto.getBookingDto()));
		return payment;
	}
	
	public UpgradeRoom convertUpgradeRoomDtoToEntity(UpgradeRoomDto upgradeRoomDto) {
		if(upgradeRoomDto == null)
			return null;
		UpgradeRoom upgradeRoom = new UpgradeRoom();
		upgradeRoom.setUpgradeId(upgradeRoomDto.getUpgradeId());
		upgradeRoom.setUpgradeDate(upgradeRoomDto.getUpgradeDate());
		upgradeRoom.setUpgradeStatus(upgradeRoomDto.getUpgradeStatus());
		upgradeRoom.setUpgradeCharges(upgradeRoomDto.getUpgradeCharges());
		upgradeRoom.setOldRoom(convertRoomDtoToEntity(upgradeRoomDto.getOldRoomDto()) );
		upgradeRoom.setNewRoom(convertRoomDtoToEntity(upgradeRoomDto.getNewRoomDto()));
		return upgradeRoom;
	}
	
	public UpgradeRoomDto convertUpgradeRoomEntityToDto(UpgradeRoom upgradeRoom) {
		if(upgradeRoom == null)
			return null;
		UpgradeRoomDto upgradeRoomDto = new UpgradeRoomDto();
		upgradeRoomDto.setUpgradeId(upgradeRoom.getUpgradeId());
		upgradeRoomDto.setUpgradeDate(upgradeRoom.getUpgradeDate());
		upgradeRoomDto.setUpgradeStatus(upgradeRoom.getUpgradeStatus());
		upgradeRoomDto.setUpgradeCharges(upgradeRoom.getUpgradeCharges());
		upgradeRoomDto.setOldRoomDto(convertRoomEntityToDto(upgradeRoom.getOldRoom()) );
		upgradeRoomDto.setNewRoomDto(convertRoomEntityToDto(upgradeRoom.getNewRoom()));
		return upgradeRoomDto;
	}
	
	
	public List<Attraction> convertAttractionDtoListToEntityList(List<AttractionDto> attractionDtos){
		return attractionDtos.stream().map(this:: convertAttractionDtoToEntity)
				.collect(Collectors.toList());
	}
	
	public List<DiningRecommendation> convertDiningRecommendationDtoListToEntityList(List<DiningRecommendationDto> attractionDtos){
		return attractionDtos.stream().map(this:: convertDiningRecommendationDtoToEntity)
				.collect(Collectors.toList());
	}
	
	public ReviewDto convertReviewEntityToDto(Review review) {
		if(review == null)
			return null;
		ReviewDto reviewDto = new ReviewDto();
		reviewDto.setReviewId(review.getReviewId());
		reviewDto.setRating(review.getRating());
		reviewDto.setComment(review.getComment());
		reviewDto.setUserDto(convertUserEntityToDto(review.getUser()));
		reviewDto.setHotelDto(convertHotelEntityToDto(review.getHotel()));
		reviewDto.setDiningRecommendationDto(convertDiningRecommendationEntityToDto(review.getDiningRecommendation()));
		return reviewDto;
	}
	
	public List<ReviewDto> convertReviewEntityListToDto(List<Review> review){
		return review
				.stream()
				.map(this::convertReviewEntityToDto)
				.collect(Collectors.toList());
	}
	
	public List<Review> convertReviewDtoListToEntity(List<ReviewDto> reviewDto){
        if (reviewDto == null) {
            return Collections.emptyList();
        }
		
		return reviewDto
				.stream()
				.map(this::convertReviewDtoToEntity)
				.collect(Collectors.toList());
	}
	
	public Review convertReviewDtoToEntity(ReviewDto reviewDto) {
		if(reviewDto == null)
			return null;
		Review review = new Review();
		review.setReviewId(reviewDto.getReviewId());
		review.setRating(reviewDto.getRating());
		review.setComment(reviewDto.getComment());
		review.setUser(convertUserDtoToEntity(reviewDto.getUserDto()));
		review.setHotel(convertHotelDtoToEntity(reviewDto.getHotelDto()));
		review.setDiningRecommendation(convertDiningRecommendationDtoToEntity(reviewDto.getDiningRecommendationDto()));
		return review;
	}
	
	public DiningRecommendationDto convertDiningRecommendationEntityToDto(DiningRecommendation diningRecommendation) {
		if(diningRecommendation == null)
			return null;
		DiningRecommendationDto diningRecommendationDto = new DiningRecommendationDto();
		diningRecommendationDto.setDiningId(diningRecommendation.getDiningId());
		diningRecommendationDto.setDiningname(diningRecommendation.getDiningname());
		diningRecommendationDto.setDiningRecommendationEmail(diningRecommendation.getDiningRecommendationEmail());
		diningRecommendationDto.setDiningOverallRating(diningRecommendation.getDiningOverallRating());
		diningRecommendationDto.setLocationDto(convertLocationEntityToDto(diningRecommendation.getLocation()));
		return diningRecommendationDto;
	}
	
	public DiningRecommendation convertDiningRecommendationDtoToEntity(DiningRecommendationDto diningRecommendationDto) {
		if(diningRecommendationDto == null)
			return null;
		DiningRecommendation diningRecommendation = new DiningRecommendation();
		diningRecommendation.setDiningId(diningRecommendationDto.getDiningId());
		diningRecommendation.setDiningname(diningRecommendationDto.getDiningname());
		diningRecommendation.setDiningRecommendationEmail(diningRecommendationDto.getDiningRecommendationEmail());
		diningRecommendation.setDiningOverallRating(diningRecommendationDto.getDiningOverallRating());
		diningRecommendation.setLocation(convertLocationDtoToEntity(diningRecommendationDto.getLocationDto()));
		return diningRecommendation;
	}

	
	public List<DiningRecommendationDto> convertDiningRecommendationEntityListToDtoList(List<DiningRecommendation> attractions){
		return attractions.stream().map(this:: convertDiningRecommendationEntityToDto)
				.collect(Collectors.toList());
	}
	
	public List<AttractionDto> convertAttractionEntityListToDtoList(List<Attraction> attractions){
		return attractions.stream().map(this:: convertAttractionEntityToDto)
				.collect(Collectors.toList());
	}
	
	
	public List<HotelDto> convertHotelEntityListToDtoList(List<Hotel> hotels){
		return hotels.stream().map(this:: convertHotelEntityToDto)
				.collect(Collectors.toList());
	}
	
	public List<RoomDto> convertRoomEntityListToDtoList(List<Room> rooms){
		return rooms.stream().map(this:: convertRoomEntityToDto)
				.collect(Collectors.toList());
	}
	
	public List<Room> convertRoomDtoListToEntityList(List<RoomDto> roomDto){
		return roomDto.stream().map(this:: convertRoomDtoToEntity)
				.collect(Collectors.toList());
	}
	
	public List<PaymentDto> convertPaymentEntityListToDtoList(List<Payment> payments){
		return payments.stream().map(this:: convertPaymentEntityToDto)
				.collect(Collectors.toList());
	}
	
	public List<BookingDto> convertBookingEntityListToDtoList(List<Booking> bookings){
		return bookings.stream().map(this:: convertBookingEntityToDto)
				.collect(Collectors.toList());
	}
	
}
