package com.hotel_booking.web.service;

import com.hotel_booking.web.model.entity.Reservation;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;

import java.sql.Date;
import java.util.List;

public interface ReservationService {
    List<Reservation> getAll();
    Reservation getById(Integer id);
    Reservation getByCheckInDate (Date checkInDate);
    boolean save(Reservation reservation);
}
