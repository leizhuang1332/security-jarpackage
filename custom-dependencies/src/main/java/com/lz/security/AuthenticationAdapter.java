package com.lz.security;

import com.lz.security.service.inteface.RoleSecurityInterface;
import com.lz.security.service.inteface.RolePermissionSecurityInterface;
import com.lz.security.service.inteface.UserSecurityInterface;

public class AuthenticationAdapter {

    private static AuthenticationAdapter authenticationAdapter;

    private final static Object lock = new Object();

    private AuthenticationAdapter() {
    }

    private RolePermissionSecurityInterface rolePermissionService;

    public AuthenticationAdapter rolePermissionService(RolePermissionSecurityInterface rolePermissionService) {
        this.rolePermissionService = rolePermissionService;
        return this;
    }

    public RolePermissionSecurityInterface getRolePermissionService() {
        return this.rolePermissionService;
    }

    private UserSecurityInterface userService;

    public AuthenticationAdapter userService(UserSecurityInterface userService) {
        this.userService = userService;
        return this;
    }

    public UserSecurityInterface getUserService() {
        return this.userService;
    }

    private RoleSecurityInterface roleService;

    public AuthenticationAdapter roleService(RoleSecurityInterface roleService) {
        this.roleService = roleService;
        return this;
    }

    public RoleSecurityInterface getRoleService() {
        return this.roleService;
    }

    public static AuthenticationAdapter getInstance() {
        if (authenticationAdapter == null) {
            synchronized (lock) {
                if (authenticationAdapter == null) {
                    authenticationAdapter = new AuthenticationAdapter();
                }
            }
        }
        return authenticationAdapter;
    }
}
