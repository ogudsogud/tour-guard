package com.msg.alamsutera.controller;

import com.msg.alamsutera.dao.ClusterDao;
import com.msg.alamsutera.model.ClusterModel;
import com.msg.alamsutera.model.ErrorHandling;
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
@RequestMapping("alam-sutera/cluster")
public class ClusterController {

    @Autowired
    private ClusterDao clusterDao;

    @RequestMapping("/getallcluster")
    public ResponseEntity<List<ClusterModel>> getAllClu(){
        List<ClusterModel> list = clusterDao.getAllCluster();
        return new ResponseEntity<List<ClusterModel>>(list, HttpStatus.OK);
    }

    @RequestMapping(value = "/insert", method = RequestMethod.POST)
    public ResponseEntity<Void> createCluster(@RequestBody ClusterModel clusterModel, UriComponentsBuilder uriComponentsBuilder) {
        if (clusterDao.isClusExist(clusterModel.getCluster_name()) == true) {
            clusterDao.saveCluster(clusterModel);
            return new ResponseEntity(new ErrorHandling("201", "Data Cluster berhasil Disimpan"), HttpStatus.CREATED);
        }
        return  new ResponseEntity(new ErrorHandling("409", "Data Cluster sudah ada"), HttpStatus.CONFLICT);

    }

}
