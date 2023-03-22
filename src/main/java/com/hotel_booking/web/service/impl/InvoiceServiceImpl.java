package com.hotel_booking.web.service.impl;

import com.hotel_booking.web.model.entity.ApartClass;
import com.hotel_booking.web.model.entity.ApartNumber;
import com.hotel_booking.web.model.entity.ApartSize;
import com.hotel_booking.web.model.entity.Invoice;
import com.hotel_booking.web.model.repository.*;
import com.hotel_booking.web.service.InvoiceService;
import org.apache.tomcat.jni.Local;
import org.joda.time.Days;
import org.joda.time.PeriodType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Date;
import java.time.LocalDate;
import java.time.Period;
import java.time.chrono.ChronoPeriod;
import java.util.*;
import java.util.stream.Collectors;

@Service
public class InvoiceServiceImpl implements InvoiceService {

    @Autowired
    InvoiceRepository invoiceRepository;
    @Autowired
    ReservationRepository reservationRepository;
    @Autowired
    ApartNumberRepository apartNumberRepository;
    @Autowired
    ApartClassRepository apartClassRepository;
    @Autowired
    ApartSizeRepository apartSizeRepository;


    @Override
    public List<Invoice> getAll() {
        return invoiceRepository.findAll();
    }

    @Override
    public List<Invoice> getByUserId(Integer userId) {
        return invoiceRepository.getByUserId(userId);
    }

    @Override
    public List<ApartNumber> showRelevantApartments(Date checkInDate, Date checkOutDate, String apClass, Integer apSize) {
        Set <LocalDate> wishedDays = checkInDate.toLocalDate()
                .datesUntil(checkOutDate.toLocalDate().plusDays(1))
                .collect(Collectors.toSet());
        List<ApartNumber> freeNumbers = new ArrayList<>();
        List<ApartNumber> allNumbers = apartNumberRepository.findAll();
        for (ApartNumber checkedNumber : allNumbers) {
            if (Collections.disjoint(checkedNumber.getDatesWhenOccupied(), wishedDays) == true){
                freeNumbers.add(checkedNumber);
            }
        }
        List<ApartNumber> relevantNumbers = new ArrayList<>();
        List<ApartClass> apartClasses = apartClassRepository.getApartClassByApclass(apClass);
        List<ApartSize> apartSizes = apartSizeRepository.getApartSizeByRoomsQuantity(apSize);
        ApartClass apartClass = apartClasses.get(0);
        ApartSize apartSize = apartSizes.get(0);
        for (ApartNumber tempNum : freeNumbers) {
            if (tempNum.getApartClassId().equals(apartClass.getId())){
                if (tempNum.getApartSizeId().equals(apartSize.getId())) {
                    relevantNumbers.add(tempNum);
                }
            }
        }
        if(relevantNumbers.isEmpty()) {
            apartSizes = apartSizeRepository.getApartSizeByRoomsQuantity(apSize + 1);
            if (!apartSizes.isEmpty()) {
                apartSize = apartSizes.get(0);
                for (ApartNumber tempNum : freeNumbers) {
                    if (tempNum.getApartClassId().equals(apartClass.getId())) {
                        if (tempNum.getApartSizeId().equals(apartSize.getId())) {
                            relevantNumbers.add(tempNum);
                        }
                    }
                }
                if (relevantNumbers.isEmpty()) {
                    ApartClass higherApartClass = apartClassRepository.getById((apartClass.getId() + 1));
                    for (ApartNumber tempNum : freeNumbers) {
                        if (tempNum.getApartClassId().equals(higherApartClass.getId())) {
                            if (tempNum.getApartSizeId().equals(apartSize.getId())) {
                                relevantNumbers.add(tempNum);
                            }
                        }
                    }
                }
            }
        }
        return relevantNumbers;
    }

