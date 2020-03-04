package com.example.idene.passandodadosactivites;

import java.io.Serializable;

public class Usuario implements Serializable { //transforma em bits o objeto para ser transportados entres as activitys
    private  String nome, email;

    public Usuario(String nome, String email) {
        this.nome = nome;
        this.email = email;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
