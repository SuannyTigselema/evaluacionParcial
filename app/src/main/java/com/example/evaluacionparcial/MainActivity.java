package com.example.evaluacionparcial;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.example.evaluacionparcial.Models.adaptadorPais;
import com.example.evaluacionparcial.Models.pais;
import com.example.evaluacionparcial.WebService.Asynchtask;
import com.example.evaluacionparcial.WebService.WebService;
import com.mindorks.placeholderview.PlaceHolderView;

import org.json.JSONArray;
import org.json.JSONException;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class MainActivity extends AppCompatActivity implements Asynchtask {
    ArrayList<pais> listPais;
    PlaceHolderView placeholderview=null;
    RecyclerView recyclerview=null;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerview=(RecyclerView)findViewById(R.id.rcvListaPaises);
        recyclerview.addItemDecoration(new DividerItemDecoration(this,DividerItemDecoration.VERTICAL));
        recyclerview.setLayoutManager(new GridLayoutManager(this, 3));

      //  placeholderview=(PlaceHolderView) findViewById(R.id.galleryView);
        //placeholderview.addView(new HeaderView(this, "header"));
       //placeholderview.addView(new ChildView(this, movie));
        Map<String, String> datos = new HashMap<>();
        WebService ws= new WebService("https://restcountries.eu/rest/v2/all",datos,
                MainActivity.this, (Asynchtask) MainActivity.this);
        ws.execute("GET");

    }

    @Override
    public void processFinish(String result) throws JSONException {
        JSONArray JSONlistaPaises = new JSONArray(result);
        ArrayList<pais> lstPaises = new ArrayList<pais>();

        lstPaises = pais.JsonObjectsBuild(JSONlistaPaises);
        adaptadorPais adapatorPais = new adaptadorPais(this, lstPaises);

        //placeholderview.addView(new HeaderView(this, "header"));

        recyclerview.setAdapter(adapatorPais);
    }
}