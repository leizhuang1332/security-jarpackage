package com.lz.config;

import com.lz.security.AuthenticationAdapter;
import com.lz.service.RolePermissionSecurityService;
import com.lz.service.RoleSecurityService;
import com.lz.service.UserSecurityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;

//@Configuration
public class CustomConfig {

    @Autowired
    private RolePermissionSecurityService rolePermissionService;
    @Autowired
    private UserSecurityService userService;
    @Autowired
    private RoleSecurityService roleService;

    @Bean
    public AuthenticationAdapter authenticationDataSource() {
        AuthenticationAdapter authentication = AuthenticationAdapter.getInstance();
        authentication.rolePermissionService(rolePermissionService)
                .userService(userService)
                .roleService(roleService);
        return authentication;
    }
}
