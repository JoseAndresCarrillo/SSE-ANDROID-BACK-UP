package com.banzaidevelopers.ssefisi.Service;

import com.banzaidevelopers.ssefisi.Model.HomePojo;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 * Created by Jose on 25/06/2017.
 */

public interface HomeService {
    @GET("perfil")
    Call<HomePojo> welcome(@Query("id_persona")String id);
}
