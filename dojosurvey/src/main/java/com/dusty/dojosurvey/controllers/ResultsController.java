package com.dusty.dojosurvey.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpSession;
import java.util.HashMap;

/**
 * Created by dusty on 7/18/17.
 */
@Controller
public class ResultsController {
    @RequestMapping(path = "/", method = RequestMethod.GET)
    public String index(){
        return "survey.html";
    }
    @RequestMapping(path = "/result", method = RequestMethod.POST)
    public String result(HttpSession session, @RequestParam HashMap<String,String> formData, @RequestParam("language") String language){
        session.setAttribute("data", formData);
        session.setAttribute("language", language);
        return "redirect:/result";
    }
    @RequestMapping(path = "/result", method = RequestMethod.GET)
    public String result(HttpSession session, Model model){
        if(session.getAttribute("data")==null){
            return "redirect:/";
        }else{
            if((session.getAttribute("language").equals("Java"))){
                return "/WEB-INF/views/java.jsp";
            }else{
                return "/WEB-INF/views/result.jsp";

            }
        }
    }
    @RequestMapping(path="/reset", method = RequestMethod.GET)
    public String reset(HttpSession session){
        session.invalidate();
        return "redirect:/";
    }
}
