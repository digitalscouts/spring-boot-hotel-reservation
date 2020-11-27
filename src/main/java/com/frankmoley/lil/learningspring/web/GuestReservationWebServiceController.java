package com.frankmoley.lil.learningspring.web;

import com.frankmoley.lil.learningspring.business.domain.GuestReservarion;
import com.frankmoley.lil.learningspring.business.service.GuestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("api/guests")
public class GuestReservationWebServiceController {
    private final GuestService guestService;

    @Autowired
    public GuestReservationWebServiceController(GuestService guestService){
        this.guestService = guestService;
    }

    @GetMapping
    public List<GuestReservarion> getGuestList(){
        return this.guestService.getGuestList();
    }
}
