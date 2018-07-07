package com.msg.alamsutera.dao;

import com.msg.alamsutera.model.SecureLoginModel;

/**
 * Created by yoga.wiguna on 5/1/2018.
 */
public interface SecureLoginDao {

    void insertLogin(SecureLoginModel loginModel);

    boolean isUserSecExsist(String id_employee);

    boolean isLoginExist(String id_employee);

    boolean isAnyLoginInClus(int idclus, int idshif);

    SecureLoginModel getUserLogin(String id_empl);
}
