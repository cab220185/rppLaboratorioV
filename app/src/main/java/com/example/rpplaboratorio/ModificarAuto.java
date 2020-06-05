package com.example.rpplaboratorio;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.os.Bundle;
import android.view.MenuItem;

public class ModificarAuto extends AppCompatActivity {

    static Activity modificarAuto;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_modificar_auto);
        modificarAuto = this;

        ActionBar toolbar = getSupportActionBar();
        toolbar.setDisplayHomeAsUpEnabled(true);


        AutoModel auto = new AutoModel();
        AutoController autoController = new AutoController(auto);
        AutoView autoView = new AutoView(this, autoController, auto);
        autoController.setAutoView(autoView);


    }



    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        int id = item.getItemId();


        if (id == android.R.id.home) {
            super.finish();
        }
        return super.onOptionsItemSelected(item);
    }
}