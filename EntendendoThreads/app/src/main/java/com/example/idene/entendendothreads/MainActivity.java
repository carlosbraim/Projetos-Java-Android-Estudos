package com.example.idene.entendendothreads;

import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    private Button botaoIniciar;
    private int numero;
    private Handler handler = new Handler();//handler responsavel por enviar dados "codigo" executavel para as threads
    private boolean pararExecucao = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        botaoIniciar = findViewById(R.id.buttonIniciar);
    }

    public void iniciarThread(View view){
        /*
        //sobrecarregando thread principal

        for (int i = 0; i <= 15; i++){
            Log.d("Thread", "contador: " + i);
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }*/

       // MyThread thread = new MyThread();
        //thread.start();
        pararExecucao = false;
        MyRunnable runnable = new MyRunnable();//permite alterações antes da execução da thread
        new Thread( runnable ).start();

    }

    class MyRunnable implements Runnable{ // outra forma de implementar uma thread

        @Override
        public void run() {//execução direto sem tratamento
            for (int i = 0; i <= 15; i++) {

                if (pararExecucao)
                    return;//como a class e void ele so para a execucao

                numero = i;
                Log.d("Thread", "contador: " + i);
                //botaoIniciar.setText("contador: " + i); isso seria impossivel pq cod para modificar interface so funciona por meio da thread principal

                /*
                runOnUiThread(new Runnable() {//sobrescrever o metodo apartir de uma instancia runnable
                    @Override
                    public void run() {
                        botaoIniciar.setText("contador: " + numero);
                    }
                });*/

                //runOnUiThread e a mesma coisa pois o handler e extendido
                handler.post(new Runnable() { // responsavel por enviar dados pois estou usando o handler
                    @Override
                    public void run() {
                        botaoIniciar.setText("contador: " + numero);
                    }
                });

                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public void pararThread(View view){
        pararExecucao = true;
    }

    //inerclass classe interna
    class MyThread extends Thread { //thread não sera executada na thread principal

        @Override
        public void run() {
            for (int i = 0; i <= 15; i++) {
                Log.d("Thread", "contador: " + i);
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
