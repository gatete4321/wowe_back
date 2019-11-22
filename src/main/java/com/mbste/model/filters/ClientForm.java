package com.mbste.model.filters;

import com.mbste.model.Client;

/**
 * Created by Gatete Rugamba
 * on 10/14/2018
 * Make it work, make it right, make it fast.
 */
public class ClientForm extends Client {

    private String recentPassword;

    public String getRecentPassword() {
        return recentPassword;
    }

    public void setRecentPassword(String recentPassword) {
        this.recentPassword = recentPassword;
    }
}
