package com.hotel_booking.web.service;

import com.hotel_booking.web.model.entity.Reservation;
import com.hotel_booking.web.model.repository.ReservationRepository;
import com.hotel_booking.web.service.impl.ReservationServiceImpl;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.MockitoJUnitRunner;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

@RunWith(MockitoJUnitRunner.class)
public class ReservationServiceTest {

    @InjectMocks
    private ReservationServiceImpl reservationServiceImpl;

    @Mock
    private ReservationRepository reservationRepository;

    @Before
    public void init() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void TestGetAll() {
        Reservation myRes = new Reservation();
        Reservation yourRes = new Reservation();
        List<Reservation> reservationList = new ArrayList<>();
        reservationList.add(myRes);
        reservationList.add(yourRes);
        when(reservationRepository.findAll()).thenReturn(reservationList);
        List<Reservation> realReservations = reservationServiceImpl.getAll();
        verify(reservationRepository).findAll();
        assertEquals(reservationList, realReservations);
    }

    @Test
    public void testGetById() {
        Reservation res = new Reservation();
        res.setReservationNumber(1015);
        when(reservationRepository.getById(1015)).thenReturn(res);
        Reservation reservation = reservationServiceImpl.getById(1015);
        verify(reservationRepository).getById(1015);
        assertEquals(1015, reservation.getReservationNumber());
    }

    @Test
    public void TestGetReservationByUserId(){
        Reservation myRes = new Reservation();
        myRes.setUserId(5);
        Reservation yourRes = new Reservation();
        yourRes.setUserId(5);
        List<Reservation> reservationList = new ArrayList<>();
        reservationList.add(myRes);
        reservationList.add(yourRes);
        when(reservationRepository.getReservationsByUserId(5)).thenReturn(reservationList);
        List<Reservation> realReservations = reservationServiceImpl.getReservationsByUserId(5);
        verify(reservationRepository).getReservationsByUserId(5);
        assertEquals(reservationList, realReservations);
    }

    @Test
    public void testGetByCheckInDate() {
        Date date = new Date(2022,8,1);
        Reservation res = new Reservation();
        res.setCheckInDate (date);
        when(reservationRepository.getReservationByCheckInDate(date)).thenReturn(res);
        Reservation reservation = reservationServiceImpl.getByCheckInDate(date);
        verify(reservationRepository).getReservationByCheckInDate(date);
        assertEquals(date, reservation.getCheckInDate());
    }

    @Test
    public void testSave(){
        Reservation resToBeSaved = new Reservation();
        Date inDate = new Date(2022,8,1);
        Date outDate = new Date(2022,8,3);
        resToBeSaved.setCheckInDate(inDate);
        resToBeSaved.setCheckOutDate(outDate);
        Reservation resVerified = reservationRepository.getReservationByCheckInDate(inDate);
        reservationServiceImpl.save(resToBeSaved);
        verify(reservationRepository, times (1)).save(any(Reservation.class));
    }
}
