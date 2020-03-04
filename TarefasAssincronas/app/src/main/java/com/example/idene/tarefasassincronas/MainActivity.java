package com.example.idene.tarefasassincronas;

import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private ProgressBar progressBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        progressBar = findViewById(R.id.progressBar);
    }

    public void iniciarAsyncTask(View view){

        MyAsyncTask task = new MyAsyncTask();
        task.execute(10);

    }

    /*
    * 1 -> Parâmetro a ser passado para a classe / void
    * 2 -> Tipo de valor que será utilizado para
    * o progresso da tarefa
    * 3 -> Retorno após tarefa finalizada
     */
    //class interna
    class MyAsyncTask extends AsyncTask<Integer, Integer, String>{

        //add apenas configuraçoes inicias pois processamento mais pesado deve ser executado no doInBackground
        @Override
        protected void onPreExecute() {
            super.onPreExecute();
            progressBar.setVisibility(View.VISIBLE);
        }

        //executa em um contexto de uma nova thread que vai ser criada em uma AsyncTask
        @Override
        protected String doInBackground(Integer... integers) {

            int numero = integers[0];
            for(int i=0; i<numero; i++){
                publishProgress(i);//passar um valor para a outra thread
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

            }

            return "Finalizado";
        }

        //executa durante a secução do doInBackground
        @Override
        protected void onProgressUpdate(Integer... values) {
            super.onProgressUpdate(values);
            progressBar.setProgress( values[0] );
        }

        @Override
        protected void onPostExecute(String s) {
            super.onPostExecute(s);
            Toast.makeText(MainActivity.this,
                    s, Toast.LENGTH_SHORT).show();

            progressBar.setProgress(0);
            progressBar.setVisibility(View.INVISIBLE);
        }




    }

}
