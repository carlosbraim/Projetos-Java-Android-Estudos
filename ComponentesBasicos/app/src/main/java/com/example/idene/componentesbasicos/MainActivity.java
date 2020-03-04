package com.example.idene.componentesbasicos;

import android.support.design.widget.TextInputEditText;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.RadioGroup;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private TextInputEditText campoProduto;
    private TextView resultado;
    private CheckBox cbBranco, cbVerde, cbVermelho;
    List<String> check = new ArrayList<String>();
    private RadioGroup rgEstoque;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        campoProduto = findViewById(R.id.etNomeProduto);
        resultado = findViewById(R.id.tvResultado);

        cbBranco =findViewById(R.id.cbBranco);
        cbVerde =findViewById(R.id.cbVerde);
        cbVermelho =findViewById(R.id.cbVermelho);

        rgEstoque = findViewById(R.id.rgEstoque);

        verificarRadioButton();
    }
    public  void verificaCheck(){
        check.clear();
        if(cbBranco.isChecked()) {//retorna vdd ou false
            check.add(cbBranco.getText().toString());
        }
        if(cbVerde.isChecked()) {//retorna vdd ou false
            check.add(cbVerde.getText().toString());
        }
        if(cbVermelho.isChecked()) {//retorna vdd ou false
            check.add(cbVermelho.getText().toString());
        }

        resultado.setText( check.toString() );
    }
    public void verificarRadioButton(){
        rgEstoque.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                if(checkedId == R.id.rbSim){
                    resultado.setText("Sim");
                }else{
                    resultado.setText("Não");
                }
            }
        });//verificar se um item foi selecionado dentro do grupo
    }
    public void btEnviar(View view){
       // String nomeProduto = campoProduto.getText().toString();
       // resultado.setText(nomeProduto);

        //verificaCheck();


    }


}
