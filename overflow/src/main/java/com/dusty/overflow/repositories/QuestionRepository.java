package com.dusty.overflow.repositories;

import com.dusty.overflow.models.Question;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by dusty on 7/21/17.
 */
@Repository
public interface QuestionRepository extends CrudRepository<Question, Long> {
}
