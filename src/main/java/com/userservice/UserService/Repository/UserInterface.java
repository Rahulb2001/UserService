package com.userservice.UserService.Repository;

import com.userservice.UserService.Model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;


@Repository
public interface UserInterface extends JpaRepository<User,Long> {


    Optional<User> findByemail(String email);
}
