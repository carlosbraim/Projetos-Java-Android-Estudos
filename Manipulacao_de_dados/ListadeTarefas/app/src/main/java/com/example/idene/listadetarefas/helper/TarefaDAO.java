package com.example.idene.listadetarefas.helper;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

import com.example.idene.listadetarefas.model.Tarefa;

import java.util.ArrayList;
import java.util.List;

public class TarefaDAO implements ITarefaDAO {

    private SQLiteDatabase escreve;//objeto para escrever na tabela
    private SQLiteDatabase le;//objeto para ler na tabela


    public TarefaDAO(Context context) {
        DbHelper db = new DbHelper(context);
        escreve = db.getWritableDatabase();//metodos prontos para escrever
        le = db.getReadableDatabase();//metodos prontos para ler
    }

    @Override
    public boolean salvar(Tarefa tarefa) {

        ContentValues cv = new ContentValues();//tipo array
        cv.put("nome",tarefa.getNomeTarefa());


        try {
            escreve.insert(DbHelper.TABELA_TAREFAS,null,cv);
            Log.i("INFO", "Tarefa salvar com sucesso");
        }catch (Exception e){
            Log.i("INFO", "Erro ao salvar a tarefa" + e.getMessage());
            return false;
        }

        return true;
    }

    @Override
    public boolean atualizar(Tarefa tarefa) {

        ContentValues cv = new ContentValues();
        cv.put("nome",tarefa.getNomeTarefa());

        try {
            String[] args = {tarefa.getId().toString()};//vetor de id dinamico
            escreve.update(DbHelper.TABELA_TAREFAS, cv,"id=?",args);//? é um curinga que e substituido pelo proximo valor coso seja mais de um parametro usase mais ?
            Log.i("INFO", "Tarefa atualizada com sucesso");
        }catch (Exception e){
            Log.i("INFO", "Erro ao atualizar a tarefa" + e.getMessage());
            return false;
        }

        return true;
    }

    @Override
    public boolean deletar(Tarefa tarefa) {

        try {
            String[] args = {tarefa.getId().toString()};
            escreve.delete(DbHelper.TABELA_TAREFAS,"id=?",args);
            Log.i("INFO", "Tarefa removida com sucesso");
        }catch (Exception e){
            Log.i("INFO", "Erro ao remover tarefa" + e.getMessage());
            return false;
        }

        return true;
    }

    @Override
    public List<Tarefa> listar() {

        List<Tarefa> tarefas = new ArrayList<>();

        String sql = "SELECT * FROM " + DbHelper.TABELA_TAREFAS + ";";
        Cursor c = le.rawQuery(sql,null);

        while (c.moveToNext()){

            Tarefa tarefa = new Tarefa();

            Long id = c.getLong(c.getColumnIndex("id"));
            String nomeTarefa = c.getString(c.getColumnIndex("nome"));

            tarefa.setId(id);
            tarefa.setNomeTarefa(nomeTarefa);

            //lista de tarefas atual
            tarefas.add(tarefa);

        }

        return tarefas;
    }
}
