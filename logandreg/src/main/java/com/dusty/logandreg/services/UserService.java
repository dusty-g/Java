package com.dusty.logandreg.services;

import com.dusty.logandreg.models.Role;
import com.dusty.logandreg.models.User;
import com.dusty.logandreg.repositories.RoleRepository;
import com.dusty.logandreg.repositories.UserRepository;
import com.sun.org.apache.xpath.internal.operations.Bool;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {
    private UserRepository userRepository;
    private RoleRepository roleRepository;
    private BCryptPasswordEncoder bCryptPasswordEncoder;
    public UserService(RoleRepository roleRepository, UserRepository userRepository, BCryptPasswordEncoder bCryptPasswordEncoder){
        this.userRepository = userRepository;
        this.roleRepository = roleRepository;
        this.bCryptPasswordEncoder = bCryptPasswordEncoder;
    }

    public void saveWithUserRole(User user){
        user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
        user.setRoles(roleRepository.findByName("ROLE_USER"));
        userRepository.save(user);
    }
    public void saveWithUserAdmin(User user){
        user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
        user.setRoles(roleRepository.findByName("ROLE_ADMIN"));
        userRepository.save(user);
    }
    public User findByUsername(String username){
        return userRepository.findByUsername(username);
    }
    public Boolean isAdmin(){
        Role role = roleRepository.findByName("ROLE_ADMIN").get(0);
        System.out.println(role.getName());
        if(userRepository.findByRolesContains(role).size()>0) {

            return true;
        }else{
            return false;
        }
    }
    public Iterable<User> allUsers(){
        return userRepository.findAll();
    }
    public Role findRoleByName(String name){
        return roleRepository.findByName(name).get(0);
    }
    public void deleteUser(Long id){
        userRepository.delete(id);
    }
    public User getUserById(Long id){
        return userRepository.findOne(id);
    }
    public void makeUserAdmin(User user){
        user.setRoles(roleRepository.findByName("ROLE_ADMIN"));
        userRepository.save(user);
    }
}
