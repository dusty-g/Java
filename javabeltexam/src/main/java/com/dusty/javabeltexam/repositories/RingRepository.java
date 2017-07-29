package com.dusty.javabeltexam.repositories;

import com.dusty.javabeltexam.models.Guild;
import com.dusty.javabeltexam.models.Ring;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RingRepository extends CrudRepository<Ring, Long>{
}
