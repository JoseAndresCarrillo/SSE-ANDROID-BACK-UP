package com.banzaidevelopers.ssefisi.Model.Welcome_Classes;

import com.google.gson.annotations.SerializedName;

/**
 * Created by Jose on 25/06/2017.
 */

public class Personal_Information_Home {
    @SerializedName("numero_documento")
    private String mDNI;
    @SerializedName("fecha_nacimiento")
    private String mBirthday;
    @SerializedName("estado_civil")
    private String mCivilState;
    @SerializedName("direccion")
    private String mAddress;

    public String getDNI() {
        return mDNI;
    }

    public void setDNI(String mDNI) {
        this.mDNI = mDNI;
    }

    public String getBirthday() {
        return mBirthday;
    }

    public void setBirthday(String mBirthday) {
        this.mBirthday = mBirthday;
    }

    public String getCivilState() {
        return mCivilState;
    }

    public void setCivilState(String mCivilState) {
        this.mCivilState = mCivilState;
    }

    public String getAddress() {
        return mAddress;
    }

    public void setAddress(String mAddress) {
        this.mAddress = mAddress;
    }
}
