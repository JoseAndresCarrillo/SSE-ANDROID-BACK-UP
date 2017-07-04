package com.banzaidevelopers.ssefisi.Model;

import com.google.gson.annotations.SerializedName;

/**
 * Created by Jose on 28/06/2017.
 */

public class PersonalEditResponse {
    @SerializedName("mensaje")
    String mMessage;

    public String getmMessage() {
        return mMessage;
    }

    public void setmMessage(String mMessage) {
        this.mMessage = mMessage;
    }
}
