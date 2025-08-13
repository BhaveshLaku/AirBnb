package com.bhavesh.airbnbapp.repository;

import com.bhavesh.airbnbapp.entity.Hotel;
import com.bhavesh.airbnbapp.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface HotelRepository extends JpaRepository<Hotel, Long> {
    List<Hotel> findByOwner(User user);
}
