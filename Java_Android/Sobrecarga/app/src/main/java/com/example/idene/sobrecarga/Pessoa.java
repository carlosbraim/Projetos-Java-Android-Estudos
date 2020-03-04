package com.example.idene.sobrecarga;

public class Pessoa {
    private String nome;
    private int idade;

    public  void exibirDados(String nome){
        System.out.println("Exiber apenas nome: " + nome);
    }

    public void exibirDados(String nome, int idade){
        System.out.println("nome: " + nome +" idade: " + idade);
    }
}
