package com.msg.alamsutera.dao;

import com.msg.alamsutera.model.ClusterModel;
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
public class ClusterDaoImpl implements ClusterDao{

    @Autowired
    private JdbcTemplate jdbcTemplate;

    class UserRowMapper implements RowMapper<ClusterModel> {
        @Override
        public ClusterModel mapRow(ResultSet rs, int i) throws SQLException {
            ClusterModel clusterModel = new ClusterModel();
            clusterModel.setId_cluster(rs.getInt("id_cluster"));
            clusterModel.setCluster_name(rs.getString("cluster_name"));
            clusterModel.setCluster_large(rs.getString("cluster_large"));
            clusterModel.setUnit_qty(rs.getInt("unit_qty"));
            clusterModel.setCreated_by(rs.getString("created_by"));
            clusterModel.setCreated_on(rs.getString("created_on"));
            clusterModel.setUpdated_by(rs.getString("updated_by"));
            clusterModel.setUpdated_on(rs.getString("updated_on"));
            clusterModel.setStatus(rs.getInt("status"));
            clusterModel.setId_sektor(rs.getInt("id_sektor"));
            return clusterModel;
        }
    }

    @Override
    public List<ClusterModel> getAllCluster() {
        String sql = "SELECT * FROM mtr_cluster";
        RowMapper<ClusterModel> rowMapper = new UserRowMapper();
        return this.jdbcTemplate.query(sql,rowMapper);
    }


    @Override
    public boolean isClusExist(String cluster_name) {
        String sql = "SELECT count(*) FROM mtr_cluster WHERE cluster_name = ?";
        int count = jdbcTemplate.queryForObject(sql, Integer.class, cluster_name);
        if(count == 0) {
            return true;
        } else {
            return false;
        }
    }

    @Override
    public void saveCluster(ClusterModel clusterModel) {
        String sql = "INSERT INTO mtr_cluster (cluster_name,cluster_large,unit_qty,created_by,created_on,updated_by,updated_on,status,id_sektor)" +
                "VALUES (?,?,?,?,now(),?,now(),?,?) ";
        jdbcTemplate.update(sql,
                clusterModel.getCluster_name(),
                clusterModel.getCluster_large(),
                clusterModel.getUnit_qty(),
                clusterModel.getCreated_by(),
//                clusterModel.getCreated_on(),
                clusterModel.getUpdated_by(),
//                clusterModel.getUpdated_on(),
                clusterModel.getStatus(),
                clusterModel.getId_sektor());
    }


}
