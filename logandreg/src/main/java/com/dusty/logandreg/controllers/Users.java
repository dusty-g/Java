package com.dusty.logandreg.controllers;

import com.dusty.logandreg.models.Role;
import com.dusty.logandreg.models.User;
import com.dusty.logandreg.services.UserService;
import com.dusty.logandreg.validator.UserValidator;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;
import java.security.Principal;
import java.util.List;

@Controller
public class Users {
    private UserService userService;
    private UserValidator userValidator;
    public Users(UserService userService, UserValidator userValidator){
        this.userService = userService;
        this.userValidator = userValidator;
    }
    @RequestMapping("/")
    public String home(@ModelAttribute("user") User user, Principal principal, Model model){
        String username = principal.getName();
        model.addAttribute("currentUser", userService.findByUsername(username));
        return "testpage.jsp";
    }
    @PostMapping("/registration")
    public String registerForm(@Valid @ModelAttribute("user") User user, BindingResult result, Model model, HttpSession session){
        userValidator.validate(user, result);
        if(result.hasErrors()){
            return "home.jsp";
        }
        //check if admin exists
        if(userService.isAdmin()){
            userService.saveWithUserRole(user);
        }else{
            userService.saveWithUserAdmin(user);
        }
        return "redirect:/login";
    }
    @RequestMapping("/test")
    public String test(Principal principal, Model model, HttpSession session){
        String username = principal.getName();
        System.out.println(username);

        model.addAttribute("currentUser", userService.findByUsername(username));
        System.out.println(userService.findByUsername(username));
        return "testpage.jsp";
    }
    @RequestMapping("/login")
    public String loginpage(@ModelAttribute("user") User user, @RequestParam(value = "error", required = false) String error, @RequestParam(value = "logout", required = false) String logout, BindingResult result, Model model, HttpSession session){
        if(error != null){
            model.addAttribute("errorMessage", "invalid credentials");
        }
        if(logout !=null){
            model.addAttribute("logoutMessage", "logout successful");
        }

        return "home.jsp";

    }
    @RequestMapping("/admin")
    public String admin(Principal principal, Model model){
        String username = principal.getName();
        Iterable<User> users = userService.allUsers();
        Role admin = userService.findRoleByName("ROLE_ADMIN");
        model.addAttribute("allUsers", users);
        model.addAttribute("adminRole", admin);
        model.addAttribute("currentUser", userService.findByUsername(username));
        return "admin.jsp";
    }
    @PostMapping("/users/delete/{id}")
    public String deleteUser(@PathVariable("id") Long id){
        userService.deleteUser(id);
        return "redirect:/admin";
    }
    @PostMapping("/users/makeadmin/{id}")
    public String makeUserAdmin(@PathVariable("id") Long id){
        User user = userService.getUserById(id);
        userService.makeUserAdmin(user);
        return "redirect:/admin";
    }
}
