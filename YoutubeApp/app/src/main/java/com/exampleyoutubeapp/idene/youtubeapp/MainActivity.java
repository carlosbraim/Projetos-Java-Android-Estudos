package com.exampleyoutubeapp.idene.youtubeapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import com.google.android.youtube.player.YouTubeBaseActivity;
import com.google.android.youtube.player.YouTubeInitializationResult;
import com.google.android.youtube.player.YouTubePlayer;
import com.google.android.youtube.player.YouTubePlayerView;

public class MainActivity extends YouTubeBaseActivity
            implements YouTubePlayer.OnInitializedListener {

    private YouTubePlayerView youTubePlayerView;
    private static final String GOOGLE_API_KEY = "AIzaSyBRLGGMLKhqRENXI17A2QjzdtiDC3VJqrY";

    private YouTubePlayer.PlaybackEventListener playbackEventListener;
    private YouTubePlayer.PlayerStateChangeListener playerStateChangeListener;//controlar as mudanças de estados


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        playerStateChangeListener = new YouTubePlayer.PlayerStateChangeListener() {
            @Override
            public void onLoading() {
                Toast.makeText(MainActivity.this,"Video carregando!", Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onLoaded(String s) {
                Toast.makeText(MainActivity.this,"Video carregado!", Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onAdStarted() {//comercial dentro do video
                Toast.makeText(MainActivity.this,"Comercial iniciou!", Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onVideoStarted() {
                Toast.makeText(MainActivity.this,"Video esta começando!", Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onVideoEnded() {
                Toast.makeText(MainActivity.this,"Video chegou ao final!", Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onError(YouTubePlayer.ErrorReason errorReason) {
                Toast.makeText(MainActivity.this,"Erre ao recuperar eventos de carregamento!", Toast.LENGTH_SHORT).show();
            }
        };

        //responsavel por contar os eventos
        playbackEventListener = new YouTubePlayer.PlaybackEventListener() {
            @Override
            public void onPlaying() {
                Toast.makeText(MainActivity.this,"Video executado com sucesso!", Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onPaused() {

                Toast.makeText(MainActivity.this,"Video Pausado!", Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onStopped() {

                Toast.makeText(MainActivity.this,"Video parado!", Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onBuffering(boolean b) { //quando o video esta carregando e da uma travadinha
                Toast.makeText(MainActivity.this,"Video pré-carregando!", Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onSeekTo(int i) {//saber em milisegundos para onde o usuario avançou
                Toast.makeText(MainActivity.this,"Movimentando a SeekBar!", Toast.LENGTH_SHORT).show();
            }
        };

        youTubePlayerView = findViewById(R.id.viewYoutubePlayer);
        youTubePlayerView.initialize(GOOGLE_API_KEY, this);
    }

    @Override
    public void onInitializationSuccess(YouTubePlayer.Provider provider, YouTubePlayer youTubePlayer, boolean foiRestaurado) {

        //Toast.makeText(this,"Player iniciado com sucesso!",Toast.LENGTH_SHORT).show();
        //youTubePlayer.loadVideo("qRXkEQOtQ98");//carrega o video automaticamente
        //Log.i("estado_player","estado: " + foiRestaurado);
        //youTubePlayer.setPlaybackEventListener( playbackEventListener ); //usado para contar eventos no video
        youTubePlayer.setPlayerStateChangeListener(playerStateChangeListener); //objeto player monitorando o video
        if ( !foiRestaurado ){
            //youTubePlayer.cueVideo("qRXkEQOtQ98");//aparece a opção do play para o usuario
            youTubePlayer.cuePlaylist("PLWz5rJ2EKKc8qKyqF60u6U8R6bErPgKrs");//play list
        }


    }

    @Override
    public void onInitializationFailure(YouTubePlayer.Provider provider, YouTubeInitializationResult youTubeInitializationResult) {

        Toast.makeText(this,"Erro ao iniciar o Player!" + youTubeInitializationResult.toString(), Toast.LENGTH_SHORT).show();


    }
}
