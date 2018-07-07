package com.msg.alamsutera.dao;

import com.msg.alamsutera.model.PointLocationModel;

import java.util.List;

/**
 * Created by yoga.wiguna on 5/3/2018.
 */
public interface PointLocDao {
    List<PointLocationModel> getAllPoint();

    boolean isPointExist(String id_censore, String longitude, String latitude);

    void savePointLoc(PointLocationModel locationModel);
}
