package com.lz.config;

import com.lz.security.AuthenticationAdapter;
import com.lz.service.RolePermissionService;
import com.lz.service.RoleService;
import com.lz.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

//@Configuration
public class CustomConfig {

    @Autowired
    private RolePermissionService rolePermissionService;
    @Autowired
    private UserService userService;
    @Autowired
    private RoleService roleService;

    @Bean
    public AuthenticationAdapter authenticationDataSource() {
        AuthenticationAdapter authentication = AuthenticationAdapter.getInstance();
        authentication.rolePermissionService(rolePermissionService)
                .userService(userService)
                .roleService(roleService);
        return authentication;
    }
}
