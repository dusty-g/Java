package com.dusty.javabeltexam.validator;

import com.dusty.javabeltexam.models.User;
import com.dusty.javabeltexam.services.UserService;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

@Component
public class UserValidator implements Validator{
    @Override
    public boolean supports(Class<?> clazz){return User.class.equals(clazz);}
    UserService userService;
    public UserValidator(UserService userService){
        this.userService = userService;
    }
    @Override
    public void validate(Object object, Errors errors){
        User user = (User) object;
        if(!user.getPasswordConfirmation().equals(user.getPassword())){
            errors.rejectValue("passwordConfirmation", "Match");
        }
        String username = user.getUsername();
        User dbUser = userService.findByUsername(username);
        if(dbUser !=null){
            errors.rejectValue("username", "Duplicate");
        }
        String email = user.getEmail();
        dbUser = userService.findByEmail(email);
        if(dbUser != null){
            errors.rejectValue("email", "Duplicate");
        }

    }

}
