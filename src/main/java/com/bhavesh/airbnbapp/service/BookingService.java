package com.bhavesh.airbnbapp.service;

import com.bhavesh.airbnbapp.dto.BookingDto;
import com.bhavesh.airbnbapp.dto.BookingRequest;
import com.bhavesh.airbnbapp.dto.GuestDto;

import java.util.List;

public interface BookingService {

    BookingDto initialiseBooking(BookingRequest bookingRequest);

    BookingDto addGuests(Long bookingId, List<GuestDto> guestDtoList);
}
