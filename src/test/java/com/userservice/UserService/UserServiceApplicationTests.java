package com.userservice.UserService;

import com.userservice.UserService.Model.User;
import com.userservice.UserService.Repository.UserInterface;
import com.userservice.UserService.Security.Services.JpaRegisteredClientRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@SpringBootTest
class UserServiceApplicationTests {

    @Autowired
    JpaRegisteredClientRepository registeredClientRepository;

    @Autowired
    UserInterface userInterface;

    @Autowired
    private BCryptPasswordEncoder passwordEncoder;

    @Test
    void contextLoads() {
    }


//    @Test
//    public void registeredClientRepository() {
//        RegisteredClient oidcClient = RegisteredClient.withId(UUID.randomUUID().toString())
//                .clientId("oidc-client")
//                .clientSecret("$2a$12$ZvObba0QWv9WJfj.znG6uOaCLKdOvzYjj2kWG1P98IQAvEGf5Rmdq")
//                .clientAuthenticationMethod(ClientAuthenticationMethod.CLIENT_SECRET_BASIC)
//                .authorizationGrantType(AuthorizationGrantType.AUTHORIZATION_CODE)
//                .authorizationGrantType(AuthorizationGrantType.REFRESH_TOKEN)
//                .redirectUri("https://oauth.pstmn.io/v1/callback")
//                .postLogoutRedirectUri("https://oauth.pstmn.io/v1/callback")
//                .scope(OidcScopes.OPENID)
//                .scope(OidcScopes.PROFILE)
//                .scope("ADMIN")
//                .clientSettings(ClientSettings.builder().requireAuthorizationConsent(true).build())
//                .build();
//
//                registeredClientRepository.save(oidcClient);
//
//
//    }


//    @Test
//    public void Signup() {
//
//        String Password = "asdfg";
//
//        User user = new User();
//        user.setName("renuka");
//        user.setEmail("renuka@gmail.com");
//        user.setHashedPassword(passwordEncoder.encode(Password));
//        user.setEmailVerified(false);
//        user.setDeleted(false);
//        userInterface.save(user);
//    }

}
