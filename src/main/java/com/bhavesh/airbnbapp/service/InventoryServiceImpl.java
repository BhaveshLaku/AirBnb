package com.bhavesh.airbnbapp.service;

import com.bhavesh.airbnbapp.dto.HotelPriceDto;
import com.bhavesh.airbnbapp.dto.HotelSearchRequest;
import com.bhavesh.airbnbapp.entity.Inventory;
import com.bhavesh.airbnbapp.entity.Room;
import com.bhavesh.airbnbapp.repository.HotelMinPriceRepository;
import com.bhavesh.airbnbapp.repository.InventoryRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

@Service
@RequiredArgsConstructor
@Slf4j
public class InventoryServiceImpl implements InventoryService {

    private final InventoryRepository inventoryRepository;
    private final ModelMapper modelMapper;
    private final HotelMinPriceRepository hotelMinPriceRepository;

    @Override
    public void initializeRoomForAYear(Room room) {
        LocalDate today = LocalDate.now();
        LocalDate endDate = today.plusYears(1);

        log.info("Initializing inventory for room ID {} of hotel '{}' from {} to {}",
                room.getId(), room.getHotel().getName(), today, endDate);

        int count = 0;
        for (; !today.isAfter(endDate); today = today.plusDays(1)) {
            Inventory inventory = Inventory.builder()
                    .hotel(room.getHotel())
                    .room(room)
                    .bookedCount(0)
                    .reservedCount(0)
                    .city(room.getHotel().getCity())
                    .date(today)
                    .price(room.getBasePrice())
                    .surgeFactor(BigDecimal.ONE)
                    .totalCount(room.getTotalCount())
                    .closed(false)
                    .build();
            inventoryRepository.save(inventory);
            count++;
        }

        log.info("Initialized {} inventory records for room ID {}", count, room.getId());
    }

    @Override
    public void deleteAllInventories(Room room) {
        log.info("Deleting all inventory records for room ID {} of hotel '{}'",
                room.getId(), room.getHotel().getName());

        inventoryRepository.deleteByRoom(room);

        log.info("All inventory records deleted for room ID {}", room.getId());
    }

    @Override
    public Page<HotelPriceDto> searchHotels(HotelSearchRequest hotelSearchRequest) {
        log.info("Searching for hotels in city '{}' from {} to {} with at least {} room(s)",
                hotelSearchRequest.getCity(),
                hotelSearchRequest.getStartDate(),
                hotelSearchRequest.getEndDate(),
                hotelSearchRequest.getRoomsCount());

        Pageable pageable = PageRequest.of(hotelSearchRequest.getPage(), hotelSearchRequest.getSize());

        long dateCount = ChronoUnit.DAYS.between(hotelSearchRequest.getStartDate(), hotelSearchRequest.getEndDate()) + 1;

        // bussiness logic - 90 days
        Page<HotelPriceDto> hotelPage = hotelMinPriceRepository.findHotelsWithAvailableInventory(
                hotelSearchRequest.getCity(),
                hotelSearchRequest.getStartDate(),
                hotelSearchRequest.getEndDate(),
                hotelSearchRequest.getRoomsCount(),
                dateCount,
                pageable);

        log.info("Found {} hotels matching criteria", hotelPage.getTotalElements());

        return hotelPage;
    }
}
