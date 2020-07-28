package com.lz.security.service;

import com.lz.security.entity.UserEntity;
import com.lz.security.mapper.UserMapper;
import com.lz.security.service.inteface.UserInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService implements UserInterface {

    @Autowired
    private UserMapper userMapper;

    @Override
    public UserEntity getByUsername(String username) {
        return userMapper.getByUsername(username);
    }
}
