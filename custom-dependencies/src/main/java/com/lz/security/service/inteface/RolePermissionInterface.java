package com.lz.security.service.inteface;

import com.lz.security.entity.RolePermissionEntityInterface;

import java.util.List;

public interface RolePermissionInterface {

    List<? extends RolePermissionEntityInterface> getAll();
}
