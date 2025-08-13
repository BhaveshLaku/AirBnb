package com.bhavesh.airbnbapp.service;

import com.bhavesh.airbnbapp.dto.HotelPriceResponseDto;
import com.bhavesh.airbnbapp.dto.HotelSearchRequest;
import com.bhavesh.airbnbapp.dto.InventoryDto;
import com.bhavesh.airbnbapp.dto.UpdateInventoryRequestDto;
import com.bhavesh.airbnbapp.entity.Room;
import org.springframework.data.domain.Page;

import java.util.List;

public interface InventoryService {

    void initializeRoomForAYear(Room room);

    void deleteAllInventories(Room room);

    Page<HotelPriceResponseDto> searchHotels(HotelSearchRequest hotelSearchRequest);

    List<InventoryDto> getAllInventoryByRoom(Long roomId);

    void updateInventory(Long roomId, UpdateInventoryRequestDto updateInventoryRequestDto);
}
