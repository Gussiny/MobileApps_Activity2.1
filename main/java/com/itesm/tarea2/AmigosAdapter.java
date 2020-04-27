package com.itesm.tarea2;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class AmigosAdapter extends RecyclerView.Adapter<AmigosAdapter.AmigosViewHolder>{

    private ArrayList<Amigos> amigos;
    private View.OnClickListener listener;

    public AmigosAdapter(ArrayList<Amigos> amigos, View.OnClickListener listener) {
        this.amigos = amigos;
        this.listener = listener;
    }

    @NonNull
    @Override
    public AmigosViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = (View) LayoutInflater.from(parent.getContext()).inflate(R.layout.row, parent, false);
        v.setOnClickListener(listener);

        AmigosViewHolder amigosViewHolder = new AmigosViewHolder(v);
        return amigosViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull AmigosViewHolder holder, int position) {
        Amigos amigo = amigos.get(position);
        String name, hobby;
        name = amigo.getName();
        hobby = amigo.getHobby();

        holder.txtName.setText(name);
        holder.txtHobby.setText(hobby);
    }

    @Override
    public int getItemCount() {
        return amigos.size();
    }

    public class AmigosViewHolder extends RecyclerView.ViewHolder{
        public TextView txtName, txtHobby;
        public AmigosViewHolder(@NonNull View itemView) {
            super(itemView);
            txtName = itemView.findViewById(R.id.txtName);
            txtHobby = itemView.findViewById(R.id.txtHobby);
        }
    }

}
