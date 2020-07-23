package com.example.evaluacionparcial.Models;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;


import com.example.evaluacionparcial.R;

import java.util.ArrayList;

public class adaptadorPais extends RecyclerView.Adapter<adaptadorPais.MyViewHolder> {
    private static final int TYPE_HEADER=0;
    private static final int TYPE_LIST=0;


    private Context mContext;

    //Lista de productos q va a llegar al adaptador
    private ArrayList<pais> mLista;
    public TextView nombre;
    public TextView lblNombre;
    public TextView lblDescripcion;
    public TextView lblPrecio;
    public TextView lblUnidad;
    public TextView lblHeader;
    public ImageView imgFoto;

    public adaptadorPais(Context context, ArrayList<pais> lista) {
        mContext = context;
        mLista=lista;
    }

    //Métodos propios del RecyclerdView

    //infla los items al recyclerd
    @NonNull
    @Override
    public adaptadorPais.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view;
           view= LayoutInflater.from(mContext)
                   .inflate(R.layout.ly_itempais,null,false);
           return new MyViewHolder(view);

    }

    //enlaza cada vista del viewholder con los datos de la Lista de productos
    @Override
    public void onBindViewHolder(@NonNull adaptadorPais.MyViewHolder holder, int position) {

        lblNombre.setText(mLista.get(position).getNombre());
    }

    //Devuelve la cantidad del elementos del recyclerd
    @Override
    public int getItemCount() {
        return mLista.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        int view_type;
        //Obtener los elementos q irán en cada item
        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
                lblNombre=(TextView)itemView.findViewById(R.id.lblNombre);
                imgFoto=(ImageView) itemView.findViewById(R.id.imageView);
        }
    }

}
