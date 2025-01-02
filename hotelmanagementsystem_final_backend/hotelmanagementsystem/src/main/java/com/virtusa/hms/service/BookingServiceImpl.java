package com.virtusa.hms.service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.Period;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.virtusa.hms.converter.ListDtoEntityConverter;
import com.virtusa.hms.entity.Status;
import com.virtusa.hms.entity.booking.Booking;
import com.virtusa.hms.entity.payment.Payment;
import com.virtusa.hms.entity.payment.PaymentMethod;
import com.virtusa.hms.entity.room.Room;
import com.virtusa.hms.entity.room.UpgradeRoom;
import com.virtusa.hms.repository.BookingRepository;
import com.virtusa.hms.repository.PaymentRepository;
import com.virtusa.hms.repository.RoomRepository;
import com.virtusa.hms.repository.UpgradeRoomRepository;
import com.virtusa.hms.repository.UpgradeRoomchargesRepository;
import com.virtusa.hms.utility.BookingDto;
import com.virtusa.hms.utility.PaymentDto;
import com.virtusa.hms.utility.UserDto;


@Service
public class BookingServiceImpl implements BookingService{
	
	@Autowired
	private BookingRepository bookingRepository;
	
	@Autowired
	private UserService userService;
	
	@Autowired
	private PaymentService paymentService;
	
	@Autowired
	private PaymentRepository paymentRepository;
	
	@Autowired
	private ListDtoEntityConverter listDtoEntityConverter;
	
	@Autowired
	private UpgradeRoomRepository upgradeRoomRepository;
	
	@Autowired
	private UpgradeRoomchargesRepository upgradeRoomchargesRepository;
	
	@Autowired
	private RoomRepository roomRepository;

	@Override
	public PaymentDto addBookings(String userId,PaymentDto paymentDto) {
		UserDto userDto = userService.getUserDetailsByUserId(userId);
		LocalDate checkIn = paymentDto.getBookingDto().getCheckIn();
		LocalDate checkOut = paymentDto.getBookingDto().getCheckOut();
		Period period = Period.between(checkIn, checkOut);
		double totalAmount = paymentDto.getAmount() * period.getDays();
		paymentDto.setAmount(totalAmount);
		paymentDto.getBookingDto().setUserDto(userDto);
		Booking booking = listDtoEntityConverter.convertBookingDtoToEntity(paymentDto.getBookingDto());
		Booking savedBooking = bookingRepository.save(booking);
		BookingDto bookingDto = listDtoEntityConverter.convertBookingEntityToDto(savedBooking);
		paymentDto.setBookingDto(bookingDto);
		PaymentDto savedPaymentDto = paymentService.addPaymentDetails(paymentDto);
		return savedPaymentDto;
	}

	@Override
	public List<PaymentDto> getAllPaymentsByUserId(String userId) {
		List<Payment> userPayments = paymentRepository.getAllPaymentsByUserId(userId);
		System.out.println("-----------------------"+userPayments);
		return listDtoEntityConverter.convertPaymentEntityListToDtoList(userPayments);
	}

	@Override
	public String cancelBookingDetails(String userId, String bookingId) {
		Optional<Booking> bookingDetails = bookingRepository.findById(bookingId);
		bookingDetails.get().setBookingStatus(Status.CANCELLED);
		bookingRepository.save(bookingDetails.get());
		return "Booking cancel successfull";
	}
	
