package com.lz.security.config;

import com.lz.security.AuthenticationAdapter;
import com.lz.security.service.RolePermissionSecurityService;
import com.lz.security.service.RoleSecurityService;
import com.lz.security.service.UserSecurityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class CustomConfig {

    @Autowired
    private RolePermissionSecurityService roleSecurityPermissionService;
    @Autowired
    private UserSecurityService userService;
    @Autowired
    private RoleSecurityService roleSecurityService;

    @Bean
    public AuthenticationAdapter authenticationDataSource() {
        AuthenticationAdapter authentication = AuthenticationAdapter.getInstance();
        authentication.rolePermissionService(roleSecurityPermissionService)
                .userService(userService)
                .roleService(roleSecurityService);
        return authentication;
    }
}
