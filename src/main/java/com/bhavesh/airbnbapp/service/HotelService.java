package com.bhavesh.airbnbapp.service;

import com.bhavesh.airbnbapp.dto.HotelDto;
import com.bhavesh.airbnbapp.dto.HotelInfoDto;
import com.bhavesh.airbnbapp.entity.Hotel;

public interface HotelService {

    HotelDto createNewHotel(HotelDto hotelDto);

    HotelDto getHotelById(Long id);

    HotelDto updateHotelById(Long id, HotelDto hotelDto);

    void deleteHotelById(Long id);

    void activateHotel(Long hotelId);


    HotelInfoDto getHotelInfoById(Long hotelId);
}
