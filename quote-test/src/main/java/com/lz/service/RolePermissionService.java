package com.lz.service;

import com.lz.entity.RolePermissionEntity;
import com.lz.mapper.RolePermissionMapper;
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
