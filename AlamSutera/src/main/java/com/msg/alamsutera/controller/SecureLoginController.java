package com.msg.alamsutera.controller;

import com.msg.alamsutera.dao.SecureLoginDao;
import com.msg.alamsutera.model.ErrorHandling;
import com.msg.alamsutera.model.SecureLoginModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

/**
 * Created by yoga.wiguna on 5/1/2018.
 */

@RestController
@RequestMapping("alam-sutera/login")
public class SecureLoginController {

    @Autowired
    private JdbcTemplate jdbcTemplate;
    @Autowired
    private SecureLoginDao loginDao;

    @RequestMapping(value = "/insertlogin", method = RequestMethod.POST)
    public ResponseEntity createLogin(@RequestBody SecureLoginModel loginModel, UriComponentsBuilder uriComponentsBuilder) {

        if(loginDao.isUserSecExsist(loginModel.getId_employee())== false) {
            return new ResponseEntity(new ErrorHandling("404","Data security belum terdaftar"), HttpStatus.NOT_FOUND);
        }

        if(loginDao.isLoginExist(loginModel.getId_employee()) == true){
            return new ResponseEntity(new ErrorHandling("409","User masih login"), HttpStatus.CONFLICT);
        }

        if(loginDao.isAnyLoginInClus(loginModel.getId_cluster(), loginModel.getId_shift()) == true ) {
            return new ResponseEntity(new ErrorHandling("409","Sudah ada user login di cluster dan shift yang sama"), HttpStatus.CONFLICT);
        }
        loginDao.insertLogin(loginModel);
        return new ResponseEntity(new ErrorHandling("100","User berhasil login"),HttpStatus.CREATED);

//        HttpHeaders headers = new HttpHeaders();
//        headers.setLocation(uriComponentsBuilder.path("/save/{id}").buildAndExpand(loginModel.getId_islogin()).toUri());

//        return new ResponseEntity<Void>(headers, HttpStatus.CREATED) ;
    }

}
