package com.msg.alamsutera.model;

/**
 * Created by yoga.wiguna on 5/1/2018.
 */


public class SecureLoginModel {

    private int id_islogin;
    private String id_employee;
    private String security_name;
    private int id_cluster;
    private int id_shift;
    private String time_login;
    private int status_login;
    private String first_id_censore;
    private int first_rute;
    private int next_rute;

    public SecureLoginModel(int id_islogin, String id_employee, String security_name, int id_cluster,
                            int id_shift, String time_login, int status_login, String first_id_censore,
                            int first_rute, int next_rute) {
        this.id_islogin = id_islogin;
        this.id_employee = id_employee;
        this.security_name = security_name;
        this.id_cluster = id_cluster;
        this.id_shift = id_shift;
        this.time_login = time_login;
        this.status_login = status_login;
        this.first_id_censore = first_id_censore;
        this.first_rute = first_rute;
        this.next_rute = next_rute;
    }

    public SecureLoginModel() {

    }


    public int getId_islogin() {
        return id_islogin;
    }

    public void setId_islogin(int id_islogin) {
        this.id_islogin = id_islogin;
    }

    public String getId_employee() {
        return id_employee;
    }

    public void setId_employee(String id_employee) {
        this.id_employee = id_employee;
    }

    public String getSecurity_name() {
        return security_name;
    }

    public void setSecurity_name(String security_name) {
        this.security_name = security_name;
    }

    public int getId_cluster() {
        return id_cluster;
    }

    public void setId_cluster(int id_cluster) {
        this.id_cluster = id_cluster;
    }

    public int getId_shift() {
        return id_shift;
    }

    public void setId_shift(int id_shift) {
        this.id_shift = id_shift;
    }

    public String getTime_login() {
        return time_login;
    }

    public void setTime_login(String time_login) {
        this.time_login = time_login;
    }

    public int getStatus_login() {
        return status_login;
    }

    public void setStatus_login(int status_login) {
        this.status_login = status_login;
    }

    public String getFirst_id_censore() {
        return first_id_censore;
    }

    public void setFirst_id_censore(String first_id_censore) {
        this.first_id_censore = first_id_censore;
    }

    public int getFirst_rute() {
        return first_rute;
    }

    public void setFirst_rute(int first_rute) {
        this.first_rute = first_rute;
    }

    public int getNext_rute(int i) {
        return next_rute;
    }

    public void setNext_rute(int next_rute) {
        this.next_rute = next_rute;
    }
}
