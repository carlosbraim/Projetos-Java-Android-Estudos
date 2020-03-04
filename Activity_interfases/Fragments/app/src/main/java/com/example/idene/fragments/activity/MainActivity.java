package com.example.idene.fragments.activity;

import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.idene.fragments.R;
import com.example.idene.fragments.fragment.ContatosFragment;
import com.example.idene.fragments.fragment.ConversasFragment;

public class MainActivity extends AppCompatActivity {

    private Button buttonConversa,buttonContato;
    private ConversasFragment conversasFragment;
    private ContatosFragment contatosFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        buttonConversa = findViewById(R.id.buttonConversa);
        buttonContato = findViewById(R.id.buttonContato);

        //Remover a sombra da ActionBar
        getSupportActionBar().setElevation(0);

        //instancia do fragmento
        conversasFragment = new ConversasFragment();

        //configurar objeto para o fragmento
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        transaction.replace(R.id.frameConteudo,conversasFragment);//transaction.add(R.id.frameConteudo,conversasFragment); escreve por cima usando o add
        transaction.commit();//fim

        buttonContato.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                //instancia do fragmento
                ContatosFragment contatosFragment = new ContatosFragment();

                FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
                transaction.replace(R.id.frameConteudo,contatosFragment);
                transaction.commit();//fim
            }
        });

        buttonConversa.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //instancia do fragmento
                ConversasFragment conversasFragment = new ConversasFragment();

                FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
                transaction.replace(R.id.frameConteudo,conversasFragment);
                transaction.commit();//fim
            }
        });

    }
}
