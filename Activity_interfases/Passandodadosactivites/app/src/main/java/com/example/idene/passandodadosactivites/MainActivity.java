package com.example.idene.passandodadosactivites;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    private Button buttonEnviar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        buttonEnviar = findViewById(R.id.buttonEnviar);

        buttonEnviar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(),SegundaActivity.class);

                //instanciar o objeto
                Usuario usuario = new Usuario("carlos","carlos@gmail.com");



                //Passar dados
                intent.putExtra("nome","Carlos");
                intent.putExtra("idade",22);
                intent.putExtra("objeto",usuario);

                startActivity(intent);
            }
        });
    }
}
