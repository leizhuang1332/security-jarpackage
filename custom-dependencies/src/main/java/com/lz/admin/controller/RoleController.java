package com.lz.admin.controller;

import com.lz.admin.bean.TbRole;
import com.lz.admin.controller.base.BaseController;
import com.lz.admin.dto.UserRolesDto;
import com.lz.admin.service.RoleService;
import com.lz.admin.service.UserRoleService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.List;

/**
 * @author pzg
 * @date 2020/7/27
 * @description
 */

@Api(description = "角色管理接口")
@RestController
public class RoleController extends BaseController {
    @Autowired
    private RoleService roleService;
    @Autowired
    private UserRoleService userRoleService;


    @ApiOperation(value = "新增一个角色", notes = "提交角色信息", produces = "application/json")
    @ApiImplicitParam(name = "role", value = "角色对象", paramType = "body", required = true, dataType = "TbRole")
    @PostMapping("role/addOneRole")
    public String addOneRole(@RequestBody @Valid TbRole role) {
        int i = roleService.addOne(role);
        if (i > 0) {
            return success();
        }

        return failure(400, "新增角色失败");
    }


    @ApiOperation(value = "更新一个角色", notes = "提交角色信息", produces = "application/json")
    @ApiImplicitParam(name = "role", value = "角色对象", paramType = "body", required = true, dataType = "TbRole")
    @PostMapping("role/updateOneRole")
    public String updateOneRole(@RequestBody @Valid TbRole role) {
        int i = roleService.updateOne(role);
        if (i > 0) {
            return success();
        }
        return failure(400, "更新角色失败，角色信息可能已经存在");
    }


    @ApiOperation(value = "删除一个角色", notes = "根据roleId删除", produces = "application/json")
    @ApiImplicitParam(name = "roleId", value = "角色id", paramType = "query", required = true, dataType = "long")
    @GetMapping("role/delOneRole")
    public String delOneRole(long roleId) {
        int i = roleService.delOne(roleId);
        if (i > 0) {
            return success();
        }
        return failure(400, "删除角色失败");
    }


    @ApiOperation(value = "获取所有角色", notes = "获取系统所有角色信息", produces = "application/json")
    @GetMapping("role/getAllRole")
    public String getAllRole() {
        List<TbRole> list = roleService.getAll();
        return success(list);
    }


    @ApiOperation(value = "获取用户具有的角色", notes = "根据用户id获取", produces = "application/json")
    @ApiImplicitParam(name = "userId", value = "用户id", paramType = "query", required = true, dataType = "long")
    @GetMapping("role/listByUserId")
    public String listByUserId(long userId) {
        List<TbRole> list = roleService.listByUserId(userId);
        return success(list);
    }


    @ApiOperation(value = "更新用户具有的角色", notes = "根据用户id更新", produces = "application/json")
    @ApiImplicitParam(name = "userRoles", value = "用户角色关系",  paramType = "body", required = true, dataType = "UserRolesDto")
    @PostMapping("role/updateUserRoles")
    public String updateUserRoles(@RequestBody UserRolesDto userRoles) {
        boolean b = userRoleService.updateUserRoleRelation(userRoles.getUserId(), userRoles.getRoleIds());
        if (b) {
            return success();
        }
        return failure(400, "更新用户角色表失败");
    }


}
