package com.dusty.languages.models;

import javax.validation.constraints.Size;

/**
 * Created by dusty on 7/19/17.
 */
public class Language {
    public String getLanguage_name() {
        return language_name;
    }

    public void setLanguage_name(String language_name) {
        this.language_name = language_name;
    }

    @Size(min = 2, max = 20)
    private String language_name;
    @Size(min = 4, max = 20)
    private String creator;
    @Size(max = 20)
    private String version;

    public String getName() {
        return language_name;
    }

    public void setName(String language_name) {
        this.language_name = language_name;
    }

    public String getCreator() {
        return creator;
    }

    public void setCreator(String creator) {
        this.creator = creator;
    }

    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version;
    }
    public Language(){}
    public Language(String language_name, String creator, String version){
        this.creator = creator;
        this.language_name = language_name;
        this.version = version;
    }

}
