package com.example.evaluacionparcial.Models;

import org.json.JSONException;
import org.json.JSONObject;

public class detallePais {
    public String name;
    public String region;
    public String nativeName;
    public String numericCode;
    public String language;
    public String band;

    public detallePais(JSONObject a) throws JSONException {
        this.name = a.getString("name").toString();
        this.region = region;
        this.nativeName = nativeName;
        this.numericCode = numericCode;
        this.language = language;
        this.band =  "https://restcountries.eu/rest/v2/alpha/"+;
    }
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getRegion() {
        return region;
    }

    public void setRegion(String region) {
        this.region = region;
    }

    public String getNativeName() {
        return nativeName;
    }

    public void setNativeName(String nativeName) {
        this.nativeName = nativeName;
    }

    public String getNumericCode() {
        return numericCode;
    }

    public void setNumericCode(String numericCode) {
        this.numericCode = numericCode;
    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    public String getBand() {
        return band;
    }

    public void setBand(String band) {
        this.band = band;
    }
}
