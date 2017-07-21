package com.dusty.dojoninjas.repositories;

import com.dusty.dojoninjas.models.Dojo;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by dusty on 7/20/17.
 */
@Repository
public interface DojoRepository extends CrudRepository<Dojo, Long> {
}
