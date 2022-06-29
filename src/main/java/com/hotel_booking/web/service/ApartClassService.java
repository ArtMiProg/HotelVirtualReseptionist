package com.hotel_booking.web.service;

import com.hotel_booking.web.model.entity.ApartClass;

import java.util.List;

public interface ApartClassService {
    List<ApartClass> getAll();

    ApartClass getById(Integer id);

    void save(ApartClass apartClass);


}
