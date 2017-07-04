package com.banzaidevelopers.ssefisi.Model;

import com.banzaidevelopers.ssefisi.PersonalEdit;
import com.google.gson.annotations.SerializedName;

/**
 * Created by cristinacaballerohervias on 30/05/17.
 */

public class PersonalEditPojo {
    @SerializedName("telefono_fijo")
    private String mPhone;
    @SerializedName("id_persona")
    private int mIdPerson;
    @SerializedName("correo_personal")
    private String mPersEmail;
    @SerializedName("numero_hijos")
    private int mChildren;
    @SerializedName("telefono_celular")
    private String mCellphone;
    @SerializedName("direccion")
    private String mAddress;
    @SerializedName("ubigeo_residencia")
    private String mResidencePlace;
    @SerializedName("correo_laboral")
    private String mWorkEmail;
    @SerializedName("estado_civil")
    private String mCivilState;

    public PersonalEditPojo() {
    }

    public PersonalEditPojo(int mIdPerson, String mCivilState, int mChildren, String mAddress, String mResidencePlace, String mPhone, String mCellphone, String mPersEmail, String mWorkEmail) {
        this.mIdPerson = mIdPerson;
        this.mCivilState = mCivilState;
        this.mChildren = mChildren;
        this.mAddress = mAddress;
        this.mResidencePlace = mResidencePlace;
        this.mPhone = mPhone;
        this.mCellphone = mCellphone;
        this.mPersEmail = mPersEmail;
        this.mWorkEmail = mWorkEmail;
    }

    public int getIdPerson() {
        return mIdPerson;
    }

    public void setIdPerson(int mIdPerson) {
        this.mIdPerson = mIdPerson;
    }

    public String getCivilState() {
        return mCivilState;
    }

    public void setCivilState(String mCivilState) {
        this.mCivilState = mCivilState;
    }

    public int getChildren() {
        return mChildren;
    }

    public void setChildren(int mChildren) {
        this.mChildren = mChildren;
    }

    public String getAddress() {
        return mAddress;
    }

    public void setAddress(String mAddress) {
        this.mAddress = mAddress;
    }

    public String getResidencePlace() {
        return mResidencePlace;
    }

    public void setResidencePlace(String mResidencePlace) {
        this.mResidencePlace = mResidencePlace;
    }

    public String getPhone() {
        return mPhone;
    }

    public void setPhone(String mPhone) {
        this.mPhone = mPhone;
    }

    public String getCellphone() {
        return mCellphone;
    }

    public void setCellphone(String mCellphone) {
        this.mCellphone = mCellphone;
    }

    public String getPersEmail() {
        return mPersEmail;
    }

    public void setPersEmail(String mPersEmail) {
        this.mPersEmail = mPersEmail;
    }

    public String getWorkEmail() {
        return mWorkEmail;
    }

    public void setWorkEmail(String mWorkEmail) {
        this.mWorkEmail = mWorkEmail;
    }
}
