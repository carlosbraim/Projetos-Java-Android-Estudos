package com.example.idene.componentesdeinterface2;

import android.content.DialogInterface;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.ToggleButton;

public class MainActivity extends AppCompatActivity {

    private ToggleButton toggleEstado;
    private Switch switchEstado;
    private CheckBox checkEstado;
    private TextView textResultado;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        toggleEstado = findViewById(R.id.toggleEstado);
        switchEstado = findViewById(R.id.switchEstado);
        checkEstado = findViewById(R.id.checkEstado);
        textResultado = findViewById(R.id.textResultado);
    }

    public void enviar(View view){
        if(toggleEstado.isChecked()){
            textResultado.setText("Toggle ligado");
            //Alerta dialogo
            AlertDialog.Builder dialog = new AlertDialog.Builder(this);
            //titulo e mensagem
            dialog.setTitle("Ligou");
            dialog.setMessage("Mensagem");
            //Configurar o botão sim adicionando o onclick no sim
            dialog.setPositiveButton("sim", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    Toast.makeText(getApplicationContext(),"Botao sim escolhido",Toast.LENGTH_LONG).show();
                }
            });
            dialog.setNegativeButton("Não", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    Toast.makeText(getApplicationContext(),"Botao Não escolhido",Toast.LENGTH_LONG).show();
                }
            });

            //criar e exibir o AlertDialog
            dialog.create();
            dialog.show();

        }else{
            textResultado.setText("Toggle Desligado");
            Toast.makeText(getApplicationContext(),"Botao escolhido",Toast.LENGTH_LONG).show();
        }
    }
}
