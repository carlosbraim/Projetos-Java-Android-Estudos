package com.example.idene.heranca;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;


public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);



        Conta conta = new Conta();
        conta.depositar(100);
        conta.sacar(50);
       // System.out.println(conta.saldo);
        System.out.println(conta.recuperarSaldo());





        //Cao cao = new Cao();
       // cao.dormir();
       // cao.latir();
       // cao.setCor("Preto");
       // System.out.println(cao.getCor());
      //  cao.correr();


      /* Animal animal = new Animal();
        animal.correr();*/

    }
}
