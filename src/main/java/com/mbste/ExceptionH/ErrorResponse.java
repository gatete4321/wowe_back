package com.mbste.ExceptionH;

/**
 * @gatete Rugamba
 * @15/11/2018
 */
public class ErrorResponse
{
    //the status
    private Integer status;
    //the meassage
    private String message;

    private long timeStamp;

    public ErrorResponse() {
    }

    public ErrorResponse(Integer status, String message, long timeStamp) {
        this.status = status;
        this.message = message;
        this.timeStamp = timeStamp;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public long getTimeStamp() {
        return timeStamp;
    }

    public void setTimeStamp(long timeStamp) {
        this.timeStamp = timeStamp;
    }
}
