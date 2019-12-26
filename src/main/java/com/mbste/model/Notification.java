package com.mbste.model;

import java.util.Date;

public class Notification
{
    private Integer notificationId;

    private Integer appoitementId;

    private Integer status;//99:deleted;read:1;notread:0

    private Integer actionId;

    private Date doneTime;

    private Integer uwayikozeId;

    private Integer uyikoreweId;

    private String uwayikozeName;

    private Integer recentNotificationId;

    private Integer serviceId;

    private String description;

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Integer getServiceId() {
        return serviceId;
    }

    public void setServiceId(Integer serviceId) {
        this.serviceId = serviceId;
    }

    public Integer getRecentNotificationId() {
        return recentNotificationId;
    }

    public void setRecentNotificationId(Integer recentNotificationId) {
        this.recentNotificationId = recentNotificationId;
    }

    public Integer getNotificationId() {
        return notificationId;
    }

    public void setNotificationId(Integer notificationId) {
        this.notificationId = notificationId;
    }

    public Integer getAppoitementId() {
        return appoitementId;
    }

    public void setAppoitementId(Integer appoitementId) {
        this.appoitementId = appoitementId;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Integer getActionId() {
        return actionId;
    }

    public void setActionId(Integer actionId) {
        this.actionId = actionId;
    }

    public Integer getUwayikozeId() {
        return uwayikozeId;
    }

    public void setUwayikozeId(Integer uwayikozeId) {
        this.uwayikozeId = uwayikozeId;
    }

    public Integer getUyikoreweId() {
        return uyikoreweId;
    }

    public void setUyikoreweId(Integer uyikoreweId) {
        this.uyikoreweId = uyikoreweId;
    }

    public Date getDoneTime() {
        return doneTime;
    }

    public void setDoneTime(Date doneTime) {
        this.doneTime = doneTime;
    }

    public String getUwayikozeName() {
        return uwayikozeName;
    }

    public void setUwayikozeName(String uwayikozeName) {
        this.uwayikozeName = uwayikozeName;
    }

}
