package com.lz.entity;

import com.lz.security.entity.inteface.UserSecurityEntityInterface;
import lombok.Data;

@Data
public class UserSecurityEntity implements UserSecurityEntityInterface {

    private Long id;
    private String username;
    private String password;
    private String phone;
    private String email;
    private String created;
    private String updated;
}
