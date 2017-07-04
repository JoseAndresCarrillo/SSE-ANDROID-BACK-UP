package com.banzaidevelopers.ssefisi.Model;

/**
 * Created by Luis05 on 28/06/2017.
 */
public class Undergraduate {
    private String mInstName;
    private String mGdtSchool;
    private int mIdStudy;
    private String mStartDate;
    private String mEndDate;
    private String mExp1;
    private String mExp2;
    private String mRank;
    private String mMode;
    private String mProfSch;
    private int mSchNum;

    public Undergraduate(String mInstName, String mGdtSchool, int mIdStudy, String mStartDate, String mEndDate, String mExp1, String mExp2, String mRank, String mMode, String mProfSch, int mSchNum) {
        this.setmInstName(mInstName);
        this.setmGdtSchool(mGdtSchool);
        this.setmIdStudy(mIdStudy);
        this.setmStartDate(mStartDate);
        this.setmEndDate(mEndDate);
        this.setmExp1(mExp1);
        this.setmExp2(mExp2);
        this.setmRank(mRank);
        this.setmMode(mMode);
        this.setmProfSch(mProfSch);
        this.setmSchNum(mSchNum);
    }

    public String getmInstName() {
        return mInstName;
    }

    public void setmInstName(String mInstName) {
        this.mInstName = mInstName;
    }

    public String getmGdtSchool() {
        return mGdtSchool;
    }

    public void setmGdtSchool(String mGdtSchool) {
        this.mGdtSchool = mGdtSchool;
    }

    public int getmIdStudy() {
        return mIdStudy;
    }

    public void setmIdStudy(int mIdStudy) {
        this.mIdStudy = mIdStudy;
    }

    public String getmStartDate() {
        return mStartDate;
    }

    public void setmStartDate(String mStartDate) {
        this.mStartDate = mStartDate;
    }

    public String getmEndDate() {
        return mEndDate;
    }

    public void setmEndDate(String mEndDate) {
        this.mEndDate = mEndDate;
    }

    public String getmExp1() {
        return mExp1;
    }

    public void setmExp1(String mExp1) {
        this.mExp1 = mExp1;
    }

    public String getmExp2() {
        return mExp2;
    }

    public void setmExp2(String mExp2) {
        this.mExp2 = mExp2;
    }

    public String getmRank() {
        return mRank;
    }

    public void setmRank(String mRank) {
        this.mRank = mRank;
    }

    public String getmMode() {
        return mMode;
    }

    public void setmMode(String mMode) {
        this.mMode = mMode;
    }

    public String getmProfSch() {
        return mProfSch;
    }

    public void setmProfSch(String mProfSch) {
        this.mProfSch = mProfSch;
    }

    public int getmSchNum() {
        return mSchNum;
    }

    public void setmSchNum(int mSchNum) {
        this.mSchNum = mSchNum;
    }
}
