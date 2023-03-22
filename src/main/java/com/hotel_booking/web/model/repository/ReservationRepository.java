package com.hotel_booking.web.model.repository;

import com.hotel_booking.web.model.entity.Reservation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.sql.Date;
import java.util.List;
import java.util.Optional;

@Repository
public interface ReservationRepository extends JpaRepository<Reservation, Integer> {
    Reservation getReservationByCheckInDate(Date checkInDate);

    Reservation getById(Integer reservationNumber);

    Reservation getReservationsByPrefApClass(String prefApClass);

    Optional<Reservation> findById(Integer reservationNumber);

    List<Reservation> getReservationsByUserId(Integer userId);
}
