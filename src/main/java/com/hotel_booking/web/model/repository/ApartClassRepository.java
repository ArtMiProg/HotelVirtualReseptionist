package com.hotel_booking.web.model.repository;

import com.hotel_booking.web.model.entity.ApartClass;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ApartClassRepository extends JpaRepository<ApartClass, Integer> {
    ApartClass getById (Integer id);

    List<ApartClass> getApartClassByApclass(String apclass);

    @Query("from ApartClass apcl where apcl.apclass = :apclass")
    List<ApartClass> getAllApartClasses(@Param("apclass") String apclassApartClass);


}
