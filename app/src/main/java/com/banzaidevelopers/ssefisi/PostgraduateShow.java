package com.banzaidevelopers.ssefisi;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

public class PostgraduateShow extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_postgraduate_show);

        ImageView editView = (ImageView) findViewById(R.id.edit_post);
        editView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), PostgraduateEdit.class);
                startActivity(intent);
            }
        });
    }
}
