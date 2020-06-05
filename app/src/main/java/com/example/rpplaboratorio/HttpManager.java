package com.example.rpplaboratorio;

import android.net.Uri;
import android.util.JsonWriter;
import android.util.Log;

import org.json.JSONObject;

import java.io.BufferedWriter;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

public class HttpManager {

    public String consutarAutos(String urlString) {


        try {


            URL url = new URL(urlString);
            HttpURLConnection urlConnection = (HttpURLConnection) url.openConnection();
            urlConnection.setRequestMethod("GET");

            urlConnection.connect();

            int response = urlConnection.getResponseCode();
            if (response == 200) {

                InputStream is = urlConnection.getInputStream();
                ByteArrayOutputStream bais = new ByteArrayOutputStream();

                byte[] Buffer = new byte[1024];
                int cantidadbyte = 0;
                while ((cantidadbyte = is.read(Buffer)) != -1) {
                    bais.write(Buffer, 0, cantidadbyte);
                }

                is.close();

                return bais.toString();


            } else {
                throw new IOException("Error en el servidor");
            }

        } catch (MalformedURLException ex) {
            ex.printStackTrace();

        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;

    }

    public byte[] consutarAutosimagen(String urlString) {

        try {


            URL url = new URL(urlString);
            HttpURLConnection urlConnection = (HttpURLConnection) url.openConnection();
            urlConnection.setRequestMethod("GET");
            urlConnection.connect();
            int response = urlConnection.getResponseCode();
            if (response == 200) {
                InputStream is = urlConnection.getInputStream();
                ByteArrayOutputStream bais = new ByteArrayOutputStream();

                byte[] Buffer = new byte[1024];
                int cantidadbyte = 0;
                while ((cantidadbyte = is.read(Buffer)) != -1) {
                    bais.write(Buffer, 0, cantidadbyte);
                }

                is.close();
                Log.d("Respuesta Servidor", bais.toString());
                return bais.toByteArray();


            } else {
                throw new IOException("Error en el servidor");
            }

        } catch (MalformedURLException ex) {
            ex.printStackTrace();

        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;

    }
}

