package com.lz.mapper;

import com.lz.entity.UserSecurityEntity;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface UserMapper {

    UserSecurityEntity getByUsername(@Param("username") String username);
}
