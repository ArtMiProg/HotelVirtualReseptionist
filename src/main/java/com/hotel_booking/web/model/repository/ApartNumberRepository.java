package com.hotel_booking.web.model.repository;

import com.hotel_booking.web.model.entity.ApartClass;
import com.hotel_booking.web.model.entity.ApartNumber;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ApartNumberRepository extends JpaRepository<ApartNumber, Integer> {

    ApartNumber getApartNumberByNumber(Integer number);

    List<ApartNumber> getByApartClassId(Integer apartClassId);

    List<ApartNumber> getByApartSizeId (Integer apartSizeId);

    @Query("from ApartNumber apartNumber where apartNumber.number = :number")
    List<ApartNumber> getAllApartNumbers(@Param("number") Integer numberApartNumber);
}
