package com.msg.alamsutera.controller;

import com.msg.alamsutera.dao.InsertPointDao;
import com.msg.alamsutera.model.ErrorHandling;
import com.msg.alamsutera.model.InsertPointModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

/**
 * Created by yoga.wiguna on 5/7/2018.
 */

@RestController
@RequestMapping("tes/masukin")
public class InsertPointController {

    @Autowired
    private InsertPointDao insertPointDao;

    @RequestMapping(value = "/point", method = RequestMethod.POST)
    public ResponseEntity<Void> insertpoint2point(@RequestBody InsertPointModel insertPointModel, UriComponentsBuilder uriComponentsBuilder) {

        if (insertPointDao.cekNextRute(insertPointModel.getRute(), insertPointModel.getId_censore()) == true) {
            insertPointDao.cekRuteCluster(insertPointModel);
            return new ResponseEntity(new ErrorHandling("201", "Berhasil cek point : " + insertPointModel.getId_censore()), HttpStatus.CREATED);

        }

        return new ResponseEntity(new ErrorHandling("404", "Silahkan ke pos point : " + (insertPointModel.getRute()+1)), HttpStatus.NOT_FOUND);
    }
}
