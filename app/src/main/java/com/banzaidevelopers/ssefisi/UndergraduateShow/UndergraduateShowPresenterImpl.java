package com.banzaidevelopers.ssefisi.UndergraduateShow;

import com.banzaidevelopers.ssefisi.Model.FormacionAcademica;

import java.util.List;

/**
 * Created by Jair Barzola on 04-Jul-17.
 */

public class UndergraduateShowPresenterImpl  implements  UndergraduateShowPresenter{
    private UndergraduateShowInteractor interactor;
    private UndergraduateShow view;
    public UndergraduateShowPresenterImpl(UndergraduateShow view){
        this.view=view;
        interactor = new UndergraduateShowInteractorImpl(this);
    }
    @Override
    public void initRecycler(List<FormacionAcademica> formacion_academica) {
        view.initRecycler(formacion_academica);
    }

    @Override
    public void loadListFormacionAcademica() {
        interactor.initRecycler();
    }

    @Override
    public void showEmpty() {
        view.showEmpty();
    }

    @Override
    public void hideEmpty() {
        view.hideEmpty();
    }

    @Override
    public void hideProgress() {
        view.hideProgress();
    }

    @Override
    public void showProgress() {
        view.showProgress();
    }
}
