package com.hotel_booking.web.model.entity;

import lombok.Data;

import javax.persistence.*;
import java.sql.Date;

@Data
@Entity
@Table
public class Reservation {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "reservation_number")
    private Integer reservationNumber;
    @Column(name = "passport_data")
    private String passportData;
    @Column(name = "user_id")
    private Integer userId;
    @Column(name = "check_in_date")
    private Date checkInDate;
    @Column(name = "check_out_date")
    private Date checkOutDate;
    @Column(name = "preferred_ap_class")
    private String prefApClass;
    @Column(name = "preferred_ap_size")
    private Integer prefApSize;
    @Column(name = "state")
    private Boolean isConfirmed = false;

    public Reservation() {

    }

    public Reservation(Integer userId) {
        this.userId = userId;
    }

}
