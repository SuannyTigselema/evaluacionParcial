package com.example.evaluacionparcial.Models;

import com.example.evaluacionparcial.MainActivity;
import com.example.evaluacionparcial.WebService.Asynchtask;
import com.example.evaluacionparcial.WebService.WebService;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class pais implements Asynchtask {
    public String name;
    public String url;
    public String code;
    public pais(JSONObject a) throws JSONException {
        this.name = a.getString("name").toString();
        code=a.getString("alpha2Code").toString();
         this.url = "http://www.geognos.com/api/en/countries/flag/"+code+".png";
    }

    @Override
    public void processFinish(String result) throws JSONException {

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
