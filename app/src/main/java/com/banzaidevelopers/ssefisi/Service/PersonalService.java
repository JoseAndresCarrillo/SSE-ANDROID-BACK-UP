package com.banzaidevelopers.ssefisi.Service;

import com.banzaidevelopers.ssefisi.Model.PersonalPojo;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 * Created by Jose on 27/06/2017.
 */

public interface PersonalService {
    @GET("perfil/informacion_personal")
    Call<PersonalPojo> personal(@Query("id_persona")String id);
}
