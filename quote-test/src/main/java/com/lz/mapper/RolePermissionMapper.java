package com.lz.mapper;

import com.lz.entity.RolePermissionSecurityEntity;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RolePermissionMapper {
    List<RolePermissionSecurityEntity> getAll();
}
