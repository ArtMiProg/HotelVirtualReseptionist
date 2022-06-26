package com.hotel_booking.web.controller;

import com.hotel_booking.web.model.entity.Invoice;
import com.hotel_booking.web.model.entity.Reservation;
import com.hotel_booking.web.model.entity.User;
import com.hotel_booking.web.service.InvoiceService;
import com.hotel_booking.web.service.ReservationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.ArrayList;
import java.util.List;

@Controller
public class UserController {

    @Autowired
    private ReservationService reservationService;
    @Autowired
    private InvoiceService invoiceService;

    @GetMapping("/account")
    public String userAccount (Model model){
        User user = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        model.addAttribute("user", user);
        List<Reservation> myReservations = reservationService.getReservationsByUserId(user.getId());
        model.addAttribute("myReservations", myReservations);
        List<Invoice> myInvoices = invoiceService.getByUserId(user.getId());
        List<Invoice> currentInvoices = new ArrayList<>();
        for (Invoice inv : myInvoices){
            Integer invNumber = inv.getId();
          for (Reservation reserv : myReservations){
              Integer reservNumber = reserv.getReservationNumber();
              if (reservNumber.equals(invNumber)){
                  currentInvoices.add(inv);
              }
          }
        }
        model.addAttribute("currentInvoices", currentInvoices);
        model.addAttribute("userAccount");
        return "account";
    }

}
