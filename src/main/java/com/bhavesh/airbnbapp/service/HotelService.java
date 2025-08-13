package com.bhavesh.airbnbapp.service;

import com.bhavesh.airbnbapp.dto.HotelDto;
import com.bhavesh.airbnbapp.dto.HotelInfoDto;
import com.bhavesh.airbnbapp.dto.HotelInfoRequestDto;

import java.util.List;

public interface HotelService {
    HotelDto createNewHotel(HotelDto hotelDto);

    HotelDto getHotelById(Long id);

    HotelDto updateHotelById(Long id, HotelDto hotelDto);

    void deleteHotelById(Long id);

    void activateHotel(Long hotelId);

    HotelInfoDto getHotelInfoById(Long hotelId, HotelInfoRequestDto hotelInfoRequestDto);

    List<HotelDto> getAllHotels();
}
