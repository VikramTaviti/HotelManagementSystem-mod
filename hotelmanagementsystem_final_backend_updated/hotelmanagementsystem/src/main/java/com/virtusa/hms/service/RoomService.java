package com.virtusa.hms.service;

import java.util.List;

import com.virtusa.hms.exceptions.RoomNotFoundException;
import com.virtusa.hms.utility.RoomDto;


public interface RoomService {

	public String insertRoomDetails(RoomDto roomDto, String hotelId);

	public List<RoomDto> getRoomsInHotelByHotelId(String hotelId);

	public RoomDto getRoomDetailsByRoomId(String roomId);

	public String updateRoomDetails(RoomDto roomDto);

	public String deleteRoomDetails(String roomId);

	public List<RoomDto> getRoomsInHotelByHotelIdAndRoomType(String hotelId, String roomType, String checkInDate, String checkOutDate) throws RoomNotFoundException;

}
