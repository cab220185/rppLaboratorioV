package com.example.rpplaboratorio;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class MyAdapter  extends RecyclerView.Adapter<MyViewHolder>   {

    private List<AutoModel> lista;
    private MyOnItemClick listener;



    public MyAdapter(List<AutoModel> lista, MyOnItemClick listener)
    {
        this.lista=lista;
        this.listener= listener;
    }



    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_layout,
                parent, false);
        MyViewHolder myViewHolder = new MyViewHolder(v , this.listener);
        return myViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {


        AutoModel p = lista.get(position);
        holder.txtModelo.setText(p.getModel());
        holder.txtMarca.setText(p.getMake());
        holder.setPosition(position);
    }

    @Override
    public int getItemCount() {
        return lista.size();
    }




}
