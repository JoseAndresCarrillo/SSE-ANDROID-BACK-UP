package com.banzaidevelopers.ssefisi;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.banzaidevelopers.ssefisi.Model.PersonalPojo;
import com.banzaidevelopers.ssefisi.Service.PersonalService;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by cristinacaballerohervias on 21/05/17.
 */

public class PersonalShow extends AppCompatActivity {

    //UI Reference
    private TextView mNameView;
    private TextView mDNIView;
    private TextView mBirthdayView;
    private TextView mBirthPlaceView;
    private TextView mCivilStateView;
    private TextView mNChildrenView;
    private TextView mAddressView;
    private TextView mResidencePlace;
    private TextView mPhone;
    private TextView mCellPhone;
    private TextView mPersonalEmailView;
    private TextView mWorkEmailView;
    //Retrofit
    private Retrofit mRestAdapter;
    private PersonalService mPersonalService;
    //Others
    private String mName = "";
    private String mFatherSurname;
    private String mMotherSurname;
    private String mResult;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_personal_show);

        ImageView editView = (ImageView) findViewById(R.id.edit_pers);
        editView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), PersonalEdit.class);
                startActivity(intent);
            }
        });

        mNameView = (TextView) findViewById(R.id.name_text);
        mDNIView = (TextView) findViewById(R.id.dni_text);
        mBirthdayView = (TextView) findViewById(R.id.birthday_text);
        mBirthPlaceView = (TextView) findViewById(R.id.birthplace_text);
        mCivilStateView = (TextView) findViewById(R.id.civilS_text);
        mNChildrenView = (TextView) findViewById(R.id.nchildren_text);
        mAddressView = (TextView) findViewById(R.id.address_text);
        mResidencePlace = (TextView) findViewById(R.id.ubigeo_text);
        mPhone = (TextView) findViewById(R.id.ntelph_text);
        mCellPhone = (TextView) findViewById(R.id.ncell_text);
        mPersonalEmailView = (TextView) findViewById(R.id.per_email_text);
        mWorkEmailView = (TextView) findViewById(R.id.work_email_text);

        /*--------------------------------------Retrofit Implementation--------------------------------------------------*/
        //Rest Connection
        mRestAdapter = new Retrofit.Builder()
                .baseUrl("https://mysterious-sierra-91040.herokuapp.com/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        //Connection PersonalService
        mPersonalService = mRestAdapter.create(PersonalService.class);

        //Rest Implementation
        Call<PersonalPojo> personalCall = mPersonalService.personal(Login.id);
        personalCall.enqueue(new Callback<PersonalPojo>() {
            @Override
            public void onResponse(Call<PersonalPojo> call, Response<PersonalPojo> response) {
                /* Codigo para usar la imagen que trae en el json
                Picasso.with(PersonalShow.this).load("https://i2.wp.com/pensamientoeconomico-unizar.com/wp-content/uploads/2017/02/Alfonso-Redonda-1.png?w=1080&ssl=1").into(mImageView);*/
                //No editable CardView
                mName = response.body().getName_Pers();
                mFatherSurname = response.body().getFatherSurname_Pers();
                mMotherSurname = response.body().getMotherSurname_Pers();
                mResult = mFatherSurname + " " + mMotherSurname + ", " + mName;
                mNameView.setText(mResult.toUpperCase());
                mDNIView.setText(response.body().getDNI_Pers());
                mBirthdayView.setText(response.body().getBirthday_Pers());
                mBirthPlaceView.setText(response.body().getBirthplace_Pers());
                //Editable Cardview
                mCivilStateView.setText(response.body().getCivilState_Pers());
                mNChildrenView.setText(response.body().getNumberChildren_Pers());
                mAddressView.setText(response.body().getAddress_Pers());
                mResidencePlace.setText(response.body().getResidencePlace_Pers());
                mPhone.setText(response.body().getPhone_Pers());
                mCellPhone.setText(response.body().getCellPhone_Pers());
                mPersonalEmailView.setText(response.body().getPersonalEmail_Pers());
                mWorkEmailView.setText(response.body().getWorkEmail_Pers());
            }

            @Override
            public void onFailure(Call<PersonalPojo> call, Throwable t) {
                Toast.makeText(PersonalShow.this, "Tengo un perro q se llama messi", Toast.LENGTH_SHORT).show();
            }
        });
    }

}
