package com.example.idene.classesemetodos;

 class Funcionario {
     //propriedades
     String nome;
     double salario;

     //metodos
     /*void recuperarSalario(){
         this.salario = this.salario - (this.salario * 0.1);//retirar 10% do salario
         System.out.println(this.salario);
     }*/

     double recuperarSalario(double bonus, double descontoAdicional){
         this.salario = this.salario - (this.salario * 0.1);//retirar 10% do salario
         return this.salario + bonus - descontoAdicional;
     }
}
