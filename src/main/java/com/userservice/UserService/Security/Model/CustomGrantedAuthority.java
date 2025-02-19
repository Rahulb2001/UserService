package com.userservice.UserService.Security.Model;

import com.userservice.UserService.Model.Role;
import org.springframework.security.core.GrantedAuthority;

public class CustomGrantedAuthority implements GrantedAuthority {

    private String authority;

    public CustomGrantedAuthority(Role role) {
        authority = role.getName();
    }

    @Override
    public String getAuthority() {
        return authority;
    }
}
