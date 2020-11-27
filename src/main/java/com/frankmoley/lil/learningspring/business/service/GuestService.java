package com.frankmoley.lil.learningspring.business.service;

import com.frankmoley.lil.learningspring.business.domain.GuestReservarion;
import com.frankmoley.lil.learningspring.business.domain.RoomReservation;
import com.frankmoley.lil.learningspring.data.entity.Guest;
import com.frankmoley.lil.learningspring.data.repository.GuestRepository;
import org.springframework.stereotype.Service;

import java.util.*;


@Service
public class GuestService {
    public final GuestRepository guestRepository;
    public GuestService(GuestRepository guestRepository){
        this.guestRepository = guestRepository;
    }
    public List<GuestReservarion> getGuestList(){
        Iterable<Guest> guests= this.guestRepository.findAll();
        Map<Long, GuestReservarion> guestReservationMap = new HashMap<>();
        guests.forEach(guest -> {
            GuestReservarion guestReservarion = new GuestReservarion();
            guestReservarion.setGuestId(guest.getGuestId());
            guestReservarion.setFirstName(guest.getFirstName());
            guestReservarion.setLastName(guest.getLastName());
            guestReservarion.setEmail(guest.getEmailAddress());
            guestReservarion.setPhoneNumber(guest.getPhoneNumber());
            guestReservationMap.put(guest.getGuestId(), guestReservarion);
        });

        List<GuestReservarion> guestReservarions = new ArrayList<>();
        for(Long id: guestReservationMap.keySet()){
            guestReservarions.add(guestReservationMap.get(id));
        }
        guestReservarions.sort(new Comparator<GuestReservarion>() {
            @Override
            public int compare(GuestReservarion o1, GuestReservarion o2) {
                if(o1.getLastName() == o2.getLastName()){
                    return o1.getFirstName().compareTo(o2.getFirstName());
                }
                return o1.getLastName().compareTo(o2.getLastName());
            }
        });
        return guestReservarions;
    }
}
