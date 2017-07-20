package com.dusty.relationships.controllers;

import com.dusty.relationships.models.License;
import com.dusty.relationships.models.Person;
import com.dusty.relationships.services.LicenseService;
import com.dusty.relationships.services.PersonService;
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
@RequestMapping("/licenses")
public class Licenses {
    LicenseService licenseService;
    PersonService personService;
    public Licenses(LicenseService licenseService, PersonService personService){
        this.licenseService = licenseService;
        this.personService = personService;
    }
    @RequestMapping("/new")
    public String showNewLicense(@ModelAttribute("license") License license, Model model){
        Iterable<Person> persons = personService.getNullLicensePersons();
        model.addAttribute("persons", persons);
        return "/WEB-INF/views/newLicense.jsp";
    }
    @PostMapping("/new")
    public String createLicense(@Valid @ModelAttribute("license") License license, BindingResult result){
        if(result.hasErrors()){
            return "/WEB-INF/views/newLicense.jsp";
        }else{
            //save to db
            licenseService.createLicense(license);
            return "redirect:/persons/"+license.getPerson().getId();
        }
    }


}
