package com.example.registrocomidas;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;


import com.squareup.picasso.Picasso;

import java.util.ArrayList;

public class Adaptador extends RecyclerView.Adapter<Adaptador.viewHolder> {

    ArrayList<Comidas> listadeComidas;

    public Adaptador(ArrayList<Comidas> listadeComidas) {
        this.listadeComidas = listadeComidas;
    }

    @NonNull
    @Override
    public Adaptador.viewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View vistaItem= LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_de_lista,parent,false);
        return new viewHolder(vistaItem);
    }

    @Override
    public void onBindViewHolder(@NonNull Adaptador.viewHolder holder, int position) {

        holder.actualizarItem(listadeComidas.get(position));

    }

    @Override
    public int getItemCount() {
        return listadeComidas.size();
    }

    public class viewHolder extends RecyclerView.ViewHolder {

        TextView descripcionComida, tipodeComida;
        ImageView fotoComida;

        public viewHolder(@NonNull View itemView) {
            super(itemView);

            tipodeComida=itemView.findViewById(R.id.tipodeComida);
            descripcionComida=itemView.findViewById(R.id.descripcionComida);
            fotoComida=itemView.findViewById(R.id.fotoComida);

        }

        public void actualizarItem(Comidas comidas) {

            tipodeComida.setText(comidas.getTipodeComida());
            descripcionComida.setText(comidas.getDescripcionComida());

            Picasso.with(itemView.getContext())
                    .load(comidas.getFotoURL())
                    .into(fotoComida);


        }
    }
}
