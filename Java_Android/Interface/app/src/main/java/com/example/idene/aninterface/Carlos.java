package com.example.idene.aninterface;

public class Carlos extends Cidadao implements Presidente {

    @Override
    public void ganharEleicao() {
        System.out.println("ganhar uma eleicao no Brasil");
    }
}
