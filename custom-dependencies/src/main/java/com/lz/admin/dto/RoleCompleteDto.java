package com.lz.admin.dto;

import com.lz.admin.bean.TbPermission;
import com.lz.admin.bean.TbRole;
import io.swagger.annotations.ApiModelProperty;

import java.util.List;

/**
 * @author pzg
 * @date 2020/8/4
 * @description 角色详情dto
 */

public class RoleCompleteDto {

    private Long id;

    @ApiModelProperty(value = "父角色")
    private Long parentId;

    @ApiModelProperty(value = "角色名称")
    private String name;

    @ApiModelProperty(value = "角色英文名称")
    private String enname;

    @ApiModelProperty(value = "备注")
    private String description;

    private String created;

    private String updated;

    private static final long serialVersionUID = 1L;

    private List<TbPermission> tbPermissions;

    public RoleCompleteDto(TbRole tbRole){
        this.id = tbRole.getId();
        this.parentId = tbRole.getParentId();
        this.name = tbRole.getName();
        this.enname = tbRole.getEnname();
        this.description = tbRole.getDescription();
        this.created = tbRole.getCreated();
        this.updated = tbRole.getUpdated();
    }

    public RoleCompleteDto(){
        super();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getParentId() {
        return parentId;
    }

    public void setParentId(Long parentId) {
        this.parentId = parentId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEnname() {
        return enname;
    }

    public void setEnname(String enname) {
        this.enname = enname;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getCreated() {
        return created;
    }

    public void setCreated(String created) {
        this.created = created;
    }

    public String getUpdated() {
        return updated;
    }

    public void setUpdated(String updated) {
        this.updated = updated;
    }

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public List<TbPermission> getTbPermissions() {
        return tbPermissions;
    }

    public void setTbPermissions(List<TbPermission> tbPermissions) {
        this.tbPermissions = tbPermissions;
    }

    @Override
    public String toString() {
        return "RoleCompleteDto{" +
                "id=" + id +
                ", parentId=" + parentId +
                ", name='" + name + '\'' +
                ", enname='" + enname + '\'' +
                ", description='" + description + '\'' +
                ", created='" + created + '\'' +
                ", updated='" + updated + '\'' +
                ", tbPermissions=" + tbPermissions +
                '}';
    }
}
