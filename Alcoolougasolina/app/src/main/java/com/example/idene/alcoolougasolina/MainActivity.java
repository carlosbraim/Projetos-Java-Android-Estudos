package com.example.idene.alcoolougasolina;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private EditText editPrecoAlcool;
    private EditText editPrecoGasolina;
    private TextView txtResultado;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editPrecoAlcool = findViewById(R.id.editPrecoAlcool);
        editPrecoGasolina = findViewById(R.id.editPrecoGasolina);
        txtResultado = findViewById(R.id.textResultado);
    }

    public void calcularPreco(View view){
        //recuperar os valores digitados
        String precoAlcool = editPrecoAlcool.getText().toString();
        String precoGasolina = editPrecoGasolina.getText().toString();
        //validar os campos
        Boolean camposValidados = this.validarcampos(precoAlcool,precoGasolina);
        if(camposValidados){
            this.calcularMelhorPreco(precoAlcool,precoGasolina);
        }else{
            txtResultado.setText("Preencha os preços primeiro!");
        }
    }
    public void calcularMelhorPreco(String pAlcool, String pGasolina){
        //converter valores Sting para numeros
        Double precoAlcool = Double.parseDouble(pAlcool);
        Double precoGasolina = Double.parseDouble(pGasolina);

        /*
        * Fazer calulo (pecoAlcoll/precoGasolina)
        * se resultado >= 0.7 melhor ultilizar gasolina
        * senao melhor ultilizar alcool*/
        Double resultado = (precoAlcool / precoGasolina);
        if(resultado>=0.7){
            txtResultado.setText("melhor ultilizar gasolina!");
        }else{
            txtResultado.setText("melhor ultilizar alcool!");
        }


    }
    public boolean validarcampos(String pAlcool, String pGasolina){
        Boolean camposValidados = true;

        //Validar campo
        if (pAlcool == null || pAlcool.equals("")){
            camposValidados = false;
        }else if(pGasolina == null || pGasolina.equals("")){
            camposValidados = false;
        }

        return camposValidados;
    }

}
