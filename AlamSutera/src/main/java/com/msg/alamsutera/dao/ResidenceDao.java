package com.msg.alamsutera.dao;

import com.msg.alamsutera.model.ResidenceModel;

import java.util.List;

/**
 * Created by yoga.wiguna on 4/23/2018.
 */
public interface ResidenceDao {

    boolean isUserExist(String email, String paswd);
    List<ResidenceModel> getAllUserRes();
    void save(ResidenceModel residenceModel);

}
