package com.hotel_booking.web.service.impl;

import com.hotel_booking.web.model.entity.ApartNumber;
import com.hotel_booking.web.model.entity.Invoice;
import com.hotel_booking.web.model.repository.ApartNumberRepository;
import com.hotel_booking.web.model.repository.InvoiceRepository;
import com.hotel_booking.web.model.repository.ReservationRepository;
import com.hotel_booking.web.service.InvoiceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.List;

@Service
public class InvoiceServiceImpl implements InvoiceService {

    Calendar calendar = new GregorianCalendar();

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
    public List<ApartNumber> getByClass() {
        return null;
    }

    @Override
    public List<ApartNumber> getBySize() {
        return null;
    }

    @Override
    public List<Invoice> getByUserId(Integer userid) {
        return invoiceRepository.getByUserId(userid);
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
        if (reservationRepository.findById(reservationNumber).isPresent()) {
            reservationRepository.deleteById(reservationNumber);
            return true;
        }
        return false;
    }
}
