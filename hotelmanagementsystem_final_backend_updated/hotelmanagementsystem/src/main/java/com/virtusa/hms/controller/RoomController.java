package com.virtusa.hms.controller;
 
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.virtusa.hms.exceptions.RoomNotFoundException;
import com.virtusa.hms.service.RoomService;
import com.virtusa.hms.utility.Message;
import com.virtusa.hms.utility.RoomDto;

import jakarta.validation.Valid;

@RestController
@Validated
@RequestMapping("/room")
@CrossOrigin(origins = "http://localhost:4200")
public class RoomController {
	
	@Autowired
	private RoomService roomService;
	
	@Autowired
	private Message message;
	
	public RoomController() {
		super();
	}

	@Autowired
	public RoomController(RoomService roomService) {
		super();
		this.roomService = roomService;
	}
	
	@PostMapping("/add/{hotelId}")
	public ResponseEntity<Message> insertRoomDetails(@PathVariable String hotelId, @Valid @RequestBody RoomDto roomDto){
		return ResponseEntity.status(HttpStatus.OK).body(new Message(roomService.insertRoomDetails(roomDto,hotelId)));
	}
	
	@GetMapping("{hotelId}")
	public ResponseEntity<List<RoomDto>> getRoomsInHotelByHotelId(@PathVariable String hotelId) {
		List<RoomDto> availableRooms = roomService.getRoomsInHotelByHotelId(hotelId);
		return ResponseEntity.ok(availableRooms);
	}
	
	@GetMapping("/availableRooms/{hotelId}/{roomType}/{checkInDate}/{checkOutDate}")
	public ResponseEntity<List<RoomDto>> getRoomsInHotelByHotelId(@PathVariable("hotelId") String hotelId,@PathVariable("roomType") String roomType,@PathVariable("checkInDate") String checkInDate,@PathVariable("checkOutDate") String checkOutDate) throws RoomNotFoundException {
		List<RoomDto> availableRooms = roomService.getRoomsInHotelByHotelIdAndRoomType(hotelId,roomType,checkInDate,checkOutDate);
		return ResponseEntity.ok(availableRooms);
	}
	
	@GetMapping("roomDetails/{roomId}")
	public ResponseEntity<RoomDto> getRoomDetailsByRoomId(@PathVariable String roomId){
		RoomDto roomDto = roomService.getRoomDetailsByRoomId(roomId);
		return ResponseEntity.ok(roomDto);
	}
	
	@PutMapping("/edit")
	public ResponseEntity<Message> updateRoomDetails(@Valid @RequestBody RoomDto roomDto){
		String response = roomService.updateRoomDetails(roomDto);
		message.setMessage(response);
		return ResponseEntity.status(HttpStatus.OK).body(message);
	}
	
	@DeleteMapping("{roomId}")
	public ResponseEntity<Message> deleteRoomDetails(@PathVariable String roomId){
		return ResponseEntity.ok().body(new Message(roomService.deleteRoomDetails(roomId)));
	}
	
}
