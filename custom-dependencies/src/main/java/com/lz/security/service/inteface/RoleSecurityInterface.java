package com.lz.security.service.inteface;

import com.lz.security.entity.inteface.RoleSecurityEntityInterface;

import java.util.List;

public interface RoleSecurityInterface {

    List<? extends RoleSecurityEntityInterface> getByUserId(Long userId);
}
