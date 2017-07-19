package com.dusty.languages.services;

import com.dusty.languages.models.Language;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by dusty on 7/19/17.
 */
@Service
public class LanguageService {
    private List<Language> languages = new ArrayList<>(Arrays.asList(
            new Language("Java", "James Gosling", "1.8"),
            new Language("Python", "Guido van Rossum", "3.6")
    ));
    public List<Language> allLanguages(){
        return languages;
    }
    public void addLanguage(Language language){
        languages.add(language);
    }
    public void deleteLanguage(int index){
        if(index < languages.size()){
            languages.remove(index);

        }
    }
    public Language getLanguageByID(int index){
        if(index < languages.size()){
            Language language = languages.get(index);
            return language;

        }else{
            return null;
        }
    }
    public void editLanguage(int id, Language language){
        if(id < languages.size()){
            languages.set(id, language);
        }
    }
}
