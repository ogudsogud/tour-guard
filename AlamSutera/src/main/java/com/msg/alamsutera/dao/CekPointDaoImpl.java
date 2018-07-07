package com.msg.alamsutera.dao;

import com.msg.alamsutera.model.CekPointModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.Basic;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

/**
 * Created by yoga.wiguna on 4/26/2018.
 */

@Transactional
@Repository
public class CekPointDaoImpl implements CekPointDao {
    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Basic
    private java.sql.Timestamp sqlTimestamp;

    class CekPointRowMapper implements RowMapper<CekPointModel> {

        @Override
        public CekPointModel mapRow(ResultSet rs, int i) throws SQLException {
            CekPointModel cekPointModel = new CekPointModel();
            cekPointModel.setId_cekpoint(rs.getInt("id_cekpoint"));
            cekPointModel.setId_employee(rs.getString("id_employee"));
            cekPointModel.setLongitude(rs.getString("longitude"));
            cekPointModel.setLatitude(rs.getString("latitude"));
            cekPointModel.setId_cluster(rs.getInt("id_cluster"));
            cekPointModel.setTime_cek(rs.getString("time_cek"));
            cekPointModel.setId_censore(rs.getString("id_censore"));
            cekPointModel.setId_shift(rs.getInt("id_shift"));
            cekPointModel.setRute(rs.getInt("rute"));
            cekPointModel.setNextrute(rs.getInt("next_rute"));

            return cekPointModel;
        }
    }

    @Override
    public List<CekPointModel> getAllCekPoint() {
        String sql = "SELECT * FROM trx_cek_point";
        RowMapper<CekPointModel> rowMapper = new CekPointRowMapper();
        return this.jdbcTemplate.query(sql,rowMapper);
    }


    //untuk cek apakah user sudah login
    @Override
    public boolean getCekUserLogin(String id_employee) {
        String sql = "SELECT count(*) FROM trx_secure_login WHERE id_employee = ?";
        int count = jdbcTemplate.queryForObject(sql, Integer.class, id_employee);
        if(count == 1){
            return true;
        } else {
            return false;
        }
    }


    public boolean cekPointandRute(String id_employee) {
        String sql = "SELECT count(*) FROM trx_secure_login WHERE id_employee = ?";
        int count = jdbcTemplate.queryForObject(sql, Integer.class, id_employee);
        if(count == 1){
            return true;
        } else {
            return false;
        }
    }


    //untuk insert cekpoint
    @Override
    public boolean insertPoint(CekPointModel pointModel) {

        String sql = "INSERT INTO trx_cek_point (id_employee, longitude, latitude, id_cluster, time_cek, id_shift, id_censore, rute, next_rute)" +
                "VALUES ((SELECT id_employee FROM trx_secure_login WHERE id_employee = ?)," +
                "(SELECT longitude FROM mtr_point WHERE longitude = ? AND id_cluster = "+pointModel.getId_cluster()+" AND rute = "+pointModel.getRute()+")," +
                "(SELECT latitude FROM mtr_point WHERE latitude = ? AND id_cluster = "+pointModel.getId_cluster()+" AND rute = "+pointModel.getRute()+")," +
                "(SELECT id_cluster FROM trx_secure_login WHERE id_cluster = ?)," +
                "(SELECT now()::TIMESTAMP)," +
                "(SELECT id_shift FROM trx_secure_login WHERE id_shift = ?)," +
                "(SELECT id_censore FROM mtr_point WHERE id_censore = ?)," +
                "(SELECT rute FROM mtr_point WHERE id_cluster = "+pointModel.getId_cluster()+" AND rute = ?)," +
                "?)";
        jdbcTemplate.update(sql,
                pointModel.getId_employee(),
                pointModel.getLongitude(),
                pointModel.getLatitude(),
                pointModel.getId_cluster(),
//                pointModel.getTime_cek(),
                pointModel.getId_shift(),
                pointModel.getId_censore(),
                pointModel.getRute(),
                pointModel.getRute() + 1
        );

        return false;
    }

    //cek apakah rute ke-1 sudah di insert
//    @Override
//    public boolean cekFirstRute() {
//        String sql = "SELECT COUNT(*)" +
//                "FROM trx_secure_login seclog " +
//                "JOIN trx_cek_point ckpo ON " +
//                "ckpo.next_rute = seclog.next_rute " +
//                "WHERE seclog.next_rute = 1  OR ckpo.rute < 1 ";
//        int count = jdbcTemplate.queryForObject(sql, Integer.class);
//        if (count == 1) {
//            return true;
//        }
//        else {
//            return false;
//        }
//    }


    //untuk cek apakah id_sensore yang dilalui sudah dicatat atau belum
    @Override
    public boolean getCekPoint(String longitude, String latitude, String id_censore) {
        String sql = "SELECT count(*) FROM trx_cek_point WHERE longitude = ? AND latitude = ? AND id_censore = ?";
        int count = jdbcTemplate.queryForObject(sql, Integer.class, longitude, latitude, id_censore);
        if (count == 0) {
            return true;
        } else {
            return false;
        }
    }



    //untuk cek apakah rute yang dilalui sudah dicatat atau belum

//    @Override
//    public CekPointModel getNxtRute(int rutes) {
//        String sql = "SELECT * FROM trx_cek_point WHERE rute = ? " +
//                "ORDER BY next_rute DESC";
//        CekPointModel pointModel = (CekPointModel)jdbcTemplate.queryForObject(sql, new Object[]{rutes},new BeanPropertyRowMapper (CekPointModel.class));
//
//        System.out.println(sql);
//
//        return pointModel;
//
//    }


    @Override
    public boolean getPointLongLat(String longitude, String latitude) {
        String sql = "SELECT longitude, latitide FROM trx_cek_point WHERE  longitude = ? AND latitude = ?";
        RowMapper <CekPointModel> rowMapper = new BeanPropertyRowMapper<CekPointModel>(CekPointModel.class);
        CekPointModel pointModel = jdbcTemplate.queryForObject(sql, rowMapper, longitude,latitude);
        return false;
    }

}
