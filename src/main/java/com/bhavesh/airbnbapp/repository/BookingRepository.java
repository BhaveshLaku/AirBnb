package com.bhavesh.airbnbapp.repository;

import com.bhavesh.airbnbapp.entity.Booking;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookingRepository extends JpaRepository<Booking, Long> {

}
