package com.msg.alamsutera.model;


import java.util.Date;

/**
 * Created by yoga.wiguna on 4/21/2018.
 */

public class ResidenceModel {

    private int id_user_residence;
    private String user_name;
//    private String cluster;
    private String blok;
    private String work;
    private String created_by;
    private Date created_on;
    private String updated_by;
    private Date updated_on;
    private int status;
    private String email;
    private String password;
    private int id_cluster;


    public ResidenceModel(int id_user_residence,
                              String user_name,
//                              String cluster,
                              String blok,
                              String work,
                              String created_by,
                              Date created_on,
                              String updated_by,
                              Date updated_on,
                              int status,
                              String email,
                              String password,
                              int id_cluster) {
        this.id_user_residence = id_user_residence;
        this.user_name = user_name;
//        this.cluster = cluster;
        this.blok = blok;
        this.work = work;
        this.created_by = created_by;
        this.created_on = created_on;
        this.updated_by = updated_by;
        this.updated_on = updated_on;
        this.status = status;
        this.email = email;
        this.password = password;
        this.id_cluster = id_cluster;
    }

    public ResidenceModel() {

    }

    public int getId_user_residence() {
        return id_user_residence;
    }

    public void setId_user_residence(int id_user_residence) {
        this.id_user_residence = id_user_residence;
    }

    public String getUser_name() {
        return user_name;
    }

    public void setUser_name(String user_name) {
        this.user_name = user_name;
    }

//    public String getCluster() {
//        return cluster;
//    }
//
//    public void setCluster(String cluster) {
//        this.cluster = cluster;
//    }

    public String getBlok() {
        return blok;
    }

    public void setBlok(String blok) {
        this.blok = blok;
    }

    public String getWork() {
        return work;
    }

    public void setWork(String work) {
        this.work = work;
    }

    public String getCreated_by() {
        return created_by;
    }

    public void setCreated_by(String created_by) {
        this.created_by = created_by;
    }

    public Date getCreated_on() {
        return created_on;
    }

    public void setCreated_on(Date created_on) {
        this.created_on = created_on;
    }

    public String getUpdated_by() {
        return updated_by;
    }

    public void setUpdated_by(String updated_by) {
        this.updated_by = updated_by;
    }

    public Date getUpdated_on() {
        return updated_on;
    }

    public void setUpdated_on(Date updated_on) {
        this.updated_on = updated_on;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getId_cluster() {
        return id_cluster;
    }

    public void setId_cluster(int id_cluster) {
        this.id_cluster = id_cluster;
    }

//    @Override
//    public String toString() {
//        return "UserResidenceModel [id_user_residence=" +id_user_residence+", " +
//                                    "nama_user = "+nama_user+", " +
//                                    "cluster = "+cluster+", " +
//                                    "blok  = "+blok+", " +
//                                    "nama_user = "+pekerjaan+", " +
//                                    "created_by = "+created_by+"," +
//                                    "created_on = "+created_on+", " +
//                                    "updated_by = "+updated_by+", " +
//                                    "updated_on = "+updated_on+"," +
//                                    "status = "+status+", " +
//                                    "email = "+email+", " +
//                                    "password = "+password+", " +
//                                    "id_cluster = "+id_cluster+"";
//    }
}
