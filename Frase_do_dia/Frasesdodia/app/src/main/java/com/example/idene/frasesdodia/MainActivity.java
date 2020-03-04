package com.example.idene.frasesdodia;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void gerarNovaFrase(View view){

        String [] frases = {
                "Querido Deus, Tu és minha proteção, a minha fortaleza. Tu és o meu Deus, eu confio em Ti. (Salmo 91:2)",
                "Deus sabe o que é bom para você. (Eclesiastes 6:12)",
                "Obrigado Senhor, pelo Seu maravilhoso amor. (Salmo 107:15)",
                "Ensina-me, Senhor, o Teu caminho, e andarei na Tua verdade; une o meu coração ao temor do Teu nome. (Salmo 86:11)",
                "Ele morreu por nós para que, quer estejamos acordados quer dormindo, vivamos unidos a ele.\n" +
                        "1 Tessalonicenses 5:10",
                "Das alturas, o Eterno enxerga as profundezas. Não importa a distância, Ele sabe tudo sobre nós. (Salmo 138:6)",
                "O meu amado é meu, e eu sou dele! (Cânticos 2:16)",
                " Ainda que eu falasse as línguas dos homens e dos anjos, e não tivesse amor, seria como o metal que soa ou como o sino que tine. (1 Coríntios 13:1)\n" +
                        "\n" + "Ainda que eu falasse as línguas dos homens e dos anjos, e não tivesse amor, seria como o metal que soa ou como o sino que tine. (1 Coríntios 13:1)"
        };
        int numero = new Random().nextInt(frases.length);//length tamanho do array

        TextView texto = (TextView) findViewById(R.id.text_resultado);

        texto.setText(frases[numero]);


    }
}
