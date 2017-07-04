package com.banzaidevelopers.ssefisi.UndergraduateShow;

import com.banzaidevelopers.ssefisi.Model.FormacionAcademica;

import java.util.List;

/**
 * Created by Jair Barzola on 04-Jul-17.
 */

public interface UndergraduateShowPresenter {
    void initRecycler(List<FormacionAcademica> formacion_academica);
    void loadListFormacionAcademica();
    void showEmpty();
    void hideEmpty();
    void hideProgress();
    void showProgress();
}
