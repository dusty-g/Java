package com.dusty.languages.repositories;

import com.dusty.languages.models.Language;
import org.springframework.data.repository.CrudRepository;

/**
 * Created by dusty on 7/19/17.
 */
public interface LanguageRepository extends CrudRepository<Language, Long> {
}
