package com.hotel_booking.web.model.entity;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "apart_number")
public class ApartNumber {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column (name = "apart_number")
    private Integer number;
    @Column (name = "apart_class_id")
    private Integer apartClassId;
    @Column (name = "apart_size_id")
    private Integer apartSizeId;
    @Column (name = "basic_pay")
    private Float basicPay;
    @Column (name = "cost")
    private Float cost;
    @Column (name = "occupied")
    public Boolean isOccupied;







}
