package com.lz.admin.mapper;

import com.lz.admin.bean.TbRolePermission;
import com.lz.admin.bean.TbRolePermissionExample;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TbRolePermissionMapper {
    long countByExample(TbRolePermissionExample example);

    int deleteByExample(TbRolePermissionExample example);

    int deleteByPrimaryKey(Long id);

    int insert(TbRolePermission record);

    int insertSelective(TbRolePermission record);

    List<TbRolePermission> selectByExample(TbRolePermissionExample example);

    TbRolePermission selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") TbRolePermission record, @Param("example") TbRolePermissionExample example);

    int updateByExample(@Param("record") TbRolePermission record, @Param("example") TbRolePermissionExample example);

    int updateByPrimaryKeySelective(TbRolePermission record);

    int updateByPrimaryKey(TbRolePermission record);
}