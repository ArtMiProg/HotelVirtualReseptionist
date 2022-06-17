package com.hotel_booking.web.model.repository;

import com.hotel_booking.web.model.entity.Reservation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.sql.Date;

@Repository
public interface ReservationRepository extends JpaRepository<Reservation, Integer> {
    Reservation getReservationByCheckInDate (Date checkInDate);
}