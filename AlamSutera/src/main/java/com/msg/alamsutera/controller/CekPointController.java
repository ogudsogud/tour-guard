package com.msg.alamsutera.controller;

import com.msg.alamsutera.dao.CekPointDao;
import com.msg.alamsutera.model.CekPointModel;
import com.msg.alamsutera.model.ErrorHandling;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.List;

/**
 * Created by yoga.wiguna on 4/26/2018.
 */

@RestController
@RequestMapping("alam-sutera/cekpoint")
public class CekPointController {
    @Autowired
    private CekPointDao cekPointDao;

//    Untuk menambah data point security yang telah login lalu cek di pos point
    @RequestMapping(value = "/insertpoint", method = RequestMethod.POST)
    public ResponseEntity<Void> insertpoint(@RequestBody CekPointModel pointModel, UriComponentsBuilder componentsBuilder) {
        if (cekPointDao.getCekUserLogin(pointModel.getId_employee()) == false) {
            return new ResponseEntity(new ErrorHandling("404", "User belum Login"), HttpStatus.NOT_FOUND);
        }

//        if(cekPointDao.getNxtRute(pointModel.getRute()) != null) {
//            return new ResponseEntity(new ErrorHandling("404", "Anda belum cek point dengan rute yang benar " + (pointModel.getRute() + 1)), HttpStatus.NOT_FOUND);
//        }

        if (cekPointDao.getCekPoint(pointModel.getLongitude(),pointModel.getLatitude(), pointModel.getId_censore()) == false) {
            return new ResponseEntity(new ErrorHandling("404", "Anda belum cek point yang benar" ), HttpStatus.CONFLICT);
        }
        cekPointDao.insertPoint(pointModel);
        return new ResponseEntity(new ErrorHandling("100", "Data berhasil disimpan"), HttpStatus.CREATED);

//        HttpHeaders headers = new HttpHeaders();
//        headers.setLocation(componentsBuilder.path("/save").buildAndExpand(activityModel.getId_cek_point()).toUri());
//        return new ResponseEntity<Void>(headers, HttpStatus.CREATED);

            }

    @RequestMapping(value = "/lon={lon}/lat={lat}", method = RequestMethod.GET)
    public ResponseEntity<CekPointModel> getPointLongLat(@PathVariable ("lon") String longitude, @PathVariable("lat")String latitude){
        cekPointDao.getPointLongLat(longitude, latitude);
        return new ResponseEntity<CekPointModel>(HttpStatus.OK);
    }

    @RequestMapping(value = "/get-cekpoint", method = RequestMethod.GET)
    public ResponseEntity<List<CekPointModel>> getAllCekPoint() {
        if(cekPointDao.getAllCekPoint().isEmpty()){
            return new ResponseEntity(new ErrorHandling("404", "Data Cek Point Tidak ditemukan"), HttpStatus.NOT_FOUND);
        }
        List<CekPointModel> activityModelList = cekPointDao.getAllCekPoint();
        return new ResponseEntity<List<CekPointModel>>(activityModelList, HttpStatus.OK);
    }


}
