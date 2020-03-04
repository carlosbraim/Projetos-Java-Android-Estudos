package com.example.idene.listview;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private ListView listaLocais;
    private String[] itens ={
        "BELO HORIZONTE","CONTAGEM","BETIM","BELO Vale",
            "RIBEIRÃO DAS NEVES","SANTA LUZIA","BELO HORIZONTE","BELO HORIZONTE",
            "BELO HORIZONTE","BELO HORIZONTE","BELO HORIZONTE","BELO HORIZONTE",
            "BELO HORIZONTE","BELO HORIZONTE","BELO HORIZONTE"
    };
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        listaLocais = findViewById(R.id.listLocais);

        //Criar adaptador para a lista
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(
                getApplicationContext(),
                android.R.layout.simple_list_item_1,//layout pronto do google
                android.R.id.text1,//lugar onde vou imprir os itens
                itens
        );

        //Adicionar adaptador para a lista
        listaLocais.setAdapter(adapter);

        //Adicionar clique na lista
        listaLocais.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String valorSelecionado = listaLocais.getItemAtPosition(position).toString();
                Toast.makeText(getApplicationContext(),valorSelecionado,Toast.LENGTH_LONG).show();
            }
        });
    }
}
