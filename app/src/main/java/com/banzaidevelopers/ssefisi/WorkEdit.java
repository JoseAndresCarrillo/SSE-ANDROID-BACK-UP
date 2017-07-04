package com.banzaidevelopers.ssefisi;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

public class WorkEdit extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_work_edit);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_save, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();

        if (id == R.id.action_save) {

            Toast.makeText(this, getString(R.string.toast_saved), Toast.LENGTH_SHORT).show();
            Intent intent = new Intent(getApplicationContext(), WorkShow.class);
            startActivity(intent);
        }
        return super.onOptionsItemSelected(item);
    }
}
