package com.dusty.javabeltexam.repositories;

import com.dusty.javabeltexam.models.Role;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RoleRepository extends CrudRepository<Role, Long>{
    List<Role> findByName(String name);
}
