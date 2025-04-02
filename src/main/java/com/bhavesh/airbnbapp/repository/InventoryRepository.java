package com.bhavesh.airbnbapp.repository;

import com.bhavesh.airbnbapp.entity.Inventory;
import com.bhavesh.airbnbapp.entity.Room;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDate;

public interface InventoryRepository extends JpaRepository<Inventory, Long> {

    void deleteByRoom(Room room);
}
