package com.msg.alamsutera.controller;

import com.msg.alamsutera.dao.PointLocDao;
import com.msg.alamsutera.model.ErrorHandling;
import com.msg.alamsutera.model.PointLocationModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.List;

/**
 * Created by yoga.wiguna on 5/3/2018.
 */

@RestController
@RequestMapping("alam-sutera/point-loc")
public class PointLocController {

    @Autowired
    private PointLocDao pointLocDao;

    @RequestMapping("/getallpoint")
    public ResponseEntity<List<PointLocationModel>> getAllPoint(){
        if(pointLocDao.getAllPoint().isEmpty()){
            return new ResponseEntity(new ErrorHandling("404", "Data Point Tidak ditemukan"), HttpStatus.NOT_FOUND);
        }
        List<PointLocationModel> list = pointLocDao.getAllPoint();
        return new ResponseEntity<List<PointLocationModel>>(list, HttpStatus.OK);
    }

    @RequestMapping(value = "/insert", method = RequestMethod.POST)
    public ResponseEntity<Void> createPoint(@RequestBody PointLocationModel pointLocationModel, UriComponentsBuilder uriComponentsBuilder) {
        if (pointLocDao.isPointExist(pointLocationModel.getId_censore(),pointLocationModel.getLongitude(), pointLocationModel.getLatitude()) == true) {
            pointLocDao.savePointLoc(pointLocationModel);
            return new ResponseEntity(new ErrorHandling("201", "Data Point berhasil Disimpan"), HttpStatus.CREATED);
        }
        return  new ResponseEntity(new ErrorHandling("409", "Data Point sudah ada"), HttpStatus.CONFLICT);

    }

}
