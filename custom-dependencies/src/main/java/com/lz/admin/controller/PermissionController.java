package com.lz.admin.controller;

import com.lz.admin.bean.TbPermission;
import com.lz.admin.controller.base.BaseController;
import com.lz.admin.dto.RolePermissionsDto;
import com.lz.security.Bootstrapper;
import com.lz.admin.service.PermissionService;
import com.lz.admin.service.RolePermissionService;
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

@Api(description = "权限管理接口")
@RestController
public class PermissionController extends BaseController {
    @Autowired
    private PermissionService permissionService;
    @Autowired
    private RolePermissionService rolePermissionService;
    @Autowired
    private Bootstrapper bootstrapper;


    @ApiOperation(value = "新增一个权限", notes = "提交权限信息", produces = "application/json")
    @ApiImplicitParam(name = "permission", value = "权限对象", paramType = "body", required = true, dataType = "TbPermission")
    @PostMapping("permission/addOnePermission")
    public String addOnePermission(@RequestBody @Valid TbPermission permission) {
        int i = permissionService.addOne(permission);
        if (i > 0) {
            return success();
        }
        return failure(400, "新增权限失败");
    }


    @ApiOperation(value = "更新一个权限", notes = "提交权限信息", produces = "application/json")
    @ApiImplicitParam(name = "permission", value = "权限对象", paramType = "body", required = true, dataType = "TbPermission")
    @PostMapping("permission/updateOnePermission")
    public String updateOnePermission(@RequestBody @Valid TbPermission permission) {
        int i = permissionService.updateOne(permission);
        if (i > 0) {
            return success();
        }
        return failure(400, "更新权限失败，权限信息可能已经存在");
    }


    @ApiOperation(value = "删除一个权限", notes = "根据权限id删除", produces = "application/json")
    @ApiImplicitParam(name = "permissionId", value = "权限id", paramType = "query", required = true, dataType = "long")
    @GetMapping("permission/delOnePermission")
    public String delOnePermission(long permissionId) {
        int i = permissionService.delOne(permissionId);
        if (i > 0) {
            return success();
        }
        return failure(400, "删除权限失败");
    }


    @ApiOperation(value = "获取所有权限", notes = "获取系统所有权限信息", produces = "application/json")
    @GetMapping("permission/getAllPermission")
    public String getAllPermission() {
        List<TbPermission> list = permissionService.getAll();
        return success(list);
    }


    @ApiOperation(value = "获取角色具有的权限", notes = "根据角色id获取", produces = "application/json")
    @ApiImplicitParam(name = "roleId", value = "角色id", paramType = "query", required = true, dataType = "long")
    @GetMapping("permission/listByRoleId")
    public String listByRoleId(long roleId) {
        List<TbPermission> list = permissionService.listByRoleId(roleId);
        return success(list);
    }


    @ApiOperation(value = "获取用户具有的权限", notes = "根据用户id获取", produces = "application/json")
    @ApiImplicitParam(name = "userId", value = "用户id", paramType = "query", required = true, dataType = "long")
    @GetMapping("permission/listByUserId")
    public String listByUserId(long userId) {
        List<TbPermission> list = permissionService.listByUserId(userId);
        return success(list);
    }


    @ApiOperation(value = "更新角色权限对应关系", notes = "根据角色id更新", produces = "application/json")
    @ApiImplicitParam(name = "rolePermissions", value = "角色权限关系",  paramType = "body", required = true, dataType = "RolePermissionsDto")
    @PostMapping("permission/updateRolePermissions")
    public String updateRolePermissions(@RequestBody RolePermissionsDto rolePermissions) {
        boolean b = rolePermissionService.updateRolePermissionRelation(rolePermissions.getRoleId(), rolePermissions.getPermissionIds());
        if (b) {
            bootstrapper.loadAuthority();
            return success();
        }
        return failure(400, "更新角色权限对应关系失败");
    }


}
