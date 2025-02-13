package com.userservice.UserService.Service;


import com.userservice.UserService.Exception.UserException;
import com.userservice.UserService.Model.Token;
import com.userservice.UserService.Model.User;
import com.userservice.UserService.Repository.TokenInterface;
import com.userservice.UserService.Repository.UserInterface;
import org.apache.commons.lang3.RandomStringUtils;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;
import java.util.Optional;

@Service
public class UserService {

    private UserInterface userInterface;
    private BCryptPasswordEncoder passwordEncoder;
    private TokenInterface tokenInterface;


    public UserService(UserInterface userInterface,BCryptPasswordEncoder passwordEncoder,TokenInterface tokenInterface) {
        this.userInterface = userInterface;
        this.passwordEncoder = passwordEncoder;
        this.tokenInterface=tokenInterface;

    }

    public User Signup(String name,String email,String password) {
        User user = new User();
        user.setName(name);
        user.setEmail(email);
        user.setHashedPassword(passwordEncoder.encode(password));
        user.setEmailVerified(false);
        return userInterface.save(user);
    }

    public Token Login(String email,String password)  {

        //find if user exist;
        Optional<User> userfound = userInterface.findByemail(email);

        if(userfound.isEmpty()) {
            throw new UserException("User not found");
        }

        User user=userfound.get();

        if(!passwordEncoder.matches(password,user.getHashedPassword())) {
            throw new UserException("Invalid Password");
        }

        Token token=generateToken(user);

        Token SetToken=tokenInterface.save(token);

        return token;

    }

    private Token generateToken(User user) {
        LocalDate currentDate = LocalDate.now();
        LocalDate thirtyDaysLater = currentDate.plusDays(30);

        Date expiryDate = Date.from(thirtyDaysLater.atStartOfDay(ZoneId.systemDefault()).toInstant());
        Token token = new Token();
        token.setValue(RandomStringUtils.randomAlphanumeric(128));
        token.setUser(user);
        token.setDeleted(false);
        token.setExpiryAt(expiryDate);
        return tokenInterface.save(token);

    }

    public void logout(String token){

        Optional<Token> optionaltoken = tokenInterface.getByValueAndIsDeleted(token,false);
        if(optionaltoken.isEmpty()){
            throw new UserException("Token not found");
        }

        Token token1=optionaltoken.get();
        token1.setDeleted(true);
        tokenInterface.save(token1);

    }

    public User validateToken(String token) {
        Optional<Token> tokenfound=  tokenInterface.getByValueAndIsDeletedAndExpiryAtGreaterThan(token,false,new Date());

  //      Optional<Token> tokenfound=  tokenInterface.getByValue(token);

        if(tokenfound.isEmpty()){
          throw new UserException("Token not found");
      }

      Token token1=tokenfound.get();

      return token1.getUser();
    }
}
