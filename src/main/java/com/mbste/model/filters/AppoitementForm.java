package com.mbste.model.filters;

import com.mbste.model.Appoitement;

import java.util.Date;

public class AppoitementForm extends Appoitement
{
    private long today;

    private String uyikozeName;

    public String getUyikozeName() {
        return uyikozeName;
    }

    public void setUyikozeName(String uyikozeName) {
        this.uyikozeName = uyikozeName;
    }

    public long getToday() {
        return today;
    }

    public void setToday(long today) {
        this.today = today;
    }

    public void convertDate(){
        this.setDoneTime(new Date(today));
    }
}
