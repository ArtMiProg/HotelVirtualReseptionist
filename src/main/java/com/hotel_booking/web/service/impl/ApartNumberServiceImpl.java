package com.hotel_booking.web.service.impl;

import com.hotel_booking.web.model.entity.ApartClass;
import com.hotel_booking.web.model.repository.ApartClassRepository;
import com.hotel_booking.web.service.ApartNumberService;
import org.springframework.beans.factory.annotation.Autowired;

public class ApartNumberServiceImpl implements ApartNumberService {
    @Autowired
    ApartClassRepository apartClassRepository;
    
    @Override
    public String getApclassById(Integer apartClassId) {
       ApartClass apartClass = apartClassRepository.getById(apartClassId);
       return apartClass.getApclass();
    }
}
