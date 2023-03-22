package com.hotel_booking.web.controller;

import com.hotel_booking.web.model.entity.ApartClass;
import com.hotel_booking.web.model.entity.ApartNumber;
import com.hotel_booking.web.model.entity.ApartSize;
import com.hotel_booking.web.model.repository.ApartClassRepository;
import com.hotel_booking.web.model.repository.ApartNumberRepository;
import com.hotel_booking.web.model.repository.ApartSizeRepository;
import com.hotel_booking.web.service.ApartNumberService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
@RequiredArgsConstructor
public class ApartNumberController {

    @Autowired
    private ApartNumberService apartNumberService;
    @Autowired
    private ApartNumberRepository apartNumberRepository;
    @Autowired
    private ApartClassRepository apartClassRepository;
    @Autowired
    private ApartSizeRepository apartSizeRepository;

    @GetMapping(value = "/apartmentView")
        public String apartmentView(@RequestParam(required=false, name="id", defaultValue="1") Integer id,
                                    @RequestParam(required=false, name="number", defaultValue="1") Integer number,
                                    @RequestParam(required=false, name="apClassId", defaultValue="1") Integer apartClassId,
                                    @RequestParam(required=false, name="apSizeId", defaultValue="1") Integer apartSizeId,
                                    @RequestParam(required=false, name="cost") Float cost,
                                    Model model){
        List<ApartNumber> apartNumbers = apartNumberService.getAll();
        model.addAttribute("apartNumbers", apartNumbers);
        model.addAttribute("number", number);
        ApartClass apartClass = apartClassRepository.getById(apartClassId);
        model.addAttribute("apartClass", apartClass);
        ApartSize apartSize = apartSizeRepository.getById(apartSizeId);
        model.addAttribute("apartSize", apartSize);
        ApartNumber apartNumberVied = apartNumberService.getById(id);
        model.addAttribute("apartNumberVied", apartNumberVied);
        if (cost == null){
            cost = apartNumberVied.getCost();
            model.addAttribute("cost", cost);
        } else {
            model.addAttribute("cost", cost);
        }
        return "apartmentView";
    }

    @PostMapping(value = "/apartmentView")
    public String apartmentView(Model model){

        return "redirect:/apartmentView";
    }
}
