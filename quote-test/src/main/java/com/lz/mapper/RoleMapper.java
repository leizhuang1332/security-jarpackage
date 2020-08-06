package com.lz.mapper;

import com.lz.entity.RoleSecurityEntity;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RoleMapper {
    List<RoleSecurityEntity> getByUserId(@Param("userId") Long userId);
}
