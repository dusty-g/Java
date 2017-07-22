package com.dusty.overflow.services;

import com.dusty.overflow.models.Question;
import com.dusty.overflow.repositories.QuestionRepository;
import org.springframework.stereotype.Service;

/**
 * Created by dusty on 7/21/17.
 */
@Service
public class QuestionService {
    QuestionRepository questionRepository;
    QuestionService(QuestionRepository questionRepository){
        this.questionRepository = questionRepository;
    }
    public Iterable<Question> getAll(){
        return questionRepository.findAll();
    }
    public Question getById(Long id){
        return questionRepository.findOne(id);
    }
    public void saveQuestion(Question question){
        questionRepository.save(question);
    }

}
