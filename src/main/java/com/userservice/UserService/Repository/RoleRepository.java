package com.userservice.UserService.Repository;

import com.userservice.UserService.Model.Role;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoleRepository extends JpaRepository<Role, Long> {
}
