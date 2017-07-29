package com.dusty.javabeltexam.controllers;

import com.dusty.javabeltexam.services.RingService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/rings")
public class Rings {
    RingService ringService;
    public Rings(RingService ringService){
        this.ringService = ringService;
    }

    @PostMapping("/delete/{id}")
    public String deleteRing(@PathVariable("id") Long id){
        ringService.deleteRing(id);
        return "redirect:/";
    }
}
