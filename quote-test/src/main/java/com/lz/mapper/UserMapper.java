package com.lz.mapper;

import com.lz.entity.UserEntity;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface UserMapper {

    UserEntity getByUsername(@Param("username") String username);
}
