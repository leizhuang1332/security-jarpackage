package com.lz.admin.mapper;

import com.lz.admin.bean.TbUser;
import com.lz.admin.bean.TbUserExample;
import com.lz.security.entity.inteface.UserSecurityEntityInterface;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TbUserMapper {
    long countByExample(TbUserExample example);

    int deleteByExample(TbUserExample example);

    int deleteByPrimaryKey(Long id);

    int insert(TbUser record);

    int insertSelective(TbUser record);

    List<TbUser> selectByExample(TbUserExample example);

    TbUser selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") TbUser record, @Param("example") TbUserExample example);

    int updateByExample(@Param("record") TbUser record, @Param("example") TbUserExample example);

    int updateByPrimaryKeySelective(TbUser record);

    int updateByPrimaryKey(TbUser record);

    UserSecurityEntityInterface getByUsername(@Param("username") String username);

    UserSecurityEntityInterface getByOpenid(@Param("openid") String openid);
}