package com.dusty.javabeltexam.repositories;

import com.dusty.javabeltexam.models.Guild;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GuildRepository extends CrudRepository<Guild, Long>{
}
