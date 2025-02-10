package com.userservice.UserService.Controller;


import com.userservice.UserService.DTO.SignupRequestDTO;
import com.userservice.UserService.DTO.UserDTO;
import com.userservice.UserService.Model.User;
import com.userservice.UserService.Service.UserService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user")
public class UserController {

    UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/signup")
    public UserDTO signup(@RequestBody SignupRequestDTO signupRequestDTO) {
        User user = userService.Signup(
                signupRequestDTO.getName(),
                signupRequestDTO.getEmail(),
                signupRequestDTO.getPassword()
        );

        return UserDTO.fromEntity(user);
    }
}
