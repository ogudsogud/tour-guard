package com.msg.alamsutera.dao;

import com.msg.alamsutera.model.InsertPointModel;

/**
 * Created by yoga.wiguna on 5/7/2018.
 */
public interface InsertPointDao {
    boolean cekRuteCluster(InsertPointModel insertPointModel);

    boolean cekNextRute(int rute, String id_censore);
}
