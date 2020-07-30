package com.lz.service;

import com.lz.entity.UserSecurityEntity;
import com.lz.mapper.UserMapper;
import com.lz.security.service.inteface.UserSecurityInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserSecurityService implements UserSecurityInterface {

    @Autowired
    private UserMapper userMapper;

    @Override
    public UserSecurityEntity getByUsername(String username) {
        return userMapper.getByUsername(username);
    }
}
