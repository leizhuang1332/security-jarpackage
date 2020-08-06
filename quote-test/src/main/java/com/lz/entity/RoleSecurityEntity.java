package com.lz.entity;

import com.lz.security.entity.inteface.RoleSecurityEntityInterface;
import lombok.Data;

@Data
public class RoleSecurityEntity implements RoleSecurityEntityInterface {

    private Long id;
    private Long parent_id;
    private String name;
    private String enname;
    private String description;
    private String created;
    private String updated;
}
