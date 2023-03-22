package com.hotel_booking.web.controller;

import com.hotel_booking.web.model.entity.*;
import com.hotel_booking.web.model.repository.ApartClassRepository;
import com.hotel_booking.web.model.repository.ApartNumberRepository;
import com.hotel_booking.web.model.repository.ApartSizeRepository;
import com.hotel_booking.web.service.ApartNumberService;
import com.hotel_booking.web.service.InvoiceService;
import com.hotel_booking.web.service.ReservationService;
import com.hotel_booking.web.service.UserService;
import com.hotel_booking.web.service.impl.ApartNumberServiceImpl;
import com.hotel_booking.web.service.impl.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.validation.Valid;
import java.io.IOException;
import java.sql.Date;
import java.util.Collections;
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
    @Autowired
    private ApartClassRepository apartClassRepository;
    @Autowired
    private ApartSizeRepository apartSizeRepository;
    @Autowired
    private ApartNumberServiceImpl apartNumberServiceImpl;
    @Autowired
    private ApartNumberService apartNumberService;
    @Autowired
    private UserServiceImpl userServiceImpl;


    @GetMapping(value = "/admin")
    public String userList(Model model) {
        List<User> userList = userService.getAll();
        model.addAttribute("allUsers", userList);
        return "admin";
    }

    @PostMapping("/admin")
    public String deleteUser(@RequestParam(required = true, defaultValue = "") Integer id,
                             @RequestParam(required = true, defaultValue = "") String action,
                             Model model) {
        if (action.equals("delete")) {
            try {
                userService.deleteUser(id);
            } finally {
                return "redirect:/admin";
            }
        }
        if (action.equals("add")) {
            return "addUser";
        }
        return "redirect:/admin";
    }

    @GetMapping(value = "/admin/reservations")
    public String reservationList(Model model) {
        List<Reservation> reservationList = reservationService.getAll();

        model.addAttribute("allReservations", reservationList);
        return "reservations";
    }

    @PostMapping("/admin/reservations")
    public String reviewReservation(@RequestParam(required = true, defaultValue = "") Integer reservationNumber,
                                    @RequestParam(required = true, defaultValue = "") String action,
                                    Model model) {
        if (action.equals("review")) {
            return "invoice";
        }
        if (action.equals("delete")) {
            try {
                invoiceService.deleteReservation(reservationNumber);
            }finally {
                return "redirect:/admin/reservations";
            }
        }
        return "redirect:/admin/reservations";
    }

    @GetMapping(value = "admin/invoice")
    public String setInvoice(@RequestParam() Integer reservationNumber,
                             Integer userId,
                             Date checkInDate,
                             Date checkOutDate,
                             String prefApClass,
                             Integer prefApSize,
                             Model model) {
        List<ApartNumber> apartNumbers = invoiceService.showRelevantApartments(checkInDate, checkOutDate,
                prefApClass, prefApSize);

        Integer number = invoiceService.selectNumber(checkInDate, checkOutDate, prefApClass, prefApSize);
        if(number!=null) {
            Integer price = invoiceService.countPrice(number, checkInDate, checkOutDate);
            model.addAttribute("apartNumbers", apartNumbers);
            model.addAttribute("newInvoice", new Invoice(reservationNumber,
                    userId,
                    number,
                    price,
                    checkInDate,
                    checkOutDate));
        } else {
            Integer price = 0;
            model.addAttribute("apartNumbers", apartNumbers);
            model.addAttribute("newInvoice", new Invoice(reservationNumber,
                    userId,
                    number,
                    price,
                    checkInDate,
                    checkOutDate));
        }
        return "invoice";
    }

    @PostMapping("/admin/invoice")
    public String setInvoice(@ModelAttribute("newInvoice") Invoice newInvoice, Model model) {
        if (!invoiceService.setInvoice(newInvoice)) {
            model.addAttribute("idError", "Failed to send the invoice");
            return "invoice";
        }
        return "redirect:/admin/reservations";
    }

    @GetMapping("/admin/get/{userId}")
    public String getUser(@PathVariable("userId") Integer userId, Model model) {
        model.addAttribute("allUsers", userService.userGetList(userId));
        return "admin";
    }

    @GetMapping(value = "admin/manageApartments")
    public String manageApartments(@RequestParam(required = true, defaultValue = "") String action,
                                   Model model, Float basicPay){
        model.addAttribute("basicPay", basicPay);
        List<ApartNumber> apartInfos = apartNumberRepository.findAll();
        model.addAttribute("apartInfos", apartInfos);
        if (action.equals("add")) {

            return "designApartment";
        }
        return "manageApartments";
    }

    @PostMapping("/admin/manageApartments")
    public String resetBasicPay(@ModelAttribute("basicPay") Float basicPay,
                                @RequestParam(required = true, defaultValue = "") Integer id,
                                @RequestParam(required = true, defaultValue = "") String action,
                                Model model) {

        if(action.equals("save")) {
            try {
            apartNumberService.resetBasicPay(basicPay);
            apartNumberService.showDiurnalCost(basicPay);

            }finally {
                return "redirect:/admin/manageApartments";
            }
        }
        if (action.equals("delete")) {
            try {
                apartNumberService.deleteApartNumber(id);
            }finally {
                return "redirect:/admin/manageApartments";
            }
        }
        if (action.equals("change")) {
            return "changeApartmentFeatures";
        }
        return "redirect:/admin/manageApartments";
    }

    @GetMapping("/admin/addUser")
    public String addUser(Model model, Integer roleId){
        model.addAttribute("roleId", roleId);
        model.addAttribute("newUser", new User());
        return "addUser";
    }

    @PostMapping("/admin/addUser")
    public String addUser(@ModelAttribute("newUser") @Valid User newUser, BindingResult bindingResult,
                          @ModelAttribute("roleId") Integer roleId,
                          Model model){
        if (roleId == 5){
            newUser.setRoles(Collections.singleton(new Role(5, "ADMIN")));
        } else if (roleId == 6){
            newUser.setRoles(Collections.singleton(new Role(6, "ROLE_USER")));
        }
        if (bindingResult.hasErrors()) {
            return "addUser";
        }
        if (!newUser.getPassword().equals(newUser.getPasswordConfirm())) {
            model.addAttribute("passwordError", "Passwords don't correspond");
            return "addUser";
        }
        if (!userServiceImpl.saveUserByAdmin(newUser)) {
            model.addAttribute("usernameError", "User with such name already exists");
            return "addUser";
        }
        return "redirect:/admin";
    }

    @GetMapping("/admin/designApartment")
    public String designApartment (Model model){
        model.addAttribute("newApartment", new ApartNumber());
        return "designApartment";
    }

    @PostMapping("/admin/designApartment")
    public String designApartment(@ModelAttribute("newApartment") ApartNumber newApartment,
                                  @RequestParam("image") MultipartFile imageFile,
                                  Model model) throws IOException {
        try {
        newApartment.setImage(imageFile);
        apartNumberService.designApartment(newApartment);
            return "redirect:/admin/manageApartments";
        } catch (IOException e) {
            e.printStackTrace();
            return "error-page";
        }
    }

    @GetMapping("/admin/changeApartmentFeatures")
    public String changeApartment(@RequestParam() Integer id,
                                  Model model){
        ApartNumber changedApartNumber = apartNumberRepository.getById(id);
        model.addAttribute("changedApartNumber", changedApartNumber);
        return "changeApartmentFeatures";
    }

    @PostMapping("/admin/changeApartmentFeatures")
    public String changeApartment(@ModelAttribute("changedApartNumber") ApartNumber changedApartNumber,
                                  @RequestParam("id") Integer id,
                                  @RequestParam("image") MultipartFile imageFile,
                                  Model model) throws IOException {
        try {
        changedApartNumber = apartNumberRepository.getById(id);
        changedApartNumber.setImage(imageFile);
        apartNumberService.changeApartNumber(changedApartNumber);
        return "redirect:/admin/manageApartments";
        } catch (IOException e) {
            e.printStackTrace();
            return "changeApartmentFeatures";
        }
    }
}
