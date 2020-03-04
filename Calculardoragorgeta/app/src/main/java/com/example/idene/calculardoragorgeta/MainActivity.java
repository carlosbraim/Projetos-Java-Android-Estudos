package com.example.idene.calculardoragorgeta;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.SeekBar;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private EditText editValor;
    private TextView textPorcentagem;
    private TextView textGorgeta;
    private TextView textTotal;
    private SeekBar seekGorgeta;

    private double porcentagem = 0;//porcentagem inicial da gorjeta

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editValor = findViewById(R.id.editValor);
        textPorcentagem = findViewById(R.id.textPorcentagem);
        textGorgeta = findViewById(R.id.textGorgeta);
        textTotal = findViewById(R.id.textTotal);
        seekGorgeta = findViewById(R.id.seekGorgeta);

        //Contolar seekbar
        seekGorgeta.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                porcentagem = seekBar.getProgress();
                textPorcentagem.setText(Math.round(porcentagem) + "%");//Math.round(gorgeta) arredonda a gorgeta
                calcular();
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });
    }

    public void calcular(){
        //Recuperar valor digitado
        Double valorDigitado = Double.parseDouble(editValor.getText().toString());
        //calculo da gorgeta total
        double gorgeta = valorDigitado * (porcentagem/100);
        double total = gorgeta + valorDigitado;

        //exibir a gorgeta total
        textGorgeta.setText("R$ "+ Math.round(gorgeta) );//Math.round(gorgeta) arredonda a gorgeta
        textTotal.setText("R$ "+ total);
    }
}
