package com.banzaidevelopers.ssefisi;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.CardView;
import android.util.Log;
import android.view.View;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;
import android.widget.Toast;

import com.banzaidevelopers.ssefisi.Model.HomePojo;
import com.banzaidevelopers.ssefisi.Model.Welcome_Classes.Undergraduate_Home;
import com.banzaidevelopers.ssefisi.Model.Welcome_Classes.Work_Home;
import com.banzaidevelopers.ssefisi.Service.HomeService;
import com.banzaidevelopers.ssefisi.UndergraduateShow.UndergraduateShow;

import org.w3c.dom.Text;

import java.util.ArrayList;
import java.util.StringTokenizer;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class Home extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {

    DrawerLayout mDrawerLayout;
    ActionBarDrawerToggle mDrawerToggle;
    NavigationView mNavigationView;
    Toolbar toolbar = null;

    //UI Reference
    private TextView mNavNameView;
    private TextView mNavGdtFromView;
    private TextView mNameView;
    private TextView mPersDniView;
    private TextView mPersBirthDay;
    private TextView mPersCivilState;
    private TextView mPersAddress;
    private TextView mAcadInstitutionNameView;
    private TextView mAcadProgrammeAcademicView;
    private TextView mAcademicDateView;
    private TextView mPostInstitutionNameView;
    private TextView mPostProgrammeAcademicView;
    private TextView mPostDateView;
    private TextView mWorkInstitutionNameView;
    private TextView mWorkPosition;
    private TextView mWorkDateView;

    //Retrofit
    private Retrofit mRestAdapter;
    private HomeService mHomeService;

    //Others
    private String mGdtFrom = "";
    private String mName = "";
    private String mFatherSurname;
    private String mMotherSurname;
    private String mTest;
    private String mAcadStartYear;
    private String mAcadEndYear;
    private String mPostStartYear;
    private String mPostEndYear;
    private String mWorkStartYear;
    private String mWorkEndYear;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_home);
        toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        TextView personalView = (TextView) findViewById(R.id.pers_more);
        personalView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), PersonalShow.class);
                intent.putExtra("id", getIntent().getStringExtra("id"));
                startActivity(intent);
            }
        });
        TextView undergraduateView = (TextView) findViewById(R.id.pre_more);
        undergraduateView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), UndergraduateShow.class);
                intent.putExtra("id", getIntent().getStringExtra("id"));
                startActivity(intent);
            }
        });

        TextView postgraduateView = (TextView) findViewById(R.id.post_more);
        postgraduateView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), PostgraduateShow.class);
                intent.putExtra("id", getIntent().getStringExtra("id"));
                startActivity(intent);
            }
        });

        TextView workView = (TextView) findViewById(R.id.work_more);
        workView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), WorkShow.class);
                intent.putExtra("id", getIntent().getStringExtra("id"));
                startActivity(intent);
            }
        });

        mDrawerLayout = (DrawerLayout) findViewById(R.id.drawer_layout);
        mDrawerToggle = new ActionBarDrawerToggle(
                this,                  /* host Activity */
                mDrawerLayout,         /* DrawerLayout object */
                toolbar,  /* host toolbar */
                R.string.navigation_drawer_open,  /* "open drawer" description */
                R.string.navigation_drawer_close  /* "close drawer" description */
        ) /*{

            *//* Called when a drawer has settled in a completely closed state. *//*
            public void onDrawerClosed(View view) {
                super.onDrawerClosed(view);
            }

            *//* Called when a drawer has settled in a completely open state. *//*
            public void onDrawerOpened(View drawerView) {
                super.onDrawerOpened(drawerView);
            }
        }*/;

        mDrawerToggle.syncState();
        mDrawerLayout.addDrawerListener(mDrawerToggle);
        mNavigationView = (NavigationView) findViewById(R.id.nav_view);
        mNavigationView.setNavigationItemSelectedListener(this);

        mNavNameView = (TextView) mNavigationView.getHeaderView(0).findViewById(R.id.nav_gdt_name);
        mNavGdtFromView = (TextView) mNavigationView.getHeaderView(0).findViewById(R.id.nav_gdt_from);
        mNameView = (TextView) findViewById(R.id.gdt_name);
        mPersDniView = (TextView) findViewById(R.id.pers_dni);
        mPersBirthDay = (TextView) findViewById(R.id.pers_birthday);
        mPersCivilState = (TextView) findViewById(R.id.pers_civil_state);
        mPersAddress = (TextView) findViewById(R.id.pers_address);
        mAcadInstitutionNameView = (TextView) findViewById(R.id.acad_inst_name);
        mAcadProgrammeAcademicView = (TextView) findViewById(R.id.acad_prog_acad);
        mAcademicDateView = (TextView) findViewById(R.id.acad_date);
        mPostInstitutionNameView = (TextView) findViewById(R.id.post_inst_name);
        mPostProgrammeAcademicView = (TextView) findViewById(R.id.post_prog_acad);
        mPostDateView = (TextView) findViewById(R.id.post_date);
        mWorkInstitutionNameView = (TextView) findViewById(R.id.work_inst_name);
        mWorkPosition = (TextView) findViewById(R.id.work_position);
        mWorkDateView = (TextView) findViewById(R.id.work_date);

        //Rest Connection
        mRestAdapter = new Retrofit.Builder()
                .baseUrl("https://mysterious-sierra-91040.herokuapp.com/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        //Connection HomeService
        mHomeService = mRestAdapter.create(HomeService.class);

        //Rest Implementation
        Call<HomePojo> homeCall = mHomeService.welcome(Login.id);// Para linkear usar intent
        homeCall.enqueue(new Callback<HomePojo>() {
            @Override
            public void onResponse(Call<HomePojo> call, Response<HomePojo> response) {
                mName = response.body().getName();
                mFatherSurname = response.body().getFatherSurname();
                mMotherSurname = response.body().getMotherSurname();
                mTest = mFatherSurname + " " + mMotherSurname + ", " + mName;
                mGdtFrom = response.body().getUndergraduate().get(0).getSchool();
                //Navigation Drawer
                mNavNameView.setText(mTest.toUpperCase());
                mNavGdtFromView.setText(R.string.gdt_from);
                //Header
                mNameView.setText(mTest.toUpperCase());
                //Personal Information
                mPersDniView.setText(getResources().getString(R.string.dni_title) + ": " + response.body().getPersonalInformation().getDNI());
                mPersBirthDay.setText(getResources().getString(R.string.birthday_title) + ": " + response.body().getPersonalInformation().getBirthday());
                mPersCivilState.setText(getResources().getString(R.string.civil_state_title) + ": " + response.body().getPersonalInformation().getCivilState());
                mPersAddress.setText(getResources().getString(R.string.address_title) + ": " + response.body().getPersonalInformation().getAddress());
                //Academic Formation
                mAcadStartYear = response.body().getUndergraduate().get(0).getStartDate().substring(0, 4);
                mAcadEndYear = response.body().getUndergraduate().get(0).getEndDate().substring(0, 4);
                mAcadInstitutionNameView.setText(response.body().getUndergraduate().get(0).getInstitutionName());
                mAcadProgrammeAcademicView.setText(response.body().getUndergraduate().get(0).getSchool());
                mAcademicDateView.setText(mAcadStartYear + " - " + mAcadEndYear);
                //Postgraduate Studies
                mPostStartYear = response.body().getPostgraduate().get(0).getStartDate().substring(0, 4);
                mPostEndYear = response.body().getPostgraduate().get(0).getEndDate().substring(0, 4);
                mPostInstitutionNameView.setText(response.body().getPostgraduate().get(0).getInstitutionName());
                mPostProgrammeAcademicView.setText(response.body().getPostgraduate().get(0).getProgrammeAcademic());
                mPostDateView.setText(mPostStartYear + " - " + mPostEndYear);
                //Laboral Experiencia
                mWorkStartYear=response.body().getWork().get(0).getmWbeginDate().substring(0,4);
                mWorkEndYear=response.body().getWork().get(0).getmWendDate().substring(0,4);
                mWorkInstitutionNameView.setText(response.body().getWork().get(0).getmInstitutionName());
                mWorkPosition.setText(response.body().getWork().get(0).getmPosition());
                mWorkDateView.setText(mWorkStartYear+" - "+mWorkEndYear);
            }

            @Override
            public void onFailure(Call<HomePojo> call, Throwable t) {
                Toast.makeText(Home.this, "Tengo un perro q se llama messi", Toast.LENGTH_SHORT).show();
            }
        });
    }

    /*@Override
    protected void onPostCreate(Bundle savedInstanceState) {
        super.onPostCreate(savedInstanceState);
        mDrawerToggle.syncState();
    }
*/
    /*@Override
    public void onConfigurationChanged(Configuration newConfig) {
        super.onConfigurationChanged(newConfig);
        mDrawerToggle.onConfigurationChanged(newConfig);
    }*/
    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();
        switch (id) {
            case R.id.about:
                Intent i1 = new Intent(Home.this, About.class);
                startActivity(i1);
                break;
            case R.id.logout:
                Intent i2 = new Intent(getApplicationContext(), Login.class);
                startActivity(i2);
                Toast.makeText(this, getString(R.string.toast_logout), Toast.LENGTH_SHORT).show();
        }

        return true;
    }
}

