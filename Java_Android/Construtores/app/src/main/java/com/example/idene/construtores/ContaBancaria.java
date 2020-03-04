package com.example.idene.construtores;

public class ContaBancaria {
    private int numeroConta;
    private double saldo;
    //contrutor
    public ContaBancaria(){
     System.out.println("Configuracoes iniciais");
    }
    //Sobrecarga de construtor
    public ContaBancaria(int nConta){
        this.numeroConta = nConta;
        //System.out.println("Construtor chamado " + nConta);
    }
}