	@Override
	public String upgradeBooking(String userId, String newRoomId, PaymentDto paymentDto) {

	    // Fetch the previous payment details
	    Optional<Payment> previousPaymentDetails = paymentRepository.findById(paymentDto.getPaymentId());

	    if (!previousPaymentDetails.isPresent()) {
	        return "Previous payment details not found!";
	    }

	    // Retrieve the current booking and room details
	    String bookingId = previousPaymentDetails.get().getBooking().getBookingId();
	    Optional<Booking> bookingDetails = bookingRepository.findById(bookingId);

	    if (!bookingDetails.isPresent()) {
	        return "Booking details not found!";
	    }

	    Optional<Room> upgradeRoom = roomRepository.findById(newRoomId);
	    if (!upgradeRoom.isPresent()) {
	        return "New room not found!";
	    }

	    // Fetch the current room
	    String oldRoomId = previousPaymentDetails.get().getBooking().getRoom().getRoomId();
	    Optional<Room> oldRoom = roomRepository.findById(oldRoomId);
	    if (!oldRoom.isPresent()) {
	        return "Old room not found!";
	    }

	    // Get the upgrade room charges from the database
	    double upgradePrice = upgradeRoomchargesRepository.getUpgradeRoomChargeByRoomType(upgradeRoom.get().getRoomType());

	    // Check the conditions for upgrade
	    LocalDate checkInDate = bookingDetails.get().getCheckIn();
	    LocalDate presentDate = LocalDate.now();
	    Period period = Period.between(presentDate, checkInDate);

	    // Ensure upgrade is allowed only if the check-in date is in the future
	    if (period.getDays() < 1 || !checkInDate.isAfter(presentDate)) {
	        return "Upgrade is not possible at this moment as the check-in date has passed!";
	    }

	    UpgradeRoom upgradeRoomDetails;

	    // If no previous upgrade exists, create a new upgrade record
	    if (previousPaymentDetails.get().getBooking().getUpgradeRoom() == null) {
	        upgradeRoomDetails = new UpgradeRoom();
	        upgradeRoomDetails.setUpgradeDate(presentDate);
	        upgradeRoomDetails.setUpgradeStatus(Status.CONFIRMED);
	        upgradeRoomDetails.setUpgradeCharges(upgradePrice);
	        upgradeRoomDetails.setNewRoom(upgradeRoom.get());
	        upgradeRoomDetails.setOldRoom(oldRoom.get());
	        upgradeRoomRepository.save(upgradeRoomDetails);

	        // Update the booking with the new room
	        bookingDetails.get().setRoom(upgradeRoom.get());
	    } else {
	        // If there is a previous upgrade, update it with the new room details
	        upgradeRoomDetails = previousPaymentDetails.get().getBooking().getUpgradeRoom();
	        upgradeRoomDetails.setOldRoom(upgradeRoomDetails.getNewRoom()); // Set the old room to the new one
	        upgradeRoomDetails.setNewRoom(upgradeRoom.get());
	        upgradeRoomDetails.setUpgradeCharges(upgradePrice);
	        upgradeRoomDetails.setUpgradeDate(presentDate);
	        upgradeRoomRepository.save(upgradeRoomDetails);

	        // Update the booking with the new room
	        bookingDetails.get().setRoom(upgradeRoom.get());
	    }

	    // Update the check-in and check-out dates (can be received from the paymentDto)
	    bookingDetails.get().setCheckIn(paymentDto.getBookingDto().getCheckIn());
	    bookingDetails.get().setCheckOut(paymentDto.getBookingDto().getCheckOut());

	    // Update the booking status to "CONFIRMED"
	    bookingDetails.get().setBookingStatus(Status.CONFIRMED);
	    bookingDetails.get().setUpgradeRoom(upgradeRoomDetails);

	    // Save the updated booking
	    bookingRepository.save(bookingDetails.get());

	    // Create a new payment entry for the upgraded booking
	    Payment newPaymentDetails = new Payment();
	    newPaymentDetails.setAmount(upgradePrice + paymentDto.getAmount());
	    newPaymentDetails.setBooking(bookingDetails.get());
	    newPaymentDetails.setPaymentDateTime(LocalDateTime.now());
	    newPaymentDetails.setPaymentMethod(PaymentMethod.UPI); // Set the appropriate payment method
	    newPaymentDetails.setPaymentStatus(Status.CONFIRMED);
	    paymentRepository.save(newPaymentDetails);

	    // If the previous booking price is greater than the current one, refund the difference
	    double previousBookingPrice = previousPaymentDetails.get().getAmount();
	    double currentBookingPriceForUpgrade = paymentDto.getAmount();

	    if (previousBookingPrice > currentBookingPriceForUpgrade) {
	        return "Upgrade room successful. Amount refunded: " + (previousBookingPrice - currentBookingPriceForUpgrade);
	    }

	    return "Upgrade room successful.";
	}

}
