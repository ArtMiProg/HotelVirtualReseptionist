package com.hotel_booking.web.service;

import com.hotel_booking.web.model.entity.ApartNumber;
import com.hotel_booking.web.model.entity.Invoice;
import com.hotel_booking.web.model.entity.Reservation;
import com.hotel_booking.web.model.repository.ApartNumberRepository;
import com.hotel_booking.web.model.repository.InvoiceRepository;
import com.hotel_booking.web.model.repository.ReservationRepository;
import com.hotel_booking.web.service.impl.InvoiceServiceImpl;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.MockitoJUnitRunner;

import java.sql.Date;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import static org.junit.Assert.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

@RunWith(MockitoJUnitRunner.class)
public class InvoiceServiceTest {

    @InjectMocks
    private InvoiceServiceImpl invoiceServiceImpl;

    @Mock
    private InvoiceRepository invoiceRepository;

    @Mock
    private ReservationRepository reservationRepository;

    @Mock
    private ApartNumberRepository apartNumberRepository;

    @Before
    public void init() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void testGetAll() {
        Invoice expensive = new Invoice();
        Invoice cheap = new Invoice();
        List<Invoice> invoiceList = new ArrayList<>();
        invoiceList.add(expensive);
        invoiceList.add(cheap);
        when(invoiceRepository.findAll()).thenReturn(invoiceList);
        List<Invoice> realInvoices = invoiceServiceImpl.getAll();
        verify(invoiceRepository).findAll();
        assertEquals(invoiceList, realInvoices);
    }

    @Test
    public void testGetByUserId() {
        Invoice discount = new Invoice();
        discount.setUserId(5);
        Invoice rebate = new Invoice();
        rebate.setUserId(5);
        List<Invoice> invoiceList = new ArrayList<>();
        invoiceList.add(discount);
        invoiceList.add(rebate);
        when(invoiceRepository.getByUserId(5)).thenReturn(invoiceList);
        List<Invoice> realReservations = invoiceServiceImpl.getByUserId(5);
        verify(invoiceRepository).getByUserId(5);
        assertEquals(invoiceList, realReservations);
    }

    @Test
    public void testSetInvoice() {
        Invoice discount = new Invoice();
        Integer id = 1001;
        discount.setId(id);
        discount.setNumber(7);
        discount.setCheckInDate(Date.valueOf(LocalDate.now()));
        discount.setCheckOutDate(Date.valueOf(LocalDate.now().plusDays(1)));
        Reservation res = new Reservation();
        res.setReservationNumber(discount.getId());
        res.setIsConfirmed(true);
        ApartNumber luxury = new ApartNumber();
        luxury.setNumber(7);
        Set<LocalDate> defaultDates = LocalDate.now().minusDays(1).datesUntil(LocalDate.now().plusDays(1))
                .collect(Collectors.toSet());
        luxury.setDatesWhenOccupied(defaultDates);
        when(reservationRepository.getById(discount.getId())).thenReturn(res);
        when(apartNumberRepository.getApartNumberByNumber(luxury.getNumber())).thenReturn(luxury);
        invoiceServiceImpl.setInvoice(discount);
        verify(invoiceRepository, times(1)).save(any(Invoice.class));
    }

    @Test
    public void testDeleteReservation() {
        Reservation toBeDeleted = new Reservation();
        toBeDeleted.setReservationNumber(2222);
        if (reservationRepository.findById(toBeDeleted.getReservationNumber()).isPresent()) {
            reservationRepository.deleteById(toBeDeleted.getReservationNumber());
        }
        verify(reservationRepository, times(1)).findById(2222);
    }
}
