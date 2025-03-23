package com.bhavesh.airbnbapp.repository;

import com.bhavesh.airbnbapp.entity.Room;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface RoomRepository extends JpaRepository<Room, Long> {

    Optional<Room> findByIdAndHotelId(Long roomId, Long hotelId);
}
