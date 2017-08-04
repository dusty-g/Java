package com.dusty.belt2.services;

import com.dusty.belt2.models.User;
import com.dusty.belt2.repositories.RoleRepository;
import com.dusty.belt2.repositories.UserRepository;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {
    private UserRepository userRepository;
    private RoleRepository roleRepository;
    private BCryptPasswordEncoder bCryptPasswordEncoder;
    public UserService(UserRepository userRepository, BCryptPasswordEncoder bCryptPasswordEncoder, RoleRepository roleRepository){
        this.bCryptPasswordEncoder = bCryptPasswordEncoder;
        this.userRepository = userRepository;
        this.roleRepository = roleRepository;
    }

    public User findByUsername(String username){
        return userRepository.findByUsername(username);
    }

    public void saveWithUserRole(User user){
        user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
        user.setRoles(roleRepository.findByName("ROLE_USER"));
        userRepository.save(user);
    }
    public void saveWithUserAdmin(User user) {
        user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
        user.setRoles(roleRepository.findByName("ROLE_ADMIN"));
        userRepository.save(user);
    }
    public Boolean hasAdmin(){
        List<User> users = (List<User>) userRepository.findAll();
        if(users.size() < 1){
            return false;
        }else {
            return true;
        }
    }
    public Iterable<User> getAll(){
        return userRepository.findAll();
    }
    public Iterable<User> getNonAdmins(){

        return userRepository.findByRolesContains(roleRepository.findByName("ROLE_USER").get(0));
    }
    public User findById(Long id){
        return userRepository.findOne(id);
    }
    public void saveUser(User user){
        userRepository.save(user);
    }
}
