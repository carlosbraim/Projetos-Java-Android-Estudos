package com.example.idene.atmconsultoria.activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.example.idene.atmconsultoria.R;

import mehdi.sakout.aboutpage.AboutPage;

public class SobreActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.activity_sobre); para add a biblioteca (implementation 'com.github.medyo:android-about-page:1.2.2') no build e depois os acessos ao app são automaticos
        String descricao="Atm é uma empresa que visa o bem estar dos clientes e fornecedores de maneira a garantir o melhor em sistemas integrados e direcionados em diversos locais e estabelecimentos .................\n+" +
                "Apimentar o seu conteúdo com algumas imagens incorporadas podem ser muito mais benéfico do que parece. Por exemplo, se você está explicando um processo complicado dentro de sua indústria, tire algumas fotos dele acontecendo em tempo real e inclua-as ao lado.......";
        View sobre = new AboutPage(this)
                .setImage(R.drawable.logo)
                .setDescription(descricao)
                .addGroup("Fale conosco")
                .addEmail("atmconsultoria@gmail.com","Envie um e-mail")
                .addWebsite("http://google.com.br/","Acesse nosso site")
                .addGroup("Acesse nossas redes sociais")
                .addFacebook("google","Facebook")
                .addTwitter("google","Twitter")
                .addYoutube("google","Youtube")
                .addPlayStore("com.google.android.apps.plus","PlayStore")
                .addGitHub("google","GitHub")
                .addInstagram("google","Instagram")
                .create();

        setContentView( sobre );
    }
}
