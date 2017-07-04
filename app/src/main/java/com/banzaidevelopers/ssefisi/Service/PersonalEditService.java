package com.banzaidevelopers.ssefisi.Service;

import com.banzaidevelopers.ssefisi.Model.PersonalEditPojo;
import com.banzaidevelopers.ssefisi.Model.PersonalEditResponse;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.POST;

/**
 * Created by Jose on 28/06/2017.
 */

public interface PersonalEditService {
    @POST("actualizar_datos_personales")
    Call<PersonalEditResponse> edit(@Body PersonalEditPojo personalEditPojo);
}
