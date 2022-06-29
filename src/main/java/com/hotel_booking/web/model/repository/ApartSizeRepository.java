package com.hotel_booking.web.model.repository;

import com.hotel_booking.web.model.entity.ApartSize;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ApartSizeRepository extends JpaRepository<ApartSize, Integer> {

    /* This interface will be used in near future */
}
