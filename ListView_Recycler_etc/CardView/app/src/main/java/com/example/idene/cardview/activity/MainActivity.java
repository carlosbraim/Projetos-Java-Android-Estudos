package com.example.idene.cardview.activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.example.idene.cardview.R;
import com.example.idene.cardview.adapter.PostagemAdapter;
import com.example.idene.cardview.model.Postagem;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private RecyclerView recyclerPostagem;
    private List<Postagem> postagem = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerPostagem = findViewById(R.id.recyclerPostagem);

        //Definir layout
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this);
        recyclerPostagem.setLayoutManager(layoutManager);
        

        /* //Definir layout em duas colunas ou mais
        RecyclerView.LayoutManager layoutManager = new GridLayoutManager(this,2);
        recyclerPostagem.setLayoutManager(layoutManager); */


       /* //Definir layout na horizontal desta forma da para passar os conteudos de lado
        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        layoutManager.setOrientation(LinearLayout.HORIZONTAL);
        recyclerPostagem.setLayoutManager(layoutManager);*/

        //Definir adapter
        this.prepararPostagens();//chamar metodo que cria as postagem
        PostagemAdapter adapter = new PostagemAdapter(postagem);
        recyclerPostagem.setAdapter(adapter);


    }

    //configurar postagens
    public void prepararPostagens(){
        Postagem p = new Postagem("Carlos Júnior","#tbt viagem legal",R.drawable.imagem1);
        this.postagem.add(p);

        p = new Postagem("Hotel","Viage, aproveite nossos desconto",R.drawable.imagem2);
        this.postagem.add(p);

        p = new Postagem("Maria Luiza","#Paris",R.drawable.imagem3);
        this.postagem.add(p);

        p = new Postagem("Marcos","Que foto linda",R.drawable.imagem4);
        this.postagem.add(p);

    }
}
