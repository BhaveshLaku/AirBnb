package com.bhavesh.airbnbapp.controller;

import com.bhavesh.airbnbapp.dto.HotelDto;
import com.bhavesh.airbnbapp.service.HotelService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/admin/hotels")
@RequiredArgsConstructor
@Slf4j
public class HotelController {

    private final HotelService hotelService;

    @PostMapping
    public ResponseEntity<HotelDto> createNewHotel(@RequestBody HotelDto hotelDto) {
        log.info("Attempting to create a new hotel with name: {}", hotelDto.getName());
        HotelDto hotel = hotelService.createNewHotel(hotelDto);
        return ResponseEntity.status(HttpStatus.CREATED).body(hotel);
    }

    @GetMapping("/{hotelId}")
    public ResponseEntity<HotelDto> getHotelById(@PathVariable Long hotelId) {
        log.info("Fetching hotel with id: {}", hotelId);
        HotelDto hotel = hotelService.getHotelById(hotelId);
        return ResponseEntity.ok(hotel);
    }

    @PutMapping("/{hotelId}")
    public ResponseEntity<HotelDto> updateHotelById(@PathVariable Long hotelId, @RequestBody HotelDto hotelDto) {
        log.info("Updating hotel with id: {}", hotelId);
        HotelDto hotel = hotelService.updateHotelById(hotelId, hotelDto);
        return ResponseEntity.ok(hotel);
    }

    @DeleteMapping("/{hotelId}")
    public ResponseEntity<Void> deleteHotelById(@PathVariable Long hotelId) {
        log.info("Deleting hotel with id: {}", hotelId);
        hotelService.deleteHotelById(hotelId);
        return ResponseEntity.noContent().build();
    }

    @PatchMapping("/{hotelId}/activate")
    public ResponseEntity<Void> activateHotel(@PathVariable Long hotelId) {
        log.info("Activating hotel with id: {}", hotelId);
        hotelService.activateHotel(hotelId);
        return ResponseEntity.noContent().build();
    }
}
