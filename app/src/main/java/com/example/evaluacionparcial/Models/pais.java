package com.example.evaluacionparcial.Models;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

public class pais {
    public String nombre;
    public String url;

    public pais(JSONObject a) throws JSONException {
        this.nombre = a.getString("nombre").toString();
        this.url = a.getString("imagen").toString();
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
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }
}
