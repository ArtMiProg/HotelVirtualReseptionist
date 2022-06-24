package com.hotel_booking.web.model.entity;

import lombok.Data;

import javax.persistence.*;
import java.util.Set;

@Data
@Entity
@Table (name = "apart_class")
public class ApartClass {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column (name = "apart_class")
    private String apclass;
    @Column (name = "class_factor")
    private Float classFactor;
    @OneToMany
    private Set<ApartNumber> apartNumbers;
}
