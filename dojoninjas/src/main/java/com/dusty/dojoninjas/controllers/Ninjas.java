package com.dusty.dojoninjas.controllers;

import com.dusty.dojoninjas.models.Dojo;
import com.dusty.dojoninjas.models.Ninja;
import com.dusty.dojoninjas.services.DojoService;
import com.dusty.dojoninjas.services.NinjaService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.validation.Valid;

/**
 * Created by dusty on 7/20/17.
 */
@Controller
@RequestMapping("/ninjas")
public class Ninjas {
    NinjaService ninjaService;
    DojoService dojoService;
    public Ninjas(NinjaService ninjaService, DojoService dojoService){
        this.ninjaService = ninjaService;
        this.dojoService = dojoService;
    }
    @RequestMapping("/new")
    public String serveNewNinjaPage(@ModelAttribute("ninja")Ninja ninja, Model model){
        Iterable<Dojo> dojos = dojoService.getAll();
        model.addAttribute("dojos", dojos);
        return "/WEB-INF/views/newNinja.jsp";
    }
    @PostMapping("/new")
    public String createNinja(@Valid @ModelAttribute("ninja") Ninja ninja, BindingResult result, Model model){
        if(result.hasErrors()){
            Iterable<Dojo> dojos = dojoService.getAll();
            model.addAttribute("dojos", dojos);
            return "/WEB-INF/views/newNinja.jsp";
        }else{
            //create ninja in db
            ninjaService.saveNinja(ninja);
            return "redirect:/dojos/"+ninja.getDojo().getId();
        }
    }
}
