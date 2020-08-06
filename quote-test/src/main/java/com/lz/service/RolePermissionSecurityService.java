package com.lz.service;

import com.lz.entity.RolePermissionSecurityEntity;
import com.lz.mapper.RolePermissionMapper;
import com.lz.security.service.inteface.RolePermissionSecurityInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RolePermissionSecurityService implements RolePermissionSecurityInterface {

    @Autowired
    private RolePermissionMapper rolePermissionMapper;

    @Override
    public List<RolePermissionSecurityEntity> getAll() {
        return rolePermissionMapper.getAll();
    }
}
