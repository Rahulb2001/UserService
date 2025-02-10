package com.userservice.UserService.Repository;

import com.userservice.UserService.Model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface UserInterface extends JpaRepository<User,Long> {
}
