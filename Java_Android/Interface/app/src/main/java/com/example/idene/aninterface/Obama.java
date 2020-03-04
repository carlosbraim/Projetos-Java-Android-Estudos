package com.example.idene.aninterface;

public class Obama extends Cidadao implements Presidente{

    @Override
    public void ganharEleicao() {
        System.out.println("ganhar uma eleicao nos Estados Unidos");
    }
}
