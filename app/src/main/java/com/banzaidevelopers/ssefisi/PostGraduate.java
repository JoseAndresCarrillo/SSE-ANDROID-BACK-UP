package com.banzaidevelopers.ssefisi;
public class PostGraduate {
    int mIdStudy;
    String mInstitutionName;
    String mInstitutionType;
    String mProgrammeName;
    String mProgrammeType;
    String mStartDate;
    String mEndDate;
    String mCertificationDate;
    int mhoraslectivas;


    public PostGraduate(int mIdStudy, String mInstitutionName, String mInstitutionType, String mProgrammeName, String mProgrammeType, String mStartDate, String mEndDate, String mCertificationDate, int mhoraslectivas) {
        this.mIdStudy = mIdStudy;
        this.mInstitutionName = mInstitutionName;
        this.mInstitutionType = mInstitutionType;
        this.mProgrammeName = mProgrammeName;
        this.mProgrammeType = mProgrammeType;
        this.mStartDate = mStartDate;
        this.mEndDate = mEndDate;
        this.mCertificationDate = mCertificationDate;
        this.mhoraslectivas = mhoraslectivas;
    }

    public int getmIdStudy() {
        return mIdStudy;
    }

    public String getmInstitutionName() {
        return mInstitutionName;
    }

    public String getmInstitutionType() {
        return mInstitutionType;
    }

    public String getmProgrammeName() {
        return mProgrammeName;
    }

    public String getmProgrammeType() {
        return mProgrammeType;
    }

    public String getmStartDate() {
        return mStartDate;
    }

    public String getmEndDate() {
        return mEndDate;
    }

    public String getmCertificationDate() {
        return mCertificationDate;
    }

    public int getMhoraslectivas() {
        return mhoraslectivas;
    }

    public void setmIdStudy(int mIdStudy) {
        this.mIdStudy = mIdStudy;
    }

    public void setmInstitutionName(String mInstitutionName) {
        this.mInstitutionName = mInstitutionName;
    }

    public void setmInstitutionType(String mInstitutionType) {
        this.mInstitutionType = mInstitutionType;
    }

    public void setmProgrammeName(String mProgrammeName) {
        this.mProgrammeName = mProgrammeName;
    }

    public void setmProgrammeType(String mProgrammeType) {
        this.mProgrammeType = mProgrammeType;
    }

    public void setmStartDate(String mStartDate) {
        this.mStartDate = mStartDate;
    }

    public void setmEndDate(String mEndDate) {
        this.mEndDate = mEndDate;
    }

    public void setmCertificationDate(String mCertificationDate) {
        this.mCertificationDate = mCertificationDate;
    }

    public void setMhoraslectivas(int mhoraslectivas) {
        this.mhoraslectivas = mhoraslectivas;
    }
}
