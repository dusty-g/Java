package com.dusty.languages.services;

import com.dusty.languages.models.Language;
import com.dusty.languages.repositories.LanguageRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by dusty on 7/19/17.
 */
@Service
public class LanguageService {
    private LanguageRepository languageRepository;
    public LanguageService(LanguageRepository languageRepository){
        this.languageRepository = languageRepository;
    }
    private List<Language> languages = new ArrayList<>(Arrays.asList(
            new Language("Java", "James Gosling", "1.8"),
            new Language("Python", "Guido van Rossum", "3.6")
    ));
    public Iterable<Language> allLanguages(){
        return languageRepository.findAll();
    }
    public void addLanguage(Language language){
        languageRepository.save(language);
    }
    public void deleteLanguage(Long index){
            languageRepository.delete(index);

    }
    public Language getLanguageByID(Long index){
        return languageRepository.findOne(index);
    }
    public void editLanguage(Language language){
        languageRepository.save(language);
    }
}
