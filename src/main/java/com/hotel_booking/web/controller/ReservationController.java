package com.hotel_booking.web.controller;

import com.hotel_booking.web.model.entity.Reservation;
import com.hotel_booking.web.service.impl.ReservationServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
@RequiredArgsConstructor
public class ReservationController {
    @Autowired
    private ReservationServiceImpl reservationServiceImpl;

    @GetMapping("/apartChoosing")
    public String apartmentNumber (Model model){
        model.addAttribute("apartChoosingForm");
        return "apartChoosing";
    }

    @GetMapping("/reservation")
    public String reservation(Model model) {
        model.addAttribute("reservationForm", new Reservation());
        return "reservation";
    }

    @PostMapping("/reservation")
    public String saveReservation(@ModelAttribute("reservationForm") Reservation reservationForm, Model model) {

        if (!reservationServiceImpl.save(reservationForm)) {
            model.addAttribute("checkInDateError", "Reservation failed");
            return "reservation";
        }

        return "redirect:/";
    }
}
