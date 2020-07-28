package com.lz.entity;

import com.lz.security.entity.inteface.RolePermissionEntityInterface;
import lombok.Data;

@Data
public class RolePermissionEntity implements RolePermissionEntityInterface {

    private Long roleId;
    private Long permissionId;
    private String roleName;
    private String roleEnname;
    private String permissionName;
    private String permissionEnName;
    private String permissionUrl;
}
