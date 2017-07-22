package com.dusty.overflow.repositories;

import com.dusty.overflow.models.Answer;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by dusty on 7/21/17.
 */
@Repository
public interface AnswerRepository extends CrudRepository<Answer, Long>{
}
