package com.hotel_booking.web.service.impl;

import com.hotel_booking.web.model.entity.ApartClass;
import com.hotel_booking.web.model.entity.ApartNumber;
import com.hotel_booking.web.model.entity.ApartSize;
import com.hotel_booking.web.model.repository.ApartClassRepository;
import com.hotel_booking.web.model.repository.ApartNumberRepository;
import com.hotel_booking.web.model.repository.ApartSizeRepository;
import com.hotel_booking.web.service.ApartNumberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.awt.*;
import java.awt.image.ImageObserver;
import java.awt.image.ImageProducer;
import java.time.LocalDate;
import java.util.List;
import java.util.Set;

@Service
public class ApartNumberServiceImpl implements ApartNumberService {
    @Autowired
    ApartClassRepository apartClassRepository;
    @Autowired
    ApartNumberRepository apartNumberRepository;
    @Autowired
    ApartSizeRepository apartSizeRepository;

    @Override
    public String getApclassById(Integer apartClassId) {
        ApartClass apartClass = apartClassRepository.getById(apartClassId);
        return apartClass.getApclass();
    }

    @Override
    public Integer getRoomsQuantityById(Integer apartSizeId) {
        ApartSize apartSize = apartSizeRepository.getById(apartSizeId);
        return apartSize.getRoomsQuantity();
    }

    @Override
    public List<ApartNumber> getAll() {
        return apartNumberRepository.findAll();
    }

    @Override
    public boolean resetBasicPay(Float basicPay){
        List<ApartNumber> apartNumbers = apartNumberRepository.findAll();
        for (ApartNumber apNum : apartNumbers) {
            apNum.setBasicPay(basicPay);
            apartNumberRepository.save(apNum);
        }
        return true;
    }

    @Override
    public boolean showDiurnalCost(Float basicPay){
        List<ApartNumber> apartNumbers = apartNumberRepository.findAll();
        for (ApartNumber apartNumber : apartNumbers) {
            ApartClass apartClass = apartClassRepository.getById(apartNumber.getApartClassId());
            ApartSize apartSize = apartSizeRepository.getById(apartNumber.getApartSizeId());
            Float cost = apartNumber.getBasicPay()*apartClass.getClassFactor()*apartSize.getSizeFactor();
            apartNumber.setCost(cost);
            apartNumberRepository.save(apartNumber);
        }
        return true;
    }


    @Override
    public ApartNumber getById(Integer id) {
        ApartNumber apartNumber = apartNumberRepository.getById(id);
        return apartNumber;
    }

    @Override
    public ApartNumber getByNumber(Integer number){
        ApartNumber apartNumber = apartNumberRepository.getApartNumberByNumber(number);
        return apartNumber;
    }

    @Override
    public boolean designApartment(ApartNumber apartNumber){
        Set<LocalDate> defaultDates = Set.of(LocalDate.now().minusDays(1));
        apartNumber.setDatesWhenOccupied(defaultDates);
        List<ApartNumber> apartNumbers = apartNumberRepository.findAll();
        if(!apartNumbers.isEmpty()){
            ApartNumber tempNumb = apartNumbers.get(apartNumbers.size()-1);
            apartNumber.setNumber(tempNumb.getNumber()+1);
            Float basicPay = tempNumb.getBasicPay();
            ApartClass apartClass = apartClassRepository.getById(apartNumber.getApartClassId());
            ApartSize apartSize = apartSizeRepository.getById(apartNumber.getApartSizeId());
            Float cost = basicPay*apartClass.getClassFactor()*apartSize.getSizeFactor();
            apartNumber.setBasicPay(basicPay);
            apartNumber.setCost(cost);
        } else {
            apartNumber.setNumber(1);
        }
        apartNumberRepository.save(apartNumber);
        return true;
    }

    @Override
    public boolean deleteApartNumber(Integer id) {
        apartNumberRepository.deleteById(id);
        return true;
    }

    @Override
    public boolean changeApartNumber(ApartNumber apartNumber){
        ApartNumber tempNumb = apartNumberRepository.getById(1);
        Float basicPay = tempNumb.getBasicPay();
        ApartClass apartClass = apartClassRepository.getById(apartNumber.getApartClassId());
        ApartSize apartSize = apartSizeRepository.getById(apartNumber.getApartSizeId());
        Float cost = basicPay*apartClass.getClassFactor()*apartSize.getSizeFactor();
        apartNumber.setBasicPay(basicPay);
        apartNumber.setCost(cost);
        apartNumberRepository.save(apartNumber);
        return  true;
    }

}
