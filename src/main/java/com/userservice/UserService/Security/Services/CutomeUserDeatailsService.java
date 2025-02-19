package com.userservice.UserService.Security.Services;

import com.userservice.UserService.Model.User;
import com.userservice.UserService.Repository.UserInterface;
import com.userservice.UserService.Security.Model.CustomUserDetails;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CutomeUserDeatailsService implements UserDetailsService {

    UserInterface userInterface;

    CutomeUserDeatailsService(UserInterface userInterface){
        this.userInterface = userInterface;
    }


    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        Optional<User> user = userInterface.findByemail(username);

        if(user.isEmpty()){
            throw  new UsernameNotFoundException("User not found");
        }

        CustomUserDetails customUserDetails=new CustomUserDetails(user.get());

        return customUserDetails;

    }
}
