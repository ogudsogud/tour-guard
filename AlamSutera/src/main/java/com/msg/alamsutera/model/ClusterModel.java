package com.msg.alamsutera.model;

/**
 * Created by yoga.wiguna on 5/3/2018.
 */
public class ClusterModel {

    private int id_cluster;
    private String cluster_name;
    private String cluster_large;
    private int unit_qty;
    private String created_by;
    private String created_on;
    private String updated_by;
    private String updated_on;
    private int status;
    private int id_sektor;

    public ClusterModel(int id_cluster, String cluster_name, String cluster_large, int unit_qty, String created_by, String created_on, String updated_by, String updated_on, int status, int id_sektor) {
        this.id_cluster = id_cluster;
        this.cluster_name = cluster_name;
        this.cluster_large = cluster_large;
        this.unit_qty = unit_qty;
        this.created_by = created_by;
        this.created_on = created_on;
        this.updated_by = updated_by;
        this.updated_on = updated_on;
        this.status = status;
        this.id_sektor = id_sektor;
    }

    public ClusterModel() {

    }

    public int getId_cluster() {
        return id_cluster;
    }

    public void setId_cluster(int id_cluster) {
        this.id_cluster = id_cluster;
    }

    public String getCluster_name() {
        return cluster_name;
    }

    public void setCluster_name(String cluster_name) {
        this.cluster_name = cluster_name;
    }

    public String getCluster_large() {
        return cluster_large;
    }

    public void setCluster_large(String cluster_large) {
        this.cluster_large = cluster_large;
    }

    public int getUnit_qty() {
        return unit_qty;
    }

    public void setUnit_qty(int unit_qty) {
        this.unit_qty = unit_qty;
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

    public int getId_sektor() {
        return id_sektor;
    }

    public void setId_sektor(int id_sektor) {
        this.id_sektor = id_sektor;
    }
}
