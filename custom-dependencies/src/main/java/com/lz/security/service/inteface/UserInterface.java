package com.lz.security.service.inteface;

import com.lz.security.entity.inteface.UserEntityInterface;

public interface UserInterface {

    UserEntityInterface getByUsername(String username);
}
