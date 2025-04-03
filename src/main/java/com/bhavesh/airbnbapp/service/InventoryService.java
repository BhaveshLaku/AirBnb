package com.bhavesh.airbnbapp.service;

import com.bhavesh.airbnbapp.dto.HotelDto;
import com.bhavesh.airbnbapp.dto.HotelSearchRequest;
import com.bhavesh.airbnbapp.entity.Room;
import org.springframework.data.domain.Page;

public interface InventoryService{

    void initializeRoomForAYear(Room room);

    void deleteAllInventories(Room room);


    Page<HotelDto> searchHotels(HotelSearchRequest hotelSearchRequest);
}
