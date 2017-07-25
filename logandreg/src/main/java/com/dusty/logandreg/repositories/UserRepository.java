package com.dusty.logandreg.repositories;

import com.dusty.logandreg.models.Role;
import com.dusty.logandreg.models.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepository extends CrudRepository<User, Long>{
    User findByFirstName(String firstName);
    User findByUsername(String username);
    List<User> findByRolesContains(Role role);
}
