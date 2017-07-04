package com.banzaidevelopers.ssefisi.Model;

import com.banzaidevelopers.ssefisi.Model.Welcome_Classes.Personal_Information_Home;
import com.banzaidevelopers.ssefisi.Model.Welcome_Classes.Postgraduate_Home;
import com.banzaidevelopers.ssefisi.Model.Welcome_Classes.Undergraduate_Home;
import com.banzaidevelopers.ssefisi.Model.Welcome_Classes.Work_Home;
import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;

/**
 * Created by Jose on 25/06/2017.
 */

public class HomePojo {
    private String mPhoto;
    @SerializedName("apellido_paterno")
    private String mFatherSurname;
    @SerializedName("apellido_materno")
    private String mMotherSurname;
    @SerializedName("nombres")
    private String mName;
    @SerializedName("datos_personales")
    private Personal_Information_Home mPersonalInformation;
    @SerializedName("formacion_academica")
    private ArrayList<Undergraduate_Home> mUndergraduate;
    @SerializedName("estudios_postgrado")
    private ArrayList<Postgraduate_Home> mPostgraduate;
    //@SerializedName("experiencia_laboral")
    private ArrayList<Work_Home> mWork;


    public String getPhoto() {
        return mPhoto;
    }

    public void setPhoto(String mPhoto) {
        this.mPhoto = mPhoto;
    }

    public String getFatherSurname() {
        return mFatherSurname;
    }

    public void setFatherSurname(String mFatherSurname) {
        this.mFatherSurname = mFatherSurname;
    }

    public String getMotherSurname() {
        return mMotherSurname;
    }

    public void setMotherSurname(String mMotherSurname) {
        this.mMotherSurname = mMotherSurname;
    }

    public String getName() {
        return mName;
    }

    public void setName(String mName) {
        this.mName = mName;
    }

    public Personal_Information_Home getPersonalInformation() {
        return mPersonalInformation;
    }

    public void setPersonalInformation(Personal_Information_Home mPersonalInformation) {
        this.mPersonalInformation = mPersonalInformation;
    }

    public ArrayList<Undergraduate_Home> getUndergraduate() {
        return mUndergraduate;
    }

    public void setUndergraduate(ArrayList<Undergraduate_Home> mUndergraduate) {
        this.mUndergraduate = mUndergraduate;
    }

    public ArrayList<Postgraduate_Home> getPostgraduate() {
        return mPostgraduate;
    }

    public void setPostgraduate(ArrayList<Postgraduate_Home> mPostgraduate) {
        this.mPostgraduate = mPostgraduate;
    }

    public ArrayList<Work_Home> getWork() {
        return mWork;
    }

    public void setWork(ArrayList<Work_Home> mWork) {
        this.mWork = mWork;
    }
}
