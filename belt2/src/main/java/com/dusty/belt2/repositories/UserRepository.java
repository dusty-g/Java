package com.dusty.belt2.repositories;

import com.dusty.belt2.models.Role;
import com.dusty.belt2.models.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepository extends CrudRepository<User, Long>{
    User findByUsername(String username);
    List<User> findByRolesContains(Role role);


}
