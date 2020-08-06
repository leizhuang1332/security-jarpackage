package com.lz.security.service.inteface;

import com.lz.security.entity.inteface.RolePermissionSecurityEntityInterface;

import java.util.List;

public interface RolePermissionSecurityInterface {

    List<? extends RolePermissionSecurityEntityInterface> getAll();
}
