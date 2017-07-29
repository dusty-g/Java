package com.dusty.javabeltexam.services;

import com.dusty.javabeltexam.models.Ring;
import com.dusty.javabeltexam.models.Role;
import com.dusty.javabeltexam.models.User;
import com.dusty.javabeltexam.repositories.GuildRepository;
import com.dusty.javabeltexam.repositories.RingRepository;
import com.dusty.javabeltexam.repositories.RoleRepository;
import com.dusty.javabeltexam.repositories.UserRepository;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserService {
    private UserRepository userRepository;
    private RoleRepository roleRepository;
    private RingRepository ringRepository;
    private GuildRepository guildRepository;
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    public UserService(UserRepository userRepository, RingRepository ringRepository, RoleRepository roleRepository, GuildRepository guildRepository, BCryptPasswordEncoder bCryptPasswordEncoder){
        this.bCryptPasswordEncoder = bCryptPasswordEncoder;
        this.userRepository = userRepository;
        this.ringRepository = ringRepository;
        this.roleRepository = roleRepository;
        this.guildRepository = guildRepository;
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
    public User findByEmail(String email){
        return userRepository.findByEmail(email);
    }
    public Boolean hasAdmin(){
        List<User> users = (List<User>) userRepository.findAll();
        if(users.size() < 1){
            return false;
        }else {
            return true;
        }
    }
    public User findById(Long id){
        return userRepository.findOne(id);
    }
    public List<Ring> adminRings(){
        Role admin = roleRepository.findByName("ROLE_ADMIN").get(0);
        List<User> admins = userRepository.findByRolesContains(admin);
        List<Ring> rings = new ArrayList<>();
        for(User user: admins){
            for(Ring ring: user.getRings()){
                rings.add(ring);
            }
        }
        return rings;
    }
    public void makeAdmin(Long id){
        User user = findById(id);
        List<Role> admin = roleRepository.findByName("ROLE_ADMIN");
        user.setRoles(admin);
        userRepository.save(user);

    }
    public Iterable<User> getAll(){
        return userRepository.findAll();
    }
    public void deleteUser(Long id){
        userRepository.delete(id);
    }
    public void saveUser(User user){
        userRepository.save(user);
    }
}
