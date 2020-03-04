package com.example.idene.minhasanotaes;

import android.content.Context;
import android.content.SharedPreferences;

public class AnotacaoPreferencias {

    private Context context;
    private SharedPreferences preferences;
    private SharedPreferences.Editor editor;

    private final String NOME_ARQUIVO = "anotacao.preferencias";
    private final String CHAVE_NOME = "nome";


    //construtor responsavel por ultilizar o getSharedPreferences q esta implementado apenas no main
    public AnotacaoPreferencias(Context c) {
        this.context = c;
        preferences = context.getSharedPreferences("NOME_ARQUIVO",0);//recuperar valores da aplicacao
        editor = preferences.edit();//edita o valor
    }

    public  void  salvarAnotacao(String anotacao){
        editor.putString(CHAVE_NOME,anotacao);
        editor.commit();
    }

    public String recuperarAnotacao(){
        return preferences.getString(CHAVE_NOME,"");
    }

}
