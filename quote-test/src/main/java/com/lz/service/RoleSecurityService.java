package com.lz.service;

import com.lz.entity.RoleSecurityEntity;
import com.lz.mapper.RoleMapper;
import com.lz.security.service.inteface.RoleSecurityInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RoleSecurityService implements RoleSecurityInterface {

    @Autowired
    private RoleMapper roleMapper;

    @Override
    public List<RoleSecurityEntity> getByUserId(Long userId){
        return roleMapper.getByUserId(userId);
    }
}
