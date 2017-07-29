package com.dusty.javabeltexam.repositories;

import com.dusty.javabeltexam.models.Role;
import com.dusty.javabeltexam.models.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepository extends CrudRepository<User, Long>{
    User findByUsername(String username);
    List<User> findByRolesContains(Role role);
    User findByEmail(String email);
}
