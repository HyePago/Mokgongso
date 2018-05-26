package com.example.hyejin.mokgongso_stack;

import com.google.gson.annotations.SerializedName;

/**
 * Created by Mirim on 2018-05-26.
 */

public class FBResult {
    @SerializedName("token")
    private String token;

    public String getToken() {
        return token;
    }
    public void setToken(String token) {
        this.token = token;
    }
}
