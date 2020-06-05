package com.example.rpplaboratorio;

import android.app.Activity;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;

public class AutoView {
    Activity activity;
    AutoModel autoModel ;
    AutoController autoController ;
    Integer posicion_a_actualizar ;

    Button btnmodificar ;
    EditText edtmarca;
    EditText edtModelo;
    Spinner spanio ;




    public AutoView  ( Activity activity , AutoController autoController , AutoModel autoModel){
        this. activity = activity ;
        this.autoController = autoController ;
        this.autoModel = autoModel ;
        this.btnmodificar = activity.findViewById(R.id.button_guardar);
        this.btnmodificar.setOnClickListener(autoController);


    }


    public void loadView (){
        edtmarca= (EditText) activity.findViewById(R.id.edittext_marcaauto);
        edtModelo = (EditText) activity.findViewById(R.id.edittext_modeloauto);
        spanio = (Spinner)activity.findViewById(R.id.spinneryear) ;


    }


    public void CargarModelo (){

        autoModel.make = edtmarca.getText().toString();

        autoModel.model = edtModelo.getText().toString();

        autoModel.year = spanio.getSelectedItem().toString();



    }
}
