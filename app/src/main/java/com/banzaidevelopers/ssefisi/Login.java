package com.banzaidevelopers.ssefisi;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.support.design.widget.TextInputLayout;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.KeyEvent;
import android.view.View;
import android.view.inputmethod.EditorInfo;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.banzaidevelopers.ssefisi.Model.ApiError;
import com.banzaidevelopers.ssefisi.Model.LoginBody;
import com.banzaidevelopers.ssefisi.Model.LoginPojo;
import com.banzaidevelopers.ssefisi.Service.LoginService;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class Login extends AppCompatActivity {

    //Credenciales de prueba
    private static final String DUMMY_USER_ID = "0123456789";
    private static final String DUMMY_PASSWORD = "12345";
    private Retrofit mRestAdapter;

    //UI Reference
    private EditText mUserIdView;
    private EditText mPasswordView;
    private TextInputLayout mFloatLabelUserId;
    private TextInputLayout mFloatLabelPassword;
    private View mProgressView;
    private View mLoginFormView;
    private TextView mForgotPassView;
    private LinearLayout mLogoView;
    private LoginService mLoginService;
    public static String id;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        mLogoView = (LinearLayout) findViewById(R.id.image_logo);
        mUserIdView = (EditText) findViewById(R.id.edit_user);
        mPasswordView = (EditText) findViewById(R.id.password);
        mFloatLabelUserId = (TextInputLayout) findViewById(R.id.float_label_user_id);
        mFloatLabelPassword = (TextInputLayout) findViewById(R.id.float_label_password);
        mProgressView = findViewById(R.id.login_progress);
        mLoginFormView = findViewById(R.id.login_form);
        mForgotPassView = (TextView) findViewById(R.id.forgot_pw);

        //Rest Connection
        mRestAdapter = new Retrofit.Builder()
                .baseUrl("https://mysterious-sierra-91040.herokuapp.com/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        //Connection LoginService
        mLoginService = mRestAdapter.create(LoginService.class);

        //Setup
        Button loginButton = (Button) findViewById(R.id.button_login);
        loginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!isOnline()) {
                    showLoginError("Error en el Servidor");
                    return;
                }
                attemptLogin();

            }
        });

        mPasswordView.setOnEditorActionListener(new TextView.OnEditorActionListener() {
            @Override
            public boolean onEditorAction(TextView textView, int id, KeyEvent keyEvent) {
                if (id == R.id.password || id == EditorInfo.IME_NULL) {
                    if (!isOnline()) {
                        showLoginError("Conexión de red no disponible");
                        return false;
                    }
                    attemptLogin();
                    return true;
                }
                return false;
            }
        });

        mForgotPassView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AlertDialog.Builder dialog = new AlertDialog.Builder(Login.this);
                dialog.setTitle(getString(R.string.pw_dialog_title));
                dialog.setMessage(getString(R.string.pw_dialog_text));
                dialog.show();
            }
        });

    }


    private void attemptLogin() {

        //Reset errors
        mFloatLabelUserId.setError(null);
        mFloatLabelPassword.setError(null);

        //Store values at time of the login attempt
        String userId = mUserIdView.getText().toString();
        String password = mPasswordView.getText().toString();

        boolean cancel = false;
        View focusView = null;
        //Check for a valid password, if the user entered one.
        if (TextUtils.isEmpty(userId)) {
            mFloatLabelUserId.setError("Nombre de Usuario Requerido");
            focusView = mFloatLabelUserId;
            cancel = true;
        } else if (!isUserIdValid(userId)) {
            mFloatLabelUserId.setError("Nombre de Usuario Inválido");
            focusView = mFloatLabelUserId;
            cancel = true;
        }

        //Verificar Password
        if (TextUtils.isEmpty(password)) {
            mFloatLabelPassword.setError("Password Requerida");
            focusView = mFloatLabelPassword;
            cancel = true;
        } else if (!isPasswordValid(password)) {
            mFloatLabelPassword.setError("Password Requerida");
            focusView = mFloatLabelPassword;
            cancel = true;
        }

        if (cancel) {
            focusView.requestFocus();
        } else {
            showProgress(true);
            //Test without Rest
            /*mAuthTask = new UserLoginTask(userId, password);
            mAuthTask.execute((Void) null);*/
            //REST Implementation
            final Call<LoginPojo> loginCall = mLoginService.login(new LoginBody(userId, password));
            loginCall.enqueue(new Callback<LoginPojo>() {
                @Override
                public void onResponse(Call<LoginPojo> call, Response<LoginPojo> response) {
                    showProgress(false);
                    if (!response.isSuccessful()) {
                        String error;
                        if (response.errorBody()
                                .contentType()
                                .subtype()
                                .equals("application/json")) {
                            ApiError apiError = ApiError.fromResponseBody(response.errorBody());

                            error = apiError.getMessage();
                            Log.d("LoginActivity", apiError.getDeveloperMessage());
                        } else {
                            error = response.message();
                        }
                        showLoginError(error);
                        return;

                    }
                    if (Integer.parseInt(response.body().getId_persona()) != -1) {
                        Intent intent = new Intent(Login.this, Home.class);
                        // intent.putExtra("id",response.body().getId_persona());
                        id = response.body().getId_persona();
                        startActivity(intent);
                        finish();
                    } else {
                        Toast.makeText(Login.this, "Usuario o Contraseña Invalido", Toast.LENGTH_SHORT).show();
                    }

                }

                @Override
                public void onFailure(Call<LoginPojo> call, Throwable t) {
                    showProgress(false);
                    showLoginError(t.getMessage());
                }
            });
        }
    }

    private boolean isUserIdValid(String userId) {
        return userId.length() > 4;
    }

    private boolean isPasswordValid(String password) {
        return password.length() > 4;
    }

    private void showProgress(boolean show) {
        mProgressView.setVisibility(show ? View.VISIBLE : View.GONE);

        int visibility = show ? View.GONE : View.VISIBLE;
        mLogoView.setVisibility(visibility);
        mLoginFormView.setVisibility(visibility);
    }

    private void showLoginError(String error) {
        Toast.makeText(this, error, Toast.LENGTH_LONG).show();
    }

    private boolean isOnline() {
        ConnectivityManager cm = (ConnectivityManager) getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo activeNetwork = cm.getActiveNetworkInfo();
        return activeNetwork != null && activeNetwork.isConnected();
    }
}