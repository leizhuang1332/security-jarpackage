package com.lz.security.service;

import com.lz.security.entity.UserEntity;
import com.lz.security.service.inteface.UserInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Service;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Service
public class UserService implements UserInterface {

    @Autowired
    @Qualifier("jdbcTemplate")
    private JdbcTemplate jdbcTemplate;

    @Override
    public UserEntity getByUsername(String username) {

        String sql = "SELECT * FROM tb_user WHERE username = ? ";

        List<UserEntity> query = jdbcTemplate.query(sql, new Object[]{username}, new UserRowMapper());

        return query.isEmpty() ? null : query.get(0);
    }

    class UserRowMapper implements RowMapper<UserEntity> {

        @Override
        public UserEntity mapRow(ResultSet rs, int rowNum) throws SQLException {

            UserEntity userEntity = new UserEntity();
            userEntity.setId(rs.getLong("id"));
            userEntity.setUsername(rs.getString("username"));
            userEntity.setPassword(rs.getString("password"));
            userEntity.setPhone(rs.getString("phone"));
            userEntity.setEmail(rs.getString("email"));
            userEntity.setCreated(rs.getString("created"));
            userEntity.setUpdated(rs.getString("updated"));

            return userEntity;
        }
    }
}
