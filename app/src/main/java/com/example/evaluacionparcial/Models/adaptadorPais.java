package com.example.evaluacionparcial.Models;

import android.content.Context;
import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;


import com.example.evaluacionparcial.R;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

public class adaptadorPais extends RecyclerView.Adapter<adaptadorPais.MyViewHolder>
        implements View.OnClickListener {
    private static final int TYPE_HEADER=0;
    private static final int TYPE_LIST=0;


    private Context mContext;

    private ArrayList<pais> mLista;
    private View.OnClickListener listener;
    public TextView lblNombre;
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
           view.setOnClickListener(this);
           return new MyViewHolder(view);

    }

    //enlaza cada vista del viewholder con los datos de la Lista
    @Override
    public void onBindViewHolder(@NonNull adaptadorPais.MyViewHolder holder, int position) {

        lblNombre.setText(mLista.get(position).getNombre());
        String url=mLista.get(position).getUrl();
        Picasso.with(mContext)
                .load(url)
                .error(R.drawable.ic_baseline_error_24)
                .fit()
                .centerInside()
                .into(imgFoto);

       // Uri imgUri=Uri.parse("https://www.natursan.net/wp-content/cebollas-2.jpg");
        //imgFoto.setImageURI(imgUri);
    }

    //Devuelve la cantidad del elementos del recyclerd
    @Override
    public int getItemCount() {
        return mLista.size();
    }

    public void setOnClickListener(View.OnClickListener listener){
        this.listener=listener;
    }

    @Override
    public void onClick(View view) {
        if(listener!=null)
        {
            listener.onClick(view);
        }
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
