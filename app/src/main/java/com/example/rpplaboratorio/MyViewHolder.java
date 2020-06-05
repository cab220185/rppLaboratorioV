package com.example.rpplaboratorio;

import android.view.View;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

public class MyViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

    TextView txtMarca;
    TextView txtModelo;

    private MyOnItemClick listener;
    private int position;

    public void setPosition(int position)
    {
        this.position = position;
    }

    public MyViewHolder(View itemView , MyOnItemClick listener) {
        super (itemView);
        txtMarca = (TextView) itemView.findViewById(R.id.txtMarca);
        txtModelo = (TextView) itemView.findViewById(R.id.txtModelo);
        itemView.setOnClickListener(this);
        this.listener = listener ;
    }

    @Override
    public void onClick(View v) {


        listener.onItemClick(position);
    }
}
