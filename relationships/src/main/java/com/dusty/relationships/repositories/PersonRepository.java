package com.dusty.relationships.repositories;

import com.dusty.relationships.models.Person;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by dusty on 7/20/17.
 */
@Repository
public interface PersonRepository extends CrudRepository<Person, Long>{
    List<Person> findAllByLicenseIsNull();
}
