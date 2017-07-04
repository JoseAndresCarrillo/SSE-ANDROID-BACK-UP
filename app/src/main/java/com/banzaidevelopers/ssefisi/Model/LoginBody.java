package com.banzaidevelopers.ssefisi.Model;

import com.google.gson.annotations.SerializedName;

/**
 * Created by Jose on 17/06/2017.
 */

public class LoginBody {
    @SerializedName("username")
    private String username;
    private String password;

    public LoginBody(String username, String password) {
        this.username = username;
        this.password = password;
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
}
