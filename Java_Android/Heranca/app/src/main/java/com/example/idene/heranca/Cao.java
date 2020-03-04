package com.example.idene.heranca;

 class Cao extends Animal {
    void latir(){
        System.out.println("Latir como cao");
    }

    void correr(){
        super.correr();
        System.out.println("cao");
    }

}
