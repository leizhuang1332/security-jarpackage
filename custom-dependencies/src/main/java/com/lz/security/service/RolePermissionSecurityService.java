package com.lz.security.service;

import com.lz.admin.config.MybatisSessionConfig;
import com.lz.admin.mapper.TbRolePermissionMapper;
import com.lz.security.entity.RolePermissionSecurityEntity;
import com.lz.security.entity.inteface.RolePermissionSecurityEntityInterface;
import com.lz.security.service.inteface.RolePermissionSecurityInterface;
import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Service;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Service
public class RolePermissionSecurityService implements RolePermissionSecurityInterface {

//    @Autowired
//    @Qualifier("jdbcTemplate")
//    private JdbcTemplate jdbcTemplate;

    private TbRolePermissionMapper tbRolePermissionMapper;

    public RolePermissionSecurityService(){
        SqlSession session = MybatisSessionConfig.getSession();
        this.tbRolePermissionMapper = session.getMapper(TbRolePermissionMapper.class);
    }



    @Override
    public List<RolePermissionSecurityEntityInterface> getAll() {
        return tbRolePermissionMapper.getAll();

//        String sql = "SELECT\n" +
//                "            r.id AS roleId,\n" +
//                "            r.`name` AS roleName,\n" +
//                "            r.enname AS roleEnname,\n" +
//                "            p.id AS permissionId,\n" +
//                "            p.`name` AS permissionName,\n" +
//                "            p.enname AS permissionEnName,\n" +
//                "            p.url AS permissionUrl\n" +
//                "        FROM\n" +
//                "            tb_role AS r\n" +
//                "            INNER JOIN tb_role_permission AS rp ON r.id = rp.role_id\n" +
//                "            INNER JOIN tb_permission AS p ON p.id = rp.permission_id";
//
//        return jdbcTemplate.query(sql, new RolePermissionRowMapper());
    }

//    class RolePermissionRowMapper implements RowMapper<RolePermissionSecurityEntity> {
//
//        @Override
//        public RolePermissionSecurityEntity mapRow(ResultSet rs, int rowNum) throws SQLException {
//            RolePermissionSecurityEntity rolePermissionEntity = new RolePermissionSecurityEntity();
//            rolePermissionEntity.setRoleId(rs.getLong("roleId"));
//            rolePermissionEntity.setRoleName(rs.getString("roleName"));
//            rolePermissionEntity.setRoleEnname(rs.getString("roleEnname"));
//            rolePermissionEntity.setPermissionId(rs.getLong("permissionId"));
//            rolePermissionEntity.setPermissionName(rs.getString("permissionName"));
//            rolePermissionEntity.setPermissionEnName(rs.getString("permissionEnName"));
//            rolePermissionEntity.setPermissionUrl(rs.getString("permissionUrl"));
//            return rolePermissionEntity;
//        }
//    }
}
