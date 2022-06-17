package com.hotel_booking.web.model.entity;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "apart_number")
public class ApartmentNumber {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column (name = "apart_number")
    private int apartNumber;
    @Column (name = "apart_class_id")
    private Integer apartClassId;
    @Column (name = "apart_size_id")
    private Integer apartSizeId;
    @Column (name = "basic_pay")
    private Integer basicPay;
    @Column
    private Integer cost;
}
