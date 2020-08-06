package com.lz.admin.service;

import com.lz.admin.bean.TbRolePermission;
import com.lz.admin.bean.TbRolePermissionExample;
import com.lz.admin.config.MybatisSessionConfig;
import com.lz.admin.mapper.TbPermissionMapper;
import com.lz.admin.mapper.TbRolePermissionMapper;
import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author pzg
 * @date 2020/7/27
 * @description
 */
@Service
public class RolePermissionService {

//    @Autowired
    private TbRolePermissionMapper tbRolePermissionMapper;

    public RolePermissionService(){
        SqlSession session = MybatisSessionConfig.getSession();
        this.tbRolePermissionMapper = session.getMapper(TbRolePermissionMapper.class);
    }

    public boolean updateRolePermissionRelation(Long roleId, List<Long> permissionIds) {
        TbRolePermissionExample example = new TbRolePermissionExample();
        example.createCriteria().andRoleIdEqualTo(roleId);
        tbRolePermissionMapper.deleteByExample(example);

        for (Long permissionId : permissionIds) {
            TbRolePermission rolePermission = new TbRolePermission();
            rolePermission.setPermissionId(permissionId);
            rolePermission.setRoleId(roleId);
            int insert = tbRolePermissionMapper.insert(rolePermission);
            if (insert <= 0) return false;
        }

        return true;
    }

}
