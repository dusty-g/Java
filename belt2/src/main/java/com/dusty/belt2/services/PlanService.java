package com.dusty.belt2.services;

import com.dusty.belt2.models.Plan;
import com.dusty.belt2.repositories.PlanRepository;
import org.springframework.stereotype.Service;

@Service
public class PlanService {
    PlanRepository planRepository;
    public PlanService(PlanRepository planRepository){
        this.planRepository = planRepository;
    }

    public Iterable<Plan> getAll(){
        return planRepository.findAll();
    }
    public Iterable<Plan> getAvailable(){
        return planRepository.findByAvailableEquals(true);
    }
    public void save(Plan plan){
        planRepository.save(plan);
    }
    public Plan getById(Long id){
        return planRepository.findOne(id);
    }
    public void delete(Long id){
        planRepository.delete(id);
    }
}
