package com.hotel_booking.web.service;

import com.hotel_booking.web.model.entity.ApartNumber;
import com.hotel_booking.web.model.entity.Invoice;

import java.sql.Date;
import java.util.List;

public interface InvoiceService {
    List<Invoice> getAll();

    List<ApartNumber> showRelevantApartments(Date checkInDate, Date checkOutDate, String apClass, Integer apSize);

    Integer selectNumber (Date checkInDate, Date checkOutDate, String apClass, Integer apSize);

    Integer countPrice(Integer number, Date checkInDate, Date checkOutDate);

    boolean setInvoice(Invoice invoice);

    boolean deleteReservation(Integer reservationNumber);

    List<Invoice> getByUserId(Integer userId);
}
