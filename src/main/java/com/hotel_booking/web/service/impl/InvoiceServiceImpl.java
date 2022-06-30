package com.hotel_booking.web.service.impl;

import com.hotel_booking.web.model.entity.Invoice;
import com.hotel_booking.web.model.repository.ApartNumberRepository;
import com.hotel_booking.web.model.repository.InvoiceRepository;
import com.hotel_booking.web.model.repository.ReservationRepository;
import com.hotel_booking.web.service.InvoiceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class InvoiceServiceImpl implements InvoiceService {

    @Autowired
    InvoiceRepository invoiceRepository;
    @Autowired
    ReservationRepository reservationRepository;
    @Autowired
    ApartNumberRepository apartNumberRepository;

    @Override
    public List<Invoice> getAll() {
        return invoiceRepository.findAll();
    }

    @Override
    public List<Invoice> getByUserId(Integer userId) {
        return invoiceRepository.getByUserId(userId);
    }

    @Override
    public boolean setInvoice(Invoice invoice) {
        reservationRepository.getReservationByCheckInDate(invoice.getCheckInDate()).setIsConfirmed(true);
        apartNumberRepository.getApartNumberByNumber(invoice.getNumber()).setIsOccupied(true);
        invoiceRepository.save(invoice);
        return true;
    }

    @Override
    public boolean deleteReservation(Integer reservationNumber) {
        Invoice invoice = invoiceRepository.getById(reservationNumber);
        if (reservationRepository.findById(reservationNumber).isPresent()) {
            apartNumberRepository.getApartNumberByNumber(invoice.getNumber()).setIsOccupied(false);
            reservationRepository.deleteById(reservationNumber);
            return true;
        }
        return false;
    }
}
