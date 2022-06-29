package com.hotel_booking.web.model.entity;

import lombok.Data;

import javax.persistence.*;
import java.sql.Date;

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

    public Invoice() {

    }

    public Invoice(Integer id, Integer userId, Date checkInDate, Date checkOutDate) {
        this.id = id;
        this.userId = userId;
        this.checkInDate = checkInDate;
        this.checkOutDate = checkOutDate;
    }
}
