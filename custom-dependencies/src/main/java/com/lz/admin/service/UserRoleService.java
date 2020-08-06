package com.lz.admin.service;

import com.lz.admin.bean.TbUserRole;
import com.lz.admin.bean.TbUserRoleExample;
import com.lz.admin.config.MybatisSessionConfig;
import com.lz.admin.mapper.TbRoleMapper;
import com.lz.admin.mapper.TbUserRoleMapper;
import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author pzg
 * @date 2020/7/27
 * @description
 */
@Service
public class UserRoleService {
//    @Autowired
    private TbUserRoleMapper tbUserRoleMapper;

    public UserRoleService(){
        SqlSession session = MybatisSessionConfig.getSession();
        this.tbUserRoleMapper = session.getMapper(TbUserRoleMapper.class);
    }

    public boolean updateUserRoleRelation(long userId, List<Long> roleIds) {
        TbUserRoleExample example = new TbUserRoleExample();
        example.createCriteria().andUserIdEqualTo(userId);
        tbUserRoleMapper.deleteByExample(example);

        for (Long roleId : roleIds) {
            TbUserRole userRole = new TbUserRole();
            userRole.setUserId(userId);
            userRole.setRoleId(roleId);
            int insert = tbUserRoleMapper.insert(userRole);
            if (insert <= 0) return false;
        }

        return true;
    }

}
