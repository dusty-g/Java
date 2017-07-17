package com.dusty.portfolio.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by dusty on 7/17/17.
 */
@Controller
public class Home {

    @RequestMapping("/x")
    public String me(){
        return "me.html";
    }
    @RequestMapping("/y")
    public String projects(){
        return "projects.html";
    }


}
