package com.banzaidevelopers.ssefisi;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.util.Patterns;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import com.banzaidevelopers.ssefisi.Model.PersonalEditPojo;
import com.banzaidevelopers.ssefisi.Model.PersonalEditResponse;
import com.banzaidevelopers.ssefisi.Model.PersonalPojo;
import com.banzaidevelopers.ssefisi.Service.PersonalEditService;
import com.banzaidevelopers.ssefisi.Service.PersonalService;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by cristinacaballerohervias on 21/05/17.
 */

public class PersonalEdit extends AppCompatActivity {

    PersonalEditPojo gdtTest;
    //UI Reference
    private Spinner gdtCivilState;
    private EditText gdtChildren;
    private EditText gdtAddress;
    private EditText gdtResidence;
    /*private EditText gdtAddDep;
    private EditText gdtAddPro;
    private EditText gdtAddDis;*/
    private EditText gdtPhone;
    private EditText gdtCellphone;
    private EditText gdtPersEmail;
    private EditText gdtWorkEmail;
    //Retrofit
    private Retrofit mRestAdapter;
    private PersonalService mPersonalService;
    private PersonalEditService mPersonalEditService;
    //Others
    private ArrayList<String> mCivilState = new ArrayList<String>();
    int position = 0;
    private String mSpinner;
    String mResult = "";
    String mensaje = "Actualización exitosa";
    private ArrayAdapter<String> adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_personal_edit);
        adapter = new ArrayAdapter<String>(PersonalEdit.this, android.R.layout.simple_spinner_item, mCivilState);
        mCivilState.add("Casado");
        mCivilState.add("Soltero");
        mCivilState.add("Viudo");
        mCivilState.add("Divorciado");
        gdtCivilState = (Spinner) findViewById(R.id.gdt_civil_state);
        gdtChildren = (EditText) findViewById(R.id.gdt_children);
        gdtAddress = (EditText) findViewById(R.id.gdt_address);
        gdtResidence = (EditText) findViewById(R.id.gdt_residence_place);
        /*gdtAddDep = (EditText) findViewById(R.id.gdt_add_dep);
        gdtAddPro = (EditText) findViewById(R.id.gdt_add_pro);
        gdtAddDis = (EditText) findViewById(R.id.gdt_add_dis);*/
        gdtPhone = (EditText) findViewById(R.id.gdt_phone);
        gdtCellphone = (EditText) findViewById(R.id.gdt_cellphone);
        gdtPersEmail = (EditText) findViewById(R.id.gdt_pers_email);
        gdtWorkEmail = (EditText) findViewById(R.id.gdt_work_email);
        //-------------------------------Retrofit Implementation(Show)
        //Rest Connection
        mRestAdapter = new Retrofit.Builder()
                .baseUrl("https://mysterious-sierra-91040.herokuapp.com/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        //Connection PersonalService
        mPersonalService = mRestAdapter.create(PersonalService.class);
        //Rest Implementation
        Call<PersonalPojo> personalCall = mPersonalService.personal("1");
        personalCall.enqueue(new Callback<PersonalPojo>() {
            @Override
            public void onResponse(Call<PersonalPojo> call, Response<PersonalPojo> response) {
                for (int i = 0; i < mCivilState.size(); i++) {
                    if (response.body().getCivilState_Pers().equals(mCivilState.get(i).toString())) {
                        position = i;
                    }
                }
                gdtCivilState.setAdapter(adapter);
                gdtCivilState.setSelection(position);
                gdtCivilState.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                    @Override
                    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                        mSpinner = adapter.getItem(position);
                    }

                    @Override
                    public void onNothingSelected(AdapterView<?> parent) {

                    }
                });

                gdtChildren.setText(response.body().getNumberChildren_Pers());
                gdtAddress.setText(response.body().getAddress_Pers());
                gdtResidence.setText(response.body().getResidencePlace_Pers());
                /*gdtAddDep.setText(response.body().);
                gdtAddPro.setText(response.body());
                gdtAddDis.setText(response.body());*/
                gdtPhone.setText(response.body().getPhone_Pers());
                gdtCellphone.setText(response.body().getCellPhone_Pers());
                gdtPersEmail.setText(response.body().getPersonalEmail_Pers());
                gdtWorkEmail.setText(response.body().getWorkEmail_Pers());
            }

            @Override
            public void onFailure(Call<PersonalPojo> call, Throwable t) {
                Toast.makeText(PersonalEdit.this, "tengo un perro que se llama messi", Toast.LENGTH_SHORT).show();
            }
        });


        //------------------------------------------------------------------------------------------

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_save, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int idItem = item.getItemId();
        boolean flag;
        gdtTest = new PersonalEditPojo();
        if (idItem == R.id.action_save) {
            flag = validateInformation();
//            Toast.makeText(this, mSpinner, Toast.LENGTH_SHORT).show();
//            Toast.makeText(this, String.valueOf(Integer.parseInt(Login.id)), Toast.LENGTH_SHORT).show();
//            Toast.makeText(this, gdtAddress.getText().toString(), Toast.LENGTH_SHORT).show();
//            Toast.makeText(this, gdtResidence.getText().toString(), Toast.LENGTH_SHORT).show();
//            Toast.makeText(this, gdtPhone.getText().toString(), Toast.LENGTH_SHORT).show();
//            Toast.makeText(this, gdtCellphone.getText().toString(), Toast.LENGTH_SHORT).show();
//            Toast.makeText(this, gdtPersEmail.getText().toString(), Toast.LENGTH_SHORT).show();
//            Toast.makeText(this, gdtWorkEmail.getText().toString(), Toast.LENGTH_SHORT).show();
//            gdtTest=new PersonalEditPojo(Integer.parseInt(Login.id),gdtCivilState.toString(),Integer.parseInt(gdtChildren.getText().toString()),gdtAddress.toString(),gdtResidence.toString(),gdtPhone.toString(),gdtCellphone.toString(),gdtPersEmail.toString(),gdtWorkEmail.toString());
            gdtTest.setIdPerson(Integer.parseInt(Login.id));
            gdtTest.setCivilState(mSpinner);
            gdtTest.setChildren(Integer.parseInt(gdtChildren.getText().toString()));
            gdtTest.setAddress(gdtAddress.getText().toString());
            gdtTest.setResidencePlace(gdtResidence.getText().toString());
            gdtTest.setPhone(gdtPhone.getText().toString());
            gdtTest.setCellphone(gdtCellphone.getText().toString());
            gdtTest.setPersEmail(gdtPersEmail.getText().toString());
            gdtTest.setWorkEmail(gdtWorkEmail.getText().toString());

            //Retrofit Implementation

            //Rest Connection
            mRestAdapter = new Retrofit.Builder()
                    .baseUrl("https://mysterious-sierra-91040.herokuapp.com/")
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();

            //Connection PersonalEditService
            mPersonalEditService = mRestAdapter.create(PersonalEditService.class);

            //Rest Implementation
            Call<PersonalEditResponse> personalEditCall = mPersonalEditService.edit(gdtTest);
            if(flag==false){
                personalEditCall.enqueue(new Callback<PersonalEditResponse>() {
                    @Override
                    public void onResponse(Call<PersonalEditResponse> call, Response<PersonalEditResponse> response) {
                        mResult = response.body().getmMessage();
                        Toast.makeText(PersonalEdit.this, mResult, Toast.LENGTH_SHORT).show();
                        Intent intent = new Intent(getApplicationContext(), PersonalShow.class);
                        startActivity(intent);
                    }

                    @Override
                    public void onFailure(Call<PersonalEditResponse> call, Throwable t) {
                        Toast.makeText(PersonalEdit.this, t.getMessage(), Toast.LENGTH_SHORT).show();
                    }
                });
            }
        }
        return super.onOptionsItemSelected(item);
    }

    private boolean isValidEmail(String email) {
        return Patterns.EMAIL_ADDRESS.matcher(email).matches();
    }

    private boolean validateInformation() {
        String mChildren;
        String mAddress;
        String mPhone;
        String mCellPhone;
        String mPersonalEmail;
        String mWorkEmail;
        boolean mCancel = false;

        mChildren = gdtChildren.getText().toString();
        mAddress = gdtAddress.getText().toString();
        mPhone = gdtPhone.getText().toString();
        mCellPhone = gdtCellphone.getText().toString();
        mPersonalEmail = gdtPersEmail.getText().toString();
        mWorkEmail = gdtWorkEmail.getText().toString();

        if (TextUtils.isEmpty(mChildren)) {
            Toast.makeText(this, "Numero de Hijos vacio", Toast.LENGTH_SHORT).show();
            mCancel = true;
        }

        if (TextUtils.isEmpty(mAddress)) {
            Toast.makeText(this, "Direccion vacia", Toast.LENGTH_SHORT).show();
            mCancel = true;
        }

        if (TextUtils.isEmpty(mPhone)) {
            Toast.makeText(this, "Telefono fijo vacio", Toast.LENGTH_SHORT).show();
            mCancel = true;
        } else if (mPhone.length() > 8) {
            Toast.makeText(this, "Telefono fijo inválido", Toast.LENGTH_SHORT).show();
            mCancel = true;
        }

        if (TextUtils.isEmpty(mCellPhone)) {
            Toast.makeText(this, "Telefono movil vacio", Toast.LENGTH_SHORT).show();
            mCancel = true;
        } else if (mCellPhone.length() > 10) {
            Toast.makeText(this, "Telefono movil inválido", Toast.LENGTH_SHORT).show();
        }

        if (TextUtils.isEmpty(mPersonalEmail)) {
            Toast.makeText(this, "Correo electronico personal vacio", Toast.LENGTH_SHORT).show();
            mCancel = true;
        } else if (!isValidEmail(mPersonalEmail)) {
            Toast.makeText(this, "Correo personal inválido", Toast.LENGTH_SHORT).show();
            mCancel = true;
        }

        if (TextUtils.isEmpty(mWorkEmail)) {
            Toast.makeText(this, "Correo electronico laboral vacio", Toast.LENGTH_SHORT).show();
            mCancel = true;
        } else if (!isValidEmail(mWorkEmail)) {
            Toast.makeText(this, "Correo laboral inválido", Toast.LENGTH_SHORT).show();
            mCancel = true;
        }

        return mCancel;
    }
}
