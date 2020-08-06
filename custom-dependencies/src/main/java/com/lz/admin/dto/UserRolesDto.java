package com.lz.admin.dto;

import lombok.Data;

import java.util.List;

/**
 * @author pzg
 * @date 2020/8/5
 * @description 用户角色dto
 */
@Data
public class UserRolesDto {
    private Long userId;
    private List<Long> roleIds;

}
