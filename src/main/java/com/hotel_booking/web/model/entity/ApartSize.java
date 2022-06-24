package com.hotel_booking.web.model.entity;

import lombok.Data;

import javax.persistence.*;
import java.util.Set;

@Data
@Entity
@Table (name = "apart_size")
public class ApartSize {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column (name = "rooms_quantity")
    private Integer roomsQuantity;
    @Column (name = "size_factor")
    private Float sizeFactor;
    @OneToMany
    private Set<ApartNumber> apartNumbers;
}
