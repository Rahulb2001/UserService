package com.userservice.UserService.Repository;

import com.userservice.UserService.Model.Token;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.Optional;

@Repository
public interface TokenInterface extends JpaRepository<Token,Long> {



    Optional<Token> getByValueAndIsDeleted(String token, boolean b);

    Optional<Token> getByValueAndIsDeletedAndExpiryAtGreaterThan(String token, boolean b, Date date);

    Optional<Token> getByValue(String token);
}
