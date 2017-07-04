package com.banzaidevelopers.ssefisi.Model.Welcome_Classes;

import com.google.gson.annotations.SerializedName;

/**
 * Created by Jose on 25/06/2017.
 */

public class Undergraduate_Home {
    @SerializedName("institucion")
    private String mInstitutionName;
    @SerializedName("programa_academico")
    private String mSchool;
    @SerializedName("anio_ingreso")
    private String mStartDate;
    @SerializedName("anio_egreso")
    private String mEndDate;

    public String getInstitutionName() {
        return mInstitutionName;
    }

    public void setInstitutionName(String mInstitutionName) {
        this.mInstitutionName = mInstitutionName;
    }

    public String getSchool() {
        return mSchool;
    }

    public void setSchool(String mSchool) {
        this.mSchool = mSchool;
    }

    public String getStartDate() {
        return mStartDate;
    }

    public void setStartDate(String mStartDate) {
        this.mStartDate = mStartDate;
    }

    public String getEndDate() {
        return mEndDate;
    }

    public void setEndDate(String mEndDate) {
        this.mEndDate = mEndDate;
    }
}
