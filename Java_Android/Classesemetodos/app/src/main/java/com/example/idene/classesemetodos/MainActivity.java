package com.example.idene.classesemetodos;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Funcionario funcionario = new Funcionario();
        funcionario.nome = "Carlos";
        funcionario.salario = 920;

        //funcionario.recuperarSalario();
        double salarioRecuperado = funcionario.recuperarSalario(120,20);
        System.out.println("O salario do %s é " + salarioRecuperado );


        /*
        Casa minhaCasa = new Casa();
        minhaCasa.cor = "Azul";

        Casa minhaCasa2 = new Casa();
        minhaCasa2.cor = "Brnco";

        System.out.println(minhaCasa.cor);
        minhaCasa.abrirPorta();*/


    }
}
