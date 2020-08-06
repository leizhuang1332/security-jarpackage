package com.lz.admin.service;

import com.lz.admin.bean.TbUser;
import com.lz.admin.config.MybatisSessionConfig;
import com.lz.admin.mapper.TbUserMapper;
import com.lz.admin.mapper.TbUserRoleMapper;
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
public class UserService {
//    @Autowired
    private TbUserMapper tbUserMapper;

    public UserService(){
        SqlSession session = MybatisSessionConfig.getSession();
        this.tbUserMapper = session.getMapper(TbUserMapper.class);
    }

    public int addOne(TbUser user) throws DuplicateKeyException {
        String now = TimeUtil.getNow();
        user.setCreated(now);
        user.setUpdated(now);
        int insert = 0;
        try {
            insert = tbUserMapper.insert(user);
        } catch (DuplicateKeyException e) {
            throw e;
        }

        return insert;
    }

    public int delOne(long userId) {
        return tbUserMapper.deleteByPrimaryKey(userId);
    }

    public int updateOne(TbUser user) throws DuplicateKeyException {
        String now = TimeUtil.getNow();
        user.setUpdated(now);
        int i = 0;
        try {
            i = tbUserMapper.updateByPrimaryKeySelective(user);
        } catch (DuplicateKeyException e) {
            throw e;
        }
        return i;
    }

    public List<TbUser> getAll() {
        return tbUserMapper.selectByExample(null);
    }

    public TbUser getOneUser(long userId) {
        return tbUserMapper.selectByPrimaryKey(userId);
    }
}
