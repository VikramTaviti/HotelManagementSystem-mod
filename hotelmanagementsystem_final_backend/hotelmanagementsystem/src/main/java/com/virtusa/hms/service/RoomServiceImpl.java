package com.virtusa.hms.service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.virtusa.hms.converter.ListDtoEntityConverter;
import com.virtusa.hms.entity.hotel.Hotel;
import com.virtusa.hms.entity.room.Room;
import com.virtusa.hms.exceptions.RoomNotFoundException;
import com.virtusa.hms.repository.HotelRepository;
import com.virtusa.hms.repository.RoomRepository;
import com.virtusa.hms.utility.RoomDto;

@Service
public class RoomServiceImpl implements RoomService {
	
	@Autowired
	private RoomRepository roomRepository;	
	
	@Autowired
	private HotelRepository hotelRepository;

	
	@Autowired
	private ListDtoEntityConverter listDtoEntityConverter;
	
	public RoomServiceImpl() {
		super();
	}

	@Autowired
	public RoomServiceImpl(RoomRepository roomRepository) {
		super();
		this.roomRepository = roomRepository;
	}

//	@Override
//	public List<RoomDto> findAvailableRoomsInHotelByDatesAndRoomType(int hotelId, LocalDate checkInDate,
//			LocalDate checkOutDate, String roomType) {
//		List<Room> rooms = roomRepository.findAvailableRoomsInHotelByDatesAndRoomType(hotelId,checkInDate,checkOutDate,roomType);
//		return listDtoEntityConverter.convertRoomListToDto(rooms);
//	}

	@Override
	public String insertRoomDetails(RoomDto roomDto, String hotelId) {
		Optional<Hotel> hotel = hotelRepository.findById(hotelId);
		Room room = listDtoEntityConverter.convertRoomDtoToEntity(roomDto);
		System.out.println("room entity:  "+room);
		room.setHotel(hotel.get());
		roomRepository.save(room);
		return "Room details inserted successfully";
	}

	@Override
	public List<RoomDto> getRoomsInHotelByHotelId(String hotelId) {
		List<Room> rooms = roomRepository.getRoomsInHotelByHotelId(hotelId);
		return listDtoEntityConverter.convertRoomEntityListToDtoList(rooms);
	}

	@Override
	public RoomDto getRoomDetailsByRoomId(String roomId) {
		Optional<Room> room = roomRepository.findById(roomId);
		return listDtoEntityConverter.convertRoomEntityToDto(room.get());
	}

	@Override
	public String updateRoomDetails(RoomDto roomDto) {
		Room room = listDtoEntityConverter.convertRoomDtoToEntity(roomDto);
		roomRepository.save(room);
		return "room details updated successfull";
	}

	@Override
	public String deleteRoomDetails(String roomId) {
		roomRepository.deleteById(roomId);
		return "room details details successfull";
	}

	@Override
	public List<RoomDto> getRoomsInHotelByHotelIdAndRoomType(String hotelId, String roomType, String checkInDate,
			String checkOutDate) throws RoomNotFoundException {
		LocalDate convertedCheckInDate = LocalDate.parse(checkInDate);
		LocalDate convertedCheckOutDate = LocalDate.parse(checkOutDate);
		List<Room> roomList = roomRepository.getAvailableRoomsInHotelByHotelIdAndRoomType(hotelId, roomType,convertedCheckInDate,convertedCheckOutDate);
		if(roomList == null) {
			throw new RoomNotFoundException("No Rooms Exist...");
		}
		List<RoomDto> roomDtoList = listDtoEntityConverter.convertRoomEntityListToDtoList(roomList);
		return roomDtoList;
	}
	

}
