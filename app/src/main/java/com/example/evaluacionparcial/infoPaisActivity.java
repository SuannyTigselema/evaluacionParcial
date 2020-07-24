package com.example.evaluacionparcial;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.MenuItem;
import android.widget.Toast;

import com.example.evaluacionparcial.Models.adaptadorPais;
import com.example.evaluacionparcial.Models.pais;
import com.example.evaluacionparcial.WebService.Asynchtask;
import com.example.evaluacionparcial.WebService.WebService;
import com.google.android.material.navigation.NavigationView;

import org.json.JSONArray;
import org.json.JSONException;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class infoPaisActivity extends AppCompatActivity implements Asynchtask {

    DrawerLayout drawerLayout;
    NavigationView navView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_info_pais);

        Bundle b = this.getIntent().getExtras();
        String pais=b.getString("pais");
        Toast toast1=Toast.makeText(getApplicationContext(),
                        "Seleccionaste: " + pais, Toast.LENGTH_SHORT);
        toast1.show();

        //recyclerview=(RecyclerView)findViewById(R.id.rcvListaPaises);
        //recyclerview.addItemDecoration(new DividerItemDecoration(this,DividerItemDecoration.VERTICAL));
       // recyclerview.setLayoutManager(new GridLayoutManager(this, 3));
        Map<String, String> datos = new HashMap<>();
        WebService ws= new WebService("https://restcountries.eu/rest/v2/alpha/"+pais,datos,
                infoPaisActivity.this, (Asynchtask) infoPaisActivity.this);
        ws.execute("GET");
    }


    @Override
    public void processFinish(String result) throws JSONException {
        JSONArray JSONlistaPaises = new JSONArray(result);
        ArrayList<pais> lstPaises = new ArrayList<pais>();

        lstPaises = pais.JsonObjectsBuild(JSONlistaPaises);
        adaptadorPais adapatorPais = new adaptadorPais(this, lstPaises);
        final ArrayList<pais> finalLstPaises = lstPaises;
        //recyclerview.setAdapter(adapatorPais);
    }
}