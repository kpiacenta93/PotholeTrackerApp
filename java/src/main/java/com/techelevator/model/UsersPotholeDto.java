package com.techelevator.model;

import java.util.Date;

public class UsersPotholeDto {

    private int potholeid;
    private String username;

    private int userid;
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
    public UsersPotholeDto(int potholeid, String username, int userid, double latitude, double longitude, int severity, String status, Date reportedAt) {
        this.potholeid = potholeid;
        this.username = username;
        this.userid = userid;
        this.latitude = latitude;
        this.longitude = longitude;
        this.severity = severity;
        this.status = status;
        this.reportedAt = reportedAt;
    }

    public UsersPotholeDto() {
    }

    public int getPotholeid() {
        return potholeid;
    }

    public void setPotholeid(int potholeid) {
        this.potholeid = potholeid;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public int getUserid() {
        return userid;
    }

    public void setUserid(int userid) {
        this.userid = userid;
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
