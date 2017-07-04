package com.banzaidevelopers.ssefisi.UndergraduateShow;

import android.util.Log;
import android.widget.Toast;

import com.banzaidevelopers.ssefisi.Model.FormacionAcademica;
import com.banzaidevelopers.ssefisi.Model.ResponseListadoFormacion;
import com.banzaidevelopers.ssefisi.Service.UndergraduateService;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by Jair Barzola on 04-Jul-17.
 */

public class UndergraduateShowInteractorImpl implements UndergraduateShowInteractor {

    private UndergraduateShowPresenter presenter;

    public UndergraduateShowInteractorImpl ( UndergraduateShowPresenter presenter){
        this.presenter= presenter;
    }
    @Override
    public void initRecycler() {
        presenter.showProgress();
        //Conexion con el webservice
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://mysterious-sierra-91040.herokuapp.com/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        UndergraduateService service = retrofit.create(UndergraduateService.class);
        Call<ResponseListadoFormacion> formacionAcademicaCall = service.getListadoFormacion(1);
        formacionAcademicaCall.enqueue(new Callback<ResponseListadoFormacion>() {
            @Override
            public void onResponse(Call<ResponseListadoFormacion> call, Response<ResponseListadoFormacion> response) {
                ResponseListadoFormacion result = response.body();
                Log.i("DEBUG",response.message());
                if(result.getFormacion_academica().isEmpty()){
                    presenter.hideProgress();
                    presenter.showEmpty();
                }else{
                    List<FormacionAcademica> formacion_academica = new ArrayList<FormacionAcademica>();
                    formacion_academica =result.getFormacion_academica();
                    presenter.hideProgress();
                    presenter.hideEmpty();
                    presenter.initRecycler(formacion_academica);
                }

            }

            @Override
            public void onFailure(Call<ResponseListadoFormacion> call, Throwable t) {
                presenter.hideProgress();
                presenter.showEmpty();
            }
        });


    }
}
