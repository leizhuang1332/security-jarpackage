package com.lz.admin.dto;

import com.lz.admin.bean.TbUser;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.List;

/**
 * @author pzg
 * @date 2020/8/4
 * @description 用户详情dto
 */
@Data
public class UserCompleteDto {
    private Long id;

    @ApiModelProperty(value = "用户名")
    private String username;

    @ApiModelProperty(value = "密码，加密存储")
    private String password;

    @ApiModelProperty(value = "注册手机号")
    private String phone;

    @ApiModelProperty(value = "注册邮箱")
    private String email;

    private String created;

    private String updated;

    private static final long serialVersionUID = 1L;

    private List<RoleCompleteDto> roleCompleteDtos;

    public UserCompleteDto(TbUser tbUser){
        this.id = tbUser.getId();
        this.username = tbUser.getUsername();
        this.password = tbUser.getPassword();
        this.phone = tbUser.getPhone();
        this.email = tbUser.getEmail();
        this.created = tbUser.getCreated();
        this.updated = tbUser.getUpdated();
    }
    public UserCompleteDto(){
        super();
    }


}
