package com.dusty.belt2.controllers;

import com.dusty.belt2.models.Plan;
import com.dusty.belt2.models.Subscription;
import com.dusty.belt2.models.User;
import com.dusty.belt2.services.PlanService;
import com.dusty.belt2.services.SubscriptionService;
import com.dusty.belt2.services.UserService;
import com.dusty.belt2.validator.UserValidator;
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
import java.util.ArrayList;
import java.util.Date;

@Controller
public class Users {
    UserService userService;
    PlanService planService;
    SubscriptionService subscriptionService;
    UserValidator userValidator;
    public Users(UserService userService, UserValidator userValidator, PlanService planService, SubscriptionService subscriptionService){
        this.planService = planService;
        this.subscriptionService = subscriptionService;
        this.userService = userService;
        this.userValidator = userValidator;
    }

    @Autowired
    protected AuthenticationManager authenticationManager;

    @RequestMapping("/login")
    public String loginPage(@ModelAttribute("user") User user, Model model, @RequestParam(value = "error", required = false) String error, @RequestParam(value = "logout", required = false) String logout){
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
        Boolean admin = false;
        if(result.hasErrors()){
            return "home.jsp";
        }
        String password = user.getPassword();
        //need to log in
        if(userService.hasAdmin()){
            userService.saveWithUserRole(user);
        }else{
            userService.saveWithUserAdmin(user);
            admin = true;

        }
        System.out.println("should be encrypted: "+user.getPassword());
        authenticateUser(user.getUsername(), password, request);
        if(admin){
            return "redirect:/admin";
        }
        return "redirect:/selection";
    }
    public void authenticateUser(String username, String password, HttpServletRequest request){

        UsernamePasswordAuthenticationToken token = new UsernamePasswordAuthenticationToken(username, password);
        request.getSession();
        token.setDetails(new WebAuthenticationDetails(request));
        Authentication authenticatedUser = authenticationManager.authenticate(token);
        SecurityContextHolder.getContext().setAuthentication(authenticatedUser);
    }
    @RequestMapping("/admin")
    public String adminPage(Model model, Principal principal){
        String username = principal.getName();
        Integer[] monthLengths = {31,28,31,30,31,30,31,31,30,31,30,31};
        model.addAttribute("monthLengths", monthLengths);
        Date today = new Date();
        model.addAttribute("today", today);
        User admin = userService.findByUsername(username);
        model.addAttribute("admin", admin);
        //get all customers
        Iterable<User> users = userService.getNonAdmins();
        model.addAttribute("users", users);

        Iterable<Plan> plans = planService.getAll();
        model.addAttribute("plans", plans);
        return "admin.jsp";

    }

    @RequestMapping("/profile")
    public String profilePage(Model model, Principal principal){
        Date today = new Date();
        String username = principal.getName();
        User user = userService.findByUsername(username);
        if(user.getRoles().get(0).getName().equals("ROLE_ADMIN")){
            return "redirect:/admin";
        }
        if(user.getSubscription() == null){
            return "redirect:/selection";
        }
        model.addAttribute("today", today);
        model.addAttribute("user", user);
        return "profile.jsp";
    }
    @RequestMapping("/selection")
    public String selectionPage(Model model, Principal principal){
        String username = principal.getName();
        User user = userService.findByUsername(username);
        model.addAttribute("user", user);
        Iterable<Plan> plans = planService.getAvailable();
        System.out.println(plans);
        ArrayList<Integer> days = new ArrayList<>();
        for(int i = 1; i<32; i++){
            days.add(i);
        }
        model.addAttribute("days", days);
        model.addAttribute("plans", plans);
        return "selection.jsp";
    }
    @PostMapping("/admin/plan/new")
    public String createPlan(@RequestParam("packageName") String packageName, @RequestParam("price") Double price){
        if(packageName.length()<3){
            return "redirect:/admin";
        }
        if(price < 1){
            return "redirect:/admin";
        }



        Plan plan = new Plan(packageName, price);
        planService.save(plan);
        return "redirect:/admin";

    }
    @PostMapping("/selection")
    public String createSubscription(Principal principal, @RequestParam("plan") Long planId, @RequestParam("due") Integer due){
        String username = principal.getName();
        User user = userService.findByUsername(username);
        if(planId.equals("")){
            return "redirect:/selection";
        }
        Plan plan = planService.getById(planId);

        Subscription subscription = new Subscription(plan, user, due);
        subscriptionService.save(subscription);
        return "redirect:/profile";
    }
    @RequestMapping("/admin/activate/{id}")
    public String activatePlan(@PathVariable("id") Long id){
        Plan plan = planService.getById(id);
        plan.setAvailable(true);
        planService.save(plan);
        return "redirect:/admin";
    }
    @RequestMapping("/admin/deactivate/{id}")
    public String deactivatePlan(@PathVariable("id") Long id){
        Plan plan = planService.getById(id);
        plan.setAvailable(false);
        planService.save(plan);
        return "redirect:/admin";
    }
    @RequestMapping("/admin/delete/{id}")
    public String deletePlan(@PathVariable("id") Long id){

        planService.delete(id);
        return "redirect:/admin";
    }
}
