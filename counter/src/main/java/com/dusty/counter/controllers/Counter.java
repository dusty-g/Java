package com.dusty.counter.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;

/**
 * Created by dusty on 7/17/17.
 */
@Controller
public class Counter {
    @RequestMapping("/")
    public String index(HttpSession session){
        Integer count = (Integer) session.getAttribute("count");
        if (count == null){
            count = 0;
        }
        session.setAttribute("count", count + 1);
        return "index.html";
    }
    @RequestMapping("/counter")
    public String counter(HttpSession session){
        return "/WEB-INF/counter.jsp";
    }
}
