package com.example.idene.recyclerview.activity.activity;

import android.database.DataSetObserver;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.example.idene.recyclerview.R;
import com.example.idene.recyclerview.activity.RecyclerItemClickListener;
import com.example.idene.recyclerview.activity.model.Filme;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
private RecyclerView recyclerView;
private List<Filme>listaFilmes = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView = findViewById(R.id.recyclerView);

        //Listagem de filmes
        this.criarFilmes();

        //configurar adapter
        com.example.idene.recyclerview.activity.adapter.Adapter adapter = new com.example.idene.recyclerview.activity.adapter.Adapter(listaFilmes);


        //configurar recyclerView
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getApplicationContext());
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setHasFixedSize(true);//otmizando o recyclerView com tamanho fixo
        recyclerView.addItemDecoration(new DividerItemDecoration(this,LinearLayout.VERTICAL));//criar uma linha entres os itens da lisata
        recyclerView.setAdapter(adapter);//Recebe os dados formata e usa no recyclerView

        //evento de click
        recyclerView.addOnItemTouchListener(
                new RecyclerItemClickListener(
                        getApplicationContext(),
                        recyclerView,
                        new RecyclerItemClickListener.OnItemClickListener() {
                            @Override
                            public void onItemClick(View view, int position) {
                                Filme filme = listaFilmes.get(position);//mostrar o titulo do filme com a position do elemento na lista
                                Toast.makeText(
                                        getApplicationContext(),
                                        "Item precionado: "+ filme.getTitoloFilme(),
                                        Toast.LENGTH_SHORT
                                ).show();
                            }

                            @Override
                            public void onLongItemClick(View view, int position) {
                                Filme filme = listaFilmes.get(position);
                                Toast.makeText(
                                        getApplicationContext(),
                                        "Click Longo: " + filme.getTitoloFilme(),
                                        Toast.LENGTH_SHORT
                                ).show();
                            }

                            @Override
                            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                            }
                        }
                )
        );
    }

public void criarFilmes(){
        Filme filme = new Filme("Homem Aranha - De volta ao lar", "Aventura", "2017");
        listaFilmes.add(filme);
        filme = new Filme("Mulher Maravilha", "Fantasia", "2017");
        listaFilmes.add(filme);
        filme = new Filme("Liga da Justiça", "Ficção", "2017");
        listaFilmes.add(filme);
        filme = new Filme("Capitão América - Guerra Civíl", "Aventura/Ficção", "2016");
        listaFilmes.add(filme);
        filme = new Filme("It: A Coisa", "Drama/Terror", "2017");
        listaFilmes.add(filme);
        filme = new Filme("Pica-Pau: O Filme", "Comédia/Animação", "2017");
        listaFilmes.add(filme);
        filme = new Filme("A Múmia", "Terror", "2017");
        listaFilmes.add(filme);
        filme = new Filme("A Bela e a Fera", "Romance", "2017");
        listaFilmes.add(filme);
        filme = new Filme("Meu malvado favorito 3", "Comédia", "2017");
        listaFilmes.add(filme);
        filme = new Filme("Carros 3", "Comédia", "2017");
        listaFilmes.add(filme);


}

}
