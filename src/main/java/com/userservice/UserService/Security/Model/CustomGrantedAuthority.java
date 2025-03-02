package com.userservice.UserService.Security.Model;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.userservice.UserService.Model.Role;
import org.springframework.security.core.GrantedAuthority;


@JsonDeserialize
public class CustomGrantedAuthority implements GrantedAuthority {

    public CustomGrantedAuthority() {
    }

    private String authority;

    public CustomGrantedAuthority(Role role) {
        authority = role.getName();
    }

    @Override
    public String getAuthority() {
        return authority;
    }


}
