package com.hotel_booking.web.service;

import com.hotel_booking.web.model.entity.ApartNumber;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

public interface ApartNumberService {

    String getApclassById(Integer apartClassId);

    Integer getRoomsQuantityById(Integer apartSizeId);

    List<ApartNumber> getAll();

    boolean resetBasicPay(Float basicPay);

    boolean showDiurnalCost(Float basicPay);

    ApartNumber getById(Integer id);

    ApartNumber getByNumber(Integer number);

    boolean designApartment(ApartNumber apartNumber);

    boolean deleteApartNumber(Integer id);

    boolean changeApartNumber(ApartNumber apartNumber);
}