    @Override
    public Integer selectNumber(Date checkInDate, Date checkOutDate, String apClass, Integer apSize) {
        Set <LocalDate> wishedDays = checkInDate.toLocalDate()
                .datesUntil(checkOutDate.toLocalDate().plusDays(1))
                .collect(Collectors.toSet());
        List<ApartNumber> freeNumbers = new ArrayList<>();
        List<ApartNumber> allNumbers = apartNumberRepository.findAll();
        for (ApartNumber checkedNumber : allNumbers) {
            if (Collections.disjoint(checkedNumber.getDatesWhenOccupied(), wishedDays) == true){
                freeNumbers.add(checkedNumber);
            }
        }
        List<ApartNumber> relevantNumbers = new ArrayList<>();
        List<ApartClass> apartClasses = apartClassRepository.getApartClassByApclass(apClass);
        List<ApartSize> apartSizes = apartSizeRepository.getApartSizeByRoomsQuantity(apSize);
        ApartClass apartClass = apartClasses.get(0);
        ApartSize apartSize = apartSizes.get(0);
        for (ApartNumber tempNum : freeNumbers) {
            if (tempNum.getApartClassId().equals(apartClass.getId())) {
                if (tempNum.getApartSizeId().equals(apartSize.getId())) {
                    relevantNumbers.add(tempNum);
                }
            }
        }
        Integer number;
        if (!relevantNumbers.isEmpty()) {
            ApartNumber apartNumber = relevantNumbers.get(0);
            number = apartNumber.getNumber();
        } else {
            apartSizes = apartSizeRepository.getApartSizeByRoomsQuantity(apSize + 1);
            if(!apartSizes.isEmpty()){
                apartSize = apartSizes.get(0);
                for (ApartNumber tempNum : freeNumbers) {
                    if (tempNum.getApartClassId().equals(apartClass.getId())) {
                        if (tempNum.getApartSizeId().equals(apartSize.getId())) {
                            relevantNumbers.add(tempNum);
                        }
                    }
                }
                if (!relevantNumbers.isEmpty()) {
                    ApartNumber apartNumber = relevantNumbers.get(0);
                    number = apartNumber.getNumber();
                } else {
                ApartClass higherApartClass = apartClassRepository.getById((apartClass.getId() + 1));
                for (ApartNumber tempNum : freeNumbers) {
                    if (tempNum.getApartClassId().equals(higherApartClass.getId())) {
                        if (tempNum.getApartSizeId().equals(apartSize.getId())) {
                            relevantNumbers.add(tempNum);
                        }
                    }
                }
                if (!relevantNumbers.isEmpty()) {
                    ApartNumber apartNumber = relevantNumbers.get(0);
                    number = apartNumber.getNumber();
                } else {
                    number = null;
                }
            }
            } else {
                Integer apClassId = (apartClass.getId() + 1);
                if(apClassId < 3) {
                    ApartClass higherApartClass = apartClassRepository.getById(apClassId);
                    for (ApartNumber tempNum : freeNumbers) {
                        if (tempNum.getApartClassId().equals(higherApartClass.getId())) {
                            if (tempNum.getApartSizeId().equals(apartSize.getId())) {
                                relevantNumbers.add(tempNum);
                            }
                        }
                    }
                    if (!relevantNumbers.isEmpty()) {
                        ApartNumber apartNumber = relevantNumbers.get(0);
                        number = apartNumber.getNumber();
                    } else {
                        number = null;
                    }
                } else {
                    number = null;
                }
            }
        }
        return number;
    }

    @Override
    public Integer countPrice(Integer number, Date checkInDate, Date checkOutDate){
        ApartNumber apartNumber = apartNumberRepository.getApartNumberByNumber(number);
        Float numberDiurnalCost = apartNumber.getCost();
        Integer numberIntDiurnalCost = numberDiurnalCost.intValue();
        Set <LocalDate> wishedDays = checkInDate.toLocalDate()
                .datesUntil(checkOutDate.toLocalDate().plusDays(1))
                .collect(Collectors.toSet());
        Integer residenceDuration = wishedDays.size();
        Integer price = numberIntDiurnalCost*residenceDuration;
        return price;
    }

    @Override
    public boolean setInvoice(Invoice invoice) {
        reservationRepository.getById(invoice.getId()).setIsConfirmed(true);
        ApartNumber givenApartNumber = apartNumberRepository.getApartNumberByNumber(invoice.getNumber());
        Set <LocalDate> daysOfResidence = invoice.getCheckInDate().toLocalDate()
                .datesUntil(invoice.getCheckOutDate().toLocalDate().plusDays(1))
                .collect(Collectors.toSet());
        invoice.setDaysOfResidence(daysOfResidence);
        givenApartNumber.getDatesWhenOccupied().addAll(daysOfResidence);
        invoiceRepository.save(invoice);
        return true;
    }

    @Override
    public boolean deleteReservation(Integer reservationNumber) {
        if (invoiceRepository.findById(reservationNumber).isPresent()) {
            if (reservationRepository.findById(reservationNumber).isPresent()) {
                reservationRepository.deleteById(reservationNumber);
                return true;
            }
        }else{
            reservationRepository.deleteById(reservationNumber);
            return true;
        }
        return false;
    }
}
