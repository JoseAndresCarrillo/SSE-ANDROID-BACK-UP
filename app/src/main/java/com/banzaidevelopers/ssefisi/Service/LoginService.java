package com.banzaidevelopers.ssefisi.Service;

import com.banzaidevelopers.ssefisi.Model.LoginBody;
import com.banzaidevelopers.ssefisi.Model.LoginPojo;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.POST;

/**
 * Created by Jose on 17/06/2017.
 */

public interface LoginService {
    @POST("login")
    Call<LoginPojo> login(@Body LoginBody loginBody);

}
