package com.dusty.relationships.services;

import com.dusty.relationships.models.License;
import com.dusty.relationships.models.Person;
import com.dusty.relationships.repositories.PersonRepository;
import org.springframework.stereotype.Service;

/**
 * Created by dusty on 7/20/17.
 */
@Service
public class PersonService {
    PersonRepository personRepo;
    public PersonService(PersonRepository personRepo){
        this.personRepo = personRepo;
    }
    public void createPerson(Person person){
        personRepo.save(person);
    }
    public Iterable<Person> getAllPersons(){
        return personRepo.findAll();
    }
    public Iterable<Person> getNullLicensePersons(){
        return personRepo.findAllByLicenseIsNull();
    }
    public Person getPersonById(Long id){
        return personRepo.findOne(id);
    }
    public void joinLicense(License license, Person person){
        person.setLicense(license);
        personRepo.save(person);
    }

}
