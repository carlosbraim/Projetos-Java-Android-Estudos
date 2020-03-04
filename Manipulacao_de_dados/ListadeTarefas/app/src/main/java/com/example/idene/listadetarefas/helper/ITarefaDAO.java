package com.example.idene.listadetarefas.helper;

import com.example.idene.listadetarefas.model.Tarefa;

import java.util.List;

public interface ITarefaDAO {//utilizado apenas para definir os 4 metodos que serão obrigatorios e ultilizado na TarefaDAO pois foi usado o implementes

    public  boolean salvar(Tarefa tarefa);
    public  boolean atualizar(Tarefa tarefa);
    public  boolean deletar(Tarefa tarefa);
    public List<Tarefa> listar();


}
