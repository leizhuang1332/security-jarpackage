package com.lz.admin.bean;

import io.swagger.annotations.ApiModelProperty;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.io.Serializable;

public class TbPermission implements Serializable {
    private Long id;

    @ApiModelProperty(value = "父权限")
    private Long parentId;

    @ApiModelProperty(value = "权限名称")
    @NotNull(message = "权限名称不能为空")
    @Size(min = 1,message ="权限名称不能为空" )
    private String name;

    @ApiModelProperty(value = "权限英文名称")
    @NotNull(message = "权限英文名称不能为空")
    @Size(min = 1,message ="权限英文名称不能为空" )
    private String enname;

    @ApiModelProperty(value = "授权路径")
    @NotNull(message = "url不能为空")
    @Size(min = 1,message ="url不能为空" )
    private String url;

    @ApiModelProperty(value = "备注")
    private String description;

    private String created;

    private String updated;

    private static final long serialVersionUID = 1L;

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

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
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

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", parentId=").append(parentId);
        sb.append(", name=").append(name);
        sb.append(", enname=").append(enname);
        sb.append(", url=").append(url);
        sb.append(", description=").append(description);
        sb.append(", created=").append(created);
        sb.append(", updated=").append(updated);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}