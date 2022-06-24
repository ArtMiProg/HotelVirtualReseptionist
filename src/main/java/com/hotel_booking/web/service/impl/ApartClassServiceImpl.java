package com.hotel_booking.web.service.impl;

import com.hotel_booking.web.model.entity.ApartClass;
import com.hotel_booking.web.model.repository.ApartClassRepository;
import com.hotel_booking.web.service.ApartClassService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ApartClassServiceImpl implements ApartClassService {
    private final ApartClassRepository apartClassRepository;


    @Override
    public List<ApartClass> getAll() {
        return  apartClassRepository.findAll();
    }

    @Override
    public ApartClass getById(Integer id) {
        return apartClassRepository.getById(id);
    }

    @Override
    public void save(ApartClass apartClass) {
        apartClassRepository.save(apartClass);
    }
}
