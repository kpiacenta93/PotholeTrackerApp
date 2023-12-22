package com.techelevator.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.techelevator.dao.PotholeDao;

import java.util.Date;

public class Pothole {

    private int potholeId;


    private int userId;

    private double latitude;

    private double longitude;

    private int severity;

    private String status;

    private Date reportedAt;

    public Date getInspectedDate() {
        return inspectedDate;
    }

    public void setInspectedDate(Date inspectedDate) {
        this.inspectedDate = inspectedDate;
    }

    private Date inspectedDate;
    public Pothole(int potholeId, int userId, double latitude, double longitude, int severity, String status, Date reportedAt) {
        this.potholeId = potholeId;
        this.userId = userId;
        this.latitude = latitude;
        this.longitude = longitude;
        this.severity = severity;
        this.status = status;
        this.reportedAt = reportedAt;
    }

    public Pothole(){

    }
    public int getPotholeId() {
        return potholeId;
    }

    public void setPotholeId(int potholeId) {
        this.potholeId = potholeId;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public double getLatitude() {
        return latitude;
    }

    public void setLatitude(double latitude) {
        this.latitude = latitude;
    }

    public double getLongitude() {
        return longitude;
    }

    public void setLongitude(double longitude) {
        this.longitude = longitude;
    }

    public int getSeverity() {
        return severity;
    }

    public void setSeverity(int severity) {
        this.severity = severity;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Date getReportedAt() {
        return reportedAt;
    }

    public void setReportedAt(Date reportedAt) {
        this.reportedAt = reportedAt;
    }

}
