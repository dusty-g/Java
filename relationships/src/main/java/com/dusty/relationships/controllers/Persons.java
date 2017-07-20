package com.dusty.relationships.controllers;

import com.dusty.relationships.models.Person;
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
@RequestMapping("/persons")
public class Persons {
    PersonService personService;

    public Persons(PersonService personService){
        this.personService = personService;
    }
    @RequestMapping("/new")
    public String newPerson(@ModelAttribute("person") Person person){
        return "/WEB-INF/views/newPerson.jsp";
    }
    @PostMapping("/new")
    public String createPerson(@Valid @ModelAttribute("person") Person person, BindingResult result){
        if(result.hasErrors()){
            return "/WEB-INF/views/newPerson.jsp";
        }else{
            //save person to database
            personService.createPerson(person);
            return "redirect:/persons/"+person.getId();
        }
    }
    @RequestMapping("/{id}")
    public String showOnePerson(@PathVariable("id") Long id, Model model){
        Person person = personService.getPersonById(id);
        if(person == null){
            return "redirect:/persons/new";
        }else{
            model.addAttribute("person", person);
            return "/WEB-INF/views/onePerson.jsp";
        }
    }
}
