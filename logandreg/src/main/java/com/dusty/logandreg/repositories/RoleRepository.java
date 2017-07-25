package com.dusty.logandreg.repositories;

import com.dusty.logandreg.models.Role;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RoleRepository extends CrudRepository<Role, Long>{
    List<Role> findByName(String name);
}
