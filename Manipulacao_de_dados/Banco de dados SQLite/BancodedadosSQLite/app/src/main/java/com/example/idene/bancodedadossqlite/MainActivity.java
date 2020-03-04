package com.example.idene.bancodedadossqlite;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        try {
            //Criar banco de dados
            SQLiteDatabase bancoDados = openOrCreateDatabase("app", MODE_PRIVATE,null);

            //Apagar dados
            //bancoDados.execSQL("DROP TABLE pessoas "); // apagar a tabela toda
            //bancoDados.execSQL("DELETE FROM pessoas WHERE id = 1");//apagar a linha toda referente ao id
            bancoDados.execSQL("DELETE FROM pessoas");//apagar todos os registro de pessoas

            //Criar tabela
            //bancoDados.execSQL("CREATE TABLE IF NOT EXISTS pessoas( nome VARCHAR, idade INT(3))");
            bancoDados.execSQL("CREATE TABLE IF NOT EXISTS pessoas( id INTEGER PRIMARY KEY AUTOINCREMENT, nome VARCHAR, idade INT(3))");//com chaveprimaria

            //Inserir dados]
            //bancoDados.execSQL("INSERT INTO pessoas(nome,idade) VALUES ('Marina',2)");
            //bancoDados.execSQL("INSERT INTO pessoas(nome,idade) VALUES ('Paula',40)");
          //  bancoDados.execSQL("INSERT INTO pessoas(nome,idade) VALUES ('Paula',40)");
         //   bancoDados.execSQL("INSERT INTO pessoas(nome,idade) VALUES ('Carlos',22)");

            //Atualizar
           // bancoDados.execSQL("UPDATE pessoas SET idade = 25 WHERE nome = 'Carlos'");
            bancoDados.execSQL("UPDATE pessoas SET idade = 22 WHERE id = 2");

            //Recuperar pessoas
            /*String consulta =
                    "SELECT nome,idade FROM pessoas " +
                    "WHERE nome = 'Carlos' AND idade = 22"; */
            /*String consulta =
                    "SELECT nome,idade FROM pessoas " +
                            "WHERE idade >= 22 OR idade = 18"; */
           /* String consulta =
                    "SELECT nome,idade FROM pessoas " +
                            //"WHERE idade IN(1,23)";//IN é igual dentro
                            "WHERE nome IN('Carlos','Paula')";//IN é igual dentro*/

           /*String consulta =
                   "SELECT nome,idade FROM pessoas " +
                   "WHERE idade BETWEEN 1 AND 32"; */

            /*String consulta =
                    "SELECT nome,idade FROM pessoas " +
                    "WHERE nome LIKE 'Carlos'";//"como" usado mais em pesquisa pode ser usado assim "WHERE nome LIKE 'Car%'";// encontrando pessoas q inicia com Car ou colocar antes*/
           /* String filtro = "Car";
            String consulta =
                   "SELECT nome,idade FROM pessoas " +
                   "WHERE nome LIKE '% " + filtro +"%'"; */
           /* String consulta =
                    "SELECT nome,idade FROM pessoas " +
                            "WHERE 1=1 ORDER BY idade ASC LIMIT 2 "; // ordenar por, ASC do menor para o maior, DESC do maior para o menor,*/
            /*String consulta =
                    "SELECT id,nome,idade FROM pessoas " +
                            "WHERE 1=1 ORDER BY idade "; */
            String consulta =
                    "SELECT * FROM pessoas " +//* sao todos os campos da consulta
                            "WHERE 1=1 ORDER BY idade ";


            Cursor cursor = bancoDados.rawQuery(consulta,null);

            //Recuperar o indices da tabela
            int indiceId = cursor.getColumnIndex("id");
            int indiceNome = cursor.getColumnIndex("nome");
            int indiceIdade = cursor.getColumnIndex("idade");

            cursor.moveToFirst();//voltar para o primeiro item da lista

            while (cursor != null){

                String id = cursor.getString(indiceId);
                String nome = cursor.getString(indiceNome);
                String idade = cursor.getString(indiceIdade);

                //Log.i("RESULTADO - nome",cursor.getString(indiceNome);//para ver os dados no log
                //Log.i("RESULTADO - idade",cursor.getString(indiceIdade);
                Log.i("RESULTADO - id ", id + " nome: "+ nome + " idade: " + idade);
                cursor.moveToNext();//mover para o proximo item
            }

        }catch (Exception e){//caso de algum erro o sistema mostra um mensagem no log
            e.printStackTrace();
        }


    }
}
