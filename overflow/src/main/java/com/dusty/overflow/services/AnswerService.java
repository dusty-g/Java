package com.dusty.overflow.services;

import com.dusty.overflow.models.Answer;
import com.dusty.overflow.repositories.AnswerRepository;
import org.springframework.stereotype.Service;

/**
 * Created by dusty on 7/21/17.
 */
@Service
public class AnswerService {
    AnswerRepository ansRepo;
    public AnswerService(AnswerRepository ansRepo){
        this.ansRepo = ansRepo;
    }
    public Iterable<Answer> getAll(){
        return ansRepo.findAll();
    }
    public Answer getById(Long id){
        return ansRepo.findOne(id);
    }
    public void saveAnswer(Answer answer){
        ansRepo.save(answer);
    }
}
