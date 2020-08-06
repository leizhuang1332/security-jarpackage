package com.lz.admin.controller;

import com.lz.admin.bean.TbPermission;
import com.lz.admin.bean.TbRole;
import com.lz.admin.bean.TbUser;
import com.lz.admin.controller.base.BaseController;
import com.lz.admin.dto.RoleCompleteDto;
import com.lz.admin.dto.UserCompleteDto;
import com.lz.admin.service.PermissionService;
import com.lz.admin.service.RoleService;
import com.lz.admin.service.UserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;

/**
 * @author pzg
 * @date 2020/7/27
 * @description
 */

@Api(description = "用户管理接口")
@RestController
public class UserController extends BaseController {
    @Autowired
    private UserService userService;
    @Autowired
    private RoleService roleService;
    @Autowired
    private PermissionService permissionService;

    @ApiOperation(value = "新增一个用户", notes = "提交用户信息", produces = "application/json")
    @ApiImplicitParam(name = "user", value = "用户对象", paramType = "body",required = true, dataType = "TbUser")
    @PostMapping("user/addOneUser")
    public String addOneUser(  @RequestBody @Valid TbUser user) {
        int i = userService.addOne(user);
        if (i > 0) {
            return success();
        }
        return failure(400,"新增用户失败");
    }


    @ApiOperation(value = "更新一个用户", notes = "提交用户信息", produces = "application/json")
    @ApiImplicitParam(name = "user", value = "用户对象", paramType = "body",required = true, dataType = "TbUser")
    @PostMapping("user/updateOneUser")
    public String updateOneUser(@RequestBody @Valid TbUser user) {
        int i = userService.updateOne(user);
        if (i > 0) {
            return success();
        }
        return failure(400,"更新用户失败,用户信息可能已经存在");
    }


    @ApiOperation(value = "删除一个用户", notes = "根据用户id删除", produces = "application/json")
    @ApiImplicitParam(name = "userId", value = "用户id", paramType = "query",required = true, dataType = "long")
    @GetMapping("user/delOneUser")
    public String delOneUser(long userId) {
        int i = userService.delOne(userId);
        if (i > 0) {
            return success();
        }
        return failure(400,"删除用户失败");
    }


    @ApiOperation(value = "获取所有用户", notes = "获取系统所有用户信息(包括角色和权限信息)", produces = "application/json")
    @GetMapping("user/getAllUser")
    public String getAllUser() {
        List<UserCompleteDto> userCompleteDtos = new ArrayList<>();

        List<TbUser> list = userService.getAll();
        list.forEach( user -> {
            UserCompleteDto userCompleteDto = new UserCompleteDto(user);
            List<RoleCompleteDto> roleCompleteDtos = new ArrayList<>();
            List<TbRole> roles = roleService.listByUserId(user.getId());
            roles.forEach( role -> {
                if(null != role){
                    RoleCompleteDto roleCompleteDto = new RoleCompleteDto(role);
                    List<TbPermission> tbPermissions = permissionService.listByRoleId(role.getId());
                    roleCompleteDto.setTbPermissions(tbPermissions);
                    roleCompleteDtos.add(roleCompleteDto);
                }

            });

            userCompleteDto.setRoleCompleteDtos(roleCompleteDtos);
            userCompleteDtos.add(userCompleteDto);
        });

        return success(userCompleteDtos);
    }


    @ApiOperation(value = "查询用户详情", notes = "根据用户id查询一个用户详情", produces = "application/json")
    @ApiImplicitParam(name = "userId", value = "用户id", paramType = "query",required = true, dataType = "long")
    @GetMapping("user/getOneUser")
    public String getOneUser(long userId){
        TbUser user = userService.getOneUser(userId);

        UserCompleteDto userCompleteDto = new UserCompleteDto(user);
        List<RoleCompleteDto> roleCompleteDtos = new ArrayList<>();
        List<TbRole> roles = roleService.listByUserId(user.getId());
        roles.forEach( role -> {
            if(null != role){
                RoleCompleteDto roleCompleteDto = new RoleCompleteDto(role);
                List<TbPermission> tbPermissions = permissionService.listByRoleId(role.getId());
                roleCompleteDto.setTbPermissions(tbPermissions);
                roleCompleteDtos.add(roleCompleteDto);
            }

        });

        userCompleteDto.setRoleCompleteDtos(roleCompleteDtos);

        return success(userCompleteDto);
    }


}
