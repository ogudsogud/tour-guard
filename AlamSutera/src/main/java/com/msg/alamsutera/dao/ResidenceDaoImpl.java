package com.msg.alamsutera.dao;

import com.msg.alamsutera.model.ResidenceModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.sql.DataSource;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

/**
 * Created by yoga.wiguna on 4/23/2018.
 */

@Transactional
@Repository
public class ResidenceDaoImpl implements ResidenceDao {

    @Autowired
    DataSource dataSource;

    @Autowired
    private JdbcTemplate jdbcTemplate;

    class UserRowMapper implements RowMapper<ResidenceModel> {

        @Override
        public ResidenceModel mapRow(ResultSet rs, int i) throws SQLException {
            ResidenceModel residenceModel = new ResidenceModel();
            residenceModel.setId_user_residence(rs.getInt("id_user_residence"));
            residenceModel.setUser_name(rs.getString("user_name"));
//            residenceModel.set(rs.getString("cluster"));
            residenceModel.setBlok(rs.getString("blok"));
            residenceModel.setWork(rs.getString("work"));
            residenceModel.setCreated_by(rs.getString("created_by"));
            residenceModel.setCreated_on(rs.getDate("created_on"));
            residenceModel.setUpdated_by(rs.getString("updated_by"));
            residenceModel.setUpdated_on(rs.getDate("updated_on"));
            residenceModel.setStatus(rs.getInt("status"));
            residenceModel.setEmail(rs.getString("email"));
            residenceModel.setPassword(rs.getString("password"));
            residenceModel.setId_cluster(rs.getInt("id_cluster"));
            return residenceModel;
        }
    }

    @Override
    public List<ResidenceModel> getAllUserRes() {
        String sql = "SELECT * FROM mtr_user_residence";
        RowMapper<ResidenceModel> rowMapper = new UserRowMapper();
        return this.jdbcTemplate.query(sql,rowMapper);
    }

    @Override
    public void save(ResidenceModel residenceModel) {
        String sql = "INSERT INTO mtr_user_residence (user_name,blok,work,created_by,created_on,updated_by,updated_on,status,email,password,id_cluster)" +
                "VALUES (?,?,?,?,?,?,?,?,?,?,?) ";
        jdbcTemplate.update(sql,
                residenceModel.getUser_name(),
                residenceModel.getBlok(),
                residenceModel.getWork(),
                residenceModel.getCreated_by(),
                residenceModel.getCreated_on(),
                residenceModel.getUpdated_by(),
                residenceModel.getCreated_on(),
                residenceModel.getStatus(),
                residenceModel.getEmail(),
                residenceModel.getPassword(),
                residenceModel.getId_cluster());
    }

    @Override
    public boolean isUserExist(String email, String paswd) {
        String sql = "SELECT count(*) FROM mtr_user_residence WHERE email = ? and password=?";
        int count = jdbcTemplate.queryForObject(sql, Integer.class, email, paswd);
        if(count == 0) {
            return false;
        } else {
            return true;
        }
    }



}
