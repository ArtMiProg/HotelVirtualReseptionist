package com.hotel_booking.web.model.repository;

import com.hotel_booking.web.model.entity.Price;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PriceRepository extends JpaRepository<Price, Integer> {

    /* This interface will be used in near future */
}
