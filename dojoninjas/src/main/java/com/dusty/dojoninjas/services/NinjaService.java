package com.dusty.dojoninjas.services;

import com.dusty.dojoninjas.models.Dojo;
import com.dusty.dojoninjas.models.Ninja;
import com.dusty.dojoninjas.repositories.NinjaRepository;
import org.springframework.stereotype.Service;

/**
 * Created by dusty on 7/20/17.
 */
@Service
public class NinjaService {
    NinjaRepository ninjaRepo;
    public NinjaService(NinjaRepository ninjaRepo){
        this.ninjaRepo = ninjaRepo;
    }
    public void saveNinja(Ninja ninja){
        ninjaRepo.save(ninja);
    }
    public Iterable<Ninja> findByDojo(Dojo dojo){
        Iterable<Ninja> ninjas = ninjaRepo.findAllByDojo(dojo);
        return ninjas;
    }
}
