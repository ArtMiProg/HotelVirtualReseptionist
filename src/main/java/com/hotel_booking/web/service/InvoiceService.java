package com.hotel_booking.web.service;

import com.hotel_booking.web.model.entity.Invoice;

import java.util.List;

public interface InvoiceService {
    List<Invoice> getAll();

    boolean setInvoice(Invoice invoice);

    boolean deleteReservation(Integer reservationNumber);

    List<Invoice> getByUserId(Integer userId);
}
