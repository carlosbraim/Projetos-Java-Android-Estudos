package com.example.idene.heranca;

 class Conta {

    private int numeroConta;
    private double saldo = 100;


    public double recuperarSaldo(){
        return this.saldo;
    }

    public void depositar (double valorDepositado){
        this.saldo = this.saldo + valorDepositado;
    }

    public void sacar (double valorSaque){
        this.saldo = this.saldo - valorSaque;
    }
}
