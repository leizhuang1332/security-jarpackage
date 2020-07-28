package com.lz.entity;

import com.lz.security.entity.inteface.UserEntityInterface;
import lombok.Data;

@Data
public class UserEntity implements UserEntityInterface {

    private Long id;
    private String username;
    private String password;
    private String phone;
    private String email;
    private String created;
    private String updated;
}
