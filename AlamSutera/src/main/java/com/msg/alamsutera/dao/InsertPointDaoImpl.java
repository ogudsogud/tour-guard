package com.msg.alamsutera.dao;

import com.msg.alamsutera.model.InsertPointModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Created by yoga.wiguna on 5/7/2018.
 */

@Transactional
@Repository
public class InsertPointDaoImpl implements InsertPointDao {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    class UserRowMapper implements RowMapper<InsertPointModel> {

        @Override
        public InsertPointModel mapRow(ResultSet rs, int i) throws SQLException {

            InsertPointModel insertPointModel = new InsertPointModel();
            insertPointModel.setId_insertpoint(rs.getInt("id_insertpoint"));
            insertPointModel.setPoint_name(rs.getString("point_name"));
            insertPointModel.setRute(rs.getInt("rute"));
            insertPointModel.setId_censore(rs.getString("id_censore"));
            insertPointModel.setId_cluster(rs.getInt("id_cluster"));

            return insertPointModel;
        }

    }

    @Override
    public boolean cekRuteCluster(InsertPointModel insertPointModel) {

            String sql = "INSERT INTO trx_insert_point2point (point_name, rute, id_censore, id_cluster, next_rute) VALUES (?,?,?,?,?)";
            jdbcTemplate.update(sql,
                    insertPointModel.getPoint_name(),
                    insertPointModel.getRute(),
                    insertPointModel.getId_censore(),
                    insertPointModel.getId_cluster(),
                    insertPointModel.getNext_rute(insertPointModel.getRute() + 1));
        return false;

    }


        @Override
    public boolean cekNextRute(int rute, String id_censore) {
        String sql = "SELECT count(*) FROM trx_insert_point2point WHERE rute = ? AND id_censore = ?";
        int count = jdbcTemplate.queryForObject(sql, Integer.class, rute, id_censore);
        if (count == 0) {
            return true;
        } else {
            return false;
        }
    }
}





