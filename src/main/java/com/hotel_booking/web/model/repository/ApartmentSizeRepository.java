package com.hotel_booking.web.model.repository;

import com.hotel_booking.web.model.entity.ApartmentSize;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ApartmentSizeRepository extends JpaRepository<ApartmentSize, Integer> {
}
