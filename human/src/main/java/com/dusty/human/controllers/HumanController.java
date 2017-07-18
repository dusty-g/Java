package com.dusty.human.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * Created by dusty on 7/18/17.
 */
@Controller
public class HumanController {
    @RequestMapping("/")
    public String index(@RequestParam(value = "name", required = false) String nameParam, Model model){
        if(nameParam != null){
            model.addAttribute("name", nameParam);
            return "/WEB-INF/views/hello.jsp";
        }else{
            return "hello.html";
        }


    }
}
