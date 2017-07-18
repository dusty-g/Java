package com.dusty.displaydate.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by dusty on 7/17/17.
 */
@Controller

public class DateController {
    @RequestMapping("/date")

    public String date(Model model){
        String dateString = new SimpleDateFormat("E, dd, MMMM, yyyy").format(new Date());
        model.addAttribute("date", dateString);
        return "date.jsp";
    }
    @RequestMapping("/time")
    public String time(Model model){
        String timeString = new SimpleDateFormat("hh:mm:ss a").format(new Date());
        model.addAttribute("time", timeString);
        return "time.jsp";
    }
}
