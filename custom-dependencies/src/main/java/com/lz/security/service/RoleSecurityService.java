package com.lz.security.service;

import com.lz.admin.config.MybatisSessionConfig;
import com.lz.admin.mapper.TbRoleMapper;
import com.lz.security.entity.RoleSecurityEntity;
import com.lz.security.entity.inteface.RoleSecurityEntityInterface;
import com.lz.security.service.inteface.RoleSecurityInterface;
import org.apache.ibatis.session.SqlSession;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Service;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Service
public class RoleSecurityService implements RoleSecurityInterface {

//    @Autowired
//    @Qualifier("jdbcTemplate")
//    private JdbcTemplate jdbcTemplate;

    private TbRoleMapper tbRoleMapper;

    public RoleSecurityService() {
        SqlSession session = MybatisSessionConfig.getSession();
        this.tbRoleMapper = session.getMapper(TbRoleMapper.class);
    }

    @Override
    public List<RoleSecurityEntityInterface> getByUserId(Long userId) {

        return tbRoleMapper.getByUserId(userId);

//        String sql = "SELECT\n" +
//                "          r.*\n" +
//                "        FROM\n" +
//                "          tb_user AS u\n" +
//                "          LEFT JOIN tb_user_role AS ur\n" +
//                "            ON u.id = ur.user_id\n" +
//                "          LEFT JOIN tb_role AS r\n" +
//                "            ON r.id = ur.role_id\n" +
//                "        WHERE u.id = ? ";
//
//        return jdbcTemplate.query(sql, new Object[]{userId}, new RoleRowMapper());
    }

//    class RoleRowMapper implements RowMapper<RoleSecurityEntity> {
//
//        @Override
//        public RoleSecurityEntity mapRow(ResultSet rs, int rowNum) throws SQLException {
//            RoleSecurityEntity roleEntity = new RoleSecurityEntity();
//            roleEntity.setId(rs.getLong("id"));
//            roleEntity.setParentId(rs.getLong("parent_id"));
//            roleEntity.setName(rs.getString("name"));
//            roleEntity.setEnname(rs.getString("enname"));
//            roleEntity.setDescription(rs.getString("description"));
//            roleEntity.setCreated(rs.getString("created"));
//            roleEntity.setUpdated(rs.getString("updated"));
//            return roleEntity;
//        }
//    }
}
