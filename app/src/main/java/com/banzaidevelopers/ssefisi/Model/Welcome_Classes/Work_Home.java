package com.banzaidevelopers.ssefisi.Model.Welcome_Classes;

import com.google.gson.annotations.SerializedName;

/**
 * Created by Jose on 25/06/2017.
 */

public class Work_Home {
    @SerializedName("institucion")
    String mInstitutionName;
    @SerializedName("rol")
    String mPosition;
    @SerializedName("fecha_inicio")
    String mWbeginDate;
    @SerializedName("fecha_fin")
    String mWendDate;

    public String getmInstitutionName() {
        return mInstitutionName;
    }

    public void setmInstitutionName(String mInstitutionName) {
        this.mInstitutionName = mInstitutionName;
    }

    public String getmPosition() {
        return mPosition;
    }

    public void setmPosition(String mPosition) {
        this.mPosition = mPosition;
    }

    public String getmWbeginDate() {
        return mWbeginDate;
    }

    public void setmWbeginDate(String mWbeginDate) {
        this.mWbeginDate = mWbeginDate;
    }

    public String getmWendDate() {
        return mWendDate;
    }

    public void setmWendDate(String mWendDate) {
        this.mWendDate = mWendDate;
    }
}
