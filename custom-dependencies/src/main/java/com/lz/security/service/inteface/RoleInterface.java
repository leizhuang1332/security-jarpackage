package com.lz.security.service.inteface;

import com.lz.security.entity.RoleEntityInterface;

import java.util.List;

public interface RoleInterface {

    List<? extends RoleEntityInterface> getByUserId(Long userId);
}
