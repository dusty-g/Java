package com.dusty.overflow.controllers;

import com.dusty.overflow.models.Answer;
import com.dusty.overflow.services.AnswerService;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Repository;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by dusty on 7/21/17.
 */
@Controller
@RequestMapping("/answers")
public class Answers {
    AnswerService ansService;
    public Answers(AnswerService ansService){
        this.ansService = ansService;
    }

}
