package com.msg.alamsutera.dao;

import com.msg.alamsutera.model.CekPointModel;

import java.util.List;


/**
 * Created by yoga.wiguna on 4/26/2018.
 */
public interface CekPointDao {

    List<CekPointModel> getAllCekPoint();

//    boolean cekFirstRute(int nxtrute, String idcens);

    boolean getCekPoint(String longitude, String latitude,String id_censore);

//    CekPointModel getNxtRute(int rutes);

    boolean getPointLongLat(String longitude, String latitude);

    boolean getCekUserLogin(String id_employee);

    boolean insertPoint(CekPointModel activityModel);

}
