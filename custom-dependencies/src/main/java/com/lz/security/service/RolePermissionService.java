package com.lz.security.service;

import com.lz.security.entity.RolePermissionEntity;
import com.lz.security.mapper.RolePermissionMapper;
import com.lz.security.service.inteface.RolePermissionInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RolePermissionService implements RolePermissionInterface {

    @Autowired
    private RolePermissionMapper rolePermissionMapper;

    @Override
    public List<RolePermissionEntity> getAll() {
        return rolePermissionMapper.getAll();
    }
}
