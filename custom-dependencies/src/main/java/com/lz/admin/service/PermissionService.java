package com.lz.admin.service;

import com.lz.admin.bean.TbPermission;
import com.lz.admin.config.MybatisSessionConfig;
import com.lz.admin.mapper.TbPermissionMapper;
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
public class PermissionService {
//    @Autowired
    private TbPermissionMapper tbPermissionMapper;

    public PermissionService(){
        SqlSession session = MybatisSessionConfig.getSession();
        this.tbPermissionMapper = session.getMapper(TbPermissionMapper.class);
    }

    public int addOne(TbPermission tbPermission) throws DuplicateKeyException {
        String now = TimeUtil.getNow();
        tbPermission.setCreated(now);
        tbPermission.setUpdated(now);
        int i = 0;
        try {
            i = tbPermissionMapper.insert(tbPermission);
        } catch (DuplicateKeyException e) {
            throw e;
        }

        return i;
    }

    public int delOne(long permissionId) {
        return tbPermissionMapper.deleteByPrimaryKey(permissionId);
    }

    public int updateOne(TbPermission tbPermission)  throws DuplicateKeyException {
        String now = TimeUtil.getNow();
        tbPermission.setUpdated(now);
        int i = 0;
        try {
            i = tbPermissionMapper.updateByPrimaryKeySelective(tbPermission);
        } catch (DuplicateKeyException e) {
            throw e;
        }

        return i;
    }

    public List<TbPermission> getAll() {
        return tbPermissionMapper.selectByExample(null);
    }

    public List<TbPermission> listByRoleId(long roleId) {
        return tbPermissionMapper.listByRoleId(roleId);
    }

    public List<TbPermission> listByUserId(long userId) {
        return tbPermissionMapper.listByUserId(userId);
    }
}
