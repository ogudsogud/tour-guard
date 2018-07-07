package com.msg.alamsutera.model;

/**
 * Created by yoga.wiguna on 5/7/2018.
 */
public class InsertPointModel {

    private int id_insertpoint;
    private String point_name;
    private int rute;
    private String id_censore;
    private int id_cluster;
    private int next_rute;

    public InsertPointModel(int id_insertpoint, String point_name, int rute, String id_censore, int id_cluster, int next_rute) {
        this.id_insertpoint = id_insertpoint;
        this.point_name = point_name;
        this.rute = rute;
        this.id_censore = id_censore;
        this.id_cluster = id_cluster;
        this.next_rute = next_rute;
    }

    public InsertPointModel() {

    }

    public int getId_insertpoint() {
        return id_insertpoint;
    }

    public void setId_insertpoint(int id_insertpoint) {
        this.id_insertpoint = id_insertpoint;
    }

    public String getPoint_name() {
        return point_name;
    }

    public void setPoint_name(String point_name) {
        this.point_name = point_name;
    }

    public int getRute() {
        return rute;
    }

    public void setRute(int rute) {
        this.rute = rute;
    }

    public String getId_censore() {
        return id_censore;
    }

    public void setId_censore(String id_censore) {
        this.id_censore = id_censore;
    }

    public int getId_cluster() {
        return id_cluster;
    }

    public void setId_cluster(int id_cluster) {
        this.id_cluster = id_cluster;
    }

    public int getNext_rute() {
        return next_rute;
    }

    public void setNext_rute(int next_rute) {
        this.next_rute = next_rute;
    }

    public int getNext_rute(int i) {
        return 0;
    }
}
