package com.userservice.UserService.Controller;


import com.userservice.UserService.DTO.LoginRequestDTO;
import com.userservice.UserService.DTO.LogoutRequest;
import com.userservice.UserService.DTO.SignupRequestDTO;
import com.userservice.UserService.DTO.UserDTO;
import com.userservice.UserService.Exception.UserException;
import com.userservice.UserService.Model.Token;
import com.userservice.UserService.Model.User;
import com.userservice.UserService.Service.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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

    @PostMapping("/login")
    public Token Login(@RequestBody LoginRequestDTO loginRequestDTO)  {

       Token token=userService.Login(loginRequestDTO.getEmail(),loginRequestDTO.getPassword());

        return token;
    }

    @PostMapping("/logout")
    public ResponseEntity<Void> Logout(@RequestBody LogoutRequest logoutRequest)  {
        userService.logout(logoutRequest.getToken());
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping("/validate/{token}")
    public UserDTO validateToken(@PathVariable("token") String token)  {
        User user=userService.validateToken(token);
        return UserDTO.fromEntity(user);
    }
}
