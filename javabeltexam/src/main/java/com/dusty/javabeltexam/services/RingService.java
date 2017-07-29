package com.dusty.javabeltexam.services;

import com.dusty.javabeltexam.models.Ring;
import com.dusty.javabeltexam.models.User;
import com.dusty.javabeltexam.repositories.RingRepository;
import org.springframework.stereotype.Service;

@Service
public class RingService {
    RingRepository ringRepository;
    public RingService(RingRepository ringRepository){
        this.ringRepository = ringRepository;
    }

    public void createRing(String name, User admin){

        Ring newRing = new Ring(name, admin);

        this.ringRepository.save(newRing);
        System.out.println("in create ring ring service");
    }
    public Ring findById(Long id){
        return ringRepository.findOne(id);
    }
    public void saveRing(Ring ring){
        ringRepository.save(ring);
    }
    public void deleteRing(Long id){
        ringRepository.delete(id);
    }

}
