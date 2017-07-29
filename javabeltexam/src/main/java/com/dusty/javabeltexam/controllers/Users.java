package com.dusty.javabeltexam.controllers;

import com.dusty.javabeltexam.models.Ring;
import com.dusty.javabeltexam.models.User;
import com.dusty.javabeltexam.services.RingService;
import com.dusty.javabeltexam.services.UserService;
import com.dusty.javabeltexam.validator.UserValidator;
import org.apache.catalina.servlet4preview.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.WebAuthenticationDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.security.Principal;
import java.util.List;

@Controller
public class Users {
    UserService userService;
    RingService ringService;
    UserValidator userValidator;

    public Users(UserService userService, RingService ringService, UserValidator userValidator){
        this.userService = userService;
        this.ringService = ringService;
        this.userValidator = userValidator;
    }
    @Autowired
    protected AuthenticationManager authenticationManager;

    @RequestMapping("/")
    public String dashboard(Principal principal, Model model){
        String username = principal.getName();
        System.out.println(username);
        List<Ring> rings = userService.adminRings();

        //get all available rings and add to model
        model.addAttribute("currentUser", userService.findByUsername(username));
        model.addAttribute("availableRings", rings);
        return "dashboard.jsp";
    }
    @RequestMapping("/login")
    public String loginPage(@ModelAttribute("user") User user, Model model,@RequestParam(value = "error", required = false) String error, @RequestParam(value= "logout", required = false) String logout ){
        if(error != null){
            model.addAttribute("errorMessage", "invalid credentials");
        }
        if(logout !=null){
            model.addAttribute("logoutMessage", "logout successful");
        }
        return "home.jsp";
    }
    @PostMapping("/registration")
    public String registerUser(@Valid @ModelAttribute("user") User user, BindingResult result, HttpServletRequest request){
        userValidator.validate(user, result);
        if(result.hasErrors()){
            return "home.jsp";
        }
        String password = user.getPassword();
        System.out.println("should be unencrypted password: "+password);
        //need to log in
        if(userService.hasAdmin()){
            userService.saveWithUserRole(user);
        }else{
            userService.saveWithUserAdmin(user);
        }
        System.out.println("should be encrypted: "+user.getPassword());
        authenticateUser(user.getUsername(), password, request);

        return "redirect:/";
    }
    public void authenticateUser(String username, String password, HttpServletRequest request){

        UsernamePasswordAuthenticationToken token = new UsernamePasswordAuthenticationToken(username, password);
        request.getSession();
        token.setDetails(new WebAuthenticationDetails(request));
        Authentication authenticatedUser = authenticationManager.authenticate(token);
        SecurityContextHolder.getContext().setAuthentication(authenticatedUser);
    }
    @PostMapping("/users/addring")
    public String addRingtoUser(@RequestParam("user") Long id, @RequestParam("ring") Long ringId){
        User user = userService.findById(id);
        Ring ring = ringService.findById(ringId);
        ring.setOwner(user);
        ringService.saveRing(ring);
        return "redirect:/";
    }

}
