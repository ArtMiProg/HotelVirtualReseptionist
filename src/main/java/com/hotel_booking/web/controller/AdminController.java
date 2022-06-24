package com.hotel_booking.web.controller;

import com.hotel_booking.web.model.entity.ApartNumber;
import com.hotel_booking.web.model.entity.Invoice;
import com.hotel_booking.web.model.entity.Reservation;
import com.hotel_booking.web.model.entity.User;
import com.hotel_booking.web.model.repository.ApartNumberRepository;
import com.hotel_booking.web.service.InvoiceService;
import com.hotel_booking.web.service.ReservationService;
import com.hotel_booking.web.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.sql.Date;
import java.util.List;

@Controller
public class AdminController {
    @Autowired
    private UserService userService;
    @Autowired
    private ReservationService reservationService;
    @Autowired
    private InvoiceService invoiceService;
    @Autowired
    private ApartNumberRepository apartNumberRepository;

    @GetMapping(value = "/admin")
    public String userList(Model model) {
        List<User> userList = userService.getAll();

        model.addAttribute("allUsers", userList);
        return "admin";
    }

    @GetMapping(value = "/admin/reservations")
    public String reservationList(Model model) {
        List<Reservation> reservationList = reservationService.getAll();

        model.addAttribute("allReservations", reservationList);
        return "reservations";
    }


    @PostMapping("/admin")
    public String deleteUser(@RequestParam(required = true, defaultValue = "") Integer id,
                             @RequestParam(required = true, defaultValue = "") String action,
                             Model model) {
        if (action.equals("delete")) {
            userService.deleteUser(id);
        }
        return "redirect:/admin";
    }

    @PostMapping("/admin/reservations")
    public String reviewReservation(@RequestParam(required = true, defaultValue = "") Integer reservationNumber,
                                    @RequestParam(required = true, defaultValue = "") String action,
                                    Model model) {
        if (action.equals("review")) {

            return "invoice";
        }
        if (action.equals("delete")) {
            invoiceService.deleteReservation(reservationNumber);
        }
        return "redirect:/admin/reservations";
    }

    @GetMapping(value = "admin/invoice")
    public String setInvoice(@RequestParam() Integer reservationNumber,
                             Integer userId,
                             Date checkInDate,
                             Date checkOutDate,
                             Model model) {
        List<ApartNumber> apartNumbers = apartNumberRepository.findAll();
        model.addAttribute("apartNumbers", apartNumbers);
        model.addAttribute("newInvoice", new Invoice(reservationNumber,
                userId,
                checkInDate,
                checkOutDate));
        return "invoice";
    }

    @PostMapping("/admin/invoice")
    public String setInvoice(@ModelAttribute("newInvoice") Invoice newInvoice, Model model) {

        if (!invoiceService.setInvoice(newInvoice)) {
            model.addAttribute("idError", "Failed to send the invoice");
            return "invoice";
        }

        return "admin";
    }

    @GetMapping("/admin/get/{userId}")
    public String getUser(@PathVariable("userId") Integer userId, Model model) {
        model.addAttribute("allUsers", userService.userGetList(userId));
        return "admin";
    }
}
