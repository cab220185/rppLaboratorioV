package com.example.rpplaboratorio;

import android.os.Handler;



import android.net.Uri;

import android.os.Message;
import android.util.Log;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;


public class Hilo extends Thread {

    Handler handler ;
    String  url ;
    Boolean texto ;
    Integer posicion ;
    String peticion ;
    List<AutoModel> listaAutos ;



    public Hilo (Handler handler , String url, Boolean texto, Integer posicion ,String peticion){
        this.handler = handler ;
        this.url = url ;
        this.texto= texto;
        this.posicion = posicion;
        this.peticion = peticion ;

    }



    @Override
    public void run (){

        if(texto &&  peticion == "GET"){
            HttpManager manager = new HttpManager();
            String respuesta =  manager.consutarAutos(this.url);
            listaAutos  = new ArrayList<AutoModel>();
            listaAutos .clear();
            if (respuesta.isEmpty()){
                Log.d("tienedatos","respuesta vacia");
            }
            JSONArray array = null;
            try {

                array = new JSONArray(respuesta);


                for(int i = 0; i<array.length(); i++){
                    JSONObject object = array.getJSONObject(i);
                    listaAutos.add( new AutoModel (object.getString("id"),object.getString("make"),object.getString("model"),object.getString("year")));

                }

            } catch (JSONException e) {
                e.printStackTrace();
            }

            Message message = new Message();
            message.obj =  listaAutos ;
            message.arg1=1;
            this.handler.sendMessage(message);}



        else  {

            HttpManager manager = new HttpManager();
            byte[] imagen =  manager.consutarAutosimagen(this.url);

            Message message = new Message();
            message.obj =  imagen ;
            message.arg1=2;
            message.arg2 = posicion ;
            this.handler.sendMessage(message);
        }



    }


}
