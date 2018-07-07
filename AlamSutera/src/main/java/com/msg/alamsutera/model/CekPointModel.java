package com.msg.alamsutera.model;


/**
 * Created by yoga.wiguna on 4/26/2018.
 */
public class CekPointModel {
    private int id_cekpoint;
    private String id_employee;
    private String longitude;
    private String latitude;
    private int id_cluster;
    private String time_cek;
    private String first_id_censore;
    private String id_censore;
    private int id_shift;
    private int first_rute;
    private int rute;
    private int nextrute;



    public CekPointModel(int id_cekpoint, String id_employee, String longitude, String latitude, int id_cluster, String time_cek,String first_id_censore, String id_censore, int id_shift, int first_rute, int rute, int nextrute) {
        this.id_cekpoint = id_cekpoint;
        this.id_employee = id_employee;
        this.longitude = longitude;
        this.latitude = latitude;
        this.id_cluster = id_cluster;
        this.time_cek = time_cek;
        this.first_id_censore = first_id_censore;
        this.id_censore = id_censore;
        this.id_shift = id_shift;
        this.first_rute = first_rute;
        this.rute = rute;
        this.nextrute = nextrute;
    }

    public CekPointModel() {

    }

    public int getId_cekpoint() {
        return id_cekpoint;
    }

    public void setId_cekpoint(int id_cekpoint) {
        this.id_cekpoint = id_cekpoint;
    }

    public String getId_employee() {
        return id_employee;
    }

    public void setId_employee(String id_employee) {
        this.id_employee = id_employee;
    }

    public String getLongitude() {
        return longitude;
    }

    public void setLongitude(String longitude) {
        this.longitude = longitude;
    }

    public String getLatitude() {
        return latitude;
    }

    public void setLatitude(String latitude) {
        this.latitude = latitude;
    }

    public int getId_cluster() {
        return id_cluster;
    }

    public void setId_cluster(int id_cluster) {
        this.id_cluster = id_cluster;
    }

    public String getTime_cek() {
        return time_cek;
    }

    public void setTime_cek(String time_cek) {
        this.time_cek = time_cek;
    }

    public String getFirst_id_censore() {
        return first_id_censore;
    }

    public void setFirst_id_censore(String first_id_censore) {
        this.first_id_censore = first_id_censore;
    }

    public String getId_censore() {
        return id_censore;
    }

    public void setId_censore(String id_censore) {
        this.id_censore = id_censore;
    }

    public int getId_shift() {
        return id_shift;
    }

    public void setId_shift(int id_shift) {
        this.id_shift = id_shift;
    }

    public int getFirst_rute() {
        return first_rute;
    }

    public void setFirst_rute(int first_rute) {
        this.first_rute = first_rute;
    }

    public int getRute() {
        return rute;
    }

    public void setRute(int rute) {
        this.rute = rute;
    }

    public int getNextrute(int i) {
        return nextrute;
    }

    public void setNextrute(int nextrute) {
        this.nextrute = nextrute;
    }
}
