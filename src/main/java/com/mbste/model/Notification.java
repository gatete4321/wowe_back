package com.mbste.model;

import java.util.Date;

public class Notification
{
    private Integer notficationId;

    private Integer appoitementId;

    private Integer status;//99:deleted;read:1;notread:0

    private Integer actionId;

    private Date doneTime;

    private Integer uwayikozeId;

    private Integer uyikoreweId;

    public Integer getNotficationId() {
        return notficationId;
    }

    public void setNotficationId(Integer notficationId) {
        this.notficationId = notficationId;
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
}
