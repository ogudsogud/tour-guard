package com.msg.alamsutera.dao;

import com.msg.alamsutera.model.PointLocationModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

/**
 * Created by yoga.wiguna on 5/3/2018.
 */

@Repository
@Transactional
public class PointLocDaoImpl implements PointLocDao {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    class UserRowMapper implements RowMapper<PointLocationModel> {
        @Override
        public PointLocationModel mapRow(ResultSet rs, int i) throws SQLException {
            PointLocationModel pointLocationModel = new PointLocationModel();
            pointLocationModel.setId_point(rs.getInt("id_point"));
            pointLocationModel.setLongitude(rs.getString("longitude"));
            pointLocationModel.setLatitude(rs.getString("latitude"));
            pointLocationModel.setId_censore(rs.getString("id_censore"));
            pointLocationModel.setBarcode(rs.getString("barcode"));
            pointLocationModel.setCreated_by(rs.getString("created_by"));
            pointLocationModel.setCreated_on(rs.getString("created_on"));
            pointLocationModel.setUpdated_by(rs.getString("updated_by"));
            pointLocationModel.setUpdated_on(rs.getString("updated_on"));
            pointLocationModel.setStatus(rs.getInt("status"));
            pointLocationModel.setId_cluster(rs.getInt("id_cluster"));
            return pointLocationModel;
        }
    }


    @Override
    public List<PointLocationModel> getAllPoint() {
        String sql = "SELECT * FROM mtr_point";
        RowMapper<PointLocationModel> rowMapper = new UserRowMapper();
        return this.jdbcTemplate.query(sql,rowMapper);
    }


    @Override
    public boolean isPointExist(String id_censore, String longitude, String latitude) {
        String sql = "SELECT count(*) FROM mtr_point WHERE id_censore = ? AND longitude = ? AND latitude = ?";
        int count = jdbcTemplate.queryForObject(sql, Integer.class, id_censore, longitude, latitude);
        if(count == 0) {
            return true;
        } else {
            return false;
        }
    }

    @Override
    public void savePointLoc(PointLocationModel locationModel) {
        String sql = "INSERT INTO mtr_point (longitude,latitude,id_censore,barcode,created_by,created_on,updated_by,updated_on,status,id_cluster)" +
                "VALUES (?,?,?,?,?,now(),?,now(),?,?) ";
        jdbcTemplate.update(sql,
                locationModel.getLongitude(),
                locationModel.getLatitude(),
                locationModel.getId_censore(),
                locationModel.getBarcode(),
                locationModel.getCreated_by(),
//                clusterModel.getCreated_on(),
                locationModel.getUpdated_by(),
//                clusterModel.getUpdated_on(),
                locationModel.getStatus(),
                locationModel.getId_cluster());
    }

}
