package com.dusty.relationships.services;

import com.dusty.relationships.models.License;
import com.dusty.relationships.models.Person;
import com.dusty.relationships.repositories.LicenseRepository;
import org.springframework.stereotype.Service;

/**
 * Created by dusty on 7/20/17.
 */
@Service
public class LicenseService {
    LicenseRepository licenseRepo;
    public LicenseService(LicenseRepository licenseRepo){
        this.licenseRepo = licenseRepo;
    }

    public void createLicense(License license){
        licenseRepo.save(license);
        License license1 = licenseRepo.findOne(license.getId());
        license1.setNumber(String.format("%06d", license.getId()));
        licenseRepo.save(license1);
    }
    public void joinPerson(License license, Person person){
        license.setPerson(person);
        licenseRepo.save(license);
    }

}
