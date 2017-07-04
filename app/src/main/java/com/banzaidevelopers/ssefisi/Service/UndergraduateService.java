package com.banzaidevelopers.ssefisi.Service;

import com.banzaidevelopers.ssefisi.Model.ResponseListadoFormacion;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 * Created by Jair Barzola on 04-Jul-17.
 */

public interface UndergraduateService {
    @GET("listado_formacion")
    Call<ResponseListadoFormacion> getListadoFormacion(@Query("id_persona")int id);
}
