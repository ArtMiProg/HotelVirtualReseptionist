package com.hotel_booking.web.controller;

import com.hotel_booking.web.model.entity.ApartClass;
import com.hotel_booking.web.service.ApartClassService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
@RequiredArgsConstructor
public class ApartClassController {

    private final ApartClassService apartClassService;

    @GetMapping(value = "/apart_classes")
    public String apartClasses(Model model) {
        List<ApartClass> apartClasses = apartClassService.getAll();

        model.addAttribute("apart_classes", apartClasses);

        return "ourApartments";
    }

    @GetMapping(value = "/apartment_class")
    public String apartClass(@RequestParam() Integer id, Model model) {
        ApartClass apartClass = apartClassService.getById(id);

        model.addAttribute("apart_class", apartClass);

        return "ourApartments";
    }

    @GetMapping(value = "/showCreateApartment_class")
    public String showCreateApartment_class() {
        return "createApart_class";
    }

}

