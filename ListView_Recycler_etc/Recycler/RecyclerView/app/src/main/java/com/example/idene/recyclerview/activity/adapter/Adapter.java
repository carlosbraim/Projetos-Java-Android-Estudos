package com.example.idene.recyclerview.activity.adapter;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.idene.recyclerview.R;
import com.example.idene.recyclerview.activity.model.Filme;

import java.util.List;

public class Adapter extends RecyclerView.Adapter<Adapter.MyViewHolder> {

    private List<Filme> listaFilmes;

    public Adapter(List<Filme> lista) {
        this.listaFilmes = lista;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {//Criar as visualizações que serão exibidas

        View itemLista = LayoutInflater.from(viewGroup.getContext())
                .inflate(R.layout.adapter_lista, viewGroup, false);//converter o XML no tilo View

        return new MyViewHolder(itemLista);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder myViewHolder, int i) {

        Filme filme = listaFilmes.get(i);//o i == position da lista
        myViewHolder.titulo.setText(filme.getTitoloFilme());
        myViewHolder.genero.setText(filme.getGenero());
        myViewHolder.ano.setText(filme.getAno());
    }

    @Override
    public int getItemCount() {

        return listaFilmes.size();//sua chamada sera de acordo com a quantidade de itens da lista
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        TextView titulo,ano,genero;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);

            //Recuper componentes usando o objeto  itemView
            titulo = itemView.findViewById(R.id.textTitulo);
            ano = itemView.findViewById(R.id.textAno);
            genero = itemView.findViewById(R.id.textGenero);
        }
    }



}
