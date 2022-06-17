package com.hotel_booking.web.model.entity;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table
public class Price {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column (name = "reservation_number")
    private Integer reservationNumber;
    @Column
    private Integer price;
}
