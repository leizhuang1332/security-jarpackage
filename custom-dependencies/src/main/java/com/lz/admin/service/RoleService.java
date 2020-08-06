package com.lz.admin.service;

import com.lz.admin.bean.TbRole;
import com.lz.admin.config.MybatisSessionConfig;
import com.lz.admin.mapper.TbRoleMapper;
import com.lz.admin.mapper.TbRolePermissionMapper;
import com.lz.admin.util.TimeUtil;
import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author pzg
 * @date 2020/7/27
 * @description
 */
@Service
public class RoleService {
//    @Autowired
    private TbRoleMapper tbRoleMapper;

    public RoleService(){
        SqlSession session = MybatisSessionConfig.getSession();
        this.tbRoleMapper = session.getMapper(TbRoleMapper.class);
    }

    public int addOne(TbRole role) throws DuplicateKeyException{
        String now = TimeUtil.getNow();
        role.setCreated(now);
        role.setUpdated(now);
        int i = 0;
        try {
            i = tbRoleMapper.insert(role);
        } catch (DuplicateKeyException e) {
            throw e;
        }

        return i;
    }

    public int delOne(long roleId) {
        return tbRoleMapper.deleteByPrimaryKey(roleId);
    }

    public int updateOne(TbRole role) throws DuplicateKeyException{
        String now = TimeUtil.getNow();
        role.setUpdated(now);
        int i = 0;
        try {
            i = tbRoleMapper.updateByPrimaryKeySelective(role);
        } catch (DuplicateKeyException e) {
            throw e;
        }

        return i;
    }

    public List<TbRole> getAll() {
        return tbRoleMapper.selectByExample(null);
    }

    public List<TbRole> listByUserId(long userId) {
        return tbRoleMapper.listByUserId(userId);
    }
}
