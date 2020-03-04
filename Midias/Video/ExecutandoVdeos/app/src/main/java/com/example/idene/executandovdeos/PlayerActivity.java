package com.example.idene.executandovdeos;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.MediaController;
import android.widget.VideoView;

public class PlayerActivity extends AppCompatActivity {
    private VideoView videoView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_player);

        videoView = findViewById(R.id.videoView);

        //Esconder a statusBar e a barra de navegação
        View decorView = getWindow().getDecorView();
        int uiOpcoes = View.SYSTEM_UI_FLAG_FULLSCREEN;
        decorView.setSystemUiVisibility(uiOpcoes);

        //Esconder a ActionBar
        getSupportActionBar().hide();

        //Executar o video
        videoView.setMediaController(new MediaController(this));//ja inicia com os controladores de videos padrões
        videoView.setVideoPath("android.resource://" + getPackageName() + "/" + R.raw.video);//setVideoPath() permite dizer o caminho do video/getPackageName recupera o nome do pacote
        videoView.start();

    }
}
