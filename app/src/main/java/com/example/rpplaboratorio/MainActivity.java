package com.example.rpplaboratorio;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.util.Log;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements MyOnItemClick ,Handler.Callback {

    AutoModel auto;
    MyAdapter adapter;
    static List<AutoModel> Autos;
    private static MainActivity activity;
    static AutoModel autoactualizado;
    static Activity mainactivity;
    static int posicionactualizado;
    Handler handler;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        handler = new Handler(this);
        Autos  = new ArrayList<AutoModel>();

        Hilo hilo = new Hilo(handler, "http://192.168.1.40:3000/autos", true,null, "GET");
        hilo.start();


        mainactivity = this;
        RecyclerView list = (RecyclerView) findViewById(R.id.list);




       GridLayoutManager  layoutManager = new GridLayoutManager(this,2) ;
       list.setLayoutManager(layoutManager);

        adapter = new MyAdapter(Autos, this);
        list.setAdapter(adapter);



    }

    @Override
    public void onItemClick(int position) {

        Intent intent = new Intent(this, ModificarAuto.class);
        posicionactualizado = position;
        super.startActivity(intent);


    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Log.d("lalistatiene",String.valueOf(autoactualizado));
        if (autoactualizado != null ) {
            Autos.get(posicionactualizado).setMake(autoactualizado.make);
            Autos.get(posicionactualizado).setModel(autoactualizado.model);
            Autos.get(posicionactualizado).setYear(autoactualizado.year);

            Log.d("cambioelanio",String.valueOf(autoactualizado.year));

            autoactualizado = null ;

            adapter.notifyItemChanged(posicionactualizado);
        }
    }

    @Override
    public boolean handleMessage(@NonNull Message msg) {

        if (msg.arg1 == 1) {

            Autos.clear();
            this.Autos.addAll((List<AutoModel>) msg.obj);
            this.adapter.notifyDataSetChanged();
            Log.d("lalistatiene",String.valueOf(Autos.size()));

        }
        return false;
    }



}
