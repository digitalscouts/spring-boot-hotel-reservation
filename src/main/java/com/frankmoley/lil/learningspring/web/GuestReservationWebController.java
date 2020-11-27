package com.frankmoley.lil.learningspring.web;

import com.frankmoley.lil.learningspring.business.domain.GuestReservarion;
import com.frankmoley.lil.learningspring.business.service.GuestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/guests")
public class GuestReservationWebController {
    public final GuestService guestService;

    @Autowired
    public GuestReservationWebController(GuestService guestService){
        this.guestService = guestService;
    }

    @GetMapping
    public String getGuests(Model model){
        List<GuestReservarion> guestReservation = this.guestService.getGuestList();
        model.addAttribute("guestReservation", guestReservation);
        return "guests";
    }
}
