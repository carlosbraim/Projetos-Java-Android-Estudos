package com.example.carlos.sqlitebase;

import java.io.Serializable;

public class Aluno implements Serializable {

    private Integer id;
    private String nome;
    private String cpf;
    private String telefone;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    //quando um aluno for convertido para string sera mostrado so onome do aluno
    //pois o ArrayAdapter pode mostrar tudo misturado
    @Override
    public String toString(){
        return nome;
    }
}
