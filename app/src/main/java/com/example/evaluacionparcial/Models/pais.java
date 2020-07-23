package com.example.evaluacionparcial.Models;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

public class pais {
    public String name;
    public String url;

    public pais(JSONObject a) throws JSONException {
        String nombre= a.getString("name").toString();
        this.name = a.getString("name").toString();
      //  this.url = a.getString("imagen").toString();
    }
    //Metodo para parsear los datos
    public static ArrayList<pais> JsonObjectsBuild(JSONArray datos) throws JSONException {
        ArrayList<pais> pais = new ArrayList<>();
        for (int i = 0; i < datos.length() && i<20; i++) {

            pais.add(new pais(datos.getJSONObject(i)));
        }
        return pais;
    }
    public String getNombre() {
        return name;
    }

    public void setNombre(String name) {
        this.name = name;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }
}
