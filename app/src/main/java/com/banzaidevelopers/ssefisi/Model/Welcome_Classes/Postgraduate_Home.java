package com.banzaidevelopers.ssefisi.Model.Welcome_Classes;

import com.google.gson.annotations.SerializedName;

/**
 * Created by Jose on 25/06/2017.
 */

public class Postgraduate_Home {
    @SerializedName("institucion")
    private String mInstitutionName;
    @SerializedName("tipo_programa_academico")
    private String mProgrammeType;
    @SerializedName("programa_academico")
    private String mProgrammeAcademic;
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

    public String getProgrammeType() {
        return mProgrammeType;
    }

    public void setProgrammeType(String mProgrammeType) {
        this.mProgrammeType = mProgrammeType;
    }

    public String getProgrammeAcademic() {
        return mProgrammeAcademic;
    }

    public void setProgrammeAcademic(String mProgrammeAcademic) {
        this.mProgrammeAcademic = mProgrammeAcademic;
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
