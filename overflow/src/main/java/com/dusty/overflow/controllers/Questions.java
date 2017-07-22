package com.dusty.overflow.controllers;

import com.dusty.overflow.models.Answer;
import com.dusty.overflow.models.Question;
import com.dusty.overflow.models.Tag;
import com.dusty.overflow.services.AnswerService;
import com.dusty.overflow.services.QuestionService;
import com.dusty.overflow.services.TagService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by dusty on 7/21/17.
 */
@Controller
@RequestMapping("/questions")
public class Questions {
    QuestionService questionService;
    TagService tagService;
    AnswerService answerService;
    public Questions(QuestionService questionService, TagService tagService, AnswerService answerService){
        this.questionService = questionService;
        this.tagService = tagService;
        this.answerService = answerService;
    }
    @RequestMapping("")
    public String dashboard(Model model){
        Iterable<Question> questions = questionService.getAll();
        model.addAttribute("questions", questions);
        return "/WEB-INF/views/dashboard.jsp";
    }
    @RequestMapping("/new")
    public String newQuestionPage(@ModelAttribute("question") Question question, Model model){
        Boolean test = false;
        model.addAttribute("test", test);
        return "/WEB-INF/views/newQuestion.jsp";
    }
    @PostMapping("/new")
    public String createQuestion(@RequestParam("question") String question, @RequestParam("tags") String tagsString){
        if(question.equals("")){
            return "redirect:/questions/new";
        }
        Question newQuestion = new Question(question);
        if(tagsString.length() > 0){

            String[] tagList = tagsString.split(",");
            if(tagList.length > 3){
                return "redirect:/questions/new";
            }
            List<Tag> tags = new ArrayList<>();
            for (String tag : tagList){
                Tag tag1;
                if(tagService.findBySubject(tag) == null){
                    tag1 = new Tag(tag);
                    tagService.saveTag(tag1);
                    tag1 = tagService.getById(tag1.getId());
                }else{
                    tag1 = tagService.findBySubject(tag);
                }
                tags.add(tag1);
            }
            newQuestion.setTags(tags);
        }
        questionService.saveQuestion(newQuestion);
        return "redirect:/questions";

    }
    @RequestMapping("/{id}")
    public String getOneQuestion(@PathVariable("id") Long id, Model model, @ModelAttribute("answerModel") Answer answerModel){
        Question question = questionService.getById(id);
        model.addAttribute("question", question);
        return "/WEB-INF/views/question.jsp";
    }
    @PostMapping("/{id}")
    public String newAnswer(@Valid @ModelAttribute("answerModel") Answer answerModel, BindingResult result, @PathVariable("id") Long id, Model model){
        Question question = questionService.getById(id);
        if(result.hasErrors()){
            System.out.println(answerModel);
            model.addAttribute("question", question);
            return "/WEB-INF/views/question.jsp";
        }else{
            //save to db

            answerModel.setQuestion(question);
            answerService.saveAnswer(answerModel);
            return "redirect:/questions/"+id;
        }
    }
}
