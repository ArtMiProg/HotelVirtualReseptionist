package com.hotel_booking.web.model.entity;

import lombok.Data;
import org.hibernate.annotations.Type;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.sql.Date;
import java.time.LocalDate;
import java.util.Set;
import java.util.stream.Collectors;

@Data
@Entity
@Table(name = "invoice")
public class Invoice {
    @Id
    private Integer id;
    @Column(name = "user_id")
    private Integer userId;
    @Column(name = "apart_number")
    private Integer number;
    @Column(name = "price")
    private Integer price;
    @Column(name = "check_in_date")
    private Date checkInDate;
    @Column(name = "check_out_date")
    private Date checkOutDate;

    @Column(name = "days_of_residence")
    @Type(type = "com.vladmihalcea.hibernate.type.json.JsonType")
    private Set<LocalDate> daysOfResidence;

    public Invoice() {

    }

    public Invoice(Integer id, Integer userId, Integer number, Integer price, Date checkInDate, Date checkOutDate) {
        this.id = id;
        this.userId = userId;
        this.number = number;
        this.price = price;
        this.checkInDate = checkInDate;
        this.checkOutDate = checkOutDate;
    }
}
