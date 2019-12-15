package com.mbste.model;

import java.util.Date;

/**
 * is for repracing the client.class
 * becz client has more fields
 */
public class Cnt {
    private Integer clientId;

    //user phone number
    private String phoneNumber;

    //username(unique 10 character string)
    private String username;


    //user password(encrypted)
    private String password;

    //user email address
    private String email;

    //user profile image
    private String profileImage;


    //user created time
    private Date createTime;
    //1:active;0:deactive;99 deleted
    private Integer status;
    //the client the service does
    private Integer serviceId;


//    private String token;


    private Integer rates;


    private String clientAbout;

    private String clientLocation;

    public Integer getClientId() {
        return clientId;
    }

    public void setClientId(Integer clientId) {
        this.clientId = clientId;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getProfileImage() {
        return profileImage;
    }

    public void setProfileImage(String profileImage) {
        this.profileImage = profileImage;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Integer getServiceId() {
        return serviceId;
    }

    public void setServiceId(Integer serviceId) {
        this.serviceId = serviceId;
    }


    public Integer getRates() {
        return rates;
    }

    public void setRates(Integer rates) {
        this.rates = rates;
    }

    public String getClientAbout() {
        return clientAbout;
    }

    public void setClientAbout(String clientAbout) {
        this.clientAbout = clientAbout;
    }

    public String getClientLocation() {
        return clientLocation;
    }

    public void setClientLocation(String clientLocation) {
        this.clientLocation = clientLocation;
    }
}
