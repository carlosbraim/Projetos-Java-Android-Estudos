package com.example.idene.recyclerview.activity.model;

public class Filme {
    private String titoloFilme,genero,ano;
    public Filme(){

    }

    public Filme(String titoloFilme, String genero, String ano) {
        this.titoloFilme = titoloFilme;
        this.genero = genero;
        this.ano = ano;
    }

    public String getTitoloFilme() {
        return titoloFilme;
    }

    public void setTitoloFilme(String titoloFilme) {
        this.titoloFilme = titoloFilme;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public String getAno() {
        return ano;
    }

    public void setAno(String ano) {
        this.ano = ano;
    }
}
