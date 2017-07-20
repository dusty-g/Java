package com.dusty.languages.controllers;

import com.dusty.languages.models.Language;
import com.dusty.languages.services.LanguageService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.validation.Valid;
import java.util.List;

/**
 * Created by dusty on 7/19/17.
 */
@Controller
public class LanguagesController {

    private final LanguageService languageService;

    public LanguagesController(LanguageService languageService){
        this.languageService = languageService;
    }

    @RequestMapping("/languages")
    public String home(@ModelAttribute("language") Language language, Model model){
        Iterable<Language> languages = languageService.allLanguages();
        model.addAttribute("languages", languages);
        return "/WEB-INF/views/languages.jsp";
    }
    @PostMapping("/languages")
    public String newLanguage(@Valid @ModelAttribute("language") Language language, BindingResult result){
        if(result.hasErrors()){
            return "/WEB-INF/views/languages.jsp";
        }else{
            languageService.addLanguage(language);
            return "redirect:/languages";
        }
    }
    @RequestMapping("/languages/delete/{id}")
    public String deleteLanguage(@PathVariable("id") Long id){
        languageService.deleteLanguage(id);
        return "redirect:/languages";
    }
    @RequestMapping("/languages/edit/{id}")
    public String editLanguage(@PathVariable("id") Long id, Model model){
        Language language = languageService.getLanguageByID(id);
        model.addAttribute("language", language);
        model.addAttribute("id", id);
        return "/WEB-INF/views/editLanguage.jsp";
    }
    @PostMapping("/languages/edit/{id}")
    public String updateLanguage(@PathVariable("id") int id, @Valid @ModelAttribute("language") Language language, BindingResult result){
        if(result.hasErrors()){
            return "/WEB-INF/views/editLanguage.jsp";
        }else{
            languageService.editLanguage(language);
            return "redirect:/languages";
        }
    }
    @RequestMapping("/languages/{id}")
    public String getLanguge(@PathVariable("id") Long id, Model model){
        Language language = languageService.getLanguageByID(id);
        model.addAttribute("language", language);
        return "/WEB-INF/views/language.jsp";
    }

}
