package com.lz.entity;

import com.lz.security.entity.inteface.RoleEntityInterface;
import lombok.Data;

@Data
public class RoleEntity implements RoleEntityInterface {

    private Long id;
    private Long parent_id;
    private String name;
    private String enname;
    private String description;
    private String created;
    private String updated;
}
