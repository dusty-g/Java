package com.dusty.platform.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by dusty on 7/18/17.
 */
@Controller
public class PlatformController {
    @RequestMapping("/m/{chapter}/0553/{assignmentNumber}")
    public String lesson(@PathVariable String chapter, @PathVariable String assignmentNumber, Model model){
        switch (assignmentNumber){
            case "0733":
                model.addAttribute("content", "Setting up your servers");
                break;
            case "0342":
                model.addAttribute("content","Punch Cards");
                break;
            case "0348":
                model.addAttribute("content", "Advanced Fortran Intro");
                break;
            default:
                model.addAttribute("content", "");
                break;
        }
        model.addAttribute("check", false);
        return "/WEB-INF/views/lesson.jsp";
        }
    @RequestMapping("/m/{chapter}/0483/{assignmentNumber}")
    public String assignment(@PathVariable String chapter, @PathVariable String assignmentNumber, Model model){
        switch(assignmentNumber){
            case "0345":
                model.addAttribute("content", "Coding Forms");
                break;
            case "2342":
                model.addAttribute("content", "Fortran to Binary");
                break;
            default:
                break;

        }
        model.addAttribute("check", true);
        return "/WEB-INF/views/assignment.jsp";
    }

    @RequestMapping("/")
    public String index(){
        return "/WEB-INF/views/lesson.jsp";
    }
}
