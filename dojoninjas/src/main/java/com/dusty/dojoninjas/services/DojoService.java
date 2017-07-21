package com.dusty.dojoninjas.services;

import com.dusty.dojoninjas.models.Dojo;
import com.dusty.dojoninjas.repositories.DojoRepository;
import org.springframework.stereotype.Service;

/**
 * Created by dusty on 7/20/17.
 */
@Service
public class DojoService {
    DojoRepository dojoRepo;
    public DojoService(DojoRepository dojoRepo){
        this.dojoRepo = dojoRepo;
    }
    public void saveDojo(Dojo dojo){
        dojoRepo.save(dojo);
    }
    public Iterable<Dojo> getAll(){
        return dojoRepo.findAll();
    }
    public Dojo findByID(Long id){
        return dojoRepo.findOne(id);
    }
}
