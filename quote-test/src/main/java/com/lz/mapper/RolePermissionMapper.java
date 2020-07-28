package com.lz.mapper;

import com.lz.entity.RolePermissionEntity;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RolePermissionMapper {
    List<RolePermissionEntity> getAll();
}
