package com.bhavesh.airbnbapp.repository;

import com.bhavesh.airbnbapp.entity.Guest;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GuestRepository extends JpaRepository<Guest, Long> {
}