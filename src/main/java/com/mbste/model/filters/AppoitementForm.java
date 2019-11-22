package com.mbste.model.filters;

import com.mbste.model.Appoitement;

import java.util.Date;

public class AppoitementForm extends Appoitement
{
    private long today;

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
