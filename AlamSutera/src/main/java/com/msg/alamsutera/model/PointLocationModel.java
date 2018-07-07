package com.msg.alamsutera.model;

/**
 * Created by yoga.wiguna on 5/3/2018.
 */
public class PointLocationModel {

    private int id_point;
    private String longitude;
    private String latitude;
    private String id_censore;
    private String rute;
    private String created_by;
    private String created_on;
    private String updated_by;
    private String updated_on;
    private int status;
    private int id_cluster;

    public PointLocationModel(int id_point,
                              String longitude,
                              String latitude,
                              String id_censore,
                              String rute,
                              String created_by,
                              String created_on,
                              String updated_by,
                              String updated_on,
                              int status,
                              int id_cluster) {
        this.id_point = id_point;
        this.longitude = longitude;
        this.latitude = latitude;
        this.id_censore = id_censore;
        this.rute = rute;
        this.created_by = created_by;
        this.created_on = created_on;
        this.updated_by = updated_by;
        this.updated_on = updated_on;
        this.status = status;
        this.id_cluster = id_cluster;
    }

    public PointLocationModel() {

    }

    public int getId_point() {
        return id_point;
    }

    public void setId_point(int id_point) {
        this.id_point = id_point;
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

    public String getId_censore() {
        return id_censore;
    }

    public void setId_censore(String id_censore) {
        this.id_censore = id_censore;
    }

    public String getBarcode() {
        return rute;
    }

    public void setBarcode(String barcode) {
        this.rute = barcode;
    }

    public String getCreated_by() {
        return created_by;
    }

    public void setCreated_by(String created_by) {
        this.created_by = created_by;
    }

    public String getCreated_on() {
        return created_on;
    }

    public void setCreated_on(String created_on) {
        this.created_on = created_on;
    }

    public String getUpdated_by() {
        return updated_by;
    }

    public void setUpdated_by(String updated_by) {
        this.updated_by = updated_by;
    }

    public String getUpdated_on() {
        return updated_on;
    }

    public void setUpdated_on(String updated_on) {
        this.updated_on = updated_on;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public int getId_cluster() {
        return id_cluster;
    }

    public void setId_cluster(int id_cluster) {
        this.id_cluster = id_cluster;
    }
}
