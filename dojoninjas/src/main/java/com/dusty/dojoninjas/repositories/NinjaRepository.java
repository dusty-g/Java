package com.dusty.dojoninjas.repositories;

import com.dusty.dojoninjas.models.Dojo;
import com.dusty.dojoninjas.models.Ninja;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by dusty on 7/20/17.
 */
@Repository
public interface NinjaRepository extends CrudRepository<Ninja, Long> {
    List<Ninja> findAllByDojo(Dojo dojo);
}
