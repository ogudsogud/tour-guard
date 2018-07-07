package com.msg.alamsutera.controller;


import com.msg.alamsutera.dao.ResidenceDao;
import com.msg.alamsutera.model.ResidenceModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.List;

/**
 * Created by yoga.wiguna on 4/21/2018.
 */

@RestController
@RequestMapping("alam-sutera/residence")
public class ResidenceController {

    @Autowired
    private ResidenceDao residenceDao;

    @GetMapping("/getall")
    public ResponseEntity<List<ResidenceModel>> getAllRes(){
        List<ResidenceModel> list = residenceDao.getAllUserRes();
        return new ResponseEntity<List<ResidenceModel>>(list, HttpStatus.OK);
    }

    @RequestMapping(value = "/insert", method = RequestMethod.POST)
    public ResponseEntity<Void> createUser(@RequestBody ResidenceModel residenceModel, UriComponentsBuilder componentsBuilder) {
//        if(residenceDao.isUserExist(residenceModel.getEmail(), residenceModel.getPassword())){
//            return new ResponseEntity<Void>(HttpStatus.CONFLICT);
//        }
        residenceDao.save(residenceModel);


        HttpHeaders headers = new HttpHeaders();
        headers.setLocation(componentsBuilder.path("/save/{id}").buildAndExpand(residenceModel.getId_user_residence()).toUri());
        return new ResponseEntity<Void>(headers, HttpStatus.CREATED);
    }

}
