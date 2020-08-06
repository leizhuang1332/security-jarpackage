package com.lz.admin.dto;

import lombok.Data;

import java.util.List;

/**
 * @author pzg
 * @date 2020/8/5
 * @description 角色权限dto
 */
@Data
public class RolePermissionsDto {

    private Long roleId;
    private List<Long> permissionIds;
}
