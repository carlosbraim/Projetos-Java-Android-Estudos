package com.example.idene.preferenciasdousuario;

import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private Button buttonSalvar;
    private EditText editNome;
    private TextView textResultado;
    private static final String ARQUIVO_PREFERENCIA = "ArquivoPreferencia";//criar um atributo constante


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        buttonSalvar = findViewById(R.id.buttonSalvar);
        editNome = findViewById(R.id.editNome);
        textResultado = findViewById(R.id.textResultado);

        buttonSalvar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                SharedPreferences preferences = getSharedPreferences(ARQUIVO_PREFERENCIA,0);//0 é modo privado, so o app vai ler e editar o arquivo
                SharedPreferences.Editor editor = preferences.edit();//editar o arquivo de preferencia

                //validar o nome
                if (editNome.getText().toString().equals("")){
                    Toast.makeText(getApplicationContext(),"Preencha o nome", Toast.LENGTH_LONG).show();
                }else{

                    String nome = editNome.getText().toString();
                    editor.putString("nome",nome);
                    editor.commit();//dado salvo

                    textResultado.setText("Olá, " + nome);
                }
            }
        });
        //Recuperar dados
        SharedPreferences preferences = getSharedPreferences(ARQUIVO_PREFERENCIA,0);
        //validar se temos o nome em preferencias
        if (preferences.contains("nome")){
            String nome = preferences.getString("nome","usuário não definido");
            textResultado.setText("Olá, " + nome);

        }else{
            textResultado.setText("Olá, usuário não definido");
        }

    }
}
