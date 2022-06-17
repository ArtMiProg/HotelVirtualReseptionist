package com.hotel_booking.web.model.entity;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table (name = "apart_size")
public class ApartmentSize {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column (name = "rooms_quantity")
    private String roomsQuantity;
    @Column (name = "size_factor")
    private float sizeFactor;
}
