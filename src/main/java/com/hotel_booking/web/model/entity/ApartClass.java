package com.hotel_booking.web.model.entity;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity

public class ApartClass {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column
    private String apclass;
    @Column (name = "class_factor")
    private float classFactor;
}
