package com.bhavesh.airbnbapp.service;

import com.bhavesh.airbnbapp.entity.Room;

public interface InventoryService{

    void initializeRoomForAYear(Room room);

    void deleteFutureInventories(Room room);


}
