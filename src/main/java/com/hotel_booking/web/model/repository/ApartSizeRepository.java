package com.hotel_booking.web.model.repository;

import com.hotel_booking.web.model.entity.ApartClass;
import com.hotel_booking.web.model.entity.ApartSize;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ApartSizeRepository extends JpaRepository<ApartSize, Integer> {

    List<ApartSize> getApartSizeByRoomsQuantity(Integer roomsQuantity);

    /* This interface will be used in near future */
}
