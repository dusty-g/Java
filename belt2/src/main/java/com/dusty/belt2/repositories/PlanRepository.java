package com.dusty.belt2.repositories;

import com.dusty.belt2.models.Plan;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PlanRepository extends CrudRepository<Plan, Long>{
    List<Plan> findByAvailableEquals(Boolean available);
}
