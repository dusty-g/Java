package com.dusty.javabeltexam.controllers;

import com.dusty.javabeltexam.models.Guild;
import com.dusty.javabeltexam.models.User;
import com.dusty.javabeltexam.services.GuildService;
import com.dusty.javabeltexam.services.RingService;
import com.dusty.javabeltexam.services.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.security.Principal;
import java.util.Date;
import java.util.List;

@Controller
@RequestMapping("/admin")
public class AdminController {
    UserService userService;
    RingService ringService;
    GuildService guildService;
    public AdminController(UserService userService, RingService ringService, GuildService guildService){
        this.userService = userService;
        this.ringService = ringService;
        this.guildService = guildService;
    }
    @RequestMapping("/users/update/{id}")
    public String updateUserPage(Model model, @PathVariable("id") Long id){
        User user = userService.findById(id);
        String username = user.getUsername();
        System.out.println(username);
        model.addAttribute("id", user.getId());
        model.addAttribute("username", username);
        return "edituser.jsp";
    }
    @PostMapping("/users/update/{id}")
    public String updateUser(@PathVariable("id") Long id, @RequestParam("username") String username, Model model){
        User user = userService.findById(id);

        if(username.length()>2){
            user.setUsername(username);
            userService.saveUser(user);
        }else{
            //error message
            model.addAttribute("username", user.getUsername());
            return "edituser.jsp";
        }
        return "redirect:/admin/guilds/";
    }
    @PostMapping("/addplayer")
    public String addPlayerToGuild(@RequestParam("playerId") Long playerId, @RequestParam("guildId") Long guildId){
        User player = userService.findById(playerId);
        Guild guild = guildService.getById(guildId);
        List<User> users = guild.getUsers();
        if(!users.contains(player)){
            if(guild.getGuildSize()> users.size()){

                users.add(player);
                guild.setUsers(users);
                guildService.saveGuild(guild);
            }else{
                //guild full error message
            }
        }else{
            //user already in guild error message
        }
        return "redirect:/admin/guilds";

    }
    @PostMapping("/users/delete/{id}")
    public String deleteUser(@PathVariable("id") Long id){
        userService.deleteUser(id);
        return "redirect:/admin/guilds";
    }
    @PostMapping("/users/makeadmin/{id}")
    public String makeAdmin(@PathVariable("id") Long id){
        userService.makeAdmin(id);
        return "redirect:/admin/guilds";
    }
    @RequestMapping("/newring")
    public String newRingPage(){
        return "newring.jsp";
    }
    @RequestMapping("/guilds/{id}")
    public String getGuild(@PathVariable("id") Long id, Model model){
        Guild guild = guildService.getById(id);
        model.addAttribute("guild", guild);
        return "guild.jsp";
    }

    @PostMapping("/newring")
    public String createRing(@RequestParam("ringName") String ringName, Principal principal){
        if(principal == null){
            System.out.println("principal was null");
            return "newring.jsp";
        }
        System.out.println(principal.getName());
        String username = principal.getName();
        User admin = userService.findByUsername(username);
        if(admin == null){
            System.out.println("admin was null");
            return "newring.jsp";
        }
        if(ringName == null){
            System.out.println("ringname was null");
            return "newring.jsp";
        }
        if(ringName.length() > 2){

            ringService.createRing(ringName, admin);
//            System.out.println(ringName);
//            System.out.println(admin.getRoles().get(0).getName());
        }

        return "redirect:/";
    }
    @RequestMapping("/guilds")
    public String showGuilds(Model model, Principal principal){
        String username = principal.getName();
        Iterable<Guild> guilds = guildService.getAll();
        User admin = userService.findByUsername(username);
        model.addAttribute("currentUser", admin);
        model.addAttribute("guilds", guilds);
        Iterable<User> users = userService.getAll();
        model.addAttribute("users", users);
        model.addAttribute("now", new Date());
        return "guilds.jsp";
    }

    public static String calculateAge(Date createdAt){
        Date now = new Date();
        Long age = now.getTime()-createdAt.getTime();
        age = Math.floorDiv(age, 100*60*60*24);
        String days = age.toString();
        return days + " days";
    }
    @PostMapping("/newguild")
    public String createGuild(@RequestParam("name") String guildName, @RequestParam("size") Integer size){
        if(guildName.length()<3){
            return "redirect:/admin/guilds";
        }
        guildService.createGuild(guildName, size);
        return "redirect:/admin/guilds";
    }

}
