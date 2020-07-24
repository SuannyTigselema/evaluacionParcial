package com.example.evaluacionparcial;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.Fragment;

import android.os.Bundle;
import android.view.MenuItem;
import android.widget.Toast;

import com.google.android.material.navigation.NavigationView;

public class infoPaisActivity extends AppCompatActivity{

    DrawerLayout drawerLayout;
    NavigationView navView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_info_pais);

        Bundle b = this.getIntent().getExtras();
        String pais=b.getString("pais");
        Toast toast1=Toast.makeText(getApplicationContext(),
                        "Sleccionaste: " + pais, Toast.LENGTH_SHORT);
        toast1.show();
    }


}