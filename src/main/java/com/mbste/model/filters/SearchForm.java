package com.mbste.model.filters;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by gatete Rugamba
 * on 10/14/2018
 * Make it work, make it right, make it fast.
 */
public class SearchForm {

    // page number
    private Integer page;

    // pagination offset
    private Integer offset;

    //page count
    private Integer count;

    //pagination by time
    private Date startTime;

    //pagination by time(end time)
    private Date endTime;

    //common search term
    private String searchTerm;

    //start time from front
    private String startTimeStr;

    //end time from front
    private String endTimeStr;

    public Integer getPage() {
        return page;
    }

    public void setPage(Integer page) {
        this.page = page;
    }

    public Integer getOffset() {
        return offset;
    }

    public void setOffset(Integer offset) {
        this.offset = offset;
    }

    public Integer getCount() {
        return count;
    }

    public void setCount(Integer count) {
        this.count = count;
    }

    public Date getStartTime() {
        return startTime;
    }

    public void setStartTime(Date startTime) {
        this.startTime = startTime;
    }

    public Date getEndTime() {
        return endTime;
    }

    public void setEndTime(Date endTime) {
        this.endTime = endTime;
    }

    public String getSearchTerm() {
        return searchTerm;
    }

    public void setSearchTerm(String searchTerm) {
        this.searchTerm = searchTerm;
    }

    public String getStartTimeStr() {
        return startTimeStr;
    }

    public void setStartTimeStr(String startTimeStr) {
        this.startTimeStr = startTimeStr;
    }

    public String getEndTimeStr() {
        return endTimeStr;
    }

    public void setEndTimeStr(String endTimeStr) {
        this.endTimeStr = endTimeStr;
    }

    public void setPaginationDates(){
        SimpleDateFormat sf=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        try {
            if(this.getStartTimeStr()!=null){
                this.startTime= sf.parse(this.startTimeStr);
            }
            if(this.getEndTimeStr()!=null){
                this.endTime =sf.parse(this.endTimeStr);
            }
        } catch (ParseException e) {
            e.printStackTrace();
        }
    }

    //set pagination offsets for page and dates
    public void setPaginationOffset(){
        if(this.page!=null && this.count!=null){
            this.offset=(page-1)*count;
        }else{
            this.offset=null;
        }
        this.setPaginationDates();
    }
}

