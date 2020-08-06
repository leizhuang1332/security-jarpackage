package com.lz.entity;

import com.lz.security.entity.inteface.RolePermissionSecurityEntityInterface;
import lombok.Data;

@Data
public class RolePermissionSecurityEntity implements RolePermissionSecurityEntityInterface {

    private Long roleId;
    private Long permissionId;
    private String roleName;
    private String roleEnname;
    private String permissionName;
    private String permissionEnName;
    private String permissionUrl;
}
