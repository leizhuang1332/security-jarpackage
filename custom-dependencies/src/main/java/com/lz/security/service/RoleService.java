package com.lz.security.service;

import com.lz.security.entity.RoleEntity;
import com.lz.security.mapper.RoleMapper;
import com.lz.security.service.inteface.RoleInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RoleService implements RoleInterface {

    @Autowired
    private RoleMapper roleMapper;

    @Override
    public List<RoleEntity> getByUserId(Long userId){
        return roleMapper.getByUserId(userId);
    }
}
