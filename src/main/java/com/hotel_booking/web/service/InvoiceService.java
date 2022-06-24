package com.hotel_booking.web.service;

import com.hotel_booking.web.model.entity.ApartNumber;
import com.hotel_booking.web.model.entity.Invoice;
import com.hotel_booking.web.model.entity.Reservation;

import java.util.List;
import java.util.Optional;

public interface InvoiceService {
    List <Invoice> getAll();
    List<ApartNumber> getByClass();
    List<ApartNumber> getBySize();

    boolean setInvoice (Invoice invoice);
    boolean deleteReservation (Integer reservationNumber);
}
