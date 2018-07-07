package com.msg.alamsutera.dao;

import com.msg.alamsutera.model.SecureLoginModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Created by yoga.wiguna on 5/1/2018.
 */

@Repository
@Transactional
public class SecureLoginDaoImpl implements SecureLoginDao {

//    String ymdSl = "", ymdUs = "";
//    ResultSet resultSet = null;
//    SimpleDateFormat df;
//    Calendar now = Calendar.getInstance();
//    now .setTimeInMillis(System.currentTimeMillis() - (interval * 86400000L));
//    Date date = now.getTime();
//    if(!ymd.isEmpty()) {
//        ymdSl = dt.formatDate("yyyy-mm-dd", "yyyy/mm/dd", ymd);
//        ymdUs = dt.formatDate("yyyy-mm-dd", "yyyy_mm_dd", ymd);
//    } else {
//        df = new SimpleDateFormat("yyyy/MM/dd");
//        ymdSl = df.format(date);
//        df = new SimpleDateFormat("yyyy_MM_dd");
//        ymdUs = df.format(date);
//    }


    @Autowired
    private JdbcTemplate jdbcTemplate;

    class UserRowMapper implements RowMapper<SecureLoginModel> {

        @Override
        public SecureLoginModel mapRow(ResultSet rs, int i) throws SQLException {
            SecureLoginModel loginModel = new SecureLoginModel();
            loginModel.setId_islogin(rs.getInt("id_islogin"));
            loginModel.setId_employee(rs.getString("id_employee"));
            loginModel.setId_cluster(rs.getInt("id_cluster"));
            loginModel.setId_shift(rs.getInt("id_shift"));
            loginModel.setTime_login(rs.getString("time_login"));
            loginModel.setStatus_login(rs.getInt("status_login"));
            loginModel.setFirst_id_censore(rs.getString("first_id_censore"));
            return loginModel;
        }
    }


    @Override
    public void insertLogin(SecureLoginModel loginModel) {
        String sql = "INSERT INTO trx_secure_login (id_employee, id_cluster, id_shift, time_login, status_login, id_censore, rute, next_rute)" +
                "VALUES ((SELECT id_employee FROM mtr_user_security WHERE id_employee = ?)," +
                        "(SELECT id_cluster FROM mtr_cluster WHERE id_cluster = ?)," +
                        "(SELECT id_shift FROM mtr_shift WHERE id_shift = ?)," +
                        "now()::TIMESTAMP," +
                        "1," +
                        "(SELECT id_censore FROM mtr_point WHERE id_cluster = "+loginModel.getId_cluster() +" AND rute = 1)," +
                        "0," +
                        "1)";
        jdbcTemplate.update(sql,
                loginModel.getId_employee(),
                loginModel.getId_cluster(),
                loginModel.getId_shift()
//                loginModel.getNext_rute(loginModel.getFirst_rute()+1)
        );
    }


    @Override
    public boolean isUserSecExsist(String id_employee) {
        String sql = "SELECT count(*) from mtr_user_security WHERE id_employee = ? ";
        int count = jdbcTemplate.queryForObject(sql, Integer.class, id_employee);
        if(count == 1) {
            return true;
        } else {
            return false;
        }
    }

    @Override
    public boolean isLoginExist (String id_employee) {
        String sql = "SELECT count(*) from trx_secure_login WHERE id_employee = ? AND status_login = 1";
        int count = jdbcTemplate.queryForObject(sql, Integer.class, id_employee);
        if(count == 1) {
            return true;
        } else {
            return false;
        }
    }


    @Override
    public boolean isAnyLoginInClus (int idclus, int idshif) {
        String sql = "SELECT count(*) from trx_secure_login WHERE id_cluster = ? AND id_shift = ? AND status_login = 1";
        int count = jdbcTemplate.queryForObject(sql, Integer.class, idclus, idshif);
        if(count == 1) {
            return true;
        } else {
            return false;
        }
    }

    @Override
    public SecureLoginModel getUserLogin(String id_empl) {
        String sql = "SELECT security_name FROM mtr_user_security WHERE  id_employee = ?";
        RowMapper <SecureLoginModel> rowMapper = new BeanPropertyRowMapper<SecureLoginModel>(SecureLoginModel.class);
        SecureLoginModel loginModel = jdbcTemplate.queryForObject(sql, rowMapper, id_empl);
        return loginModel;
    }

}
