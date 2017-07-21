package com.dusty.dojoninjas.controllers;

import com.dusty.dojoninjas.models.Dojo;
import com.dusty.dojoninjas.models.Ninja;
import com.dusty.dojoninjas.services.DojoService;
import com.dusty.dojoninjas.services.NinjaService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.validation.Valid;

/**
 * Created by dusty on 7/20/17.
 */
@Controller
@RequestMapping("/dojos")
public class Dojos {
    DojoService dojoService;
    NinjaService ninjaService;
    public Dojos(DojoService dojoService, NinjaService ninjaService){
        this.dojoService = dojoService;
        this.ninjaService = ninjaService;
    }
    @RequestMapping("/new")
    public String serveDojoForm(@ModelAttribute("dojo")Dojo dojo){
        return "/WEB-INF/views/newDojo.jsp";
    }
    @PostMapping("/new")
    public String createNewDojo(@Valid @ModelAttribute("dojo") Dojo dojo, BindingResult result){
        if(result.hasErrors()){
            return "/WEB-INF/views/newDojo.jsp";
        }else{
            //create dojo
            dojoService.saveDojo(dojo);
            return "redirect:/dojos/"+dojo.getId();
        }
    }
    @RequestMapping("/{id}")
    public String getDojo(@PathVariable("id") Long id, Model model){
        Dojo dojo = dojoService.findByID(id);
        Iterable<Ninja> ninjas = ninjaService.findByDojo(dojo);
        model.addAttribute("ninjas", ninjas);
        model.addAttribute("dojo", dojo.getDojoName());
        return "/WEB-INF/views/ninjas.jsp";
    }

}
