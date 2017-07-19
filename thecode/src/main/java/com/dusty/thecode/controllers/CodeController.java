package com.dusty.thecode.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

/**
 * Created by dusty on 7/18/17.
 */
@Controller
public class CodeController {
    @RequestMapping("/")
    public String index(@ModelAttribute("error") String error){
        return "/WEB-INF/views/index.jsp";
    }
    @RequestMapping("/code")
    public String code(){
        return "x.html";
    }
    @PostMapping("/code")
    public String code(@RequestParam("code") String code, RedirectAttributes redirectAttributes){
        if(code.equals("bushido")){
            return "redirect:/code";
        }else{
            redirectAttributes.addFlashAttribute("error", "Train harder!");
            return"redirect:/";
        }
    }
}
