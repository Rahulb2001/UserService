package com.userservice.UserService.Service;


import com.userservice.UserService.Model.User;
import com.userservice.UserService.Repository.UserInterface;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    private UserInterface userInterface;
    private BCryptPasswordEncoder passwordEncoder;


    public UserService(UserInterface userInterface,BCryptPasswordEncoder passwordEncoder) {
        this.userInterface = userInterface;
        this.passwordEncoder = passwordEncoder;

    }

    public User Signup(String name,String email,String password) {
        User user = new User();
        user.setName(name);
        user.setEmail(email);
        user.setHashedPassword(passwordEncoder.encode(password));
        user.setEmailVerified(false);
        return userInterface.save(user);
    }
}
