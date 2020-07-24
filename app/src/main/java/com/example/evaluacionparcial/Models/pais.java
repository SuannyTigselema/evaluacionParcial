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

public class pais {
    public String name;
    public String url;
    public String code;
    public String code2;

    public pais(JSONObject a) throws JSONException {
        this.name = a.getString("name").toString();
        code=a.getString("alpha2Code").toString();
        this.url = "http://www.geognos.com/api/en/countries/flag/"+code+".png";
        this.code2=a.getString("alpha2Code").toString();
    }

    //Metodo para parsear los datos
    public static ArrayList<pais> JsonObjectsBuild(JSONArray datos) throws JSONException {
        ArrayList<pais> pais = new ArrayList<>();
        for (int i = 0; i < datos.length(); i++) {

            pais.add(new pais(datos.getJSONObject(i)));
        }
        return pais;
    }

    public String getCode2() {
        return code2;
    }

    public void setCode2(String code2) {
        this.code2 = code2;
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
