package com.banzaidevelopers.ssefisi.UndergraduateShow;

import com.banzaidevelopers.ssefisi.Model.FormacionAcademica;

import java.util.List;

/**
 * Created by Jair Barzola on 04-Jul-17.
 */

public interface UndergraduateShowView {
    void initRecycler(List<FormacionAcademica> formacion_academica);
    void showEmpty();
    void hideEmpty();
    void showProgress();
    void hideProgress();
}
