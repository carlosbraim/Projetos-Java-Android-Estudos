package com.example.idene.pedrapapeloutesoura;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    }

    public void selecionarPedra(View view){
        this.opcaoSelecionada("pedra");

    }

    public void selecionarPapel(View view){
        this.opcaoSelecionada("papel");
    }

    public void selecionarTesoura(View view){
        this.opcaoSelecionada("tesoura");
    }

    public void opcaoSelecionada(String escolhaUsuario){

        ImageView imageResultado = (ImageView) findViewById(R.id.imageResultado);
        TextView textResultado = (TextView) findViewById(R.id.textResultado);

        String[] opcoes = {"pedra","papel","tesoura"};
        int numero = new Random().nextInt(3);
        String ecolhaApp = opcoes[numero];

        switch (ecolhaApp){
            case "pedra" :
                imageResultado.setImageResource(R.drawable.pedra);
                break;
            case "papel" :
                imageResultado.setImageResource(R.drawable.papel);
                break;
            case "tesoura" :
                imageResultado.setImageResource(R.drawable.tesoura);
                break;
        }

        if((ecolhaApp=="pedra" && escolhaUsuario =="tesoura")||
                (ecolhaApp=="papel" && escolhaUsuario =="pedra")||
                (ecolhaApp=="tesoura" && escolhaUsuario =="papel")){//app ganhador
            textResultado.setText("Voce perdeu :( ");
        }else if((escolhaUsuario=="pedra" && ecolhaApp =="tesoura")||
                (escolhaUsuario=="papel" && ecolhaApp =="pedra")||
                (escolhaUsuario=="tesoura" && ecolhaApp =="papel")){//usuario ganhador
            textResultado.setText("Voce Ganhou :) ");
        }else{//empate
            textResultado.setText("Empatamos ;) ");
        }
    }

}
