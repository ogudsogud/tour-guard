package com.msg.alamsutera.dao;

import com.msg.alamsutera.model.ClusterModel;

import java.util.List;

/**
 * Created by yoga.wiguna on 5/3/2018.
 */
public interface ClusterDao {


    List<ClusterModel> getAllCluster();

    boolean isClusExist(String cluster_name);

    void saveCluster(ClusterModel clusterModel);
}
