package com.hotel_booking.web.service.impl;

import com.hotel_booking.web.model.entity.Reservation;
import com.hotel_booking.web.model.repository.ReservationRepository;
import com.hotel_booking.web.service.ReservationService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Date;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.List;

@Service
@RequiredArgsConstructor
public class ReservationServiceImpl implements ReservationService {
    Calendar calendar = new GregorianCalendar();
    @Autowired
    ReservationRepository reservationRepository;

    @Override
    public List<Reservation> getAll() {
        return reservationRepository.findAll();
    }

    @Override
    public Reservation getById(Integer reservationNumber) {

        return reservationRepository.getById(reservationNumber);
    }


    @Override
    public Reservation getByCheckInDate(Date checkInDate) {
        return null;
    }

    @Override
    public boolean save(Reservation reservation) {

        Reservation verifiedReservation = reservationRepository
                .getReservationByCheckInDate(reservation.getCheckInDate());
        if (verifiedReservation != null) {
            return false;
        }
        if (reservation.getCheckInDate().before(calendar.getTime())){
            return false;
        }
        if (reservation.getCheckOutDate().before(reservation.getCheckInDate())){
            return false;
        }

        reservationRepository.save(reservation);
        return true;
    }
}
