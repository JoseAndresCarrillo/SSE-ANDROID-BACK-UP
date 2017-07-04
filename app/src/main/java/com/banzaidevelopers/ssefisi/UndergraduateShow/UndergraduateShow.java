package com.banzaidevelopers.ssefisi.UndergraduateShow;

import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.banzaidevelopers.ssefisi.R;
import com.banzaidevelopers.ssefisi.Model.FormacionAcademica;

import java.util.List;

public class UndergraduateShow extends AppCompatActivity implements UndergraduateShowView {
    RecyclerView recyclerView;
    RecyclerAdapterFormacionAcademica adapter;
    TextView empty;
    ProgressBar progressBar;
    UndergraduateShowPresenter presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_undergraduate_show);
        empty= (TextView) findViewById(R.id.empty);
        progressBar= (ProgressBar) findViewById(R.id.progress);
        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.add);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getApplicationContext(),"Click",Toast.LENGTH_SHORT).show();
            }
        });

        /*Declarcion del presenter*/
        presenter = new UndergraduateShowPresenterImpl(this);
       /*Declaracion del ReyclerView*/
        recyclerView = (RecyclerView) findViewById(R.id.rv);
        recyclerView.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.VERTICAL,false));
        adapter = new RecyclerAdapterFormacionAcademica(getApplicationContext(),R.layout.item_cardview);
        recyclerView.setAdapter(adapter);
        /*inicializar el presenter llamando al interactor*/
        presenter.loadListFormacionAcademica();

    }

    @Override
    public void initRecycler(List<FormacionAcademica> formacion_academica) {
        adapter.setListProyecto(formacion_academica);
        adapter.notifyDataSetChanged();
    }

    @Override
    public void showEmpty() {
        recyclerView.setVisibility(View.GONE);
        empty.setVisibility(View.VISIBLE);
    }

    @Override
    public void hideEmpty() {
        empty.setVisibility(View.GONE);
        recyclerView.setVisibility(View.VISIBLE);
    }

    @Override
    public void showProgress() {
        progressBar.setVisibility(View.VISIBLE);
    }

    @Override
    public void hideProgress() {
        progressBar.setVisibility(View.GONE);

    }
}
