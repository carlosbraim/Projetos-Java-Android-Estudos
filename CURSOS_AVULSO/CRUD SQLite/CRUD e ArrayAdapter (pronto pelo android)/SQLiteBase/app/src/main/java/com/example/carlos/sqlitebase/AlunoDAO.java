package com.example.carlos.sqlitebase;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;
import java.util.List;

public class AlunoDAO { //Data Access Object

    private Conexao conexao;
    private SQLiteDatabase banco;


    public AlunoDAO(Context context){
        conexao = new Conexao(context);
        banco = conexao.getWritableDatabase();
    }

    public long inserir(Aluno aluno){
        ContentValues values = new ContentValues();
        values.put("nome", aluno.getNome());//primeiro parametro que e a key esta associado com a coluna nome no banco de dados
        values.put("cpf", aluno.getCpf());
        values.put("telefone", aluno.getTelefone());
        return banco.insert("aluno",null,values); //tabela aluno, nao vai ter coluna vazia, e os valores values/ retorno um id
    }

    public List<Aluno> obterTodos(){
        List<Aluno> alunos = new ArrayList<>();
        Cursor cursor = banco.query("aluno", new String[]{"id", "nome", "cpf","telefone"},
                null, null,null,null,null);
        while (cursor.moveToNext()){//verificar se consigo mover para o proximo
            Aluno a = new Aluno();
            a.setId(cursor.getInt(0));
            a.setNome(cursor.getString(1));
            a.setCpf(cursor.getString(2));
            a.setTelefone(cursor.getString(3));
            alunos.add(a);
        }
        return alunos;
    }

    public void excluir(Aluno a){
        banco.delete("aluno","id = ?",new String[]{a.getId().toString()});//no lugar da ? ele coloca o id aluno
    }

    public void atualizar(Aluno aluno){
        ContentValues values = new ContentValues();
        values.put("nome", aluno.getNome());//primeiro parametro que e a key esta associado com a coluna nome no banco de dados
        values.put("cpf", aluno.getCpf());
        values.put("telefone", aluno.getTelefone());
        banco.update("aluno", values,
                "id = ?", new String[]{aluno.getId().toString()});
    }

}
